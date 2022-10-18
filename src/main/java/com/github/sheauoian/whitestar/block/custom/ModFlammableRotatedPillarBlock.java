package com.github.sheauoian.whitestar.block.custom;

import javax.annotation.Nullable;

import com.github.sheauoian.whitestar.block.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock{

    public ModFlammableRotatedPillarBlock(Properties pProperties) {
        super(pProperties);
    }

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

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction action, boolean simulate)
    {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(ModBlocks.COSMIC_LOG.get())) {
                return ModBlocks.STRIPPED_COSMIC_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if (state.is(ModBlocks.COSMIC_WOOD.get())) {
                return ModBlocks.STRIPPED_COSMIC_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, action, simulate);
    } 
}