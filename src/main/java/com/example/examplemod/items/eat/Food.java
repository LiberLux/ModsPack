package com.example.examplemod.items.eat;

import com.example.examplemod.ExampleMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Food extends ItemFood {
    public Food(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        setCreativeTab(ExampleMod.FOOD);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        if (player.getFoodStats().getFoodLevel() > 2)
            player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 100));
    }
}
