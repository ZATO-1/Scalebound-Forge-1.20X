package net.stefan.scalebound.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stefan.scalebound.ScaleboundMod;
import net.stefan.scalebound.block.custom.WildGarlicCropBlock;
import net.stefan.scalebound.fluid.ModFluids;
import net.stefan.scalebound.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ScaleboundMod.MOD_ID);

    // Misc blocks
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> WEEPING_ROSE = registerBlock("weeping_rose",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 4, BlockBehaviour.Properties.copy(Blocks.RED_TULIP)));
    public static final RegistryObject<Block> POTTED_WEEPING_ROSE = BLOCKS.register("potted_weeping_rose",
            () -> new FlowerPotBlock((() -> (FlowerPotBlock)Blocks.FLOWER_POT), WEEPING_ROSE, BlockBehaviour.Properties.copy(Blocks.POTTED_RED_TULIP)));

    public static final RegistryObject<LiquidBlock> BLOOD_BLOCK = BLOCKS.register("blood_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BLOOD_WATER, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    // WOODS
    public static final RegistryObject<Block> GREY_PLANK = registerBlock("grey_plank",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BANJO)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GREY_STAIRS = registerBlock("grey_stairs",
            () -> new StairBlock(() -> ModBlocks.GREY_PLANK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MANGROVE_STAIRS)));

    public static final RegistryObject<Block> GREY_SLABS = registerBlock("grey_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_SLAB)));

    // Custom BLOCKS

    public static final RegistryObject<Block> FROSTED_ICE = registerBlock("frosted_ice",
            () -> new MagmaBlock(BlockBehaviour.Properties.copy(Blocks.MAGMA_BLOCK)));

    // CROPS

    public static final RegistryObject<Block> WILD_GARLIC_CROP = BLOCKS.register("wild_garlic_crop",
            () -> new WildGarlicCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().noOcclusion()));





    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
