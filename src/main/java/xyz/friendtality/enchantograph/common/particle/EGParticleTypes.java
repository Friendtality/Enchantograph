package xyz.friendtality.enchantograph.common.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.enchantograph.Enchatograph;

public class EGParticleTypes {
    public static final DeferredRegister<ParticleType<?>> EG_PARTICLE_TYPES =
            DeferredRegister.create(Registries.PARTICLE_TYPE, Enchatograph.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> IMPACT_PARTICLE =
            EG_PARTICLE_TYPES.register("impact_particle", ()-> new SimpleParticleType(false));

    public static void register(IEventBus eventBus){
        EG_PARTICLE_TYPES.register(eventBus);
    }

}
