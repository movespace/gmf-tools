package org.eclipse.gmf.codegen.templates.diacanvas;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class EditorGen
{
  protected static String nl;
  public static synchronized EditorGen create(String lineSeparator)
  {
    nl = lineSeparator;
    EditorGen result = new EditorGen();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "import java.io.IOException;" + NL + "import java.util.ArrayList;" + NL + "import java.util.EventObject;" + NL + "import java.util.Collections;" + NL + "import java.util.Iterator;" + NL + "import java.util.List;" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.draw2d.geometry.Dimension;" + NL + "import org.eclipse.emf.common.command.BasicCommandStack;" + NL + "import org.eclipse.emf.common.command.CommandStackListener;" + NL + "import org.eclipse.emf.common.notify.AdapterFactory;" + NL + "import org.eclipse.emf.common.util.URI;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL + "import org.eclipse.emf.ecore.resource.ResourceSet;" + NL + "import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;" + NL + "import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;" + NL + "import org.eclipse.emf.edit.provider.ComposedAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;" + NL + "import org.eclipse.jface.action.Action;" + NL + "import org.eclipse.jface.action.IMenuManager;" + NL + "import org.eclipse.jface.dialogs.MessageDialog;" + NL + "import org.eclipse.swt.SWT;" + NL + "import org.eclipse.swt.widgets.Display;" + NL + "import org.eclipse.ui.IEditorInput;" + NL + "import org.eclipse.ui.IEditorPart;" + NL + "import org.eclipse.ui.IFileEditorInput;" + NL + "import org.eclipse.ui.IWorkbenchPart;" + NL + "import org.eclipse.ui.actions.ActionFactory;" + NL + "import org.eclipse.ui.views.contentoutline.IContentOutlinePage;" + NL + "import org.eclipse.ui.views.properties.IPropertySheetPage;" + NL + "import org.eclipse.gef.*;" + NL + "import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;" + NL + "import org.eclipse.gef.palette.PaletteRoot;" + NL + "import org.eclipse.gef.ui.actions.*;" + NL + "import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;" + NL + "import org.eclipse.gef.ui.parts.*;" + NL + "import org.eclipse.gmf.diagramrt.DiagramCanvas;" + NL + "import org.eclipse.gmf.edit.provider.metainfo.AdapterFactoryMetaInfoSource;" + NL + "import org.eclipse.gmf.util.SelectionUnwrapProvider;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends GraphicalEditorWithFlyoutPalette {" + NL + "\t// XXX subclass or add adapter to myResourceSet to manage IEditingDomainProvider" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final ResourceSet myResourceSet = new ResourceSetImpl();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate DiagramCanvas myDiagram;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteRoot myPaletteRoot;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate AdapterFactory myDomainModelAdapterFactory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "() {" + NL + "\t\t// FIXME move to #init() - setEditDomain calls other methods of this class, so it's better to have construction complete" + NL + "\t\tsetEditDomain(new DefaultEditDomain(this));" + NL + "\t\tsetupDomainsEMFEdititngDomain();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void configureGraphicalViewer() {" + NL + "\t\tsuper.configureGraphicalViewer();" + NL + "" + NL + "\t\tGraphicalViewer viewer = getGraphicalViewer();" + NL + "\t\tviewer.setRootEditPart(new ScalableFreeformRootEditPart());" + NL + "\t\tviewer.setProperty(SnapToGrid.PROPERTY_GRID_SPACING, new Dimension(25, 25));" + NL + "\t\tviewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, Boolean.TRUE);" + NL + "\t\tviewer.setEditPartFactory(new ";
  protected final String TEXT_7 = "());" + NL + "\t\tContextMenuProvider contextMenu = new ContextMenuProvider(viewer) {" + NL + "\t\t\tpublic void buildContextMenu(IMenuManager menu) {" + NL + "\t\t\t\tGEFActionConstants.addStandardActionGroups(menu);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tviewer.setContextMenu(contextMenu);" + NL + "\t\tgetSite().registerContextMenu(contextMenu, new SelectionUnwrapProvider(viewer));" + NL + "\t\t// XXX registerContextMenu(\"anotherID\", contextMenu, viewer); - for actions that need editPart in selection?" + NL + "" + NL + "\t\t// XXX menu manager as part of genModel?" + NL + "" + NL + "\t\tKeyHandler keyHandler = new GraphicalViewerKeyHandler(viewer);" + NL + "\t\tkeyHandler.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry().getAction(GEFActionConstants.DIRECT_EDIT));" + NL + "\t\tkeyHandler.put(KeyStroke.getPressed(SWT.DEL, SWT.DEL, 0), getActionRegistry().getAction(ActionFactory.DELETE.getId()));" + NL + "\t\tviewer.setKeyHandler(keyHandler);" + NL + "" + NL + "\t\tviewer.setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.CTRL), MouseWheelZoomHandler.SINGLETON);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createActions() {" + NL + "\t\tsuper.createActions();" + NL + "" + NL + "\t\tAction action = new DirectEditAction((IWorkbenchPart)this);" + NL + "\t\tgetActionRegistry().registerAction(action);" + NL + "\t\tgetSelectionActions().add(action.getId());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected FlyoutPreferences getPalettePreferences() {" + NL + "\t\treturn new ";
  protected final String TEXT_8 = "(";
  protected final String TEXT_9 = ".getInstance().getPluginPreferences());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected PaletteRoot getPaletteRoot() {" + NL + "\t\tif (myPaletteRoot == null) {" + NL + "\t\t\tmyPaletteRoot = ";
  protected final String TEXT_10 = ".createPalette(getAdapterFactory4DomainModel());" + NL + "\t\t}" + NL + "\t\treturn myPaletteRoot;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class type) {" + NL + "\t\tif (type == IPropertySheetPage.class) {" + NL + "\t\t\t// placeholder" + NL + "\t\t} else if (type == IContentOutlinePage.class) {" + NL + "\t\t\t// another placeholder" + NL + "\t\t}" + NL + "\t\treturn super.getAdapter(type);" + NL + "\t}" + NL + "" + NL + "\t// TODO later..." + NL + "//\tprotected PaletteViewerProvider createPaletteViewerProvider() {" + NL + "//\t\treturn new PaletteViewerProvider(getEditDomain()) {" + NL + "//\t\t\tprotected void configurePaletteViewer(PaletteViewer viewer) {" + NL + "//\t\t\t\tsuper.configurePaletteViewer(viewer);" + NL + "//\t\t\t\tviewer.setCustomizer(new PaletteCustomizer()..." + NL + "//\t\t\t\t// to get Customize... action on palette " + NL + "//\t\t\t}" + NL + "//\t\t};" + NL + "//\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void initializeGraphicalViewer() {" + NL + "\t\tsuper.initializeGraphicalViewer();" + NL + "\t\tGraphicalViewer viewer = getGraphicalViewer();" + NL + "\t\tviewer.setContents(myDiagram);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setInput(IEditorInput input) {" + NL + "\t\tsuper.setInput(input);" + NL + "" + NL + "\t\tIFile file = ((IFileEditorInput)input).getFile();" + NL + "\t\tURI uri = URI.createURI(file.getFullPath().toString());" + NL + "\t\tResource resource = myResourceSet.getResource(uri, true);" + NL + "\t\tmyDiagram = (DiagramCanvas) resource.getContents().get(0);" + NL + "\t\tsetupDomainForDiagram(file);" + NL + "\t\tAdapterFactory metaInfoAdapterFactory = new ";
  protected final String TEXT_11 = "();" + NL + "\t\tmyDiagram.eAdapters().add(new AdapterFactoryMetaInfoSource(metaInfoAdapterFactory));" + NL + "" + NL + "\t\tsetPartName(file.getName());" + NL + "\t\tsetContentDescription(file.getFullPath().toString());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void doSave(IProgressMonitor monitor) {" + NL + "\t\ttry {" + NL + "\t\t\tfor (Iterator it = myResourceSet.getResources().iterator(); it.hasNext();) {" + NL + "\t\t\t\t((Resource) it.next()).save(Collections.EMPTY_MAP);" + NL + "\t\t\t}" + NL + "\t\t\tgetCommandStack().markSaveLocation();" + NL + "\t\t} catch (IOException ex) {" + NL + "\t\t\t// TODO handle exception" + NL + "\t\t\tex.printStackTrace();" + NL + "\t\t\tMessageDialog.openWarning(getGraphicalControl().getShell(), \"Errors Detected\", ex.getMessage());" + NL + "\t\t}" + NL + "\t}" + NL + "\tpublic void doSaveAs() {" + NL + "\t}" + NL + "\tpublic boolean isSaveAsAllowed() {" + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void commandStackChanged(EventObject event) {" + NL + "\t\tfirePropertyChange(PROP_DIRTY);" + NL + "\t\tsuper.commandStackChanged(event);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void setupDomainForDiagram(IFile file) {" + NL + "\t\tEObject domainContainer = myDiagram.getDomainContainerObject();";
  protected final String TEXT_12 = NL + "\t\tif (domainContainer == null || domainContainer.eClass() != ";
  protected final String TEXT_13 = ".eINSTANCE.get";
  protected final String TEXT_14 = "()) {" + NL + "\t\t\t// XXX limiting outselves to single container which itself has no containers" + NL + "\t\t\tdomainContainer = ";
  protected final String TEXT_15 = ".eINSTANCE.create";
  protected final String TEXT_16 = "();";
  protected final String TEXT_17 = NL + "\t\t\tResource domainRes = myDiagram.eResource();";
  protected final String TEXT_18 = NL + "\t\t\tURI domainResURI = URI.createURI(file.getFullPath().removeFileExtension().addFileExtension(\"";
  protected final String TEXT_19 = "\").toString());" + NL + "\t\t\tResource domainRes = myResourceSet.createResource(domainResURI);";
  protected final String TEXT_20 = NL + "\t\t\tdomainRes.getContents().add(domainContainer);" + NL + "\t\t\tmyDiagram.setDomainResource(domainRes);" + NL + "\t\t\tmyDiagram.setDomainContainerObject(domainContainer);" + NL + "\t\t} else {" + NL + "\t\t\t// XXX keeping domainResource in addition to domainContainerObject" + NL + "\t\t\t// for future - when we implement support for \"no dedicated domain container object\"" + NL + "\t\t\t// case, and created nodes go directly to the object" + NL + "\t\t\tmyDiagram.setDomainResource(domainContainer.eResource());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected AdapterFactory getAdapterFactory4DomainModel() {" + NL + "\t\tif (myDomainModelAdapterFactory == null) {" + NL + "\t\t\tArrayList factories = new ArrayList();" + NL + "\t\t\tfillItemProviderFactories(factories);" + NL + "\t\t\tmyDomainModelAdapterFactory = new ComposedAdapterFactory(factories);" + NL + "\t\t}" + NL + "\t\treturn myDomainModelAdapterFactory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setupDomainsEMFEdititngDomain() {" + NL + "\t\tBasicCommandStack commandStack = new BasicCommandStack();" + NL + "\t\tcommandStack.addCommandStackListener(new CommandStackListener() {" + NL + "\t\t\tpublic void commandStackChanged(final EventObject event) {" + NL + "\t\t\t\tgetEditorDisplay().asyncExec(new Runnable() {" + NL + "\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\tfirePropertyChange(IEditorPart.PROP_DIRTY);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tAdapterFactoryEditingDomain afed = new AdapterFactoryEditingDomain(getAdapterFactory4DomainModel(), commandStack);" + NL + "\t\tmyResourceSet.eAdapters().add(new AdapterFactoryEditingDomain.EditingDomainProvider(afed));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tDisplay getEditorDisplay() {" + NL + "\t\treturn getGraphicalControl().getDisplay();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void fillItemProviderFactories(List factories) {";
  protected final String TEXT_21 = NL + "\t\tfactories.add(new ";
  protected final String TEXT_22 = "());";
  protected final String TEXT_23 = NL + "\t\tfactories.add(new ";
  protected final String TEXT_24 = "());";
  protected final String TEXT_25 = NL + "\t\tfactories.add(new ResourceItemProviderAdapterFactory());" + NL + "\t\tfactories.add(new ReflectiveItemProviderAdapterFactory());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * make accessible for command stack listener" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void firePropertyChange(int property) {" + NL + "\t\tsuper.firePropertyChange(property);" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    GenModel genModel = genDiagram.getEmfGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditorClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getEditorClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.util.DefaultPalettePreferences"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPluginQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPalette().getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getMetaInfoFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    
		EClass domainContainerClass = genDiagram.getDomainDiagramElement();
		GenClass genClass = genDiagram.findGenClass(domainContainerClass);
		GenPackage genPackage = genClass.getGenPackage();
		importManager.addImport(genPackage.getInterfacePackageName(), genPackage.getPackageInterfaceName());

    stringBuffer.append(TEXT_12);
    stringBuffer.append(genPackage.getPackageInterfaceName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_16);
    if (genDiagram.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_17);
    } else {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genPackage.getPrefix().toLowerCase());
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    for (Iterator i = genModel.getAllGenPackagesWithClassifiers().iterator(); i.hasNext(); ) {
	GenPackage aGenPackage = (GenPackage)i.next();
	if (aGenPackage.getGenModel().hasEditSupport()) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(aGenPackage.getQualifiedItemProviderAdapterFactoryClassName()));
    stringBuffer.append(TEXT_22);
    	}
    }
    for (Iterator i = genModel.getAllUsedGenPackagesWithClassifiers().iterator(); i.hasNext(); ) {
	GenPackage aGenPackage = (GenPackage)i.next();
	if (aGenPackage.getGenModel().hasEditSupport()) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(aGenPackage.getQualifiedItemProviderAdapterFactoryClassName()));
    stringBuffer.append(TEXT_24);
    	}
    }
    stringBuffer.append(TEXT_25);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
