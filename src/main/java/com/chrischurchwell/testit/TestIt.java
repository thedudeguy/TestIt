package com.chrischurchwell.testit;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.particle.Particle;
import org.getspout.spoutapi.sound.SoundEffect;

import com.chrischurchwell.testit.material.ParticleEmitter;
import com.chrischurchwell.testit.material.ParticleSetting;
import com.chrischurchwell.testit.material.SoundEmitter;
import com.chrischurchwell.testit.texture.TextureFile;

public class TestIt extends JavaPlugin {

	public static TestIt instance;
	public static ParticleEmitter blockParticleEmitter;
	public static SoundEmitter blockSoundEmitter;
	
	public static TestIt getInstance() {
		return instance;
	}
	
	public static void log(String message) {
		Bukkit.getLogger().log(Level.INFO, "[TestIt] " + message);
	}
	
	public static void playSound(SpoutBlock block, SoundEffect ps) {
		playSound(block.getLocation(), ps);
	}
	
	public static void playSound(Location location, SoundEffect ps) {
		log("Playing " + ps.toString());
		SpoutManager.getSoundManager().playGlobalSoundEffect(ps, location, 100, 100);
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
		
		TestIt.log("--------------------------");
		TestIt.log("Spawning Particle...");
		TestIt.log("Type: " + particle.getName());
		TestIt.log("Amount: " + String.valueOf(particle.getAmount()));
		TestIt.log("Gravity: " + String.valueOf(particle.getGravity()));
		TestIt.log("Age: " + String.valueOf(particle.getMaxAge()));
		TestIt.log("Range: " + String.valueOf(particle.getRange()));
		TestIt.log("Scale: " + String.valueOf(particle.getScale()));
		TestIt.log("Red: " + String.valueOf(particle.getParticleRed()));
		TestIt.log("Green: " + String.valueOf(particle.getParticleGreen()));
		TestIt.log("Blue: " + String.valueOf(particle.getParticleBlue()));
		TestIt.log("Motion X: " + String.valueOf(particle.getMotion().getX()));
		TestIt.log("Motion Y: " + String.valueOf(particle.getMotion().getY()));
		TestIt.log("Motion Z: " + String.valueOf(particle.getMotion().getZ()));
		
		particle.spawn();
	}
	
	public void onEnable() {
		
		//double check for spout.
		if (!Bukkit.getPluginManager().isPluginEnabled("Spout")) {
			Bukkit.getLogger().log(Level.WARNING, "[TestIt] Could not start: SpoutPlugin not found. SpoutPlugin is required for JukeBukkit to operate.");
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
		blockSoundEmitter = new SoundEmitter();
		
		log("Enabled");
	}
	
	public void onDisable() {
		log("Disabled");
	}
	
}
