package xyz.friendtality.enchantograph.common.blockentity.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static xyz.friendtality.enchantograph.common.blockentity.EnchantographBlockEntityTypes.UNSTABLE_RIPPER_BLOCK_ENTITY;

public class UnstableRipperBlockEntity extends BlockEntity{
    private static int TICK_COUNTER;

    public UnstableRipperBlockEntity(BlockPos pos, BlockState blockState) {
        super(UNSTABLE_RIPPER_BLOCK_ENTITY.get(), pos, blockState);
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState blockState, T blockEntity) {
        TICK_COUNTER++;
        if(TICK_COUNTER >= 10){
            TICK_COUNTER = 0;

        }
    }
}