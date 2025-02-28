package xyz.friendtality.enchantograph.common.conditions.lootitemconditions;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.enchantograph.Enchatograph;

public class EGLootItemConditions {
    public static final DeferredRegister<LootItemConditionType> ENCH_LOOT_ITEM_CON =
            DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, Enchatograph.MODID);

    public static void register(IEventBus eventBus){
        ENCH_LOOT_ITEM_CON.register(eventBus);
    }
}