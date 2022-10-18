package com.github.sheauoian.whitestar.villager;

import com.github.sheauoian.whitestar.Whitestar;
import com.github.sheauoian.whitestar.block.ModBlocks;
import com.google.common.collect.ImmutableSet;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPOIs {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, Whitestar.MODID);

    public static final RegistryObject<PoiType> DONFAI_PORTAL =
            POI.register("donfai_portal", () -> new PoiType(
                    ImmutableSet.copyOf(ModBlocks.DONFAI_PORTAL.get().getStateDefinition().getPossibleStates())
                    , 0, 1));

    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}