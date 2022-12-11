package online.flowerinsnow.saussureautils.spigot.item;

import online.flowerinsnow.saussureautils.SaussureUtils;
import online.flowerinsnow.saussureautils.annotation.DependOf;
import online.flowerinsnow.saussureautils.annotation.Dependency;
import online.flowerinsnow.saussureautils.spigot.util.MessageUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@DependOf(
        {
                @Dependency(
                        groupId = "online.flowerinsnow",
                        artifactId = "SaussureaUtils-Spigot-Common",
                        version = SaussureUtils.VERSION
                ),
                @Dependency(
                        groupId = "org.spigotmc",
                        artifactId = "spigot-api",
                        version = "1.12.2-R0.1-SNAPSHOT"
                )
        }
)
public class ItemStackBuilder {
    private final ItemStack stack;
    public ItemStackBuilder(Material type) {
        stack = new ItemStack(type);
    }

    public ItemStackBuilder(Material type, int amount) {
        stack = new ItemStack(type, amount);
    }

    public ItemStackBuilder(Material type, int amount, short damage) {
        stack = new ItemStack(type, amount, damage);
    }

    public ItemStackBuilder(ItemStack stack) {
        this.stack = new ItemStack(stack);
    }

    public ItemStackBuilder setType(Material type) {
        this.stack.setType(type);
        return this;
    }

    public ItemStackBuilder setAmount(int amount) {
        this.stack.setAmount(amount);
        return this;
    }

    public ItemStackBuilder setData(MaterialData data) {
        this.stack.setData(data);
        return this;
    }

    public ItemStackBuilder setDurability(short durability) {
        this.stack.setDurability(durability);
        return this;
    }

    public ItemStackBuilder setDisplayName(String displayName) {
        metaOperation(meta -> meta.setDisplayName(MessageUtils.parseColour(displayName)));
        return this;
    }

    public ItemStackBuilder setLore(List<String> lore) {
        metaOperation(meta -> meta.setLore(MessageUtils.parseColour(lore)));
        return this;
    }

    public ItemStackBuilder addLore(String lore) {
        metaOperation(meta -> {
            List<String> list = meta.getLore();
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(MessageUtils.parseColour(lore));
            meta.setLore(list);
        });
        return this;
    }

    public ItemStackBuilder addEnchant(Enchantment enchantment, int level, boolean ignoreRestrictions) {
        metaOperation(meta -> meta.addEnchant(enchantment, level, ignoreRestrictions));
        return this;
    }

    public ItemStackBuilder removeEnchant(Enchantment enchantment) {
        metaOperation(meta -> meta.removeEnchant(enchantment));
        return this;
    }

    public ItemStackBuilder addItemFlags(ItemFlag... flags) {
        metaOperation(meta -> meta.addItemFlags(flags));
        return this;
    }

    public ItemStackBuilder removeItemFlags(ItemFlag... flags) {
        metaOperation(meta -> meta.removeItemFlags(flags));
        return this;
    }

    public ItemStackBuilder setUnbreakable(boolean unbreakable) {
        metaOperation(meta -> meta.setUnbreakable(unbreakable));
        return this;
    }

    public ItemStackBuilder unbreakable() {
        return setUnbreakable(true);
    }

    public ItemStack build() {
        return stack.clone();
    }

    private void metaOperation(Consumer<ItemMeta> action) {
        ItemMeta meta = stack.getItemMeta();
        action.accept(meta);
        stack.setItemMeta(meta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemStackBuilder that = (ItemStackBuilder) o;
        return stack.equals(that.stack);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + stack.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ItemStackBuilder{" +
                "stack=" + stack +
                '}';
    }
}
