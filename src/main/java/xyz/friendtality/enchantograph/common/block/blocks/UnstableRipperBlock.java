package xyz.friendtality.enchantograph.common.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import xyz.friendtality.enchantograph.common.blockentity.EGBlockEntityTypes;
import xyz.friendtality.enchantograph.common.blockentity.blockentities.UnstableRipperBlockEntity;

public class UnstableRipperBlock extends Block implements EntityBlock {
    private static final MapCodec<UnstableRipperBlock> CODEC = simpleCodec(UnstableRipperBlock::new);

    public UnstableRipperBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new UnstableRipperBlockEntity(pos,state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return blockEntityType == EGBlockEntityTypes.UNSTABLE_RIPPER_BLOCK_ENTITY.get() ? (BlockEntityTicker<T>)  UnstableRipperBlockEntity::tick : null;
    }
}

