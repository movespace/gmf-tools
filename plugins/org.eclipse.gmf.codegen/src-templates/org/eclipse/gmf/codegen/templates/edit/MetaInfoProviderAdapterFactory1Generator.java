package org.eclipse.gmf.codegen.templates.edit;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.ImportUtil;
import java.util.*;

public class MetaInfoProviderAdapterFactory1Generator
{
  protected static String nl;
  public static synchronized MetaInfoProviderAdapterFactory1Generator create(String lineSeparator)
  {
    nl = lineSeparator;
    MetaInfoProviderAdapterFactory1Generator result = new MetaInfoProviderAdapterFactory1Generator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "import org.eclipse.emf.common.notify.Adapter;" + NL + "import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.ComposedAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.IDisposable;" + NL + "import org.eclipse.gmf.diagramrt.DiagramCanvas;" + NL + "import org.eclipse.gmf.diagramrt.DiagramLink;" + NL + "import org.eclipse.gmf.diagramrt.DiagramNode;" + NL + "import org.eclipse.gmf.diagramrt.util.DiagramRTAdapterFactory;" + NL + "import org.eclipse.gmf.diagramrt.util.DiagramRTSwitch;" + NL + "import org.eclipse.gmf.edit.provider.metainfo.LinkMetaInfoProvider;" + NL + "import org.eclipse.gmf.edit.provider.metainfo.NodeMetaInfoProvider;";
  protected final String TEXT_4 = NL + NL + NL + "/**" + NL + " * This one is for Basic DRT model." + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends DiagramRTAdapterFactory implements ComposeableAdapterFactory, IDisposable {";
  protected final String TEXT_6 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ComposedAdapterFactory myParentFactory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isFactoryForType(Object object) {" + NL + "\t\treturn NodeMetaInfoProvider.class.equals(object) || LinkMetaInfoProvider.class.equals(object) || super.isFactoryForType(object);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_7 = "() {" + NL + "\t\tsuper.modelSwitch = new DiagramRTSwitch() {" + NL + "\t\t\tpublic Object caseDiagramCanvas(DiagramCanvas object) {" + NL + "\t\t\t\treturn createDiagramCanvasAdapter(object);" + NL + "\t\t\t}" + NL + "\t\t\tpublic Object caseDiagramNode(DiagramNode object) {" + NL + "\t\t\t\treturn createDiagramNodeAdapter(object);" + NL + "\t\t\t}" + NL + "\t\t\tpublic Object caseDiagramLink(DiagramLink object) {" + NL + "\t\t\t\treturn createDiagramLinkAdapter(object);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Adapter createDiagramCanvasAdapter(DiagramCanvas canvas) {" + NL + "\t\treturn create";
  protected final String TEXT_8 = "();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Adapter createDiagramNodeAdapter(DiagramNode node) {" + NL + "\t\tswitch(node.getVisualID()) {";
  protected final String TEXT_9 = NL + "\t\tcase ";
  protected final String TEXT_10 = ".VISUAL_ID : return create";
  protected final String TEXT_11 = "();";
  protected final String TEXT_12 = NL + "\t\tdefault : throw new IllegalStateException(\"Wrong visual id for node:\" + node.getVisualID());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Adapter createDiagramLinkAdapter(DiagramLink link) {" + NL + "\t\tswitch(link.getVisualID()) {";
  protected final String TEXT_13 = NL + "\t\tcase ";
  protected final String TEXT_14 = ".VISUAL_ID : return create";
  protected final String TEXT_15 = "();";
  protected final String TEXT_16 = NL + "\t\tdefault : throw new IllegalStateException(\"Wrong visual id for link:\" + link.getVisualID());" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_17 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_18 = " my";
  protected final String TEXT_19 = ";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_20 = " create";
  protected final String TEXT_21 = "() {" + NL + "\t\tif (my";
  protected final String TEXT_22 = " == null) {" + NL + "\t\t\tmy";
  protected final String TEXT_23 = " = new ";
  protected final String TEXT_24 = "();" + NL + "\t\t}" + NL + "\t\treturn my";
  protected final String TEXT_25 = ";" + NL + "\t}";
  protected final String TEXT_26 = NL + "\t// TODO statful";
  protected final String TEXT_27 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ComposeableAdapterFactory getRootAdapterFactory() {" + NL + "\t\treturn myParentFactory == null ? this : myParentFactory.getRootAdapterFactory();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {" + NL + "\t\tmyParentFactory = parentAdapterFactory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void dispose() {" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getMetaInfoFactoryClassName());
    stringBuffer.append(TEXT_5);
    final boolean STATELESS = true;
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getMetaInfoFactoryClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_8);
    for (Iterator it = genDiagram.getNodes().iterator(); it.hasNext();) { GenNode genNode = (GenNode) it.next();
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genNode.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) { GenLink genLink = (GenLink) it.next();
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genLink.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    
final List allElements = new LinkedList();
allElements.addAll(genDiagram.getNodes());
allElements.addAll(genDiagram.getLinks());
allElements.add(genDiagram);
for (Iterator it = allElements.iterator(); it.hasNext();) {
	GenCommonBase genElement = (GenCommonBase) it.next();
	final String mipQualifiedName = importManager.getImportedName(genElement.getMetaInfoProviderQualifiedClassName());
	if (STATELESS) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(mipQualifiedName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genElement.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(mipQualifiedName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genElement.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genElement.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genElement.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(mipQualifiedName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genElement.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_25);
    	} else {
    stringBuffer.append(TEXT_26);
    	}
    }
    stringBuffer.append(TEXT_27);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
