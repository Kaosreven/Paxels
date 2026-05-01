package com.github.kaosreven.paxels.items;

import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.registry.Registry;
import net.modificationstation.stationapi.api.registry.RegistryKey;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.template.item.TemplateToolItem;
import net.modificationstation.stationapi.api.util.Identifier;

import net.minecraft.item.ToolMaterial;

public class ItemGenericPaxel extends TemplateToolItem {
    private final ToolMaterial Tool_Material;
    public ItemGenericPaxel(Identifier identifier, ToolMaterial material) {
        super(identifier, 3, material, Block.BLOCKS);
        this.setMaxDamage(material.getDurability()*2+1);
        Tool_Material = material;
    }

    @Override
    public boolean isSuitableFor(Block block) {
        RegistryKey<? extends Registry<Block>> BlockRegistryKey = BlockRegistry.INSTANCE.getKey();
        BlockState Block_State = block.getDefaultState();
        switch(Tool_Material) {
            case WOOD:
                if (
                        Block_State.isIn(TagKey.of(BlockRegistryKey, Identifier.of("minecraft:needs_diamond_tool"))) ||
                        Block_State.isIn(TagKey.of(BlockRegistryKey, Identifier.of("minecraft:needs_iron_tool"))) ||
                        Block_State.isIn(TagKey.of(BlockRegistryKey, Identifier.of("minecraft:needs_stone_tool")))
                ) return false;
            case STONE:
            case GOLD:
                if (
                        Block_State.isIn(TagKey.of(BlockRegistryKey, Identifier.of("minecraft:needs_diamond_tool"))) ||
                        Block_State.isIn(TagKey.of(BlockRegistryKey, Identifier.of("minecraft:needs_iron_tool")))
                ) return false;
            case IRON:
                if (
                        Block_State.isIn(TagKey.of(BlockRegistryKey, Identifier.of("minecraft:needs_diamond_tool")))
                ) return false;
            default:
        }
        return true;
    }
}
