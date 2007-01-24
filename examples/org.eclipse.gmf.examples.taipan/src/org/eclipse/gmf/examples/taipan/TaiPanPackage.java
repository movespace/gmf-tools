/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.taipan.TaiPanFactory
 * @model kind="package"
 * @generated
 */
public interface TaiPanPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "taipan"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/examples/gmf/taipan"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "taipan"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TaiPanPackage eINSTANCE = org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.taipan.impl.AquatoryImpl <em>Aquatory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.taipan.impl.AquatoryImpl
	 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getAquatory()
	 * @generated
	 */
	int AQUATORY = 0;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUATORY__PORTS = 0;

	/**
	 * The feature id for the '<em><b>Ships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUATORY__SHIPS = 1;

	/**
	 * The feature id for the '<em><b>Routes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUATORY__ROUTES = 2;

	/**
	 * The number of structural features of the '<em>Aquatory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUATORY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.taipan.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.taipan.impl.PortImpl
	 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Buildings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__BUILDINGS = 1;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.taipan.impl.ShipImpl <em>Ship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.taipan.impl.ShipImpl
	 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getShip()
	 * @generated
	 */
	int SHIP = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIP__DESTINATION = 1;

	/**
	 * The feature id for the '<em><b>Cargo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIP__CARGO = 2;

	/**
	 * The number of structural features of the '<em>Ship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIP_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.taipan.impl.ItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.taipan.impl.ItemImpl
	 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getItem()
	 * @generated
	 */
	int ITEM = 3;

	/**
	 * The feature id for the '<em><b>Article</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__ARTICLE = 0;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.taipan.impl.LargeItemImpl <em>Large Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.taipan.impl.LargeItemImpl
	 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getLargeItem()
	 * @generated
	 */
	int LARGE_ITEM = 4;

	/**
	 * The feature id for the '<em><b>Article</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_ITEM__ARTICLE = ITEM__ARTICLE;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_ITEM__WEIGHT = ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Large Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LARGE_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.taipan.impl.SmallItemsImpl <em>Small Items</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.taipan.impl.SmallItemsImpl
	 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getSmallItems()
	 * @generated
	 */
	int SMALL_ITEMS = 5;

	/**
	 * The feature id for the '<em><b>Article</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_ITEMS__ARTICLE = ITEM__ARTICLE;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_ITEMS__QUANTITY = ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Small Items</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_ITEMS_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.taipan.impl.EmptyBoxImpl <em>Empty Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.taipan.impl.EmptyBoxImpl
	 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getEmptyBox()
	 * @generated
	 */
	int EMPTY_BOX = 6;

	/**
	 * The feature id for the '<em><b>Article</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_BOX__ARTICLE = ITEM__ARTICLE;

	/**
	 * The number of structural features of the '<em>Empty Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_BOX_FEATURE_COUNT = ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.taipan.impl.RouteImpl <em>Route</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.taipan.impl.RouteImpl
	 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getRoute()
	 * @generated
	 */
	int ROUTE = 7;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__DESTINATION = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Reliability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__RELIABILITY = 3;

	/**
	 * The number of structural features of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.taipan.impl.BuildingImpl <em>Building</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.taipan.impl.BuildingImpl
	 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getBuilding()
	 * @generated
	 */
	int BUILDING = 8;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__ADDRESS = 0;

	/**
	 * The number of structural features of the '<em>Building</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_FEATURE_COUNT = 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.taipan.Aquatory <em>Aquatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aquatory</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Aquatory
	 * @generated
	 */
	EClass getAquatory();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.taipan.Aquatory#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Aquatory#getPorts()
	 * @see #getAquatory()
	 * @generated
	 */
	EReference getAquatory_Ports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.taipan.Aquatory#getShips <em>Ships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ships</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Aquatory#getShips()
	 * @see #getAquatory()
	 * @generated
	 */
	EReference getAquatory_Ships();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.taipan.Aquatory#getRoutes <em>Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routes</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Aquatory#getRoutes()
	 * @see #getAquatory()
	 * @generated
	 */
	EReference getAquatory_Routes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.taipan.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.taipan.Port#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Port#getLocation()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Location();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.taipan.Port#getBuildings <em>Buildings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buildings</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Port#getBuildings()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Buildings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.taipan.Ship <em>Ship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ship</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Ship
	 * @generated
	 */
	EClass getShip();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.taipan.Ship#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Ship#getName()
	 * @see #getShip()
	 * @generated
	 */
	EAttribute getShip_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.taipan.Ship#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Ship#getDestination()
	 * @see #getShip()
	 * @generated
	 */
	EReference getShip_Destination();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.taipan.Ship#getCargo <em>Cargo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cargo</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Ship#getCargo()
	 * @see #getShip()
	 * @generated
	 */
	EReference getShip_Cargo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.taipan.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Item
	 * @generated
	 */
	EClass getItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.taipan.Item#getArticle <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Article</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Item#getArticle()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Article();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.taipan.LargeItem <em>Large Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Large Item</em>'.
	 * @see org.eclipse.gmf.examples.taipan.LargeItem
	 * @generated
	 */
	EClass getLargeItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.taipan.LargeItem#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.eclipse.gmf.examples.taipan.LargeItem#getWeight()
	 * @see #getLargeItem()
	 * @generated
	 */
	EAttribute getLargeItem_Weight();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.taipan.SmallItems <em>Small Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Small Items</em>'.
	 * @see org.eclipse.gmf.examples.taipan.SmallItems
	 * @generated
	 */
	EClass getSmallItems();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.taipan.SmallItems#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see org.eclipse.gmf.examples.taipan.SmallItems#getQuantity()
	 * @see #getSmallItems()
	 * @generated
	 */
	EAttribute getSmallItems_Quantity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.taipan.EmptyBox <em>Empty Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empty Box</em>'.
	 * @see org.eclipse.gmf.examples.taipan.EmptyBox
	 * @generated
	 */
	EClass getEmptyBox();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.taipan.Route <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Route</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Route
	 * @generated
	 */
	EClass getRoute();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.taipan.Route#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Route#getSource()
	 * @see #getRoute()
	 * @generated
	 */
	EReference getRoute_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.taipan.Route#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Route#getDestination()
	 * @see #getRoute()
	 * @generated
	 */
	EReference getRoute_Destination();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.taipan.Route#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Route#getDescription()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.taipan.Route#getReliability <em>Reliability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reliability</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Route#getReliability()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Reliability();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.taipan.Building <em>Building</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Building</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Building
	 * @generated
	 */
	EClass getBuilding();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.taipan.Building#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see org.eclipse.gmf.examples.taipan.Building#getAddress()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_Address();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TaiPanFactory getTaiPanFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.taipan.impl.AquatoryImpl <em>Aquatory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.taipan.impl.AquatoryImpl
		 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getAquatory()
		 * @generated
		 */
		EClass AQUATORY = eINSTANCE.getAquatory();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AQUATORY__PORTS = eINSTANCE.getAquatory_Ports();

		/**
		 * The meta object literal for the '<em><b>Ships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AQUATORY__SHIPS = eINSTANCE.getAquatory_Ships();

		/**
		 * The meta object literal for the '<em><b>Routes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AQUATORY__ROUTES = eINSTANCE.getAquatory_Routes();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.taipan.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.taipan.impl.PortImpl
		 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__LOCATION = eINSTANCE.getPort_Location();

		/**
		 * The meta object literal for the '<em><b>Buildings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__BUILDINGS = eINSTANCE.getPort_Buildings();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.taipan.impl.ShipImpl <em>Ship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.taipan.impl.ShipImpl
		 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getShip()
		 * @generated
		 */
		EClass SHIP = eINSTANCE.getShip();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHIP__NAME = eINSTANCE.getShip_Name();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHIP__DESTINATION = eINSTANCE.getShip_Destination();

		/**
		 * The meta object literal for the '<em><b>Cargo</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHIP__CARGO = eINSTANCE.getShip_Cargo();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.taipan.impl.ItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.taipan.impl.ItemImpl
		 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getItem()
		 * @generated
		 */
		EClass ITEM = eINSTANCE.getItem();

		/**
		 * The meta object literal for the '<em><b>Article</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__ARTICLE = eINSTANCE.getItem_Article();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.taipan.impl.LargeItemImpl <em>Large Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.taipan.impl.LargeItemImpl
		 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getLargeItem()
		 * @generated
		 */
		EClass LARGE_ITEM = eINSTANCE.getLargeItem();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LARGE_ITEM__WEIGHT = eINSTANCE.getLargeItem_Weight();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.taipan.impl.SmallItemsImpl <em>Small Items</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.taipan.impl.SmallItemsImpl
		 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getSmallItems()
		 * @generated
		 */
		EClass SMALL_ITEMS = eINSTANCE.getSmallItems();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMALL_ITEMS__QUANTITY = eINSTANCE.getSmallItems_Quantity();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.taipan.impl.EmptyBoxImpl <em>Empty Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.taipan.impl.EmptyBoxImpl
		 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getEmptyBox()
		 * @generated
		 */
		EClass EMPTY_BOX = eINSTANCE.getEmptyBox();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.taipan.impl.RouteImpl <em>Route</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.taipan.impl.RouteImpl
		 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getRoute()
		 * @generated
		 */
		EClass ROUTE = eINSTANCE.getRoute();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTE__SOURCE = eINSTANCE.getRoute_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTE__DESTINATION = eINSTANCE.getRoute_Destination();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__DESCRIPTION = eINSTANCE.getRoute_Description();

		/**
		 * The meta object literal for the '<em><b>Reliability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__RELIABILITY = eINSTANCE.getRoute_Reliability();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.taipan.impl.BuildingImpl <em>Building</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.taipan.impl.BuildingImpl
		 * @see org.eclipse.gmf.examples.taipan.impl.TaiPanPackageImpl#getBuilding()
		 * @generated
		 */
		EClass BUILDING = eINSTANCE.getBuilding();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUILDING__ADDRESS = eINSTANCE.getBuilding_Address();

	}

} //TaiPanPackage
