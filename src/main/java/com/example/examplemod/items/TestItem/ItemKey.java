package com.example.examplemod.items.TestItem;

import com.example.examplemod.ExampleMod;
import net.minecraft.item.Item;


public class ItemKey extends Item {
    public ItemKey() {
        setRegistryName("key");
        setUnlocalizedName("key");
        setCreativeTab(ExampleMod.CTAB);
        setMaxStackSize(10);


    }


}