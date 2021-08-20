
package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface DishAddOn {
    Tag name = new Tag("nombre");
    Tag pictureUrl = new Tag("fotoUrl");
    Tag price = new Tag("precio");
    Tag isSelected = new Tag("seleccionado");
}
