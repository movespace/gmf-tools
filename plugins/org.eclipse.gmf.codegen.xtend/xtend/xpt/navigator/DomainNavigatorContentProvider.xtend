/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.navigator

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import xpt.Common

class DomainNavigatorContentProvider {
	@Inject extension Common;

	@Inject NavigatorContentProvider xptNavigatorContentProvider;

	def DomainNavigatorContentProvider(GenNavigator it) '''
		«copyright(editorGen)»
		package «packageName»;
		
		«generatedClassComment()»
		public class «domainContentProviderClassName» implements org.eclipse.ui.navigator.ICommonContentProvider {
		
			«attributes(it)»
			
			«constructor(it)»
			
			«xptNavigatorContentProvider.iContentProvider(it)»
			
			«xptNavigatorContentProvider.iStructuredContentProvider(it)»
			
			«xptNavigatorContentProvider.iMementoAware(it)»
			
			«xptNavigatorContentProvider.iCommonContentProvider(it)»
			
			«iTreeContentProvider(it)»
			
			«additions(it)»
		}
	'''

	def attributes(GenNavigator it) '''
		«generatedMemberComment()»
		private org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider myAdapterFctoryContentProvier;
		
		«xptNavigatorContentProvider.attributes(it)»
	'''

	def constructor(GenNavigator it) '''
		«generatedMemberComment()»
		public «domainContentProviderClassName»() {
			myAdapterFctoryContentProvier = new org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider(«editorGen.plugin.
			getActivatorQualifiedClassName()».getInstance().getItemProvidersAdapterFactory());
			«xptNavigatorContentProvider.initCommonAttributes(it)»
		}
	'''

	def iTreeContentProvider(GenNavigator it) '''
		«getChildren(it)»
		
		«wrapEObjects(it)»
		
		«xptNavigatorContentProvider.getParent(it)»
		
		«xptNavigatorContentProvider.hasChildren(it)»
	'''

	def getChildren(GenNavigator it) '''
		«generatedMemberComment()»
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof org.eclipse.core.resources.IFile) {
				«xptNavigatorContentProvider.getFileResource(it)»
				return wrapEObjects(myAdapterFctoryContentProvier.getChildren(resource), parentElement);
			}
			
			if (parentElement instanceof «domainNavigatorItemQualifiedClassName») {
				return wrapEObjects(myAdapterFctoryContentProvier.getChildren(((«domainNavigatorItemQualifiedClassName») parentElement).getEObject()), parentElement);
			}
			«getOtherChildren(it)»
		}
	'''

	def getOtherChildren(GenNavigator it) '''
		return EMPTY_ARRAY;
	'''

	def wrapEObjects(GenNavigator it) '''
		«generatedMemberComment()»
		public Object[] wrapEObjects(Object[] objects, Object parentElement) {
			java.util.Collection result = new java.util.ArrayList();
			for (int i = 0; i < objects.length; i++) {
				if (objects[i] instanceof org.eclipse.emf.ecore.EObject) {
					result.add(new «domainNavigatorItemQualifiedClassName»((org.eclipse.emf.ecore.EObject) objects[i], parentElement, myAdapterFctoryContentProvier));
				}
			}
			return result.toArray();
		}
	'''

	def additions(GenNavigator it) ''''''

}