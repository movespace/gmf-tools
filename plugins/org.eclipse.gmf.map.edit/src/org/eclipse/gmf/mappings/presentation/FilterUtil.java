/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    vano - initial API and implementation
 */
package org.eclipse.gmf.mappings.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.FeatureInitializer;
import org.eclipse.gmf.mappings.FeatureSeqInitializer;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.MappingEntry;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.NodeReference;
import org.eclipse.gmf.mappings.TopNodeReference;

public class FilterUtil {

	private static Comparator EOBJECTS_COMPARATOR = new EObjectsComparator();

	public static List sort(Collection eObjects) {
		List result = new ArrayList(eObjects);
		Collections.sort(result, EOBJECTS_COMPARATOR);
		return result;
	}

	public static List filterByResourceSet(Collection eClasses, ResourceSet resourceSet) {
		return sort(getValidEClassesFrom(eClasses, resourceSet));
	}

	public static List filterByContainmentFeature(Collection eClasses, MappingEntry mappingEntry) {
		EClass superType = null;
		if (mappingEntry instanceof NodeMapping) {
			NodeReference nodeReference = (NodeReference) mappingEntry.eContainer();
			EReference modelReference = nodeReference.getChildrenFeature() != null ? nodeReference.getChildrenFeature() : nodeReference.getContainmentFeature();
			if (modelReference != null) {
				superType = modelReference.getEReferenceType();
			}
		} else if (mappingEntry instanceof LinkMapping) {
			if (((LinkMapping) mappingEntry).getContainmentFeature() != null) {
				superType = ((LinkMapping) mappingEntry).getContainmentFeature().getEReferenceType();
			}
		}
		return sort(getSubtypesOf(getValidEClassesFrom(eClasses, mappingEntry.eResource().getResourceSet()), superType));
	}

	public static List filterByContainerMetaclass(Collection eReferences, LinkMapping mappingEntry) {
		EClass containerMetaClass = mappingEntry.getDomainMetaElement();
		return sort(getEStructuralFeaturesOf(eReferences, containerMetaClass));
	}

	public static List filterByContainerMetaclass(Collection eAttributes, LabelMapping labelMapping) {
		EClass containerMetaClass = labelMapping.getMapEntry().getDomainMetaElement();
		return sort(getEStructuralFeaturesOf(eAttributes, containerMetaClass));
	}
	
	public static List filterByContainerMetaclass(Collection eAttributes, MappingEntry mappingEntry) {
		EClass containerMetaClass = mappingEntry.getDomainMetaElement();
		return sort(getEStructuralFeaturesOf(eAttributes, containerMetaClass));
	}

	public static List filterByContainerMetaclass(Collection eReferences, NodeReference nodeReference, boolean containmentOnly) {
		EClass containerMetaClass = null;
		EClass targetMetaClass = null;
		if (nodeReference instanceof ChildReference) {
			containerMetaClass = ((ChildReference) nodeReference).getParentNode().getDomainMetaElement();
		} else if (nodeReference instanceof TopNodeReference) {
			CanvasMapping diagram = ((Mapping) nodeReference.eContainer()).getDiagram();
			if (diagram != null) {
				containerMetaClass = diagram.getDomainMetaElement();
			}
		}
		if (nodeReference.isSetChild()) {
			targetMetaClass = nodeReference.getChild().getDomainMetaElement();
		}
		// XXX hmm, outcome from getEStructuralFeaturesOf passed to getEReferences - 
		// neither implementation filters out elements of other types. just assumes and casts 
		List fromHierarchy = sort(getEReferences(getEStructuralFeaturesOf(eReferences, containerMetaClass), containmentOnly));
		if (targetMetaClass == null) {
			// no child known, thus can take references from metaelement's hierarchy only
			return fromHierarchy;
		}
		List targetsToChild = sort(getEReferences(getEReferencesOfType(eReferences, targetMetaClass), containmentOnly));
		for (Iterator it = targetsToChild.iterator(); it.hasNext();) {
			if (fromHierarchy.contains(it.next())) {
				it.remove();
			}
		}
		ArrayList rv = new ArrayList(fromHierarchy.size() + targetsToChild.size());
		rv.addAll(fromHierarchy);
		rv.addAll(targetsToChild);
		return rv;
	}

