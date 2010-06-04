/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.xcardconsulting.jcardkit.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.jdt.ui.JavaUI;


/**
 *  This class is meant to serve as an example for how various contributions 
 *  are made to a perspective. Note that some of the extension point id's are
 *  referred to as API constants while others are hardcoded and may be subject 
 *  to change. 
 */
public class JCardKitPerspective implements IPerspectiveFactory {

	private static final String APPLETS_VIEW_ID = "com.xcardconsulting.jcardkit.views.AppletsView";
	private static final String CREF_VIEW_ID = "com.xcardconsulting.jcardkit.views.CrefSimulatorView";
	private static final String JC_EDITOR_ID = "com.xcardconsulting.jcardkit.editors.JCardKitEditor";
	
	private IPageLayout factory;

	public JCardKitPerspective() {
		super();
	}

	public void createInitialLayout(IPageLayout factory) {
		this.factory = factory;
		addViews();
	}

	private void addViews() {
		// Creates the overall folder layout. 
		// Note that each new Folder uses a percentage of the remaining EditorArea.
		
		IFolderLayout bottom =
			factory.createFolder(
				"bottomRight", //NON-NLS-1
				IPageLayout.BOTTOM,
				0.75f,
				factory.getEditorArea());
				
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		bottom.addPlaceholder(IConsoleConstants.ID_CONSOLE_VIEW);
		bottom.addView(CREF_VIEW_ID);
		

		IFolderLayout topLeft =
			factory.createFolder(
				"topLeft", //NON-NLS-1
				IPageLayout.LEFT,
				0.25f,
				factory.getEditorArea());		
		topLeft.addView(IPageLayout.ID_PROJECT_EXPLORER);
		
		IFolderLayout topRight =
			factory.createFolder(
				"topRight", //NON-NLS-1
				IPageLayout.RIGHT,
				0.75f,
				factory.getEditorArea());
		
		topRight.addView(APPLETS_VIEW_ID);	
		
		
		factory.addFastView("org.eclipse.team.ccvs.ui.RepositoriesView",0.50f); //NON-NLS-1
		factory.addFastView("org.eclipse.team.sync.views.SynchronizeView", 0.50f); //NON-NLS-1
	}

}
