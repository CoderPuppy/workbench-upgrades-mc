package cpup.mc.workbenchUpgrades

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.inventory.ContainerWorkbench
import net.minecraft.inventory.IInventory
import net.minecraft.item.crafting.CraftingManager
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class ContainerWorkbench(inv: InventoryPlayer, private val world: World, private val pos: BlockPos): ContainerWorkbench(inv, world, pos) {
	override fun onCraftMatrixChanged(inv: IInventory?) {
		var stack = CraftingManager.getInstance().findMatchingRecipe(craftMatrix, world)
		if(stack != null) {
			stack = stack.copy()
			stack.stackSize *= 4;
		}
		craftResult.setInventorySlotContents(0, stack)
	}

	override fun canInteractWith(p_canInteractWith_1_: EntityPlayer): Boolean {
		return if (world.getBlockState(this.pos).block !== WorkbenchUpgrades.block) false else p_canInteractWith_1_.getDistanceSq(this.pos.x.toDouble() + 0.5, this.pos.y.toDouble() + 0.5, this.pos.z.toDouble() + 0.5) <= 64.0
	}
}
