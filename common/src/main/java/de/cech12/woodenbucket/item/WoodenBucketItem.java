package de.cech12.woodenbucket.item;

import de.cech12.bucketlib.api.item.UniversalBucketItem;
import de.cech12.bucketlib.util.BucketLibUtil;
import de.cech12.woodenbucket.init.ModTags;
import de.cech12.woodenbucket.platform.Services;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WoodenBucketItem extends UniversalBucketItem {

    public WoodenBucketItem(ResourceKey<Item> id) {
        super(id, new UniversalBucketItem.Properties()
                .durability(Services.CONFIG::getDurability)
                .upperCrackingTemperature(Services.CONFIG::getBreakTemperature)
                .burningTemperature(Services.CONFIG::getBurningTemperature)
                .burningFluids(ModTags.Fluids.BURNING)
                .burningBlocks(ModTags.Blocks.BURNING)
                .freezingTemperature(Services.CONFIG::getFreezingTemperature)
                .freezingFluids(ModTags.Fluids.FREEZING)
                .freezingBlocks(ModTags.Blocks.FREEZING)
                .crackingFluids(ModTags.Fluids.CRACKING)
                .milking(Services.CONFIG::isMilkingEnabled)
                .entityObtaining(Services.CONFIG::isFishObtainingEnabled)
        );
    }

    @Override
    public int getBucketBurnTime(@NotNull ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        if (BucketLibUtil.isEmpty(itemStack)) {
            return 200; // an empty bucket should burn as long as a wooden tool
        }
        return super.getBucketBurnTime(itemStack, recipeType);
    }

}
