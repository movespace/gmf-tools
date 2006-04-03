package org.eclipse.gmf.codegen.templates.helpers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class EditHelperAdviceGenerator
{
  protected static String nl;
  public static synchronized EditHelperAdviceGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    EditHelperAdviceGenerator result = new EditHelperAdviceGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractEditHelperAdvice {" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
ElementType genType = (ElementType) ((Object[]) argument)[0];
GenDiagram genDiagram = (GenDiagram) ((GenCommonBase) genType).getDiagram();
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genType.getEditHelperClassName());
    stringBuffer.append(TEXT_6);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
