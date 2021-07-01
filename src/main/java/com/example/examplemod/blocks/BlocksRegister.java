package com.example.examplemod.blocks;

import com.example.examplemod.blocks.EatBlocks.BlockCropCorn;
import com.example.examplemod.blocks.ForKitchenBlocks.KitchenBlock;
import com.example.examplemod.blocks.ForKitchenBlocks.fridge;
import com.example.examplemod.blocks.RockBlocks.BlockBestStone;
import com.example.examplemod.blocks.RockBlocks.BlueBlock;
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
    public static final Block CROP_CORN = new BlockCropCorn("crop_corn");
    public static final Block CUT_BOARD= new KitchenBlock("cutting board");
    public static final Block KITCHEN_TABLE= new KitchenBlock("cook table");
    public static final Block FRIDGE= new fridge("fridge_magic");

    public static void register()
    {
        setRegister(BLUE_STONE);
        setRegister(BEST_STONE);
        setRegister( CUT_BOARD);
        setRegister( KITCHEN_TABLE);
        setRegister( FRIDGE);
        setItemBlockRegister(BEST_STONE);
        setItemBlockRegister(BLUE_STONE);
        setItemBlockRegister( CUT_BOARD);
        setItemBlockRegister( KITCHEN_TABLE);
        setItemBlockRegister( FRIDGE);
        setRegister(CROP_CORN);

    }

    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {
        setRender(BLUE_STONE);
        setRender(BEST_STONE);
        setRender( CUT_BOARD);
        setRender( KITCHEN_TABLE);
        setRender( FRIDGE);
    }

    private static void setRegister(Block block)
    {
        ForgeRegistries.BLOCKS.register(block);
    }

    private static void setItemBlockRegister(Block block) {
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Block block)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}

