package io.github.maxgamesNL.woundClient.modules;


import io.github.maxgamesNL.woundClient.modules.GUI.ClickGUI;
import io.github.maxgamesNL.woundClient.modules.HUD.*;
import io.github.maxgamesNL.woundClient.modules.Trolling.Emo;
import io.github.maxgamesNL.woundClient.modules.catagories.GUI;
import io.github.maxgamesNL.woundClient.modules.catagories.HUD;
import io.github.maxgamesNL.woundClient.modules.catagories.Movement;
import io.github.maxgamesNL.woundClient.modules.catagories.Trolling;

import java.util.ArrayList;
import java.util.List;

public class ModuleRegistry {



    private static ModuleRegistry INSTANCE = null;
    List<Module> MODULES = new ArrayList<Module>();
    List<Category> CATEGORIES = new ArrayList<Category>();
    public ModuleRegistry(){
        if(INSTANCE != null){
            throw new IllegalStateException("Module registry already exists");
        }
        INSTANCE = this;
        registerCategories();
        registerModules();
    }

    void register(Module module){
        MODULES.add(module);
    }

    void registerCategories(){

        CATEGORIES.add(new Movement());
        CATEGORIES.add(new HUD());
        CATEGORIES.add(new Trolling());
        CATEGORIES.add(new GUI());

    }

    void registerModules(){
        //use register(new [classname]()); to register a module
        register(new Coords());
        register(new FPS());
        register(new CPS());
        register(new Yaw());
        register(new Pitch());

        //Util

        register(new Emo());

        //Gui
        register(new ClickGUI());
    }

    public Module getByName(String name){
        for (Module module : MODULES){
            if (module.getName().equalsIgnoreCase(name)) return module;
        }
        return null;
    }

    public Category getCategoryByName(String name){
        for (Category category : CATEGORIES){
            if (category.getName().equalsIgnoreCase(name)) return category;
        }
        return null;
    }

    public static ModuleRegistry getInstance(){
        if (INSTANCE == null) new ModuleRegistry();
        return INSTANCE;
    }

    public List<Module> getAll(){
        return MODULES;
    }

    public List<Category> getCATEGORIES(){return CATEGORIES;}



}

