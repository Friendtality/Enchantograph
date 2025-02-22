package xyz.friendtality.enchantograph.common.enchantment;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.enchantograph.VoxelingEnchants;
import xyz.friendtality.enchantograph.common.enchantment.effectcomponents.OnDamage;

public class EnchantographEnchantmentComponentTypes {
    public static final DeferredRegister<DataComponentType<?>> ENCH_ENCH_COMPONENT_TYPES =
            DeferredRegister.create(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, VoxelingEnchants.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<OnDamage>> ON_FALL_DAMAGE =
            ENCH_ENCH_COMPONENT_TYPES.register("on_fall_damage",
                    () -> DataComponentType.<OnDamage>builder()
                            .persistent(OnDamage.CODEC)
                            .build()
            );


    public static void register(IEventBus eventBus){
        ENCH_ENCH_COMPONENT_TYPES.register(eventBus);
    }
}
