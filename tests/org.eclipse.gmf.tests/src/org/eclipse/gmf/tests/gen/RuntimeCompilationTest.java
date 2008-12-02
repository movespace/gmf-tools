/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction;
import org.eclipse.gmf.codegen.gmfgen.CustomParser;
import org.eclipse.gmf.codegen.gmfgen.DynamicModelAccess;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenCommandAction;
import org.eclipse.gmf.codegen.gmfgen.GenContextMenu;
import org.eclipse.gmf.codegen.gmfgen.GenCustomAction;
import org.eclipse.gmf.codegen.gmfgen.GenCustomPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenGroupMarker;
import org.eclipse.gmf.codegen.gmfgen.GenMenuManager;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenPreference;
import org.eclipse.gmf.codegen.gmfgen.GenStandardPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.LoadResourceAction;
import org.eclipse.gmf.codegen.gmfgen.StandardPreferencePages;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * @author dstadnik
 */
public class RuntimeCompilationTest extends CompilationTest {

	public RuntimeCompilationTest(String name) {
		super(name, new RuntimeBasedGeneratorConfiguration(), new InnerClassViewmapProducer());
	}

	/**
	 * Pure design diagrams are not supported in lite version.
	 */
	public void testCompilePureDesignDiagram() throws Exception {
		myMapSource.detachFromDomainModel();
		DiaGenSource gmfGenSource = createLibraryGen(false);
		gmfGenSource.getGenDiagram().getEditorGen().setPackageNamePrefix("org.eclipse.gmf.examples.library.diagram"); //$NON-NLS-1$
		generateAndCompile(gmfGenSource);
	}

	public void testCompileDynamicDomainModel() throws Exception {
		DiaGenSource s = createLibraryGen(false);
		final GenEditorGenerator editorGen = s.getGenDiagram().getEditorGen();
		assertNull("prereq", editorGen.getModelAccess());
		DynamicModelAccess dma = GMFGenFactory.eINSTANCE.createDynamicModelAccess();
		editorGen.setModelAccess(dma);
		generateAndCompile(s, new GenDiagramMutator("dynmodel") {
			@Override
			public void doMutation(GenDiagram d) {
				final DynamicModelAccess modelAccess = d.getEditorGen().getModelAccess();
				modelAccess.setClassName("NonDefaultDynamicAccessorName");
			}
			@Override
			public void undoMutation(GenDiagram d) {
				final DynamicModelAccess modelAccess = d.getEditorGen().getModelAccess();
				modelAccess.setClassName(null);
			}
		});
	}

