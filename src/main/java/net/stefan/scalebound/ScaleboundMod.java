package net.stefan.scalebound;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stefan.scalebound.block.ModBlocks;
import net.stefan.scalebound.enchantment.ModEnchantments;
import net.stefan.scalebound.fluid.ModFluidTypes;
import net.stefan.scalebound.fluid.ModFluids;
import net.stefan.scalebound.item.ModCreativeModeTabs;
import net.stefan.scalebound.item.ModItemProperties;
import net.stefan.scalebound.item.ModItems;
import net.stefan.scalebound.loot.ModLootModifiers;
import net.stefan.scalebound.villager.ModVillagers;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ScaleboundMod.MOD_ID)
public class ScaleboundMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "scalebound";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public ScaleboundMod(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register the items
        ModItems.register(modEventBus);

        // Register the blocks
        ModBlocks.register(modEventBus);

        // Register the creative tab
        ModCreativeModeTabs.register(modEventBus);

        // Register enchantments
        ModEnchantments.register(modEventBus);

        // Register Loot modifiers
        ModLootModifiers.register(modEventBus);

        // Register new villagers
        ModVillagers.register(modEventBus);

        // Register new wandering trader

        // Register Fluids
        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

    }

    private void commonSetup(final FMLCommonSetupEvent event){
        event.enqueueWork(() ->{
            ComposterBlock.COMPOSTABLES.put(ModItems.WILD_GARLIC.get(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(ModItems.WILD_GARLIC_SEEDS.get(), 0.20f);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event){

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            event.enqueueWork(() ->{
                //ModItemProperties.addCustomItemProperties();



                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_BLOOD_WATER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BLOOD.get(), RenderType.translucent());

            });

        }
    }
}
