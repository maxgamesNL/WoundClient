package io.github.maxgamesNL.woundClient.modules.HUD;

import io.github.maxgamesNL.woundClient.modules.Module;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.Display;

public class Coords extends Module {

    Minecraft mc = Minecraft.getMinecraft();
    int width;


    public Coords() {
        super("Coords", ModuleRegistry.getInstance().getCategoryByName("HUD"), "Shows your coords on screen");
    }

    @Override
    protected void enable() {

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {


    }

    @Override
    public void renderHud(RenderGameOverlayEvent.Post e) {

        width = Display.getWidth();
        GlStateManager.scale(1.2, 1.2, 1.2);

        if(mc.fontRendererObj.getStringWidth("X: " + Math.round(mc.thePlayer.posX)) >= mc.fontRendererObj.getStringWidth("Y: " + Math.round(mc.thePlayer.posY)) && mc.fontRendererObj.getStringWidth("X: " + Math.round(mc.thePlayer.posX)) >= mc.fontRendererObj.getStringWidth("Z: " + Math.round(mc.thePlayer.posZ))) {
            Gui.drawRect(Math.round((float)Display.getWidth()/2.4f - mc.fontRendererObj.getStringWidth("X: " + Math.round(mc.thePlayer.posX)))-5, 2, Math.round((float)Display.getWidth()/2.4f), 35, 0x80000000);
        }else if(mc.fontRendererObj.getStringWidth("Y: " + Math.round(mc.thePlayer.posY)) >= mc.fontRendererObj.getStringWidth("X: " + Math.round(mc.thePlayer.posX)) && mc.fontRendererObj.getStringWidth("Y: " + Math.round(mc.thePlayer.posY)) >= mc.fontRendererObj.getStringWidth("Z: " + Math.round(mc.thePlayer.posZ))) {
            Gui.drawRect(Math.round((float)Display.getWidth()/2.4f - mc.fontRendererObj.getStringWidth("Y: " + Math.round(mc.thePlayer.posY)))-5, 2, Math.round((float)Display.getWidth()/2.4f), 35, 0x80000000);
        }else if(mc.fontRendererObj.getStringWidth("Z: " + Math.round(mc.thePlayer.posZ)) >= mc.fontRendererObj.getStringWidth("Y: " + Math.round(mc.thePlayer.posY)) && mc.fontRendererObj.getStringWidth("Z: " + Math.round(mc.thePlayer.posZ)) >= mc.fontRendererObj.getStringWidth("X: " + Math.round(mc.thePlayer.posX))) {
            Gui.drawRect(Math.round((float)Display.getWidth()/2.4f - mc.fontRendererObj.getStringWidth("Z: " + Math.round(mc.thePlayer.posZ))) -5, 2, Math.round((float) Display.getWidth() / 2.4f), 35, 0x80000000);
        }
        mc.fontRendererObj.drawStringWithShadow("X: " + Math.round(mc.thePlayer.posX), (float)Display.getWidth()/2.4f - mc.fontRendererObj.getStringWidth("X: " + Math.round(mc.thePlayer.posX)) - 1, 5, 0xFFFFFF);
        mc.fontRendererObj.drawStringWithShadow("Y: " + Math.round(mc.thePlayer.posY), (float)Display.getWidth()/2.4f - mc.fontRendererObj.getStringWidth("Y: " + Math.round(mc.thePlayer.posY)) - 1, 15, 0xFFFFFF);
        mc.fontRendererObj.drawStringWithShadow("Z: " + Math.round(mc.thePlayer.posZ), (float)Display.getWidth()/2.4f - mc.fontRendererObj.getStringWidth("Z: " + Math.round(mc.thePlayer.posZ)) - 1, 25, 0xFFFFFF);



        GlStateManager.scale(1/1.2, 1/1.2, 1/1.2);
    }

    @Override
    public void renderText(RenderGameOverlayEvent.Text e) {

    }

    @Override
    public void onClick(MouseEvent e) {

    }
}
