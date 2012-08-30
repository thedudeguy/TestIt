package com.chrischurchwell.particletester.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.particletester.material.ParticleEmitter;
import com.chrischurchwell.particletester.material.ParticleSetting;

public class MotionYSlider extends SettingSlider {
	
	private double value = 0;
	
	public MotionYSlider(SpoutBlock block) {
		super("Motion Y", block);
		value = ParticleEmitter.particleSettings.get(block.getLocation()).getMotionY();
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
		ps.setMotionY(value);
		ParticleEmitter.particleSettings.put(block.getLocation(), ps);
	}

	@Override
	public float getPosition() {
		return (float)value;
	}
}
