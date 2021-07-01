package com.example.examplemod.blocks.RockBlocks;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlueBlock extends Block {
    public BlueBlock (String name)
    {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(ExampleMod.CTAB);
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
