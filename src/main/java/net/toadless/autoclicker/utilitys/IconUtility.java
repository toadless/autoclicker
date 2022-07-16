package net.toadless.autoclicker.utilitys;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IconUtility
{
    private static final String ICON_LOCATION = "/assets/icon.png";

    public static final Image ICON_IMAGE = getScaledIcon(120, 120);
    public static final Image TRAY_IMAGE = getScaledIcon(16, 16);
    public static final Image POPUP_IMAGE = getScaledIcon(70, 70);

    private IconUtility() {}

    private static ImageIcon getIcon()
    {
        return new ImageIcon(IconUtility.class.getResource(ICON_LOCATION));
    }

    private static Image getScaledImage(Image img, int width, int height)
    {
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, width, height, null);
        g2.dispose();

        return resizedImg;
    }

    private static Image getScaledIcon(int width, int height)
    {
        return getScaledImage(getIcon().getImage(), width, height);
    }
}