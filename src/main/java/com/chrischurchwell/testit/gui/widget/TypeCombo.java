package com.chrischurchwell.testit.gui.widget;

import java.util.ArrayList;
import java.util.List;

import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.gui.GenericComboBox;
import org.getspout.spoutapi.particle.Particle.ParticleType;

import com.chrischurchwell.testit.material.ParticleEmitter;
import com.chrischurchwell.testit.material.ParticleSetting;

public class TypeCombo extends GenericComboBox {
	
	private SpoutBlock block;
	
	public TypeCombo(SpoutBlock block) {
		
		this.block = block;
		
		//generate list of particle types
		List<String> pTypes = new ArrayList<String>();
		for( ParticleType p : ParticleType.values() ) {
			if (p != null && p.getName() != null) {
				pTypes.add(p.getName());
			}
		}
		
		setFormat("%text%");
		setItems(pTypes);
		
		setText("Type: " + ParticleEmitter.particleSettings.get(block.getLocation()).getType().getName());
	}
	
	@Override
	public void onSelectionChanged(int i, String text) {
		if (i >= 0) {
			setText("Type: " + text);
			
			ParticleSetting ps = ParticleEmitter.particleSettings.get(block.getLocation());
			ps.setType(ParticleType.getTypeFromName(text));
			ParticleEmitter.particleSettings.put(block.getLocation(), ps);
		}
	}
	
}
