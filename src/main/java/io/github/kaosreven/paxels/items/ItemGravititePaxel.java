package io.github.kaosreven.paxels.items;

import com.matthewperiut.aether.entity.special.EntityFloatingBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.util.Identifier;

public class ItemGravititePaxel extends ItemGenericPaxel {
    public ItemGravititePaxel(Identifier identifier, ToolMaterial material) {
        super(identifier, material);
    }

    @Override
    public boolean useOnBlock(ItemStack item, PlayerEntity player, World world, int x, int y, int z, int side) {
        if (!world.isRemote) {
            BlockState b = world.getBlockState(x, y, z);
            if (b.getHardness(world, new BlockPos(x,y,z)) > -1 && (
                b.isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("minecraft:mineable/pickaxe"))) ||
                b.isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("minecraft:mineable/axe"))) ||
                b.isIn(TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("minecraft:mineable/shovel")))
            ))  {
                if (b.getBlock() != Block.SPAWNER) {
                    final int metadata = world.getBlockMeta(x, y, z);
                    world.spawnEntity(new EntityFloatingBlock(world, x + 0.5f, y + 0.5f, z + 0.5f, b.getBlock().id, metadata));
                    item.damage(1, player);
                }
            }
            return super.useOnBlock(item, player, world, x, y, z, side);
        }
        return false;
    }
}
