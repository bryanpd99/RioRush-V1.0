
package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface Restaurant {
    Tag name = new Tag("nombre");
    Tag description= new Tag("descripcion");
    Tag picture = new Tag("foto");
    Tag icon = new Tag("icono");
    Tag category = new Tag("categoria");
    Tag rating = new Tag("rating");
    Tag menu = new Tag("menu");
    Tag order = new Tag("orden");
    Tag estimatedDeliveryTime = new Tag("tiempo estimado");
    Tag deliveryFee = new Tag("deliveryFee");
    Tag distance = new Tag("distancia");
    Tag restDiscount = new Tag("descuento");

    public static final int CATEGORY_RICE = 0;
    public static final int CATEGORY_PIZZA = 1;
    public static final int CATEGORY_DONUT = 2;
    public static final int CATEGORY_CHICKEN = 3;
    public static final int CATEGORY_MEAL = 4;
    public static final int CATEGORY_STEAK = 5;
    public static final int CATEGORY_KEBAB = 6;
    public static final int CATEGORY_ALL = 7;
}
