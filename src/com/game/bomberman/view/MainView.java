package com.game.bomberman.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import DAO.ImageDAO;

/**
 * Shika 3/20/2018
 */
@SuppressWarnings("serial")
public class MainView extends JFrame{
	private PanelMainView pnlView;
	private BufferedImage myImage;
	private Image newLoaderImage;
	private MenuView menubar;
	private JLayeredPane layerPane;

	public static void main(String[] args) {
		new MainView();
	}

	public MainView() {
		try {
			layerPane = new JLayeredPane();
			menubar= new MenuView();
			pnlView = new PanelMainView();
			view();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// view TOTAL
	public void view() throws IOException {
		try {
			/*
			 * Thuc hien phuong thuc o duoi se cho ra giao hien khac voi giao dien mac dinh
			 * cua swing
			 */
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//change cursor icon 
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			BufferedImage myImages = ImageIO.read(getClass().getResource(ImageDAO.cursorBasicIcon));
			
			Cursor cursor = toolkit.createCustomCursor(myImages , new Point(this.getX(), 
			           this.getY()), "img");
			setCursor (cursor);
			//set layeredpane cho panel cua cac nut duoc popup
			setLayeredPane(layerPane);
			// Tạo hình nền
			myImage = ImageIO.read(getClass().getResource(ImageDAO.backgroundImage));
			newLoaderImage = myImage.getScaledInstance(780, 620, java.awt.Image.SCALE_SMOOTH);
			setContentPane(new JLabel(new ImageIcon(newLoaderImage)));
			setLayout(new BorderLayout());
			// Tạo Menubar
			setTitle("Bomberman");
			// Create the menu
			setJMenuBar(menubar);
			// add panel main view
			layerPane.add(getPnlView(),JLayeredPane.POPUP_LAYER);
			// icon of application
			Image imgAvatar1 = ImageIO.read(getClass().getResource(ImageDAO.boomIcon));
			setIconImage(imgAvatar1);
			// set attribute
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			setSize(new Dimension(780, 620));
			setLocationRelativeTo(null);// Location default is middle
			setResizable(false);// None resizable a window
			setVisible(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	public PanelMainView getPnlView() {
		return pnlView;
	}

	public void setPnlView(PanelMainView pnlView) {
		this.pnlView = pnlView;
	}

	public BufferedImage getMyImage() {
		return myImage;
	}

	public void setMyImage(BufferedImage myImage) {
		this.myImage = myImage;
	}

	public MenuView getMenubar() {
		return menubar;
	}

	public void setMenubar(MenuView menubar) {
		this.menubar = menubar;
	}
	
	

}
