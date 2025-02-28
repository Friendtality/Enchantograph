package xyz.friendtality.enchantograph.common.packages.fserver;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import xyz.friendtality.enchantograph.Enchatograph;

public record ActuallyDashPackage(Float acceleration)implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ActuallyDashPackage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID, "actually_dash_package"));

    public static final StreamCodec<ByteBuf, ActuallyDashPackage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.FLOAT,
            ActuallyDashPackage::acceleration,
            ActuallyDashPackage::new
    );


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
