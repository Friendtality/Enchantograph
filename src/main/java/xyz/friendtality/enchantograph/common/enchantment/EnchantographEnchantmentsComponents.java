package xyz.friendtality.enchantograph.common.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.enchantograph.VoxelingEnchants;
import xyz.friendtality.enchantograph.common.enchantment.effects.PropelOnKeyEffect;
import xyz.friendtality.enchantograph.common.enchantment.effects.SplashOnDamageEffect;
import xyz.friendtality.enchantograph.common.enchantment.effects.ImpactEntityEffect;
import xyz.friendtality.enchantograph.common.enchantment.effects.TeleportOwnerEffect;

import java.util.function.Supplier;

public class EnchantographEnchantmentsComponents {
    public static DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENCH_ENCH_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, VoxelingEnchants.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> WARP =
            ENCH_ENCH_EFFECTS.register("warp", ()-> TeleportOwnerEffect.CODEC);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> IMPACT =
            ENCH_ENCH_EFFECTS.register("impact", ()-> ImpactEntityEffect.CODEC);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> SPLASH =
            ENCH_ENCH_EFFECTS.register("spash_damage", ()-> SplashOnDamageEffect.CODEC);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> PROPEL =
            ENCH_ENCH_EFFECTS.register("spash_damage", ()-> PropelOnKeyEffect.CODEC);



    public static void register(IEventBus eventBus){
        ENCH_ENCH_EFFECTS.register(eventBus);
    }
}
