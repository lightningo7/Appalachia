package appalachia.item.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

import appalachia.api.AppalachiaBlocks;
import appalachia.block.planks.BlockPlanksOakH10S170;

public class ItemSlabOakH10S170 extends AppalachiaItemSlab {

    public ItemSlabOakH10S170(Block block) {

        super(block);
    }

    @Override
    protected IBlockState getFullBlock() {

        return AppalachiaBlocks.planks_oak_10_170.getDefaultState().withProperty(BlockPlanksOakH10S170.DOUBLE, Boolean.valueOf(true));
    }
}