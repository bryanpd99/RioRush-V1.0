
package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.views.SetFirstLocationView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class SetFirstLocationController extends FormController {

    public SetFirstLocationController(Controller parent, Entity account, Node viewNode) {
        super(parent);
        Form setAddressForm = new Form(new BorderLayout());
        setAddressForm.getToolbar().hideToolbar();
        setAddressForm.setFormBottomPaddingEditingMode(true);


        setAddressForm.add(BorderLayout.CENTER, new SetFirstLocationView(account, viewNode));

        setView(setAddressForm);

    }
}
