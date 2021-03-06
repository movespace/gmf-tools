/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.gmf.mappings.util.GMFMapAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GMFMapItemProviderAdapterFactory extends GMFMapAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GMFMapItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.NodeMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeMappingItemProvider nodeMappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.NodeMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNodeMappingAdapter() {
		if (nodeMappingItemProvider == null) {
			nodeMappingItemProvider = new NodeMappingItemProvider(this);
		}

		return nodeMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.CompartmentMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompartmentMappingItemProvider compartmentMappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.CompartmentMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompartmentMappingAdapter() {
		if (compartmentMappingItemProvider == null) {
			compartmentMappingItemProvider = new CompartmentMappingItemProvider(this);
		}

		return compartmentMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.LinkMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkMappingItemProvider linkMappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.LinkMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLinkMappingAdapter() {
		if (linkMappingItemProvider == null) {
			linkMappingItemProvider = new LinkMappingItemProvider(this);
		}

		return linkMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.CanvasMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CanvasMappingItemProvider canvasMappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.CanvasMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCanvasMappingAdapter() {
		if (canvasMappingItemProvider == null) {
			canvasMappingItemProvider = new CanvasMappingItemProvider(this);
		}

		return canvasMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.LabelMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelMappingItemProvider labelMappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.LabelMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLabelMappingAdapter() {
		if (labelMappingItemProvider == null) {
			labelMappingItemProvider = new LabelMappingItemProvider(this);
		}

		return labelMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.FeatureLabelMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureLabelMappingItemProvider featureLabelMappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.FeatureLabelMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFeatureLabelMappingAdapter() {
		if (featureLabelMappingItemProvider == null) {
			featureLabelMappingItemProvider = new FeatureLabelMappingItemProvider(this);
		}

		return featureLabelMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.OclChoiceLabelMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclChoiceLabelMappingItemProvider oclChoiceLabelMappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.OclChoiceLabelMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOclChoiceLabelMappingAdapter() {
		if (oclChoiceLabelMappingItemProvider == null) {
			oclChoiceLabelMappingItemProvider = new OclChoiceLabelMappingItemProvider(this);
		}

		return oclChoiceLabelMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.DesignLabelMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DesignLabelMappingItemProvider designLabelMappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.DesignLabelMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDesignLabelMappingAdapter() {
		if (designLabelMappingItemProvider == null) {
			designLabelMappingItemProvider = new DesignLabelMappingItemProvider(this);
		}

		return designLabelMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.ExpressionLabelMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionLabelMappingItemProvider expressionLabelMappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.ExpressionLabelMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExpressionLabelMappingAdapter() {
		if (expressionLabelMappingItemProvider == null) {
			expressionLabelMappingItemProvider = new ExpressionLabelMappingItemProvider(this);
		}

		return expressionLabelMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.Mapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingItemProvider mappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.Mapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMappingAdapter() {
		if (mappingItemProvider == null) {
			mappingItemProvider = new MappingItemProvider(this);
		}

		return mappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.ChildReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildReferenceItemProvider childReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.ChildReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createChildReferenceAdapter() {
		if (childReferenceItemProvider == null) {
			childReferenceItemProvider = new ChildReferenceItemProvider(this);
		}

		return childReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.TopNodeReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopNodeReferenceItemProvider topNodeReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.TopNodeReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTopNodeReferenceAdapter() {
		if (topNodeReferenceItemProvider == null) {
			topNodeReferenceItemProvider = new TopNodeReferenceItemProvider(this);
		}

		return topNodeReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.Constraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintItemProvider constraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.Constraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConstraintAdapter() {
		if (constraintItemProvider == null) {
			constraintItemProvider = new ConstraintItemProvider(this);
		}

		return constraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.LinkConstraints} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkConstraintsItemProvider linkConstraintsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.LinkConstraints}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLinkConstraintsAdapter() {
		if (linkConstraintsItemProvider == null) {
			linkConstraintsItemProvider = new LinkConstraintsItemProvider(this);
		}

		return linkConstraintsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.ValueExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueExpressionItemProvider valueExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.ValueExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createValueExpressionAdapter() {
		if (valueExpressionItemProvider == null) {
			valueExpressionItemProvider = new ValueExpressionItemProvider(this);
		}

		return valueExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.FeatureSeqInitializer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureSeqInitializerItemProvider featureSeqInitializerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.FeatureSeqInitializer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFeatureSeqInitializerAdapter() {
		if (featureSeqInitializerItemProvider == null) {
			featureSeqInitializerItemProvider = new FeatureSeqInitializerItemProvider(this);
		}

		return featureSeqInitializerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.FeatureValueSpec} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureValueSpecItemProvider featureValueSpecItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.FeatureValueSpec}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFeatureValueSpecAdapter() {
		if (featureValueSpecItemProvider == null) {
			featureValueSpecItemProvider = new FeatureValueSpecItemProvider(this);
		}

		return featureValueSpecItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.ReferenceNewElementSpec} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceNewElementSpecItemProvider referenceNewElementSpecItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.ReferenceNewElementSpec}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReferenceNewElementSpecAdapter() {
		if (referenceNewElementSpecItemProvider == null) {
			referenceNewElementSpecItemProvider = new ReferenceNewElementSpecItemProvider(this);
		}

		return referenceNewElementSpecItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.AuditContainer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuditContainerItemProvider auditContainerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.AuditContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAuditContainerAdapter() {
		if (auditContainerItemProvider == null) {
			auditContainerItemProvider = new AuditContainerItemProvider(this);
		}

		return auditContainerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.AuditRule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuditRuleItemProvider auditRuleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.AuditRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAuditRuleAdapter() {
		if (auditRuleItemProvider == null) {
			auditRuleItemProvider = new AuditRuleItemProvider(this);
		}

		return auditRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.DomainElementTarget} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainElementTargetItemProvider domainElementTargetItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.DomainElementTarget}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDomainElementTargetAdapter() {
		if (domainElementTargetItemProvider == null) {
			domainElementTargetItemProvider = new DomainElementTargetItemProvider(this);
		}

		return domainElementTargetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.DomainAttributeTarget} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainAttributeTargetItemProvider domainAttributeTargetItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.DomainAttributeTarget}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDomainAttributeTargetAdapter() {
		if (domainAttributeTargetItemProvider == null) {
			domainAttributeTargetItemProvider = new DomainAttributeTargetItemProvider(this);
		}

		return domainAttributeTargetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.DiagramElementTarget} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramElementTargetItemProvider diagramElementTargetItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.DiagramElementTarget}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDiagramElementTargetAdapter() {
		if (diagramElementTargetItemProvider == null) {
			diagramElementTargetItemProvider = new DiagramElementTargetItemProvider(this);
		}

		return diagramElementTargetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.NotationElementTarget} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotationElementTargetItemProvider notationElementTargetItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.NotationElementTarget}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNotationElementTargetAdapter() {
		if (notationElementTargetItemProvider == null) {
			notationElementTargetItemProvider = new NotationElementTargetItemProvider(this);
		}

		return notationElementTargetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.MetricContainer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricContainerItemProvider metricContainerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.MetricContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetricContainerAdapter() {
		if (metricContainerItemProvider == null) {
			metricContainerItemProvider = new MetricContainerItemProvider(this);
		}

		return metricContainerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.MetricRule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricRuleItemProvider metricRuleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.MetricRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetricRuleAdapter() {
		if (metricRuleItemProvider == null) {
			metricRuleItemProvider = new MetricRuleItemProvider(this);
		}

		return metricRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.AuditedMetricTarget} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuditedMetricTargetItemProvider auditedMetricTargetItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.AuditedMetricTarget}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAuditedMetricTargetAdapter() {
		if (auditedMetricTargetItemProvider == null) {
			auditedMetricTargetItemProvider = new AuditedMetricTargetItemProvider(this);
		}

		return auditedMetricTargetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.mappings.VisualEffectMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisualEffectMappingItemProvider visualEffectMappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.mappings.VisualEffectMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVisualEffectMappingAdapter() {
		if (visualEffectMappingItemProvider == null) {
			visualEffectMappingItemProvider = new VisualEffectMappingItemProvider(this);
		}

		return visualEffectMappingItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (mappingItemProvider != null) mappingItemProvider.dispose();
		if (childReferenceItemProvider != null) childReferenceItemProvider.dispose();
		if (topNodeReferenceItemProvider != null) topNodeReferenceItemProvider.dispose();
		if (nodeMappingItemProvider != null) nodeMappingItemProvider.dispose();
		if (compartmentMappingItemProvider != null) compartmentMappingItemProvider.dispose();
		if (linkMappingItemProvider != null) linkMappingItemProvider.dispose();
		if (canvasMappingItemProvider != null) canvasMappingItemProvider.dispose();
		if (labelMappingItemProvider != null) labelMappingItemProvider.dispose();
		if (featureLabelMappingItemProvider != null) featureLabelMappingItemProvider.dispose();
		if (oclChoiceLabelMappingItemProvider != null) oclChoiceLabelMappingItemProvider.dispose();
		if (designLabelMappingItemProvider != null) designLabelMappingItemProvider.dispose();
		if (expressionLabelMappingItemProvider != null) expressionLabelMappingItemProvider.dispose();
		if (constraintItemProvider != null) constraintItemProvider.dispose();
		if (linkConstraintsItemProvider != null) linkConstraintsItemProvider.dispose();
		if (valueExpressionItemProvider != null) valueExpressionItemProvider.dispose();
		if (featureSeqInitializerItemProvider != null) featureSeqInitializerItemProvider.dispose();
		if (featureValueSpecItemProvider != null) featureValueSpecItemProvider.dispose();
		if (referenceNewElementSpecItemProvider != null) referenceNewElementSpecItemProvider.dispose();
		if (auditContainerItemProvider != null) auditContainerItemProvider.dispose();
		if (auditRuleItemProvider != null) auditRuleItemProvider.dispose();
		if (domainElementTargetItemProvider != null) domainElementTargetItemProvider.dispose();
		if (domainAttributeTargetItemProvider != null) domainAttributeTargetItemProvider.dispose();
		if (diagramElementTargetItemProvider != null) diagramElementTargetItemProvider.dispose();
		if (notationElementTargetItemProvider != null) notationElementTargetItemProvider.dispose();
		if (metricContainerItemProvider != null) metricContainerItemProvider.dispose();
		if (metricRuleItemProvider != null) metricRuleItemProvider.dispose();
		if (auditedMetricTargetItemProvider != null) auditedMetricTargetItemProvider.dispose();
		if (visualEffectMappingItemProvider != null) visualEffectMappingItemProvider.dispose();
	}

}
