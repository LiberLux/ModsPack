package com.example.examplemod;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class Technolgies{
    Integer protein;
    Integer vegetable;
    Integer water;

    public Technolgies() {
        protein = 33;
        vegetable =33;
        water = 33;
    }

    public void eaten(Integer protein, Integer vegetable, Integer water){
        this.protein += protein;
        this.vegetable +=vegetable;
        this.water +=water;
        if(this.protein > 33) this.protein = 33;
        if(this.vegetable > 33) this.protein = 33;
        if(this.water > 33) this.protein = 33;

        if(this.protein <0) {
            this.protein = 0;
        }
        if(this.vegetable <0) {
            this.vegetable = 0;
        }
        if(this.water <0) {
            this.water = 0;
        }
    }

    public void chec(EntityPlayer player) {
        if (protein < 15) {
            player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 100));
        } else if (protein < 30) {
            player.removePotionEffect(MobEffects.NAUSEA);
            player.removePotionEffect(MobEffects.HASTE);
        } else {
            player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 100));
        }

        if (vegetable < 15) {
            player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100));
        } else if (vegetable < 30) {
            player.removePotionEffect(MobEffects.SLOWNESS);
            player.removePotionEffect(MobEffects.SPEED);
        } else {
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 100));
        }

        if (water < 15) {
            player.addPotionEffect(new PotionEffect(MobEffects.WITHER, 100));
        } else if (water < 30) {
            player.removePotionEffect(MobEffects.WITHER);
            player.removePotionEffect(MobEffects.STRENGTH);
        } else {
            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 100));
        }
    }
    public ITextComponent Printmassage(){
        TextComponentString message = new TextComponentString("белков = "+  protein +"\n раститетельной пищи = " + vegetable + "\n воды = " + water);
        return message;
    }

}
