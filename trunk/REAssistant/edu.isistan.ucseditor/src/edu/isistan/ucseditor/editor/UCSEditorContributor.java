package edu.isistan.ucseditor.editor;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.TextActionHandler;

public class UCSEditorContributor extends EditingDomainActionBarContributor {
	protected TextActionHandler textActionHandler;
	protected Collection<Text> textControls;
	
	@Override
	public void init(IActionBars actionBars) {
		super.init(actionBars);
		textActionHandler = new TextActionHandler(actionBars);
	}
	
	public void setTextControls(Text... texts) {
		if(this.textControls != null)
			for(Text text : this.textControls)
				textActionHandler.removeText(text);
		
		Collection<Text> textControls = new ArrayList<Text>();
		for(Text text : texts)
			textControls.add(text);
		
		this.textControls = textControls;
		
		for(Text text : textControls)
			textActionHandler.addText(text);
	}
	
	public void addTextControls(Text... texts) {
		if(this.textControls == null)
			this.textControls = new ArrayList<Text>();
		
		for(Text text : texts)
			this.textControls.add(text);
		
		for(Text text : texts)
			textActionHandler.addText(text);
	}
	
	public void removeTextControls(Text... texts) {
		if(this.textControls != null) {
			
			for(Text text : texts)
				this.textControls.remove(text);
			
			for(Text text : texts)
				textActionHandler.removeText(text);
		}
	}
}