	public static List filterByReferenceType(Collection eReferences, LinkMapping linkMapping) {
		EClass referenceType = linkMapping.getDomainMetaElement();
		return sort(getEReferences(getEReferencesOfType(eReferences, referenceType), true));
	}

	public static Collection filterByNodeMapping(Collection childReferences, CompartmentMapping mapping) {
		return sort(getChildrenOf(childReferences, mapping.getParentNode(), false));
	}
	
	public static Collection filterByNodeMapping(Collection compartments, ChildReference childReference) {
		return getChildrenOf(compartments, childReference.getParentNode(), true);
	}
	
	public static Collection filterBySuperClasses(Collection instances, Class[] classes) {
		return sort(getSubClassesOf(instances, classes));
	}
	
	public static Collection<EStructuralFeature> filterByFeatureInitializer(Collection<EStructuralFeature> features, FeatureInitializer featureInitializer) {
		if(featureInitializer.getFeatureSeqInitializer() == null ||
			featureInitializer.getFeatureSeqInitializer().getElementClass() == null) {
			return features;
		}
		EClass eClass = featureInitializer.getFeatureSeqInitializer().getElementClass();		
		List<EStructuralFeature> result = new ArrayList<EStructuralFeature>(getEStructuralFeaturesOf(features, eClass));
		for (Iterator<EStructuralFeature> it = result.iterator(); it.hasNext();) {
			EStructuralFeature nextFeature = it.next();
			if(nextFeature == null || !nextFeature.isChangeable()) {
				it.remove();
			}
		}
		return result;
	}
	
	public static Collection<EClass> filterByFeatureSeqInitializer(Collection<EClass> eClasses, FeatureSeqInitializer featureSeqInitializer) {
		if(featureSeqInitializer.getCreatingInitializer() != null) {
			EStructuralFeature feature = featureSeqInitializer.getCreatingInitializer().getFeature();
			if(feature != null && feature.getEType() instanceof EClass) {
				for (Iterator it = eClasses.iterator(); it.hasNext();) {
					EClass nextEClass = (EClass) it.next();
					EClass typeEClass = (EClass)feature.getEType();
					if(nextEClass == null || nextEClass.isAbstract() || nextEClass.isInterface() || !typeEClass.isSuperTypeOf(nextEClass)) {
						it.remove();
					}
				}
			}
		} else if(featureSeqInitializer.getElementClass() != null) {
			return Collections.singleton(featureSeqInitializer.getElementClass());
		} 
				
		return eClasses;
	}	

	private static Collection getSubtypesOf(Collection eClasses, EClass superType) {
		if (superType == null) {
			return eClasses;
		}
		for (Iterator it = eClasses.iterator(); it.hasNext();) {
			EClass nextEClass = (EClass) it.next();
			if (nextEClass != null && !superType.isSuperTypeOf(nextEClass)) {
				it.remove();
			}
		}
		return eClasses;
	}

	private static Collection getEReferences(Collection eReferences, boolean containmentOnly) {
		if (!containmentOnly) {
			return eReferences;
		}
		for (Iterator it = eReferences.iterator(); it.hasNext();) {
			EReference nextReference = (EReference) it.next();
			if (nextReference != null && !nextReference.isContainment()) {
				it.remove();
			}
		}
		return eReferences;
	}

	private static Collection getEStructuralFeaturesOf(Collection structuralFeatures, EClass featureContainerEClass) {
		Collection result = getValidEStructuralFeatures(structuralFeatures);
		if (featureContainerEClass == null) {
			return result;
		}
		for (Iterator it = result.iterator(); it.hasNext();) {
			EStructuralFeature nextFeature = (EStructuralFeature) it.next();
			if (nextFeature != null && !nextFeature.getEContainingClass().isSuperTypeOf(featureContainerEClass)) {
				it.remove();
			}
		}
		return result;
	}

