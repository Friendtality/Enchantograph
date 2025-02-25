package xyz.friendtality.enchantograph.common.enchantment;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.enchantment.ConditionalEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.enchantograph.VoxelingEnchants;

import java.util.List;

public class EnchantographEnchantmentComponentTypes {
    public static final DeferredRegister<DataComponentType<?>> ENCH_ENCH_COMPONENT_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, VoxelingEnchants.MODID);



    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<ConditionalEffect<EnchantmentEntityEffect>>>> ON_FALL_DAMAGE =
            ENCH_ENCH_COMPONENT_TYPES.register("on_take_damage",
                    () -> DataComponentType.<List<ConditionalEffect<EnchantmentEntityEffect>>>builder()
                            .persistent(ConditionalEffect.codec(EnchantmentEntityEffect.CODEC, LootContextParamSets.ENCHANTED_DAMAGE).listOf())
                            .build());


    public static void register(IEventBus eventBus){
        ENCH_ENCH_COMPONENT_TYPES.register(eventBus);
    }
}
