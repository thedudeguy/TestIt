package com.chrischurchwell.testit.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.sound.SoundEffect;

import com.chrischurchwell.testit.TestIt;
import com.chrischurchwell.testit.material.SoundEmitter;

public class PlayButton extends GenericButton {

	private SpoutBlock block;
	
	public PlayButton(SpoutBlock block) {
		super("Play Sound");
		this.block = block;
	}
	
	public void onButtonClick(ButtonClickEvent event) {
		SoundEffect ps = SoundEmitter.soundMap.get(block.getLocation());
		TestIt.playSound(block, ps);
		//event.getPlayer().getMainScreen().getActivePopup().close();
	}
}
