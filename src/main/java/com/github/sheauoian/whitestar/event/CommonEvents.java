package com.github.sheauoian.whitestar.event;

import com.github.sheauoian.whitestar.Whitestar;

import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Whitestar.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {
    @SubscribeEvent
    public void onSleep(PlayerSleepInBedEvent event)
    {
        event.getEntity().setCustomName(Component.translatable("お前、オイスターだな?"));
        event.getEntity().sendSystemMessage(Component.translatable("お前、オイスターだな?"));
    }
}
