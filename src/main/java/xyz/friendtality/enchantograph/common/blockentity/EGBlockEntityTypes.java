package xyz.friendtality.enchantograph.common.blockentity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.enchantograph.common.block.EGBlocks;
import xyz.friendtality.enchantograph.common.blockentity.blockentities.UnstableRipperBlockEntity;

import java.util.function.Supplier;

import static xyz.friendtality.enchantograph.Enchatograph.MODID;

public class EGBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> ENCH_BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    public static final Supplier<BlockEntityType<UnstableRipperBlockEntity>> UNSTABLE_RIPPER_BLOCK_ENTITY = ENCH_BLOCK_ENTITY_TYPES.register(
            "unstable_ripper_blockentity",
            () -> BlockEntityType.Builder.of(
                    UnstableRipperBlockEntity::new,
                    EGBlocks.UNSTABLE_RIPPER_BLOCK.get()
            ).build(null)

    );

    public static void register(IEventBus eventBus){
        ENCH_BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
