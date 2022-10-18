package com.github.sheauoian.whitestar.item;

import java.util.function.Supplier;

import com.github.sheauoian.whitestar.Whitestar;
import com.github.sheauoian.whitestar.creativemodetab.ModCreativeModeTab;
import com.github.sheauoian.whitestar.fluid.ModFluids;
import com.github.sheauoian.whitestar.item.custom.CatalystItem;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, Whitestar.MODID
    );

    public static final RegistryObject<Item> COSMIC_SWORD = ITEMS.register(
        "cosmic_sword", 
        () -> new Item(new Item.Properties()
        .tab(ModCreativeModeTab.WhitestarTab)));

    public static final RegistryObject<Item> DIRTY_WATER_BUCKET = ITEMS.register(
        "dirty_water_bucket", 
        () -> new BucketItem(ModFluids.SOURCE_SOAP_WATER ,new Item.Properties()
        .tab(ModCreativeModeTab.WhitestarTab).stacksTo(1)));
    
    public static final RegistryObject<Item> OISTAR = ITEMS.register("oistar", 
        () -> new Item(new Item.Properties()
        .tab(ModCreativeModeTab.WhitestarTab)));
        
    public static final RegistryObject<Item> CITRINE_STAFF = ITEMS.register("citrine_staff", CatalystItem::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
