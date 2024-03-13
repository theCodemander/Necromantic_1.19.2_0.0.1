package com.theCodemander.necromantic.item;

import com.theCodemander.necromantic.NecromanticMod;

import net.minecraft.world.item.Item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NecromanticItems {
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, NecromanticMod.MOD_ID);
    
    @SuppressWarnings("null")
    public static final RegistryObject<Item> SOUL_CRYSTAL = ITEMS.register("soul_crystal", 
        () -> new Item(new Item.Properties().tab(NecromanticCreativeTab.NECROMANTIC_MOD_TAB)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
