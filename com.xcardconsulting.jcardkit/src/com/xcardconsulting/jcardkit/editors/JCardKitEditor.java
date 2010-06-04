package com.xcardconsulting.jcardkit.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class JCardKitEditor extends TextEditor {

	private ColorManager colorManager;

	public JCardKitEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
