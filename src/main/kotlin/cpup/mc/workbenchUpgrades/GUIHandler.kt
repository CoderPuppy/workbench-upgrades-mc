package cpup.mc.workbenchUpgrades

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler

object GUIHandler : IGuiHandler {
	override fun getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Any? {
		return ContainerWorkbench(player.inventory, world, BlockPos(x, y, z))
	}

	override fun getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Any? {
		return WorkbenchGUI(player.inventory, world, BlockPos(x, y, z))
	}
}