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
import edu.isistan.dal.ucs.model.UseCaseSpecification;

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
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.isistan.dal.ucs.model.UseCaseSpecification} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UseCaseSpecificationItemProvider
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
	public UseCaseSpecificationItemProvider(AdapterFactory adapterFactory) {
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

			addStereotypePropertyDescriptor(object);
			addMainActorPropertyDescriptor(object);
			addBasicFlowPropertyDescriptor(object);
			addAlternativeFlowsPropertyDescriptor(object);
			addPreconditionsPropertyDescriptor(object);
			addPostconditionsPropertyDescriptor(object);
			addSpecialRequirementsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Stereotype feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStereotypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Stereotypeable_Stereotype_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Stereotypeable_Stereotype_feature", "_UI_Stereotypeable_type"),
				 UCSModelPackage.Literals.STEREOTYPEABLE__STEREOTYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Main Actor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMainActorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCaseSpecification_MainActor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCaseSpecification_MainActor_feature", "_UI_UseCaseSpecification_type"),
				 UCSModelPackage.Literals.USE_CASE_SPECIFICATION__MAIN_ACTOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Basic Flow feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBasicFlowPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCaseSpecification_BasicFlow_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCaseSpecification_BasicFlow_feature", "_UI_UseCaseSpecification_type"),
				 UCSModelPackage.Literals.USE_CASE_SPECIFICATION__BASIC_FLOW,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Alternative Flows feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAlternativeFlowsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCaseSpecification_AlternativeFlows_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCaseSpecification_AlternativeFlows_feature", "_UI_UseCaseSpecification_type"),
				 UCSModelPackage.Literals.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Preconditions feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPreconditionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCaseSpecification_Preconditions_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCaseSpecification_Preconditions_feature", "_UI_UseCaseSpecification_type"),
				 UCSModelPackage.Literals.USE_CASE_SPECIFICATION__PRECONDITIONS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Postconditions feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPostconditionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCaseSpecification_Postconditions_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCaseSpecification_Postconditions_feature", "_UI_UseCaseSpecification_type"),
				 UCSModelPackage.Literals.USE_CASE_SPECIFICATION__POSTCONDITIONS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Special Requirements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpecialRequirementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UseCaseSpecification_SpecialRequirements_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_UseCaseSpecification_SpecialRequirements_feature", "_UI_UseCaseSpecification_type"),
				 UCSModelPackage.Literals.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS,
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
			childrenFeatures.add(UCSModelPackage.Literals.USE_CASE_SPECIFICATION__BASIC_FLOW);
			childrenFeatures.add(UCSModelPackage.Literals.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS);
			childrenFeatures.add(UCSModelPackage.Literals.USE_CASE_SPECIFICATION__PRECONDITIONS);
			childrenFeatures.add(UCSModelPackage.Literals.USE_CASE_SPECIFICATION__POSTCONDITIONS);
			childrenFeatures.add(UCSModelPackage.Literals.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS);
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
	 * This returns UseCaseSpecification.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/UseCaseSpecification"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((UseCaseSpecification)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_UseCaseSpecification_type") :
			getString("_UI_UseCaseSpecification_type") + " " + label;
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

		switch (notification.getFeatureID(UseCaseSpecification.class)) {
			case UCSModelPackage.USE_CASE_SPECIFICATION__STEREOTYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case UCSModelPackage.USE_CASE_SPECIFICATION__BASIC_FLOW:
			case UCSModelPackage.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS:
			case UCSModelPackage.USE_CASE_SPECIFICATION__PRECONDITIONS:
			case UCSModelPackage.USE_CASE_SPECIFICATION__POSTCONDITIONS:
			case UCSModelPackage.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS:
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
				(UCSModelPackage.Literals.USE_CASE_SPECIFICATION__BASIC_FLOW,
				 SRSModelFactory.eINSTANCE.createSection()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS,
				 SRSModelFactory.eINSTANCE.createSection()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.USE_CASE_SPECIFICATION__PRECONDITIONS,
				 SRSModelFactory.eINSTANCE.createSection()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.USE_CASE_SPECIFICATION__POSTCONDITIONS,
				 SRSModelFactory.eINSTANCE.createSection()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS,
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
			childFeature == UCSModelPackage.Literals.USE_CASE_SPECIFICATION__BASIC_FLOW ||
			childFeature == UCSModelPackage.Literals.USE_CASE_SPECIFICATION__ALTERNATIVE_FLOWS ||
			childFeature == UCSModelPackage.Literals.USE_CASE_SPECIFICATION__PRECONDITIONS ||
			childFeature == UCSModelPackage.Literals.USE_CASE_SPECIFICATION__POSTCONDITIONS ||
			childFeature == UCSModelPackage.Literals.USE_CASE_SPECIFICATION__SPECIAL_REQUIREMENTS;

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
