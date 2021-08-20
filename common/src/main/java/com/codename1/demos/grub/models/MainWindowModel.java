
package com.codename1.demos.grub.models;

import com.codename1.demos.grub.interfaces.MainWindow;
import com.codename1.rad.models.*;

import java.util.List;

public class MainWindowModel extends Entity {
    public static EntityProperty profile, filter;
    public static ListProperty restaurants;

    public static class Restaurants extends EntityList {}

    public static final EntityType TYPE = new EntityType(){{
        profile = entity(AccountModel.class, tags(MainWindow.profile));
        filter = entity(FilterModel.class, tags(MainWindow.filter));
        restaurants = list(Restaurants.class, tags(MainWindow.restaurants));
    }};

    {
        setEntityType(TYPE);
    }

    public MainWindowModel(Entity profile, List<Entity> restaurants){
        set(this.profile, profile);
        set(filter, new FilterModel());
        Restaurants restaurantsList = new Restaurants();
        for (Entity rest : restaurants){
            restaurantsList.add(rest);
        }
        set(this.restaurants, restaurantsList);
    }
}
