package org.eclipse.gmf.codegen.templates.diacanvas;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class NodeEditPartGen
{
  protected static String nl;
  public static synchronized NodeEditPartGen create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeEditPartGen result = new NodeEditPartGen();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "import java.util.*;" + NL + "import org.eclipse.draw2d.*;" + NL + "import org.eclipse.emf.edit.domain.*;" + NL + "import org.eclipse.emf.edit.provider.IItemLabelProvider;" + NL + "import org.eclipse.emf.ecore.EAttribute;" + NL + "import org.eclipse.gef.*;" + NL + "import org.eclipse.gef.commands.*;" + NL + "import org.eclipse.gef.editparts.*;" + NL + "import org.eclipse.gef.editpolicies.*;" + NL + "import org.eclipse.gef.requests.*;" + NL + "import org.eclipse.gef.tools.*;";
  protected final String TEXT_4 = NL + "import org.eclipse.gmf.runtime.gef.DefaultDirectEditManager;" + NL + "import org.eclipse.gmf.runtime.gef.CompartmentsContentPane;" + NL + "import org.eclipse.gmf.runtime.gef.commands.ChangeDiagramElementNameCommand;" + NL + "import org.eclipse.gmf.runtime.gef.commands.CreateChildNodeCommand;" + NL + "import org.eclipse.gmf.runtime.gef.commands.CreateDiagramLinkCommand;" + NL + "import org.eclipse.gmf.runtime.gef.commands.DeleteDiagramNodeCommand;" + NL + "import org.eclipse.gmf.runtime.update.UpdatablePart;" + NL + "import org.eclipse.swt.graphics.Image;" + NL + "import org.eclipse.swt.graphics.Font;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractGraphicalEditPart implements org.eclipse.gef.NodeEditPart, UpdatablePart {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_7 = ";";
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected DirectEditManager myManager;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure myDirectEditFigure;";
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate CompartmentsContentPane myContentPane;";
  protected final String TEXT_10 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ConnectionAnchor myAnchor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_11 = "(DiagramNode model) {" + NL + "\t\tsetModel(model);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {" + NL + "\t\t// super.createEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutPolicy());" + NL + "\t\tinstallEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, createGraphicalNodePolicy());" + NL + "\t\tinstallEditPolicy(EditPolicy.COMPONENT_ROLE, createComponentPolicy());";
  protected final String TEXT_12 = NL + "\t\tinstallEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, createDirectEditPolicy());";
  protected final String TEXT_13 = NL + "\t\tinstallEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, createSelectionFeedbackPolicy());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EditPolicy createSelectionFeedbackPolicy() {" + NL + "\t\treturn new ResizableEditPolicy() {" + NL + "\t\t\tprotected IFigure createDragSourceFeedbackFigure() {" + NL + "\t\t\t\tIFigure feedback = super.createDragSourceFeedbackFigure();" + NL + "\t\t\t\tfeedback.setForegroundColor(ColorConstants.darkGray);" + NL + "\t\t\t\treturn feedback;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EditPolicy createComponentPolicy() {" + NL + "\t\treturn new ComponentEditPolicy() {" + NL + "\t\t\tprotected Command createDeleteCommand(GroupRequest deleteRequest) {" + NL + "\t\t\t\t// FIXME deleteRequest is GroupRequest. Should I respect editPart(s!) from request" + NL + "\t\t\t\t// rather then taking model of this editPart?" + NL + "\t\t\t\tif (deleteRequest.getEditParts().size() != 1 && deleteRequest.getEditParts().get(0) != getDiagramNode()) {" + NL + "\t\t\t\t\tSystem.err.println(\"WARNING: needs fix!\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new DeleteDiagramNodeCommand(getDiagramNode());" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EditPolicy createLayoutPolicy() {" + NL + "\t\treturn new LayoutEditPolicy() {" + NL + "\t\t\tprotected EditPolicy createChildEditPolicy(EditPart child) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command getCreateCommand(CreateRequest request) {" + NL + "\t\t\t\tif (request.getNewObjectType() != ChildNode.class) {" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tChildNode childNode = (ChildNode) request.getNewObject();" + NL + "\t\t\t\t// FIXME get feature from compartment definition, GenChildContainer.childFeatures" + NL + "\t\t\t\t// foreach (cn : genNode.childNode)" + NL + "\t\t\t\t// if cn.getDomainMetaClass == childNode.getDomainElement().eClass()) feature = cn.childFeature" + NL + "\t\t\t\treturn new CreateChildNodeCommand(childNode, getDiagramNode());" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command getDeleteDependantCommand(Request request) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command getMoveChildrenCommand(Request request) {" + NL + "\t\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tprotected void showLayoutTargetFeedback(Request request) {" + NL + "\t\t\t\tif (myLayoutFeedback != null) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tmyLayoutFeedback = createLayoutFeedback();" + NL + "\t\t\t\taddFeedback(myLayoutFeedback);" + NL + "\t\t\t}" + NL + "\t\t\tprotected void eraseLayoutTargetFeedback(Request request) {" + NL + "\t\t\t\tremoveFeedback(myLayoutFeedback);" + NL + "\t\t\t\tmyLayoutFeedback = null;" + NL + "\t\t\t}" + NL + "\t\t\tprivate IFigure createLayoutFeedback() {" + NL + "\t\t\t\tRectangleFigure result = new RectangleFigure();" + NL + "\t\t\t\tresult.setFill(false);" + NL + "\t\t\t\tresult.setBounds(getHostFigure().getBounds().getExpanded(5, 5));" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t\tprivate IFigure myLayoutFeedback;" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EditPolicy createGraphicalNodePolicy() {" + NL + "\t\treturn new GraphicalNodeEditPolicy() {" + NL + "\t\t\tprotected Command getConnectionCompleteCommand(CreateConnectionRequest request) {" + NL + "\t\t\t\tCreateDiagramLinkCommand cmd = (CreateDiagramLinkCommand) request.getStartCommand();" + NL + "\t\t\t\tcmd.setTargetNode(getDiagramNode());" + NL + "\t\t\t\treturn cmd;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command getConnectionCreateCommand(CreateConnectionRequest request) {" + NL + "\t\t\t\tif (request.getNewObjectType() != DiagramLink.class) {" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tDiagramLink diagramLink = (DiagramLink) request.getNewObject();" + NL + "\t\t\t\tCommand cmd = new CreateDiagramLinkCommand(diagramLink, getDiagramNode());" + NL + "\t\t\t\trequest.setStartCommand(cmd);" + NL + "\t\t\t\treturn cmd;" + NL + "\t\t\t\t// The disallow cursor will be shown IFF you return null" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command getReconnectSourceCommand(ReconnectRequest request) {" + NL + "\t\t\t\treturn null; // TODO" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command getReconnectTargetCommand(ReconnectRequest request) {" + NL + "\t\t\t\treturn null; // TODO" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createFigure() {";
  protected final String TEXT_14 = NL + "\t\tIFigure r = ";
  protected final String TEXT_15 = ".create(\"";
  protected final String TEXT_16 = "\", \"";
  protected final String TEXT_17 = "\");";
  protected final String TEXT_18 = NL + "\t\tRoundedRectangle r = new RoundedRectangle() {";
  protected final String TEXT_19 = NL + "\t\tRectangleFigure r = new RectangleFigure() {";
  protected final String TEXT_20 = NL + "\t\tEllipse r = new Ellipse() {";
  protected final String TEXT_21 = NL + "\t\tTriangle r = new Triangle() {";
  protected final String TEXT_22 = NL + "\t\t\tprotected void fillShape(Graphics graphics) {" + NL + "\t\t\t\tgraphics.pushState();" + NL + "\t\t\t\tgraphics.setForegroundColor(getColorSupport().get(\"130,245,255\")); //88, 210, 245" + NL + "\t\t\t\tgraphics.fillGradient(getBounds(), true);" + NL + "\t\t\t\tgraphics.popState();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tr.setLineWidth(2);";
  protected final String TEXT_23 = NL + "\t\tLabel r = new Label();";
  protected final String TEXT_24 = NL + "\t\tr.setLocation(getDiagramNode().getLocation());" + NL + "\t\tif (getDiagramNode().getSize().isEmpty()) {" + NL + "\t\t\tr.setSize(100, 50);" + NL + "\t\t} else {" + NL + "\t\t\tr.setSize(getDiagramNode().getSize());" + NL + "\t\t}" + NL + "\t\tr.setBorder(new MarginBorder(0, 5, 0, 5));";
  protected final String TEXT_25 = NL + "\t\tif (getDiagramNode().getForegroundColor() == null) {" + NL + "\t\t\t// set default color, defined in genmodel" + NL + "\t\t\tr.setForegroundColor(getColorSupport().get(\"";
  protected final String TEXT_26 = "\"));" + NL + "\t\t}";
  protected final String TEXT_27 = NL + "\t\tif (getDiagramNode().getBackgroundColor() == null) {" + NL + "\t\t\tr.setBackgroundColor(getColorSupport().get(\"";
  protected final String TEXT_28 = "\"));" + NL + "\t\t}";
  protected final String TEXT_29 = NL + "\t\trefreshColors(r);";
  protected final String TEXT_30 = NL + "\t\tr.setLayoutManager(new ToolbarLayout());";
  protected final String TEXT_31 = NL + "\t\tLabel stereotypes = new Label();";
  protected final String TEXT_32 = NL + "\t\tstereotypes.setText(\"";
  protected final String TEXT_33 = "\");" + NL + "\t\tstereotypes.setFont(";
  protected final String TEXT_34 = ".getFontRegistry().getItalic(JFaceResources.TEXT_FONT));" + NL + "\t\tr.add(stereotypes);";
  protected final String TEXT_35 = NL + "\t\tr.add(getDirectEditFigure());";
  protected final String TEXT_36 = NL + "\t\t// XXX actually, content pane should be added with some constraint, " + NL + "\t\t// not necessarily as the last figure. " + NL + "\t\tmyContentPane = createContentPane();" + NL + "\t\tr.add(myContentPane);";
  protected final String TEXT_37 = NL + "\t\treturn r;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic DiagramNode getDiagramNode() {" + NL + "\t\treturn (DiagramNode) getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tvisualPropertiesChanged();" + NL + "\t\tboundsChanged();" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t}" + NL + "" + NL + "\t// XXX TODO? introduce ChangeColorRequest() with appropriate command to handle? With EditPolicy/handleRequest?" + NL + "\t// (+) undo, unified, (-) nothing, really." + NL + "\t// ??? Request/policy? Enough to have command?" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshColors(IFigure fig) {" + NL + "\t\tif (getDiagramNode().getForegroundColor() != null) {" + NL + "\t\t\tfig.setForegroundColor(getColorSupport().get(getDiagramNode().getForegroundColor()));" + NL + "\t\t}" + NL + "\t\tif (getDiagramNode().getBackgroundColor() != null) {" + NL + "\t\t\tfig.setBackgroundColor(getColorSupport().get(getDiagramNode().getBackgroundColor()));" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_38 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelChildren() {" + NL + "\t\treturn getDiagramNode().getChildNodes();" + NL + "\t}";
  protected final String TEXT_39 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected CompartmentsContentPane createContentPane() {" + NL + "\t\tCompartmentsContentPane contentPane = new CompartmentsContentPane();" + NL + "\t\t// if (genNode.childContainersPlacement == TOOLBAR) {" + NL + "\t\tcontentPane.setLayoutManager(new ToolbarLayout());" + NL + "\t\t// } else {" + NL + "\t\t//contentPane.setLayoutManager(new FlowLayout());" + NL + "\t\t//}" + NL + "\t\tIFigure compartment;";
  protected final String TEXT_40 = NL + "\t\tcompartment = createCompartment(\"";
  protected final String TEXT_41 = "\");" + NL + "\t\t" + NL + "\t\t// if childContainer.needsLabel() {" + NL + "\t\t// compartment.setLabel(childContainer.titleKey);" + NL + "\t\t//}" + NL + "\t\t// compartment.setCollapse(childContainer.canCollapse);" + NL + "\t\t// compartment.setHideEmpty(childContainer.hideIfEmpty);" + NL + "\t\t// switch (compartment.layoutKind)" + NL + "\t\tcompartment.setLayoutManager(new ToolbarLayout());" + NL + "\t\tcontentPane.register(\"";
  protected final String TEXT_42 = "\", compartment);";
  protected final String TEXT_43 = NL + "\t\treturn contentPane;" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createCompartment(String title) {" + NL + "\t\tLabeledContainer r = new LabeledContainer();" + NL + "\t\tr.setLabel(title);" + NL + "\t\tr.setOpaque(false);" + NL + "\t\treturn r;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(EditPart childEditPart, int index) {" + NL + "\t\tChildNode model = (ChildNode) childEditPart.getModel();" + NL + "\t\tIFigure child = ((GraphicalEditPart)childEditPart).getFigure();" + NL + "\t\tmyContentPane.addChildVisual(model.getGroupID(), child, index);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeChildVisual(EditPart childEditPart) {" + NL + "\t\tChildNode model = (ChildNode) childEditPart.getModel();" + NL + "\t\tIFigure child = ((GraphicalEditPart)childEditPart).getFigure();" + NL + "\t\tmyContentPane.removeChildVisual(model.getGroupID(), child);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getContentPane() {" + NL + "\t\treturn myContentPane;" + NL + "\t}";
  protected final String TEXT_44 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelSourceConnections() {" + NL + "\t\treturn getDiagramNode().getOutgoingLinks();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelTargetConnections() {" + NL + "\t\treturn getDiagramNode().getIncomingLinks();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void boundsChanged() {" + NL + "\t\tgetFigure().setLocation(getDiagramNode().getLocation());" + NL + "\t\tgetFigure().setSize(getDiagramNode().getSize());" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void visualPropertiesChanged() {" + NL + "\t\trefreshColors(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void structuralPropertiesChanged() {" + NL + "\t\trefreshChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void incomingLinksChanged() {" + NL + "\t\trefreshTargetConnections();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void outgoingLinksChanged() {" + NL + "\t\trefreshSourceConnections();" + NL + "\t}" + NL;
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createDirectEditFigure() {" + NL + "\t\t// FIXME reuse getInitialText" + NL + "\t\treturn new Label(String.valueOf(getDiagramNode().getDomainModelElement().eGet(getDefaultNameFeature())), getImage());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Image getImage() {" + NL + "\t\tEditingDomain ed = AdapterFactoryEditingDomain.getEditingDomainFor(getDiagramNode().getDomainModelElement());" + NL + "\t\t// XXX it's our way to get adapter factory without initializing it right here. Is there better way?" + NL + "\t\tif (ed instanceof AdapterFactoryEditingDomain) {" + NL + "\t\t\tIItemLabelProvider labelProvider = (IItemLabelProvider) ((AdapterFactoryEditingDomain) ed).getAdapterFactory().adapt(getDiagramNode().getDomainModelElement(), IItemLabelProvider.class);" + NL + "\t\t\tif (labelProvider != null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_47 = ".getInstance().getImage(labelProvider.getImage(getDiagramNode().getDomainModelElement()));" + NL + "\t\t\t}" + NL + "\t\t\t// else fall through" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure getDirectEditFigure() {" + NL + "\t\tif (myDirectEditFigure == null) {" + NL + "\t\t\tmyDirectEditFigure = createDirectEditFigure();" + NL + "\t\t}" + NL + "\t\treturn myDirectEditFigure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EditPolicy createDirectEditPolicy() {" + NL + "\t\treturn new DirectEditPolicy() {" + NL + "\t\t\tprotected Command getDirectEditCommand(DirectEditRequest request) {" + NL + "\t\t\t\tEAttribute domainNameFeature = (EAttribute) request.getDirectEditFeature();" + NL + "\t\t\t\tif (domainNameFeature == null) {" + NL + "\t\t\t\t\tSystem.err.println(\"Someone passes DirectEditRequest without directEditFeature set\");" + NL + "\t\t\t\t\tdomainNameFeature = getDefaultNameFeature();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new ChangeDiagramElementNameCommand(getDiagramNode(), domainNameFeature,(String) request.getCellEditor().getValue());" + NL + "\t\t\t}" + NL + "\t\t\tprotected void showCurrentEditValue(DirectEditRequest request) {" + NL + "\t\t\t\tIFigure fig = getDirectEditFigure();" + NL + "\t\t\t\tif (fig instanceof Label) {" + NL + "\t\t\t\t\t((Label)fig).setText((String)request.getCellEditor().getValue());" + NL + "\t\t\t\t\tfig.getUpdateManager().performUpdate();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tif(myManager == null) {" + NL + "\t\t\tmyManager = new DefaultDirectEditManager(this, new DefaultDirectEditManager.DirectEditInfoProvider() {" + NL + "\t\t\t\tpublic Object getDirectEditFeature() {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_48 = ".eINSTANCE.get";
  protected final String TEXT_49 = "();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic String getInitialText() {" + NL + "\t\t\t\t\treturn String.valueOf(getDiagramNode().getDomainModelElement().eGet((EAttribute) getDirectEditFeature()));" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic IFigure getDirectEditFigure() {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_50 = ".this.getDirectEditFigure();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic Font getTextFont() {" + NL + "\t\t\t\t\treturn getDirectEditFigure().getFont();" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t}" + NL + "\t\tmyManager.show();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(Request request) {" + NL + "\t\tif (request.getType() == RequestConstants.REQ_DIRECT_EDIT) {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t} else {" + NL + "\t\t\tsuper.performRequest(request);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EAttribute getDefaultNameFeature() {" + NL + "\t\treturn ";
  protected final String TEXT_51 = ".eINSTANCE.get";
  protected final String TEXT_52 = "();" + NL + "\t}";
  protected final String TEXT_53 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart arg0) {" + NL + "\t\treturn getAnchor();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart arg0) {" + NL + "\t\treturn getAnchor();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ConnectionAnchor getSourceConnectionAnchor(Request arg0) {" + NL + "\t\treturn getAnchor();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ConnectionAnchor getTargetConnectionAnchor(Request arg0) {" + NL + "\t\treturn getAnchor();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_54 = " getColorSupport() {" + NL + "\t\treturn ((";
  protected final String TEXT_55 = ") getRoot().getContents()).getColorSupport();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ConnectionAnchor getAnchor() {" + NL + "\t\tif (myAnchor == null) {" + NL + "\t\t\tmyAnchor = new ChopboxAnchor(getFigure());" + NL + "\t\t}" + NL + "\t\treturn myAnchor;" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNode genNode = (GenNode) argument;
GenDiagram genDiagram = genNode.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.addImport("org.eclipse.gmf.diagramrt.*");
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_7);
    if (genNode.hasNameToEdit()) {
    stringBuffer.append(TEXT_8);
    }
    if (!genNode.getChildContainers().isEmpty()) {
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_11);
    if (genNode.hasNameToEdit()) {
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    if (genNode.getViewmapURI() != null) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.diagramrt.gefsvg.SVGShapeFactory"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genDiagram.getPluginID());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genNode.getViewmapURI());
    stringBuffer.append(TEXT_17);
    } else {
    if (genNode.getNodeVisualizationKind() == 1) {
    stringBuffer.append(TEXT_18);
    }
    if (genNode.getNodeVisualizationKind() == 2) {
    stringBuffer.append(TEXT_19);
    }
    if (genNode.getNodeVisualizationKind() == 3) {
    stringBuffer.append(TEXT_20);
    }
    if (genNode.getNodeVisualizationKind() == 4) {
    stringBuffer.append(TEXT_21);
    }
    if (genNode.getNodeVisualizationKind() > 0 && genNode.getNodeVisualizationKind() < 5) {
    stringBuffer.append(TEXT_22);
    }
    if (genNode.getNodeVisualizationKind() == 5) {
    stringBuffer.append(TEXT_23);
    }
    }
    stringBuffer.append(TEXT_24);
    if (genNode.getForegroundColor() != null) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genNode.getForegroundColor());
    stringBuffer.append(TEXT_26);
    }
    if (genNode.getBackgroundColor() != null) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genNode.getBackgroundColor());
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    if (genNode.hasNameToEdit() || !genNode.getAffixedStereotypes().isEmpty()) {
    stringBuffer.append(TEXT_30);
    }
    if (!genNode.getAffixedStereotypes().isEmpty()) {
    stringBuffer.append(TEXT_31);
    
StringBuffer sb = new StringBuffer();
sb.append('<');
for (Iterator it = genNode.getAffixedStereotypes().iterator(); it.hasNext();) { 
	sb.append(it.next());
	sb.append(',');
}
sb.deleteCharAt(sb.length() - 1);
sb.append('>');

    stringBuffer.append(TEXT_32);
    stringBuffer.append(sb.toString());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.JFaceResources"));
    stringBuffer.append(TEXT_34);
    }
    if (genNode.hasNameToEdit()) {
    stringBuffer.append(TEXT_35);
    }
    if (!genNode.getChildContainers().isEmpty()) {
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    if (!genNode.getChildNodes().isEmpty()) {
    stringBuffer.append(TEXT_38);
    }
    if (!genNode.getChildContainers().isEmpty() /* production: && !genNode.getChildNodes().isEmpty()*/) {
    stringBuffer.append(TEXT_39);
    for (Iterator it = genNode.getChildContainers().iterator(); it.hasNext();) {
		GenChildContainer childContainer = (GenChildContainer) it.next();

    stringBuffer.append(TEXT_40);
    stringBuffer.append(childContainer.getTitleKey());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(childContainer.getGroupID());
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    if (genNode.hasNameToEdit()) {
    stringBuffer.append(TEXT_45);
    
	GenFeature genFeature = genDiagram.findGenFeature(genNode.getDomainNameFeature());
	String metaPackageInterfaceName = importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(metaPackageInterfaceName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(metaPackageInterfaceName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ColorSupport"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_55);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
