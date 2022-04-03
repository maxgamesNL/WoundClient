package io.github.maxgamesNL.woundClient.modules;

import net.minecraftforge.client.event.RenderGameOverlayEvent;

public abstract class Module {
    boolean isEnabled = false;
    String name ,description;
    Category category;
    int key;
    public Module(String name, Category category, String description){
        this.name = name;
        this.category = category;
        this.key = 0;
        this.description = description;
    }
    protected abstract void enable();
    protected abstract void disable();
    public abstract void tick();
    public abstract void renderHud(RenderGameOverlayEvent.Post e);
    public abstract void renderText(RenderGameOverlayEvent.Text e);
    public abstract void onClick(net.minecraftforge.client.event.MouseEvent e);

    public String getDescription(){
        return description;
    }
    public String getName(){
        return name;
    }
    public Category getCategory(){
        return category;
    }
    public boolean isEnabled(){
        return isEnabled;}

    public void setKey(int key){
        this.key = key;
    }

    public void toggle(){
        if(isEnabled){
            disable();
            isEnabled = false;
        }else{
            enable();
            isEnabled = true;
        }
    }


    public void setEnabled(boolean enabled){
        if(enabled) enable();
        else disable();
        this.isEnabled = enabled;
    }

}
