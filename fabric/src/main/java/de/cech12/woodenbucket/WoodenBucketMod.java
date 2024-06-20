package de.cech12.woodenbucket;

import de.cech12.bucketlib.api.BucketLibApi;
import de.cech12.bucketlib.api.item.UniversalBucketItem;
import de.cech12.woodenbucket.init.ModTags;
import de.cech12.woodenbucket.platform.Services;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

@SuppressWarnings("unused")
public class WoodenBucketMod implements ModInitializer {

    public static final ResourceLocation WOODEN_BUCKET_LOCATION = Constants.id("wooden_bucket");

    public static final Item WOODEN_BUCKET = Registry.register(BuiltInRegistries.ITEM, WOODEN_BUCKET_LOCATION, new UniversalBucketItem(new UniversalBucketItem.Properties()
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
    ));

    @Override
    public void onInitialize() {
        CommonLoader.init();
        //register bucket
        BucketLibApi.registerBucket(WOODEN_BUCKET_LOCATION);
    }

}
