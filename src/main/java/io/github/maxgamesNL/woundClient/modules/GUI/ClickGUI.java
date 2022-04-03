package io.github.maxgamesNL.woundClient.modules.GUI;

import io.github.maxgamesNL.woundClient.GUISHIT.comp.ClickGuiScreen;
import io.github.maxgamesNL.woundClient.modules.Category;
import io.github.maxgamesNL.woundClient.modules.Module;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import io.github.maxgamesNL.woundClient.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class ClickGUI extends Module {
    Minecraft mc = Minecraft.getMinecraft();
    //this big bunda coderboy helped me so much! https://www.youtube.com/watch?v=SR_NAVTTD5o



    public ClickGUI() {
        super("ClickGUI", ModuleRegistry.getInstance().getCategoryByName("GUI"), "Opens the ClickGUI");
    }

    @Override
    protected void enable() {
        mc.displayGuiScreen(new ClickGuiScreen());
    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void renderHud(RenderGameOverlayEvent.Post e) {


    }

    @Override
    public void renderText(RenderGameOverlayEvent.Text e) {

    }

    @Override
    public void onClick(MouseEvent e) {

    }
}
