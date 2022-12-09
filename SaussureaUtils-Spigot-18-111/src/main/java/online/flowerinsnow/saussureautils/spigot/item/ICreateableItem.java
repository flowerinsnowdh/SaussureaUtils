package online.flowerinsnow.saussureautils.spigot.item;

import online.flowerinsnow.saussureautils.annotation.DependOf;
import online.flowerinsnow.saussureautils.annotation.Dependency;
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
public interface ICreateableItem {
    ItemStack create();
    ItemStackBuilder createBuilder();
}
