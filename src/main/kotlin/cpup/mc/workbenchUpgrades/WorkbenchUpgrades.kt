package cpup.mc.workbenchUpgrades

import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.FMLCommonHandler
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.oredict.ShapelessOreRecipe
import org.apache.logging.log4j.Logger

@Mod(modid = "workbench-upgrades")
class WorkbenchUpgrades {
	@Mod.EventHandler
	fun preInitEv(e: FMLPreInitializationEvent) {
		Static._logger = e.modLog
		Static._block = WorkbenchBlock()
		GameRegistry.register(Static.block)
		GameRegistry.register(ItemBlock(Static.block), Static.block.registryName)
		Static.proxy.preInitEv(e)
	}

	@Mod.EventHandler
	fun initEv(e: FMLInitializationEvent) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, GUIHandler)
		GameRegistry.addRecipe(ShapelessOreRecipe(
			ItemStack(block),
			"blockIron", Blocks.CRAFTING_TABLE
		))
	}

	open class CommonProxy {
		open fun preInitEv(e: FMLPreInitializationEvent) {}
	}

	class ClientProxy : CommonProxy() {
		override fun preInitEv(e: FMLPreInitializationEvent) {
			super.preInitEv(e)
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(Static.block), 0, ModelResourceLocation(Static.block.registryName, "inventory"))
		}
	}

	class ServerProxy : CommonProxy() {

	}

	companion object Static {
		private var _logger: Logger? = null
		val logger: Logger
			get() = _logger!!

		private var _block: WorkbenchBlock? = null
		val block: WorkbenchBlock
			get() = _block!!

		@Mod.Instance("workbench-upgrades")
		private var _instance: WorkbenchUpgrades? = null
		val instance: WorkbenchUpgrades
			get() = _instance!!

		@SidedProxy
		private var _proxy: CommonProxy? = null
		val proxy: CommonProxy
			get() = _proxy!!
	}
}