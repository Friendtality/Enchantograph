package xyz.friendtality.enchantograph.common.conditions.lootitemconditions;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.enchantograph.VoxelingEnchants;

import java.util.function.Supplier;

public class EnchantographLootItemConditions {
    public static final DeferredRegister<LootItemConditionType> ENCH_LOOT_ITEM_CON =
            DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, VoxelingEnchants.MODID);

//    public static final Supplier<LootItemConditionType> ENCH_LOCATION_CHECKS =
//          ENCH_LOOT_ITEM_CON.register("enchantograph_location_checks", ()-> new LootItemConditionType(EnchantographLocationCheks.CODEC));

    public static void register(IEventBus eventBus){
        ENCH_LOOT_ITEM_CON.register(eventBus);
    }
}