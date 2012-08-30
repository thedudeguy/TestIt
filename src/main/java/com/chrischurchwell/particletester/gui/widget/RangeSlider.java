package com.chrischurchwell.particletester.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.particletester.material.ParticleEmitter;
import com.chrischurchwell.particletester.material.ParticleSetting;

public class RangeSlider extends SettingSlider {
	
	double value = 0;
	
	public RangeSlider(SpoutBlock block) {
		super("Range", block);
		value = ParticleEmitter.particleSettings.get(block.getLocation()).getRange();
		update();
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Float position) {
		value = position * 100;
		
		ParticleSetting ps = ParticleEmitter.particleSettings.get(block.getLocation());
		ps.setRange(value);
		ParticleEmitter.particleSettings.put(block.getLocation(), ps);
	}
	
	@Override
	public float getPosition() {
		if (value == 0) return 0;
		return (float)value / 100;
	}

}
