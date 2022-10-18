package com.github.sheauoian.whitestar.creativemodetab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab extends CreativeModeTab
{
    public static final ModCreativeModeTab WhitestarTab
    = new ModCreativeModeTab(CreativeModeTab.getGroupCountSafe(), "whitestar");

    public ModCreativeModeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.HONEY_BLOCK);
    }
}