package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface CreditCard {
    Tag cardHolderName = new Tag("cardpropietarioName");
    Tag number = new Tag("numero");
    Tag expirationYear = new Tag("expiracionaño");
    Tag expirationMonth = new Tag("experacionmes");
    Tag secretCode = new Tag("codigosecreto");

}
