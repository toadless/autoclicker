package net.toadless.autoclicker;

import net.toadless.autoclicker.types.Click;
import net.toadless.autoclicker.types.ClickType;

import javax.swing.*;
import java.awt.*;

public class Clicker implements Runnable
{
    private final AutoClicker autoClicker;
    private final Robot robot;

    private Thread thread;
    private boolean running = false;

    public Clicker(AutoClicker autoClicker) throws AWTException
    {
        this.autoClicker = autoClicker;
        this.robot = new Robot();
    }

    public void start()
    {
        if (thread == null || !thread.isAlive())
        {
            thread = new Thread(this);
        }

        running = true;
        thread.start();
    }

    public void stop()
    {
        running = false;
    }

    @Override
    public void run()
    {
        long lastClick = System.currentTimeMillis();
        long clickInterval = Parser.convertIntToMillis(autoClicker, Component.INTERVAL);

        while (running)
        {
            long now = System.currentTimeMillis();
            boolean shouldClick = now >= lastClick + clickInterval;

            if (shouldClick)
            {
                lastClick = now;
                click();
            }
        }
    }

    public void click()
    {
        long clickTime = System.currentTimeMillis();
        long clickDuration = Parser.convertIntToMillis(autoClicker, Component.DURATION);

        final Click clickToRelease = hold();
        boolean needToRelease = true;

        while (needToRelease)
        {
            long now = System.currentTimeMillis();
            boolean shouldRelease = now >= clickTime + clickDuration;

            if (shouldRelease)
            {
                needToRelease = false;
                release(clickToRelease);
            }
        }
    }

    public boolean isRunning()
    {
        return running;
    }

    public Click hold()
    {
        final Click click = Click.getClicks()[((JComboBox<?>) autoClicker.getAllComponents().get(Component.CLICK)).getSelectedIndex()];

        if (click.getClickType() == ClickType.KEYBOARD)
        {
            robot.keyPress(click.getEvent());
        }

        if (click.getClickType() == ClickType.MOUSE)
        {
            robot.mousePress(click.getEvent());
        }

        return click;
    }

    public void release(Click click)
    {
        if (click.getClickType() == ClickType.KEYBOARD)
        {
            robot.keyRelease(click.getEvent());
        }

        if (click.getClickType() == ClickType.MOUSE)
        {
            robot.mouseRelease(click.getEvent());
        }
    }
}