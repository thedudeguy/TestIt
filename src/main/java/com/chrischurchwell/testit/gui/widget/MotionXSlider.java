package com.chrischurchwell.testit.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.testit.material.ParticleEmitter;
import com.chrischurchwell.testit.material.ParticleSetting;

public class MotionXSlider extends SettingSlider {
	
	private double value = 0;
	
	public MotionXSlider(SpoutBlock block) {
		super("Motion X", block);
		value = ParticleEmitter.particleSettings.get(block.getLocation()).getMotionX();
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
		ps.setMotionX(value);
		ParticleEmitter.particleSettings.put(block.getLocation(), ps);
	}
	
	@Override
	public float getPosition() {
		return (float)value;
	}

}
