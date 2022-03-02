package cech12.woodenbucket;

import cech12.bucketlib.api.BucketLibApi;
import cech12.bucketlib.api.item.UniversalBucketItem;
import cech12.woodenbucket.config.ServerConfig;
import cech12.woodenbucket.init.ModTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static cech12.woodenbucket.WoodenBucketMod.MOD_ID;

@Mod(MOD_ID)
@Mod.EventBusSubscriber(modid = MOD_ID)
public class WoodenBucketMod {

    public static final String MOD_ID = "woodenbucket";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Item> WOODEN_BUCKET = ITEMS.register("wooden_bucket", () -> new UniversalBucketItem(
            new UniversalBucketItem.Properties()
                    .durability(ServerConfig.DURABILITY)
                    .upperCrackingTemperature(ServerConfig.CRACKING_TEMPERATURE)
                    .burningTemperature(ServerConfig.BURNING_TEMPERATURE)
                    .burningFluids(ModTags.Fluids.BURNING)
                    .burningBlocks(ModTags.Blocks.BURNING)
                    .freezingTemperature(ServerConfig.FREEZING_TEMPERATURE)
                    .freezingFluids(ModTags.Fluids.FREEZING)
                    .freezingBlocks(ModTags.Blocks.FREEZING)
                    .crackingFluids(ModTags.Fluids.CRACKING)
                    .milking(ServerConfig.MILKING_ENABLED)
                    .entityObtaining(ServerConfig.FISH_OBTAINING_ENABLED)
    ));

    public WoodenBucketMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        //Config
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfig.SERVER_CONFIG);
        ServerConfig.loadConfig(ServerConfig.SERVER_CONFIG, FMLPaths.GAMEDIR.get().resolve(FMLConfig.defaultConfigPath()).resolve(MOD_ID + "-server.toml"));
        //register for IMC event
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::sendImc);
    }

    private void sendImc(InterModEnqueueEvent evt) {
        BucketLibApi.registerBucket(WOODEN_BUCKET.getId());
    }

}
