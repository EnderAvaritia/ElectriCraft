/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RotationalInduction.Registry;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import Reika.DragonAPI.Libraries.Java.ReikaJavaLibrary;
import Reika.DragonAPI.Libraries.Java.ReikaStringParser;
import Reika.DragonAPI.ModInteract.ReikaTwilightHelper;

public enum InductionOres {

	COPPER(		32, 64, 	6, 	6, 	0, 	0.5F,	1,	"ore.copper"),
	TIN(		48, 72, 	8, 	12,	0, 	0.2F,	1,	"ore.tin"),
	SILVER(		0, 32, 		6, 	4, 	0, 	0.8F,	2,	"ore.silver"),
	NICKEL(		16, 48, 	8, 	8, 	0, 	0.3F,	1,	"ore.nickel"),
	ALUMINUM(	60, 128, 	8, 	10,	0, 	0.4F,	1,	"ore.aluminum"),
	PLATINUM(	0, 16, 		4, 	2, 	0, 	1F,		2,	"ore.platinum");

	public final int minY;
	public final int maxY;
	public final int veinSize;
	public final int perChunk;
	public final int dimensionID;
	public final String oreName;
	public final int harvestLevel;
	public final float xpDropped;

	public static final InductionOres[] oreList = values();

	private InductionOres(int min, int max, int size, int count, int dim, float xp, int level, String name) {
		minY = min;
		maxY = max;
		veinSize = size;
		perChunk = count;
		dimensionID = dim;
		oreName = StatCollector.translateToLocal(name);
		harvestLevel = level;
		xpDropped = xp;
	}

	@Override
	public String toString() {
		return this.name()+" "+perChunk+"x"+veinSize+" between "+minY+" and "+maxY;
	}

	public static InductionOres getOre(IBlockAccess iba, int x, int y, int z) {
		int id = iba.getBlockId(x, y, z);
		int meta = iba.getBlockMetadata(x, y, z);
		if (id != InductionBlocks.ORE.getBlockID())
			return null;
		return oreList[meta];
	}

	public static InductionOres getOre(int id, int meta) {
		if (id != InductionBlocks.ORE.getBlockID())
			return null;
		return oreList[meta];
	}

	public String getTextureName() {
		return "RotationalInduction:ore"+ReikaStringParser.capFirstChar(this.name());
	}

	public String getDictionaryName() {
		return "ore"+ReikaStringParser.capFirstChar(this.name());
	}

	public String getProductDictionaryName() {
		switch(this) {
		default:
			return "ingot"+ReikaStringParser.capFirstChar(this.name());
		}
	}

	public int getBlockID() {
		return InductionBlocks.ORE.getBlockID();
	}


	public int getBlockMetadata() {
		return this.ordinal();
	}

	public ItemStack getOreBlock() {
		return new ItemStack(this.getBlockID(), 1, this.getBlockMetadata());
	}

	public ItemStack getProduct() {
		switch(this) {
		default:
			return InductionItems.INGOTS.getStackOfMetadata(this.getProductMetadata());
		}
	}

	public List<ItemStack> getOreDrop(int meta) {
		switch(this) {
		default:
			return ReikaJavaLibrary.makeListFrom(new ItemStack(InductionBlocks.ORE.getBlockID(), 1, meta));
		}
	}

	public int getProductMetadata() {
		return this.ordinal()-1;
	}

	public String getProductName() {
		switch(this) {
		default:
			return StatCollector.translateToLocal("item."+this.name().toLowerCase());
		}
	}

	public int getReplaceableBlock() {
		switch(dimensionID) {
		case 0:
			return Block.stone.blockID;
		case 1:
			return Block.whiteStone.blockID;
		case -1:
			return Block.netherrack.blockID;
		case 7:
			return Block.stone.blockID;
		default:
			return Block.stone.blockID;
		}
	}

	public boolean isValidDimension(int id) {
		if (id == dimensionID)
			return true;
		if (id == ReikaTwilightHelper.getDimensionID() && dimensionID == 0)
			return true;
		if (dimensionID == 0 && id != -1 && id != 1)
			return true;
		return false;
	}

	public boolean isValidBiome(BiomeGenBase biome) {
		switch(this) {
		default:
			return true;
		}
	}

	public boolean canGenerateInChunk(World world, int chunkX, int chunkZ) {
		int id = world.provider.dimensionId;
		if (!this.shouldGen())
			return false;
		if (!this.isValidDimension(id))
			return false;
		return this.isValidBiome(world.getBiomeGenForCoords(chunkX, chunkZ)) || id == ReikaTwilightHelper.getDimensionID();
	}

	private boolean shouldGen() {
		return true;
	}

	public boolean canGenAt(World world, int x, int y, int z) {
		return true;
	}

	public boolean dropsSelf(int meta) {
		List<ItemStack> li = this.getOreDrop(meta);
		return li.size() == 1 && li.get(0).itemID == InductionBlocks.ORE.getBlockID() && li.get(0).getItemDamage() == meta;
	}
}
