package appalachia.block.planks;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import appalachia.api.AppalachiaBlocks;

public class BlockPlanksAutumnGrey extends AppalachiaBlockPlanks
{
	public BlockPlanksAutumnGrey()
	{
		super("planks.autumn.grey");
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(state.getValue(DOUBLE).booleanValue() ? AppalachiaBlocks.slab_autumn_grey : this);
	}
}