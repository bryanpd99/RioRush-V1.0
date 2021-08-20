
package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.models.AccountModel;
import com.codename1.demos.grub.views.AddCreditCardView;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.nodes.Node;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class AddCreditCardController extends FormController {


    public AddCreditCardController(FormController parent, AccountModel account, Node viewNode) {
        super(parent);
        Form addCreditCartController = new Form(new BorderLayout());
        addCreditCartController.getToolbar().hideToolbar();
        addCreditCartController.setFormBottomPaddingEditingMode(true);
        AddCreditCardView view = new AddCreditCardView(account, viewNode);
        addCreditCartController.add(BorderLayout.CENTER, view);

        setView(addCreditCartController);

    }
}
