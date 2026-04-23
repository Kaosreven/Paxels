package com.github.kaosreven.paxels.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemZanitePaxel extends ItemGenericPaxel {
    public ItemZanitePaxel(Identifier identifier, ToolMaterial material) {
        super(identifier, material);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack itemstack, Block block) {
        return super.getMiningSpeedMultiplier(itemstack, block) * (2.0F * (float) itemstack.getDamage() / (float) itemstack.getItem().getMaxDamage() + 0.5F);
    }
}
