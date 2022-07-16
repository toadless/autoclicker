package net.toadless.autoclicker.utilitys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class TrayUtility
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TrayUtility.class);

    private TrayUtility() {}

    public static void createNewSystemTray(java.util.List<MenuItem> menuItems)
    {
        final SystemTray systemTray = SystemTray.getSystemTray();
        final TrayIcon trayIcon = new TrayIcon(IconUtility.TRAY_IMAGE);
        final PopupMenu popupMenu = new PopupMenu();

        for (MenuItem menuItem : menuItems)
        {
            popupMenu.add(menuItem);
        }

        trayIcon.setPopupMenu(popupMenu);

        try
        {
            systemTray.add(trayIcon);
        } catch (AWTException e)
        {
            LOGGER.warn("Unable to add icon to system tray.");
        }
    }
}
