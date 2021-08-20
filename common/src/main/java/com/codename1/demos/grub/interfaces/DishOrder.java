
package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface DishOrder {
    Tag name = new Tag("nombre");
    Tag pictureUrl = new Tag("fotoUrl");
    Tag price = new Tag("precio");
    Tag addOns = new Tag("addOns");
    Tag quantity = new Tag("quantity");
}
