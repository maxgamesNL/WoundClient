package io.github.maxgamesNL.woundClient.GUISHIT.comp;

import io.github.maxgamesNL.woundClient.Events.OnClick;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ClickGuiScreen extends GuiScreen {

    ArrayList<ModButton> modButtons = new ArrayList<ModButton>();

    @Override
    public void initGui() {
        super.initGui();
        this.modButtons.add(new ModButton(210, 60, 60, 20, ModuleRegistry.getInstance().getByName("Coords"), 11, 7));
        this.modButtons.add(new ModButton(300, 60, 60, 20, ModuleRegistry.getInstance().getByName("FPS"), 20, 7));
        this.modButtons.add(new ModButton(390, 60, 60, 20, ModuleRegistry.getInstance().getByName("CPS"), 20, 7));
        this.allowUserInput = true;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        ScaledResolution sr = new ScaledResolution(mc);
        super.drawScreen(mouseX, mouseY, partialTicks);

        Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight()-50, new Color(38, 38, 38,230).getRGB());

        for(ModButton m : modButtons){
            m.draw();
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        for(ModButton m : modButtons){
            m.onClick(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        ModuleRegistry.getInstance().getByName("ClickGUI").setEnabled(false);
    }
}
