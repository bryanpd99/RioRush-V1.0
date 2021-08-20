
package com.codename1.demos.grub;

import com.codename1.demos.grub.controllers.*;
import com.codename1.demos.grub.interfaces.Account;
import com.codename1.demos.grub.models.*;
import com.codename1.demos.grub.views.*;
import com.codename1.io.Log;
import com.codename1.rad.controllers.ApplicationController;
import com.codename1.rad.controllers.ControllerEvent;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.ViewNode;
import com.codename1.rad.ui.UI;
import com.codename1.ui.*;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codename1.ui.CN.*;


public class Grub extends ApplicationController {
    Entity account;
    private static boolean darkMode = false;
    private Resources theme;

    public static final ActionNode enterMainWindow = UI.action();
    public static final ActionNode enterIntroduction = UI.action();
    public static final ActionNode enterSetLocation = UI.action();
    public static final ActionNode logout = UI.action();
    public static final ActionNode darkModeActionNode = UI.action();

    public static final ActionNode.Category SKIP_TO_MAIN_WINDOW = new ActionNode.Category();

    public static final int DEBUG_MODE_WITH_SIGNING = 0;
    public static final int DEBUG_MODE_WITHOUT_SIGNING = 1;
    public static final int DEBUG_MODE_WITH_SIGNING_DARK_MODE = 2;
    public static final int DEBUG_MODE_WITHOUT_SIGNING_DARK_MODE = 3;

    public static final int mode = DEBUG_MODE_WITH_SIGNING;

    @Override
    public void actionPerformed(ControllerEvent evt) {
        if (evt instanceof StartEvent) {
            evt.consume();

            ViewNode viewNode = new ViewNode(
                    UI.actions(SignInView.COMPLETE_SIGNING_IN, enterIntroduction),
                    UI.actions(ThirdIntroductionView.FINISHED_THIRD_INTRO, enterSetLocation),
                    UI.actions(SetFirstLocationView.COMPLETE_SETTING_ADDRESS, enterMainWindow),
                    UI.actions(ProfileView.LOG_OUT, logout),
                    UI.actions(AccountView.DARK_MODE, darkModeActionNode),
                    UI.actions(SKIP_TO_MAIN_WINDOW, enterMainWindow)
            );

            if (mode == DEBUG_MODE_WITH_SIGNING || mode == DEBUG_MODE_WITH_SIGNING_DARK_MODE){

                if (mode == DEBUG_MODE_WITH_SIGNING_DARK_MODE){
                    darkMode = true;
                    initTheme();
                }

                account = new AccountModel();
                new AccountController(this, account, viewNode).getView().show();

                addActionListener(logout, event-> {
                    account = new AccountModel();
                    new AccountController(this, account, viewNode).getView().showBack();
                });

                addActionListener(enterIntroduction, event->{
                    event.consume();
                    new IntroductionController(this, account, viewNode).getView().show();
                });


                addActionListener(enterSetLocation, event -> {
                    event.consume();
                    new SetFirstLocationController(this, account, viewNode).getView().show();
                });

                addActionListener(enterMainWindow, event->{
                    event.consume();
                    new MainWindowController(this, createDemoMainWindowEntity(account), viewNode).getView().show();
                });

                addActionListener(darkModeActionNode, event->{
                    event.consume();
                    darkMode = !darkMode;
                    initTheme();
                });
            }else if (mode == DEBUG_MODE_WITHOUT_SIGNING){
                new MainWindowController(this, createDemoMainWindowEntity(null), viewNode).getView().show();

            }else if(mode == DEBUG_MODE_WITHOUT_SIGNING_DARK_MODE){
                darkMode = true;
                initTheme();
                new MainWindowController(this, createDemoMainWindowEntity(null), viewNode).getView().show();
            }
        }
    }

    private Entity createDemoMainWindowEntity(Entity accountEntity){
        Entity account;
        if (accountEntity == null){
             account = new AccountModel();
            account.set(Account.firstName, "nombre");
            account.set(Account.lastName, "apellido");
            account.set(Account.emailAddress, "correo@gmail.com");
            account.set(Account.password, "sd12eqwf134qsd");
            account.set(Account.mobileNumber, "0544123415");
        }else{
            account = accountEntity;
        }
        List restaurantsList = new ArrayList();
        for (int i = 0; i < 10; i++){
            restaurantsList.add(createRestaurantDemoModel());
        }
        return new MainWindowModel(account, restaurantsList);
    }

    private Entity createRestaurantDemoModel(){
        RestaurantModel restaurant = new RestaurantModel("RIO_RUSH Pizza", "https://sergeycodenameone.github.io/restaurant.png", "Italian", 4.7, 5, "https://sergeycodenameone.github.io/restaurant-icon.png",30, createDemoMenu());
        return restaurant;
    }

