package xyz.friendtality.enchantograph.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import xyz.friendtality.enchantograph.VoxelingEnchants;
import xyz.friendtality.enchantograph.common.enchantment.EnchantographEnchants;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class EnchantographDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
                .add(Registries.ENCHANTMENT, EnchantographEnchants::bootstrap)
                ;



    public EnchantographDatapackProvider(PackOutput output, CompletableFuture< HolderLookup.Provider> registries) {
            super(output, registries, BUILDER, Set.of(VoxelingEnchants.MODID));
        }
    }
