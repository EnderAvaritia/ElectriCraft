/*******************************************************************************
 * @author Reika Kalseki
 *
 * Copyright 2017
 *
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
// Date: 13-03-2014 09:44:42
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package Reika.ElectriCraft.Renders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Reika.DragonAPI.Instantiable.Rendering.LODModelPart;

public class ModelPreciseResistor extends ModelResistorBase {

	LODModelPart band4a;
	LODModelPart band4b;
	LODModelPart band3a;
	LODModelPart band3b;
	LODModelPart band2a;
	LODModelPart band2b;
	LODModelPart band1a;
	LODModelPart band1b;

	private ArrayList<ResistorBand> bands;

	@Override
	protected void addBands() {
		band4a = new LODModelPart(this, 0, 63);
		band4a.addBox(0F, 0F, 0F, 7, 6, 2);
		band4a.setRotationPoint(-3.5F, 11.5F, 3F);
		band4a.setTextureSize(128, 128);
		band4a.mirror = true;
		this.setRotation(band4a, 0F, 0F, 0F);
		band4b = new LODModelPart(this, 22, 63);
		band4b.addBox(0F, 0F, 0F, 9, 6, 2);
		band4b.setRotationPoint(-4.5F, 13.5F, 3F);
		band4b.setTextureSize(128, 128);
		band4b.mirror = true;
		this.setRotation(band4b, 0F, 0F, 0F);

		band3a = new LODModelPart(this, 0, 63);
		band3a.addBox(0F, 0F, 0F, 7, 6, 2);
		band3a.setRotationPoint(-3.5F, 11.5F, 0F);
		band3a.setTextureSize(128, 128);
		band3a.mirror = true;
		this.setRotation(band3a, 0F, 0F, 0F);
		band3b = new LODModelPart(this, 22, 63);
		band3b.addBox(0F, 0F, 0F, 9, 6, 2);
		band3b.setRotationPoint(-4.5F, 13.5F, 0F);
		band3b.setTextureSize(128, 128);
		band3b.mirror = true;
		this.setRotation(band3b, 0F, 0F, 0F);

		band2a = new LODModelPart(this, 0, 63);
		band2a.addBox(0F, 0F, 0F, 7, 6, 2);
		band2a.setRotationPoint(-3.5F, 11.5F, -3F);
		band2a.setTextureSize(128, 128);
		band2a.mirror = true;
		this.setRotation(band2a, 0F, 0F, 0F);
		band2b = new LODModelPart(this, 22, 63);
		band2b.addBox(0F, 0F, 0F, 9, 6, 2);
		band2b.setRotationPoint(-4.5F, 13.5F, -3F);
		band2b.setTextureSize(128, 128);
		band2b.mirror = true;
		this.setRotation(band2b, 0F, 0F, 0F);

		band1a = new LODModelPart(this, 0, 63);
		band1a.addBox(0F, 0F, 0F, 7, 6, 2);
		band1a.setRotationPoint(-3.5F, 11.5F, -6F);
		band1a.setTextureSize(128, 128);
		band1a.mirror = true;
		this.setRotation(band1a, 0F, 0F, 0F);
		band1b = new LODModelPart(this, 22, 63);
		band1b.addBox(0F, 0F, 0F, 9, 6, 2);
		band1b.setRotationPoint(-4.5F, 13.5F, -6F);
		band1b.setTextureSize(128, 128);
		band1b.mirror = true;
		this.setRotation(band1b, 0F, 0F, 0F);

		bands = new ArrayList();
		bands.add(new ResistorBand(1, band1a, band1b));
		bands.add(new ResistorBand(2, band2a, band2b));
		bands.add(new ResistorBand(3, band3a, band3b));
		bands.add(new ResistorBand(4, band4a, band4b));
	}

	@Override
	protected List<ResistorBand> getBands() {
		return Collections.unmodifiableList(bands);
	}

}
