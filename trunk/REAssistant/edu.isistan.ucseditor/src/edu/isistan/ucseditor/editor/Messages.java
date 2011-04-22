package edu.isistan.ucseditor.editor;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "edu.isistan.ucseditor.editor.messages"; //$NON-NLS-1$
	
	public static String UCSEditor_Overview;
	public static String UCSEditor_ProblemStatement;
	public static String UCSEditor_Vision;
	public static String UCSEditor_Actor;
	public static String UCSEditor_UseCaseSpecification;
	public static String UCSEditor_SupplementarySpecification;
	public static String UCSEditor_Glossary;
	public static String UCSEditor_Source;
		
	public static String UCSEditor_FilenameDefaultBase;
	public static String UCSEditor_FilenameExtension;
	public static String UCSEditor_OpenEditorErrorLabel;
	
	public static String UCSWizard_Label;
	public static String UCSWizard_Description;
	public static String UCSWizard_Title;
	public static String UCSWizard_WarningFilenameExtension;
	public static String UCSWizard_WarningFilenameExtensions;
	public static String UCSWizard_ProjectName;
	public static String UCSWizard_ProjectContent;
	public static String UCSWizard_DefaultProjectName;
	public static String UCSWizard_DefaultProjectContent;
	public static String UCSWizard_XMLEncoding;
	public static String UCSWizard_XMLEncodingChoices;
	public static String UCSWizard_InitialDescription;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
