package com.chrischurchwell.particletester;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.particle.Particle;

import com.chrischurchwell.particletester.material.ParticleEmitter;
import com.chrischurchwell.particletester.material.ParticleSetting;
import com.chrischurchwell.particletester.texture.TextureFile;

public class ParticleTester extends JavaPlugin {

	public static ParticleTester instance;
	public static ParticleEmitter blockParticleEmitter;
	
	public static ParticleTester getInstance() {
		return instance;
	}
	
	public static void log(String message) {
		Bukkit.getLogger().log(Level.INFO, "[ParticleTester] " + message);
	}
	
	public static void spawnParticle(SpoutBlock block, ParticleSetting ps) {
		
		//prepare the location
		Location loc = block.getLocation();
		loc.setX(loc.getX()+0.5F);
		loc.setY(loc.getY()+1.1F);
		loc.setZ(loc.getZ()+0.5F);
		
		spawnParticle(loc, ps);
		
	}
	
	public static void spawnParticle(Location location, ParticleSetting ps) {
		//prepare vector.
		Vector v = new Vector(ps.getMotionX(), ps.getMotionY(), ps.getMotionZ());
		
		//create particle.
		Particle particle = new Particle(ps.getType(), location, v);
		particle.setAmount(ps.getAmount());
		particle.setGravity(ps.getGravity());
		particle.setMaxAge(ps.getAge());
		particle.setParticleBlue(ps.getBlue());
		particle.setParticleGreen(ps.getGreen());
		particle.setParticleRed(ps.getRed());
		particle.setRange(ps.getRange());
		particle.setScale(ps.getScale());
		
		ParticleTester.log("--------------------------");
		ParticleTester.log("Spawning Particle...");
		ParticleTester.log("Type: " + particle.getName());
		ParticleTester.log("Amount: " + String.valueOf(particle.getAmount()));
		ParticleTester.log("Gravity: " + String.valueOf(particle.getGravity()));
		ParticleTester.log("Age: " + String.valueOf(particle.getMaxAge()));
		ParticleTester.log("Range: " + String.valueOf(particle.getRange()));
		ParticleTester.log("Scale: " + String.valueOf(particle.getScale()));
		ParticleTester.log("Red: " + String.valueOf(particle.getParticleRed()));
		ParticleTester.log("Green: " + String.valueOf(particle.getParticleGreen()));
		ParticleTester.log("Blue: " + String.valueOf(particle.getParticleBlue()));
		ParticleTester.log("Motion X: " + String.valueOf(particle.getMotion().getX()));
		ParticleTester.log("Motion Y: " + String.valueOf(particle.getMotion().getY()));
		ParticleTester.log("Motion Z: " + String.valueOf(particle.getMotion().getZ()));
		
		particle.spawn();
	}
	
	public void onEnable() {
		
		//double check for spout.
		if (!Bukkit.getPluginManager().isPluginEnabled("Spout")) {
			Bukkit.getLogger().log(Level.WARNING, "[ParticleTester] Could not start: SpoutPlugin not found. SpoutPlugin is required for JukeBukkit to operate.");
			setEnabled(false);
			return;
		}
		
		instance = this;
		
		//extract textures to the server
		TextureFile.extractTextures();
		
		//precache texture
		TextureFile.preCacheTextures();
		
		//cache the textures we use to the client, doubling up like this seems to fix caching errors.
		TextureFile.cacheTextures();
		
		//load the custom block
		blockParticleEmitter = new ParticleEmitter();
		
		log("Enabled");
	}
	
	public void onDisable() {
		log("Disabled");
	}
	
}
