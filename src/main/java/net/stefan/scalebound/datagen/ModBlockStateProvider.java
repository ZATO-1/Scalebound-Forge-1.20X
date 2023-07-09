package net.stefan.scalebound.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stefan.scalebound.ScaleboundMod;
import net.stefan.scalebound.block.ModBlocks;
import net.stefan.scalebound.block.custom.WildGarlicCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ScaleboundMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockWithItem(ModBlocks.GREY_PLANK);
        blockWithItem(ModBlocks.FROSTED_ICE);


        stairsBlock((StairBlock) ModBlocks.GREY_STAIRS.get(), blockTexture(ModBlocks.GREY_PLANK.get()));
        slabBlock(((SlabBlock) ModBlocks.GREY_SLABS.get()), blockTexture(ModBlocks.GREY_PLANK.get()), blockTexture(ModBlocks.GREY_PLANK.get()));

        blockItem(ModBlocks.GREY_SLABS);
        blockItem(ModBlocks.GREY_STAIRS);

        makeCrop(((WildGarlicCropBlock) ModBlocks.WILD_GARLIC_CROP.get()), "wild_garlic_stage", "wild_garlic_stage");

        simpleBlock(ModBlocks.WEEPING_ROSE.get(),
                models().cross((blockTexture(ModBlocks.WEEPING_ROSE.get()).getPath()), blockTexture(ModBlocks.WEEPING_ROSE.get())).renderType("cutout"));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((WildGarlicCropBlock) block).getAgeProperty()),
                new ResourceLocation(ScaleboundMod.MOD_ID, "block/" + textureName + state.getValue(((WildGarlicCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    // HELPERS

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("scalebound:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
