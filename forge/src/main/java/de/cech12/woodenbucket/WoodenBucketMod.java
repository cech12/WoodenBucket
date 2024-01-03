package de.cech12.woodenbucket;

import de.cech12.bucketlib.api.BucketLibApi;
import de.cech12.bucketlib.api.item.UniversalBucketItem;
import de.cech12.woodenbucket.init.ModTags;
import de.cech12.woodenbucket.platform.Services;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(WoodenBucketMod.MOD_ID)
@Mod.EventBusSubscriber(modid = WoodenBucketMod.MOD_ID)
public class WoodenBucketMod {

    public static final String MOD_ID = "woodenbucket";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Item> WOODEN_BUCKET = ITEMS.register("wooden_bucket", () -> new UniversalBucketItem(
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

    public WoodenBucketMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        //Config
        CommonLoader.init();
        //register for IMC event
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::sendImc);
    }

    private void sendImc(InterModEnqueueEvent evt) {
        BucketLibApi.registerBucket(WOODEN_BUCKET.getId());
    }

}
