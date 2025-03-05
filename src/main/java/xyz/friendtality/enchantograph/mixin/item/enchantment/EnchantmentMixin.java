package xyz.friendtality.enchantograph.mixin.item.enchantment;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.friendtality.enchantograph.common.enchantment.EGEnchTags;

@Mixin(Enchantment.class)
public class EnchantmentMixin {

    @Inject(method = "getFullname", at = @At(value = "RETURN"))
    private static void inject(Holder<Enchantment> enchantment, int level, CallbackInfoReturnable<Component> cir, @Local LocalRef<MutableComponent> comp){
        if (enchantment.is(EGEnchTags.TERRARIAN)) {
            comp.set(comp.get().withColor(0x00af00));
        } else if (enchantment.is(EGEnchTags.NAUTIC)) {
            comp.set(comp.get().withColor(0x008080));
        }else if (enchantment.is(EGEnchTags.AREAL)) {
            comp.set(comp.get().withColor(0xC0FFFF));
        }else if (enchantment.is(EGEnchTags.TRUTHLESS)) {
            comp.set(comp.get().withColor(0xD000D0));
        }

    }
}
