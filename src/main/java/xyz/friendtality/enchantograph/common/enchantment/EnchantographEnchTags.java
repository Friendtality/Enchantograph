package xyz.friendtality.enchantograph.common.enchantment;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import xyz.friendtality.enchantograph.VoxelingEnchants;

import java.security.PublicKey;

public class EnchantographEnchTags {

    public static final TagKey<Enchantment> WARP_EXCLUSIVE = TagKey.create(Registries.ENCHANTMENT,
                ResourceLocation.fromNamespaceAndPath(VoxelingEnchants.MODID, "warp_exclusive"));

    public static final TagKey<Enchantment> IMPACT_EXCLUSIVE = TagKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(VoxelingEnchants.MODID, "impact_exclusive"));
}
