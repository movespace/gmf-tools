package org.eclipse.gmf.codegen.templates.diacanvas;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class EditPartFactoryGen
{
  protected static String nl;
  public static synchronized EditPartFactoryGen create(String lineSeparator)
  {
    nl = lineSeparator;
    EditPartFactoryGen result = new EditPartFactoryGen();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "import org.eclipse.emf.ecore.*;" + NL + "import org.eclipse.gef.*;" + NL + "import org.eclipse.gmf.diagramrt.*;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " implements EditPartFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createEditPart(EditPart context, Object model) {" + NL + "\t\tif (model instanceof ChildNode) {" + NL + "\t\t\treturn createChildEditPart(context, (ChildNode) model);" + NL + "\t\t}" + NL + "\t\tif (model instanceof DiagramNode) {" + NL + "\t\t\treturn createNodeEditPart(context, (DiagramNode) model);" + NL + "\t\t}" + NL + "\t\tif (model instanceof DiagramLink) {" + NL + "\t\t\treturn createLinkEditPart(context, (DiagramLink) model);" + NL + "\t\t}" + NL + "\t\tif (model instanceof DiagramCanvas) {" + NL + "\t\t\treturn createCanvasEditPart(context, (DiagramCanvas) model);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createNodeEditPart(EditPart context, DiagramNode diagramElement) {" + NL + "\t\tfinal int visualID = diagramElement.getVisualID();";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = "\t\tif (visualID == ";
  protected final String TEXT_8 = ".VISUAL_ID) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_9 = "(diagramElement);" + NL + "\t\t}";
  protected final String TEXT_10 = NL + "\t\tSystem.err.println(\"No NodeEditPart for \" + diagramElement + \" with visualID=\" + visualID);" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createLinkEditPart(EditPart context, DiagramLink diagramElement) {" + NL + "\t\tfinal int visualID = diagramElement.getVisualID();";
  protected final String TEXT_11 = NL + "\t\t";
  protected final String TEXT_12 = "\t\tif (visualID == ";
  protected final String TEXT_13 = ".VISUAL_ID) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_14 = "(diagramElement);" + NL + "\t\t}";
  protected final String TEXT_15 = NL + "\t\tSystem.err.println(\"No LinkEditPart for \" + diagramElement + \" with visualID=\" + visualID);" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createChildEditPart(EditPart context, ChildNode diagramElement) {" + NL + "\t\tDiagramNode parentNode = (DiagramNode) context.getModel();" + NL + "\t\tfinal EClass parentMetaClass = parentNode.getDomainModelElement().eClass();" + NL + "\t\tfinal EClass childMetaClass = diagramElement.getDomainModelElement().eClass();";
  protected final String TEXT_16 = NL + "\t\t";
  protected final String TEXT_17 = NL + "\t\tif (parentMetaClass == ";
  protected final String TEXT_18 = ".eINSTANCE.get";
  protected final String TEXT_19 = "()) {";
  protected final String TEXT_20 = NL + "\t\t\tif (childMetaClass == ";
  protected final String TEXT_21 = ".eINSTANCE.get";
  protected final String TEXT_22 = "()) {" + NL + "\t\t\t\t// && genChildNode.getGroupID == diagramElement.getGroupID()?" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_23 = "(diagramElement);" + NL + "\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t}";
  protected final String TEXT_25 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createCanvasEditPart(EditPart context, DiagramCanvas model) {" + NL + "\t\treturn new ";
  protected final String TEXT_26 = "(model);" + NL + "\t}" + NL + "}";

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
    stringBuffer.append(genDiagram.getEditPartFactoryClassName());
    stringBuffer.append(TEXT_5);
    
	//HashMap domainToGenNode = new HashMap();
	for (Iterator it = genDiagram.getNodes().iterator(); it.hasNext();) {
		GenNode genNode = (GenNode) it.next();

    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    
	}

    stringBuffer.append(TEXT_10);
    
	for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
		GenLink genLink = (GenLink) it.next();

    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    
	}

    stringBuffer.append(TEXT_15);
    
	for (Iterator it = genDiagram.getNodes().iterator(); it.hasNext();) {
		GenNode genNode = (GenNode) it.next();
		if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_16);
    
	EClass next = genNode.getDomainMetaClass();
	GenClass nextGen = genDiagram.findGenClass(next);
	GenPackage genPackage = nextGen.getGenPackage();
	importManager.addImport(genPackage.getInterfacePackageName(), genPackage.getPackageInterfaceName());

    stringBuffer.append(TEXT_17);
    stringBuffer.append(genPackage.getPackageInterfaceName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(nextGen.getClassifierAccessorName());
    stringBuffer.append(TEXT_19);
    
	for (Iterator it2 = genNode.getChildNodes().iterator(); it2.hasNext();) {
		GenChildNode genChildNode = (GenChildNode) it2.next();
		GenClass nextGenChildClass = genDiagram.findGenClass(genChildNode.getDomainMetaClass());
		GenPackage nextChildGenPackage = nextGenChildClass.getGenPackage();
		if (nextChildGenPackage != genPackage) {
			importManager.addImport(nextChildGenPackage.getInterfacePackageName(), nextChildGenPackage.getPackageInterfaceName());
		}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(nextChildGenPackage.getPackageInterfaceName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(nextGenChildClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName(genChildNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_23);
    
	}

    stringBuffer.append(TEXT_24);
    		}
	}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
