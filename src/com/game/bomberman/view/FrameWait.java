package com.game.bomberman.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.game.bomberman.controller.FrameWaitController;

import DAO.ImageDAO;

public class FrameWait {
	public JFrame frame;
	public JFrame loaderFrame;
	FrameWaitController waitViewController;
	ImageDAO imgDAO;

	public FrameWait() {
		frame = new JFrame();
		loaderFrame = new JFrame();
		imgDAO = new ImageDAO();
		loadingView(ImageDAO.backgroundLoader,ImageDAO.loader);
	}

	/* Phương thức khởi tạo màn hình đợi */
	public void loadingView(String imgFrame, String imgLoaderFrame) {
		try {
			frame.setUndecorated(true);
			frame.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));// khong mau nen

			BufferedImage srcLoaderImage = ImageIO.read(getClass().getResource(imgFrame));
			Image newLoaderImage = srcLoaderImage.getScaledInstance(680, 510, java.awt.Image.SCALE_SMOOTH);
			Icon iconLoaderImage = new ImageIcon(newLoaderImage);
			JLabel label1 = new JLabel(iconLoaderImage);
			frame.getContentPane().add(label1);
			frame.pack();
			frame.setLocationRelativeTo(null);
			
			loaderFrame.setUndecorated(true);
			loaderFrame.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));// khong mau nen
			Image srcLoader = new ImageIcon(getClass().getResource(imgLoaderFrame)).getImage();
			Icon iconLoader = new ImageIcon(srcLoader);
			JLabel label2 = new JLabel(iconLoader);
			loaderFrame.getContentPane().add(label2);
			loaderFrame.pack();
			loaderFrame.setLocation(480, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		new FrameWait();
	}
}
