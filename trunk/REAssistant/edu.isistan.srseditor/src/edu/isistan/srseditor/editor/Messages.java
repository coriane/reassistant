package edu.isistan.srseditor.editor;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "edu.isistan.srseditor.editor.messages"; //$NON-NLS-1$
	
	public static String SRSEditor_Overview;
	public static String SRSEditor_Stakeholder;
	public static String SRSEditor_Source;
		
	public static String SRSEditor_FilenameDefaultBase;
	public static String SRSEditor_FilenameExtension;
	public static String SRSEditor_OpenEditorErrorLabel;
	
	public static String SRSWizard_Label;
	public static String SRSWizard_Description;
	public static String SRSWizard_Title;
	public static String SRSWizard_WarningFilenameExtension;
	public static String SRSWizard_WarningFilenameExtensions;
	public static String SRSWizard_ProjectName;
	public static String SRSWizard_ProjectContent;
	public static String SRSWizard_DefaultProjectName;
	public static String SRSWizard_DefaultProjectContent;
	public static String SRSWizard_XMLEncoding;
	public static String SRSWizard_XMLEncodingChoices;
	public static String SRSWizard_InitialDescription;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
