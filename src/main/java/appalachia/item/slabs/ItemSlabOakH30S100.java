package appalachia.item.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

import appalachia.api.AppalachiaBlocks;
import appalachia.block.planks.BlockPlanksOakH30S100;

public class ItemSlabOakH30S100 extends AppalachiaItemSlab {

    public ItemSlabOakH30S100(Block block) {

        super(block);
    }

    @Override
    protected IBlockState getFullBlock() {

        return AppalachiaBlocks.planks_oak_30_100.getDefaultState().withProperty(BlockPlanksOakH30S100.DOUBLE, Boolean.valueOf(true));
    }
}