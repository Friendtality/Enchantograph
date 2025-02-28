package xyz.friendtality.enchantograph.common;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class ServerGlobals {
    public static List<PlayerDashInterface> DashServerList = List.of();


    public static class PlayerDashInterface{
        public boolean force;
        public Player player;
        public PlayerDashInterface(Player pplayer, boolean pforce){
            force = pforce;
            player = pplayer;
        }
    }
}
