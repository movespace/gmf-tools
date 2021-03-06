/*
 * Copyright (c) 2005, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.tr;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.ToolGroupItem;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.m2m.internal.qvt.oml.InternalTransformationExecutor;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;

@SuppressWarnings("restriction")
public abstract class QvtGenModelTransformerTest extends AbstractMappingTransformerTest {

	protected GenEditorGenerator myTransformationResult;
//	private final DiagramRunTimeModelHelper myDiagramModelHelper; 
	protected Resource traceResource;
	
	protected QvtGenModelTransformerTest(String name, DiagramRunTimeModelHelper rtHelper) {
		super(name);
		assert rtHelper != null;
//		myDiagramModelHelper = rtHelper;
	}

	protected void setUp() throws Exception {
		super.setUp();
		myTransformationResult = executeQVT();
	}
	
	protected GenEditorGenerator executeQVT() throws IOException {
		GenModel genModel = Utils.createGenModel(getCanvasMapping().getDomainModel());
		Mapping mapping = getMapping();
		
		ResourceSet resourceSet = genModel.eResource().getResourceSet();
		traceResource = resourceSet.createResource(URI.createURI("test.qvtotrace"));
		InternalTransformationExecutor executor = 
			new InternalTransformationExecutor(URI.createURI("platform:/plugin/org.eclipse.gmf.bridge/transforms/Map2Gen.qvto")) {
				 @Override
				    protected void handleExecutionTraces(Trace traces) {
				        traceResource.getContents().add(traces);
				        super.handleExecutionTraces(traces);
				    }
			};
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("rcp", false);
		context.setConfigProperty("useMapMode", false);
		context.setConfigProperty("useFullRunTime", false);
		context.setConfigProperty("useInTransformationCodeGen", true);
		
		EList<EObject> mapObjects = new BasicEList<EObject>();
		mapObjects.add(mapping);
		ModelExtent inMap = new BasicModelExtent(mapObjects);
		EList<EObject> genObjects = new BasicEList<EObject>();
		genObjects.add(genModel);
		ModelExtent inGen = new BasicModelExtent(genObjects);
		Resource res = resourceSet.createResource(URI.createURI("platform:/plugin/org.eclipse.gmf.runtime.notation/model/notation.genmodel"));
		res.load(null);
		ModelExtent inNotation = new BasicModelExtent(res.getContents());
		
		ModelExtent output = new BasicModelExtent();
		
		ExecutionDiagnostic result = executor.execute(context, inMap, inGen, inNotation, output);
		
		if(result.getSeverity() == Diagnostic.OK) {
			
			List<EObject> outObjects = output.getContents();
			assertTrue(outObjects.get(0) instanceof GenEditorGenerator);
			
			return (GenEditorGenerator) outObjects.get(0);
		}
		
		return null;
	}
	
	protected GenNode[] find(NodeMapping nodeMap) {
		assert nodeMap != null;
		GenNode genNode = findTopNode(nodeMap);
		return genNode != null ? new GenNode[] {genNode} : new GenNode[]{};//findChildNodes(nodeMap);
	}
	
	protected GenTopLevelNode findTopNode(NodeMapping nodeMap) {
		assert nodeMap != null;
		Trace trace = (Trace) traceResource.getContents().get(0);
		for (TraceRecord record: trace.getTraceRecords()) {
			if (record.getContext().getContext().getType().equals(GMFMapPackage.eINSTANCE.getTopNodeReference().getName())) {
				if (record.getContext().getContext().getValue().getModelElement().equals(nodeMap.eContainer())) {
					return (GenTopLevelNode) record.getResult().getResult().get(0).getValue().getModelElement();
				}
			}
		}
		return null;
	}
	
	private GenLink find(LinkMapping linkMapping) {
		assert linkMapping != null;
		Trace trace = (Trace) traceResource.getContents().get(0);
		for (TraceRecord record: trace.getTraceRecords()) {
			if (record.getContext().getContext().getType().equals(GMFMapPackage.eINSTANCE.getLinkMapping().getName())) {
				if (record.getContext().getContext().getValue().getModelElement().equals(linkMapping)) {
					EObject modelElement = record.getResult().getResult().get(0).getValue().getModelElement();
					if (modelElement instanceof GenLink)
						return (GenLink) modelElement ;
				}
			}
		}
		return null;
	}
	
	public void testGenModelTransform() {
		assertNotNull("GenEditorGenerator is expected as result of mapping transformation", myTransformationResult);
		assertNotNull("GenDiagram is expected to be set...", myTransformationResult.getDiagram());
		assertNotNull("... as well as GenPlugin is expected to be set", myTransformationResult.getPlugin());
		assertNotNull("Diagram filename extension not set", myTransformationResult.getDiagramFileExtension());
		// FIXME add more
		
		GenNode[] genNodes = find(getNodeMapping());
		assertEquals("Result model contains no GenNode for nodeMapping", 1, genNodes.length);
		// FIXME add more

		GenLink genLinks = find(getLinkMapping());
		assertNotNull("Result model contains no GenLink for linkMapping", genLinks);
		// FIXME add more
	}
	
	public void testCreatedPalette() {
		final Palette palette = myTransformationResult.getDiagram().getPalette();
		for (TopNodeReference topNode : getMapping().getNodes()) {
			final NodeMapping nodeMapping = topNode.getChild();
			GenTopLevelNode genNode = findTopNode(nodeMapping);
			assertNotNull(genNode);
			assertEquals(nodeMapping.getTool() != null ? 1 : 0, countUses(genNode, palette));
		}
		for (LinkMapping linkMapping : getMapping().getLinks()) {
			GenLink genLink = find(linkMapping);
			assertNotNull(genLink);
			assertEquals(linkMapping.getTool() != null ? 1 : 0, countUses(genLink, palette));
		}
		// TODO add grooping test
	}

	private static int countUses(GenCommonBase genElement, Palette palette) {
		int uses = 0;
		for (ToolGroup nextGroup : palette.getGroups()) {
			for (ToolGroupItem item : nextGroup.getEntries()) {
				if (false == item instanceof ToolEntry) {
					continue;
				}
				for (GenCommonBase cb : ((ToolEntry) item).getElements()) {
					if (cb == genElement) {
						uses++;
						// although it's hardly there's more that one GenCommonBase in EMF EList for ToolEntry#elements, doesn't hurt 
						// *not to* break here 
					}
				}
			}
		}
		return uses;
	}
}

