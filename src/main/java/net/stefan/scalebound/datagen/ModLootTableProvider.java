package net.stefan.scalebound.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.stefan.scalebound.datagen.loot.ModBlockLootTables;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider {
    public static LootTableProvider create(PackOutput packOutput){
        return new LootTableProvider(packOutput, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)));

    }
}
