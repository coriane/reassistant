package edu.isistan.srseditor.composites;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

public class StakeholderListComposite extends Composite {
	private StakeholderListCompositeController m_controller;

	private List listStakeholders;
	private ListViewer listViewerStakeholders;
	private Button btnAdd;
	private Button btnRemove;

	public StakeholderListComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		listViewerStakeholders = new ListViewer(scrolledComposite, SWT.NONE);
		listStakeholders = listViewerStakeholders.getList();
		scrolledComposite.setContent(listStakeholders);
		scrolledComposite.setMinSize(listStakeholders.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Composite compositeButtons = new Composite(this, SWT.NONE);
		compositeButtons.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		FillLayout fl_compositeButtons = new FillLayout(SWT.VERTICAL);
		fl_compositeButtons.spacing = 5;
		fl_compositeButtons.marginWidth = 5;
		fl_compositeButtons.marginHeight = 5;
		compositeButtons.setLayout(fl_compositeButtons);
		
		btnAdd = new Button(compositeButtons, SWT.NONE);
		btnAdd.setText("Add");
		
		btnRemove = new Button(compositeButtons, SWT.NONE);
		btnRemove.setText("Remove");
		
		m_controller = new StakeholderListCompositeController(this);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public List getListStakeholders() {
		return listStakeholders;
	}
	
	public ListViewer getListViewerStakeholders() {
		return listViewerStakeholders;
	}
	
	public Button getBtnAdd() {
		return btnAdd;
	}
	
	public Button getBtnRemove() {
		return btnRemove;
	}
	
	public StakeholderListCompositeController getController() {
		return m_controller;
	}
}