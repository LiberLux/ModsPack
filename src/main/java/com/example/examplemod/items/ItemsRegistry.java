package com.example.examplemod.items;

import com.example.examplemod.items.TestItem.ItemKey;
import com.example.examplemod.items.Tools.Hoe;
import com.example.examplemod.items.Tools.Sword;
import com.example.examplemod.items.ToolsForKitchen.ToolForKitchen;
import com.example.examplemod.items.eat.Food;
import com.example.examplemod.items.seed.ItemCornSeeds;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@GameRegistry.ObjectHolder("examplemod")
@Mod.EventBusSubscriber
public class ItemsRegistry {
    @GameRegistry.ObjectHolder("key")
    public static final Item KEY = new ItemKey();
    public static final Item SWORD = new Sword("sword", Item.ToolMaterial.DIAMOND);
    public static final Item CORN_SEED = new ItemCornSeeds("corn_seed");
    public static final Item KNIFE = new ToolForKitchen("knife");
    public static final Item HOE = new Hoe("hoe", Item.ToolMaterial.DIAMOND);




    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(KEY,SWORD,CORN_SEED,KNIFE,HOE);
    }


    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {
        registryModel(KEY);
        registryModel(SWORD);
        registryModel(CORN_SEED);
        registryModel(KNIFE);
        registryModel(HOE);

    }

    @SideOnly(Side.CLIENT)
    private static void registryModel(Item item) {
        final ResourceLocation regName = item.getRegistryName();// Не забываем, что getRegistryName может вернуть Null!
        final ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
        ModelBakery.registerItemVariants(item, mrl);// Регистрация вариантов предмета. Это нужно если мы хотим использовать подтипы предметов/блоков(см. статью подтипы)
        ModelLoader.setCustomModelResourceLocation(item, 0, mrl);// Устанавливаем вариант модели для нашего предмета. Без регистрации варианта модели, сама модель не будет установлена для предмета/блока(см. статью подтипы)
    }
}