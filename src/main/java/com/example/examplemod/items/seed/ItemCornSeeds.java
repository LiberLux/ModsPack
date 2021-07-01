package com.example.examplemod.items.seed;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.blocks.BlocksRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemCornSeeds extends ItemSeeds {
    public ItemCornSeeds(String name) {
        super(BlocksRegister.CROP_CORN, Blocks.FARMLAND);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ExampleMod.CTAB);
        setMaxStackSize(100);
    }
}
