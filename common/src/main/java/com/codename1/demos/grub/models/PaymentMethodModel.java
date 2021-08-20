
package com.codename1.demos.grub.models;

import com.codename1.demos.grub.interfaces.PaymentMethod;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityProperty;
import com.codename1.rad.models.EntityType;
import com.codename1.rad.models.IntProperty;

public class PaymentMethodModel extends Entity {

    public static IntProperty method;
    public static EntityProperty creditCard;

    public static final EntityType TYPE = new EntityType(){{
        method = Integer(tags(PaymentMethod.method));
        creditCard = entity(CreditCardModel.class ,tags(PaymentMethod.creditCard));
    }};

    {
        setEntityType(TYPE);
    }

    public PaymentMethodModel(int method, Entity creditCard){
        set(this.method, method);
        if (method == PaymentMethod.CREDIT_CARD){

        set(this.creditCard, creditCard);
        }
    }
}
