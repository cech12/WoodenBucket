package cech12.woodenbucket.init;

import cech12.woodenbucket.WoodenBucketMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class ModTags {

    public static class Fluids {

        public static final TagKey<Fluid> CRACKING = tag("cracking");
        public static final TagKey<Fluid> BURNING = tag("burning");
        public static final TagKey<Fluid> FREEZING = tag("freezing");

        private static TagKey<Fluid> tag(@Nonnull String name) {
            return TagKey.create(ForgeRegistries.FLUIDS.getRegistryKey(), new ResourceLocation(WoodenBucketMod.MOD_ID, name));
        }

    }

    public static class Blocks {

        public static final TagKey<Block> BURNING = tag("burning");
        public static final TagKey<Block> FREEZING = tag("freezing");

        private static TagKey<Block> tag(@Nonnull String name) {
            return TagKey.create(ForgeRegistries.BLOCKS.getRegistryKey(), new ResourceLocation(WoodenBucketMod.MOD_ID, name));
        }

    }

}
