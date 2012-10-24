package com.chrischurchwell.testit.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.testit.material.ParticleEmitter;
import com.chrischurchwell.testit.material.ParticleSetting;

public class RedSlider extends SettingSlider {
	
	private float value = 0;
	
	public RedSlider(SpoutBlock block) {
		super("Red", block);
		value = ParticleEmitter.particleSettings.get(block.getLocation()).getRed();
		update();
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Float position) {
		value = position;
		
		ParticleSetting ps = ParticleEmitter.particleSettings.get(block.getLocation());
		ps.setRed(value);
		ParticleEmitter.particleSettings.put(block.getLocation(), ps);
	}
	
	@Override
	public float getPosition() {
		return value;
	}
	
}
