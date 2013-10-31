/**
 */
package pins.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pins.CustomPin;
import pins.PinsChild;
import pins.PinsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Pin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pins.impl.CustomPinImpl#getGetChildren <em>Get Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomPinImpl extends PinImpl implements CustomPin {
	/**
	 * The cached value of the '{@link #getGetChildren() <em>Get Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<PinsChild> getChildren;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomPinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PinsPackage.Literals.CUSTOM_PIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PinsChild> getGetChildren() {
		if (getChildren == null) {
			getChildren = new EObjectContainmentEList<PinsChild>(PinsChild.class, this, PinsPackage.CUSTOM_PIN__GET_CHILDREN);
		}
		return getChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PinsPackage.CUSTOM_PIN__GET_CHILDREN:
				return ((InternalEList<?>)getGetChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PinsPackage.CUSTOM_PIN__GET_CHILDREN:
				return getGetChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PinsPackage.CUSTOM_PIN__GET_CHILDREN:
				getGetChildren().clear();
				getGetChildren().addAll((Collection<? extends PinsChild>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PinsPackage.CUSTOM_PIN__GET_CHILDREN:
				getGetChildren().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PinsPackage.CUSTOM_PIN__GET_CHILDREN:
				return getChildren != null && !getChildren.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CustomPinImpl