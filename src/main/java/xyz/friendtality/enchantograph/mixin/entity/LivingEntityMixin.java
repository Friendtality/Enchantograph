package xyz.friendtality.enchantograph.mixin.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.friendtality.enchantograph.common.enchantment.EGEnchantmentHelper;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow protected abstract int calculateFallDamage(float fallDistance, float damageMultiplier);

    @Inject(method = "causeFallDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void injection(float fallDistance, float multiplier, DamageSource source, CallbackInfoReturnable<Boolean> cir){
        LivingEntity livingEntity = (LivingEntity)(Object)this;
        if(livingEntity.level() instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel) livingEntity.level();
            EGEnchantmentHelper.doPostFallDamageEffects(serverLevel, livingEntity, calculateFallDamage(fallDistance, multiplier));
        }
    }
}
