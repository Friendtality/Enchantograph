package xyz.friendtality.enchantograph.client.particle;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import xyz.friendtality.enchantograph.Enchatograph;
import xyz.friendtality.enchantograph.client.particle.providers.ImpactParticleProvider;
import xyz.friendtality.enchantograph.common.particle.EGParticleTypes;

@EventBusSubscriber(modid = Enchatograph.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EGParticleTypeProvidere {

    @SubscribeEvent
    public static void registerParicleProviders(RegisterParticleProvidersEvent event){
        event.registerSpriteSet(EGParticleTypes.IMPACT_PARTICLE.get(), ImpactParticleProvider::new);
    }
}
