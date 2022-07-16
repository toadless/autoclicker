package net.toadless.autoclicker;

import java.awt.*;

// prevents components from being permanently focused
public class FocusTraversalPolicy extends java.awt.FocusTraversalPolicy
{
    @Override
    public java.awt.Component getComponentAfter(Container aContainer, java.awt.Component aComponent)
    {
        return null;
    }

    @Override
    public java.awt.Component getComponentBefore(Container aContainer, java.awt.Component aComponent)
    {
        return null;
    }

    @Override
    public java.awt.Component getFirstComponent(Container aContainer)
    {
        return null;
    }

    @Override
    public java.awt.Component getLastComponent(Container aContainer)
    {
        return null;
    }

    @Override
    public java.awt.Component getDefaultComponent(Container aContainer)
    {
        return null;
    }
}
