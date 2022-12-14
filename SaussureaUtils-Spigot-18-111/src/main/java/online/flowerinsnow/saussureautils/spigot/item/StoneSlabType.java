package online.flowerinsnow.saussureautils.spigot.item;

import online.flowerinsnow.saussureautils.annotation.DependOf;
import online.flowerinsnow.saussureautils.annotation.Dependency;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@DependOf(
        @Dependency(
                groupId = "org.spigotmc",
                artifactId = "spigot-api",
                version = "1.8.8-R0.1-SNAPSHOT",
                minVersion = "1.8.3-R0.1-SNAPSHOT",
                maxVersion = "1.11.2-R0.1-SNAPSHOT"
        )
)
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
