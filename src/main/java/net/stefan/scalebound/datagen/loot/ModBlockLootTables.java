package net.stefan.scalebound.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import net.stefan.scalebound.block.ModBlocks;
import net.stefan.scalebound.block.custom.WildGarlicCropBlock;
import net.stefan.scalebound.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.STEEL_BLOCK.get());

        this.dropSelf(ModBlocks.GREY_PLANK.get());

        this.dropSelf(ModBlocks.GREY_STAIRS.get());

        this.dropSelf(ModBlocks.FROSTED_ICE.get());

        this.add(ModBlocks.GREY_SLABS.get(),
                block -> createSlabItemTable(ModBlocks.GREY_SLABS.get()));

       /* this.add(ModBlocks.insertoreblock.get(),
                block -> createOreDrop(ModBlocks.insertoreblock.get(), ModItems.insertraworeitem.get())); */


        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.WILD_GARLIC_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(WildGarlicCropBlock.AGE, 6));
        this.add(ModBlocks.WILD_GARLIC_CROP.get(), this.createCropDrops(ModBlocks.WILD_GARLIC_CROP.get(),
                ModItems.WILD_GARLIC.get(), ModItems.WILD_GARLIC_SEEDS.get(), lootitemcondition$builder1));


        this.dropSelf(ModBlocks.WEEPING_ROSE.get());
        this.add(ModBlocks.POTTED_WEEPING_ROSE.get(),
                createPotFlowerItemTable(ModBlocks.POTTED_WEEPING_ROSE.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
