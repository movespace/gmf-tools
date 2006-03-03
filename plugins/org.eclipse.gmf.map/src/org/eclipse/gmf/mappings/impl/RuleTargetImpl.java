/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.RuleBase;
import org.eclipse.gmf.mappings.RuleTarget;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.impl.RuleTargetImpl#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RuleTargetImpl extends EObjectImpl implements RuleTarget {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleTargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getRuleTarget();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleBase getRule() {
		if (eContainerFeatureID != GMFMapPackage.RULE_TARGET__RULE) return null;
		return (RuleBase)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule(RuleBase newRule) {
		if (newRule != eInternalContainer() || (eContainerFeatureID != GMFMapPackage.RULE_TARGET__RULE && newRule != null)) {
			if (EcoreUtil.isAncestor(this, newRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRule != null)
				msgs = ((InternalEObject)newRule).eInverseAdd(this, GMFMapPackage.RULE_BASE__TARGET, RuleBase.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newRule, GMFMapPackage.RULE_TARGET__RULE, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.RULE_TARGET__RULE, newRule, newRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.RULE_TARGET__RULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, GMFMapPackage.RULE_TARGET__RULE, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.RULE_TARGET__RULE:
				return eBasicSetContainer(null, GMFMapPackage.RULE_TARGET__RULE, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case GMFMapPackage.RULE_TARGET__RULE:
				return eInternalContainer().eInverseRemove(this, GMFMapPackage.RULE_BASE__TARGET, RuleBase.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFMapPackage.RULE_TARGET__RULE:
				return getRule();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GMFMapPackage.RULE_TARGET__RULE:
				setRule((RuleBase)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case GMFMapPackage.RULE_TARGET__RULE:
				setRule((RuleBase)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GMFMapPackage.RULE_TARGET__RULE:
				return getRule() != null;
		}
		return super.eIsSet(featureID);
	}

} //RuleTargetImpl
