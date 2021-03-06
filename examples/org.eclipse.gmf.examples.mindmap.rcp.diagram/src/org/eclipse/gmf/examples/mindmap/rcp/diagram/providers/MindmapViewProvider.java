package org.eclipse.gmf.examples.mindmap.rcp.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.RelationshipLabel2EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.RelationshipLabel3EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.RelationshipLabelEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ResourceNameEmailEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadSubjectEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadThreadItemCompartmentEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.TopicNameEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.TopicSubtopicsEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.TopicThreadCompartmentEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.MapViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.Relationship2ViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.Relationship3ViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.RelationshipLabel2ViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.RelationshipLabel3ViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.RelationshipLabelViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.RelationshipViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ResourceNameEmailViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ResourceViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ThreadItemViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ThreadSubjectViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ThreadThreadItemCompartmentViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ThreadViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.TopicNameViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.TopicSubtopicsViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.TopicThreadCompartmentViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.TopicViewFactory;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MindmapViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (MapEditPart.MODEL_ID.equals(diagramKind)
				&& MindmapVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return MapViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = MindmapVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = MindmapVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!MindmapElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != MindmapVisualIDRegistry.getNodeVisualID(
								containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!MapEditPart.MODEL_ID.equals(MindmapVisualIDRegistry
						.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case TopicEditPart.VISUAL_ID:
				case ResourceEditPart.VISUAL_ID:
				case ThreadEditPart.VISUAL_ID:
				case ThreadItemEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != MindmapVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case TopicNameEditPart.VISUAL_ID:
				case TopicThreadCompartmentEditPart.VISUAL_ID:
					if (TopicEditPart.VISUAL_ID != MindmapVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ResourceNameEmailEditPart.VISUAL_ID:
					if (ResourceEditPart.VISUAL_ID != MindmapVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ThreadSubjectEditPart.VISUAL_ID:
				case ThreadThreadItemCompartmentEditPart.VISUAL_ID:
					if (ThreadEditPart.VISUAL_ID != MindmapVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case RelationshipLabelEditPart.VISUAL_ID:
					if (RelationshipEditPart.VISUAL_ID != MindmapVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case RelationshipLabel2EditPart.VISUAL_ID:
					if (Relationship2EditPart.VISUAL_ID != MindmapVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case RelationshipLabel3EditPart.VISUAL_ID:
					if (Relationship3EditPart.VISUAL_ID != MindmapVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null
				|| !MindmapVisualIDRegistry.canCreateNode(containerView,
						visualID)) {
			return null;
		}
		switch (visualID) {
		case TopicEditPart.VISUAL_ID:
			return TopicViewFactory.class;
		case TopicNameEditPart.VISUAL_ID:
			return TopicNameViewFactory.class;
		case ResourceEditPart.VISUAL_ID:
			return ResourceViewFactory.class;
		case ResourceNameEmailEditPart.VISUAL_ID:
			return ResourceNameEmailViewFactory.class;
		case ThreadEditPart.VISUAL_ID:
			return ThreadViewFactory.class;
		case ThreadSubjectEditPart.VISUAL_ID:
			return ThreadSubjectViewFactory.class;
		case ThreadItemEditPart.VISUAL_ID:
			return ThreadItemViewFactory.class;
		case TopicThreadCompartmentEditPart.VISUAL_ID:
			return TopicThreadCompartmentViewFactory.class;
		case ThreadThreadItemCompartmentEditPart.VISUAL_ID:
			return ThreadThreadItemCompartmentViewFactory.class;
		case RelationshipLabelEditPart.VISUAL_ID:
			return RelationshipLabelViewFactory.class;
		case RelationshipLabel2EditPart.VISUAL_ID:
			return RelationshipLabel2ViewFactory.class;
		case RelationshipLabel3EditPart.VISUAL_ID:
			return RelationshipLabel3ViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!MindmapElementTypes.isKnownElementType(elementType)
				|| (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = MindmapVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != MindmapVisualIDRegistry
						.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case TopicSubtopicsEditPart.VISUAL_ID:
			return TopicSubtopicsViewFactory.class;
		case RelationshipEditPart.VISUAL_ID:
			return RelationshipViewFactory.class;
		case Relationship2EditPart.VISUAL_ID:
			return Relationship2ViewFactory.class;
		case Relationship3EditPart.VISUAL_ID:
			return Relationship3ViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}
}