	private static Collection getEReferencesOfType(Collection references, EClass referenceType) {
		Collection result = getValidEStructuralFeatures(references);
		if (referenceType == null) {
			return result;
		}
		for (Iterator it = result.iterator(); it.hasNext();) {
			EReference nextFeature = (EReference) it.next();
			if (nextFeature != null && !nextFeature.getEReferenceType().isSuperTypeOf(referenceType)) {
				it.remove();
			}
		}
		return result;
	}

	private static Collection getValidEStructuralFeatures(Collection structuralFeatures) {
		Collection result = getValidEObjects(structuralFeatures);
		for (Iterator it = result.iterator(); it.hasNext();) {
			EStructuralFeature nextFeature = (EStructuralFeature) it.next();
			if (nextFeature != null && (nextFeature.getEContainingClass() == null)) {
				it.remove();
			}
		}
		return result;
	}

	private static Collection getValidEClassesFrom(Collection eClasses, ResourceSet resourceSet) {
		Collection result = getValidEObjects(eClasses);
		for (Iterator it = result.iterator(); it.hasNext();) {
			EClass nextEClass = (EClass) it.next();
			if (nextEClass == null) {
				continue;
			}
			if (nextEClass.eResource().getResourceSet() != resourceSet) {
				it.remove();
			}
		}
		return result;
	}

	private static Collection getValidEObjects(Collection eObjects) {
		List result = new ArrayList();
		for (Iterator it = eObjects.iterator(); it.hasNext();) {
			EObject nextEObject = (EObject) it.next();
			if (nextEObject != null && (nextEObject.eContainer() == null)) {
				continue;
			}
			result.add(nextEObject);
		}
		return result;
	}
	
	private static Collection getChildrenOf(Collection elements, EObject container, boolean addNull) {
		List result = new ArrayList();
		for (Iterator it = elements.iterator(); it.hasNext();) {
			EObject nextEObject = (EObject) it.next();
			if (nextEObject == null ? addNull : nextEObject.eContainer() == container) {
				result.add(nextEObject);
			}
		}
		return result;
	}

	private static Collection getSubClassesOf(Collection instances, Class[] classes) {
		List result = new ArrayList();
		for (Iterator it = instances.iterator(); it.hasNext();) {
			Object nextInstance = it.next();
			for (int i = 0; i < classes.length; i++) {
				if (nextInstance == null || classes[i].isAssignableFrom(nextInstance.getClass())) {
					result.add(nextInstance);
					break;
				}
			}
		}
		return result;
	}
	
	private static class EObjectsComparator implements Comparator {

		public int compare(Object o1, Object o2) {
			if (o1 instanceof EObject && o2 instanceof EObject) {
				EObject firstEObject = (EObject) o1;
				EObject secondEObject = (EObject) o2;
				return compareLabels(firstEObject, secondEObject);
			}
			return compareObjects(o1, o2);
		}

		private int compareObjects(Object o1, Object o2) {
			if (o1 == null) {
				return o2 == null ? 0 : 1;
			} else {
				return o2 == null ? -1 : 0;
			}
		}

		private int compareLabels(EObject firstEObject, EObject secondEObject) {
			String firstLabel = getLabel(firstEObject);
			String secondLabel = getLabel(secondEObject);
			return firstLabel == null ? (secondLabel == null ? 0 : 1) : (secondLabel == null ? -1 : firstLabel.compareTo(secondLabel));
		}

		private String getLabel(EObject eObject) {
			AdapterFactory adapterFactory = getAdapterFactory(eObject);
			if (adapterFactory == null) {
				return "";
			}
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(eObject, IItemLabelProvider.class);
			return itemLabelProvider != null ? itemLabelProvider.getText(eObject) : eObject == null ? "" : eObject.toString();
		}

		private AdapterFactory getAdapterFactory(EObject eObject) {
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
			if (editingDomain instanceof AdapterFactoryEditingDomain) {
				return ((AdapterFactoryEditingDomain) editingDomain).getAdapterFactory();
			}
			return null;
		}

	}

}
