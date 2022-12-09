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
public enum WoodType {
    OAK(0),
    SPRUCE(1),
    BIRCH(2),
    JUNGLE(3),
    ACACIA(4),
    DARK_OAK(5);
    public final int id;

    WoodType(int id) {
        this.id = id;
    }

    public ItemStack createItemStack(Material material) {
        return createItemStackBuilder(material).build();
    }

    public ItemStackBuilder createItemStackBuilder(Material material) {
        switch (material) {
            case WOOD:
            case WOOD_STEP:
                return new ItemStackBuilder(material, 1, (short) id);
            case LOG:
            case LOG_2:
                return id < 4 ?
                        new ItemStackBuilder(Material.LOG, 1, (short) id) :
                        new ItemStackBuilder(Material.LOG_2, 1, (short) (id - 4));
            default:
                throw new IllegalArgumentException(material.name() + " does not have wood meta.");
        }
    }
}
