package xyz.friendtality.enchantograph.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.friendtality.enchantograph.VoxelingEnchants;
import xyz.friendtality.enchantograph.common.enchantment.EnchantographEnchTags;
import xyz.friendtality.enchantograph.common.enchantment.EnchantographEnchants;

import java.util.concurrent.CompletableFuture;

public class EnchantographEnchTagsProvider extends EnchantmentTagsProvider {


    public EnchantographEnchTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VoxelingEnchants.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(EnchantographEnchTags.WARP_EXCLUSIVE)
                .add(Enchantments.MENDING, Enchantments.RIPTIDE);
        tag(EnchantographEnchTags.IMPACT_EXCLUSIVE)
                .add(Enchantments.FEATHER_FALLING);


    }
}
