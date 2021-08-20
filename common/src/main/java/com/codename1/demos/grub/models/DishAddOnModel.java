
package com.codename1.demos.grub.models;

import com.codename1.demos.grub.interfaces.DishAddOn;
import com.codename1.rad.models.*;

public class DishAddOnModel extends Entity {
    public static StringProperty name, pictureUrl;
    public static DoubleProperty price;
    public static BooleanProperty isSelected;

    public static final EntityType TYPE = new EntityType(){{
        name = string(tags(DishAddOn.name));
        pictureUrl = string(tags(DishAddOn.pictureUrl));
        price = Double(tags(DishAddOn.price));
        isSelected = Boolean(tags(DishAddOn.isSelected));

    }};

    {
        setEntityType(TYPE);
    }

    public DishAddOnModel(String name, String pictureUrl, double price){
        set(this.name, name);
        set(this.pictureUrl, pictureUrl);
        set(this.price, price);
        set(isSelected, false);
    }

    public DishAddOnModel(Entity eddOnEntity){
        set(this.name, eddOnEntity.getText(DishAddOn.name));
        set(this.pictureUrl, eddOnEntity.getText(DishAddOn.pictureUrl));
        set(this.price, eddOnEntity.getDouble(DishAddOn.price));
    }


}
