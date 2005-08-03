/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Link With Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Covers cases where domain model has dedicated metaclass for the link
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass#getDomainMetaClass <em>Domain Meta Class</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass#getLinkContainerFeature <em>Link Container Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenLinkWithClass()
 * @model
 * @generated
 */
public interface GenLinkWithClass extends GenLink {
	/**
	 * Returns the value of the '<em><b>Domain Meta Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * instances of this class will be represented by link
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Meta Class</em>' reference.
	 * @see #setDomainMetaClass(EClass)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenLinkWithClass_DomainMetaClass()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='super.domainLinkTargetFeature.eContainingClass \'equals to\' or \'superclass of\' domainMetaClass'"
	 * @generated
	 */
	EClass getDomainMetaClass();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass#getDomainMetaClass <em>Domain Meta Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Meta Class</em>' reference.
	 * @see #getDomainMetaClass()
	 * @generated
	 */
	void setDomainMetaClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Link Container Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * references link containment feature, i.e. where to add created links (of type domainMetaClass)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link Container Feature</em>' reference.
	 * @see #setLinkContainerFeature(EStructuralFeature)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenLinkWithClass_LinkContainerFeature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getLinkContainerFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass#getLinkContainerFeature <em>Link Container Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Container Feature</em>' reference.
	 * @see #getLinkContainerFeature()
	 * @generated
	 */
	void setLinkContainerFeature(EStructuralFeature value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initialize(EClass eClass);

} // GenLinkWithClass
