package de.cech12.woodenbucket.init;

import de.cech12.woodenbucket.WoodenBucketMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import javax.annotation.Nonnull;

public class ModTags {

    public static class Fluids {

        public static final TagKey<Fluid> CRACKING = tag("cracking");
        public static final TagKey<Fluid> BURNING = tag("burning");
        public static final TagKey<Fluid> FREEZING = tag("freezing");

        private static TagKey<Fluid> tag(@Nonnull String name) {
            return TagKey.create(Registries.FLUID, new ResourceLocation(WoodenBucketMod.MOD_ID, name));
        }

    }

    public static class Blocks {

        public static final TagKey<Block> BURNING = tag("burning");
        public static final TagKey<Block> FREEZING = tag("freezing");

        private static TagKey<Block> tag(@Nonnull String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(WoodenBucketMod.MOD_ID, name));
        }

    }

}
