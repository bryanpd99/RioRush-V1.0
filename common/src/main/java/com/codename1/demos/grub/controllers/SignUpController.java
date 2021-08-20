
package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.views.SignUpView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class SignUpController extends FormController {

    public SignUpController(Controller parent, Entity account, Node applicationControllerViewNode, Node accountViewNode) {
        super(parent);
        Form signUoForm = new Form(new BorderLayout());
        setView(signUoForm);
        signUoForm.getToolbar().hideToolbar();
        signUoForm.setFormBottomPaddingEditingMode(true);


        signUoForm.add(BorderLayout.CENTER, new SignUpView(account, applicationControllerViewNode, accountViewNode));
    }
}
