package xyz.friendtality.enchantograph.common.enchantment.effects;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record ImpactEntityEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<ImpactEntityEffect> CODEC = MapCodec.unit(ImpactEntityEffect::new);
    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return null;
    }
}
