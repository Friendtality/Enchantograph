package xyz.friendtality.enchantograph.common.packages;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import xyz.friendtality.enchantograph.Enchatograph;
import xyz.friendtality.enchantograph.common.packages.fclient.ClientPayloadHandeler;
import xyz.friendtality.enchantograph.common.packages.fclient.TryDashPackage;
import xyz.friendtality.enchantograph.common.packages.fserver.ActuallyDashPackage;
import xyz.friendtality.enchantograph.common.packages.fserver.ServerPayloadHandeler;

@EventBusSubscriber(modid = Enchatograph.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Packages {


    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event){
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playBidirectional(
                TryDashPackage.TYPE,
                TryDashPackage.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        ClientPayloadHandeler::handleTryDassh,
                        ServerPayloadHandeler::handleTryDash
                )
        );
        registrar.playBidirectional(
                ActuallyDashPackage.TYPE,
                ActuallyDashPackage.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        ClientPayloadHandeler::handleActuallyDash,
                        ServerPayloadHandeler::handleActuallyDash
                )
        );
    }
}
