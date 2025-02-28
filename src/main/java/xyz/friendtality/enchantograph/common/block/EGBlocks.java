package xyz.friendtality.enchantograph.common.block;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.enchantograph.common.block.blocks.UnstableRipperBlock;

import static xyz.friendtality.enchantograph.Enchatograph.MODID;

public class EGBlocks {

    public static final DeferredRegister<Block> ENCH_BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredHolder<Block, UnstableRipperBlock> UNSTABLE_RIPPER_BLOCK =
            ENCH_BLOCKS.register("unstable_ripper_block", registryName -> new UnstableRipperBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA)));

    public static void register(IEventBus eventBus){
        ENCH_BLOCKS.register(eventBus);
    }
}

