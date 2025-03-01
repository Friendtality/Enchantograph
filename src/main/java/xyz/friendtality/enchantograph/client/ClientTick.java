package xyz.friendtality.enchantograph.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import xyz.friendtality.enchantograph.Enchatograph;
import xyz.friendtality.enchantograph.common.packages.fclient.TryDashPackage;

@OnlyIn(Dist.CLIENT)
public class ClientTick {

    public static void onClientTick(ClientTickEvent.Post event) {
        while(EGKeybinds.DASH.get().consumeClick()){
            System.out.println("Ahhhh");
            PacketDistributor.sendToServer(new TryDashPackage(false));
        }
    }

    public static void dash(float velocity) {
    }



}