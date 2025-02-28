package xyz.friendtality.enchantograph.common.tags;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.enchantograph.Enchatograph;

import java.util.function.Supplier;

public class EGDataComponentTypes {

    public static final Codec<Float> NON_NEGATIVE_FLOAT = Codec.floatRange(0, Float.MAX_VALUE);



    public static final DeferredRegister.DataComponents REGISTRAR = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Enchatograph.MODID);


    public static final Supplier<DataComponentType<Float>> STORED_DAMAGE =
            REGISTRAR.registerComponentType(
            "stored_damage", resourceLocation -> resourceLocation.persistent(NON_NEGATIVE_FLOAT).networkSynchronized(ByteBufCodecs.FLOAT)
    );

    public static final Supplier<DataComponentType<Boolean>> DASH_USED =
            REGISTRAR.registerComponentType(
                    "dash_used", resouceLocation -> resouceLocation.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL)
            );

    public static final Supplier<DataComponentType<Integer>> COOLDOWN    =
            REGISTRAR.registerComponentType(
                    "cooldown", resouceLocation -> resouceLocation.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT)
            );



    public static void register(IEventBus eventBus){
        REGISTRAR.register(eventBus);
    }

}
