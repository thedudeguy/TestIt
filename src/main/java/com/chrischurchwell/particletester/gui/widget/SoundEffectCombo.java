package com.chrischurchwell.particletester.gui.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.gui.GenericComboBox;
import org.getspout.spoutapi.sound.SoundEffect;

import com.chrischurchwell.particletester.ParticleTester;
import com.chrischurchwell.particletester.material.ParticleEmitter;
import com.chrischurchwell.particletester.material.SoundEmitter;

public class SoundEffectCombo extends GenericComboBox {
	
	private SpoutBlock block;
	
	public static HashMap<String, SoundEffect> soundEffects = new HashMap<String, SoundEffect>();
	
	public SoundEffectCombo(SpoutBlock block) {
		
		this.block = block;
		
		//generate list of particle types
		List<String> pTypes = new ArrayList<String>();
		for( SoundEffect e : SoundEffect.values()) {
			if (!e.equals(SoundEffect.CUSTOM_EFFECT)) {
				soundEffects.put(e.toString(), e);
				pTypes.add(e.toString());
			}
		}
		
		setFormat("%text%");
		setItems(pTypes);
		
		setText("Type: " + SoundEmitter.soundMap.get(block.getLocation()).toString());
	}
	
	@Override
	public void onSelectionChanged(int i, String text) {
		if (i >= 0) {
			setText("Type: " + text);
			
			SoundEffect sound = soundEffects.get(text);
			SoundEmitter.soundMap.put(block.getLocation(), sound);
			
			ParticleTester.playSound(this.block, sound);
		}
	}
	
}
