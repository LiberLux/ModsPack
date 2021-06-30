package com.example.examplemod.items;

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

/*
 * Указывает ModId для других ObjectHolder в классе
 * Если не добавлять аннотацию над классом, то каждый раз придётся прописывать ModId вручную.
 * Подробнее см. https://mcforge.readthedocs.io/en/latest/concepts/registries/#injecting-registry-values-into-fields
 */
@GameRegistry.ObjectHolder("examplemod")
@Mod.EventBusSubscriber// Автоматическая регистрация статичных обработчиков событий
public class ItemsRegistry {
    /*
     * Получение предмета по ключу. Вы также можете использовать данную аннотацию для получения ванильных предметов
     * Если вы не добавляли аннотация над классом, то в таком случаи вам нужно прописать вместо `key` -> `tut:key`
     */
    @GameRegistry.ObjectHolder("key")
    public static final Item KEY = null;
    public static final ItemOutSword SWORD = null;


    /*
     * Начиная с 1.12 регистрацию предметов/блоков/моделей и т.п. следует проводить в специальном событии.
     * Событие Register<IForgeRegistryEntry> поддерживает регистрацию: Block, Item, Potion, Biome, SoundEvent,
     * PotionType, Enchantment, IRecipe,  VillagerProfession, EntityEntry.
     * Обратите внимание! Метод является статичным, так как мы используем EventBusSubscriber
     */
    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> e) {
        // Также вместо `register` можно использовать `registerAll`, чтобы прописать все предметы разом
        e.getRegistry().registerAll(new ItemKey(),  new ItemOutSword("sword", Item.ToolMaterial.DIAMOND));
    }

    /*
     * Начиная с 1.11 регистрацию моделей для предметов/блоков следует проводить в специальном событии.
     * Обратите внимание! Метод является статичным, так как мы используем EventBusSubscriber
     */
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {
        registryModel(KEY);
        registryModel(SWORD);
    }
    @SideOnly(Side.CLIENT)
    private static void registryModel(Item item) {
        final ResourceLocation regName = item.getRegistryName();// Не забываем, что getRegistryName может вернуть Null!
        final ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
        ModelBakery.registerItemVariants(item, mrl);// Регистрация вариантов предмета. Это нужно если мы хотим использовать подтипы предметов/блоков(см. статью подтипы)
        ModelLoader.setCustomModelResourceLocation(item, 0, mrl);// Устанавливаем вариант модели для нашего предмета. Без регистрации варианта модели, сама модель не будет установлена для предмета/блока(см. статью подтипы)
    }
}