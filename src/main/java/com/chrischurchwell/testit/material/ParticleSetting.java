package com.chrischurchwell.testit.material;

import org.getspout.spoutapi.particle.Particle.ParticleType;

public class ParticleSetting {
	
	private int amount = 1;
	private int age = 20;
	private float gravity = 0.0F;
	private float scale = 1.0F;
	private float red = 0.0F;
	private float green = 0.0F;
	private float blue = 0.0F;
	private double motionX = 0.0F;
	private double motionY = 0.0F;
	private double motionZ = 0.0F;
	private double range = 50;
	private ParticleType type = ParticleType.SMOKE;
	
	public ParticleType getType() {
		return type;
	}
	public void setType(ParticleType type) {
		this.type = type;
	}
	public double getMotionX() {
		return motionX;
	}
	public void setMotionX(double motionX) {
		this.motionX = motionX;
	}
	public double getMotionY() {
		return motionY;
	}
	public void setMotionY(double motionY) {
		this.motionY = motionY;
	}
	public double getMotionZ() {
		return motionZ;
	}
	public void setMotionZ(double motionZ) {
		this.motionZ = motionZ;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getGravity() {
		return gravity;
	}
	public void setGravity(float gravity) {
		this.gravity = gravity;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getScale() {
		return scale;
	}
	public void setScale(float scale) {
		this.scale = scale;
	}
	public float getRed() {
		return red;
	}
	public void setRed(float red) {
		this.red = red;
	}
	public float getGreen() {
		return green;
	}
	public void setGreen(float green) {
		this.green = green;
	}
	public float getBlue() {
		return blue;
	}
	public void setBlue(float blue) {
		this.blue = blue;
	}
	public double getRange() {
		return range;
	}
	public void setRange(double range) {
		this.range = range;
	}
	
}