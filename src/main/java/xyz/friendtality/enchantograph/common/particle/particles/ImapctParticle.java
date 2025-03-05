package xyz.friendtality.enchantograph.common.particle.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;

public class ImapctParticle extends TextureSheetParticle {
    private final SpriteSet spriteSet;

    public ImapctParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet) {
        super(level, x, y, z);
        this.scale(6);
        this.spriteSet = spriteSet;
        this.gravity = 0;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public void tick() {
        this.setSpriteFromAge(spriteSet);
        super.tick();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }
}
