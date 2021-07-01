package com.example.examplemod.items;

import com.example.examplemod.items.eat.Food;
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
public class FOOD {
    public static final Item NYAM = new Food("nyam", 2,2,false);
    public static final Item POTATOES = new Food("potatoes", 2,2,false);

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(POTATOES,NYAM);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {
        registryModel(POTATOES);
        registryModel(NYAM);
    }

    @SideOnly(Side.CLIENT)
    private static void registryModel(Item item) {
        final ResourceLocation regName = item.getRegistryName();// Не забываем, что getRegistryName может вернуть Null!
        final ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
        ModelBakery.registerItemVariants(item, mrl);// Регистрация вариантов предмета. Это нужно если мы хотим использовать подтипы предметов/блоков(см. статью подтипы)
        ModelLoader.setCustomModelResourceLocation(item, 0, mrl);// Устанавливаем вариант модели для нашего предмета. Без регистрации варианта модели, сама модель не будет установлена для предмета/блока(см. статью подтипы)
    }
}
