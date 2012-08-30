package com.chrischurchwell.particletester.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.particletester.material.ParticleEmitter;
import com.chrischurchwell.particletester.material.ParticleSetting;

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
