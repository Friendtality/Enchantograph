package xyz.friendtality.enchantograph.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.friendtality.enchantograph.Enchatograph;
import xyz.friendtality.enchantograph.common.enchantment.EGEnchTags;
import xyz.friendtality.enchantograph.common.enchantment.EGEnchants;

import java.util.concurrent.CompletableFuture;

public class EGEnchTantmentTagProvider extends EnchantmentTagsProvider {


    public EGEnchTantmentTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Enchatograph.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(EGEnchTags.WARP_EXCLUSIVE)
                .add(Enchantments.MENDING, Enchantments.RIPTIDE);

        tag(EGEnchTags.IMPACT_EXCLUSIVE)
                .add(Enchantments.FEATHER_FALLING)
                .addOptional(EGEnchants.DASH.location());

        tag(EGEnchTags.DASH_EXCLUSIVE)
                .add(Enchantments.FEATHER_FALLING)
                .add(Enchantments.SOUL_SPEED)
                .add(Enchantments.DEPTH_STRIDER)
                .addOptional(EGEnchants.IMPACT.location());


        tag(EGEnchTags.TERRARIAN)
                .addOptional(EGEnchants.IMPACT.location());

        tag(EGEnchTags.TRUTHLESS)
                .add(Enchantments.MENDING)
                .add(Enchantments.UNBREAKING)
                .add(Enchantments.PROTECTION)
                .add(Enchantments.FORTUNE)
                .add(Enchantments.SILK_TOUCH);

        tag(EGEnchTags.AREAL)
                .addOptional(EGEnchants.DASH.location())
                .add(Enchantments.WIND_BURST);

        tag(EGEnchTags.NAUTIC)
                .add(Enchantments.AQUA_AFFINITY)
                .add(Enchantments.FROST_WALKER)
                .add(Enchantments.DEPTH_STRIDER);

        tag(EnchantmentTags.NON_TREASURE)
                .addOptional(EGEnchants.DASH.location())
                .addOptional(EGEnchants.WARP.location())
                .addOptional(EGEnchants.IMPACT.location());

        tag(EnchantmentTags.CURSE)
                .addOptional(EGEnchants.ANNIHILATION_CURSE.location());

    }
}
