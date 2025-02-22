package xyz.friendtality.enchantograph.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import xyz.friendtality.enchantograph.common.block.EnchantographBlocks;

import java.util.Set;

public class BlockLootTableProvider extends BlockLootSubProvider {
    protected BlockLootTableProvider( HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropOther(EnchantographBlocks.UNSTABLE_RIPPER_BLOCK.get(), Items.STONE.asItem());
    }
}
