package com.github.kaosreven.paxels.items;

import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.template.item.TemplateToolItem;
import net.modificationstation.stationapi.api.util.Identifier;

import net.minecraft.item.ToolMaterial;

public class ItemGenericPaxel extends TemplateToolItem {
    private String MaterialTagToCheckAgainst;
    public ItemGenericPaxel(Identifier identifier, ToolMaterial material) {
        super(identifier, 3, material, Block.BLOCKS);
        this.setMaxDamage(material.getDurability()*2+1);
        switch (material) {
            case WOOD: MaterialTagToCheckAgainst = "minecraft:needs_stone_tool"; break;
            case STONE:
            case GOLD:
                MaterialTagToCheckAgainst = "minecraft:needs_iron_tool"; break;
            case IRON: MaterialTagToCheckAgainst = "minecraft:needs_diamond_tool"; break;
        }
    }

    @Override
    public boolean isSuitableFor(Block block) {
        if (MaterialTagToCheckAgainst == null) return true;
        else if (block.getDefaultState().isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("minecraft:needs_diamond_tool")))) return false;
        else return true;
    }
}
