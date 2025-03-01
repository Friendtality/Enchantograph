package xyz.friendtality.enchantograph.common.enchantment;

  import net.minecraft.server.level.ServerLevel;

  import net.minecraft.world.entity.LivingEntity;

  import net.minecraft.world.item.enchantment.Enchantment;
  import net.minecraft.world.item.enchantment.EnchantmentHelper;
  import xyz.friendtality.enchantograph.common.tags.EGDataComponentTypes;

  import java.util.Objects;

public class EGEnchantmentHelper extends EnchantmentHelper {

    public static void doPostFallDamageEffects(ServerLevel level,LivingEntity entity, float damage){
        runIterationOnEquipment(entity,
                (enchantmentholder, enchantmentLevel , itemInUse )->{
                    itemInUse.itemStack().set(EGDataComponentTypes.STORED_DAMAGE.get(), damage);
                    if(enchantmentholder.value().effects().get(EGEnchantmentComponentTypes.ON_FALL_DAMAGE.get()) != null) {
                        Enchantment.applyEffects(
                                enchantmentholder.value().effects().get(EGEnchantmentComponentTypes.ON_FALL_DAMAGE.get()), // Or whichever other List<ConditionalEffect<T>> you want
                                Enchantment.entityContext(level, enchantmentLevel, entity, entity.position()),
                                (effectData) -> {
                                    effectData.apply(level, enchantmentLevel, itemInUse, entity, entity.position());
                                } // Use the effectData (in this example, an EnchantmentValueEffect) however you want.
                        );
                    }
                });
    }


}
