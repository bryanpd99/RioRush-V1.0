
package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface CompletedOrder {
    Tag restaurant = new Tag("restaurante");
    Tag order = new Tag("orden");
    Tag date = new Tag("fecha");
    Tag deliveredTo = new Tag("deliveredTo");
    Tag orderId = new Tag("orderId");
}
