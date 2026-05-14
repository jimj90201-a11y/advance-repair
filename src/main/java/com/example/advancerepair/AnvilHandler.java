package com.example.advancerepair;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class AnvilHandler {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {

        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        float multiplier = getRepairMultiplier(left.getItem(), right);

        if (multiplier > 0) {

            ItemStack output = left.copy();

            int baseRepair = left.getMaxDamage() / 4;
            int repair = (int)(baseRepair * multiplier);

            int newDamage = Math.max(0, left.getDamageValue() - repair);
            output.setDamageValue(newDamage);

            boolean hasTrim = left.getTag() != null && left.getTag().contains("Trim");
            boolean enchanted = left.isEnchanted();

            int xpCost;

            if (hasTrim && enchanted) xpCost = 20;
            else if (enchanted) xpCost = 15;
            else if (hasTrim) xpCost = 12;
            else xpCost = 10;

            event.setOutput(output);
            event.setCost(xpCost);
        }
    }

    private static float getRepairMultiplier(Item item, ItemStack material) {

        // 🟥 Netherite
        if (isNetherite(item)) {
            if (material.is(Items.DIAMOND)) return 0.8f;
            if (material.is(Items.IRON_INGOT)) return 0.5f;
            if (material.is(Items.GOLD_INGOT)) return 0.4f;
        }

        // 🟦 Diamond
        if (isDiamond(item)) {
            if (material.is(Items.IRON_INGOT)) return 0.6f;
            if (material.is(Items.GOLD_INGOT)) return 0.45f;
        }

        // ⚙️ Iron
        if (isIron(item)) {
            if (material.is(Items.GOLD_INGOT)) return 0.7f;
        }

        // 🟤 Leather
        if (isLeather(item)) {
            if (material.is(Items.LEATHER)) return 1.0f;
        }

        // ⛓️ Chainmail (both supported)
        if (isChainmail(item)) {
            if (material.is(Items.CHAIN)) return 0.6f;
            if (material.is(Items.IRON_INGOT)) return 0.5f;
        }

        return -1f;
    }

    // 🔽 Netherite (armor + tools)
    private static boolean isNetherite(Item item) {
        return item == Items.NETHERITE_HELMET
            || item == Items.NETHERITE_CHESTPLATE
            || item == Items.NETHERITE_LEGGINGS
            || item == Items.NETHERITE_BOOTS
            || item == Items.NETHERITE_SWORD
            || item == Items.NETHERITE_PICKAXE
            || item == Items.NETHERITE_AXE
            || item == Items.NETHERITE_SHOVEL
            || item == Items.NETHERITE_HOE;
    }

    // 🔽 Diamond (armor + tools)
    private static boolean isDiamond(Item item) {
        return item == Items.DIAMOND_HELMET
            || item == Items.DIAMOND_CHESTPLATE
            || item == Items.DIAMOND_LEGGINGS
            || item == Items.DIAMOND_BOOTS
            || item == Items.DIAMOND_SWORD
            || item == Items.DIAMOND_PICKAXE
            || item == Items.DIAMOND_AXE
            || item == Items.DIAMOND_SHOVEL
            || item == Items.DIAMOND_HOE;
    }

    // 🔽 Iron (armor + tools)
    private static boolean isIron(Item item) {
        return item == Items.IRON_HELMET
            || item == Items.IRON_CHESTPLATE
            || item == Items.IRON_LEGGINGS
            || item == Items.IRON_BOOTS
            || item == Items.IRON_SWORD
            || item == Items.IRON_PICKAXE
            || item == Items.IRON_AXE
            || item == Items.IRON_SHOVEL
            || item == Items.IRON_HOE;
    }

    // 🔽 Leather (armor only)
    private static boolean isLeather(Item item) {
        return item == Items.LEATHER_HELMET
            || item == Items.LEATHER_CHESTPLATE
            || item == Items.LEATHER_LEGGINGS
            || item == Items.LEATHER_BOOTS;
    }

    // 🔽 Chainmail (armor only)
    private static boolean isChainmail(Item item) {
        return item == Items.CHAINMAIL_HELMET
            || item == Items.CHAINMAIL_CHESTPLATE
            || item == Items.CHAINMAIL_LEGGINGS
            || item == Items.CHAINMAIL_BOOTS;
    }
}
