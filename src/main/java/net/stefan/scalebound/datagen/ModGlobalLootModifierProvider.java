package net.stefan.scalebound.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.stefan.scalebound.ScaleboundMod;
import net.stefan.scalebound.item.ModItems;
import net.stefan.scalebound.loot.AddItemModifier;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, ScaleboundMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("wild_garlic_seeds_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.WILD_GARLIC_SEEDS.get()));

        add("wild_garlic_seeds_from_fern", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.FERN).build(),
                LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.WILD_GARLIC_SEEDS.get()));

        add("wolf_hide_from_wolf", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/wolf")).build()},
                ModItems.WOLFE_HIDE.get()));

        add("raven_claw_from_jungle_temple", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build() },
                ModItems.RAVEN_CLAW.get()));

    }
}
