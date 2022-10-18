package com.github.sheauoian.whitestar;

import com.github.sheauoian.whitestar.block.ModBlocks;
import com.github.sheauoian.whitestar.event.CommonEvents;
import com.github.sheauoian.whitestar.fluid.ModFluidTypes;
import com.github.sheauoian.whitestar.fluid.ModFluids;
import com.github.sheauoian.whitestar.item.ModItems;
import com.github.sheauoian.whitestar.villager.ModPOIs;
import com.github.sheauoian.whitestar.world.feature.dimension.ModDimensions;
import com.github.sheauoian.whitestar.world.feature.ModConfiguredFeatures;
import com.github.sheauoian.whitestar.world.feature.ModPlacedFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Whitestar.MODID)
public class Whitestar
{
    public static final String MODID = "whitestar";

    private static final Logger LOGGER = LogUtils.getLogger();

    public Whitestar()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new CommonEvents());

        ModDimensions.register();

        //BiomeInit.register(eventBus);
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);

        ModFluids.register(eventBus);
        ModFluidTypes.register(eventBus);

        ModPlacedFeatures.register(eventBus);
        ModConfiguredFeatures.register(eventBus);

        ModPOIs.register(eventBus);

        eventBus.addListener(this::commonSetup);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.JASMINE.getId(), ModBlocks.POTTED_JASMINE);
        });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());


            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SOAP_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SOAP_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.DONFAI_PORTAL.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COSMIC_SAPLING.get(), RenderType.cutout());
        }
    }
}
