package com.example.examplemod.items.Tools;

import com.example.examplemod.ExampleMod;
import net.minecraft.item.ItemSword;


public class Sword extends ItemSword{
    public Sword(String name, ToolMaterial material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(ExampleMod.CTAB);
    }
}


