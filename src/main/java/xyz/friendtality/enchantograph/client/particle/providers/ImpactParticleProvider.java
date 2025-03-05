package xyz.friendtality.enchantograph.client.particle.providers;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleOptions;
import org.jetbrains.annotations.Nullable;
import xyz.friendtality.enchantograph.common.particle.particles.ImapctParticle;

public class ImpactParticleProvider implements ParticleProvider {

    private final SpriteSet spriteSet;

    public ImpactParticleProvider(SpriteSet spriteSet){
        this.spriteSet = spriteSet;
    }
    @Override
    public @Nullable Particle createParticle(ParticleOptions type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        return new ImapctParticle(level, x, y, z, spriteSet);
    }
}
