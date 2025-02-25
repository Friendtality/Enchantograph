package xyz.friendtality.enchantograph.common.enchantment.effects;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import xyz.friendtality.enchantograph.client.ClientTick;
import xyz.friendtality.enchantograph.common.tags.EnchantographDataComponentTypes;

public record PropelOnKeyEffect(Vec3 acceleration) implements EnchantmentEntityEffect {
    public static final MapCodec<PropelOnKeyEffect> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                            Vec3.CODEC.fieldOf("acceleration").forGetter(PropelOnKeyEffect::acceleration)
                    ).apply(instance, PropelOnKeyEffect::new)
            );
    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        ItemStack stack = item.itemStack();
        if (ClientTick.dashPressed()){
        }else{

        }

    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
