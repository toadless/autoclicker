package net.toadless.autoclicker;

import net.toadless.autoclicker.types.Unit;
import net.toadless.autoclicker.utilitys.PopupUtility;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Parser
{
    private Parser() {}

    private static int getIntFromTextComponent(AutoClicker autoClicker, Component component)
    {
        try
        {
            int value = Integer.parseInt(((JTextField) autoClicker.getAllComponents().get(component)).getText());

            if (value <= 0)
            {
                PopupUtility.showMessage(
                        autoClicker.getPanel(),
                        JOptionPane.WARNING_MESSAGE,
                        "You must provide an integer bigger than 0.");

                return -1;
            }

            return value;
        } catch (NumberFormatException exception)
        {
            PopupUtility.showMessage(
                    autoClicker.getPanel(),
                    JOptionPane.WARNING_MESSAGE,
                    "You must provide an integer value as your " + component.name().toLowerCase() + ".");

            return -1;
        }
    }

    public static long convertIntToMillis(AutoClicker autoClicker, Component component)
    {
        final int initialValue = getIntFromTextComponent(autoClicker, component);

        if (initialValue == -1)
        {
            return initialValue;
        }

        final int unitIndex = ((JComboBox<?>) autoClicker.getAllComponents().get(Component.UNIT)).getSelectedIndex();
        final Unit unit = Unit.getUnits()[unitIndex];

        return TimeUnit.MILLISECONDS.convert(initialValue, unit.getTimeUnit());
    }
}