package io.github.maxgamesNL.woundClient.GUISHIT.comp;

import io.github.maxgamesNL.woundClient.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import scala.collection.parallel.ParIterableLike;

import java.awt.*;

public class ModButton {

    public int x, y, w, h, textOffsetX, textOffsetY;
    public Module m;

    public ModButton(int x, int y, int w, int h, Module mod, int textOffsetX, int textOffsetY){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.m = mod;
        this.textOffsetX = textOffsetX;
        this.textOffsetY = textOffsetY;

    }

    public void draw(){
        Gui.drawRect(x, y, x+w, y+h, getColor());
        Minecraft.getMinecraft().fontRendererObj.drawString(m.getName(), x + textOffsetX, y+textOffsetY, getTextColor());
    }

    public int getColor(){
        if (m.isEnabled()){
            return new Color(255, 85, 85, 255).getRGB();
        }else {
            return new Color(0, 0, 0, 255).getRGB();
        }
    }

    public int getTextColor(){
        if (m.isEnabled()){
            return new Color(0, 0, 0, 255).getRGB();
        }else {
            return new Color(255, 255, 255, 255).getRGB();
        }
    }

    public void onClick(int mouseX, int mouseY, int button){
        if(mouseX >= x && mouseX <=  x+w && mouseY >= y && mouseY <= y + h){
            m.toggle();
            System.out.println(m.getName() + " was toggled");
        }
    }
}
