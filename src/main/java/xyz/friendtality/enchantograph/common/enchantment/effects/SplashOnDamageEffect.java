package xyz.friendtality.enchantograph.common.enchantment.effects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.SimpleMapCodec;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import xyz.friendtality.enchantograph.common.particle.EGParticleTypes;
import xyz.friendtality.enchantograph.common.tags.EGDataComponentTypes;

import java.util.List;

public record SplashOnDamageEffect(boolean shouldDestroy) implements EnchantmentEntityEffect {
    public static final MapCodec<SplashOnDamageEffect> CODEC =
            RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                            Codec.BOOL.fieldOf("shouldDestroy").forGetter(SplashOnDamageEffect::shouldDestroy)
                    ).apply(instance, SplashOnDamageEffect::new)
            );

        // SimpleMapCodec.unit(SplashOnDamageEffect::new);

    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        ItemStack stack = item.itemStack();
        float damage = stack.get(EGDataComponentTypes.STORED_DAMAGE) == null ? 0 : stack.get(EGDataComponentTypes.STORED_DAMAGE);
        if(damage > 0){
            RegistryAccess registryAccess = level.registryAccess();
            double areaMod = 2*Math.sqrt(enchantmentLevel);
                    List<Entity> entities = level.getEntities(entity, new AABB(entity.position().subtract(new Vec3(areaMod,1,areaMod)), entity.position().add(new Vec3(areaMod,areaMod/2,areaMod))));
                    for (int i = 0; i< 8; i++){
                        level.sendParticles(EGParticleTypes.IMPACT_PARTICLE.get(),
                                entity.position().x + Math.sin(45*i), entity.position().y, entity.position().z + Math.cos(45*i) ,
                                1, 0,0 ,0 ,0);
                    }
                    for(Entity e: entities) {
                        if(!(e instanceof ItemEntity) || shouldDestroy) {
                            e.hurt(new DamageSource(
                                            registryAccess.lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(DamageTypes.THORNS), null, entity, null),
                                    (float) (damage * Math.sqrt(enchantmentLevel)));
                        }
                    }
        }
            stack.remove(EGDataComponentTypes.STORED_DAMAGE);
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
