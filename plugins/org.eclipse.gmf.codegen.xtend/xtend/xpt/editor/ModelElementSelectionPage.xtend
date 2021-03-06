/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Svyatoslav Kovalsky (Montages) - #410477 "same-generated" code extracted to GMFT-runtime 
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.editor

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import xpt.Common
import xpt.Externalizer
import xpt.ExternalizerUtils_qvto
import plugin.Activator

@com.google.inject.Singleton class ModelElementSelectionPage {
	@Inject extension Common;
	@Inject extension ExternalizerUtils_qvto;

	@Inject Activator xptActivator;	
	@Inject Externalizer xptExternalizer;

	def className(GenDiagram it) '''ModelElementSelectionPage'''

	def packageName(GenDiagram it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def extendsList(GenDiagram it) '''extends org.eclipse.gmf.tooling.runtime.part.DefaultModelElementSelectionPage'''

	def ModelElementSelectionPage(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment('Wizard page that allows to select element from model.')»
		public class «className(it)» «extendsList(it)» {
			«attributes(it)»
		
			«constructor(it)»
		
			«getModelElement(it)»
		
			«setModelElement(it)»
		
			«createControl(it)»
		
			«getSelectionTitle(it)»
		
			«updateSelection(it)»
		
			«validatePage(it)»
		
			«additions(it)»
		}
	'''

	def constructor(GenDiagram it) '''
		«generatedMemberComment»
		public «className(it)»(String pageName) {
			super(«xptActivator.qualifiedClassName(editorGen.plugin)».getInstance().getItemProvidersAdapterFactory(), pageName);
		}
	'''

	def getSelectionTitle(GenDiagram it) '''
		«generatedMemberComment('Override to provide custom model element description.')»
		protected String getSelectionTitle() {
			return «xptExternalizer.accessorCall(editorGen, messageKey(i18nKeyForModelElementSelectionPage(it)))»;
		}
	'''

	@Localization def i18nValues(GenDiagram it) '''
		«xptExternalizer.messageEntry(messageKey(i18nKeyForModelElementSelectionPage(it)), 'Select model element:')»
	'''

	@Localization def i18nAccessors(GenDiagram it) '''
		«xptExternalizer.accessorField(messageKey(i18nKeyForModelElementSelectionPage(it)))»
	'''

	/**
	 * Since 3.1 the code moved to non-generated super class in GMFT-runtime. 
	 * Empty xpands are left here to support backward compatibility
	 */
	def attributes(GenDiagram it) ''''''

	/**
	 * Since 3.1 the code moved to non-generated super class in GMFT-runtime. 
	 * Empty xpands are left here to support backward compatibility
	 */
	def getModelElement(GenDiagram it) ''''''

	/**
	 * Since 3.1 the code moved to non-generated super class in GMFT-runtime. 
	 * Empty xpands are left here to support backward compatibility
	 */
	def setModelElement(GenDiagram it) ''''''

	/**
	 * Since 3.1 the code moved to non-generated super class in GMFT-runtime. 
	 * Empty xpands are left here to support backward compatibility
	 */
	def createControl(GenDiagram it) ''''''

	/**
	 * Since 3.1 the code moved to non-generated super class in GMFT-runtime. 
	 * Empty xpands are left here to support backward compatibility
	 */
	def updateSelection(GenDiagram it) ''''''

	/**
	 * Since 3.1 the code moved to non-generated super class in GMFT-runtime. 
	 * Empty xpands are left here to support backward compatibility
	 */
	def validatePage(GenDiagram it) ''''''

	def additions(GenDiagram it) ''''''

	@Localization def String i18nKeyForModelElementSelectionPage(GenDiagram diagram) {
		return className(diagram).toString
	}

}
