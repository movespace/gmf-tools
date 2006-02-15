/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.graphdef.codegen;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.gmf.common.codegen.ImportAssistant;
import org.eclipse.gmf.common.codegen.NullImportAssistant;
import org.eclipse.gmf.gmfgraph.BorderLayout;
import org.eclipse.gmf.gmfgraph.BorderLayoutData;
import org.eclipse.gmf.gmfgraph.CustomLayout;
import org.eclipse.gmf.gmfgraph.CustomLayoutData;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FlowLayout;
import org.eclipse.gmf.gmfgraph.GridLayout;
import org.eclipse.gmf.gmfgraph.GridLayoutData;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.PolygonDecoration;
import org.eclipse.gmf.gmfgraph.Polyline;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.PolylineDecoration;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.gmfgraph.Shape;
import org.eclipse.gmf.gmfgraph.XYLayoutData;
import org.eclipse.gmf.gmfgraph.util.FigureQualifiedNameSwitch;
import org.eclipse.gmf.gmfgraph.util.GMFGraphSwitch;
import org.eclipse.gmf.graphdef.codegen.templates.CustomClassAttributesGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.FigureAttrGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.FigureChildrenGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.InitBorderLayoutDataGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.InitBorderLayoutGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.InitCustomLayoutDataGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.InitCustomLayoutGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.InitFlowLayoutGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.InitGridLayoutDataGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.InitGridLayoutGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.InitXYLayoutDataGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.LabelAttrGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.NewFigureGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.NewLayoutDataGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.NewLayoutGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.PolygonDecorationAttrGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.PolylineAttrGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.PolylineDecorationAttrGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.RoundedRectAttrGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.ShapeAttrGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.TopConnectionGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.TopFigureGenerator;
import org.eclipse.gmf.graphdef.codegen.templates.TopShapeGenerator;
import org.eclipse.gmf.internal.codegen.dispatch.EmitterFactory;
import org.eclipse.gmf.internal.codegen.dispatch.HierarchyKeyMap;
import org.eclipse.gmf.internal.codegen.dispatch.KeyChain;
import org.eclipse.gmf.internal.codegen.dispatch.KeyMap;
import org.eclipse.gmf.internal.codegen.dispatch.StaticTemplateRegistry;
import org.eclipse.gmf.internal.codegen.dispatch.TemplateRegistry;
import org.osgi.framework.Bundle;

/**
 * @author artem
 *
 */
public class FigureGenerator {
	private final String packageName;
	private GraphDefDispatcher myTopDispatcher;
	private GraphDefDispatcher myInnerDispatcher;

	public FigureGenerator() {
		this(null, new NullImportAssistant(), new FigureQualifiedNameSwitch());
	}

	public FigureGenerator(String aPackageName, ImportAssistant importManager, GMFGraphSwitch figureNameSwitch) {
		packageName = aPackageName;
		final Bundle thisBundle = Platform.getBundle("org.eclipse.gmf.graphdef.codegen");
		final String[] variables = new String[] {
				"org.eclipse.gmf.graphdef",
				"org.eclipse.emf.ecore",
				"org.eclipse.emf.common",
				"org.eclipse.gmf.common",
				"org.eclipse.gmf.graphdef.codegen"
		};

		KeyMap keyMap = new HierarchyKeyMap() {
			/*
			 * Capture knowledge that we use classes and strings as keys
			 */
			public KeyChain map(Object key) {
				if (key instanceof String) {
					return super.map(key);
				} else {
					return super.map(key.getClass());
				}
			}
		};
		EmitterFactory topFactory = new EmitterFactory(thisBundle.getEntry("/"), fillTopLevel(), true, variables, true);
		myTopDispatcher = new GraphDefDispatcher(topFactory, keyMap, importManager, figureNameSwitch);
		EmitterFactory innerFactory = new EmitterFactory(thisBundle.getEntry("/"), fillAttrs(), true, variables, true);
		myInnerDispatcher = new GraphDefDispatcher(innerFactory, keyMap, importManager, figureNameSwitch);
	}

	/**
	 * @return possibly <code>null</code>
	 */
	public String getPackageStatement() {
		return packageName;
	}

