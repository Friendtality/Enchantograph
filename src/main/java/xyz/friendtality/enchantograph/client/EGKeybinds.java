package xyz.friendtality.enchantograph.client;

import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;
import xyz.friendtality.enchantograph.Enchatograph;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = Enchatograph.MODID,bus = EventBusSubscriber.Bus.MOD)
public class EGKeybinds {

    public static final Lazy<KeyMapping> DASH =
            Lazy.of(()-> new KeyMapping(Component.translatable("dash").toString(), GLFW.GLFW_KEY_LEFT_SHIFT, Component.translatable(Enchatograph.MODID).toString()));

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event){
        event.register(DASH.get());
    }

}
