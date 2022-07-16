package net.toadless.autoclicker.types;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public enum Click
{
    LEFT_CLICK(InputEvent.BUTTON1_DOWN_MASK, "Left Click", ClickType.MOUSE),
    RIGHT_CLICK(InputEvent.BUTTON2_DOWN_MASK, "Right Click", ClickType.MOUSE),
    SHIFT(KeyEvent.VK_SHIFT, "Shift", ClickType.KEYBOARD),

    A(KeyEvent.VK_A, "A", ClickType.KEYBOARD),
    B(KeyEvent.VK_B, "B", ClickType.KEYBOARD),
    C(KeyEvent.VK_C, "C", ClickType.KEYBOARD),
    D(KeyEvent.VK_D, "D", ClickType.KEYBOARD),
    E(KeyEvent.VK_E, "E", ClickType.KEYBOARD),
    F(KeyEvent.VK_F, "F", ClickType.KEYBOARD),
    G(KeyEvent.VK_G, "G", ClickType.KEYBOARD),
    H(KeyEvent.VK_H, "H", ClickType.KEYBOARD),
    I(KeyEvent.VK_I, "I", ClickType.KEYBOARD),
    J(KeyEvent.VK_J, "J", ClickType.KEYBOARD),
    K(KeyEvent.VK_K, "K", ClickType.KEYBOARD),
    L(KeyEvent.VK_L, "L", ClickType.KEYBOARD),
    M(KeyEvent.VK_M, "M", ClickType.KEYBOARD),
    N(KeyEvent.VK_N, "N", ClickType.KEYBOARD),
    O(KeyEvent.VK_O, "O", ClickType.KEYBOARD),
    P(KeyEvent.VK_P, "P", ClickType.KEYBOARD),
    Q(KeyEvent.VK_Q, "Q", ClickType.KEYBOARD),
    R(KeyEvent.VK_R, "R", ClickType.KEYBOARD),
    S(KeyEvent.VK_S, "S", ClickType.KEYBOARD),
    T(KeyEvent.VK_T, "T", ClickType.KEYBOARD),
    U(KeyEvent.VK_U, "U", ClickType.KEYBOARD),
    V(KeyEvent.VK_V, "V", ClickType.KEYBOARD),
    W(KeyEvent.VK_W, "W", ClickType.KEYBOARD),
    X(KeyEvent.VK_X, "X", ClickType.KEYBOARD),
    Y(KeyEvent.VK_Y, "Y", ClickType.KEYBOARD),
    Z(KeyEvent.VK_Z, "Z", ClickType.KEYBOARD);



    private int event;
    private String identifier;
    private ClickType clickType;

    Click(int event, String identifier, ClickType clickType)
    {
        this.event = event;
        this.identifier = identifier;
        this.clickType = clickType;
    }

    public int getEvent()
    {
        return this.event;
    }

    public String getIdentifier()
    {
        return this.identifier;
    }

    public ClickType getClickType()
    {
        return this.clickType;
    }



    public static Click[] getClicks()
    {
        return Click.class.getEnumConstants();
    }

    public static String[] getIdentifiers()
    {
        final List<String> identifiers = new LinkedList<>();

        for (Click click : getClicks())
        {
            identifiers.add(click.getIdentifier());
        }

        return identifiers.toArray(new String[0]);
    }
}