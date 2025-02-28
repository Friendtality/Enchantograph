package xyz.friendtality.enchantograph.common.packages.fclient;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import xyz.friendtality.enchantograph.Enchatograph;

public record TryDashPackage(Boolean force) implements CustomPacketPayload {

    public static CustomPacketPayload.Type<TryDashPackage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID, "try_dash_payload"));

    public static final StreamCodec<ByteBuf, TryDashPackage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL,
            TryDashPackage::force,
            TryDashPackage::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
