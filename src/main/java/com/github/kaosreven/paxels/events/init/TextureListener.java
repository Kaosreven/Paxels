package com.github.kaosreven.paxels.events.init;

import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import static net.modificationstation.stationapi.api.util.Identifier.of;
import static com.github.kaosreven.paxels.events.init.ItemListener.MOD_ID;


public class TextureListener {
    @EventListener
    public static void registerTextures(TextureRegisterEvent event) {
        setItemTextures();
    }
    public static void setItemTextures() {
        ItemListener.Wood_Paxel.setTexture(of(MOD_ID, "item/Wood_Paxel"));
        ItemListener.Stone_Paxel.setTexture(of(MOD_ID, "item/Stone_Paxel"));
        ItemListener.Iron_Paxel.setTexture(of(MOD_ID, "item/Iron_Paxel"));
        ItemListener.Gold_Paxel.setTexture(of(MOD_ID, "item/Gold_Paxel"));
        ItemListener.Diamond_Paxel.setTexture(of(MOD_ID, "item/Diamond_Paxel"));
        if (FabricLoader.getInstance().isModLoaded("aether")) {
            ItemListener.Skyroot_Paxel.setTexture(of(MOD_ID, "item/Aether/Skyroot_Paxel"));
            ItemListener.Holystone_Paxel.setTexture(of(MOD_ID, "item/Aether/Holystone_Paxel"));
            ItemListener.Zanite_Paxel.setTexture(of(MOD_ID, "item/Aether/Zanite_Paxel"));
            ItemListener.Gravitite_Paxel.setTexture(of(MOD_ID, "item/Aether/Gravitite_Paxel"));
        }
    }
}