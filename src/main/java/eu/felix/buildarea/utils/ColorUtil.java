package eu.felix.buildarea.utils;

import org.bukkit.ChatColor;

public final class ColorUtil {

    public static String translate(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}