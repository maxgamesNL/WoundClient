package io.github.maxgamesNL.woundClient.modules.HUD;

import io.github.maxgamesNL.woundClient.modules.Category;
import io.github.maxgamesNL.woundClient.modules.Module;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.awt.*;

public class Yaw extends Module {

    Minecraft mc;
    int YawX = 10;
    int YawY = 80;
    public Yaw() {
        super("Yaw", ModuleRegistry.getInstance().getCategoryByName("HUD"), "Shows your yaw");
    }

    @Override
    protected void enable() {

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {
        mc = Minecraft.getMinecraft();
        if(mc.thePlayer.rotationYaw >= 360 || mc.thePlayer.rotationYaw <= -360) {
            mc.thePlayer.rotationYaw = 1;
        }
    }

    @Override
    public void renderHud(RenderGameOverlayEvent.Post e) {
        mc = Minecraft.getMinecraft();
        Gui.drawRect(YawX, YawY, YawX + 60, YawY + 20, 0x80000000);
        mc.fontRendererObj.drawStringWithShadow("Yaw: " + (int)mc.thePlayer.rotationYaw, YawX + 4, YawY + 6, new Color(255, 255, 255, 255).getRGB());
    }

    @Override
    public void renderText(RenderGameOverlayEvent.Text e) {

    }

    @Override
    public void onClick(MouseEvent e) {

    }
}