	public void testPreferencePages() throws Exception {
		DiaGenSource s = createLibraryGen(false);
		final GenDiagram gd = s.getGenDiagram();
		// Part 1: compile all standard
		GenStandardPreferencePage[] p = new GenStandardPreferencePage[StandardPreferencePages.values().length];
		assertTrue("sanity", p.length > 5);
		for (int i = 0; i < p.length; i++) {
			p[i] = GMFGenFactory.eINSTANCE.createGenStandardPreferencePage();
			p[i].setClassName("Page" + i);
			p[i].setKind(StandardPreferencePages.values()[i]);
			if (i > 0) {
				p[i-1].getChildren().add(p[i]);
			}
		}
		gd.getPreferencePages().clear();
		gd.getPreferencePages().add(p[0]);
		generateAndCompile(s);
		GenPlugin gp = gd.getEditorGen().getPlugin();
		IProject generatedProject = ResourcesPlugin.getWorkspace().getRoot().getProject(gp.getID());
		IFile generatedManifest = generatedProject.getFile("plugin.xml");
		assertTrue(generatedManifest.exists());
		XPathFactory xf = XPathFactory.newInstance();
		XPathExpression xe = xf.newXPath().compile("/plugin/extension[@point = 'org.eclipse.ui.preferencePages']/page");
		NodeList result = (NodeList) xe.evaluate(new InputSource(generatedManifest.getContents()), XPathConstants.NODESET);
		assertEquals(p.length, result.getLength());
		//
		// Part 2: generateBoilerplate and subset of pages
		gp.setID(gp.getID() + ".boilerplateprefpage");
		gd.getPreferencePages().clear();
		GenCustomPreferencePage cp1 = GMFGenFactory.eINSTANCE.createGenCustomPreferencePage();
		cp1.setQualifiedClassName(gd.getPreferencesPackageName() + ".CustomPageNoCodeGenerated");
		cp1.setGenerateBoilerplate(false);
		GenCustomPreferencePage cp2 = GMFGenFactory.eINSTANCE.createGenCustomPreferencePage();
		cp2.setQualifiedClassName(gd.getPreferencesPackageName() + ".CustomPageWithBoilerplateCode");
		cp2.setGenerateBoilerplate(true);
		GenStandardPreferencePage onePage = GMFGenFactory.eINSTANCE.createGenStandardPreferencePage();
		onePage.setKind(StandardPreferencePages.CONNECTIONS_LITERAL);
		onePage.getChildren().add(cp1);
		onePage.getChildren().add(cp2);
		gd.getPreferencePages().add(onePage);
		generateAndCompile(s);
		generatedProject = ResourcesPlugin.getWorkspace().getRoot().getProject(gp.getID());
		generatedManifest = generatedProject.getFile("plugin.xml");
		assertTrue(generatedManifest.exists());
		// check all three have been registered
		result = (NodeList) xe.evaluate(new InputSource(generatedManifest.getContents()), XPathConstants.NODESET);
		assertEquals(3, result.getLength());
		HashSet<String> names = new HashSet<String>();
		names.add(onePage.getQualifiedClassName());
		names.add(cp1.getQualifiedClassName());
		names.add(cp2.getQualifiedClassName());
		assertTrue("sanity", names.size() == 3);
		for (int i = 0; i < result.getLength(); i++) {
			String className = result.item(i).getAttributes().getNamedItem("class").getNodeValue();
			assertTrue(className, names.remove(className));
		}
		assertTrue(names.isEmpty());
		// check real files
		IFile file_sp = generatedProject.getFile("/src/" + onePage.getQualifiedClassName().replace('.', '/') + ".java");
		IFile file_cp1 = generatedProject.getFile("/src/" + cp1.getQualifiedClassName().replace('.', '/') + ".java");
		IFile file_cp2 = generatedProject.getFile("/src/" + cp2.getQualifiedClassName().replace('.', '/') + ".java");
		assertTrue(file_sp.exists());
		assertTrue(file_cp2.exists());
		assertFalse(file_cp1.exists());
	}

