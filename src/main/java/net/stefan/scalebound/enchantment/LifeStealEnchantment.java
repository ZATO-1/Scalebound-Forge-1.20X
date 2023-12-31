package net.stefan.scalebound.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LifeStealEnchantment extends Enchantment {
    protected LifeStealEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide()) {
            ServerLevel level = ((ServerLevel) pAttacker.level());
            BlockPos position = pTarget.blockPosition();

            if (pLevel == 1) {
                EntityType.BAT.spawn(level, (ItemStack) null, null, position,
                        MobSpawnType.TRIGGERED, true, true);
            }

            if (pLevel == 2) {
            //    MobEffects.HEAL

            }

            super.doPostAttack(pAttacker, pTarget, pLevel);
        }



    }
    @Override
    public int getMaxLevel() {
        return 2;
    }
}
