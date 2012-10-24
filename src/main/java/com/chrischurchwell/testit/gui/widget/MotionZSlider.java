package com.chrischurchwell.testit.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.testit.material.ParticleEmitter;
import com.chrischurchwell.testit.material.ParticleSetting;

public class MotionZSlider extends SettingSlider {
	
	private double value = 0;
	
	public MotionZSlider(SpoutBlock block) {
		super("Motion Z", block);
		value = ParticleEmitter.particleSettings.get(block.getLocation()).getMotionZ();
		update();
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Float position) {
		value = (double)position;
		
		ParticleSetting ps = ParticleEmitter.particleSettings.get(block.getLocation());
		ps.setMotionZ(value);
		ParticleEmitter.particleSettings.put(block.getLocation(), ps);
	}
	
	@Override
	public float getPosition() {
		return (float)value;
	}
	
}
