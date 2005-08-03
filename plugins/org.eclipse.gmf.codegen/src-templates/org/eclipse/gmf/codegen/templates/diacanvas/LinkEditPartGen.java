package org.eclipse.gmf.codegen.templates.diacanvas;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class LinkEditPartGen
{
  protected static String nl;
  public static synchronized LinkEditPartGen create(String lineSeparator)
  {
    nl = lineSeparator;
    LinkEditPartGen result = new LinkEditPartGen();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "import org.eclipse.draw2d.*;" + NL + "import org.eclipse.emf.ecore.EAttribute;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.*;" + NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gef.editparts.*;" + NL + "import org.eclipse.gef.editpolicies.*;" + NL + "import org.eclipse.gef.requests.DirectEditRequest;" + NL + "import org.eclipse.gef.requests.GroupRequest;" + NL + "import org.eclipse.gef.tools.DirectEditManager;" + NL + "import org.eclipse.gmf.diagramrt.DiagramLink;" + NL + "import org.eclipse.gmf.runtime.gef.DefaultDirectEditManager;" + NL + "import org.eclipse.gmf.runtime.gef.commands.ChangeDiagramElementNameCommand;" + NL + "import org.eclipse.gmf.runtime.gef.commands.DeleteDiagramLinkCommand;" + NL + "import org.eclipse.swt.graphics.Font;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends AbstractConnectionEditPart {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_6 = ";" + NL;
  protected final String TEXT_7 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected DirectEditManager myManager;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure myLabelFigure;" + NL;
  protected final String TEXT_8 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_9 = "(DiagramLink model) {" + NL + "\t\tsetModel(model);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {" + NL + "\t\tinstallEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());" + NL + "\t\tinstallEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {" + NL + "\t\t\tprotected Command getDeleteCommand(GroupRequest request) {" + NL + "\t\t\t\t// TODO perhaps, request.getEditParts().getModel()?" + NL + "\t\t\t\treturn new DeleteDiagramLinkCommand(getDiagramLink());" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_10 = NL + "\t\tinstallEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, createDirectEditPolicy());";
  protected final String TEXT_11 = NL + "\t\t// installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new BendpointEditPolicy() {});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createFigure() {" + NL + "\t\tPolylineConnection conn = createConnectionFigure();";
  protected final String TEXT_12 = NL + "\t\tconn.setLineStyle(Graphics.";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\tconn.setSourceDecoration(new ";
  protected final String TEXT_15 = "()); ";
  protected final String TEXT_16 = NL + "\t\tconn.setTargetDecoration(new ";
  protected final String TEXT_17 = "()); ";
  protected final String TEXT_18 = NL + "\t\tif (getDiagramLink().getForegroundColor() == null) {" + NL + "\t\t\t// set default color from genmodel" + NL + "\t\t\t// XXX no 'if' check? set color from genModel if any, and allow refreshColors to override later?" + NL + "\t\t\tconn.setForegroundColor(getColorSupport().get(\"";
  protected final String TEXT_19 = "\"));" + NL + "\t\t}";
  protected final String TEXT_20 = NL + "\t\tconn.add(getLabelFigure(), createLabelConstraint(conn));";
  protected final String TEXT_21 = NL + "\t\trefreshColors(conn);" + NL + "\t\treturn conn;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected PolylineConnection createConnectionFigure() {" + NL + "\t\treturn new ";
  protected final String TEXT_22 = "();" + NL + "\t}" + NL;
  protected final String TEXT_23 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object createLabelConstraint(Connection conn) {" + NL + "\t\tConnectionLocator cl = new ConnectionLocator(conn, ConnectionLocator.MIDDLE);" + NL + "\t\tcl.setRelativePosition(PositionConstants.NORTH_EAST);" + NL + "\t\tcl.setGap(2);" + NL + "\t\treturn cl;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected final IFigure getLabelFigure() {" + NL + "\t\tif (myLabelFigure == null) {" + NL + "\t\t\tmyLabelFigure = createLabelFigure();" + NL + "\t\t}" + NL + "\t\treturn myLabelFigure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createLabelFigure() {" + NL + "\t\treturn new Label(getLabelText());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\tEObject owner = getDiagramLink().getDomainModelElement();" + NL + "\t\tif (owner == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn String.valueOf(owner.eGet(getLabelFeature()));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EAttribute getLabelFeature() {";
  protected final String TEXT_24 = NL + "\t\treturn ";
  protected final String TEXT_25 = ".eINSTANCE.get";
  protected final String TEXT_26 = "();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EditPolicy createDirectEditPolicy() {" + NL + "\t\treturn new DirectEditPolicy() {" + NL + "\t\t\tprotected Command getDirectEditCommand(DirectEditRequest request) {" + NL + "\t\t\t\tEAttribute domainNameFeature = (EAttribute) request.getDirectEditFeature();" + NL + "\t\t\t\tif (domainNameFeature == null) {" + NL + "\t\t\t\t\tSystem.err.println(\"Someone passes DirectEditRequest without directEditFeature set\");" + NL + "\t\t\t\t\tdomainNameFeature = getLabelFeature();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new ChangeDiagramElementNameCommand(getDiagramLink(), domainNameFeature,(String) request.getCellEditor().getValue());" + NL + "\t\t\t}" + NL + "\t\t\tprotected void showCurrentEditValue(DirectEditRequest request) {" + NL + "\t\t\t\tIFigure fig = getLabelFigure();" + NL + "\t\t\t\tif (fig instanceof Label) {" + NL + "\t\t\t\t\t((Label)fig).setText((String)request.getCellEditor().getValue());" + NL + "\t\t\t\t\tfig.getUpdateManager().performUpdate();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tif(myManager == null) {" + NL + "\t\t\tmyManager = new DefaultDirectEditManager(this, new DefaultDirectEditManager.DirectEditInfoProvider() {" + NL + "\t\t\t\tpublic Object getDirectEditFeature() {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_27 = ".eINSTANCE.get";
  protected final String TEXT_28 = "();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic String getInitialText() {" + NL + "\t\t\t\t\treturn String.valueOf(getDiagramLink().getDomainModelElement().eGet(getLabelFeature()));" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic IFigure getDirectEditFigure() {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_29 = ".this.getLabelFigure();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic Font getTextFont() {" + NL + "\t\t\t\t\treturn getLabelFigure().getFont();" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t}" + NL + "\t\tmyManager.show();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(Request request) {" + NL + "\t\tif (request.getType() == RequestConstants.REQ_DIRECT_EDIT) {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t} else {" + NL + "\t\t\tsuper.performRequest(request);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_30 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\t// FIXME placeholder for attaching listener to model object, e.g.:" + NL + "\t\t// ((Notifier) getModel()).eAdapters().add(myListener)" + NL + "\t\t// perhaps, for perfomance reasons it's better to have single listener" + NL + "\t\t// (e.g. diagram attaches one to domain model) and then request updates" + NL + "\t\t// of editParts (as maping of model element to edit part is known to diagram)" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic DiagramLink getDiagramLink() {" + NL + "\t\treturn (DiagramLink) getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\trefreshColors(getFigure());" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshColors(IFigure fig) {" + NL + "\t\tif (getDiagramLink().getForegroundColor() != null) {" + NL + "\t\t\tfig.setForegroundColor(getColorSupport().get(getDiagramLink().getForegroundColor()));" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_31 = " getColorSupport() {" + NL + "\t\treturn ((";
  protected final String TEXT_32 = ") getRoot().getContents()).getColorSupport();" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenLink genLink = (GenLink) argument;
    GenDiagram genDiagram = genLink.getDiagram();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_6);
    if (genLink.hasNameToEdit()) {
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_9);
    if (genLink.hasNameToEdit()) {
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    if (genLink.getLineStyle() != null) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genLink.getLineStyle());
    stringBuffer.append(TEXT_13);
    
}
if (genLink.getSourceDecorationFigureQualifiedClassName() != null && genLink.getSourceDecorationFigureQualifiedClassName().trim().length() != 0) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genLink.getSourceDecorationFigureQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    
}
if (genLink.getTargetDecorationFigureQualifiedClassName() != null && genLink.getTargetDecorationFigureQualifiedClassName().trim().length() != 0) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(genLink.getTargetDecorationFigureQualifiedClassName()));
    stringBuffer.append(TEXT_17);
    }
    if (genLink.getForegroundColor() != null) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genLink.getForegroundColor());
    stringBuffer.append(TEXT_19);
    }
    if (genLink.hasNameToEdit()) {
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(genLink.getFigureQualifiedClassName()));
    stringBuffer.append(TEXT_22);
    if (genLink.hasNameToEdit()) {
    stringBuffer.append(TEXT_23);
    
final GenFeature genFeature = genDiagram.findGenFeature(genLink.getDomainNameFeature());
final String metaPackageInterfaceName = importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_24);
    stringBuffer.append(metaPackageInterfaceName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(metaPackageInterfaceName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ColorSupport"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
