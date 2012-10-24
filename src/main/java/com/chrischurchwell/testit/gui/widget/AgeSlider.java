package com.chrischurchwell.testit.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.testit.material.ParticleEmitter;
import com.chrischurchwell.testit.material.ParticleSetting;

public class AgeSlider extends SettingSlider {
	
	private int value = 0;
	
	public AgeSlider(SpoutBlock block) {
		super("Age", block);
		value = ParticleEmitter.particleSettings.get(block.getLocation()).getAge();
		update();
	}
	
	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Float position) {
		value = Math.round(position*1000);
		
		ParticleSetting ps = ParticleEmitter.particleSettings.get(block.getLocation());
		ps.setAge(value);
		ParticleEmitter.particleSettings.put(block.getLocation(), ps);
	}

	@Override
	public float getPosition() {
		if (value == 0) return 0;
		return (float)((float)value/1000);
	}

}
