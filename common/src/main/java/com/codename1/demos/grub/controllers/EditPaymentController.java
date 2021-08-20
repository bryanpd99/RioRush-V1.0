
package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.views.EditPaymentView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class EditPaymentController extends FormController {
    public EditPaymentController(Controller parent, Entity paymentModel, Entity account, Node viewNode) {
        super(parent);

        Form paymentView = new Form(new BorderLayout());
        paymentView.getToolbar().hideToolbar();
        paymentView.add(BorderLayout.CENTER, new EditPaymentView(paymentModel, account, viewNode));

        setView(paymentView);
    }




}
