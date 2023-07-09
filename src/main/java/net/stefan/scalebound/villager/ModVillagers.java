package net.stefan.scalebound.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stefan.scalebound.ScaleboundMod;
import net.stefan.scalebound.block.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, ScaleboundMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, ScaleboundMod.MOD_ID);

    /*public static final DeferredRegister<WanderingTrader> WANDERING_TRADER =
            DeferredRegister.create(ForgeRegistries.WANDERING_TRADER, ScaleboundMod.MOD_ID);*/

    public static final RegistryObject<PoiType> FORGE_POI = POI_TYPES.register("forge_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.FROSTED_ICE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> FORGE_MASTER =
            VILLAGER_PROFESSIONS.register("forgemaster", () -> new VillagerProfession("forgemaster",
                    x -> x.get() == FORGE_POI.get(), x -> x.get() == FORGE_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_TOOLSMITH));

    //public static final RegistryObject<WanderingTrader> DEATH =

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
        //WANDERING_TRADER.register(eventBus);
    }
}
