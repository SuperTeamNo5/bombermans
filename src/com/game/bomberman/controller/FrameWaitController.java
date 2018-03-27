package com.game.bomberman.controller;

import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import com.game.bomberman.view.FrameWait;

public class FrameWaitController {
	FrameWait waitView;

	public FrameWaitController() {
		waitView = new FrameWait();
		setLoader(waitView.frame, waitView.loaderFrame);
	}

	// This method will return a random number in the given instance
	public int randomRange(int min, int max) {
		Random r = new Random();
		return max - r.nextInt(min);
	}

	// Method playSound
	public void playSound() {// sound
		try {
			AudioInputStream audioIn;
			audioIn = AudioSystem.getAudioInputStream(getClass().getResource("/musics/Windows Shutdown.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			System.out.println(audioIn.getFormat());
			clip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * This method receive 2 jframes and they are setvisible true for display
	 * (thread)
	 */

	public void setLoader(JFrame frame, JFrame loaderFrame) {
		frame.setVisible(true);
		loaderFrame.setVisible(true);
		try {
			// waitViewController.playSound();
			Thread.sleep(randomRange(2000, 3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		 frame.setVisible(false);
		 loaderFrame.setVisible(false);
//		System.exit(0);
	}

	public static void main(String[] args) {
		new FrameWaitController();
	}

}
