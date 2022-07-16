package net.toadless.autoclicker.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JTextFieldFocusListener implements FocusListener
{
    private final JTextField textField;
    private final String unfocusText;

    private JTextFieldFocusListener(JTextField textField, String unfocusText)
    {
        this.textField = textField;
        this.unfocusText = unfocusText;
    }

    public static JTextField getNewTextField(String defaultText, int columns)
    {
        final JTextField newTextField = new JTextField(defaultText, columns);
        newTextField.addFocusListener(new JTextFieldFocusListener(newTextField, defaultText));
        newTextField.setForeground(Color.GRAY);
        return newTextField;
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        if (textField.getText().equals(unfocusText))
        {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e)
    {
        if (textField.getText().isEmpty())
        {
            textField.setText(unfocusText);
            textField.setForeground(Color.GRAY);
        }
    }
}