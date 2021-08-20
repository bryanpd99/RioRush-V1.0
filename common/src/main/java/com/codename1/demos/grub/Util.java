

package com.codename1.demos.grub;

import com.codename1.l10n.L10NManager;
import com.codename1.ui.CN;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class Util {
    private static Image roundRectImage = null;

    public static String getPriceAsString(double price){
        String priceString =  price + "";
        if (priceString.indexOf('.') + 2 <= priceString.length() - 1){
            priceString = priceString.substring(0, priceString.indexOf('.') + 2);
        }
        return priceString + "0 " + L10NManager.getInstance().getCurrencySymbol();
    }

    public static Object createRoundMask(int size){
        Image maskImage = Image.createImage(size, size);
        Graphics g = maskImage.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0x000000);
        g.fillRect(0, 0, size, size);
        g.setColor(0xffffff);
        g.fillArc(0, 0, size, size, 0, 360);
        return maskImage.createMask();
    }

    public static Object createRoundRectangleMask(int width, int height){
        if (roundRectImage == null){
            roundRectImage = getGlobalResources().getImage("round-rectangle.png");
        }

        return roundRectImage.scaled(width, height).createMask();
    }

    public static Object createHalfRoundRectangleMask(int width, int height){
        if (roundRectImage == null){
            roundRectImage = getGlobalResources().getImage("half-round-rectangle.png");
        }

        return roundRectImage.scaled(width, height).createMask();
    }

    public static float convertToDips(int pixels){
        final int pixelsPerDip = CN.convertToPixels(1);
        return pixels / pixelsPerDip;
    }

}
