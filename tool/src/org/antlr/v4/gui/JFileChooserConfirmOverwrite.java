/*
 * Copyright (c) 2012 The ANTLR Project. All rights reserved.
 * Use of this file is governed by the BSD-3-Clause license that
 * can be found in the LICENSE.txt file in the project root.
 */
package org.antlr.v4.gui;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.File;

/**
 *
 * @author Sam Harwell
 */
@SuppressWarnings("serial")
public class JFileChooserConfirmOverwrite extends JFileChooser {

	public JFileChooserConfirmOverwrite() {
		setMultiSelectionEnabled(false);
	}

	@Override
	public void approveSelection() {
		File selectedFile = getSelectedFile();

		if (selectedFile.exists()) {
			int answer = JOptionPane.showConfirmDialog(this,
													   "Overwrite existing file?",
													   "Overwrite?",
													   JOptionPane.YES_NO_OPTION);
			if (answer != JOptionPane.YES_OPTION) {
				// do not call super.approveSelection
				return;
			}
		}

		super.approveSelection();
	}

}
