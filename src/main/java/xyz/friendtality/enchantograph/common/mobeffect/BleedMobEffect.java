package xyz.friendtality.enchantograph.common.mobeffect;

import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BleedMobEffect extends MobEffect {
    protected BleedMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        var dTypeReg = livingEntity.damageSources().damageTypes;
        var dType = dTypeReg.getHolder(DamageTypes.MAGIC).orElse(dTypeReg.getHolderOrThrow(DamageTypes.MAGIC));
        livingEntity.hurt(new DamageSource(dType), 1.0F);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int i = 40 >> amplifier;
        return i > 0 ? duration % i == 0 : true;
    }
}
