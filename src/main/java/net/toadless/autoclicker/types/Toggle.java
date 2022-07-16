package net.toadless.autoclicker.types;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public enum Toggle
{
    F1("F1"),
    F2("F2"),
    F3("F3"),
    F4("F4"),
    F5("F5"),
    F6("F6"),
    F7("F7"),
    F8("F8"),
    F9("F9"),
    F10("F10"),
    F11("F11"),
    F12("F12");



    private final String value;

    Toggle(String value)
    {
     this.value = value;
    }

    public String getValue()
    {
        return this.value;
    }

    public int getKeyCode()
    {
        return KeyStroke.getKeyStroke(value).getKeyCode();
    }



    public static Toggle[] getToggles()
    {
        return Toggle.class.getEnumConstants();
    }

    public static String[] getValues()
    {
        final List<String> values = new LinkedList<>();

        for (Toggle toggle : getToggles())
        {
            values.add(toggle.getValue());
        }

        return values.toArray(new String[0]);
    }
}