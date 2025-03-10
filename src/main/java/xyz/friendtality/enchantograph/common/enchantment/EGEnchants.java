package xyz.friendtality.enchantograph.common.enchantment;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.effects.AllOf;
import net.minecraft.world.item.enchantment.effects.PlaySoundEffect;
import net.minecraft.world.phys.Vec3;
import xyz.friendtality.enchantograph.Enchatograph;
import xyz.friendtality.enchantograph.common.enchantment.effects.PropelOnKeyEffect;
import xyz.friendtality.enchantograph.common.enchantment.effects.SplashOnDamageEffect;
import xyz.friendtality.enchantograph.common.enchantment.effects.TeleportOwnerEffect;


public class EGEnchants {

    public static final ResourceKey<Enchantment> WARP = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID,"warp"));
    public static final ResourceKey<Enchantment> IMPACT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID,"impact"));
    public static final ResourceKey<Enchantment> ANNIHILATION_CURSE = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID,"annihilation_curse"));
    public static final ResourceKey<Enchantment> DASH = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID,"dash"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        HolderGetter<Enchantment> enchantmentHolderGetter = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> itemHolderGetter = context.lookup(Registries.ITEM);
        register(
                context,
                WARP,
                Enchantment.enchantment(
                                Enchantment.definition(
                                        itemHolderGetter.getOrThrow(ItemTags.TRIDENT_ENCHANTABLE),
                                        1,
                                        1,
                                        Enchantment.constantCost(28),
                                        Enchantment.constantCost(50),
                                        1,
                                        EquipmentSlotGroup.HAND
                                )
                        )
                        .exclusiveWith(enchantmentHolderGetter.getOrThrow(EGEnchTags.WARP_EXCLUSIVE))
                        .withEffect(
                                EnchantmentEffectComponents.HIT_BLOCK,
                                new TeleportOwnerEffect())

        );
        register(
                context,
                IMPACT,
                Enchantment.enchantment(
                                Enchantment.definition(
                                        itemHolderGetter.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                                        5,
                                        3,
                                        Enchantment.dynamicCost(10, 8),
                                        Enchantment.dynamicCost(18, 8),
                                        1,
                                        EquipmentSlotGroup.FEET
                                )
                        )
                        .exclusiveWith(enchantmentHolderGetter.getOrThrow(EGEnchTags.IMPACT_EXCLUSIVE))
                        .withEffect(
                                EGEnchantmentComponentTypes.ON_FALL_DAMAGE.get(),
                                AllOf.entityEffects(
                                        new PlaySoundEffect(SoundEvents.GENERIC_EXPLODE, ConstantFloat.of(5.0F), ConstantFloat.of(1.0F)),
                                        new SplashOnDamageEffect(false)
                                ))
        );
        register(
                context,
                DASH,
                Enchantment.enchantment(
                                Enchantment.definition(
                                        itemHolderGetter.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                                        1,
                                        1,
                                        Enchantment.constantCost(28),
                                        Enchantment.constantCost(50),
                                        1,
                                        EquipmentSlotGroup.FEET
                                )
                        )
                        .exclusiveWith(enchantmentHolderGetter.getOrThrow(EGEnchTags.IMPACT_EXCLUSIVE))
                        .withEffect(
                                EnchantmentEffectComponents.TICK,
                                AllOf.entityEffects(
                                        new PropelOnKeyEffect(1f)
                                ))
        );
        register(
                context,
                ANNIHILATION_CURSE,
                Enchantment.enchantment(
                                Enchantment.definition(
                                        itemHolderGetter.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                                        5,
                                        3,
                                        Enchantment.dynamicCost(10, 8),
                                        Enchantment.dynamicCost(18, 8),
                                        1,
                                        EquipmentSlotGroup.FEET
                                )
                        )
                        .exclusiveWith(enchantmentHolderGetter.getOrThrow(EGEnchTags.IMPACT_EXCLUSIVE))
                        .withEffect(
                                EGEnchantmentComponentTypes.ON_FALL_DAMAGE.get(),
                                AllOf.entityEffects(
                                        new SplashOnDamageEffect(true)
                                ))
        );


    }
    private static void register(BootstrapContext<Enchantment> context, ResourceKey <Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.location()));
    }
}
