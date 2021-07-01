package com.example.examplemod.blocks.RockBlocks;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.GUI.GuiMysteriousStranger;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBestStone extends Block{
        public BlockBestStone (String name)
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

