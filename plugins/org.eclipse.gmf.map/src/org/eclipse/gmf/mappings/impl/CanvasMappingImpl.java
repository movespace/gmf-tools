/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.GMFMapPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Canvas Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.impl.CanvasMappingImpl#getDiagramCanvas <em>Diagram Canvas</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.CanvasMappingImpl#getDomainModel <em>Domain Model</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.CanvasMappingImpl#getDomainMetaElement <em>Domain Meta Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CanvasMappingImpl extends MappingEntryImpl implements CanvasMapping {
	/**
	 * The cached value of the '{@link #getDiagramCanvas() <em>Diagram Canvas</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramCanvas()
	 * @generated
	 * @ordered
	 */
	protected Canvas diagramCanvas = null;

	/**
	 * The cached value of the '{@link #getDomainModel() <em>Domain Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainModel()
	 * @generated
	 * @ordered
	 */
	protected EPackage domainModel = null;

	/**
	 * The cached value of the '{@link #getDomainMetaElement() <em>Domain Meta Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainMetaElement()
	 * @generated
	 * @ordered
	 */
	protected EClass domainMetaElement = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CanvasMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getCanvasMapping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Canvas getDiagramCanvas() {
		if (diagramCanvas != null && diagramCanvas.eIsProxy()) {
			InternalEObject oldDiagramCanvas = (InternalEObject)diagramCanvas;
			diagramCanvas = (Canvas)eResolveProxy(oldDiagramCanvas);
			if (diagramCanvas != oldDiagramCanvas) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.CANVAS_MAPPING__DIAGRAM_CANVAS, oldDiagramCanvas, diagramCanvas));
			}
		}
		return diagramCanvas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Canvas basicGetDiagramCanvas() {
		return diagramCanvas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramCanvas(Canvas newDiagramCanvas) {
		Canvas oldDiagramCanvas = diagramCanvas;
		diagramCanvas = newDiagramCanvas;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CANVAS_MAPPING__DIAGRAM_CANVAS, oldDiagramCanvas, diagramCanvas));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getDomainModel() {
		if (domainModel != null && domainModel.eIsProxy()) {
			InternalEObject oldDomainModel = (InternalEObject)domainModel;
			domainModel = (EPackage)eResolveProxy(oldDomainModel);
			if (domainModel != oldDomainModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.CANVAS_MAPPING__DOMAIN_MODEL, oldDomainModel, domainModel));
			}
		}
		return domainModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetDomainModel() {
		return domainModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainModel(EPackage newDomainModel) {
		EPackage oldDomainModel = domainModel;
		domainModel = newDomainModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CANVAS_MAPPING__DOMAIN_MODEL, oldDomainModel, domainModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainMetaElement() {
		if (domainMetaElement != null && domainMetaElement.eIsProxy()) {
			InternalEObject oldDomainMetaElement = (InternalEObject)domainMetaElement;
			domainMetaElement = (EClass)eResolveProxy(oldDomainMetaElement);
			if (domainMetaElement != oldDomainMetaElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.CANVAS_MAPPING__DOMAIN_META_ELEMENT, oldDomainMetaElement, domainMetaElement));
			}
		}
		return domainMetaElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetDomainMetaElement() {
		return domainMetaElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainMetaElement(EClass newDomainMetaElement) {
		EClass oldDomainMetaElement = domainMetaElement;
		domainMetaElement = newDomainMetaElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.CANVAS_MAPPING__DOMAIN_META_ELEMENT, oldDomainMetaElement, domainMetaElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFMapPackage.CANVAS_MAPPING__DIAGRAM_CANVAS:
				if (resolve) return getDiagramCanvas();
				return basicGetDiagramCanvas();
			case GMFMapPackage.CANVAS_MAPPING__DOMAIN_MODEL:
				if (resolve) return getDomainModel();
				return basicGetDomainModel();
			case GMFMapPackage.CANVAS_MAPPING__DOMAIN_META_ELEMENT:
				if (resolve) return getDomainMetaElement();
				return basicGetDomainMetaElement();
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
			case GMFMapPackage.CANVAS_MAPPING__DIAGRAM_CANVAS:
				setDiagramCanvas((Canvas)newValue);
				return;
			case GMFMapPackage.CANVAS_MAPPING__DOMAIN_MODEL:
				setDomainModel((EPackage)newValue);
				return;
			case GMFMapPackage.CANVAS_MAPPING__DOMAIN_META_ELEMENT:
				setDomainMetaElement((EClass)newValue);
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
			case GMFMapPackage.CANVAS_MAPPING__DIAGRAM_CANVAS:
				setDiagramCanvas((Canvas)null);
				return;
			case GMFMapPackage.CANVAS_MAPPING__DOMAIN_MODEL:
				setDomainModel((EPackage)null);
				return;
			case GMFMapPackage.CANVAS_MAPPING__DOMAIN_META_ELEMENT:
				setDomainMetaElement((EClass)null);
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
			case GMFMapPackage.CANVAS_MAPPING__DIAGRAM_CANVAS:
				return diagramCanvas != null;
			case GMFMapPackage.CANVAS_MAPPING__DOMAIN_MODEL:
				return domainModel != null;
			case GMFMapPackage.CANVAS_MAPPING__DOMAIN_META_ELEMENT:
				return domainMetaElement != null;
		}
		return super.eIsSet(featureID);
	}

} //CanvasMappingImpl
