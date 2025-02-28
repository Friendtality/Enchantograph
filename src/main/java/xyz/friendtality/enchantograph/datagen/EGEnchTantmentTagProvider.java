package xyz.friendtality.enchantograph.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.friendtality.enchantograph.Enchatograph;
import xyz.friendtality.enchantograph.common.enchantment.EGEnchTags;

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
                .add(Enchantments.FEATHER_FALLING);


    }
}
