
package com.codename1.demos.grub.controllers;

import com.codename1.demos.grub.models.OrderDishModel;
import com.codename1.demos.grub.models.RestaurantModel;
import com.codename1.demos.grub.views.DishPreview;
import com.codename1.demos.grub.views.DishView;
import com.codename1.demos.grub.views.RestaurantView;
import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class RestaurantController extends FormController {

    public static final ActionNode enterDish = UI.action();
    public static final ActionNode showOrder = UI.action();
    public static final ActionNode addToCart = UI.action();


    public RestaurantController(Controller parent, Entity restEntity, Entity account, Node mainWindowNode) {
        super(parent);
        Form form = new Form(new BorderLayout());
        form.getToolbar().hideToolbar();

        ViewNode viewNode = new ViewNode(
                UI.actions(DishPreview.DISH_CLICKED, enterDish),
                UI.actions(RestaurantView.SHOW_ORDER, showOrder),
                UI.actions(DishView.ADD_TO_CART, addToCart)
        );
        RestaurantView restaurant = new RestaurantView(restEntity, account, viewNode, mainWindowNode);
        form.add(BorderLayout.CENTER, restaurant);
        setView(form);

        addActionListener(enterDish, evt->{
            evt.consume();
            Entity dish = evt.getEntity();
            new DishController(this, dish, viewNode).getView().show();
        });

        addActionListener(showOrder, evt->{
            evt.consume();
            new OrderController(this, restEntity, account, mainWindowNode).getView().show();
        });

        addActionListener(addToCart, evt -> {
            evt.consume();
            if (restEntity instanceof RestaurantModel){
                ((RestaurantModel)(restEntity)).addToOrder(new OrderDishModel(evt.getEntity(), (int)(evt.getContext().getExtra("quantity"))));
            }
        });
    }
}


