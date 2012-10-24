package com.chrischurchwell.testit.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.testit.material.ParticleEmitter;
import com.chrischurchwell.testit.material.ParticleSetting;

public class GreenSlider extends SettingSlider {
	
	private float value = 0;
	
	public GreenSlider(SpoutBlock block) {
		super("Green", block);
		value = ParticleEmitter.particleSettings.get(block.getLocation()).getGreen();
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
		ps.setGreen(value);
		ParticleEmitter.particleSettings.put(block.getLocation(), ps);
	}
	
	@Override
	public float getPosition() {
		return value;
	}
}
