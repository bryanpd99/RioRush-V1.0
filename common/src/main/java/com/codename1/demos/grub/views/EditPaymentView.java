
package com.codename1.demos.grub.views;

import com.codename1.components.MultiButton;
import com.codename1.demos.grub.interfaces.Account;
import com.codename1.demos.grub.interfaces.PaymentMethod;
import com.codename1.rad.controllers.ActionSupport;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.table.TableLayout;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class EditPaymentView extends AbstractEntityView {

    public static final ActionNode.Category UPDATE_PAYMENT_VIEW = new ActionNode.Category();

    public EditPaymentView(Entity paymentModel, Entity account, Node viewNode) {
        super(paymentModel);
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
        setScrollVisible(false);
        setUIID("EditPaymentView");

        Button backButton = new Button(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT);
        backButton.setUIID("EditPaymentBackButton");
        backButton.addActionListener(evt -> {
            evt.consume();
            ActionSupport.dispatchEvent(new FormController.FormBackEvent(backButton));
        });

        Label headerLabel = new Label("MI DIRECCION", "EditPaymentHeaderLabel");
        Container headerCnt = BorderLayout.center(headerLabel).add(BorderLayout.WEST, backButton);
        headerCnt.setUIID("EditPaymentHeaderCnt");
        add(headerCnt);

        Label savedCardsHeader = new Label("GUARDADAS", "SavedCardsHeader");
        add(savedCardsHeader);
        Container cardsCnt = new Container(new BoxLayout(BoxLayout.X_AXIS));
        cardsCnt.setScrollableX(true);
        EntityList<Entity> cardsList = (EntityList<Entity>) account.get(Account.creditCards);
        for (Entity card : cardsList){
            cardsCnt.add(new CreditCardView(card, viewNode));
        }
        add(cardsCnt);

        Label anotherMethodHeader = new Label("OTRO METODO", "AnotherMethodHeader");
        add(anotherMethodHeader);

        MultiButton cashOnDeliveryButton = new MultiButton("DINERO EFECTIVO");
        cashOnDeliveryButton.setEmblem(getGlobalResources().getImage("cash-icon.png"));
        cashOnDeliveryButton.setEmblemPosition("West");
        cashOnDeliveryButton.setEmblemUIID("ChangePaymentMethodEmblem");
        cashOnDeliveryButton.setUIID("ChangePaymentMethodActionButton");
        cashOnDeliveryButton.setUIIDLine1("ChangePaymentMethodActionButtonText");
        cashOnDeliveryButton.addActionListener(evt -> {
            evt.consume();
            paymentModel.set(PaymentMethod.method, PaymentMethod.CASH);
            ActionNode action = viewNode.getInheritedAction(UPDATE_PAYMENT_VIEW);
            if (action != null) {
                action.fireEvent(null, EditPaymentView.this);
            }
        });

        MultiButton creditCardButton = new MultiButton("TARJETA");
        creditCardButton.setEmblem(getGlobalResources().getImage("credit-card-icon.png"));
        creditCardButton.setEmblemPosition("West");
        creditCardButton.setUIID("ChangePaymentMethodActionButton");
        creditCardButton.setUIIDLine1("ChangePaymentMethodActionButtonText");


        MultiButton applePayButton = new MultiButton("Apple Pay");
        applePayButton.setEmblem(getGlobalResources().getImage("apple-icon2.png"));
        applePayButton.setEmblemPosition("West");
        applePayButton.setUIID("ChangePaymentMethodActionButton");
        applePayButton.setUIIDLine1("ChangePaymentMethodActionButtonText");
        applePayButton.addActionListener(evt -> {
            evt.consume();
            paymentModel.set(PaymentMethod.method, PaymentMethod.APPLE_PAY);
            ActionNode action = viewNode.getInheritedAction(UPDATE_PAYMENT_VIEW);
            if (action != null) {
                action.fireEvent(null, EditPaymentView.this);
            }
        });

        MultiButton paypalButton = new MultiButton("Paypal");
        paypalButton.setEmblem(getGlobalResources().getImage("paypal-icon.png"));
        paypalButton.setEmblemPosition("West");
        paypalButton.setUIID("ChangePaymentMethodActionButton");
        paypalButton.setUIIDLine1("ChangePaymentMethodActionButtonText");
        paypalButton.addActionListener(evt -> {
            evt.consume();
            paymentModel.set(PaymentMethod.method, PaymentMethod.PAYPAL);
            ActionNode action = viewNode.getInheritedAction(UPDATE_PAYMENT_VIEW);
            if (action != null) {
                action.fireEvent(null, EditPaymentView.this);
            }
        });
        add(TableLayout.encloseIn(1, cashOnDeliveryButton, creditCardButton, applePayButton, paypalButton));
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
