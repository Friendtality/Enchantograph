package xyz.friendtality.enchantograph.common.packages.fclient;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.arguments.coordinates.LocalCoordinates;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import xyz.friendtality.enchantograph.common.packages.fserver.ActuallyDashPackage;

import static java.lang.Math.*;

public class ClientPayloadHandeler {

    public static void handleActuallyDash(final ActuallyDashPackage data, final IPayloadContext context) {
        if(Dist.CLIENT.isClient()) {
            float acc = data.acceleration();
            Player player =context.player();
            Vec2 vec2 = player.getRotationVector();
            float f = Mth.cos((vec2.y + 90.0F) * (float) (Math.PI / 180.0));
            float f1 = Mth.sin((vec2.y + 90.0F) * (float) (Math.PI / 180.0));
            float f2 = Mth.cos(-vec2.x * (float) (Math.PI / 180.0));
            float f3 = Mth.sin(-vec2.x * (float) (Math.PI / 180.0));
            float f4 = Mth.cos((-vec2.x + 90.0F) * (float) (Math.PI / 180.0));
            float f5 = Mth.sin((-vec2.x + 90.0F) * (float) (Math.PI / 180.0));
            Vec3 vec31 = new Vec3((f * f2), f3, (f1 * f2));
            Vec3 vec32 = new Vec3((f * f4), f5, (f1 * f4));
            double d0 = vec31.x * acc + vec32.x * 0.3 * acc;
            double d1 = vec31.y * acc + vec32.y * 0.3 * acc;
            double d2 = vec31.z * acc + vec32.z * 0.3 * acc;
            player.addDeltaMovement(new Vec3(d0, d1, d2));
        }
    }

    public static void handleTryDassh(final TryDashPackage data, IPayloadContext context){

    }

    }