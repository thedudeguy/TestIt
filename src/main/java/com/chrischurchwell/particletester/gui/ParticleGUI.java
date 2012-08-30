package com.chrischurchwell.particletester.gui;

import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.gui.GenericPopup;

import com.chrischurchwell.particletester.ParticleTester;
import com.chrischurchwell.particletester.gui.widget.AgeSlider;
import com.chrischurchwell.particletester.gui.widget.AmountSlider;
import com.chrischurchwell.particletester.gui.widget.BlueSlider;
import com.chrischurchwell.particletester.gui.widget.CloseButton;
import com.chrischurchwell.particletester.gui.widget.GravitySlider;
import com.chrischurchwell.particletester.gui.widget.GreenSlider;
import com.chrischurchwell.particletester.gui.widget.MotionXSlider;
import com.chrischurchwell.particletester.gui.widget.MotionYSlider;
import com.chrischurchwell.particletester.gui.widget.MotionZSlider;
import com.chrischurchwell.particletester.gui.widget.PrintButton;
import com.chrischurchwell.particletester.gui.widget.RangeSlider;
import com.chrischurchwell.particletester.gui.widget.RedSlider;
import com.chrischurchwell.particletester.gui.widget.ScaleSlider;
import com.chrischurchwell.particletester.gui.widget.SpawnButton;
import com.chrischurchwell.particletester.gui.widget.TypeCombo;

public class ParticleGUI extends GenericPopup {

	public ParticleGUI(SpoutBlock block) {
		
		//Type
		TypeCombo typeCombo = new TypeCombo(block);
		typeCombo.setX(5).setY(5);
		typeCombo.setWidth(100).setHeight(20);
		attachWidget(ParticleTester.getInstance(), typeCombo);
		
		//Amount
		AmountSlider amountSlider = new AmountSlider(block);
		amountSlider.setX(5).setY(30);
		amountSlider.setWidth(200).setHeight(20);
		attachWidget(ParticleTester.getInstance(), amountSlider);
		
		//Age
		AgeSlider ageSlider = new AgeSlider(block);
		ageSlider.setX(5).setY(55);
		ageSlider.setWidth(200).setHeight(20);
		attachWidget(ParticleTester.getInstance(), ageSlider);
		
		//Gravity
		GravitySlider gravitySlider = new GravitySlider(block);
		gravitySlider.setX(5).setY(80);
		gravitySlider.setWidth(200).setHeight(20);
		attachWidget(ParticleTester.getInstance(), gravitySlider);
		
		//Scale
		ScaleSlider scaleSlider = new ScaleSlider(block);
		scaleSlider.setX(5).setY(105);
		scaleSlider.setWidth(200).setHeight(20);
		attachWidget(ParticleTester.getInstance(), scaleSlider);
		
		//Range
		RangeSlider rangeSlider = new RangeSlider(block);
		rangeSlider.setX(5).setY(130);
		rangeSlider.setWidth(200).setHeight(20);
		attachWidget(ParticleTester.getInstance(), rangeSlider);
		
		//Color Red
		RedSlider redSlider = new RedSlider(block);
		redSlider.setX(5).setY(155);
		redSlider.setWidth(100).setHeight(20);
		attachWidget(ParticleTester.getInstance(), redSlider);
		
		//Color Green
		GreenSlider greenSlider = new GreenSlider(block);
		greenSlider.setX(110).setY(155);
		greenSlider.setWidth(100).setHeight(20);
		attachWidget(ParticleTester.getInstance(), greenSlider);
		
		//Color Blue
		BlueSlider blueSlider = new BlueSlider(block);
		blueSlider.setX(215).setY(155);
		blueSlider.setWidth(100).setHeight(20);
		attachWidget(ParticleTester.getInstance(), blueSlider);
		
		//Motion X
		MotionXSlider motionXSlider = new MotionXSlider(block);
		motionXSlider.setX(5).setY(180);
		motionXSlider.setWidth(100).setHeight(20);
		attachWidget(ParticleTester.getInstance(), motionXSlider);
		
		//Motion Y
		MotionYSlider motionYSlider = new MotionYSlider(block);
		motionYSlider.setX(110).setY(180);
		motionYSlider.setWidth(100).setHeight(20);
		attachWidget(ParticleTester.getInstance(), motionYSlider);
				
		//Motion Z
		MotionZSlider motionZSlider = new MotionZSlider(block);
		motionZSlider.setX(215).setY(180);
		motionZSlider.setWidth(100).setHeight(20);
		attachWidget(ParticleTester.getInstance(), motionZSlider);
		
		//close
		CloseButton closeButton = new CloseButton();
		closeButton.setX(5).setY(205);
		closeButton.setWidth(50).setHeight(20);
		attachWidget(ParticleTester.getInstance(), closeButton);
		
		//print
		PrintButton printButton = new PrintButton(block);
		printButton.setX(60).setY(205);
		printButton.setWidth(100).setHeight(20);
		attachWidget(ParticleTester.getInstance(), printButton);
		
		//spawn
		SpawnButton spawnButton = new SpawnButton(block);
		spawnButton.setX(165).setY(205);
		spawnButton.setWidth(100).setHeight(20);
		attachWidget(ParticleTester.getInstance(), spawnButton);
	}
	
}
