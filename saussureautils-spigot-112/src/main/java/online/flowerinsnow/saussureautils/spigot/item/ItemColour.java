package online.flowerinsnow.saussureautils.spigot.item;

import online.flowerinsnow.saussureautils.annotation.DependOf;
import online.flowerinsnow.saussureautils.annotation.Dependency;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

@DependOf(
        @Dependency(
                groupId = "org.spigotmc",
                artifactId = "spigot-api",
                version = "1.12.2-R0.1-SNAPSHOT"
        )
)
public enum ItemColour {
    WHITE(0),
    ORANGE(1),
    MAGENTA(2),
    LIGHT_BLUE(3),
    YELLOW(4),
    LIGHT_GREEN(5),
    PINK(6),
    GREY(7),
    LIGHT_GREY(8),
    CYAN(9),
    PURPLE(10),
    BLUE(11),
    BROWN(12),
    GREEN(13),
    RED(14),
    BLACK(15);
    public final int id;

    ItemColour(int id) {
        this.id = id;
    }

    /**
     * 使用当前颜色创建ItemStack
     *
     * @param material 物品类型
     * @return 创建好的ItemStack
     */
    public ItemStack createItemStack(Material material) {
        Objects.requireNonNull(material);
        return createItemStackBuilder(material).build();
    }

    /**
     * 使用当前颜色创建ItemStackBuilder
     *
     * @param material 物品类型
     * @return 创建好的ItemStackBuilder
     */
    public ItemStackBuilder createItemStackBuilder(Material material) {
        Objects.requireNonNull(material);
        switch (material) {
            case WOOL:
            case STAINED_GLASS:
            case STAINED_CLAY:
            case STAINED_GLASS_PANE:
            case CARPET:
                return new ItemStackBuilder(material, 1, (short) id);
            case BANNER:
            case INK_SACK:
                return new ItemStackBuilder(material, 1, (short) (15 - id));
            default:
                throw new IllegalArgumentException(material.name() + " does not have colour meta.");
        }
    }
}
