
package com.codename1.demos.grub.interfaces;

import com.codename1.rad.models.Tag;

public interface Address {
    Tag type = new Tag("tipo");
    Tag city = new Tag("ciudad");
    Tag street = new Tag("calle");
    Tag additionalInfo = new Tag("informacion adicional");
    Tag isDefault = new Tag("Default");


    public static final int HOME = 1;
    public static final int WORK = 2;
    public static final int OTHER = 3;
}