	private static TemplateRegistry fillTopLevel() {
		StaticTemplateRegistry tr = new StaticTemplateRegistry();
		tr.put(PolylineConnection.class, "/templates/PolylineConnection.javajet", TopConnectionGenerator.class);
		tr.put(Shape.class, "/templates/top/Shape.javajet", TopShapeGenerator.class);
		tr.put(Figure.class, "/templates/top/Figure.javajet", TopFigureGenerator.class);
		return tr;
	}
	
	// XXX NOTE, the fact we use "instantiate" and "Children" strings
	// helps us to postpone resolution of the next problem (one we make these twwo overridable):
	// it's not possible to tell from single dispatcher.dispatch(Figure, args) what's the intention - 
	// whether to instantiate, look for children or initialize attributes
	// Perhaps, we should have distinct methods in the Dispatcher, or add "hint" as another argument
	private static TemplateRegistry fillAttrs() {
		StaticTemplateRegistry tr = new StaticTemplateRegistry();
		tr.put(Figure.class, "/templates/attr/Figure.javajet", FigureAttrGenerator.class);
		tr.put(Shape.class, "/templates/attr/Shape.javajet", ShapeAttrGenerator.class);
		tr.put(Label.class, "/templates/attr/Label.javajet", LabelAttrGenerator.class);
		tr.put(Polyline.class, "/templates/attr/Polyline.javajet", PolylineAttrGenerator.class);
		tr.put(RoundedRectangle.class, "/templates/attr/RoundedRectangle.javajet", RoundedRectAttrGenerator.class);
		tr.put(PolygonDecoration.class, "/templates/attr/PolygonDecoration.javajet", PolygonDecorationAttrGenerator.class);
		tr.put(PolylineDecoration.class, "/templates/attr/PolylineDecoration.javajet", PolylineDecorationAttrGenerator.class);
		// instantiation templates - only single one now. FIXME - make it overridable
		tr.put("instantiate", "/templates/new/Figure.javajet", NewFigureGenerator.class);
		// children templates - only single one now. FIXME - make it overridable
		tr.put("Children", "/templates/children/Figure.javajet", FigureChildrenGenerator.class);
		// FIXME same template is registered twice
		tr.put("Shape", "/templates/attr/Shape.javajet", ShapeAttrGenerator.class);
		tr.put("Figure", "/templates/attr/Figure.javajet", FigureAttrGenerator.class);
		tr.put("PolylineDecoration", "/templates/attr/PolylineDecoration.javajet", PolylineDecorationAttrGenerator.class);

		// Custom attributes support
		tr.put("customAttributes", "/templates/attr/CustomConfigurableClass.javajet", CustomClassAttributesGenerator.class);
		// Layout related dispatching chain.  
		tr.put("createLayout", "/templates/new/Layout.javajet", NewLayoutGenerator.class);
		tr.put(GridLayout.class, "/templates/layout/GridLayout.javajet", InitGridLayoutGenerator.class);
		tr.put(BorderLayout.class, "/templates/layout/BorderLayout.javajet", InitBorderLayoutGenerator.class);
		tr.put(CustomLayout.class, "/templates/layout/CustomLayout.javajet", InitCustomLayoutGenerator.class);
		tr.put(FlowLayout.class, "/templates/layout/FlowLayout.javajet", InitFlowLayoutGenerator.class);
		
		tr.put("createLayoutData", "/templates/new/LayoutData.javajet", NewLayoutDataGenerator.class);
		tr.put(GridLayoutData.class, "/templates/layoutData/GridLayoutData.javajet", InitGridLayoutDataGenerator.class);
		tr.put(BorderLayoutData.class, "/templates/layoutData/BorderLayoutData.javajet", InitBorderLayoutDataGenerator.class);
		tr.put(CustomLayoutData.class, "/templates/layoutData/CustomLayoutData.javajet", InitCustomLayoutDataGenerator.class);
		tr.put(XYLayoutData.class, "/templates/layoutData/XYLayoutData.javajet", InitXYLayoutDataGenerator.class);
		return tr;
	}

	public String go(Figure fig) throws JETException {
		String res = null;
		Object args = new Object[] {fig, myTopDispatcher.getImportManager(), myTopDispatcher.getFQNSwitch(), myInnerDispatcher};
		res = myTopDispatcher.dispatch(fig, args);
		if (res == null) {
			throw new IllegalStateException();
		}
		return packageName == null ? res : "package " + packageName + ";\n" + res;
	}
}
