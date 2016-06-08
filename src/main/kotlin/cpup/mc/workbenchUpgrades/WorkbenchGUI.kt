package cpup.mc.workbenchUpgrades

import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.resources.I18n
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class WorkbenchGUI(inv: InventoryPlayer, world: World, pos: BlockPos): GuiContainer(ContainerWorkbench(inv, world, pos)) {
	override fun drawGuiContainerForegroundLayer(p_drawGuiContainerForegroundLayer_1_: Int, p_drawGuiContainerForegroundLayer_2_: Int) {
		fontRendererObj.drawString(I18n.format("container.crafting", *arrayOfNulls<Any>(0)), 28, 6, 4210752)
		fontRendererObj.drawString(I18n.format("container.inventory", *arrayOfNulls<Any>(0)), 8, ySize - 96 + 2, 4210752)
	}

	override fun drawGuiContainerBackgroundLayer(p_drawGuiContainerBackgroundLayer_1_: Float, p_drawGuiContainerBackgroundLayer_2_: Int, p_drawGuiContainerBackgroundLayer_3_: Int) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f)
		mc.textureManager.bindTexture(craftingTableGuiTextures)
		val lvt_4_1_ = (width - xSize) / 2
		val lvt_5_1_ = (height - ySize) / 2
		drawTexturedModalRect(lvt_4_1_, lvt_5_1_, 0, 0, xSize, ySize)
	}

	override fun onGuiClosed() {
		super.onGuiClosed()
	}

	companion object {
		private val craftingTableGuiTextures = ResourceLocation("textures/gui/container/crafting_table.png")
	}
}
