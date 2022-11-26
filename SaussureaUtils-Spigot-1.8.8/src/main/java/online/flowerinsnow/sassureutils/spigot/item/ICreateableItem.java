package online.flowerinsnow.sassureutils.spigot.item;

import online.flowerinsnow.saussureautils.annotation.DependOf;
import online.flowerinsnow.saussureautils.annotation.Dependency;
import org.bukkit.inventory.ItemStack;

@DependOf(
        @Dependency(
                groupId = "org.spigotmc",
                artifactId = "spigot-api",
                version = "1.8.8-R0.1-SNAPSHOT"
        )
)
public interface ICreateableItem {
    ItemStack create();
    ItemStackBuilder createBuilder();
}
