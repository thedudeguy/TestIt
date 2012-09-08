package com.chrischurchwell.particletester.gui;

import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.gui.GenericPopup;

import com.chrischurchwell.particletester.ParticleTester;
import com.chrischurchwell.particletester.gui.widget.CloseButton;
import com.chrischurchwell.particletester.gui.widget.PlayButton;
import com.chrischurchwell.particletester.gui.widget.SoundEffectCombo;

public class SoundEffectGUI extends GenericPopup {

	public SoundEffectGUI(SpoutBlock block) {
		
		//Type
		SoundEffectCombo typeCombo = new SoundEffectCombo(block);
		typeCombo.setX(5).setY(5);
		typeCombo.setWidth(300).setHeight(20);
		attachWidget(ParticleTester.getInstance(), typeCombo);
		
		//close
		CloseButton closeButton = new CloseButton();
		closeButton.setX(5).setY(205);
		closeButton.setWidth(50).setHeight(20);
		attachWidget(ParticleTester.getInstance(), closeButton);
		
		//play
		PlayButton playButton = new PlayButton(block);
		playButton.setX(165).setY(205);
		playButton.setWidth(100).setHeight(20);
		attachWidget(ParticleTester.getInstance(), playButton);
	}
	
}
