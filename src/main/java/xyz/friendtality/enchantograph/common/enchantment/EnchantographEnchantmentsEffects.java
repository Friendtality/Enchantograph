package xyz.friendtality.enchantograph.common.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.enchantograph.VoxelingEnchants;
import xyz.friendtality.enchantograph.common.enchantment.enchantments.TeleportEntityEffect;

import java.util.function.Supplier;

public class EnchantographEnchantmentsEffects {
    public static DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENCH_ENCH_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, VoxelingEnchants.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> WARP =
            ENCH_ENCH_EFFECTS.register("warp", ()-> TeleportEntityEffect.CODEC);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> IMPACT =
            ENCH_ENCH_EFFECTS.register("impact", ()-> TeleportEntityEffect.CODEC);

    public static void register(IEventBus eventBus){
        ENCH_ENCH_EFFECTS.register(eventBus);
    }
}
