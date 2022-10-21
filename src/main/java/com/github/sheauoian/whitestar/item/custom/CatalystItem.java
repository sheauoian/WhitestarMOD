package com.github.sheauoian.whitestar.item.custom;

import com.github.sheauoian.whitestar.block.ModBlocks;
import com.github.sheauoian.whitestar.block.custom.DFPortalBlock;
import com.github.sheauoian.whitestar.creativemodetab.ModCreativeModeTab;
import com.github.sheauoian.whitestar.world.feature.dimension.ModDimensions;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class CatalystItem extends Item {
    public CatalystItem() {
        super(new Properties()
                .tab(ModCreativeModeTab.WhitestarTab)
                .stacksTo(1)
                .rarity(Rarity.RARE)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() != null) {
            if(context.getPlayer().level.dimension() == ModDimensions.DONFAIDIM_KEY
                    || context.getPlayer().level.dimension() == Level.OVERWORLD) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if(((DFPortalBlock) ModBlocks.DONFAI_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(
                                context.getPlayer(),
                                framePos,
                                SoundEvents.PORTAL_TRIGGER,
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else {
                        context.getPlayer().sendSystemMessage(Component.translatable("お前、オイスターだな?"));
                        return InteractionResult.FAIL;
                    }
                }
            }
        }
        return InteractionResult.FAIL;
    }
}