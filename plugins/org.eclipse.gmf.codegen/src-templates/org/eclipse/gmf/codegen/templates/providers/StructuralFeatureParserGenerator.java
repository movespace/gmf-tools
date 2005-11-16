package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;

public class StructuralFeatureParserGenerator
{
  protected static String nl;
  public static synchronized StructuralFeatureParserGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    StructuralFeatureParserGenerator result = new StructuralFeatureParserGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractModelCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;" + NL + "import org.eclipse.jface.text.contentassist.IContentAssistProcessor;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " implements IParser {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EStructuralFeature feature;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_4 = "(EStructuralFeature feature) {" + NL + "\t\tthis.feature = feature;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {" + NL + "\t\tEObject element = (EObject) adapter.getAdapter(EObject.class);" + NL + "\t\tSetRequest request = new SetRequest(element, feature, newString);" + NL + "\t\tfinal SetValueCommand actualCommand = new SetValueCommand(request);" + NL + "\t\tString label = feature.getName();" + NL + "\t\treturn new AbstractModelCommand(label, actualCommand.getAffectedObjects()) {" + NL + "" + NL + "\t\t\tprotected CommandResult doExecute(IProgressMonitor progressMonitor) {" + NL + "\t\t\t\tactualCommand.execute(progressMonitor);" + NL + "\t\t\t\treturn actualCommand.getCommandResult();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getPrintString(IAdaptable adapter, int flags) {" + NL + "\t\tEObject element = (EObject) adapter.getAdapter(EObject.class);" + NL + "\t\tObject value = element.eGet(feature);" + NL + "\t\tif (value != null) {" + NL + "\t\t\tString literalValue = value.toString();" + NL + "\t\t\tif (literalValue.length() > 0) {" + NL + "\t\t\t\treturn literalValue;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getDefaultValue();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getDefaultValue() {" + NL + "\t\tString defaultValue = feature.getDefaultValueLiteral();" + NL + "\t\tif (defaultValue == null) {" + NL + "\t\t\tdefaultValue = \"\"; //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\treturn defaultValue;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getEditString(IAdaptable adapter, int flags) {" + NL + "\t\treturn getPrintString(adapter, flags);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IParserEditStatus isValidEditString(IAdaptable element, String editString) {" + NL + "\t\treturn ParserEditStatus.EDITABLE_STATUS;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isAffectingEvent(Object event, int flags) {" + NL + "\t\tif (event instanceof Notification) {" + NL + "\t\t\tif (feature == ((Notification) event).getFeature()) {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IContentAssistProcessor getCompletionProcessor(IAdaptable element) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getStructuralFeatureParserClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getStructuralFeatureParserClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
