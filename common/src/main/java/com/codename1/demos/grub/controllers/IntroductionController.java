
package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.views.*;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class IntroductionController extends FormController {

    public static final ActionNode enterSecondIntroduction = UI.action();
    public static final ActionNode enterThirdIntroduction = UI.action();

    public IntroductionController(Controller parent, Entity account, Node viewNode) {
        super(parent);

        ViewNode introNode = new ViewNode(
                UI.actions(FirstIntroductionView.FINISHED_FIRST_INTRO, enterSecondIntroduction),
                UI.actions(SecondIntroductionView.FINISHED_SECOND_INTRO, enterThirdIntroduction)
        );

        Form introForm = new Form(new BorderLayout());
        introForm.getToolbar().hideToolbar();
        IntroductionView introView = new IntroductionView(account, viewNode, introNode);
        introForm.add(BorderLayout.CENTER, introView);
        setView(introForm);

        addActionListener(enterSecondIntroduction, event->{
            event.consume();
            introView.setIntroPage(1);
        });

        addActionListener(enterThirdIntroduction, event->{
            event.consume();
            introView.setIntroPage(2);
        });
    }
}