	public void testCustomActions() throws Exception {
		DiaGenSource s = createLibraryGen(false);
		final GenEditorGenerator editorGen = s.getGenDiagram().getEditorGen();
		GenContextMenu menu = GMFGenFactory.eINSTANCE.createGenContextMenu();
		GenCustomAction a1 = GMFGenFactory.eINSTANCE.createGenCustomAction();
		GenCustomAction a2 = GMFGenFactory.eINSTANCE.createGenCustomAction();
		GenCustomAction a3 = GMFGenFactory.eINSTANCE.createGenCustomAction();
		a1.setGenerateBoilerplate(false);
		a2.setGenerateBoilerplate(true);
		a3.setGenerateBoilerplate(true);
		a1.setQualifiedClassName("org.sample.actions.Action1");
		a2.setQualifiedClassName("org.sample.actions.Action2");
		a3.setQualifiedClassName("org.sample.actions.Action3");
		a1.setName("testaction-1");
		a2.setName("testaction-2");
		a3.setName("testaction-3");
		GenMenuManager subMenu = GMFGenFactory.eINSTANCE.createGenMenuManager();
		subMenu.setID("org.sample.submenu");
		GenGroupMarker gm = GMFGenFactory.eINSTANCE.createGenGroupMarker();
		gm.setGroupName("group.name");
		GenCommandAction cmdAction = GMFGenFactory.eINSTANCE.createGenCommandAction();
		cmdAction.setCommandIdentifier("org.sample.command");
		subMenu.getItems().add(a3);
		subMenu.getItems().add(gm);
		subMenu.getItems().add(cmdAction);
		menu.getItems().add(a1);
		menu.getItems().add(GMFGenFactory.eINSTANCE.createGenSeparator());
		menu.getItems().add(a2);
		menu.getItems().add(subMenu);
		editorGen.getContextMenus().clear(); // make sure there's no other (default) menus
		editorGen.getContextMenus().add(menu);
		//
		generateAndCompile(s);
		//
		IProject generatedProject = ResourcesPlugin.getWorkspace().getRoot().getProject(editorGen.getPlugin().getID());
		IFile generatedManifest = generatedProject.getFile("plugin.xml");
		assertTrue(generatedManifest.exists());
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document parsedManifest = db.parse(new InputSource(generatedManifest.getContents()));
		XPath xf = XPathFactory.newInstance().newXPath();
		XPathExpression xe = xf.compile("/plugin/extension[@point = 'org.eclipse.ui.menus']/menuContribution");
		NodeList result = (NodeList) xe.evaluate(parsedManifest, XPathConstants.NODESET);
		assertEquals(2, result.getLength()); // one contribution to global context menu and another for submenu
		String l1 = result.item(0).getAttributes().getNamedItem("locationURI").getNodeValue();
		String l2 = result.item(1).getAttributes().getNamedItem("locationURI").getNodeValue();
		assertEquals(l1, "popup:org.eclipse.gmf.runtime.diagram.ui.DiagramEditorContextMenu");
		assertEquals(l2, "popup:" + subMenu.getID());
		//
		xe = xf.compile("/plugin/extension[@point = 'org.eclipse.ui.menus']/menuContribution/menu");
		result = (NodeList) xe.evaluate(parsedManifest, XPathConstants.NODESET);
		assertEquals(1, result.getLength());
		String menuIdAttr = result.item(0).getAttributes().getNamedItem("id").getNodeValue();
		assertEquals(subMenu.getID(), menuIdAttr);
		//
		xe = xf.compile("/plugin/extension[@point = 'org.eclipse.ui.menus']/menuContribution/command");
		result = (NodeList) xe.evaluate(parsedManifest, XPathConstants.NODESET);
		assertEquals(4, result.getLength());
		// FIXME assert command contribution goes into correct locationURI
		//
		xe = xf.compile("/plugin/extension[@point = 'org.eclipse.ui.menus']/menuContribution/separator");
		result = (NodeList) xe.evaluate(parsedManifest, XPathConstants.NODESET);
		assertEquals(2, result.getLength());
		//
		xe = xf.compile("/plugin/extension[@point = 'org.eclipse.ui.commands']/command[starts-with(@name,'testaction-')]");
		result = (NodeList) xe.evaluate(parsedManifest, XPathConstants.NODESET);
		assertEquals(3, result.getLength());
		// XXX perhaps, should use either defaultHandler or oe.ui.handlers extp contribution, not both? 
		String dh1 = result.item(0).getAttributes().getNamedItem("defaultHandler").getNodeValue();
		String dh2 = result.item(1).getAttributes().getNamedItem("defaultHandler").getNodeValue();
		String dh3 = result.item(2).getAttributes().getNamedItem("defaultHandler").getNodeValue();
		assertEquals(a1.getQualifiedClassName(), dh1); // ordering change might affect test result 
		assertEquals(a2.getQualifiedClassName(), dh2); 
		assertEquals(a3.getQualifiedClassName(), dh3); 
		//
		xe = xf.compile("/plugin/extension[@point = 'org.eclipse.ui.handlers']/handler");
		result = (NodeList) xe.evaluate(parsedManifest, XPathConstants.NODESET);
		assertEquals(2, result.getLength());
		String h1 = result.item(0).getAttributes().getNamedItem("class").getNodeValue();
		String h2 = result.item(1).getAttributes().getNamedItem("class").getNodeValue();
		assertEquals(a2.getQualifiedClassName(), h1);
		assertEquals(a3.getQualifiedClassName(), h2);

		// check real files for handlers
		IFile file_a1 = generatedProject.getFile("/src/" + a1.getQualifiedClassName().replace('.', '/') + ".java");
		IFile file_a2 = generatedProject.getFile("/src/" + a2.getQualifiedClassName().replace('.', '/') + ".java");
		IFile file_a3 = generatedProject.getFile("/src/" + a3.getQualifiedClassName().replace('.', '/') + ".java");
		assertFalse(file_a1.exists());
		assertTrue(file_a2.exists());
		assertTrue(file_a3.exists());
	}

