package net.stefan.scalebound.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.stefan.scalebound.ScaleboundMod;
import net.stefan.scalebound.block.ModBlocks;
import net.stefan.scalebound.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    //private static final List<ItemLike>


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.STEEL_INGOT.get())
                .unlockedBy("has_steel_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.STEEL_INGOT.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK.get())
                .unlockedBy("has_steel_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.STEEL_BLOCK.get()).build()))
                .save(pWriter);

        //nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.insertrawmaterial.get(), RecipeCategory.MISC, ModBlocks.rawitemblock.get());




    }

}
