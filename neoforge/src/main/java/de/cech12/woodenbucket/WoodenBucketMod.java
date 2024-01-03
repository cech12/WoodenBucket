package de.cech12.woodenbucket;

import de.cech12.bucketlib.api.BucketLibApi;
import de.cech12.bucketlib.api.item.UniversalBucketItem;
import de.cech12.woodenbucket.init.ModTags;
import de.cech12.woodenbucket.platform.Services;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(WoodenBucketMod.MOD_ID)
public class WoodenBucketMod {

    public static final String MOD_ID = "woodenbucket";

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<Item> WOODEN_BUCKET = ITEMS.register("wooden_bucket", () -> new UniversalBucketItem(
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

    private void sendImc(InterModEnqueueEvent evt) {
        BucketLibApi.registerBucket(WOODEN_BUCKET.getId());
    }

}