	// CreateShortcut, LoadResource, InitDiagramFileAction 
	public void testPredefinedActions() throws Exception {
		DiaGenSource s1 = createLibraryGen(false);
		final GenEditorGenerator editorGen = s1.getGenDiagram().getEditorGen();
		GenContextMenu menu = GMFGenFactory.eINSTANCE.createGenContextMenu();
		menu.getContext().add(s1.getGenDiagram());
		final CreateShortcutAction createShortcutAction = GMFGenFactory.eINSTANCE.createCreateShortcutAction();
		final LoadResourceAction loadResourceAction = GMFGenFactory.eINSTANCE.createLoadResourceAction();
		menu.getItems().add(createShortcutAction);
		menu.getItems().add(loadResourceAction);
		editorGen.getContextMenus().clear(); // make sure there's no other (default) menus
		editorGen.getContextMenus().add(menu);
		editorGen.getDiagram().getContainsShortcutsTo().add("ecore");
		assertTrue("sanity", editorGen.getDiagram().generateCreateShortcutAction());
		//
		generateAndCompile(s1);
		//
		IProject generatedProject = ResourcesPlugin.getWorkspace().getRoot().getProject(editorGen.getPlugin().getID());
		IFile generatedManifest = generatedProject.getFile("plugin.xml");
		assertTrue(generatedManifest.exists());
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document parsedManifest = db.parse(new InputSource(generatedManifest.getContents()));
		XPath xf = XPathFactory.newInstance().newXPath();
		XPathExpression xe = xf.compile("/plugin/extension[@point = 'org.eclipse.ui.menus']/menuContribution/command");
		NodeList result = (NodeList) xe.evaluate(parsedManifest, XPathConstants.NODESET);
		assertEquals(2, result.getLength());
		xe = xf.compile("/plugin/extension[@point = 'org.eclipse.ui.commands']/command");
		result = (NodeList) xe.evaluate(parsedManifest, XPathConstants.NODESET);
		assertTrue(result.getLength() > 2);
		HashSet<String> allCommands = new HashSet<String>();
		for (int i = result.getLength() - 1; i >= 0; i--) {
			allCommands.add(result.item(i).getAttributes().getNamedItem("defaultHandler").getNodeValue());
		}
		assertTrue(allCommands.contains(createShortcutAction.getQualifiedClassName()));
		assertTrue(allCommands.contains(loadResourceAction.getQualifiedClassName()));
		IFile file1 = generatedProject.getFile("/src/" + createShortcutAction.getQualifiedClassName().replace('.', '/') + ".java");
		IFile file2 = generatedProject.getFile("/src/" + loadResourceAction.getQualifiedClassName().replace('.', '/') + ".java");
		assertTrue(file1.exists());
		assertTrue(file2.exists());
		//
//		DiaGenSource s2 = createLibraryGen(true);
//		fail("TODO");
	}

