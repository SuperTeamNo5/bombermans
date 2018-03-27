package com.game.bomberman.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.game.bomberman.view.PanelHighScore;

import DAO.ImageDAO;
import DAO.MusicDAO;
import DAO.ScoreDAO;

public class PanelHighScoreController implements MouseListener {
	PanelHighScore guiHighScore;
	JFrame frame;
	JPanel pnlView;
	ScoreDAO scoreDAO;
	MainViewController mainViewController;
	MusicDAO musicDAO;

	private BufferedImage bufferImage;

	public PanelHighScoreController(JFrame frame, MainViewController mainViewController) {
		this.frame = frame;
		this.mainViewController = mainViewController;
		scoreDAO = new ScoreDAO();
		guiHighScore = new PanelHighScore();
	}

	public void setEventProcessing() {
		guiHighScore.getLblBtnBack().addMouseListener(this);
	}

	/*
	 * This method will set up View high score, change about abstract frame's
	 * background
	 */
	public void setUpView() {
		try {
			bufferImage = ImageIO.read(getClass().getResource(ImageDAO.backgroundHighScore));
			Image newLoaderImage = bufferImage.getScaledInstance(780, 620, java.awt.Image.SCALE_SMOOTH);
			frame.setContentPane(new JLabel(new ImageIcon(newLoaderImage)));
			pnlView = guiHighScore.pnlView();
			frame.add(pnlView, BorderLayout.CENTER);
			printHighScore();
			setEventProcessing();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	/*
	 * This method will print 10 high score, and display them in the screen
	 */
	public void printHighScore() {
		for (int i = 0; i < 10; i++) {
			guiHighScore.setLblNumber(new JLabel("", SwingConstants.CENTER));
			guiHighScore.getLblNumber().setFont(new Font("Times New Roman", Font.BOLD, 23));
			guiHighScore.getLblNumber().setForeground(new Color(255, 255, 255));
			guiHighScore.getLblNumber().setText("" + (i + 1));
			guiHighScore.getPnlHighScore().add(guiHighScore.getLblNumber());

			guiHighScore.setLblName((new JLabel()));
			guiHighScore.getLblName().setFont(new Font("Times New Roman", Font.BOLD, 23));
			guiHighScore.getLblName().setForeground(new Color(255, 255, 255));
			guiHighScore.getLblName().setText(scoreDAO.getDataScore().get(i).getName());
			guiHighScore.getPnlHighScore().add(guiHighScore.getLblName());

			guiHighScore.setLblScore((new JLabel("", SwingConstants.CENTER)));
			guiHighScore.getLblScore().setFont(new Font("Times New Roman", Font.BOLD, 23));
			guiHighScore.getLblScore().setForeground(new Color(255, 255, 255));
			guiHighScore.getLblScore().setText(scoreDAO.getDataScore().get(i).getScore() + "");
			guiHighScore.getPnlHighScore().add(guiHighScore.getLblScore());
		}
	}

	public void setAttributeOfLabel(String imgIcon, JLabel lblItem) {
		try {
			BufferedImage myImage = ImageIO.read(getClass().getResource(imgIcon));
			lblItem.setIcon(new ImageIcon(myImage));
			lblItem.setBackground(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pnlView.setVisible(false);
		mainViewController.playSounds(MusicDAO.pressMusic, false);
		mainViewController.setMainView(true);
		frame.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setAttributeOfLabel(ImageDAO.sbackIcon, guiHighScore.getLblBtnBack());
		mainViewController.playSounds(MusicDAO.enteredMusic, false);
		frame.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setAttributeOfLabel(ImageDAO.backIcon, guiHighScore.getLblBtnBack());
		frame.repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
