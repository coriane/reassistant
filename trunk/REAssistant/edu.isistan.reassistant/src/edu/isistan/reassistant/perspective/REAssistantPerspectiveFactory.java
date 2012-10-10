package edu.isistan.reassistant.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class REAssistantPerspectiveFactory implements IPerspectiveFactory {

	@SuppressWarnings("unused")
	private static final String VIEW_ID = "edu.isistan.reassistant.perspective.REAssistantPerspectiveFactory";

	public void createInitialLayout(IPageLayout layout) {
	    defineActions(layout);
	    defineLayout(layout);
	}
	
	public void defineActions(IPageLayout layout) {
        // Add "new wizards".
        layout.addNewWizardShortcut("edu.isistan.ucseditor.wizards.UCSWizard");
        layout.addNewWizardShortcut("edu.isistan.uima.wizards.UIMAWizard");
        layout.addNewWizardShortcut("edu.isistan.reassistant.wizards.REAssistantWizard");
        // Add "show views".
        // Visualiser
        layout.addShowViewShortcut("org.eclipse.contribution.visualiser.views.Menu");
        layout.addShowViewShortcut("org.eclipse.contribution.visualiser.views.Visualiser");
        // REAssistant
        layout.addShowViewShortcut("edu.isistan.reassistant.ccdetector.gui.view.CCDetectorViewPart");
        layout.addShowViewShortcut("edu.isistan.reassistant.evaluator.gui.view.EvaluatorViewPart");
}
	
	@SuppressWarnings("deprecation")
	public void defineLayout(IPageLayout layout) {
        // Editors are placed for free.
        String editorArea = layout.getEditorArea();
        // Place navigator and outline to left of editor area.
        IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, 0.26f, editorArea);
        left.addView(IPageLayout.ID_RES_NAV);
        IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.76f, editorArea);
        bottom.addView("edu.isistan.reassistant.ccdetector.gui.view.CCDetectorViewPart");
        bottom.addView("edu.isistan.reassistant.evaluator.gui.view.EvaluatorViewPart");
        bottom.addView("org.eclipse.contribution.visualiser.views.Visualiser");
        IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, 0.74f, editorArea);
        right.addView("org.eclipse.contribution.visualiser.views.Menu");
	}
}
