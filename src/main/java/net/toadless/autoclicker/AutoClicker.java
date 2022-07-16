package net.toadless.autoclicker;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import net.toadless.autoclicker.listeners.InputListener;
import net.toadless.autoclicker.listeners.JTextFieldFocusListener;
import net.toadless.autoclicker.listeners.MouseListener;
import net.toadless.autoclicker.types.Click;
import net.toadless.autoclicker.types.Toggle;
import net.toadless.autoclicker.types.Unit;
import net.toadless.autoclicker.utilitys.IconUtility;
import net.toadless.autoclicker.utilitys.PopupUtility;
import net.toadless.autoclicker.utilitys.TrayUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class AutoClicker extends JFrame
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoClicker.class);

    public static final String NAME = "AutoClicker";
    public static final int HEIGHT = 85;
    public static final int WIDTH = HEIGHT * 17 / 6;

    public static boolean running;

    private final JPanel panel;
    private final Clicker clicker;

    private final Map<Component, JComponent> interfaceComponents;

    public static void start()
    {
        running = true;

        try
        {
            AutoClicker autoClicker = new AutoClicker();
            autoClicker.setVisible(true);
        } catch (Exception e)
        {
            LOGGER.error("Unable to start AutoClicker. Error: {0}", e);

            PopupUtility.showMessage(
                    null,
                    JOptionPane.ERROR_MESSAGE,
                    "Unable to start AutoClicker!"
            );

            System.exit(-1);
        }
    }

    public static void stop(AutoClicker autoClicker)
    {
        running = false;
        autoClicker.getClicker().stop();

        LOGGER.info("Exiting...");
        System.exit(0);
    }

    private AutoClicker() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, AWTException, NativeHookException
    {
        super(NAME);

        this.clicker = new Clicker(this);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.panel.setFocusable(true);
        this.panel.addMouseListener(new MouseListener());

        this.interfaceComponents = this.setupInterfaceComponents();

        this.setIconImage(IconUtility.ICON_IMAGE);
        this.setFocusTraversalPolicy(new FocusTraversalPolicy());
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();

        this.setupNativeKeyListener();
    }

    private Map<Component, JComponent> setupInterfaceComponents() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        LOGGER.info("Setting up all UI components.");

        final Map<Component, JComponent> interfaceComponents = new EnumMap<>(Component.class);

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        final JTextField intervalField = JTextFieldFocusListener.getNewTextField("Interval Between Clicks", 25);
        this.panel.add(intervalField);
        interfaceComponents.put(Component.INTERVAL, intervalField);

        final JTextField durationField = JTextFieldFocusListener.getNewTextField("Duration Of Clicks", 25);
        this.panel.add(durationField);
        interfaceComponents.put(Component.DURATION, durationField);

        final JComboBox<String> toggleList = new JComboBox<>(Toggle.getValues());
        toggleList.setSelectedIndex(7); // f8
        this.panel.add(toggleList);
        interfaceComponents.put(Component.TOGGLE, toggleList);

        final JComboBox<String> clickList = new JComboBox<>(Click.getIdentifiers());
        clickList.setSelectedIndex(0); // left click
        this.panel.add(clickList);
        interfaceComponents.put(Component.CLICK, clickList);

        final JComboBox<String> unitDropdown = new JComboBox<>(Unit.getIdentifiers());
        unitDropdown.setSelectedIndex(1); // seconds
        this.panel.add(unitDropdown);
        interfaceComponents.put(Component.UNIT, unitDropdown);

        // system tray
        final MenuItem menuItem = new MenuItem("Exit");
        menuItem.addActionListener(item -> stop(this));
        TrayUtility.createNewSystemTray(List.of(menuItem));

        return interfaceComponents;
    }

    public void setupNativeKeyListener() throws NativeHookException
    {
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new InputListener(this));
    }

    public Map<Component, JComponent> getAllComponents()
    {
        return this.interfaceComponents;
    }

    public Clicker getClicker()
    {
        return clicker;
    }

    public JPanel getPanel()
    {
        return panel;
    }
}