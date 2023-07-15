package net.stefan.scalebound.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.stefan.scalebound.ScaleboundMod;
import net.stefan.scalebound.block.ModBlocks;
import net.stefan.scalebound.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ScaleboundMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.STEEL_INGOT);
        simpleItem(ModItems.BLOOD_BUCKET);
        simpleItem(ModItems.BLOOD_INFUSED_STEEL_INGOT);
        simpleItem(ModItems.BOTTLE_OF_BLOOD);
        simpleItem(ModItems.RAVEN_CLAW);
        simpleItem(ModItems.WILD_GARLIC);
        simpleItem(ModItems.LIMESTONE_DUST);
        simpleItem(ModItems.BLOOD_ESSENCE);
        simpleItem(ModItems.BROKEN_BONE);

        simpleItem(ModItems.TEST);

        simpleItem(ModItems.WOLFE_HIDE);

        simpleItem(ModItems.WILD_GARLIC_SEEDS);
        simpleBlockItem(ModBlocks.WEEPING_ROSE);

        handHeld(ModItems.ALUCARDS_SHIELD);
        handHeld(ModItems.ALUCARDS_DAGGER);

        handHeld(ModItems.SACRIFICIAL_KNIFE);
        //handHeld(ModItems.SPEAR);



        handHeld(ModItems.CURSED_AXE);
        handHeld(ModItems.CURSED_PICKAXE);
        handHeld(ModItems.CURSED_HOE);
        handHeld(ModItems.CURSED_SHOVEL);
        handHeld(ModItems.CURSED_PAXEL);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ScaleboundMod.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handHeld(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ScaleboundMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ScaleboundMod.MOD_ID,"item/" + item.getId().getPath()));
    }


}
