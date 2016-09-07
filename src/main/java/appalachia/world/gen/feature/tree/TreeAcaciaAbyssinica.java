package appalachia.world.gen.feature.tree;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import appalachia.config.ConfigAppalachia;


/**
 * Acacia Abyssinica (Flat-top Acacia)
 */
public class TreeAcaciaAbyssinica extends AppalachiaTree {

    public TreeAcaciaAbyssinica() {

        super();

        this.logBlock = Blocks.LOG2.getStateFromMeta(0);
        this.leavesBlock = Blocks.LEAVES2.getStateFromMeta(0);
        this.trunkSize = 12;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        IBlockState b = world.getBlockState(new BlockPos(x, y - 1, z));

        if (b == Blocks.SAND.getDefaultState() && !ConfigAppalachia.allowTreesToGenerateOnSand) {
            return false;
        }

        if (b != Blocks.GRASS.getDefaultState() && b != Blocks.DIRT.getDefaultState()) {
            return false;
        }

        int h = this.trunkSize;
        int bh = h - 6;

        for (int i = 0; i < h; i++) {
            world.setBlockState(new BlockPos(x, y + i, z), this.logBlock, this.generateFlag);
        }
        genLeaves(world, rand, x, y + h, z);

        int sh, eh, dir;
        float xd, yd, c;

        for (int a = 6 + rand.nextInt(3); a > -1; a--) {
            sh = bh + rand.nextInt(4);
            eh = h - (int) ((h - sh) * 1f);
            dir = rand.nextInt(360);
            xd = (float) Math.cos(dir * Math.PI / 180f) * 2f;
            yd = (float) Math.sin(dir * Math.PI / 180f) * 2f;
            c = 1;

            while (sh < h) {
                world.setBlockState(new BlockPos(x + (int) (xd * c), y + sh, z + (int) (yd * c)), this.logBlock, this.generateFlag);
                sh++;
                c += 0.5f;
            }
            genLeaves(world, rand, x + (int) (xd * c), y + sh, z + (int) (yd * c));
        }

        return true;
    }

    public void genLeaves(World world, Random rand, int x, int y, int z) {

        if (!this.noLeaves) {

            int i;
            int j;
            for (i = -2; i <= 2; i++) {
                for (j = -2; j <= 2; j++) {
                    if (world.isAirBlock(new BlockPos(x + i, y + 1, z + j)) && Math.abs(i) + Math.abs(j) < 4) {
                        world.setBlockState(new BlockPos(x + i, y + 1, z + j), this.leavesBlock, this.generateFlag);
                    }
                }
            }

            for (i = -3; i <= 3; i++) {
                for (j = -3; j <= 3; j++) {
                    if (world.isAirBlock(new BlockPos(x + i, y, z + j)) && Math.abs(i) + Math.abs(j) < 5) {
                        world.setBlockState(new BlockPos(x + i, y, z + j), this.leavesBlock, this.generateFlag);
                    }
                }
            }
        }

        world.setBlockState(new BlockPos(x, y, z), this.logBlock, this.generateFlag);
    }
}
