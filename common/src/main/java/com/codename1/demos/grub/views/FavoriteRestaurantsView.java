
package com.codename1.demos.grub.views;

import com.codename1.demos.grub.interfaces.Account;
import com.codename1.demos.grub.models.RestaurantModel;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;

import java.util.List;

public class FavoriteRestaurantsView extends AbstractEntityView {

    Container restsCnt;
    Node viewNode;

    public FavoriteRestaurantsView(Entity account, Node viewNode) {
        super(account);
        setUIID("FavoriteRestaurantsView");
        this.viewNode = viewNode;
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        Label headerLabel = new Label("FAVORITOS", "FavoriteHeaderLabel");
        Container headerCnt = BorderLayout.center(headerLabel);
        headerCnt.setUIID("FavoriteHeaderCnt");
        add(headerCnt);
        restsCnt = new Container();
//        ((GridLayout)restsCnt.getLayout()).
        restsCnt.setScrollableY(true);
        restsCnt.setScrollVisible(false);
        add(restsCnt);

        update();
    }

    @Override
    public void update() {
        restsCnt.removeAll();
        if (getEntity().get(Account.favoriteRestaurants) instanceof EntityList){
            EntityList<Entity> restList = (EntityList<Entity>)getEntity().get(Account.favoriteRestaurants);
            final int restListSize = restList.size();
            if (restListSize > 0){
                int landScapeRows = restListSize / 2;
                if (restListSize % 2 != 0){
                    landScapeRows++;
                }
                restsCnt.setLayout(new GridLayout(restListSize, 1, landScapeRows, 2));
                for(Entity rest : restList){
                    restsCnt.add(new FavoriteRestView((RestaurantModel) rest, viewNode));
                }
            }
        }
    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }

    public void addFavorite(Entity rest){
        restsCnt.add(new FavoriteRestView((RestaurantModel) rest, viewNode));
        update();
    }

    public void removeFavorite(Entity rest){
        List<Component> restaurants = restsCnt.getChildrenAsList(true);
        for(Component currRest : restaurants){
            if (currRest instanceof FavoriteRestView){
                if (((FavoriteRestView) currRest).getEntity() == rest){
                    restsCnt.removeComponent(currRest);
                }
            }
        }
        update();
    }
}
