package com.chrischurchwell.testit.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.testit.material.ParticleEmitter;
import com.chrischurchwell.testit.material.ParticleSetting;

public class BlueSlider extends SettingSlider {
	
	private float value;
	
	public BlueSlider(SpoutBlock block) {
		super("Blue", block);
		value = ParticleEmitter.particleSettings.get(block.getLocation()).getBlue();
		update();
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Float position) {
		value=position;
		
		ParticleSetting ps = ParticleEmitter.particleSettings.get(block.getLocation());
		ps.setBlue(value);
		ParticleEmitter.particleSettings.put(block.getLocation(), ps);
	}

	@Override
	public float getPosition() {
		return value;
	}
	
}
