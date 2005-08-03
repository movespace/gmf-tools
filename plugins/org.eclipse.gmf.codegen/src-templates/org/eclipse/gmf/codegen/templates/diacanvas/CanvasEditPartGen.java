package org.eclipse.gmf.codegen.templates.diacanvas;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class CanvasEditPartGen
{
  protected static String nl;
  public static synchronized CanvasEditPartGen create(String lineSeparator)
  {
    nl = lineSeparator;
    CanvasEditPartGen result = new CanvasEditPartGen();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "import java.util.List;" + NL + "import java.util.Map;" + NL + "import org.eclipse.draw2d.*;" + NL + "import org.eclipse.draw2d.geometry.Dimension;" + NL + "import org.eclipse.draw2d.geometry.Point;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.util.EContentAdapter;" + NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.gef.*;" + NL + "import org.eclipse.gef.commands.*;" + NL + "import org.eclipse.gef.editparts.*;" + NL + "import org.eclipse.gef.editpolicies.*;" + NL + "import org.eclipse.gef.requests.ChangeBoundsRequest;" + NL + "import org.eclipse.gef.requests.CreateRequest;" + NL + "import org.eclipse.gmf.diagramrt.*;" + NL + "import org.eclipse.gmf.runtime.gef.commands.CreateDiagramNodeCommand;" + NL + "import org.eclipse.gmf.runtime.gef.commands.ChangeNodeBoundsCommand;" + NL + "import org.eclipse.gmf.runtime.update.DiagramUpdateManager;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends AbstractGraphicalEditPart {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final ";
  protected final String TEXT_6 = " myColorSupport;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final DiagramUpdateManager myDiagramListener = new DiagramUpdateManager() {" + NL + "\t\tprotected Map getEditPartRegistry() {" + NL + "\t\t\treturn getViewer().getEditPartRegistry();" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_7 = "(DiagramCanvas model) {" + NL + "\t\tsetModel(model);" + NL + "\t\tmyColorSupport = new ";
  protected final String TEXT_8 = "();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {" + NL + "\t\tinstallEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());" + NL + "\t\tinstallEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {" + NL + "\t\t\t// " + NL + "\t\t\t// FIXME !!! " + NL + "\t\t\t//" + NL + "\t\t\tprotected Command createAddCommand(EditPart child, Object constraint) {" + NL + "\t\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(EditPart child, Object constraint) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {" + NL + "\t\t\t\tDiagramNode node = (DiagramNode) child.getModel();" + NL + "\t\t\t\tPoint newLocation = node.getLocation().getTranslated(request.getMoveDelta());" + NL + "\t\t\t\tDimension newSize = node.getSize().getExpanded(request.getSizeDelta());" + NL + "\t\t\t\treturn new ChangeNodeBoundsCommand(node, newLocation, newSize);" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command getCreateCommand(CreateRequest request) {" + NL + "\t\t\t\tif (request.getNewObjectType() != DiagramNode.class) {" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tDiagramNode diagramNode = (DiagramNode) request.getNewObject();" + NL + "\t\t\t\tif (request.getLocation() != null) {" + NL + "\t\t\t\t\tPoint location = request.getLocation().getCopy();" + NL + "\t\t\t\t\tgetHostFigure().translateToRelative(location);" + NL + "\t\t\t\t\tdiagramNode.setLocation(location);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (request.getSize() != null && !request.getSize().isEmpty()) {";
  protected final String TEXT_9 = NL + "\t\t\t\t\tdiagramNode.setSize(request.getSize());" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new CreateDiagramNodeCommand(diagramNode, getDiagramCanvas());" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command getDeleteDependantCommand(Request arg0) {" + NL + "\t\t\t\t// TODO Auto-generated method stub" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createFigure() {" + NL + "\t\tFigure f = new FreeformLayer();" + NL + "\t\tf.setBorder(new MarginBorder(5));" + NL + "\t\tf.setLayoutManager(new FreeformLayout());" + NL + "\t\treturn f;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelChildren() {" + NL + "\t\treturn getDiagramCanvas().getNodes();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {" + NL + "\t\tif (SnapToHelper.class == key) {" + NL + "\t\t\treturn new SnapToGrid(this);" + NL + "\t\t}" + NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic DiagramCanvas getDiagramCanvas() {" + NL + "\t\treturn (DiagramCanvas) getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_10 = " getColorSupport() {" + NL + "\t\treturn myColorSupport;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramCanvas().eAdapters().add(myDiagramListener);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tgetDiagramCanvas().eAdapters().remove(myDiagramListener);" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ColorSupport"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ColorSupport"));
    stringBuffer.append(TEXT_8);
    
					// XXX plus subject to 'resizable' attribute of the node?

    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ColorSupport"));
    stringBuffer.append(TEXT_10);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
