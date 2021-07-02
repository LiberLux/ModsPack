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
    public static final Item NYAM = new Food("nyam", 2, 600, false);
    public static final Item POTATOES = new Food("potatoes", 2, 600, false);
    public static final Item Carrot = new Food("carrot", 2, 600, false);
    public static final Item Cucumbers = new Food("cucumbers", 2, 600, false);
    public static final Item Tomatoes = new Food("tomatoes", 2, 600, false);
    public static final Item Cabbage = new Food("cabbage", 2, 600, false);
    public static final Item Turnip = new Food("turnip", 2, 600, false);
    public static final Item Onion = new Food("onion", 2, 600, false);
    public static final Item Garlic = new Food("garlic", 2, 600, false);
    public static final Item Grapes = new Food("grapes", 2, 600, false);
    public static final Item Corn = new Food("corn", 2, 600, false);
    public static final Item Rice = new Food("rice", 2, 600, false);
    public static final Item Wheat = new Food("wheat", 2, 600, false);
    public static final Item Beet = new Food("beet", 2, 600, false);
    public static final Item Apples = new Food("apples", 2, 600, false);
    public static final Item Radish = new Food("radish", 2, 600, false);
    public static final Item Horseradish = new Food("horseradish", 2, 600, false);
    public static final Item Pepper = new Food("pepper", 2, 600, false);
    public static final Item Cinnamon = new Food("cinnamon", 2, 600, false);
    public static final Item Vanilla = new Food("vanilla", 2, 600, false);
    public static final Item chill_pepper = new Food("chill_pepper", 2, 600, false);
    public static final Item strawberry = new Food("strawberry", 2, 600, false);
    public static final Item pineapple = new Food("pineapple", 2, 600, false);


    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(
                POTATOES,               NYAM,                   Carrot,                 Cucumbers,
                Tomatoes,               Cabbage,                Turnip,                 Onion,
                Garlic,                 Grapes,                 Corn,                   Rice,
                Wheat,                  Beet,                   Apples,                 Radish,
                Horseradish,            Pepper,                 Cinnamon,               Vanilla,
                chill_pepper,           strawberry,             pineapple
        );
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {
        registryModel(POTATOES);
        registryModel(NYAM);
        registryModel(Carrot);
        registryModel(Cucumbers);
        registryModel(Tomatoes);
        registryModel(Cabbage);
        registryModel(Turnip);
        registryModel(Onion);
        registryModel(Garlic);
        registryModel(Grapes);
        registryModel(Corn);
        registryModel(Rice);
        registryModel(Wheat);
        registryModel(Beet);
        registryModel(Apples);
        registryModel(Radish);
        registryModel(Horseradish);
        registryModel(Pepper);
        registryModel(Cinnamon);
        registryModel(Vanilla);
        registryModel(chill_pepper);
        registryModel(strawberry);
        registryModel(pineapple);
    }

    @SideOnly(Side.CLIENT)
    private static void registryModel(Item item) {
        final ResourceLocation regName = item.getRegistryName();// Не забываем, что getRegistryName может вернуть Null!
        final ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
        ModelBakery.registerItemVariants(item, mrl);// Регистрация вариантов предмета. Это нужно если мы хотим использовать подтипы предметов/блоков(см. статью подтипы)
        ModelLoader.setCustomModelResourceLocation(item, 0, mrl);// Устанавливаем вариант модели для нашего предмета. Без регистрации варианта модели, сама модель не будет установлена для предмета/блока(см. статью подтипы)
    }

}
