/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Label Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Label based on feature(s) from domain model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.FeatureLabelMapping#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.FeatureLabelMapping#getViewPattern <em>View Pattern</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.FeatureLabelMapping#getViewMethod <em>View Method</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.FeatureLabelMapping#getEditPattern <em>Edit Pattern</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.FeatureLabelMapping#getEditMethod <em>Edit Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.mappings.GMFMapPackage#getFeatureLabelMapping()
 * @model
 * @generated
 */
public interface FeatureLabelMapping extends LabelMapping {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getFeatureLabelMapping_Features()
	 * @model type="org.eclipse.emf.ecore.EAttribute" required="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='features->forAll(f | f.eContainingClass.isSuperTypeOf(mapEntry.domainMetaElement))' description='Label attributes must be available in \'Domain Element\' EClass of the labeled mapping entry'"
	 * @generated
	 */
	EList<EAttribute> getFeatures();

	/**
	 * Returns the value of the '<em><b>View Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pattern to produce label on diagram, depends on view method
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>View Pattern</em>' attribute.
	 * @see #setViewPattern(String)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getFeatureLabelMapping_ViewPattern()
	 * @model
	 * @generated
	 */
	String getViewPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.FeatureLabelMapping#getViewPattern <em>View Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Pattern</em>' attribute.
	 * @see #getViewPattern()
	 * @generated
	 */
	void setViewPattern(String value);

	/**
	 * Returns the value of the '<em><b>View Method</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gmf.mappings.LabelViewMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Method</em>' attribute.
	 * @see org.eclipse.gmf.mappings.LabelViewMethod
	 * @see #setViewMethod(LabelViewMethod)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getFeatureLabelMapping_ViewMethod()
	 * @model
	 * @generated
	 */
	LabelViewMethod getViewMethod();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.FeatureLabelMapping#getViewMethod <em>View Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Method</em>' attribute.
	 * @see org.eclipse.gmf.mappings.LabelViewMethod
	 * @see #getViewMethod()
	 * @generated
	 */
	void setViewMethod(LabelViewMethod value);

	/**
	 * Returns the value of the '<em><b>Edit Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pattern to produce text for inplace editor, depends on edit method; if not specified then viewPattern should be used
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Edit Pattern</em>' attribute.
	 * @see #setEditPattern(String)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getFeatureLabelMapping_EditPattern()
	 * @model
	 * @generated
	 */
	String getEditPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.FeatureLabelMapping#getEditPattern <em>Edit Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edit Pattern</em>' attribute.
	 * @see #getEditPattern()
	 * @generated
	 */
	void setEditPattern(String value);

	/**
	 * Returns the value of the '<em><b>Edit Method</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gmf.mappings.LabelEditMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edit Method</em>' attribute.
	 * @see org.eclipse.gmf.mappings.LabelEditMethod
	 * @see #setEditMethod(LabelEditMethod)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getFeatureLabelMapping_EditMethod()
	 * @model
	 * @generated
	 */
	LabelEditMethod getEditMethod();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.FeatureLabelMapping#getEditMethod <em>Edit Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edit Method</em>' attribute.
	 * @see org.eclipse.gmf.mappings.LabelEditMethod
	 * @see #getEditMethod()
	 * @generated
	 */
	void setEditMethod(LabelEditMethod value);

} // FeatureLabelMapping