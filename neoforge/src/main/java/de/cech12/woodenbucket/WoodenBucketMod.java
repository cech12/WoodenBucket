package de.cech12.woodenbucket;

import de.cech12.bucketlib.api.BucketLibApi;
import de.cech12.bucketlib.api.item.UniversalBucketItem;
import de.cech12.woodenbucket.init.ModTags;
import de.cech12.woodenbucket.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
@Mod(Constants.MOD_ID)
public class WoodenBucketMod {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    public static final DeferredItem<Item> WOODEN_BUCKET = ITEMS.register(Constants.WOODEN_BUCKET_NAME, () -> new UniversalBucketItem(
            ResourceKey.create(BuiltInRegistries.ITEM.key(), Constants.id(Constants.WOODEN_BUCKET_NAME)),
            new UniversalBucketItem.Properties()
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

    public WoodenBucketMod(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        //Config
        CommonLoader.init();
        //register for IMC event
        modEventBus.addListener(this::sendImc);
    }

    private void sendImc(RegisterCapabilitiesEvent evt) {
        BucketLibApi.registerBucket(evt, WOODEN_BUCKET.getId());
    }

}
