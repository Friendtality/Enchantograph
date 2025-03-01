package xyz.friendtality.enchantograph.common.mobeffect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.enchantograph.Enchatograph;

public class EGMobEffects {
    public static final DeferredRegister<MobEffect> EG_MOB_EFFECTS =DeferredRegister.create(Registries.MOB_EFFECT, Enchatograph.MODID);

    public static final Holder<MobEffect> BLEED = EG_MOB_EFFECTS.register("bleed", ()-> new BleedMobEffect(MobEffectCategory.HARMFUL,0xff0000));

    public static void register(IEventBus eventBus){
        EG_MOB_EFFECTS.register(eventBus);
    }
}
