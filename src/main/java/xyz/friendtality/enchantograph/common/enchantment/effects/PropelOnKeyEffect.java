package xyz.friendtality.enchantograph.common.enchantment.effects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import xyz.friendtality.enchantograph.common.packages.fserver.ActuallyDashPackage;
import xyz.friendtality.enchantograph.common.tags.EGDataComponentTypes;

public record PropelOnKeyEffect(Float acceleration) implements EnchantmentEntityEffect {
    public static final MapCodec<PropelOnKeyEffect> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                            Codec.FLOAT.fieldOf("acceleration").forGetter(PropelOnKeyEffect::acceleration)
                    ).apply(instance, PropelOnKeyEffect::new)
            );
    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        ItemStack stack = item.itemStack();
        boolean b = false;
        for(String s: entity.getTags()){
            System.out.println(s);
            if(s.equals("dash")){
                b = true;
            }
        }
        if(!stack.has(EGDataComponentTypes.COOLDOWN)){
            stack.set(EGDataComponentTypes.COOLDOWN, 10);
        }
        if (b){
            boolean dash_used = stack.get(EGDataComponentTypes.DASH_USED.get()) == null || Boolean.TRUE.equals(stack.get(EGDataComponentTypes.DASH_USED.get()));
            if(!dash_used && stack.get(EGDataComponentTypes.COOLDOWN) < 1){
                PacketDistributor.sendToPlayer((ServerPlayer) entity,new ActuallyDashPackage(acceleration));
                entity.removeTag("dash");
                stack.set(EGDataComponentTypes.COOLDOWN, 10);
                stack.set(EGDataComponentTypes.DASH_USED, true);
            }
        }
            if(entity.onGround()){
                stack.set(EGDataComponentTypes.DASH_USED, false);
                if(stack.get(EGDataComponentTypes.COOLDOWN) > 0){
                    stack.set(EGDataComponentTypes.COOLDOWN, stack.get(EGDataComponentTypes.COOLDOWN)-1);
                }
            }

    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
