package xyz.friendtality.enchantograph.common.enchantment.effects;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record TeleportOwnerEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<TeleportOwnerEffect> CODEC = MapCodec.unit(TeleportOwnerEffect::new);

    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        Projectile projectile = (Projectile)entity;
        Entity owner = projectile.getOwner();
        double ownerX = owner.getX();
        double ownerY = owner.getY();
        double ownerZ = owner.getZ();
        double vecX = origin.x - ownerX;
        double vecY = origin.y - ownerY;
        double vecZ = origin.z - ownerZ;
        owner.teleportTo(origin.x, origin.y + 0.5, origin.z);
        for(int i = 0; i <= 50; i++){
            level.sendParticles(ParticleTypes.BUBBLE,ownerX+i*(vecX/50),ownerY+i*(vecY/50),ownerZ+i*(vecZ/50),1,0,0,0,0);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
