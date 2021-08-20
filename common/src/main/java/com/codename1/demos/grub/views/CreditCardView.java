
package com.codename1.demos.grub.views;

import com.codename1.demos.grub.interfaces.CreditCard;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.CN.convertToPixels;

public class CreditCardView extends AbstractEntityView {

    Property numberProp, expirationYearProp, expirationMonthProp;

    public static final ActionNode.Category SET_CARD_TO_PAY = new ActionNode.Category();

    public CreditCardView(Entity creditCard, Node viewNode) {
        super(creditCard);
        setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        setUIID("CreditCard");

        numberProp = creditCard.findProperty(CreditCard.number);
        expirationYearProp = creditCard.findProperty(CreditCard.expirationYear);
        expirationMonthProp = creditCard.findProperty(CreditCard.expirationMonth);

        String number = creditCard.getText(numberProp);
        String expirationYear = creditCard.getText(expirationYearProp);
        String expirationMonth = creditCard.getText(expirationMonthProp);
        String cardLastFourNumbers = number.substring(12);

        Button numberButton = new Button("****  ****  ****  " + cardLastFourNumbers, "CreditCardNumber");
        Label expirationDate = new Label(expirationMonth + "/" + expirationYear, "CreditCardExpirationDate");

        add(BorderLayout.CENTER, numberButton);
        add(BorderLayout.SOUTH, expirationDate);

        numberButton.addActionListener(evt -> {
            evt.consume();
            if (viewNode != null){
                ActionNode action = viewNode.getInheritedAction(SET_CARD_TO_PAY);
                if (action != null) {
                    action.fireEvent(creditCard, CreditCardView.this);
                }
            }
        });
        setLeadComponent(numberButton);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dim =  super.getPreferredSize();
        int width = Display.getInstance().getDisplayWidth() - getComponentForm().getContentPane().getAllStyles().getHorizontalPadding() - convertToPixels(2);
        dim.setWidth(width);
        dim.setHeight((Display.getInstance().getDisplayWidth() - this.getParent().getAllStyles().getHorizontalPadding()) / 2);
        return dim;
    }

    @Override
    public void update() {

    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }
}
