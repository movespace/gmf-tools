/*
 *  Copyright (c) 2006, 2007 Borland Software Corporation and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.providers;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.Polygon;
import org.eclipse.gmf.gmfgraph.Polyline;
import org.eclipse.gmf.graphdef.editor.expressions.GMFGraphAbstractExpression;
import org.eclipse.gmf.graphdef.editor.expressions.GMFGraphOCLFactory;
import org.eclipse.gmf.graphdef.editor.part.GMFGraphDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static void init_Polyline_3014(Polyline instance) {
		try {

			Point newInstance100 = GMFGraphFactory.eINSTANCE.createPoint();

			instance.getTemplate().add(newInstance100);
			Object value10100 = GMFGraphOCLFactory.getExpression("10", GMFGraphPackage.eINSTANCE.getPoint()).evaluate(newInstance100);

			value10100 = GMFGraphAbstractExpression.performCast(value10100, EcorePackage.eINSTANCE.getEInt());
			newInstance100.setX(((Integer) value10100).intValue());
			Object value10101 = GMFGraphOCLFactory.getExpression("10", GMFGraphPackage.eINSTANCE.getPoint()).evaluate(newInstance100);

			value10101 = GMFGraphAbstractExpression.performCast(value10101, EcorePackage.eINSTANCE.getEInt());
			newInstance100.setY(((Integer) value10101).intValue());

			Point newInstance101 = GMFGraphFactory.eINSTANCE.createPoint();

			instance.getTemplate().add(newInstance101);
			Object value10200 = GMFGraphOCLFactory.getExpression("30", GMFGraphPackage.eINSTANCE.getPoint()).evaluate(newInstance101);

			value10200 = GMFGraphAbstractExpression.performCast(value10200, EcorePackage.eINSTANCE.getEInt());
			newInstance101.setX(((Integer) value10200).intValue());
			Object value10201 = GMFGraphOCLFactory.getExpression("30", GMFGraphPackage.eINSTANCE.getPoint()).evaluate(newInstance101);

			value10201 = GMFGraphAbstractExpression.performCast(value10201, EcorePackage.eINSTANCE.getEInt());
			newInstance101.setY(((Integer) value10201).intValue());
		} catch (RuntimeException e) {
			GMFGraphDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Polygon_3023(Polygon instance) {
		try {

			Point newInstance100 = GMFGraphFactory.eINSTANCE.createPoint();

			instance.getTemplate().add(newInstance100);
			Object value10100 = GMFGraphOCLFactory.getExpression("10", GMFGraphPackage.eINSTANCE.getPoint()).evaluate(newInstance100);

			value10100 = GMFGraphAbstractExpression.performCast(value10100, EcorePackage.eINSTANCE.getEInt());
			newInstance100.setX(((Integer) value10100).intValue());
			Object value10101 = GMFGraphOCLFactory.getExpression("10", GMFGraphPackage.eINSTANCE.getPoint()).evaluate(newInstance100);

			value10101 = GMFGraphAbstractExpression.performCast(value10101, EcorePackage.eINSTANCE.getEInt());
			newInstance100.setY(((Integer) value10101).intValue());

			Point newInstance101 = GMFGraphFactory.eINSTANCE.createPoint();

			instance.getTemplate().add(newInstance101);
			Object value10200 = GMFGraphOCLFactory.getExpression("30", GMFGraphPackage.eINSTANCE.getPoint()).evaluate(newInstance101);

			value10200 = GMFGraphAbstractExpression.performCast(value10200, EcorePackage.eINSTANCE.getEInt());
			newInstance101.setX(((Integer) value10200).intValue());
			Object value10201 = GMFGraphOCLFactory.getExpression("30", GMFGraphPackage.eINSTANCE.getPoint()).evaluate(newInstance101);

			value10201 = GMFGraphAbstractExpression.performCast(value10201, EcorePackage.eINSTANCE.getEInt());
			newInstance101.setY(((Integer) value10201).intValue());

			Point newInstance102 = GMFGraphFactory.eINSTANCE.createPoint();

			instance.getTemplate().add(newInstance102);
			Object value10300 = GMFGraphOCLFactory.getExpression("10", GMFGraphPackage.eINSTANCE.getPoint()).evaluate(newInstance102);

			value10300 = GMFGraphAbstractExpression.performCast(value10300, EcorePackage.eINSTANCE.getEInt());
			newInstance102.setX(((Integer) value10300).intValue());
			Object value10301 = GMFGraphOCLFactory.getExpression("60", GMFGraphPackage.eINSTANCE.getPoint()).evaluate(newInstance102);

			value10301 = GMFGraphAbstractExpression.performCast(value10301, EcorePackage.eINSTANCE.getEInt());
			newInstance102.setY(((Integer) value10301).intValue());
		} catch (RuntimeException e) {
			GMFGraphDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}
}
