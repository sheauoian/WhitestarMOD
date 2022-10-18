package com.github.sheauoian.whitestar.fluid;

import com.github.sheauoian.whitestar.Whitestar;
import com.mojang.math.Vector3f;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation SOAP_OVERLAY_RL = new ResourceLocation(Whitestar.MODID, "misc/in_soap_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(
        ForgeRegistries.Keys.FLUID_TYPES, Whitestar.MODID);

    
    public static final RegistryObject<FluidType> SOAP_WATER_FLUID_TYPE = register(
        "soap_water_fluid",
        FluidType.Properties.create()
        .canExtinguish(true)
        .canPushEntity(true)
        .canSwim(false) );

    

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidTypes(
            WATER_STILL_RL, WATER_FLOWING_RL, SOAP_OVERLAY_RL, 
            0xA2f79a54, 
            new Vector3f(200f/255f, 160f/255f, 40f/255f), 
            properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
