
package com.codename1.demos.grub.views;

import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.grub.Grub;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class FirstIntroductionView extends AbstractEntityView {

    public static final ActionNode.Category FINISHED_FIRST_INTRO = new ActionNode.Category();


    public FirstIntroductionView(Entity entity, Node grubNode, Node introNode) {
        super(entity);
        setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        Container wrapper = new Container(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("IntroductionView");

        Label header = new Label("Descubre Restaurantes", "IntroductionHeader");

        String imageName = Grub.isDarkMode() ? "first-intro-image-dark.png" : "first-intro-image.png";
        ScaleImageLabel introImage = new ScaleImageLabel(getGlobalResources().getImage(imageName)){
            @Override
            public Dimension getPreferredSize() {
                Dimension dim = super.getPreferredSize();
                if (CN.isTablet()){
                    dim.setWidth(Display.getInstance().getDisplayWidth() / 2);
                    dim.setHeight((int) (Display.getInstance().getDisplayWidth() / 3));
                }else{
                    dim.setWidth(Display.getInstance().getDisplayWidth());
                    dim.setHeight((int) (Display.getInstance().getDisplayWidth() / 1.5));
                }
                return dim;
            }
        };
        introImage.setUIID("IntroImage");
        introImage.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);

        Label emptyFirstLabel = new Label ("    ", "IntroEmptyLabelOn");
        Label emptySecondLabel = new Label ("    ", "IntroEmptyLabelOff");
        Label emptyThirdLabel = new Label ("    ", "IntroEmptyLabelOff");
        Container progressCnt = BoxLayout.encloseXCenter(emptyFirstLabel, emptySecondLabel, emptyThirdLabel);

        Button next = new Button("SIGUIENTE", "IntroductionNextButton");
        next.addActionListener(evt->{
            evt.consume();
            ActionNode action = introNode.getInheritedAction(FINISHED_FIRST_INTRO);
            if (action != null) {
                action.fireEvent(entity, FirstIntroductionView.this);
            }
        });

        Button skip = new Button("SKIP", "IntroductionSkipButton");
        skip.addActionListener(evt -> {
            evt.consume();
            ActionNode action = grubNode.getInheritedAction(Grub.SKIP_TO_MAIN_WINDOW);
            if (action != null) {
                action.fireEvent(null, FirstIntroductionView.this);
            }
        });

        wrapper.add(BorderLayout.CENTER, BoxLayout.encloseY(header, introImage));
        wrapper.add(BorderLayout.SOUTH, BoxLayout.encloseY(progressCnt, next, skip));

        add(BorderLayout.CENTER, wrapper);
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
