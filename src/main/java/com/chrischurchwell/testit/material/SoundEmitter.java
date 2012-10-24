package com.chrischurchwell.testit.material;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.block.design.BlockDesign;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;
import org.getspout.spoutapi.sound.SoundEffect;

import com.chrischurchwell.meshit.Model;
import com.chrischurchwell.testit.TestIt;
import com.chrischurchwell.testit.gui.SoundEffectGUI;
import com.chrischurchwell.testit.texture.TextureFile;

public class SoundEmitter extends GenericCustomBlock {
	
	public static HashMap<Location, SoundEffect> soundMap = new HashMap<Location, SoundEffect>();
	
	public SoundEmitter() {
		super(TestIt.getInstance(), "Sound Emitter", Material.CAULDRON.getId());
		
		Model model = new Model(TestIt.getInstance().getResource("models/soundemitter.obj"));
		
		BlockDesign design = model.getDesign();
		design.setTexture(TestIt.getInstance(), TextureFile.BLOCK_PARTICLE_EMITTER.getTexture());
		setBlockDesign(design);
		setHardness(0.1F);
		
		//set the recipe.
		SpoutManager.getMaterialManager().registerSpoutRecipe(
				new SpoutShapedRecipe(new SpoutItemStack(this, 1))
				.shape(" i ", " i ", "ioi")
				.setIngredient('i', MaterialData.ironIngot)
				.setIngredient('o', MaterialData.noteblock)
			);
	}
	
	public boolean onBlockInteract(org.bukkit.World world, int x, int y, int z, SpoutPlayer player) {
		
		SpoutBlock block = (SpoutBlock)world.getBlockAt(x,y,z);
		
		//create the default settings
		if (!soundMap.containsKey(block.getLocation())) soundMap.put(block.getLocation(), SoundEffect.BLAZE_BREATHE_1);
		
		player.getMainScreen().attachPopupScreen(new SoundEffectGUI(block));
		
		return true;
	}
	
	public void onBlockClicked(org.bukkit.World world, int x, int y, int z, SpoutPlayer player) {
		
		SpoutBlock block = (SpoutBlock)world.getBlockAt(x,y,z);
		
		//create the default settings
		if (!soundMap.containsKey(block.getLocation())) soundMap.put(block.getLocation(), SoundEffect.BLAZE_BREATHE_1);
		
		//get sound effect.
		SoundEffect ps = soundMap.get(block.getLocation());
		
		TestIt.playSound(block, ps);
	}
	
	/*
	 * For redstone Power Activation
	 * @see org.getspout.spoutapi.material.block.GenericCustomBlock#onNeighborBlockChange(org.bukkit.World, int, int, int, int)
	 */
	public void onNeighborBlockChange(org.bukkit.World world, int x, int y, int z, int changedId) {
		
		SpoutBlock block = (SpoutBlock)world.getBlockAt(x, y, z);
		if (
				(
						block.getData("emitter.powered") == null ||
						(Integer)block.getData("emitter.powered") == 0
				) &&
				block.isBlockPowered() == true
				) {
			block.setData("emitter.powered", 1);
			
			onBlockClicked(world, x, y, z, null);
			
		} else if (
				block.getData("emitter.powered") != null &&
				(Integer)block.getData("emitter.powered") == 1 &&
				block.isBlockPowered() == true
				) {
		
		} else if (
				block.getData("emitter.powered") != null &&
				(Integer)block.getData("emitter.powered") == 1 &&
				block.isBlockPowered() == false
				) {
			block.setData("emitter.powered", 0);
			
		} else {
			block.setData("emitter.powered", 0);
		}
		
	}
}
