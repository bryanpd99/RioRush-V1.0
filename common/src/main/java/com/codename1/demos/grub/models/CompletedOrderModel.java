
package com.codename1.demos.grub.models;

import com.codename1.demos.grub.interfaces.CompletedOrder;
import com.codename1.rad.models.*;

import java.util.Random;

public class CompletedOrderModel extends Entity {
    public static EntityProperty restaurant;
    public static StringProperty date;
    public static IntProperty deliveredTo;
    public static IntProperty orderId;
    public static ListProperty order;

    public static class RestaurantOrder extends EntityList {}

    private static final EntityType TYPE = new EntityType() {{
        restaurant = entity(RestaurantModel.class, tags(CompletedOrder.restaurant));
        order = list(RestaurantOrder.class, tags(CompletedOrder.order));
        date = string(tags(CompletedOrder.date));
        deliveredTo = Integer(tags(CompletedOrder.deliveredTo));
        orderId = Integer(tags(CompletedOrder.orderId));
    }};

    {
        setEntityType(TYPE);
    }

    public CompletedOrderModel(Entity restaurant, EntityList<Entity> order, String date, int deliveredTo) {
        set(this.restaurant, restaurant);
        set(this.date, date);
        set(this.deliveredTo, deliveredTo);
        Random idMaker = new Random();
        int id = idMaker.nextInt();
        if (id < 0){
            id = id * -1;
        }
        set(this.orderId, id);

        RestaurantOrder orderList = new RestaurantOrder();
        for (Entity menuCategory : order){
            orderList.add(menuCategory);
        }
        set(this.order, orderList);
    }
}
