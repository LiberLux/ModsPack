package com.example.examplemod.blocks.EatBlocks;

import com.example.examplemod.items.FOOD;
import com.example.examplemod.items.ItemsRegistry;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropCorn extends BlockCrops {

    private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {

            new AxisAlignedBB(0.4375D, 0.0D, 0.4375D, 0.5625D, 0.25D, 0.5625D),
            new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 0.375D, 0.625D),
            new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 0.5D, 0.625D),
            new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 0.5625D, 0.625D),
            new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 0.6875D, 0.625D),
            new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 0.875D, 0.625D),
            new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 1.0D, 0.6875D),
            new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 1.0D, 0.6875D)
    };

    public BlockCropCorn(String cropName) {

        this.setUnlocalizedName(cropName);
        this.setRegistryName(cropName);
    }

    public AxisAlignedBB getBoundingBox(IBlockState blockState, IBlockAccess source, BlockPos position) {

        return CROPS_AABB[(blockState.getValue(this.getAgeProperty())).intValue()];
    }

   @Override
    protected Item getSeed() {

        return ItemsRegistry.CORN_SEED;
    }

    @Override
    protected Item getCrop() {

        return FOOD.NYAM;
    }
    protected int getBonemealAgeIncrease(World world) {

        return MathHelper.getInt(world.rand, 1, 2);
    }

    public EnumPlantType getPlantType(IBlockAccess world, BlockPos position) {

        return EnumPlantType.Crop;
    }
}