	public void testCustomPreferences() throws Exception {
		DiaGenSource s = createLibraryGen(false);
		final GenDiagram gd = s.getGenDiagram();
		GenCustomPreferencePage pp = GMFGenFactory.eINSTANCE.createGenCustomPreferencePage();
		if (gd.getPreferencePages().isEmpty()) {
			gd.getPreferencePages().add(pp);
		} else {
			gd.getPreferencePages().get(0).getChildren().add(pp);
		}
		pp.setGenerateBoilerplate(true);
		pp.setName("Page Name");
		pp.setQualifiedClassName(gd.getEditorGen().getEditor().getPackageName() + ".CustomPreferencePage");
		GenPreference p1 = GMFGenFactory.eINSTANCE.createGenPreference();
		p1.setName("PREF_XXX_ONE");
		p1.setDefaultValue("\"XXX_ONE_DEFAULT\"");
		GenPreference p2 = GMFGenFactory.eINSTANCE.createGenPreference();
		p2.setName("NO_PREFIX_XXX_TWO");
		p2.setKey("KEY.XXX.TWO");
		pp.getPreferences().add(p1);
		pp.getPreferences().add(p2);
		//
		generateAndCompile(s);
		//
		IProject generatedProject = ResourcesPlugin.getWorkspace().getRoot().getProject(gd.getEditorGen().getPlugin().getID());
		IFile file_pp = generatedProject.getFile("/src/" + pp.getQualifiedClassName().replace('.', '/') + ".java");
		assertTrue(file_pp.exists());
		ICompilationUnit cuPage = (ICompilationUnit) JavaCore.create(file_pp);
		assertNotNull(cuPage);
		IType mainClass = cuPage.getTypes()[0];
		assertNotNull(mainClass);
		assertEquals(2, mainClass.getFields().length);
		final IField p1field = mainClass.getField(p1.getName());
		final IField p2field = mainClass.getField(p2.getName());
		assertTrue(Flags.isPublic(p1field.getFlags()));
		assertTrue(Flags.isStatic(p1field.getFlags()));
		assertTrue(Flags.isPublic(p2field.getFlags()));
		assertTrue(Flags.isStatic(p2field.getFlags()));
		assertEquals('"' + p1.getKey() + '"', p1field.getConstant());
		assertEquals('"' + p2.getKey() + '"', p2field.getConstant());
		IMethod initMethod = mainClass.getMethod("initDefaults",  new String[] { "Q" + IPreferenceStore.class.getSimpleName() + ";" });
		assertNotNull(initMethod);
		String methodText = initMethod.getSource();
		assertTrue(methodText.indexOf(p1.getName()) != -1);
		assertTrue(methodText.indexOf(p1.getDefaultValue()) != -1);
		assertTrue(methodText.indexOf(p2.getName()) == -1);
	}

	// check CustomParser#isGenerateBoilerplate == true emits java class 
	public void testCustomParsers() throws Exception {
		DiaGenSource s = createLibraryGen(false);
		final GenEditorGenerator gd = s.getGenDiagram().getEditorGen();
		CustomParser cp1 = GMFGenFactory.eINSTANCE.createCustomParser();
		cp1.setQualifiedName(gd.getLabelParsers().getImplPackageName() + "CustomParserOne");
		CustomParser cp2 = GMFGenFactory.eINSTANCE.createCustomParser();
		cp2.setQualifiedName(gd.getLabelParsers().getImplPackageName() + "CustomParserTwo");
		cp2.setGenerateBoilerplate(true);
		gd.getLabelParsers().getImplementations().add(cp1);
		gd.getLabelParsers().getImplementations().add(cp2);
		//
		generateAndCompile(s);
		//
		IProject generatedProject = ResourcesPlugin.getWorkspace().getRoot().getProject(gd.getPlugin().getID());
		IFile file_cp1 = generatedProject.getFile("/src/" + cp1.getQualifiedName().replace('.', '/') + ".java");
		IFile file_cp2 = generatedProject.getFile("/src/" + cp2.getQualifiedName().replace('.', '/') + ".java");
		assertFalse(file_cp1.exists());
		assertTrue(file_cp2.exists());
	}
}
