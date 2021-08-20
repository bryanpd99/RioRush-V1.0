
package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface PaymentMethod {
    Tag method = new Tag("metodo");
    Tag creditCard = new Tag("tarjeta de credito");

    public static final int CREDIT_CARD = 0;
    public static final int CASH = 1;
    public static final int APPLE_PAY = 2;
    public static final int PAYPAL = 3;
}
