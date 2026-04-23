package com.github.kaosreven.paxels.events.init;

import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import com.matthewperiut.aether.item.AetherItems;

import java.util.Objects;

public class RecipeListener {
    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        RecipeRegisterEvent.Vanilla type = RecipeRegisterEvent.Vanilla.fromType(event.recipeId);
        switch (Objects.requireNonNull(type)) {
            case CRAFTING_SHAPED -> {
                CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.Wood_Paxel, 1), "ABC", " Y ", " Y ", 'A', Item.WOODEN_AXE, 'B', Item.WOODEN_PICKAXE, 'C', Item.WOODEN_SHOVEL, 'Y', Item.STICK);
                CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.Stone_Paxel, 1), "ABC", " Y ", " Y ", 'A', Item.STONE_AXE, 'B', Item.STONE_PICKAXE, 'C', Item.STONE_SHOVEL, 'Y', Item.STICK);
                CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.Iron_Paxel, 1), "ABC", " Y ", " Y ", 'A', Item.IRON_AXE, 'B', Item.IRON_PICKAXE, 'C', Item.IRON_SHOVEL, 'Y', Item.STICK);
                CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.Gold_Paxel, 1), "ABC", " Y ", " Y ", 'A', Item.GOLDEN_AXE, 'B', Item.GOLDEN_PICKAXE, 'C', Item.GOLDEN_SHOVEL, 'Y', Item.STICK);
                CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.Diamond_Paxel, 1), "ABC", " Y ", " Y ", 'A', Item.DIAMOND_AXE, 'B', Item.DIAMOND_PICKAXE, 'C', Item.DIAMOND_SHOVEL, 'Y', Item.STICK);
                if (FabricLoader.getInstance().isModLoaded("aether")) {
                    CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.Skyroot_Paxel, 1), "ABC", " Y ", " Y ", 'A', AetherItems.AxeSkyroot, 'B', AetherItems.PickSkyroot, 'C', AetherItems.ShovelSkyroot, 'Y', AetherItems.Stick);
                    CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.Holystone_Paxel, 1), "ABC", " Y ", " Y ", 'A', AetherItems.AxeHolystone, 'B', AetherItems.PickHolystone, 'C', AetherItems.ShovelHolystone, 'Y', AetherItems.Stick);
                    CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.Zanite_Paxel, 1), "ABC", " Y ", " Y ", 'A', AetherItems.AxeZanite, 'B', AetherItems.PickZanite, 'C', AetherItems.ShovelZanite, 'Y', AetherItems.Stick);
                    CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.Gravitite_Paxel, 1), "ABC", " Y ", " Y ", 'A', AetherItems.AxeGravitite, 'B', AetherItems.PickGravitite, 'C', AetherItems.ShovelGravitite, 'Y', AetherItems.Stick);
                }
            }
        }
    }
}
