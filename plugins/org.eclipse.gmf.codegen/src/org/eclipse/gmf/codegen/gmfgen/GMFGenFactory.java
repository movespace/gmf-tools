/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage
 * @generated
 */
public interface GMFGenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GMFGenFactory eINSTANCE = new org.eclipse.gmf.codegen.gmfgen.impl.GMFGenFactoryImpl();

	/**
	 * Returns a new object of class '<em>Gen Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Diagram</em>'.
	 * @generated
	 */
	GenDiagram createGenDiagram();

	/**
	 * Returns a new object of class '<em>Gen Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Node</em>'.
	 * @generated
	 */
	GenNode createGenNode();

	/**
	 * Returns a new object of class '<em>Gen Child Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Child Node</em>'.
	 * @generated
	 */
	GenChildNode createGenChildNode();

	/**
	 * Returns a new object of class '<em>Gen Child Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Child Container</em>'.
	 * @generated
	 */
	GenChildContainer createGenChildContainer();

	/**
	 * Returns a new object of class '<em>Gen Link With Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Link With Class</em>'.
	 * @generated
	 */
	GenLinkWithClass createGenLinkWithClass();

	/**
	 * Returns a new object of class '<em>Gen Link Reference Only</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Link Reference Only</em>'.
	 * @generated
	 */
	GenLinkReferenceOnly createGenLinkReferenceOnly();

	/**
	 * Returns a new object of class '<em>Palette</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Palette</em>'.
	 * @generated
	 */
	Palette createPalette();

	/**
	 * Returns a new object of class '<em>Node Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Entry</em>'.
	 * @generated
	 */
	NodeEntry createNodeEntry();

	/**
	 * Returns a new object of class '<em>Link Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Entry</em>'.
	 * @generated
	 */
	LinkEntry createLinkEntry();

	/**
	 * Returns a new object of class '<em>Tool Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tool Group</em>'.
	 * @generated
	 */
	ToolGroup createToolGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GMFGenPackage getGMFGenPackage();

} //GMFGenFactory
