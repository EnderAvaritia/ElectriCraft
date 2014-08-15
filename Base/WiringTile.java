/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.ElectriCraft.Base;



public abstract class WiringTile extends NetworkTileEntity {

	public abstract int getResistance();

	public abstract void onNetworkChanged();

	@Override
	public final int getRedstoneOverride() {
		return 0;
	}

}