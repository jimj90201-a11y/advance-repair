package com.example.advancerepair;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("advancerepair")
public class AdvanceRepairMod {

public AdvanceRepairMod() {
    MinecraftForge.EVENT_BUS.register(AnvilHandler.class);
    MinecraftForge.EVENT_BUS.register(TooltipHandler.class);
} 
}
