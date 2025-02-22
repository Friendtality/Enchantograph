package xyz.friendtality.enchantograph.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import xyz.friendtality.enchantograph.VoxelingEnchants;

import java.util.concurrent.CompletableFuture;


@EventBusSubscriber(modid = VoxelingEnchants.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EnchantographDataGens {




    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        //generator.addProvider(event.includeServer(),
        //      new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(BlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        generator.addProvider(
                event.includeServer(), new EnchantographDatapackProvider(packOutput, lookupProvider)
        );

        generator.addProvider(
                event.includeServer(), new EnchantographEnchTagsProvider(packOutput, lookupProvider, fileHelper)
        );
    }
}
