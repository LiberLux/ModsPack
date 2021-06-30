package com.example.examplemod;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;

public class CraftingRegister {
    public static void register() {
        registerRecipes("key");
    }

    private static void registerRecipes(String name) {
        CraftingHelper.register(new ResourceLocation("examplemod", name), (IRecipeFactory) (context, json) -> CraftingHelper.getRecipe(json, context));
    }
}
