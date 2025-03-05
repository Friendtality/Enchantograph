package xyz.friendtality.enchantograph.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;
import xyz.friendtality.enchantograph.Enchatograph;
import xyz.friendtality.enchantograph.common.particle.EGParticleTypes;

public class EGParticleDescriptionProvider extends ParticleDescriptionProvider {

    protected EGParticleDescriptionProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, fileHelper);
    }

    @Override
    protected void addDescriptions() {
        spriteSet(EGParticleTypes.IMPACT_PARTICLE.get(),
                ResourceLocation.fromNamespaceAndPath(Enchatograph.MODID, "impact_particle"),
                7,
                false);

    }
}
