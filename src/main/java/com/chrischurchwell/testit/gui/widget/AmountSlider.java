package com.chrischurchwell.testit.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;

import com.chrischurchwell.testit.material.ParticleEmitter;
import com.chrischurchwell.testit.material.ParticleSetting;

public class AmountSlider extends SettingSlider {
	
	int value = 0;
	
	public AmountSlider(SpoutBlock block) {
		super("Amount", block);
		value = ParticleEmitter.particleSettings.get(block.getLocation()).getAmount();
		update();
	}
	
	@Override
	public Object getValue() {
		return value;
	}
	
	@Override
	public void setValue(Float position) {
		value = Math.round(position*100);
		
		ParticleSetting ps = ParticleEmitter.particleSettings.get(block.getLocation());
		ps.setAmount(value);
		ParticleEmitter.particleSettings.put(block.getLocation(), ps);
	}

	@Override
	public float getPosition() {
		if (value == 0) return 0;
		return (float)((float)value/100);
	}
	
}
