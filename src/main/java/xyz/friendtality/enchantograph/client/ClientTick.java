package xyz.friendtality.enchantograph.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@OnlyIn(Dist.CLIENT)
public class ClientTick {

    public static void onClientTick(ClientTickEvent.Post event) {

    }

    public static boolean dashPressed() {
        while (EnchantographKeybinds.DASH.get().consumeClick()) {
            return true;
        }
        return false;
    }

}