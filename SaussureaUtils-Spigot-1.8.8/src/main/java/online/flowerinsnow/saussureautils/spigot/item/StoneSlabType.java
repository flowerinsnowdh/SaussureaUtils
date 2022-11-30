package online.flowerinsnow.saussureautils.spigot.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum StoneSlabType implements ICreateableItem {
    STONE(0),
    SANDSTONE(1),
    RED_SANDSTONE(2),
    COBBLESTONE(3),
    BRICK(4),
    STONE_BRICK(5),
    NETHER_BRICK(6),
    QUARTZ(7);
    public final int id;

    StoneSlabType(int id) {
        this.id = id;
    }

    @Override
    public ItemStack create() {
        return createBuilder().build();
    }

    @Override
    public ItemStackBuilder createBuilder() {
        if (id == 2) {
            return new ItemStackBuilder(Material.STONE_SLAB2, 1, (short) id);
        } else {
            return new ItemStackBuilder(Material.STEP, 1, (short) id);
        }
    }
}
