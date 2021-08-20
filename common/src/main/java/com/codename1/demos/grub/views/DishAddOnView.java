
package com.codename1.demos.grub.views;

import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.grub.Util;
import com.codename1.demos.grub.interfaces.DishAddOn;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.models.PropertySelector;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.rad.ui.image.RoundRectImageRenderer;
import com.codename1.ui.Button;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class DishAddOnView extends AbstractEntityView {

    public static final ActionNode.Category ADD_ON_CLICKED = new ActionNode.Category();

    private Node viewNode;
    private Property nameProp, pictureUrlProp, priceProp, isSelectedProp;
    Button nameLabel;
    Label priceLabel;

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("placeholder.png"), false);

    public DishAddOnView(Entity entity, Node node) {
        super(entity);
        viewNode = node;
        this.setUIID("DishAddOn");
        setLayout(new BorderLayout());

        nameProp = entity.findProperty(DishAddOn.name);
        pictureUrlProp = entity.findProperty(DishAddOn.pictureUrl);
        priceProp = entity.findProperty(DishAddOn.price);
        isSelectedProp = entity.findProperty(DishAddOn.isSelected);


        PropertySelector imagePropertySelector = new PropertySelector(entity, pictureUrlProp);
        RoundRectImageRenderer renderer = new RoundRectImageRenderer(200, 200, 2);

        Image addOnImage = renderer.createImage(imagePropertySelector);
        ScaleImageLabel addOnImageLabel = new ScaleImageLabel(addOnImage);

        nameLabel = new Button(entity.getText(nameProp), "DishAddOnName");
        priceLabel = new Label(Util.getPriceAsString(entity.getDouble(priceProp)), "DishAddOnPrice");
        nameLabel.addActionListener(evt->{
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(ADD_ON_CLICKED);
            if (action != null) {
                action.fireEvent(entity, DishAddOnView.this);
            }
        });
        setLeadComponent(nameLabel);

        add(BorderLayout.NORTH, addOnImageLabel);
        add(BorderLayout.CENTER, nameLabel);
        add(BorderLayout.SOUTH, priceLabel);

        update();
    }

    @Override
    public void update() {
        boolean isSelected = getEntity().getBoolean(isSelectedProp);
        if (isSelected){
            setUIID("DishAddOnPressed");
            nameLabel.setUIID("DishAddOnNamePressed");
            priceLabel.setUIID("DishAddOnPricePressed");
        }else{
            setUIID("DishAddOn");
            nameLabel.setUIID("DishAddOnName");
            priceLabel.setUIID("DishAddOnPrice");
        }
        revalidateWithAnimationSafety();

    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }


}
