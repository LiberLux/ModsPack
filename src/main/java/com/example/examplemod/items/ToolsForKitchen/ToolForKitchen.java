package com.example.examplemod.items.ToolsForKitchen;

import com.example.examplemod.ExampleMod;
import net.minecraft.item.Item;

public class ToolForKitchen extends Item {
    public ToolForKitchen(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(ExampleMod.CTAB);
        setMaxStackSize(1);
    }
}
