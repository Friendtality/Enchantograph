package xyz.friendtality.enchantograph.common.enchantment;

import net.minecraft.advancements.critereon.DamageSourcePredicate;
import net.minecraft.advancements.critereon.TagPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.AddValue;
import net.minecraft.world.item.enchantment.effects.AllOf;
import net.minecraft.world.item.enchantment.effects.DamageItem;
import net.minecraft.world.level.storage.loot.predicates.DamageSourceCondition;
import xyz.friendtality.enchantograph.VoxelingEnchants;
import xyz.friendtality.enchantograph.common.enchantment.enchantments.ImpactEntityEffect;
import xyz.friendtality.enchantograph.common.enchantment.enchantments.TeleportEntityEffect;


public class EnchantographEnchants {

    public static final ResourceKey<Enchantment> WARP = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(VoxelingEnchants.MODID,"warp"));
    public static final ResourceKey<Enchantment> IMPACT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(VoxelingEnchants.MODID,"impact"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        HolderGetter<Enchantment> enchantmentHolderGetter = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> itemHolderGetter = context.lookup(Registries.ITEM);
        register(
                context,
                WARP,
                Enchantment.enchantment(
                                Enchantment.definition(
                                        itemHolderGetter.getOrThrow(ItemTags.TRIDENT_ENCHANTABLE),
                                        10,
                                        4,
                                        Enchantment.dynamicCost(1, 11),
                                        Enchantment.dynamicCost(12, 11),
                                        1,
                                        EquipmentSlotGroup.HAND
                                )
                        )
                        .exclusiveWith(enchantmentHolderGetter.getOrThrow(EnchantographEnchTags.WARP_EXCLUSIVE))
                        .withEffect(
                                EnchantmentEffectComponents.HIT_BLOCK,
                                new TeleportEntityEffect())

        );
//        register(
//                context,
//                IMPACT,
//                Enchantment.enchantment(
//                                Enchantment.definition(
//                                        itemHolderGetter.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
//                                        10,
//                                        4,
//                                        Enchantment.dynamicCost(1, 11),
//                                        Enchantment.dynamicCost(12, 11),
//                                        1,
//                                        EquipmentSlotGroup.FEET
//                                )
//                        )
//        );

    }
    private static void register(BootstrapContext<Enchantment> context, ResourceKey <Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.location()));
    }
}
