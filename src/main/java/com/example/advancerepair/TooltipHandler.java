package com.example.advancerepair;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class TooltipHandler {

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {

        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();

        // 🟥 Netherite
        if (isNetherite(stack)) {
            tooltip.add(Component.literal("Repair with Diamond: 80%").withStyle(ChatFormatting.GREEN));
            tooltip.add(Component.literal("Repair with Iron: 50%").withStyle(ChatFormatting.YELLOW));
            tooltip.add(Component.literal("Repair with Gold: 40%").withStyle(ChatFormatting.GOLD));
        }

        // 🟦 Diamond
        if (isDiamond(stack)) {
            tooltip.add(Component.literal("Repair with Iron: 60%").withStyle(ChatFormatting.YELLOW));
            tooltip.add(Component.literal("Repair with Gold: 45%").withStyle(ChatFormatting.GOLD));
        }

        // ⚙️ Iron
        if (isIron(stack)) {
            tooltip.add(Component.literal("Repair with Gold: 70%").withStyle(ChatFormatting.GOLD));
        }

        // 🟤 Leather
        if (isLeather(stack)) {
            tooltip.add(Component.literal("Repair with Leather: 100%").withStyle(ChatFormatting.GREEN));
        }

        // ⛓️ Chainmail
        if (isChainmail(stack)) {
            tooltip.add(Component.literal("Repair with Chain: 60%").withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.literal("Repair with Iron: 50%").withStyle(ChatFormatting.YELLOW));
        }

        // XP info
        tooltip.add(Component.literal("XP Cost: 10–20 levels").withStyle(ChatFormatting.DARK_PURPLE));
    }

    private static boolean isNetherite(ItemStack stack) {
        return stack.is(Items.NETHERITE_HELMET)
            || stack.is(Items.NETHERITE_CHESTPLATE)
            || stack.is(Items.NETHERITE_LEGGINGS)
            || stack.is(Items.NETHERITE_BOOTS)
            || stack.is(Items.NETHERITE_SWORD)
            || stack.is(Items.NETHERITE_PICKAXE)
            || stack.is(Items.NETHERITE_AXE)
            || stack.is(Items.NETHERITE_SHOVEL)
            || stack.is(Items.NETHERITE_HOE);
    }

    private static boolean isDiamond(ItemStack stack) {
        return stack.is(Items.DIAMOND_HELMET)
            || stack.is(Items.DIAMOND_CHESTPLATE)
            || stack.is(Items.DIAMOND_LEGGINGS)
            || stack.is(Items.DIAMOND_BOOTS)
            || stack.is(Items.DIAMOND_SWORD)
            || stack.is(Items.DIAMOND_PICKAXE)
            || stack.is(Items.DIAMOND_AXE)
            || stack.is(Items.DIAMOND_SHOVEL)
            || stack.is(Items.DIAMOND_HOE);
    }

    private static boolean isIron(ItemStack stack) {
        return stack.is(Items.IRON_HELMET)
            || stack.is(Items.IRON_CHESTPLATE)
            || stack.is(Items.IRON_LEGGINGS)
            || stack.is(Items.IRON_BOOTS)
            || stack.is(Items.IRON_SWORD)
            || stack.is(Items.IRON_PICKAXE)
            || stack.is(Items.IRON_AXE)
            || stack.is(Items.IRON_SHOVEL)
            || stack.is(Items.IRON_HOE);
    }

    private static boolean isLeather(ItemStack stack) {
        return stack.is(Items.LEATHER_HELMET)
            || stack.is(Items.LEATHER_CHESTPLATE)
            || stack.is(Items.LEATHER_LEGGINGS)
            || stack.is(Items.LEATHER_BOOTS);
    }

    private static boolean isChainmail(ItemStack stack) {
        return stack.is(Items.CHAINMAIL_HELMET)
            || stack.is(Items.CHAINMAIL_CHESTPLATE)
            || stack.is(Items.CHAINMAIL_LEGGINGS)
            || stack.is(Items.CHAINMAIL_BOOTS);
    }
}
