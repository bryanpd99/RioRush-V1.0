
package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface Account {
    Tag firstName = new Tag("Nombre");
    Tag lastName = new Tag("Apellido");
    Tag emailAddress = new Tag("correo");
    Tag password = new Tag("password");
    Tag mobileNumber = new Tag("celular");
    Tag addresses = new Tag("direcciones");
    Tag creditCards = new Tag("tarjeta de credit");
    Tag favoriteRestaurants = new Tag("favoritos");
    Tag completedOrders = new Tag("ordenescompletas");

}
