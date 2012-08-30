package com.chrischurchwell.particletester.gui.widget;

import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;

import com.chrischurchwell.particletester.ParticleTester;
import com.chrischurchwell.particletester.material.ParticleEmitter;
import com.chrischurchwell.particletester.material.ParticleSetting;

public class SpawnButton extends GenericButton {

	private SpoutBlock block;
	
	public SpawnButton(SpoutBlock block) {
		super("Spawn Particle");
		this.block = block;
	}
	
	public void onButtonClick(ButtonClickEvent event) {
		ParticleSetting ps = ParticleEmitter.particleSettings.get(block.getLocation());
		ParticleTester.spawnParticle(block, ps);
		event.getPlayer().getMainScreen().getActivePopup().close();
	}
}
