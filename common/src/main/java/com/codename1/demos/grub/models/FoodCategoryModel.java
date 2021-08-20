
package com.codename1.demos.grub.models;

import com.codename1.demos.grub.interfaces.FoodCategory;
import com.codename1.rad.models.*;

import java.util.List;

public class FoodCategoryModel extends Entity{
    public static StringProperty name;
    public static ListProperty dishes;

    public static class Dishes extends EntityList {}

    public static final EntityType TYPE = new EntityType(){{
        name = string(tags(FoodCategory.name));
        dishes = list(Dishes.class, tags(FoodCategory.dishes));
    }};

    {
        setEntityType(TYPE);
    }

    public FoodCategoryModel(String name , List<Entity> dishes){
        set(this.name, name);
        Dishes dishesList = new Dishes();
        for (Entity addOn : dishes){
            dishesList.add(addOn);
        }
        set(this.dishes, dishesList);
    }
}
