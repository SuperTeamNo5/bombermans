package com.game.bomberman.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.KeyStroke;

import com.game.bomberman.view.MenuView;

import DAO.MusicDAO;

public class MenuViewController implements ActionListener {
	MenuView menuView;
	MainViewController mainViewController;

	public MenuViewController(MenuView menuView, MainViewController mainViewController) {
		this.mainViewController = mainViewController;
		this.menuView = menuView;
		setEventProcessing();
	}

	private void setEventProcessing() {

		menuView.getMniExit().addActionListener(this);
		menuView.getMniFresh().addActionListener(this);
		menuView.getMniLoad().addActionListener(this);
		menuView.getMniSave().addActionListener(this);
		menuView.getInforAuthor().addActionListener(this);

		menuView.getMniExit().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		menuView.getMniFresh().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		menuView.getMniLoad().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		menuView.getMniSave().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuView.getInforAuthor().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainViewController.playSounds(MusicDAO.pressMusic, false);
		if (e.getSource() == menuView.getMniExit()) {
			mainViewController.closing();
		} else if (e.getSource() == menuView.getMniFresh()) {

		} else if (e.getSource() == menuView.getMniLoad()) {

		} else if (e.getSource() == menuView.getMniSave()) {

		} else if (e.getSource() == menuView.getInforAuthor()) {

		}

	}

}
