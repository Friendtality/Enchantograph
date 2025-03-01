package xyz.friendtality.enchantograph.common.packages.fserver;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import xyz.friendtality.enchantograph.common.ServerGlobals;
import xyz.friendtality.enchantograph.common.packages.fclient.TryDashPackage;

public class ServerPayloadHandeler {
    public static void handleTryDash(final TryDashPackage data, final IPayloadContext context) {
        context.player().addTag("dash");
    }

    public static void handleActuallyDash(final  ActuallyDashPackage data, final  IPayloadContext context){
    }
}
