package com.example.examplemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlocksRegister
{
    public static Block BEST_STONE = new BlockBestStone("best_stone");
    public static Block BLUE_STONE = new BlueBlock("blue_block");

    public static void register()
    {
        setRegister(BLUE_STONE);
        setRegister(BEST_STONE);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {
        setRender(BLUE_STONE);
        setRender(BEST_STONE);
    }

    private static void setRegister(Block block)
    {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Block block)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}

