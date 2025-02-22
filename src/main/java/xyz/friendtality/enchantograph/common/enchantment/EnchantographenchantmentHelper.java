package xyz.friendtality.enchantograph.common.enchantment;

  import net.minecraft.core.RegistryAccess;
  import net.minecraft.core.particles.ParticleTypes;
  import net.minecraft.core.registries.Registries;
  import net.minecraft.server.level.ServerLevel;

  import net.minecraft.world.damagesource.DamageSource;

  import net.minecraft.world.damagesource.DamageTypes;
  import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

  import net.minecraft.world.item.enchantment.EnchantmentHelper;
  import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

  import java.util.List;

public class EnchantographenchantmentHelper extends EnchantmentHelper {

    public static void doPostFallDamageEffects(ServerLevel level,LivingEntity entity, float damage){
        runIterationOnEquipment(entity,
                (enchantmentholder, enchantmentLevel , itemInUse )->{
                if(enchantmentholder.getKey() == EnchantographEnchants.IMPACT){
                    RegistryAccess registryAccess = level.registryAccess();
                    List<Entity> entities = level.getEntities(entity, new AABB(entity.position().subtract(new Vec3(enchantmentLevel,enchantmentLevel,enchantmentLevel)), entity.position().add(new Vec3(enchantmentLevel,enchantmentLevel,enchantmentLevel))));
                    level.sendParticles(ParticleTypes.LARGE_SMOKE ,entity.getX(),entity.getY()+0.5,entity.getZ(),50,0,0,0,0.2);
                    for(Entity e: entities){
                        e.hurt(new DamageSource(
                                registryAccess.lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(DamageTypes.THORNS), null, entity, null),
                                (float)(damage*Math.sqrt(2^enchantmentLevel)));
                    }
                }
                });
    }

}
