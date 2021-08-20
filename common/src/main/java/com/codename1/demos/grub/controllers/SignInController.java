
package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.views.SignInView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class SignInController extends FormController {
    public SignInController(Controller parent, Entity account, Node applicationControllerViewNode, Node accountViewNode) {
        super(parent);
        Form signInForm = new Form(new BorderLayout());
        signInForm.setFormBottomPaddingEditingMode(true);
        signInForm.getToolbar().hideToolbar();
        signInForm.add(BorderLayout.CENTER, new SignInView(account, applicationControllerViewNode, accountViewNode));

        setView(signInForm);
    }
}
