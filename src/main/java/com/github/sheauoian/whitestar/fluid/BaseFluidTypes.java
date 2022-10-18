package com.github.sheauoian.whitestar.fluid;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Vector3f;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

public class BaseFluidTypes extends FluidType {
    private final ResourceLocation stillTexture;
    private final ResourceLocation flowingTexture;
    private final ResourceLocation overlayTexture;
    private final int tintcolor;
    private final Vector3f fogcolor;

    public BaseFluidTypes(final ResourceLocation stillTexture, final ResourceLocation flowingTexture,
        final ResourceLocation overlayTexture, final int tintcolor, final Vector3f fogcolor, final Properties properties) {
        super(properties);
        
        this.stillTexture = stillTexture;
        this.flowingTexture = flowingTexture;
        this.overlayTexture = overlayTexture;
        this.tintcolor = tintcolor;
        this.fogcolor = fogcolor;
    }
    
    public ResourceLocation getStillTexture() {
        return stillTexture;
    }
    public ResourceLocation getFlowingTexture() {
        return flowingTexture;
    }
    public ResourceLocation getOverlayTexture() {
        return overlayTexture;
    }
    public int getTintColor() {
        return tintcolor;
    }
    public Vector3f getFogColor() {
        return fogcolor;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
         
            @Override
            public ResourceLocation getStillTexture() {
                return stillTexture;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return flowingTexture;
            }

            @Override
            public ResourceLocation getOverlayTexture() {
                return overlayTexture;
            }

            @Override
            public int getTintColor() {
                return tintcolor;
            }

            @Override
            public @NotNull Vector3f modifyFogColor(Camera camera, float particalTick, ClientLevel level,
                int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return fogcolor;
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float particalTick, 
                float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(1f);
                RenderSystem.setShaderFogEnd(6f);
            }
        });
    }
}
