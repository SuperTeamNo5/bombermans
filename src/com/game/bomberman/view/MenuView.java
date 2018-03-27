package com.game.bomberman.view;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import DAO.ImageDAO;

@SuppressWarnings("serial")
public class MenuView extends JMenuBar {
	private JMenu mnuFile, mnuIfor, mnuHelp;
	private JMenuItem mniFresh, mniExit, mniSave, mniLoad, inforAuthor;

	public MenuView() {
		setMenuBar();
	}

	// menuBar
	public void setMenuBar() {
		mnuFile = new JMenu("File");
		mnuFile.setIcon(new ImageIcon(getClass().getResource(ImageDAO.fileIcon)));
		// mnuFile.setMnemonic(KeyEvent.VK_F);

		mniFresh = new JMenuItem("New game");
		mniFresh.setIcon(new ImageIcon(getClass().getResource(ImageDAO.refreshIcon)));
		mniFresh.setEnabled(false);
		mnuFile.add(mniFresh);

		mniSave = new JMenuItem("Save game");
		mniSave.setIcon(new ImageIcon(getClass().getResource(ImageDAO.saveIcon)));
		mniSave.setEnabled(false);
		mnuFile.add(mniSave);

		mniLoad = new JMenuItem("Load game");
		mniLoad.setIcon(new ImageIcon(getClass().getResource(ImageDAO.loadIcon)));
		mnuFile.add(mniLoad);

		mniExit = new JMenuItem("Exit");
		mniExit.add(new JSeparator());
		mniExit.setIcon(new ImageIcon(getClass().getResource(ImageDAO.exitIcon)));
		mnuFile.add(mniExit);

		mnuIfor = new JMenu("About");
		mnuIfor.setIcon(new ImageIcon(getClass().getResource(ImageDAO.mailIcon)));

		mnuHelp = new JMenu("Help");
		mnuHelp.setIcon(new ImageIcon(getClass().getResource(ImageDAO.helpIcon)));

		inforAuthor = new JMenuItem("Contract");
		inforAuthor.setIcon(new ImageIcon(getClass().getResource(ImageDAO.communicationIcon)));
		mnuIfor.add(inforAuthor);

		add(mnuFile);
		add(mnuHelp);
		add(mnuIfor);
	}

	public JMenu getMnuFile() {
		return mnuFile;
	}

	public void setMnuFile(JMenu mnuFile) {
		this.mnuFile = mnuFile;
	}

	public JMenu getMnuIfor() {
		return mnuIfor;
	}

	public void setMnuIfor(JMenu mnuIfor) {
		this.mnuIfor = mnuIfor;
	}

	public JMenu getMnuHelp() {
		return mnuHelp;
	}

	public void setMnuHelp(JMenu mnuHelp) {
		this.mnuHelp = mnuHelp;
	}

	public JMenuItem getMniFresh() {
		return mniFresh;
	}

	public void setMniFresh(JMenuItem mniFresh) {
		this.mniFresh = mniFresh;
	}

	public JMenuItem getMniExit() {
		return mniExit;
	}

	public void setMniExit(JMenuItem mniExit) {
		this.mniExit = mniExit;
	}

	public JMenuItem getMniSave() {
		return mniSave;
	}

	public void setMniSave(JMenuItem mniSave) {
		this.mniSave = mniSave;
	}

	public JMenuItem getMniLoad() {
		return mniLoad;
	}

	public void setMniLoad(JMenuItem mniLoad) {
		this.mniLoad = mniLoad;
	}

	public JMenuItem getInforAuthor() {
		return inforAuthor;
	}

	public void setInforAuthor(JMenuItem inforAuthor) {
		this.inforAuthor = inforAuthor;
	}
	
	

}
