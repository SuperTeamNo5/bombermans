package com.game.bomberman.view;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.ImageDAO;

@SuppressWarnings("serial")
public class PanelMainView extends JPanel {
	private JLabel lblPlayer1, lblPlayer2, lblHighScore, lblOption, lblQuit, lblWelcome, lblAvatar;

	public PanelMainView() {
		add(getButtonPlayer1());
		add(getButtonPlayer2());
		add(getButtonHighScore());
		add(getButtonOption());
		add(getButtonQuit());
		add(getWelcomeAnimation());
		add(getAvatarAnimation());
		setVisible(true);
		setLayout(new BorderLayout());
		setBounds(0, 0, 780, 620);
		setOpaque(false);
	}

	// This method will display the welcome text animation
	public void setAttributeOfLabel(String imgIcon, JLabel lblItem) {
		try {
			BufferedImage myImage = ImageIO.read(getClass().getResource(imgIcon));
			lblItem.setIcon(new ImageIcon(myImage));
			lblItem.setBackground(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public JLabel getWelcomeAnimation() {
		lblWelcome = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource(ImageDAO.welcomeImage));
		lblWelcome.setIcon(icon);
		lblWelcome.setBackground(null);
		lblWelcome.setBounds(280, 110, 324, 126);
		return lblWelcome;
	}

	// This method will display the character animation
	public JLabel getAvatarAnimation() {
		lblAvatar = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource(ImageDAO.avatarImage));
		lblAvatar.setIcon(icon);
		lblAvatar.setBackground(null);
		lblAvatar.setBounds(170, 430, 324, 126);
		return lblAvatar;
	}

	private JLabel getButtonPlayer1() {
		lblPlayer1 = new JLabel();
		setAttributeOfLabel(ImageDAO.player1Icon, lblPlayer1);
		lblPlayer1.setBounds(90, 210, 155, 60);
		return lblPlayer1;
	}

	private JLabel getButtonPlayer2() {
		lblPlayer2 = new JLabel();
		setAttributeOfLabel(ImageDAO.player2Icon, lblPlayer2);
		lblPlayer2.setBounds(90, 275, 155, 60);
		return lblPlayer2;
	}

	private JLabel getButtonHighScore() {
		lblHighScore = new JLabel();
		setAttributeOfLabel(ImageDAO.highScoreIcon, lblHighScore);
		lblHighScore.setBounds(90, 275 + 60, 155, 60);
		return lblHighScore;
	}

	private JLabel getButtonOption() {
		lblOption = new JLabel();
		setAttributeOfLabel(ImageDAO.optionIcon, lblOption);
		lblOption.setBounds(90, 275 + 60 + 60, 155, 60);
		return lblOption;
	}

	private JLabel getButtonQuit() {
		lblQuit = new JLabel();
		setAttributeOfLabel(ImageDAO.quitIcon, lblQuit);
		lblQuit.setBounds(65, 275 + 60 + 60 + 60, 155, 60);
		return lblQuit;
	}

	public JLabel getLblPlayer1() {
		return lblPlayer1;
	}

	public void setLblPlayer1(JLabel lblPlayer1) {
		this.lblPlayer1 = lblPlayer1;
	}

	public JLabel getLblPlayer2() {
		return lblPlayer2;
	}

	public void setLblPlayer2(JLabel lblPlayer2) {
		this.lblPlayer2 = lblPlayer2;
	}

	public JLabel getLblHighScore() {
		return lblHighScore;
	}

	public void setLblHighScore(JLabel lblHighScore) {
		this.lblHighScore = lblHighScore;
	}

	public JLabel getLblOption() {
		return lblOption;
	}

	public void setLblOption(JLabel lblOption) {
		this.lblOption = lblOption;
	}

	public JLabel getLblQuit() {
		return lblQuit;
	}

	public void setLblQuit(JLabel lblQuit) {
		this.lblQuit = lblQuit;
	}

}
