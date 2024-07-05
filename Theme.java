package CalculatorApp;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

class Theme {
    boolean borderColorIsBlack = true;

    Theme(boolean borderColorIsBlack) {
        this.borderColorIsBlack = borderColorIsBlack;
    }

    public void toggleBorderColor(JComponent component) {
        borderColorIsBlack = !borderColorIsBlack;
        component.setBorder(borderColorIsBlack ? BorderFactory.createLineBorder(Color.BLACK, 2) : BorderFactory.createLineBorder(Color.WHITE, 2));
    }
}
