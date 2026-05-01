package com.github.kaosreven.paxels.events.init;

import com.github.kaosreven.paxels.items.ItemGenericPaxel;
import com.github.kaosreven.paxels.items.ItemGravititePaxel;
import com.github.kaosreven.paxels.items.ItemHolystonePaxel;
import com.github.kaosreven.paxels.items.ItemZanitePaxel;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class ItemListener {
    @Entrypoint.Namespace
    public static Namespace MOD_ID = Null.get();
    public static Item Wood_Paxel;
    public static Item Stone_Paxel;
    public static Item Iron_Paxel;
    public static Item Gold_Paxel;
    public static Item Diamond_Paxel;
    public static Item Skyroot_Paxel;
    public static Item Holystone_Paxel;
    public static Item Zanite_Paxel;
    public static Item Gravitite_Paxel;
    public static Item Refined_Paxel;
    public static Item Pumpkin_Paxel;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        Wood_Paxel = (new ItemGenericPaxel(Identifier.of(MOD_ID, "wood_paxel"), ToolMaterial.WOOD)).setTranslationKey(MOD_ID, "wood_paxel");
        Stone_Paxel = (new ItemGenericPaxel(Identifier.of(MOD_ID, "stone_paxel"), ToolMaterial.STONE)).setTranslationKey(MOD_ID, "stone_paxel");
        Iron_Paxel = (new ItemGenericPaxel(Identifier.of(MOD_ID, "iron_paxel"), ToolMaterial.IRON)).setTranslationKey(MOD_ID, "iron_paxel");
        Gold_Paxel = (new ItemGenericPaxel(Identifier.of(MOD_ID, "gold_paxel"), ToolMaterial.GOLD)).setTranslationKey(MOD_ID, "gold_paxel");
        Diamond_Paxel = (new ItemGenericPaxel(Identifier.of(MOD_ID, "diamond_paxel"), ToolMaterial.DIAMOND)).setTranslationKey(MOD_ID, "diamond_paxel");
        if (FabricLoader.getInstance().isModLoaded("aether")) {
            Skyroot_Paxel = (new ItemGenericPaxel(Identifier.of(MOD_ID, "skyroot_paxel"), ToolMaterial.WOOD)).setTranslationKey(MOD_ID, "skyroot_paxel");
            Holystone_Paxel = (new ItemHolystonePaxel(Identifier.of(MOD_ID, "holystone_paxel"), ToolMaterial.STONE)).setTranslationKey(MOD_ID, "holystone_paxel");
            Zanite_Paxel = (new ItemZanitePaxel(Identifier.of(MOD_ID, "zanite_paxel"), ToolMaterial.IRON)).setTranslationKey(MOD_ID, "zanite_paxel");
            Gravitite_Paxel = (new ItemGravititePaxel(Identifier.of(MOD_ID, "gravitite_paxel"), ToolMaterial.DIAMOND)).setTranslationKey(MOD_ID, "gravitite_paxel");
        }
    }
}
