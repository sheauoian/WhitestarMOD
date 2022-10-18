package com.github.sheauoian.whitestar.world.feature;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.Supplier;

import com.github.sheauoian.whitestar.Whitestar;
import com.github.sheauoian.whitestar.block.ModBlocks;
import com.github.sheauoian.whitestar.fluid.ModFluids;
import com.google.common.base.Suppliers;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.*;

import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;

import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
        DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Whitestar.MODID);
    

    // [Configured] Oistar Ore
    public static final Supplier<List<OreConfiguration.TargetBlockState>> LEVEL_OISTAR_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.OISTAR_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.BLACK_STONE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_OISTAR_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OISTAR_ORE = CONFIGURED_FEATURES.register("oistar_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LEVEL_OISTAR_ORES.get(),7)));


    // [Configured] Cosmic Tree
    public static final RegistryObject<ConfiguredFeature<?, ?>> COSMIC =
        CONFIGURED_FEATURES.register("cosmic", () ->
            new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.COSMIC_LOG.get()),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.simple(ModBlocks.COSMIC_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> COSMIC_SPAWN =
        CONFIGURED_FEATURES.register("cosmic_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
            new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                ModPlacedFeatures.COSMIC_CHECKED.getHolder().get(),
                0.5F)), ModPlacedFeatures.COSMIC_CHECKED.getHolder().get())));
    

    // [Configured] White Tree
    public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_TREE =
        CONFIGURED_FEATURES.register("white_tree", () ->
                new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.WHITE_LOG.get()),
                        new MegaJungleTrunkPlacer(23, 2, 24),
                        BlockStateProvider.simple(ModBlocks.WHITE_LEAVES.get()),
                        new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
                        new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
                ).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_TREE_SPAWN =
        CONFIGURED_FEATURES.register("white_tree_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
            new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                ModPlacedFeatures.WHITE_TREE_CHECKED.getHolder().get(),
                0.5F)), ModPlacedFeatures.WHITE_TREE_CHECKED.getHolder().get())));

    // [Configured] Forest Rock
    public static final RegistryObject<ConfiguredFeature<?, ?>> COSMIC_ROCK =
            CONFIGURED_FEATURES.register("cosmic_rock", () ->
                    new ConfiguredFeature<>(
                            Feature.FOREST_ROCK,
                            new BlockStateConfiguration(ModBlocks.COSMIC_STONE.get().defaultBlockState())
                    ));
    public static final RegistryObject<ConfiguredFeature<?, ?>> COSMIC_ROCK_SPAWN =
            CONFIGURED_FEATURES.register("cosmic_rock_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.COSMIC_ROCK_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.COSMIC_ROCK_CHECKED.getHolder().get())));


    /* [Configured] Forest Rock
    public static final Holder<ConfiguredFeature<BlockStateConfiguration, ?>> DIRTY_LAKE = FeatureUtils.register(
            "forest_rock",
            Feature.FOREST_ROCK,
            new BlockStateConfiguration(ModBlocks.WHITE_WOOD.get().defaultBlockState()));
     */
    public static final RegistryObject<ConfiguredFeature<?, ?>> DIRTY_LAKE = CONFIGURED_FEATURES.register(
            "dirty_lake",
            () -> new ConfiguredFeature<>(
                    Feature.LAKE,
                    new LakeFeature.Configuration(
                            BlockStateProvider.simple(ModBlocks.DIRTY_WATER_BLOCK.get().defaultBlockState()),
                            BlockStateProvider.simple(ModBlocks.COSMIC_WOOD.get().defaultBlockState()))
                    )
    );
    public static final RegistryObject<ConfiguredFeature<?, ?>> DIRTY_LAKE_SPAWN =
            CONFIGURED_FEATURES.register("dirty_lake_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.DIRTY_LAKE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.DIRTY_LAKE_CHECKED.getHolder().get())));


    public static final RegistryObject<ConfiguredFeature<?, ?>> JASMINE = CONFIGURED_FEATURES.register("jasmine",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.JASMINE.get()))))));




    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
