package com.github.sheauoian.whitestar.world.feature.tree;

import javax.annotation.Nullable;

import com.github.sheauoian.whitestar.world.feature.ModConfiguredFeatures;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class WhiteTreeGrower extends AbstractTreeGrower {

    @Override
    @Nullable
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_,
            boolean p_222911_) {
        return ModConfiguredFeatures.WHITE_TREE.getHolder().get();
    }
    
}
