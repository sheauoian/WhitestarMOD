package com.github.sheauoian.whitestar.world.feature;

import com.github.sheauoian.whitestar.Whitestar;
import com.github.sheauoian.whitestar.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Whitestar.MODID);
    


    // [Placed] Oistar Ore
    public static final RegistryObject<PlacedFeature> ZIRCON_ORE_PLACED = PLACED_FEATURES.register("oistar_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.OISTAR_ORE.getHolder().get(),
                    commonOrePlacement(7, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    // [Placed] Cosmic Tree
    public static final RegistryObject<PlacedFeature> COSMIC_CHECKED = PLACED_FEATURES.register("cosmic_checked",
        () -> new PlacedFeature(ModConfiguredFeatures.COSMIC.getHolder().get(),
                List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.COSMIC_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> COSMIC_PLACED = PLACED_FEATURES.register("cosmic_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.COSMIC_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));

    // [Placed] White Tree
    public static final RegistryObject<PlacedFeature> WHITE_TREE_CHECKED = PLACED_FEATURES.register("white_tree_checked",
        () -> new PlacedFeature(ModConfiguredFeatures.WHITE_TREE.getHolder().get(),
                List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.WHITE_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> WHITE_TREE_PLACED = PLACED_FEATURES.register(
            "white_tree_placed",
            () -> new PlacedFeature(
                    ModConfiguredFeatures.WHITE_TREE_SPAWN.getHolder().get(),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2))));


    // [Placed] Cosmic Rock
    public static final RegistryObject<PlacedFeature> COSMIC_ROCK_CHECKED = PLACED_FEATURES.register(
            "cosmic_rock_checked",
            () -> new PlacedFeature(
                    ModConfiguredFeatures.COSMIC_ROCK.getHolder().get(),
                    List.of()));
    public static final RegistryObject<PlacedFeature> COSMIC_ROCK_PLACED = PLACED_FEATURES.register(
            "cosmic_rock_placed",
            () -> new PlacedFeature(
                    ModConfiguredFeatures.COSMIC_ROCK_SPAWN.getHolder().get(),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2))));

    // [Placed] Cosmic Rock
    public static final RegistryObject<PlacedFeature> DIRTY_LAKE_CHECKED = PLACED_FEATURES.register(
            "dirty_lake_checked",
            () -> new PlacedFeature(
                    ModConfiguredFeatures.DIRTY_LAKE.getHolder().get(),
                    List.of()));
    public static final RegistryObject<PlacedFeature> DIRTY_LAKE_PLACED = PLACED_FEATURES.register(
            "dirty_lake_placed",
            () -> new PlacedFeature(
                    ModConfiguredFeatures.DIRTY_LAKE_SPAWN.getHolder().get(),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2))));

    // Placement Modifiers
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static final RegistryObject<PlacedFeature> JASMINE_PLACED = PLACED_FEATURES.register("jasmine_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.JASMINE.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(8),
                    InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome())));
    
    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
