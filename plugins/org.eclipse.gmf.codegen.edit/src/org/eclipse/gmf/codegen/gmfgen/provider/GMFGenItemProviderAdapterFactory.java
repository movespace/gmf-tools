/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.provider;

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

import org.eclipse.gmf.codegen.gmfgen.util.GMFGenAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GMFGenItemProviderAdapterFactory extends GMFGenAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	protected Collection supportedTypes = new ArrayList();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GMFGenItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);		
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.codegen.gmfgen.GenDiagram} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDiagramItemProvider genDiagramItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.codegen.gmfgen.GenDiagram}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createGenDiagramAdapter() {
		if (genDiagramItemProvider == null) {
			genDiagramItemProvider = new GenDiagramItemProvider(this);
		}

		return genDiagramItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.codegen.gmfgen.GenNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenNodeItemProvider genNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.codegen.gmfgen.GenNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createGenNodeAdapter() {
		if (genNodeItemProvider == null) {
			genNodeItemProvider = new GenNodeItemProvider(this);
		}

		return genNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.codegen.gmfgen.GenChildNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenChildNodeItemProvider genChildNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.codegen.gmfgen.GenChildNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createGenChildNodeAdapter() {
		if (genChildNodeItemProvider == null) {
			genChildNodeItemProvider = new GenChildNodeItemProvider(this);
		}

		return genChildNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.codegen.gmfgen.GenChildContainer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenChildContainerItemProvider genChildContainerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.codegen.gmfgen.GenChildContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createGenChildContainerAdapter() {
		if (genChildContainerItemProvider == null) {
			genChildContainerItemProvider = new GenChildContainerItemProvider(this);
		}

		return genChildContainerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenLinkWithClassItemProvider genLinkWithClassItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createGenLinkWithClassAdapter() {
		if (genLinkWithClassItemProvider == null) {
			genLinkWithClassItemProvider = new GenLinkWithClassItemProvider(this);
		}

		return genLinkWithClassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.codegen.gmfgen.GenLinkReferenceOnly} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenLinkReferenceOnlyItemProvider genLinkReferenceOnlyItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.codegen.gmfgen.GenLinkReferenceOnly}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createGenLinkReferenceOnlyAdapter() {
		if (genLinkReferenceOnlyItemProvider == null) {
			genLinkReferenceOnlyItemProvider = new GenLinkReferenceOnlyItemProvider(this);
		}

		return genLinkReferenceOnlyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.codegen.gmfgen.Palette} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PaletteItemProvider paletteItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.codegen.gmfgen.Palette}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createPaletteAdapter() {
		if (paletteItemProvider == null) {
			paletteItemProvider = new PaletteItemProvider(this);
		}

		return paletteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.codegen.gmfgen.NodeEntry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeEntryItemProvider nodeEntryItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.codegen.gmfgen.NodeEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createNodeEntryAdapter() {
		if (nodeEntryItemProvider == null) {
			nodeEntryItemProvider = new NodeEntryItemProvider(this);
		}

		return nodeEntryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.codegen.gmfgen.LinkEntry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkEntryItemProvider linkEntryItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.codegen.gmfgen.LinkEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createLinkEntryAdapter() {
		if (linkEntryItemProvider == null) {
			linkEntryItemProvider = new LinkEntryItemProvider(this);
		}

		return linkEntryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmf.codegen.gmfgen.ToolGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolGroupItemProvider toolGroupItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmf.codegen.gmfgen.ToolGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createToolGroupAdapter() {
		if (toolGroupItemProvider == null) {
			toolGroupItemProvider = new ToolGroupItemProvider(this);
		}

		return toolGroupItemProvider;
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
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class)type).isInstance(adapter))) {
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
		if (genDiagramItemProvider != null) genDiagramItemProvider.dispose();
		if (genNodeItemProvider != null) genNodeItemProvider.dispose();
		if (genChildNodeItemProvider != null) genChildNodeItemProvider.dispose();
		if (genChildContainerItemProvider != null) genChildContainerItemProvider.dispose();
		if (genLinkWithClassItemProvider != null) genLinkWithClassItemProvider.dispose();
		if (genLinkReferenceOnlyItemProvider != null) genLinkReferenceOnlyItemProvider.dispose();
		if (paletteItemProvider != null) paletteItemProvider.dispose();
		if (nodeEntryItemProvider != null) nodeEntryItemProvider.dispose();
		if (linkEntryItemProvider != null) linkEntryItemProvider.dispose();
		if (toolGroupItemProvider != null) toolGroupItemProvider.dispose();
	}

}
