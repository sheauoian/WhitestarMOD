package com.github.sheauoian.whitestar.block;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import com.github.sheauoian.whitestar.Whitestar;
import com.github.sheauoian.whitestar.block.custom.DFPortalBlock;
import com.github.sheauoian.whitestar.block.custom.ModFlammableRotatedPillarBlock;
import com.github.sheauoian.whitestar.block.custom.ModmealableBlock;
import com.github.sheauoian.whitestar.creativemodetab.ModCreativeModeTab;
import com.github.sheauoian.whitestar.fluid.ModFluids;
import com.github.sheauoian.whitestar.item.ModItems;
import com.github.sheauoian.whitestar.world.feature.tree.CosmicTreeGrower;
import com.github.sheauoian.whitestar.world.feature.tree.WhiteTreeGrower;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
        ForgeRegistries.BLOCKS, Whitestar.MODID
    );

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> sup) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(
            sup.get(), new Item.Properties().tab(ModCreativeModeTab.WhitestarTab)));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> sup, ModCreativeModeTab whitestarTab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, sup);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static ToIntFunction<BlockState> light = BlockState -> 10;
    /* 
    # 以下ブロックをいっぱい書く
    */
    

    // 基本ブロック

    public static final RegistryObject<Block> COSMIC_GRASS_BLOCK = registerBlock("cosmic_grass_block", 
        () -> new ModmealableBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)
        .strength(0.2f)
        ), ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> COSMIC_DIRT = registerBlock("cosmic_dirt", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)
        .strength(0.2f)
        ), ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> COSMIC_STONE = registerBlock("cosmic_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f)
                    .requiresCorrectToolForDrops()
            ), ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> BLACK_STONE = registerBlock("black_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(10f)
                    .lightLevel(BlockState -> 15)
                    .requiresCorrectToolForDrops()
            ), ModCreativeModeTab.WhitestarTab);




    // 鉱石 関連

    public static final RegistryObject<Block> OISTAR_ORE = registerBlock("oistar_ore", 
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
        .strength(6f).requiresCorrectToolForDrops(),
        UniformInt.of(3, 7)), ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> DEEPSLATE_OISTAR_ORE = registerBlock("deepslate_oistar_ore", 
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
        .strength(6f).requiresCorrectToolForDrops(),
        UniformInt.of(3, 7)), ModCreativeModeTab.WhitestarTab);


    // Cosmic Tree 関連

    public static final RegistryObject<Block> COSMIC_LOG = registerBlock("cosmic_log", 
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
        .lightLevel(light)
        .strength(6f)
        .requiresCorrectToolForDrops()
        ), ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> STRIPPED_COSMIC_LOG = registerBlock("stripped_cosmic_log", 
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
        .lightLevel(light)
        .strength(6f)
        .requiresCorrectToolForDrops()
        ), ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> COSMIC_WOOD = registerBlock("cosmic_wood", 
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
        .lightLevel(light)
        .strength(2f)
        .requiresCorrectToolForDrops()
        ), ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> STRIPPED_COSMIC_WOOD = registerBlock("stripped_cosmic_wood", 
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
        .lightLevel(light)
        .strength(6f)
        .requiresCorrectToolForDrops()
        ), ModCreativeModeTab.WhitestarTab);

    public static final RegistryObject<Block> COSMIC_LEAVES = registerBlock("cosmic_leaves", 
        () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
        .lightLevel(light)
        .strength(1f)
        .requiresCorrectToolForDrops()
        ){
            @Override
            public boolean isFlammable(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
                return true;
            }

            @Override
            public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
                return 5;
            }

            @Override
            public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
                return 20;
            }
        }, ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> COSMIC_PLANKS = registerBlock("cosmic_planks", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
        .lightLevel(light)
        .strength(6f)
        .requiresCorrectToolForDrops()
        ) {
            @Override
            public boolean isFlammable(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
                return true;
            }

            @Override
            public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
                return 30;
            }

            @Override
            public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
                return 60;
            }
        }, ModCreativeModeTab.WhitestarTab);

    public static final RegistryObject<Block> COSMIC_SAPLING = registerBlock("cosmic_sapling", 
        () -> new SaplingBlock(new CosmicTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WhitestarTab);
    


    // White Tree 関連

    public static final RegistryObject<Block> WHITE_LOG = registerBlock("white_log", 
    () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
    .strength(2f)
    .requiresCorrectToolForDrops()
    ), ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> STRIPPED_WHITE_LOG = registerBlock("stripped_white_log", 
    () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
    .strength(2f)
    .requiresCorrectToolForDrops()
    ), ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> WHITE_WOOD = registerBlock("white_wood", 
    () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
    .strength(2f)
    .requiresCorrectToolForDrops()
    ), ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> STRIPPED_WHITE_WOOD = registerBlock("stripped_white_wood", 
    () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
    .strength(2f)
    .requiresCorrectToolForDrops()
    ), ModCreativeModeTab.WhitestarTab);

    public static final RegistryObject<Block> WHITE_LEAVES = registerBlock("white_leaves", 
    () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
    .lightLevel(light)
    .strength(1f)
    .requiresCorrectToolForDrops()
    ){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
            return 5;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
            return 20;
        }
    }, ModCreativeModeTab.WhitestarTab);
    public static final RegistryObject<Block> WHITE_PLANKS = registerBlock("white_planks", 
    () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
    .lightLevel(light)
    .strength(2f)
    .requiresCorrectToolForDrops()
    ) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
            return 30;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
            return 60;
        }
    }, ModCreativeModeTab.WhitestarTab);

    public static final RegistryObject<Block> WHITE_SAPLING = registerBlock("white_sapling", 
    () -> new SaplingBlock(new WhiteTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WhitestarTab);

    public static final RegistryObject<Block> DONFAI_PORTAL = registerBlock("donfai_portal",
        DFPortalBlock::new, ModCreativeModeTab.WhitestarTab);
        

    // 三流河川 流体ブロック
    
    public static final RegistryObject<LiquidBlock> DIRTY_WATER_BLOCK = BLOCKS.register("dirty_water_block",
        () -> new LiquidBlock(ModFluids.SOURCE_SOAP_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));


    // 花
    public static final RegistryObject<Block> JASMINE = registerBlock("jasmine",
            () -> new FlowerBlock(MobEffects.GLOWING, 5,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), ModCreativeModeTab.WhitestarTab);

    public static final RegistryObject<Block> POTTED_JASMINE = BLOCKS.register("potted_jasmine",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.JASMINE,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
