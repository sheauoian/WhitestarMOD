package com.github.sheauoian.whitestar.world.feature.dimension;

import com.github.sheauoian.whitestar.Whitestar;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> DONFAIDIM_KEY = ResourceKey.create(
        Registry.DIMENSION_REGISTRY, 
        new ResourceLocation(Whitestar.MODID, "oistar"));

    public static final ResourceKey<DimensionType> DONFAIDIM_TYPE = ResourceKey.create(
        Registry.DIMENSION_TYPE_REGISTRY, 
        DONFAIDIM_KEY.registry());

    public static void register() {
        System.out.println("Registering \"Don\'t Fight The Dimension\" for " + Whitestar.MODID);
    }
}
