package com.theCodemander.necromantic.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class NecromanticCreativeTab {
    public static final CreativeModeTab NECROMANTIC_MOD_TAB = new CreativeModeTab("necromantic_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(NecromanticItems.SOUL_CRYSTAL.get());
        }
    };
}
