
package com.codename1.demos.grub.views;

import com.codename1.demos.grub.Grub;
import com.codename1.demos.grub.Util;
import com.codename1.demos.grub.interfaces.Address;
import com.codename1.demos.grub.models.AccountModel;
import com.codename1.demos.grub.models.AddressModel;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;

public class SetFirstLocationView extends AbstractEntityView {

    public static final ActionNode.Category COMPLETE_SETTING_ADDRESS = new ActionNode.Category();

    public SetFirstLocationView(Entity entity, Node viewNode) {
        super(entity);
        setLayout(new BorderLayout());
        setUIID("SetFirstLocationView");

        Container newLocationCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        newLocationCnt.setUIID("SetFirstLocationWrapperView");
        Label enterLocationHeader = new Label("Introduce Localizacion", "SetFirstAddressHeader");
        TextField city = new TextField("", "Ciudad", 20, TextArea.ANY);
        city.setUIID("SetFirstLocationTextField");
        city.getHintLabel().setUIID("SetFirstLocationTextFieldHint");
        TextField street = new TextField("", "Calle", 20, TextArea.ANY);
        street.setUIID("SetFirstLocationTextField");
        street.getHintLabel().setUIID("SetFirstLocationTextFieldHint");
        Button continueButton = new Button("CONTINUE", "SetFirstAddressNextButton");
        continueButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(COMPLETE_SETTING_ADDRESS);
            if (action != null) {
                if (entity instanceof AccountModel){
                    ((AccountModel) entity).addAddress(new AddressModel(city.getText(), street.getText(), "", Address.HOME));
                }
                action.fireEvent(entity, SetFirstLocationView.this);
            }
        });
        Button skipForNowButton = new Button("SKIP", "SetFirstAddressSkipButton");
        skipForNowButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(Grub.SKIP_TO_MAIN_WINDOW);
            if (action != null) {
                action.fireEvent(null, SetFirstLocationView.this);
            }
        });

        Validator validator = new Validator();
        validator.addConstraint(city, new LengthConstraint(1));
        validator.addConstraint(street, new LengthConstraint(1));
        validator.addSubmitButtons(continueButton);
        newLocationCnt.addAll(enterLocationHeader, city, street, continueButton, skipForNowButton);
        add(BorderLayout.SOUTH, newLocationCnt);

        if(CN.isTablet()) {
            final int sideMargin = (int) (Display.getInstance().getDisplayWidth() / 3.5);
            newLocationCnt.getAllStyles().setMargin(Component.LEFT, Util.convertToDips(sideMargin));
            newLocationCnt.getAllStyles().setMargin(Component.RIGHT, Util.convertToDips(sideMargin));
        }
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