    private List<Entity> createDemoMenu(){
        List<Entity> menu = new ArrayList<>();

        menu.add(new FoodCategoryModel("Pizzas", createPizzaMenu()));
        menu.add(new FoodCategoryModel("Pastas", createPastaMenu()));
        menu.add(new FoodCategoryModel("Postres", createDessertsMenu()));
        menu.add(new FoodCategoryModel("Bebidas", createDrinksMenu()));
        return menu;
    }

    private List<Entity> createPastaMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Ravioli", "Ravioli pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 4, createDemoAddOns()));
        dishes.add(new DishModel("Fettuccine", "Fettuccine pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 5, createDemoAddOns()));
        dishes.add(new DishModel("Linguini", "Linguini pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 2, createDemoAddOns()));
        dishes.add(new DishModel("Rotelle", "Rotelle pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 3, createDemoAddOns()));
        dishes.add(new DishModel("Ditalini", "Ditalini pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 4.5, createDemoAddOns()));
        dishes.add(new DishModel("Tortellini", "Tortellini pasta", "https://sergeycodenameone.github.io/pasta-image.jpg", 6.4, createDemoAddOns()));

        return dishes;
    }

    private List<Entity> createDrinksMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Cola", "Cola con hielo", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Soda", "Soda con hielo", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Jugo de Naranja", "Jugo Naranja con hielo", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Jugo de Manzana", "Jugo Manzana con hielo", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Batido", "Batido con crema", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Chocolatada", "Chocolatada con crema", "https://sergeycodenameone.github.io/orange-juice.jpg", 4.60, createDemoAddOns()));

        return dishes;
    }

    private List<Entity> createDessertsMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Pie Manzana", "Pie de Manzana con helado", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Pastel Chocolate", "Pastel con helado", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Pancakes", "Pancakes con helado", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Cupcakes", "Cupcakes con helado", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Helado Vanilla", "Helado de Vainilla", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Helado Vhocolate", "Helado de Chocolate", "https://sergeycodenameone.github.io/pancakes-image.jpg", 4.60, createDemoAddOns()));

        return dishes;
    }

    private List<Entity> createPizzaMenu(){
        List<Entity> dishes = new ArrayList<>();
        dishes.add(new DishModel("Neapolitana Pizza", "Grande pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Chicago Pizza", "Mediana pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("New York Pizza", "Pequeña pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Sicilian Pizza", "Mediana pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("Griega Pizza", "Pequeña pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));
        dishes.add(new DishModel("California Pizza", "Mediana pizza", "https://sergeycodenameone.github.io/pizza-image.jpg", 4.60, createDemoAddOns()));

        return dishes;
    }


    private List<Entity> createDemoAddOns(){
        List addOns = new ArrayList();

        addOns.add(new DishAddOnModel("Champiñones", "https://sergeycodenameone.github.io/mushrooms-image.jpg", 4.0));
        addOns.add(new DishAddOnModel("tomate", "https://sergeycodenameone.github.io/tomato-image.jpg", 2.0));
        addOns.add(new DishAddOnModel("queso", "https://sergeycodenameone.github.io/cheese-image.jpg", 3.0));
        addOns.add(new DishAddOnModel("cebolla", "https://sergeycodenameone.github.io/onion-image.jpg", 1.0));

        return addOns;
    }

    private void initTheme() {
        String themeFileName = darkMode ? "/dark-theme" : "/theme";
        try {
            Resources theme = Resources.openLayered(themeFileName);
            UIManager.getInstance().addThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        }catch(IOException e){
            Log.e(e);
        }
        Form currForm = Display.getInstance().getCurrent();
        if (currForm != null) {
            currForm.refreshTheme();
        }
    }

    @Override
    public void init(Object context) {
        CN.setProperty("Component.revalidateOnStyleChange", "false");
        updateNetworkThreadCount(2);

        try {
            theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
            Resources.setGlobalResources(theme);
        }catch(IOException e){
            Log.e(e);
        }

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });
        dispatchEvent(new InitEvent(context));
    }

    public static boolean isDarkMode(){
        return darkMode;
    }

    @Override
    public void stop() {
        current = getCurrentForm();
        dispatchEvent(new StopEvent());
        System.out.println(current);
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }

    @Override
    public void start() {
        showCurrentForm();
        if (current == null){
            dispatchEvent(new StartEvent());
        }
    }

    @Override
    protected void showCurrentForm() {
        if (current != null) {
            current.show();
        }
    }
    
}

