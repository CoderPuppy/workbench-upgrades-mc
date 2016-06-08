package cpup.mc.workbenchUpgrades

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.MapColor
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class WorkbenchBlock : Block(Material.IRON, MapColor.IRON) {
	init {
		setHardness(5.0F)
		setResistance(10.0F)
		setSoundType(SoundType.METAL)
		setUnlocalizedName("workbench-upgrades:workbench")
		setCreativeTab(CreativeTabs.DECORATIONS)
		setRegistryName("workbench")
	}

	override fun onBlockActivated(world: World?, pos: BlockPos?, state: IBlockState?, player: EntityPlayer?, hand: EnumHand?, heldItem: ItemStack?, side: EnumFacing?, x: Float, y: Float, z: Float): Boolean {
		if(!world!!.isRemote) {
			player!!.openGui(WorkbenchUpgrades.instance, 0, world, pos!!.x, pos.y, pos.z)
		}
		return true
	}
}