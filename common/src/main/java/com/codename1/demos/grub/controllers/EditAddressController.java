
package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.models.AddressModel;
import com.codename1.demos.grub.views.EditAddressView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.nodes.Node;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class EditAddressController extends FormController {

    public EditAddressController(Controller parent, AddressModel address, Node viewNode) {
        super(parent);
        Form addAddressForm = new Form(new BorderLayout());
        addAddressForm.setFormBottomPaddingEditingMode(true);
        addAddressForm.getToolbar().hideToolbar();
        addAddressForm.add(BorderLayout.CENTER, new EditAddressView(address, viewNode));

        setView(addAddressForm);
    }
}
