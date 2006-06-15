/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import java.io.IOException;
import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.mappings.AuditContainer;
import org.eclipse.gmf.mappings.AuditRule;
import org.eclipse.gmf.mappings.AuditedMetricTarget;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.DiagramElementTarget;
import org.eclipse.gmf.mappings.DomainAttributeTarget;
import org.eclipse.gmf.mappings.DomainElementTarget;
import org.eclipse.gmf.mappings.FeatureSeqInitializer;
import org.eclipse.gmf.mappings.FeatureValueSpec;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.Language;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.MetricContainer;
import org.eclipse.gmf.mappings.MetricRule;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.Severity;
import org.eclipse.gmf.tests.EPath;
import org.eclipse.gmf.tests.Plugin;


public class LinksSessionSetup extends SessionSetup {

	private static String modelURI = "/models/links/links.ecore"; //$NON-NLS-1$
	
	protected LinksSessionSetup() {
	}

	public static SessionSetup newInstance() {
		if (factoryClosed) {
			return null;
		}
		return new LinksSessionSetup();
	}

	protected DomainModelSource createDomainModel() {
		DomainModelFileSetup modelSetup = new DomainModelFileSetup() {
			public EClass getDiagramElement() {
				return (EClass) EPath.ECORE.lookup(getModel(), "Root"); //$NON-NLS-1$
			}
			public NodeData getNodeA() {
				EClass n = (EClass) EPath.ECORE.lookup(getModel(), "Container"); //$NON-NLS-1$
				EReference c = (EReference) EPath.ECORE.lookup(getModel(), "Root::elements"); //$NON-NLS-1$
				return new NodeData(n, null, c);
			}
			public NodeData getNodeB() {
				EClass n = (EClass) EPath.ECORE.lookup(getModel(), "Node"); //$NON-NLS-1$
				EReference c = (EReference) EPath.ECORE.lookup(getModel(), "Root::elements"); //$NON-NLS-1$
				return new NodeData(n, null, c);
			}
			public LinkData getLinkAsClass() {
				EClass l = (EClass) EPath.ECORE.lookup(getModel(), "Link"); //$NON-NLS-1$
				EReference t = (EReference) EPath.ECORE.lookup(getModel(), "Link::target"); //$NON-NLS-1$
				EReference c = (EReference) EPath.ECORE.lookup(getModel(), "Container::childNodes"); //$NON-NLS-1$
				return new LinkData(l, t, c);
			}
			public EReference getLinkAsRef() {
				return (EReference) EPath.ECORE.lookup(getModel(), "Container::referenceOnlyLink"); //$NON-NLS-1$
			}
		};
		try {
			modelSetup.init(Plugin.createURI(modelURI));
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Failed to setup the domain model. " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		return modelSetup;
	}
	
	protected DiaGenSource createGenModel() {
		DiaGenSetup diaGenSetup = new DiaGenSetup().init(getMapModel());
		// force generation of validation support 
		diaGenSetup.getGenDiagram().setValidationEnabled(true);
		diaGenSetup.getGenDiagram().setValidationDecorators(true);
		// fix Prefixes for nested packages
		GenModel genModel = diaGenSetup.getGenDiagram().getDiagram().getDomainDiagramElement().getGenModel();
		for (Iterator it = genModel.getAllGenPackagesWithClassifiers().iterator(); it.hasNext();) {
			GenPackage nextGenPackage = (GenPackage) it.next();
			if(nextGenPackage.getPrefix() == null || nextGenPackage.getPrefix().length() == 0) {
				StringBuffer buf = new StringBuffer(nextGenPackage.getPackageName());
				buf.setCharAt(0, Character.toUpperCase(buf.charAt(0)));
				nextGenPackage.setPrefix(buf.toString());
			}
		}
		return diaGenSetup;
	}

	protected MapDefSource createMapModel() {
		MapSetup mapDefSource = new LinksMapSetup();
		return mapDefSource.init(new DiaDefSetup().init(), getDomainModel(), new ToolDefSetup());
	}
	
	/*
	 * Custom map-setup
	 */
	private static final class LinksMapSetup extends MapSetup {
		private DomainModelSource domainSource;
		
		public MapSetup init(DiaDefSource ddSource, DomainModelSource domainSource, ToolDefSource toolDef) {
			this.domainSource = domainSource;
			super.init(ddSource, domainSource, toolDef);
			// add mapping for InvalidNode, this node will be never created in tests
			// but used for generation purposes of java expression support
			EClass invalidNodeMetaClass = (EClass)EPath.ECORE.lookup(domainSource.getModel(), "InvalidNode"); //$NON-NLS-1$
			createNodeMapping(ddSource.getNodeDef(), 
					invalidNodeMetaClass, null, null,
					(EReference)EPath.findFeature(domainSource.getModel(), "Root::elements"), //$NON-NLS-1$
					true);
					
			// Note: needs metrics to be initialized before audits as audits may reference metric
			initMetricContainer(domainSource);
			initAudits();
			return this;
		}

		/* Setup element initializers */
		protected void setupNodeMapping(NodeMapping nme) {
			if("Container".equals(nme.getDomainContext().getName())) { //$NON-NLS-1$
				String[][] data = new String[][] {
						new String[] { "Container::enumAttr_Init", "TestEnum::LIT1" }, //$NON-NLS-1$ //$NON-NLS-2$
						new String[] { "Container::manyEnumAttr_Init", "Sequence { TestEnum::LIT0, TestEnum::LIT1 }" }, //$NON-NLS-1$ //$NON-NLS-2$						
						new String[] { "Container::reference_Init", "Bag { self }" }, //$NON-NLS-1$ //$NON-NLS-2$
						new String[] { "Container::manyRealAttr_Init", "Sequence { 1, 1.5 }" }, //$NON-NLS-1$ //$NON-NLS-2$						
				};
				setupInitializers(nme, data);	
				// test domain element seletor
				Constraint selector = GMFMapFactory.eINSTANCE.createConstraint();
				selector.setBody("true"); //$NON-NLS-1$
				nme.setDomainSpecialization(selector);
				
			} else if("Node".equals(nme.getDomainContext().getName())) { //$NON-NLS-1$
				String[][] data = new String[][] {  
					new String[] { "Node::integers_Init", "Sequence { 10, 20 }" }, //$NON-NLS-1$ //$NON-NLS-2$
					new String[] { "Node::name", "setNodeName", "java" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$				
				};				
				setupInitializers(nme, data);				
				createReusedChildNodes(nme, new String[] { "Node::nestedNodes1", "Node::nestedNodes2" }); //$NON-NLS-1$ //$NON-NLS-2$				
			} else if("InvalidNode".equals(nme.getDomainContext().getName())) { //$NON-NLS-1$				
				// test specializer with multiple java expressions coming from reused node mapping				
				// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=144305
				String[][] data = new String[][] {
					new String[] { "Node::name", "'\"Quated-name tests literal escaping\"'" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$						
					new String[] { "Node::multiValPrimitive", "multiValPrimitive", "java" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$					
					new String[] { "Node::multiValObj", "multiValObj", "java" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$					
					new String[] { "Node::multiRef", "multiRef", "java" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					new String[] { "Node::singleValPrimitive", "singleValPrimitive", "java" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$					
					new String[] { "Node::singleValObj", "singleValObj", "java" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$					
					new String[] { "Node::singleRef", "singleRef", "java" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$										
				};				
				setupInitializers(nme, data);				
				Constraint selector = GMFMapFactory.eINSTANCE.createConstraint();
				selector.setLanguage(Language.JAVA_LITERAL);				
				selector.setBody("myNodeSelector"); //$NON-NLS-1$
				nme.setDomainSpecialization(selector);
				createReusedChildNodes(nme, new String[] { "InvalidNode::nestedNodes1" }); //$NON-NLS-1$				
			}
		}

		private void createReusedChildNodes(NodeMapping topNode, String[] containmentFeatures) {
			for (int i = 0; i < containmentFeatures.length; i++) {
				ChildReference childRef = GMFMapFactory.eINSTANCE.createChildReference();
				childRef.setContainmentFeature((EReference) EPath.findFeature(domainSource.getModel(), containmentFeatures[i])); 
				childRef.setReferencedChild(topNode);
				topNode.getChildren().add(childRef);
			}
		}		
		
		private void setupInitializers(NodeMapping nme, String[][] data) {
			FeatureSeqInitializer initializer = GMFMapFactory.eINSTANCE.createFeatureSeqInitializer();				
			for (int i = 0; i < data.length; i++) {
				FeatureValueSpec featureValueSpec = GMFMapFactory.eINSTANCE.createFeatureValueSpec();					
				EStructuralFeature feature = (EStructuralFeature)
					EPath.ECORE.lookup(nme.getDomainContext().getEPackage(), data[i][0]);					
				featureValueSpec.setFeature(feature);
				featureValueSpec.setBody(data[i][1]);
				if(data[i].length > 2) {
					Language lang = Language.getByName(data[i][2]);
					Assert.assertNotNull("Could not find language enumerator for :" + data[i][2], lang); //$NON-NLS-1$
					featureValueSpec.setLanguage(lang);
				}
				initializer.getInitializers().add(featureValueSpec);
			}
			nme.setDomainInitializer(initializer);				
		}

		protected void initAudits() {
			AuditContainer auditContainer = createAuditContainer(Plugin.getPluginID() + ".<category1>" + System.currentTimeMillis()); //$NON-NLS-1$
			getMapping().setAudits(auditContainer);
						
			DomainElementTarget classA = GMFMapFactory.eINSTANCE.createDomainElementTarget();
			classA.setElement(getNodeA().getDomainMetaElement());
			DomainElementTarget classB = GMFMapFactory.eINSTANCE.createDomainElementTarget();
			//classB.setElement(getNodeB().getDomainMetaElement());
			classB.setElement((EClass)EPath.ECORE.lookup(domainSource.getModel(), "nestedPckg::ClassA"));			
			
			// create set of allways satisfied constraints
			// create ID with xml markup chars to test xml escaping in plugin.xml
			String constraintId1 = "<constraint.id1>"; //$NON-NLS-1$ 
			auditContainer.getAudits().add(createAudit(constraintId1, "true", classA, Severity.ERROR_LITERAL, true)); //$NON-NLS-1$
			auditContainer.getAudits().add(createAudit("constraint.id2", "10 > 0", classB, Severity.WARNING_LITERAL, false));	//$NON-NLS-1$ //$NON-NLS-2$
			
			AuditContainer subCat = createAuditContainer("category2"); //$NON-NLS-1$
			DiagramElementTarget nodeTarget = GMFMapFactory.eINSTANCE.createDiagramElementTarget();
			nodeTarget.setElement(getNodeB());
			auditContainer.getChildContainers().add(subCat);
			subCat.getAudits().add(createAudit("constraint.id3", "''<>'Foo'", nodeTarget, Severity.INFO_LITERAL, false)); //$NON-NLS-1$ //$NON-NLS-2$
			
			AuditContainer attrAuditContainer = createAuditContainer("audit_container.attributeTarget");  //$NON-NLS-1$
			auditContainer.getChildContainers().add(attrAuditContainer);
			
			DomainAttributeTarget attrTarget1 = GMFMapFactory.eINSTANCE.createDomainAttributeTarget();
			attrTarget1.setAttribute((EAttribute) EPath.ECORE.lookup(getMapping().getDiagram().getDomainModel(), "Node::name")); //$NON-NLS-1$
			attrTarget1.setNullAsError(true);
			attrAuditContainer.getAudits().add(createAudit("audit.attributeTarget.id1", "self <> ''", attrTarget1, Severity.ERROR_LITERAL, false)); //$NON-NLS-1$ //$NON-NLS-2$
			
			DomainAttributeTarget attrTarget2 = GMFMapFactory.eINSTANCE.createDomainAttributeTarget();
			attrTarget2.setAttribute((EAttribute) EPath.ECORE.lookup(getMapping().getDiagram().getDomainModel(), "Node::acceptLinkKind")); //$NON-NLS-1$
			attrTarget2.setNullAsError(false);
			AuditRule regexpRule = createAudit("audit.attributeTarget.id2", "a*b", attrTarget2, Severity.ERROR_LITERAL, false); //$NON-NLS-1$ //$NON-NLS-2$
			regexpRule.getRule().setLanguage(Language.REGEXP_LITERAL);				
			attrAuditContainer.getAudits().add(regexpRule);
									
			DomainAttributeTarget attrTarget3 = GMFMapFactory.eINSTANCE.createDomainAttributeTarget();
			attrTarget3.setAttribute((EAttribute) EPath.ECORE.lookup(getMapping().getDiagram().getDomainModel(), "Node::acceptLinkKind")); //$NON-NLS-1$
			AuditRule javaRule1 = createAudit("audit.attributeTarget.id3", "myJavaAudit1", attrTarget3, Severity.ERROR_LITERAL, false); //$NON-NLS-1$ //$NON-NLS-2$
			javaRule1.getRule().setLanguage(Language.JAVA_LITERAL);				
			attrAuditContainer.getAudits().add(javaRule1);
		
			DomainAttributeTarget attrTarget4 = GMFMapFactory.eINSTANCE.createDomainAttributeTarget();
			attrTarget4.setAttribute((EAttribute) EPath.ECORE.lookup(getMapping().getDiagram().getDomainModel(), "Container::enumAttr_Init")); //$NON-NLS-1$
			AuditRule javaRule2 = createAudit("audit.attributeTarget.id4", "myJavaAudit2", attrTarget4, Severity.ERROR_LITERAL, false); //$NON-NLS-1$ //$NON-NLS-2$
			javaRule2.getRule().setLanguage(Language.JAVA_LITERAL);		
			attrAuditContainer.getAudits().add(javaRule2);
			
			DomainAttributeTarget attrTarget5 = GMFMapFactory.eINSTANCE.createDomainAttributeTarget();
			attrTarget5.setAttribute((EAttribute) EPath.ECORE.lookup(getMapping().getDiagram().getDomainModel(), "Node::multiValObj")); //$NON-NLS-1$
			attrTarget5.setNullAsError(false);
			AuditRule nregexpRule = createAudit("audit.attributeTarget.nregexp.id", "a*b", attrTarget5, Severity.ERROR_LITERAL, false); //$NON-NLS-1$ //$NON-NLS-2$
			nregexpRule.getRule().setLanguage(Language.NREGEXP_LITERAL);				
			attrAuditContainer.getAudits().add(nregexpRule);
			
			AuditedMetricTarget metricTarget = GMFMapFactory.eINSTANCE.createAuditedMetricTarget();
			Assert.assertTrue("Requires at least one metric definition", //$NON-NLS-1$
					getMapping().getMetrics() != null && getMapping().getMetrics().getMetrics().size() > 0);
			metricTarget.setMetric((MetricRule)getMapping().getMetrics().getMetrics().get(0));
			AuditRule metricAuditRule = createAudit("audit.metricTarget.id", "self > 0 and false", metricTarget, Severity.INFO_LITERAL, false); //$NON-NLS-1$ //$NON-NLS-2$
			auditContainer.getAudits().add(metricAuditRule);			
		}

		protected void setupClassLinkMapping(LinkMapping lme) {
			addCreationConstraints(lme, null, "self.acceptLinkKind = oppositeEnd.acceptLinkKind"); //$NON-NLS-1$
		}

		protected void setupReferenceLinkMapping(LinkMapping lme) {
			addCreationConstraints(lme, 
					"not self.acceptLinkKind.oclIsUndefined()", //$NON-NLS-1$
					"self.acceptLinkKind = oppositeEnd.acceptLinkKind"); //$NON-NLS-1$
		}
		
		private void initMetricContainer(DomainModelSource domainModel) {
			MetricContainer container = GMFMapFactory.eINSTANCE.createMetricContainer();		 
			MetricRule domainElementRule = createMetric("\"dom1\"", "1.2", null, null); //$NON-NLS-1$ //$NON-NLS-2$
			DomainElementTarget domainElementTarget = GMFMapFactory.eINSTANCE.createDomainElementTarget();
			// test name and description optionality
			domainElementRule.setName(null);		
			domainElementRule.setDescription(null);			
			domainElementTarget.setElement(domainModel.getNodeA().getEClass());
			domainElementRule.setTarget(domainElementTarget);
			container.getMetrics().add(domainElementRule);
			
			
			MetricRule reusedDiagramElementRule = createMetric("reused.node.mapping.diagramElement", "150", new Double(100), new Double(200)); //$NON-NLS-1$ //$NON-NLS-2$
			// set optional desc
			reusedDiagramElementRule.setDescription("A diagram metric with reused diagram element mapping"); //$NON-NLS-1$		
			
			DiagramElementTarget reusedDiagramElementTarget = GMFMapFactory.eINSTANCE.createDiagramElementTarget();
			reusedDiagramElementTarget.setElement(getNodeB());
			reusedDiagramElementRule.setTarget(reusedDiagramElementTarget);
			container.getMetrics().add(reusedDiagramElementRule);			

			MetricRule diagramElementRule = createMetric("node.mapping.diagramElement", "15", new Double(10), new Double(20)); //$NON-NLS-1$ //$NON-NLS-2$			
			DiagramElementTarget diagramElementTarget = GMFMapFactory.eINSTANCE.createDiagramElementTarget();
			diagramElementTarget.setElement(getNodeA());
			diagramElementRule.setTarget(diagramElementTarget);
			container.getMetrics().add(diagramElementRule);			

			getMapping().setMetrics(container);
		}
		
		private static MetricRule createMetric(String key, String oclBody, Double low, Double high) {
			MetricRule rule = GMFMapFactory.eINSTANCE.createMetricRule();
			rule.setKey(key);
			// Note: use characters that need to be escaped in java source string literals
			rule.setName("Name of \"" + key + "\""); //$NON-NLS-1$ //$NON-NLS-2$
			rule.setDescription("Description of \"" + key + "\""); //$NON-NLS-1$ //$NON-NLS-2$
			rule.setRule(GMFMapFactory.eINSTANCE.createValueExpression());
			rule.getRule().setBody(oclBody);
			rule.setLowLimit(low);
			rule.setHighLimit(high);
			return rule;
		}		
	}	
}
