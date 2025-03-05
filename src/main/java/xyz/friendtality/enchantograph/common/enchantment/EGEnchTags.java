package xyz.friendtality.enchantograph.common.enchantment;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import xyz.friendtality.enchantograph.Enchatograph;

public class EGEnchTags {

    public static final TagKey<Enchantment> WARP_EXCLUSIVE = TagKey.create(Registries.ENCHANTMENT,
                ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID, "warp_exclusive"));

    public static final TagKey<Enchantment> IMPACT_EXCLUSIVE = TagKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID, "impact_exclusive"));

    public static final TagKey<Enchantment> DASH_EXCLUSIVE = TagKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID, "dash_exclusive"));



    public static final TagKey<Enchantment> TERRARIAN = TagKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID, "terrarian"));

    public static final TagKey<Enchantment> TRUTHLESS = TagKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID, "truthless"));

    public static final TagKey<Enchantment> AREAL = TagKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID, "areal"));

    public static final TagKey<Enchantment> NAUTIC = TagKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID, "nautic"));
}
