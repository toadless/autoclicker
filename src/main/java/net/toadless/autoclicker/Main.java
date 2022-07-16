package net.toadless.autoclicker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoClicker.class);

    public static void main(String[] args)
    {
        LOGGER.info("Starting AutoClicker");
        AutoClicker.start();
    }
}