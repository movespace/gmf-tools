package org.eclipse.gmf.codegen.templates.edit;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.util.ImportUtil;
import java.util.*;

public class MetaInfoProviderAdapterFactory2Generator
{
  protected static String nl;
  public static synchronized MetaInfoProviderAdapterFactory2Generator create(String lineSeparator)
  {
    nl = lineSeparator;
    MetaInfoProviderAdapterFactory2Generator result = new MetaInfoProviderAdapterFactory2Generator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "import org.eclipse.emf.common.notify.Adapter;" + NL + "import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.ComposedAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.IDisposable;" + NL + "import org.eclipse.gmf.diagramrt.DiagramCanvas;" + NL + "import org.eclipse.gmf.diagramrt.DiagramLink;" + NL + "import org.eclipse.gmf.diagramrt.DiagramNode;" + NL + "import org.eclipse.gmf.diagramrt.util.DiagramRTAdapterFactory;" + NL + "import org.eclipse.gmf.diagramrt.util.DiagramRTSwitch;" + NL + "import org.eclipse.gmf.edit.provider.metainfo.LinkMetaInfoProvider;" + NL + "import org.eclipse.gmf.edit.provider.metainfo.NodeMetaInfoProvider;";
  protected final String TEXT_4 = NL + NL + NL + "/**" + NL + " * This one is for specific DRT model of ";
  protected final String TEXT_5 = "." + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " implements ComposeableAdapterFactory, IDisposable {";
  protected final String TEXT_8 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ComposedAdapterFactory myParentFactory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isFactoryForType(Object object) {" + NL + "\t\treturn NodeMetaInfoProvider.class.equals(object) || LinkMetaInfoProvider.class.equals(object) || super.isFactoryForType(object);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_9 = "() {" + NL + "\t}" + NL;
  protected final String TEXT_10 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_11 = " my";
  protected final String TEXT_12 = ";" + NL + "" + NL + "\t/**" + NL + "\t * XXX Looks like we restrict ourselves to 'full' DRT models here, ie for each kind  " + NL + "\t * of node/link on diagram there should be separate class in DRT. Otherwise, " + NL + "\t * there will be no different createXXXAdapter methods and same metainfo " + NL + "\t * @generated" + NL + "\t * @overrides" + NL + "\t */" + NL + "\tpublic Adapter create";
  protected final String TEXT_13 = "Adapter() {" + NL + "\t\tif (my";
  protected final String TEXT_14 = " == null) {" + NL + "\t\t\tmy";
  protected final String TEXT_15 = " = new ";
  protected final String TEXT_16 = "();" + NL + "\t\t}" + NL + "\t\treturn my";
  protected final String TEXT_17 = ";" + NL + "\t}";
  protected final String TEXT_18 = NL + "\t// TODO statful";
  protected final String TEXT_19 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ComposeableAdapterFactory getRootAdapterFactory() {" + NL + "\t\treturn myParentFactory == null ? this : myParentFactory.getRootAdapterFactory();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {" + NL + "\t\tmyParentFactory = parentAdapterFactory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void dispose() {" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) argument;
GenPackage rtGenPackage = genDiagram.getDiagramRunTimeClass().getGenPackage();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(rtGenPackage.getEcorePackage().getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getMetaInfoFactoryClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(rtGenPackage.getQualifiedAdapterFactoryClassName()));
    stringBuffer.append(TEXT_7);
    final boolean STATELESS = true;
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getMetaInfoFactoryClassName());
    stringBuffer.append(TEXT_9);
    
final List allElements = new LinkedList();
allElements.addAll(genDiagram.getNodes());
allElements.addAll(genDiagram.getLinks());
allElements.add(genDiagram);
for (Iterator it = allElements.iterator(); it.hasNext();) {
	GenCommonBase genElement = (GenCommonBase) it.next();
	final String mipQualifiedName = importManager.getImportedName(genElement.getMetaInfoProviderQualifiedClassName());
	if (STATELESS) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(mipQualifiedName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genElement.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genElement.getDiagramRunTimeClass().getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genElement.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genElement.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(mipQualifiedName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genElement.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_17);
    	} else {
    stringBuffer.append(TEXT_18);
    	}
    }
    stringBuffer.append(TEXT_19);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
