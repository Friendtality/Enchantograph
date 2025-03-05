package xyz.friendtality.enchantograph.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import xyz.friendtality.enchantograph.Enchatograph;
import xyz.friendtality.enchantograph.common.enchantment.EGEnchants;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class EGDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
                .add(Registries.ENCHANTMENT, EGEnchants::bootstrap);


    public EGDatapackProvider(PackOutput output, CompletableFuture< HolderLookup.Provider> registries) {
            super(output, registries, BUILDER, Set.of(Enchatograph.MODID));
        }
    }
