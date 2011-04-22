/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model.provider;


import edu.isistan.dal.srs.model.SRSModelFactory;

import edu.isistan.dal.srs.model.provider.DocumentItemProvider;

import edu.isistan.dal.ucs.model.UCSModelPackage;
import edu.isistan.dal.ucs.model.Vision;

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
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.isistan.dal.ucs.model.Vision} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VisionItemProvider
	extends DocumentItemProvider
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
	public VisionItemProvider(AdapterFactory adapterFactory) {
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

			addBusinessRequirementsPropertyDescriptor(object);
			addProductOverviewPropertyDescriptor(object);
			addMajorFeaturesPropertyDescriptor(object);
			addScopePropertyDescriptor(object);
			addOthersPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Business Requirements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBusinessRequirementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vision_BusinessRequirements_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vision_BusinessRequirements_feature", "_UI_Vision_type"),
				 UCSModelPackage.Literals.VISION__BUSINESS_REQUIREMENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Product Overview feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProductOverviewPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vision_ProductOverview_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vision_ProductOverview_feature", "_UI_Vision_type"),
				 UCSModelPackage.Literals.VISION__PRODUCT_OVERVIEW,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Major Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMajorFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vision_MajorFeatures_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vision_MajorFeatures_feature", "_UI_Vision_type"),
				 UCSModelPackage.Literals.VISION__MAJOR_FEATURES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Scope feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScopePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vision_Scope_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vision_Scope_feature", "_UI_Vision_type"),
				 UCSModelPackage.Literals.VISION__SCOPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Others feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOthersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vision_Others_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vision_Others_feature", "_UI_Vision_type"),
				 UCSModelPackage.Literals.VISION__OTHERS,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(UCSModelPackage.Literals.VISION__BUSINESS_REQUIREMENTS);
			childrenFeatures.add(UCSModelPackage.Literals.VISION__PRODUCT_OVERVIEW);
			childrenFeatures.add(UCSModelPackage.Literals.VISION__MAJOR_FEATURES);
			childrenFeatures.add(UCSModelPackage.Literals.VISION__SCOPE);
			childrenFeatures.add(UCSModelPackage.Literals.VISION__OTHERS);
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
	 * This returns Vision.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Vision"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Vision)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Vision_type") :
			getString("_UI_Vision_type") + " " + label;
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

		switch (notification.getFeatureID(Vision.class)) {
			case UCSModelPackage.VISION__BUSINESS_REQUIREMENTS:
			case UCSModelPackage.VISION__PRODUCT_OVERVIEW:
			case UCSModelPackage.VISION__MAJOR_FEATURES:
			case UCSModelPackage.VISION__SCOPE:
			case UCSModelPackage.VISION__OTHERS:
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
				(UCSModelPackage.Literals.VISION__BUSINESS_REQUIREMENTS,
				 SRSModelFactory.eINSTANCE.createSection()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.VISION__PRODUCT_OVERVIEW,
				 SRSModelFactory.eINSTANCE.createSection()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.VISION__MAJOR_FEATURES,
				 SRSModelFactory.eINSTANCE.createSection()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.VISION__SCOPE,
				 SRSModelFactory.eINSTANCE.createSection()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.VISION__OTHERS,
				 SRSModelFactory.eINSTANCE.createSection()));
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
			childFeature == UCSModelPackage.Literals.VISION__BUSINESS_REQUIREMENTS ||
			childFeature == UCSModelPackage.Literals.VISION__PRODUCT_OVERVIEW ||
			childFeature == UCSModelPackage.Literals.VISION__MAJOR_FEATURES ||
			childFeature == UCSModelPackage.Literals.VISION__SCOPE ||
			childFeature == UCSModelPackage.Literals.VISION__OTHERS;

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
		return UCSEditPlugin.INSTANCE;
	}

}
