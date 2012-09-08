package com.chrischurchwell.particletester.gui.widget;

import java.util.ArrayList;
import java.util.List;

import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.gui.GenericComboBox;
import org.getspout.spoutapi.sound.SoundEffect;

import com.chrischurchwell.particletester.ParticleTester;
import com.chrischurchwell.particletester.material.ParticleEmitter;
import com.chrischurchwell.particletester.material.SoundEmitter;

public class SoundEffectCombo extends GenericComboBox {
	
	private SpoutBlock block;
	
	public SoundEffectCombo(SpoutBlock block) {
		
		this.block = block;
		
		//generate list of particle types
		List<String> pTypes = new ArrayList<String>();
		for( SoundEffect e : SoundEffect.values()) {
			if (!e.equals(SoundEffect.CUSTOM_EFFECT)) {
				pTypes.add(e.getName());
			}
		}
		
		setFormat("%text%");
		setItems(pTypes);
		
		setText("Type: " + SoundEmitter.soundMap.get(block.getLocation()).getName());
	}
	
	@Override
	public void onSelectionChanged(int i, String text) {
		if (i >= 0) {
			setText("Type: " + text);
			
			SoundEffect sound = SoundEffect.getSoundEffectFromName(text);
			SoundEmitter.soundMap.put(block.getLocation(), sound);
			
			ParticleTester.playSound(this.block, sound);
		}
	}
	
}
