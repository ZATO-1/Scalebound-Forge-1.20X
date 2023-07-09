package net.stefan.scalebound.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stefan.scalebound.ScaleboundMod;
import net.stefan.scalebound.block.ModBlocks;
import net.stefan.scalebound.fluid.ModFluids;
import net.stefan.scalebound.item.custom.AlucardsDaggerItem;
import net.stefan.scalebound.item.custom.AlucardsShieldItem;
import net.stefan.scalebound.item.custom.ModFoodProperties;
import net.stefan.scalebound.item.custom.PaxelItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ScaleboundMod.MOD_ID);


    // Add Items here

    // Ingots, ores and dust

    public static final RegistryObject<Item> BLOOD_INFUSED_STEEL_INGOT = ITEMS.register("blood_infused_steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIMESTONE_DUST = ITEMS.register("limestone_dust",
            () -> new Item(new Item.Properties()));

    // Misc

    public static final RegistryObject<Item> BLOOD_BUCKET = ITEMS.register("blood_bucket",
            () -> new BucketItem(ModFluids.SOURCE_BLOOD_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> BOTTLE_OF_BLOOD = ITEMS.register("bottle_of_blood",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_ESSENCE = ITEMS.register("blood_essence",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAVEN_CLAW = ITEMS.register("raven_claw",
            () -> new Item(new Item.Properties()));

    // Spawn Eggs
    public static final RegistryObject<Item> TEST_SPAWN_EGG = ITEMS.register("test_spawn_egg",
            () -> new SpawnEggItem(EntityType.DOLPHIN, 0x7e9680, 0xc5d1c5,
                    new Item.Properties())); // when adding your own mob use ForgeSpawnEggItem(ModEntityType.yourmob

    // public static final RegistryObject<Item> TEST = ITEMS.register("test");

    // Food items
    public static final RegistryObject<Item> WILD_GARLIC = ITEMS.register("wild_garlic",
            () -> new Item(new Item.Properties().food(ModFoodProperties.WILD_GARLIC)));

    // Artifacts
    public static final RegistryObject<Item> ALUCARDS_SHIELD = ITEMS.register("alucards_shield",
            () -> new ShieldItem(new Item.Properties()));

    public static final RegistryObject<Item> ALUCARDS_DAGGER = ITEMS.register("alucards_dagger",
            () -> new AlucardsDaggerItem(ModToolTiers.CURSED, 2, 3, new Item.Properties().durability(256)));

    public static final RegistryObject<Item> SACRIFICIAL_KNIFE = ITEMS.register("sacrificial_knife",
            () -> new SwordItem(ModToolTiers.CURSED, 2, 3, new Item.Properties().durability(256)));

    // TOOLS

    public static final RegistryObject<Item> CURSED_AXE = ITEMS.register("cursed_axe",
            () -> new AxeItem(ModToolTiers.CURSED, 2, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CURSED_PICKAXE = ITEMS.register("cursed_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CURSED, 2, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CURSED_SHOVEL = ITEMS.register("cursed_shovel",
            () -> new ShovelItem(ModToolTiers.CURSED, 2, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CURSED_HOE = ITEMS.register("cursed_hoe",
            () -> new HoeItem(ModToolTiers.CURSED, 2, 3, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CURSED_PAXEL = ITEMS.register("cursed_paxel",
            () -> new PaxelItem(ModToolTiers.CURSED, 2, 3, new Item.Properties().durability(256)));

    // ARMOR

    public static final RegistryObject<Item> WOLFE_HIDE = ITEMS.register("wolf_hide",
            () -> new Item(new Item.Properties()));

    // crops

    public static final RegistryObject<Item> WILD_GARLIC_SEEDS = ITEMS.register("wild_garlic_seeds",
            () -> new ItemNameBlockItem(ModBlocks.WILD_GARLIC_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
