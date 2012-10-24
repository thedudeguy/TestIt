package com.chrischurchwell.testit.gui.widget;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.event.screen.SliderDragEvent;
import org.getspout.spoutapi.gui.GenericSlider;

public abstract class SettingSlider extends GenericSlider {
	
	protected SpoutBlock block;
	protected String label;
	protected NumberFormat formatter = new DecimalFormat("0.000");
	
	public SettingSlider(String label, SpoutBlock block) {
		this.block = block;
		this.label = label;
		
		update();
		setSliderPosition(getPosition());
	}
	
	public void update() {
		
		setText(label + " " + formatter.format(getValue()));
		setSliderPosition(getPosition());
	}
	
	@Override
	public void onSliderDrag(SliderDragEvent event) {
		
		setValue(event.getNewPosition());
		update();
		
	}
	
	public abstract Object getValue();
	
	public abstract void setValue(Float position);
	
	public abstract float getPosition();
}
