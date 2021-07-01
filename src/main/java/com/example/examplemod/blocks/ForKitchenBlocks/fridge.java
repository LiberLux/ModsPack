package com.example.examplemod.blocks.ForKitchenBlocks;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class fridge extends Block {
    public fridge(String name)
    {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        setCreativeTab(ExampleMod.CTAB);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
}

