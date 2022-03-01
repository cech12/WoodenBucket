package cech12.woodenbucket.init;

import cech12.woodenbucket.WoodenBucketMod;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;

import javax.annotation.Nonnull;

public class ModTags {

    public static class Fluids {

        public static final Tag.Named<Fluid> CRACKING = tag("cracking");
        public static final Tag.Named<Fluid> BURNING = tag("burning");
        public static final Tag.Named<Fluid> FREEZING = tag("freezing");
        public static final Tag.Named<Fluid> DENY_FLUIDS = tag("deny_fluids");

        private static Tag.Named<Fluid> tag(@Nonnull String name) {
            return FluidTags.bind(WoodenBucketMod.MOD_ID + ":" + name);
        }

    }

    public static class Blocks {

        public static final Tag.Named<Block> DENY_BLOCKS = tag("deny_blocks");
        public static final Tag.Named<Block> BURNING = tag("burning");
        public static final Tag.Named<Block> FREEZING = tag("freezing");

        private static Tag.Named<Block> tag(@Nonnull String name) {
            return BlockTags.bind(WoodenBucketMod.MOD_ID + ":" + name);
        }

    }

    public static class Entities {

        public static final Tag.Named<EntityType<?>> DENY_ENTITIES = tag("deny_entities");

        private static Tag.Named<EntityType<?>> tag(@Nonnull String name) {
            return EntityTypeTags.bind(WoodenBucketMod.MOD_ID + ":" + name);
        }

    }

}
