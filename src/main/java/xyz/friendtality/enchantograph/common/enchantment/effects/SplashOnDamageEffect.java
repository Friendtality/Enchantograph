package xyz.friendtality.enchantograph.common.enchantment.effects;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.SimpleMapCodec;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import xyz.friendtality.enchantograph.common.tags.EnchantographDataComponentTypes;

import java.util.List;

public record SplashOnDamageEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<SplashOnDamageEffect> CODEC = SimpleMapCodec.unit(SplashOnDamageEffect::new);

    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        ItemStack stack = item.itemStack();
        float damage = stack.get(EnchantographDataComponentTypes.STORED_DAMAGE) == null ? 0 : stack.get(EnchantographDataComponentTypes.STORED_DAMAGE);
        if(damage > 0){
            RegistryAccess registryAccess = level.registryAccess();
            double areaMod = 3*Math.sqrt(enchantmentLevel);
                    List<Entity> entities = level.getEntities(entity, new AABB(entity.position().subtract(new Vec3(areaMod,1,areaMod)), entity.position().add(new Vec3(areaMod,1,areaMod))));
                    level.sendParticles(ParticleTypes.LARGE_SMOKE ,entity.getX(),entity.getY()+0.5,entity.getZ(),50,0,0,0,0.2);
                    for(Entity e: entities) {
                        e.hurt(new DamageSource(
                                        registryAccess.lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(DamageTypes.THORNS), null, entity, null),
                                (float) (damage * Math.sqrt(enchantmentLevel)));
                    }
        }
            stack.remove(EnchantographDataComponentTypes.STORED_DAMAGE);
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
