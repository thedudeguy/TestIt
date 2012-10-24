/**
 * This file is part of JukeBukkit
 *
 * Copyright (C) 2011-2012  Chris Churchwell
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.chrischurchwell.testit.texture;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.Texture;

import com.chrischurchwell.testit.TestIt;

public enum TextureFile {
	/* items */
	
	/* gui */
	
	/* blocks */
	BLOCK_PARTICLE_EMITTER("particleblock.png", 1024, 1024, 1024);
	
	private String file;
	private int width;
	private int height;
	private int size;
	
	TextureFile(String file) {
		this(file, 16, 16, 16);
	}
	
	TextureFile(String file, int width, int height, int size) {
		this.file = file;
		this.width = width;
		this.height = height;
		this.size = size;
	}
	
	public String getFile() {
		return file;
	}
	
	public Texture getTexture() {
		
		// since the texture class actually uses the width/height/size parameters to calculate u-v coordinates
		// its safe to just use the default texture size, and any custom textures with higher resolutions
		// will still work fine assuming the custom texture was scaled properly. (in powers of 2 and maintains size ratio)
		return new Texture(TestIt.getInstance(), this.file, this.width, this.height, this.size);
		
	}
	
	public static void extractTextures() {
		File dir = new File(TestIt.getInstance().getDataFolder(), "textures");
		
		if (!dir.exists()) dir.mkdirs();
		if (!dir.canWrite()) Bukkit.getLogger().log(Level.WARNING, "The path "+ dir.getPath() +" is not writable");
		if (!dir.isDirectory()) Bukkit.getLogger().log(Level.WARNING, "The path "+ dir.getPath() +" is not a directory");
		
		for (TextureFile texture : TextureFile.values()) {
			String fileCopyRelPath = new File("textures", texture.getFile()).getPath();
			TestIt.getInstance().saveResource(fileCopyRelPath, true);
		}
	}
	
	public static void preCacheTextures() {
		//clear cached elements. this seems to fix a cacheing bug
		List<String> textures = new ArrayList<String>();
		for (TextureFile texture : TextureFile.values()) {
			textures.add(texture.getFile());
		}
		SpoutManager.getFileManager().removeFromCache(TestIt.getInstance(), textures);
		
		//add
		for (TextureFile texture : TextureFile.values()) {
			SpoutManager.getFileManager().addToPreLoginCache(
					TestIt.getInstance(),
					new File(TestIt.getInstance().getDataFolder(), new File("textures", texture.getFile()).getPath())
					);
		}
	}
	
	public static void cacheTextures() {
		//clear cached elements. this seems to fix a cacheing bug
		List<String> textures = new ArrayList<String>();
		for (TextureFile texture : TextureFile.values()) {
			textures.add(texture.getFile());
		}
		SpoutManager.getFileManager().removeFromCache(TestIt.getInstance(), textures);
		
		//add
		for (TextureFile texture : TextureFile.values()) {
			SpoutManager.getFileManager().addToCache(
					TestIt.getInstance(),
					new File(TestIt.getInstance().getDataFolder(), new File("textures", texture.getFile()).getPath())
					);
		}
	}
}
