package com.github.kaosreven.paxels.events.init;

import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemStack;
import paulevs.bhcreative.api.CreativeTab;
import paulevs.bhcreative.api.SimpleTab;
import paulevs.bhcreative.registry.TabRegistryEvent;
import static com.github.kaosreven.paxels.events.init.ItemListener.MOD_ID;

public class CreativeListener {
    public static CreativeTab Paxels;

    @EventListener
    public void onTabInit(TabRegistryEvent event){
        Paxels = new SimpleTab(MOD_ID.id("paxels"), ItemListener.Iron_Paxel);
        event.register(Paxels);
        Paxels.addItem(new ItemStack(ItemListener.Wood_Paxel, 1));
        Paxels.addItem(new ItemStack(ItemListener.Stone_Paxel, 1));
        Paxels.addItem(new ItemStack(ItemListener.Iron_Paxel, 1));
        Paxels.addItem(new ItemStack(ItemListener.Gold_Paxel, 1));
        Paxels.addItem(new ItemStack(ItemListener.Diamond_Paxel, 1));
        if (FabricLoader.getInstance().isModLoaded("aether")) {
            Paxels.addItem(new ItemStack(ItemListener.Skyroot_Paxel, 1));
            Paxels.addItem(new ItemStack(ItemListener.Holystone_Paxel, 1));
            Paxels.addItem(new ItemStack(ItemListener.Zanite_Paxel, 1));
            Paxels.addItem(new ItemStack(ItemListener.Gravitite_Paxel, 1));
        }
    }
}