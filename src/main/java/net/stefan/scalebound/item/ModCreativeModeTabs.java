package net.stefan.scalebound.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.stefan.scalebound.ScaleboundMod;
import net.stefan.scalebound.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ScaleboundMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> COURSE_TAB = CREATIVE_MODE_TABS.register("scalebound_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BOTTLE_OF_BLOOD.get()))
                    .title(Component.translatable("creativetab.scalebound_tab"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(ModItems.BOTTLE_OF_BLOOD.get());
                        output.accept(ModItems.STEEL_INGOT.get());
                        output.accept(ModItems.BLOOD_INFUSED_STEEL_INGOT.get());

                        output.accept(ModItems.WILD_GARLIC.get());
                        output.accept(ModItems.WILD_GARLIC_SEEDS.get());

                        // spawn eggs
                        output.accept(ModItems.TEST_SPAWN_EGG.get());


                        output.accept(ModItems.LIMESTONE_DUST.get());
                        output.accept(ModItems.RAVEN_CLAW.get());

                        output.accept(ModItems.ALUCARDS_SHIELD.get());
                        output.accept(ModItems.ALUCARDS_DAGGER.get());

                        output.accept(ModItems.SACRIFICIAL_KNIFE.get());

                        output.accept(ModItems.WOLFE_HIDE.get());

                        output.accept(ModItems.CURSED_PICKAXE.get());
                        output.accept(ModItems.CURSED_AXE.get());
                        output.accept(ModItems.CURSED_SHOVEL.get());
                        output.accept(ModItems.CURSED_HOE.get());
                        output.accept(ModItems.CURSED_PAXEL.get());

                        output.accept(ModItems.ADVENTURER_AXE.get());
                        output.accept(ModItems.SPEAR.get());


                        output.accept(ModBlocks.STEEL_BLOCK.get());
                        output.accept(ModBlocks.GREY_PLANK.get());
                        output.accept(ModBlocks.GREY_STAIRS.get());
                        output.accept(ModBlocks.GREY_SLABS.get());

                        output.accept(ModBlocks.WEEPING_ROSE.get());

                        output.accept(ModBlocks.FROSTED_ICE.get());




                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
