package io.github.maxgamesNL.woundClient.modules.HUD;


import io.github.maxgamesNL.woundClient.modules.Module;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.awt.*;

public class Pitch extends Module {

    Minecraft mc;
    int PitchX = 10;
    int PitchY = 101;
    public Pitch() {
        super("Pitch", ModuleRegistry.getInstance().getCategoryByName("HUD"), "Shows the pitch");
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
        if (mc.thePlayer.rotationPitch >= 360 || mc.thePlayer.rotationPitch <= -360) {
            mc.thePlayer.rotationPitch = 1;
        }

    }

    @Override
    public void renderHud(RenderGameOverlayEvent.Post e) {
        mc = Minecraft.getMinecraft();
        Gui.drawRect(PitchX, PitchY, PitchX + 70, PitchY + 20, 0x80000000);
        mc.fontRendererObj.drawStringWithShadow("Pitch: " + (int)mc.thePlayer.rotationPitch, PitchX + 4, PitchY + 6, new Color(255, 255, 255, 255).getRGB());
    }

    @Override
    public void renderText(RenderGameOverlayEvent.Text e) {

    }

    @Override
    public void onClick(MouseEvent e) {

    }
}
