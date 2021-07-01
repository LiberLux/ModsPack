package com.example.examplemod.items.Tools;

import com.example.examplemod.ExampleMod;
import net.minecraft.item.ItemHoe;

public class Hoe extends ItemHoe {
    public Hoe(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        setCreativeTab(ExampleMod.CTAB);
    }
}
