/**
 * Copyright (c) 2008, 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.xpand.migration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.migration.MigrationException;
import org.eclipse.gmf.internal.xpand.migration.MigrationExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.migration.XpandMigrationFacade;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.gmf.tests.xpand.TestsResourceManager;
import org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage;

public class XpandMigrationTest extends TestCase {

	private TestsResourceManager testResourceManager;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testResourceManager = new TestsResourceManager();
	}
	
	public void testDefinition() throws IOException, MigrationException {
		checkMigration("Definition");
	}

	public void testDefinitionParameters() throws IOException, MigrationException {
		checkMigration("DefinitionParameters");
	}
	
	public void testStdlibExtension() throws IOException, MigrationException {
		checkMigration("StdlibExtension");
	}
	
	public void testStdlibExtension_withoutOtherExtensions() throws IOException, MigrationException {
		checkMigration("StdlibExtension_withoutOtherExtensions");
	}

	public void testStdlibExtension_withOtherExtensions() throws IOException, MigrationException {
		checkMigration("StdlibExtension_withOtherExtensions");
	}
	
	public void testExpressionStatements() throws IOException, MigrationException {
		checkMigration("ExpressionStatements");
	}
	
	public void testErrorStatements() throws IOException, MigrationException {
		checkMigration("ErrorStatements");
	}
	
	public void testExpandStatements() throws IOException, MigrationException {
		checkMigration("ExpandStatements");
	}
	
	public void testFileStatements() throws IOException, MigrationException {
		checkMigration("FileStatements");
	}
	
	public void testForEachStatements() throws IOException, MigrationException {
		checkMigration("ForEachStatements");
	}
	
	public void testIfStatements() throws IOException, MigrationException {
		checkMigration("IfStatements");
	}
	
	public void testLetStatements() throws IOException, MigrationException {
		checkMigration("LetStatements");
	}
	
	public void testFixedProblems() throws IOException, MigrationException {
		String resourceName = "FixedProblems";
		checkMigration(new XpandMigrationFacade(testResourceManager, getResourceName(resourceName), new MigrationExecutionContextImpl(testResourceManager, MigrationTestsPackage.eINSTANCE)), resourceName);
	}
	
	public void testImportedExtensions() throws IOException, MigrationException {
		checkMigration("ImportedExtensions");
	}

	public void testImportedExtensionsWReexport() throws IOException, MigrationException {
		checkMigration("ImportedExtensionsWReexport");
	}
	
	private String checkMigration(XpandMigrationFacade facade, String resourceName) throws IOException, MigrationException {
		String content = facade.migrateXpandResource().toString();
		assertTrue(content.length() > 0);

		StringBuilder etalon = new StringBuilder();
		Reader reader = new InputStreamReader(testResourceManager.loadFile(getEtalonResourceName(resourceName), XpandResource.TEMPLATE_EXTENSION), Charset.forName("ISO-8859-1"));
		for (int ch = reader.read(); ch != -1; ch = reader.read()) {
			etalon.append((char) ch);
		}
		assertEquals(etalon.toString(), content);
		return content;
	}
	
	
	private String checkMigration(String resourceName) throws IOException, MigrationException {
		return checkMigration(new XpandMigrationFacade(testResourceManager, getResourceName(resourceName)), resourceName);
	}

	private static String getEtalonResourceName(String resourceName) {
		return getResourceName(resourceName) + "_etalon";
	}

	private static String getResourceName(String resourceName) {
		return "org::eclipse::gmf::tests::xpand::migration::xpand::" + resourceName;
	}

}
