package io.github.maxgamesNL.woundClient.modules.HUD;

import io.github.maxgamesNL.woundClient.modules.Category;
import io.github.maxgamesNL.woundClient.modules.Module;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class CPS extends Module {

    public CPS() {
        super("CPS", ModuleRegistry.getInstance().getCategoryByName("HUD"), "Shows your current CPS");
    }

    Minecraft mc = Minecraft.getMinecraft();

    public int CPSCounterX = 10;
    public int CPSCounterY = 50;
    int CPSCounterLeft = 0;
    int CPSCounterRight = 0;
    int LastCPSCounterLeft = 0;
    int LastCPSCounterRight = 0;
    int every20thTick = 0;

    @Override
    protected void enable() {

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {
        every20thTick++;
        if(every20thTick >= 20) {
            LastCPSCounterLeft = CPSCounterLeft;
            LastCPSCounterRight = CPSCounterRight ;
            CPSCounterLeft = 0;
            CPSCounterRight = 0;
            every20thTick = 0;
        }

    }

    @Override
    public void renderHud(RenderGameOverlayEvent.Post e) {
        Gui.drawRect(CPSCounterX, CPSCounterY, CPSCounterX + 50, CPSCounterY + 19, 0x80000000);
        mc.fontRendererObj.drawStringWithShadow("CPS: " + LastCPSCounterLeft + ", "+ LastCPSCounterRight, CPSCounterX + 4, CPSCounterY + 6, 0xFFFFFFFF);
        //get click per second on left mouse button


    }

    @Override
    public void renderText(RenderGameOverlayEvent.Text e) {

    }

    @Override
    public void onClick(MouseEvent e) {
        if(e.button == 0) {
            CPSCounterLeft++;
        }else if(e.button == 1) {
            CPSCounterRight++;
        }
    }
}
