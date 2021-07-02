package com.example.examplemod;

import com.example.examplemod.GUI.GuiMysteriousStranger;
import com.example.examplemod.blocks.BlocksRegister;
import com.example.examplemod.items.ItemsRegistry;
import com.example.examplemod.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        BlocksRegister.register();
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        BlocksRegister.registerRender();
    }

    void  openMyGui ()
    {
        Minecraft.getMinecraft().displayGuiScreen(new GuiMysteriousStranger());
    }

    public static final CreativeTabs CTAB = new CreativeTabs("examplemod") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemsRegistry.KEY);
        }
    };
    public static final CreativeTabs FOOD = new CreativeTabs("FOOD") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemsRegistry.KEY);
        }
    };
}


