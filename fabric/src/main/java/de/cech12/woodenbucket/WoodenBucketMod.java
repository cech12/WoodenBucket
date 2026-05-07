package de.cech12.woodenbucket;

import de.cech12.bucketlib.api.BucketLibApi;
import de.cech12.woodenbucket.item.WoodenBucketItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

@SuppressWarnings("unused")
public class WoodenBucketMod implements ModInitializer {

    public static final ResourceLocation WOODEN_BUCKET_LOCATION = Constants.id(Constants.WOODEN_BUCKET_NAME);

    public static final Item WOODEN_BUCKET = Registry.register(BuiltInRegistries.ITEM, WOODEN_BUCKET_LOCATION, new WoodenBucketItem(
            ResourceKey.create(BuiltInRegistries.ITEM.key(), WOODEN_BUCKET_LOCATION)
    ));

    @Override
    public void onInitialize() {
        CommonLoader.init();
        //register bucket
        BucketLibApi.registerBucket(WOODEN_BUCKET_LOCATION);
    }

}
