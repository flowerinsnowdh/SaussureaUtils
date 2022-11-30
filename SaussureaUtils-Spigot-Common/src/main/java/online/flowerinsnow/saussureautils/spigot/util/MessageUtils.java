package online.flowerinsnow.saussureautils.spigot.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MessageUtils {
    public static String parseColor(String message) {
        if (message != null) {
            return message.replace("&", "§").replace("§§", "&");
        }
        return null;
    }

    public static List<String> parseColor(Collection<String> messages) {
        return messages.stream().collect(ArrayList::new, (list, str) -> list.add(parseColor(str)), ArrayList::addAll);
    }
}
