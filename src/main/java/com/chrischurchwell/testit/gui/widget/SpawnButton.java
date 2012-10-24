package com.chrischurchwell.testit.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;

import com.chrischurchwell.testit.TestIt;
import com.chrischurchwell.testit.material.ParticleEmitter;
import com.chrischurchwell.testit.material.ParticleSetting;

public class SpawnButton extends GenericButton {

	private SpoutBlock block;
	
	public SpawnButton(SpoutBlock block) {
		super("Spawn Particle");
		this.block = block;
	}
	
	public void onButtonClick(ButtonClickEvent event) {
		ParticleSetting ps = ParticleEmitter.particleSettings.get(block.getLocation());
		TestIt.spawnParticle(block, ps);
		event.getPlayer().getMainScreen().getActivePopup().close();
	}
}
