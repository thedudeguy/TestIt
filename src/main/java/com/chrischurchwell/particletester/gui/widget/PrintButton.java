package com.chrischurchwell.particletester.gui.widget;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;

import com.chrischurchwell.particletester.material.ParticleEmitter;
import com.chrischurchwell.particletester.material.ParticleSetting;

public class PrintButton extends GenericButton {
	
	private SpoutBlock block;
	private NumberFormat f = new DecimalFormat("0.0000");
	
	public PrintButton(SpoutBlock block) {
		super("Print to Console");
		this.block = block;
	}
	
	public void onButtonClick(ButtonClickEvent event) {
		
		//get settings.
		ParticleSetting ps = ParticleEmitter.particleSettings.get(block.getLocation());
		
		Bukkit.getLogger().log(Level.INFO, "\n" +
				"\n" +
				"\n" +
				"//Particle Effect Generated by ParticleTester by Chris Churchwell\n" +
				"//for more info see:\n" +
				"// http://jd.spout.org/legacy/plugin/latest/org/getspout/spoutapi/particle/Particle.html\n" +
				"Particle particle = new Particle(\n" +
				"		ParticleType.getTypeFromName(\""+ps.getType().getName()+"\"),\n" +
				"		event.getPlayer().getLocation(), //<--- CHANGE ME! \n" +
				"		new org.bukkit.util.Vector("+f.format(ps.getMotionX())+"D, "+f.format(ps.getMotionY())+"D, "+f.format(ps.getMotionZ())+"D)\n" +
				"		)\n" +
				"	.setAmount("+String.valueOf(ps.getAmount())+")\n" +
				"	.setMaxAge("+String.valueOf(ps.getAge())+")\n" +
				"	.setGravity("+f.format(ps.getGravity())+"F)\n" +
				"	.setRange("+f.format(ps.getRange())+"D)\n" +
				"	.setScale("+f.format(ps.getScale())+"F)\n" +
				"	.setParticleBlue("+f.format(ps.getBlue())+"F)\n" +
				"	.setParticleGreen("+f.format(ps.getGreen())+"F)\n" +
				"	.setParticleRed("+f.format(ps.getRed())+"F);\n" +
				"particle.spawn();" +
				"\n" +
				"\n");
		
	}
}
