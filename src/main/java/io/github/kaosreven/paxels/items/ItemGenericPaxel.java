package io.github.kaosreven.paxels.items;

import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.template.item.TemplateToolItem;
import net.modificationstation.stationapi.api.util.Identifier;

import net.minecraft.item.ToolMaterial;

public class ItemGenericPaxel extends TemplateToolItem {
    private final ToolMaterial toolMaterial;
    public ItemGenericPaxel(Identifier identifier, ToolMaterial material) {
        super(identifier, 3, material, Block.BLOCKS);
        this.setMaxDamage(material.getDurability()*2+1);
        toolMaterial = material;
    }

    @Override
    public boolean isSuitableFor(Block block) {
        BlockState blockState = block.getDefaultState();
        TagKey<Block> diamondToolNeeded = TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("minecraft:needs_diamond_tool"));
        TagKey<Block> ironToolNeeded = TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("minecraft:needs_iron_tool"));
        TagKey<Block> stoneToolNeeded = TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("minecraft:needs_stone_tool"));
        switch(toolMaterial) {
            case WOOD:
                if (
                        blockState.isIn(diamondToolNeeded) ||
                        blockState.isIn(ironToolNeeded) ||
                        blockState.isIn(stoneToolNeeded)
                ) return false;
            case STONE:
            case GOLD:
                if (
                        blockState.isIn(diamondToolNeeded) ||
                        blockState.isIn(ironToolNeeded)
                ) return false;
            case IRON:
                if (
                        blockState.isIn(diamondToolNeeded)
                ) return false;
            default:
        }
        return true;
    }
}
