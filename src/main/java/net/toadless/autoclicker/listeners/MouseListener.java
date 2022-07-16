package net.toadless.autoclicker.listeners;

import java.awt.event.MouseEvent;

// this is used to allow focus gain in the window
public class MouseListener implements java.awt.event.MouseListener
{
    @Override
    public void mouseClicked(MouseEvent e)
    {
        e.getComponent().requestFocusInWindow();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
