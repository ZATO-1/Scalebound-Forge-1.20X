package net.stefan.scalebound.item;

import com.ibm.icu.number.Scale;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.stefan.scalebound.ScaleboundMod;
import net.stefan.scalebound.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier CURSED = TierSortingRegistry.registerTier(
            new ForgeTier(5,2000,10f,3f,26,
                    ModTags.Blocks.NEEDS_CURSED_TOOL, () -> Ingredient.of(ModItems.STEEL_INGOT.get())),
            new ResourceLocation(ScaleboundMod.MOD_ID, "steel_ingot"), List.of(Tiers.DIAMOND), List.of());

}
