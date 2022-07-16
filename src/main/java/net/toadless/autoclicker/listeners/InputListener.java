package net.toadless.autoclicker.listeners;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import net.toadless.autoclicker.AutoClicker;
import net.toadless.autoclicker.Clicker;
import net.toadless.autoclicker.Component;
import net.toadless.autoclicker.Parser;
import net.toadless.autoclicker.types.Toggle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class InputListener implements NativeKeyListener
{
    private static final Logger LOGGER = LoggerFactory.getLogger(InputListener.class);

    private final AutoClicker autoClicker;

    public InputListener(AutoClicker autoClicker)
    {
        this.autoClicker = autoClicker;
    }

    public void nativeKeyPressed(NativeKeyEvent event)
    {
        final Toggle toggle = Toggle.getToggles()[((JComboBox<?>) this.autoClicker.getAllComponents().get(Component.TOGGLE)).getSelectedIndex()];

        if (event.getRawCode() == toggle.getKeyCode())
        {
            if (!sanitizeInputs()) return;

            final Clicker clicker = this.autoClicker.getClicker();

            if (!clicker.isRunning())
            {
                LOGGER.info("Toggling on AutoClicker.");

                clicker.start();
                return;
            }

            LOGGER.info("Toggling off AutoClicker.");

            clicker.stop();
        }
    }

    public boolean sanitizeInputs()
    {
        long clickInterval = Parser.convertIntToMillis(autoClicker, Component.INTERVAL);
        if (clickInterval == -1) return false;

        long clickDuration = Parser.convertIntToMillis(autoClicker, Component.DURATION);
        if (clickDuration == -1) return false;

        return true;
    }
}