/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.gmfgraph.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.gmf.gmfgraph.*;

import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Child;
import org.eclipse.gmf.gmfgraph.ColorStyle;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.CustomConnection;
import org.eclipse.gmf.gmfgraph.CustomDecoration;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Direction;
import org.eclipse.gmf.gmfgraph.Ellipse;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FigureRef;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.GeneralFacet;
import org.eclipse.gmf.gmfgraph.GradientFacet;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LabeledContainer;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.Polygon;
import org.eclipse.gmf.gmfgraph.PolygonDecoration;
import org.eclipse.gmf.gmfgraph.Polyline;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.PolylineDecoration;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.gmfgraph.SizeStyle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GMFGraphFactoryImpl extends EFactoryImpl implements GMFGraphFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GMFGraphFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GMFGraphPackage.CANVAS: return createCanvas();
			case GMFGraphPackage.FIGURE_GALLERY: return createFigureGallery();
			case GMFGraphPackage.NODE: return createNode();
			case GMFGraphPackage.CONNECTION: return createConnection();
			case GMFGraphPackage.COMPARTMENT: return createCompartment();
			case GMFGraphPackage.CHILD: return createChild();
			case GMFGraphPackage.GENERAL_FACET: return createGeneralFacet();
			case GMFGraphPackage.GRADIENT_FACET: return createGradientFacet();
			case GMFGraphPackage.FIGURE_REF: return createFigureRef();
			case GMFGraphPackage.LABEL: return createLabel();
			case GMFGraphPackage.LABELED_CONTAINER: return createLabeledContainer();
			case GMFGraphPackage.RECTANGLE: return createRectangle();
			case GMFGraphPackage.ROUNDED_RECTANGLE: return createRoundedRectangle();
			case GMFGraphPackage.ELLIPSE: return createEllipse();
			case GMFGraphPackage.POLYLINE: return createPolyline();
			case GMFGraphPackage.POLYGON: return createPolygon();
			case GMFGraphPackage.POLYLINE_CONNECTION: return createPolylineConnection();
			case GMFGraphPackage.POLYLINE_DECORATION: return createPolylineDecoration();
			case GMFGraphPackage.POLYGON_DECORATION: return createPolygonDecoration();
			case GMFGraphPackage.CUSTOM_FIGURE: return createCustomFigure();
			case GMFGraphPackage.CUSTOM_DECORATION: return createCustomDecoration();
			case GMFGraphPackage.CUSTOM_CONNECTION: return createCustomConnection();
			case GMFGraphPackage.COLOR_STYLE: return createColorStyle();
			case GMFGraphPackage.SIZE_STYLE: return createSizeStyle();
			case GMFGraphPackage.FONT_STYLE: return createFontStyle();
			case GMFGraphPackage.POINT: return createPoint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GMFGraphPackage.DIRECTION: {
				Direction result = Direction.get(initialValue);
				if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
				return result;
			}
			case GMFGraphPackage.LINE_KIND: {
				LineKind result = LineKind.get(initialValue);
				if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
				return result;
			}
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GMFGraphPackage.DIRECTION:
				return instanceValue == null ? null : instanceValue.toString();
			case GMFGraphPackage.LINE_KIND:
				return instanceValue == null ? null : instanceValue.toString();
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Canvas createCanvas() {
		CanvasImpl canvas = new CanvasImpl();
		return canvas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FigureGallery createFigureGallery() {
		FigureGalleryImpl figureGallery = new FigureGalleryImpl();
		return figureGallery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compartment createCompartment() {
		CompartmentImpl compartment = new CompartmentImpl();
		return compartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Child createChild() {
		ChildImpl child = new ChildImpl();
		return child;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralFacet createGeneralFacet() {
		GeneralFacetImpl generalFacet = new GeneralFacetImpl();
		return generalFacet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GradientFacet createGradientFacet() {
		GradientFacetImpl gradientFacet = new GradientFacetImpl();
		return gradientFacet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FigureRef createFigureRef() {
		FigureRefImpl figureRef = new FigureRefImpl();
		return figureRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label createLabel() {
		LabelImpl label = new LabelImpl();
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabeledContainer createLabeledContainer() {
		LabeledContainerImpl labeledContainer = new LabeledContainerImpl();
		return labeledContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle createRectangle() {
		RectangleImpl rectangle = new RectangleImpl();
		return rectangle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoundedRectangle createRoundedRectangle() {
		RoundedRectangleImpl roundedRectangle = new RoundedRectangleImpl();
		return roundedRectangle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ellipse createEllipse() {
		EllipseImpl ellipse = new EllipseImpl();
		return ellipse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Polyline createPolyline() {
		PolylineImpl polyline = new PolylineImpl();
		return polyline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Polygon createPolygon() {
		PolygonImpl polygon = new PolygonImpl();
		return polygon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolylineConnection createPolylineConnection() {
		PolylineConnectionImpl polylineConnection = new PolylineConnectionImpl();
		return polylineConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolylineDecoration createPolylineDecoration() {
		PolylineDecorationImpl polylineDecoration = new PolylineDecorationImpl();
		return polylineDecoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolygonDecoration createPolygonDecoration() {
		PolygonDecorationImpl polygonDecoration = new PolygonDecorationImpl();
		return polygonDecoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomFigure createCustomFigure() {
		CustomFigureImpl customFigure = new CustomFigureImpl();
		return customFigure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomDecoration createCustomDecoration() {
		CustomDecorationImpl customDecoration = new CustomDecorationImpl();
		return customDecoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomConnection createCustomConnection() {
		CustomConnectionImpl customConnection = new CustomConnectionImpl();
		return customConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorStyle createColorStyle() {
		ColorStyleImpl colorStyle = new ColorStyleImpl();
		return colorStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SizeStyle createSizeStyle() {
		SizeStyleImpl sizeStyle = new SizeStyleImpl();
		return sizeStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontStyle createFontStyle() {
		FontStyleImpl fontStyle = new FontStyleImpl();
		return fontStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point createPoint() {
		PointImpl point = new PointImpl();
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GMFGraphPackage getGMFGraphPackage() {
		return (GMFGraphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static GMFGraphPackage getPackage() {
		return GMFGraphPackage.eINSTANCE;
	}

} //GMFGraphFactoryImpl
