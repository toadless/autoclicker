package net.toadless.autoclicker.utilitys;

import net.toadless.autoclicker.AutoClicker;

import javax.swing.*;

public class PopupUtility
{
    private PopupUtility() {}

    public static void showMessage(JPanel panel, int messageType, String error)
    {
        JOptionPane.showMessageDialog(
                panel,
                error,
                AutoClicker.NAME,
                messageType
        );
    }


}