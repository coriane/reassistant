/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model.provider;


import edu.isistan.reassistant.ccdetector.model.CCDetectorModelFactory;
import edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CrosscuttingConcernRuleItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrosscuttingConcernRuleItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addMetadataPropertyDescriptor(object);
			addCompositionGuidelinesPropertyDescriptor(object);
			addCompositionRulePropertyDescriptor(object);
			addIDPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addEnabledPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Metadata feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMetadataPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CrosscuttingConcernRule_Metadata_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CrosscuttingConcernRule_Metadata_feature", "_UI_CrosscuttingConcernRule_type"),
				 CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__METADATA,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Composition Guidelines feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCompositionGuidelinesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CrosscuttingConcernRule_CompositionGuidelines_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CrosscuttingConcernRule_CompositionGuidelines_feature", "_UI_CrosscuttingConcernRule_type"),
				 CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__COMPOSITION_GUIDELINES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Composition Rule feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCompositionRulePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CrosscuttingConcernRule_CompositionRule_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CrosscuttingConcernRule_CompositionRule_feature", "_UI_CrosscuttingConcernRule_type"),
				 CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__COMPOSITION_RULE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CrosscuttingConcernRule_ID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CrosscuttingConcernRule_ID_feature", "_UI_CrosscuttingConcernRule_type"),
				 CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CrosscuttingConcernRule_Name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CrosscuttingConcernRule_Name_feature", "_UI_CrosscuttingConcernRule_type"),
				 CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CrosscuttingConcernRule_Enabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CrosscuttingConcernRule_Enabled_feature", "_UI_CrosscuttingConcernRule_type"),
				 CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET);
			childrenFeatures.add(CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns CrosscuttingConcernRule.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CrosscuttingConcernRule"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CrosscuttingConcernRule)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_CrosscuttingConcernRule_type") :
			getString("_UI_CrosscuttingConcernRule_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(CrosscuttingConcernRule.class)) {
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__METADATA:
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_GUIDELINES:
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__COMPOSITION_RULE:
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ID:
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__NAME:
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__ENABLED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET:
			case CCDetectorModelPackage.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET,
				 CCDetectorModelFactory.eINSTANCE.createQuerySet()));

		newChildDescriptors.add
			(createChildParameter
				(CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET,
				 CCDetectorModelFactory.eINSTANCE.createQuerySet()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__DIRECT_QUERY_SET ||
			childFeature == CCDetectorModelPackage.Literals.CROSSCUTTING_CONCERN_RULE__IMPACT_QUERY_SET;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CcdetectorEditPlugin.INSTANCE;
	}

}
