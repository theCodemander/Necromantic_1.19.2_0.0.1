package com.theCodemander.necromantic.block;

import com.google.common.base.Supplier;
import com.theCodemander.necromantic.NecromanticMod;
import com.theCodemander.necromantic.block.custom.NecromanticInfusionAltar;
import com.theCodemander.necromantic.block.custom.__NecromanticInfusionAltar;
import com.theCodemander.necromantic.item.NecromanticCreativeTab;
import com.theCodemander.necromantic.item.NecromanticItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NecromanticBlocks {
    public static final DeferredRegister<Block> BLOCKS =
                DeferredRegister.create(ForgeRegistries.BLOCKS, NecromanticMod.MOD_ID);



    //Mod Blocks
    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("soul_crystal_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.5f).requiresCorrectToolForDrops())
            , NecromanticCreativeTab.NECROMANTIC_MOD_TAB);

    public static final RegistryObject<Block> INFUSION_ALTAR = registerBlock("infusion_altar",
            () -> new NecromanticInfusionAltar(BlockBehaviour.Properties.of(Material.STONE).noOcclusion())
            , NecromanticCreativeTab.NECROMANTIC_MOD_TAB);


    //Block Register and IEventBus
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab ){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return NecromanticItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
