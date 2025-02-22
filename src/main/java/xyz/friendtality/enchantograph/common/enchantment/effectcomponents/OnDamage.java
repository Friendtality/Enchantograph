package xyz.friendtality.enchantograph.common.enchantment.effectcomponents;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageType;

public record OnDamage(HolderSet<DamageType> damageType, int amount) {
    public static final Codec<OnDamage> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    RegistryCodecs.homogeneousList(Registries.DAMAGE_TYPE).fieldOf("damageType").forGetter(OnDamage::damageType),
                    Codec.INT.fieldOf("amount").forGetter(OnDamage::amount)
            ).apply(instance, OnDamage::new)
    );
}
