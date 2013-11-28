package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies.CompartmentsTextSelectionEditPolicy;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies.TopNodeBCanonicalEditPolicy;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies.TopNodeBItemSemanticEditPolicy;
import org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class TopNodeBEditPart extends AbstractBorderedShapeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2002;

	/**
	* @generated
	*/
	protected IFigure contentPane;

	/**
	* @generated
	*/
	protected IFigure primaryShape;

	/**
	* @generated
	*/
	public TopNodeBEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(CompartmentsVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new TopNodeBItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new TopNodeBCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	* @generated
	*/
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (CompartmentsVisualIDRegistry.getVisualID(childView)) {
				case ChildOfB_GEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy();
				}
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new CompartmentsTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	}

	/**
	* @generated
	*/
	protected IFigure createNodeShape() {
		return primaryShape = new NodeBFigure();
	}

	/**
	* @generated
	*/
	public NodeBFigure getPrimaryShape() {
		return (NodeBFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TopNodeBNameEditPart) {
			((TopNodeBNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureNodeBNameFigure());
			return true;
		}
		if (childEditPart instanceof TopNodeBNodeECompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureNodeEListCompFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((TopNodeBNodeECompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof TopNodeBNodeFCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureNodeFListCompFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((TopNodeBNodeFCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ChildOfB_GEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH);
			getBorderedFigure().getBorderItemContainer().add(((ChildOfB_GEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TopNodeBNameEditPart) {
			return true;
		}
		if (childEditPart instanceof TopNodeBNodeECompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureNodeEListCompFigure();
			pane.remove(((TopNodeBNodeECompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof TopNodeBNodeFCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureNodeFListCompFigure();
			pane.remove(((TopNodeBNodeFCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ChildOfB_GEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ChildOfB_GEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	* @generated
	*/
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	* @generated
	*/
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof TopNodeBNodeECompartmentEditPart) {
			return getPrimaryShape().getFigureNodeEListCompFigure();
		}
		if (editPart instanceof TopNodeBNodeFCompartmentEditPart) {
			return getPrimaryShape().getFigureNodeFListCompFigure();
		}
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	* @generated
	*/
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	* Creates figure for this edit part.
	* 
	* Body of this method does not depend on settings in generation model
	* so you may safely remove <i>generated</i> tag and modify it.
	* 
	* @generated
	*/
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	* Default implementation treats passed figure as content pane.
	* Respects layout one may have set for generated figure.
	* @param nodeShape instance of generated figure class
	* @generated
	*/
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	* @generated
	*/
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	* @generated
	*/
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	* @generated
	*/
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	* @generated
	*/
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(CompartmentsVisualIDRegistry.getType(TopNodeBNameEditPart.VISUAL_ID));
	}

	/**
	* @generated
	*/
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == CompartmentsElementTypes.ChildOfB_E_3003) {
				return getChildBySemanticHint(CompartmentsVisualIDRegistry.getType(TopNodeBNodeECompartmentEditPart.VISUAL_ID));
			}
			if (type == CompartmentsElementTypes.ChildOfB_F_3006) {
				return getChildBySemanticHint(CompartmentsVisualIDRegistry.getType(TopNodeBNodeFCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class NodeBFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fFigureNodeEListCompFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureNodeBNameFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureNodeFListCompFigure;

		/**
		 * @generated
		 */
		public NodeBFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutThis.setSpacing(5);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setBorder(new MarginBorder(4, 4, 4, 4));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureNodeBNameFigure = new WrappingLabel();

			fFigureNodeBNameFigure.setText("NodeB");

			this.add(fFigureNodeBNameFigure);

			fFigureNodeEListCompFigure = new RectangleFigure();

			fFigureNodeEListCompFigure.setForegroundColor(ColorConstants.lightGreen);

			this.add(fFigureNodeEListCompFigure);

			fFigureNodeFListCompFigure = new RectangleFigure();

			fFigureNodeFListCompFigure.setForegroundColor(ColorConstants.lightBlue);

			this.add(fFigureNodeFListCompFigure);

		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureNodeEListCompFigure() {
			return fFigureNodeEListCompFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNodeBNameFigure() {
			return fFigureNodeBNameFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureNodeFListCompFigure() {
			return fFigureNodeFListCompFigure;
		}

	}

}
