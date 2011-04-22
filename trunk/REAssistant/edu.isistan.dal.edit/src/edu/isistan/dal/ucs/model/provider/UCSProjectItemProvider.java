/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.dal.ucs.model.provider;


import edu.isistan.dal.srs.model.provider.ProjectItemProvider;

import edu.isistan.dal.ucs.model.UCSModelFactory;
import edu.isistan.dal.ucs.model.UCSModelPackage;
import edu.isistan.dal.ucs.model.UCSProject;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.isistan.dal.ucs.model.UCSProject} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UCSProjectItemProvider
	extends ProjectItemProvider
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
	public UCSProjectItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(UCSModelPackage.Literals.UCS_PROJECT__ACTORS);
			childrenFeatures.add(UCSModelPackage.Literals.UCS_PROJECT__USE_CASE_SPECIFICATIONS);
			childrenFeatures.add(UCSModelPackage.Literals.UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS);
			childrenFeatures.add(UCSModelPackage.Literals.UCS_PROJECT__PROBLEM_STATEMENT);
			childrenFeatures.add(UCSModelPackage.Literals.UCS_PROJECT__GLOSSARY);
			childrenFeatures.add(UCSModelPackage.Literals.UCS_PROJECT__VISION);
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
	 * This returns UCSProject.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/UCSProject"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((UCSProject)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_UCSProject_type") :
			getString("_UI_UCSProject_type") + " " + label;
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

		switch (notification.getFeatureID(UCSProject.class)) {
			case UCSModelPackage.UCS_PROJECT__ACTORS:
			case UCSModelPackage.UCS_PROJECT__USE_CASE_SPECIFICATIONS:
			case UCSModelPackage.UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS:
			case UCSModelPackage.UCS_PROJECT__PROBLEM_STATEMENT:
			case UCSModelPackage.UCS_PROJECT__GLOSSARY:
			case UCSModelPackage.UCS_PROJECT__VISION:
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
				(UCSModelPackage.Literals.UCS_PROJECT__ACTORS,
				 UCSModelFactory.eINSTANCE.createActor()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.UCS_PROJECT__USE_CASE_SPECIFICATIONS,
				 UCSModelFactory.eINSTANCE.createUseCaseSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.UCS_PROJECT__SUPPLEMENTARY_SPECIFICATIONS,
				 UCSModelFactory.eINSTANCE.createSupplementarySpecification()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.UCS_PROJECT__PROBLEM_STATEMENT,
				 UCSModelFactory.eINSTANCE.createProblemStatement()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.UCS_PROJECT__GLOSSARY,
				 UCSModelFactory.eINSTANCE.createGlossary()));

		newChildDescriptors.add
			(createChildParameter
				(UCSModelPackage.Literals.UCS_PROJECT__VISION,
				 UCSModelFactory.eINSTANCE.createVision()));
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
