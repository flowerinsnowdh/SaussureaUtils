package online.flowerinsnow.saussureautils.spigot.item;

import online.flowerinsnow.saussureautils.annotation.DependOf;
import online.flowerinsnow.saussureautils.annotation.Dependency;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@DependOf(
        @Dependency(
                groupId = "org.spigotmc",
                artifactId = "spigot-api",
                version = "1.12.2-R0.1-SNAPSHOT"
        )
)
public enum StoneType implements ICreateableItem {
    STONE(0),
    GRANITE(1),
    POLISHED_GRANITE(2),
    DIORITE(3),
    POLISHED_DIORITE(4),
    ANDESITE(5),
    POLISHED_ANDESITE(6);
    public final int id;

    StoneType(int id) {
        this.id = id;
    }

    @Override
    public ItemStack create() {
        return createBuilder().build();
    }

    @Override
    public ItemStackBuilder createBuilder() {
        return new ItemStackBuilder(Material.STONE, 1, (short) id);
    }
}
