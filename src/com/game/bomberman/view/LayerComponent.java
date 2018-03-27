package com.game.bomberman.view;

import javax.swing.JLayeredPane;

@SuppressWarnings("serial")
public class LayerComponent extends JLayeredPane {
	
	
	public LayerComponent() {
//		add(new PanelMainView(),JLayeredPane.POPUP_LAYER);
		add(new PanelHighScore(),JLayeredPane.POPUP_LAYER);
	}

}
