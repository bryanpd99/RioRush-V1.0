
package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface Dish {
    Tag name = new Tag("nombre");
    Tag description = new Tag("descripcion");
    Tag price = new Tag("precio");
    Tag pictureUrl = new Tag("pictureUrl");
    Tag addOns = new Tag("addOns");
}
