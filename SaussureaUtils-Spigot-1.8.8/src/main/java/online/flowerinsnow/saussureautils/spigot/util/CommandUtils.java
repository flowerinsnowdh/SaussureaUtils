package online.flowerinsnow.saussureautils.spigot.util;

import online.flowerinsnow.saussureautils.SaussureUtils;
import online.flowerinsnow.saussureautils.annotation.DependOf;
import online.flowerinsnow.saussureautils.annotation.Dependency;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

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
                        version = "1.8.8-R0.1-SNAPSHOT"
                )
        }
)
public final class CommandUtils {
    private CommandUtils() {
    }

    private static String NO_PERMISSION_MESSAGE = "§c您没有权限这么做";
    private static String MUST_BE_PLAYER_MESSAGE = "§c您必须是一名玩家才能这么做";

    /**
     * 检查命令发送者是否拥有权限
     *
     * @param sender 命令发送者
     * @param permission 权限
     * @return 若是，返回该发送者，否则发送错误消息并返回空
     */
    public static Optional<CommandSender> checkPermission(CommandSender sender, String permission) {
        if (sender.hasPermission(permission)) {
            return Optional.of(sender);
        } else {
            sender.sendMessage(NO_PERMISSION_MESSAGE);
            return Optional.empty();
        }
    }

    /**
     * 检查命令发送者是否是玩家
     *
     * @param sender 命令发送者
     * @return 若是，返回该玩家，否则发送错误消息并返回空
     */
    public static Optional<Player> checkPlayer(CommandSender sender) {
        if (sender instanceof Player) {
            return Optional.of((Player) sender);
        } else {
            sender.sendMessage(MUST_BE_PLAYER_MESSAGE);
            return Optional.empty();
        }
    }

    /**
     * 检查命令发送者是否拥有权限并且是玩家
     *
     * @param sender 命令发送者
     * @param permission 权限
     * @return 若是，返回该玩家，否则发送错误消息并返回空
     */
    public static Optional<Player> checkPermissionAndPlayer(CommandSender sender, String permission) {
        if (!sender.hasPermission(permission)) {
            sender.sendMessage(NO_PERMISSION_MESSAGE);
            return Optional.empty();
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(MUST_BE_PLAYER_MESSAGE);
            return Optional.empty();
        }
        return Optional.of((Player) sender);
    }

    /**
     * 设置检查到发送者没有权限时发送的消息
     *
     * @param noPermissionMessage 没有权限时发送的消息
     */
    public static void setNoPermissionMessage(String noPermissionMessage) {
        NO_PERMISSION_MESSAGE = MessageUtils.parseColor(noPermissionMessage);
    }

    /**
     * 玩家不是玩家但要求是玩家时发送的消息
     *
     * @param mustBePlayerMessage 玩家不是玩家但要求是玩家时发送的消息
     */
    public static void setMustBePlayerMessage(String mustBePlayerMessage) {
        MUST_BE_PLAYER_MESSAGE = MessageUtils.parseColor(mustBePlayerMessage);
    }

    /**
     * 适合用作TAB补全时，筛选出试图补全的子命令
     * 例如
     *      filterSubcommands("he", "help", "test", "heal")
     * 则会返回["help", "heal"]
     *
     * @param input 输入内容
     * @param subcommands 子命令
     * @return 筛选后的子命令
     */
    public static List<String> filterSubcommands(String input, String... subcommands) {
        return filterSubcommands(input, new ArrayList<>(Arrays.asList(subcommands)));
    }

    /**
     * 适合用作TAB补全时，筛选出试图补全的子命令
     * 例如
     *      filterSubcommands("he", new ArrayList(Arrays.asList("help", "test", "heal")))
     * 则会返回["help", "heal"]
     *
     * @param input 输入内容
     * @param subcommands 子命令
     * @return 筛选后的子命令
     */
    public static List<String> filterSubcommands(String input, List<String> subcommands) {
        subcommands.removeIf(s -> !s.toLowerCase().startsWith(input.toLowerCase()));
        return subcommands;
    }

    /**
     * 适合用作TAB补全时，筛选出试图补全的玩家
     * 例如现在在线3个玩家 ["zhang1", "zhang2", "li4"]
     *      filterPlayers("zhan");
     * 就会返回["zhang1", "zhang2"]
     *
     * @param input 输入内容
     * @return 筛选出的在线的玩家
     */
    public static List<String> filterPlayers(String input) {
        return Bukkit.getOnlinePlayers().stream().collect(
                ArrayList::new,
                (list, pl) -> {
                    if (pl.getName().toLowerCase().startsWith(input.toLowerCase())) {
                        list.add(pl.getName());
                    }
                },
                ArrayList::addAll
        );
    }

    /**
     * 适合用作TAB补全时，筛选出试图补全的玩家，并且要求该玩家没有隐藏目标才能进行补全
     * 隐藏：是指调用了player.hidePlayer(Player)后
     * 例如现在在线3个玩家 ["zhang1", "zhang2", "li4"]，但是发送者看不见zhang2
     *      filterPlayers("zhan");
     * 就会返回["zhang1"]
     *
     * @param input 输入内容
     * @return 筛选出的在线的且未被隐藏的玩家
     */
    public static List<String> filterPlayersIgnoreHidden(String input, Player player) {
        return Bukkit.getOnlinePlayers().stream().collect(
                ArrayList::new,
                (list, pl) -> {
                    if (pl.getName().toLowerCase().startsWith(input.toLowerCase()) && player.canSee(pl)) {
                        list.add(pl.getName());
                    }
                },
                ArrayList::addAll
        );
    }
}
