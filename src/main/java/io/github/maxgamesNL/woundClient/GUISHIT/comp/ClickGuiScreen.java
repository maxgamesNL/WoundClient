package io.github.maxgamesNL.woundClient.GUISHIT.comp;

import io.github.maxgamesNL.woundClient.Events.OnClick;
import io.github.maxgamesNL.woundClient.modules.HUD.Pitch;
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


        this.modButtons.add(new ModButton(210, 100, 60, 20, ModuleRegistry.getInstance().getByName("Coords"), 11, 7));
        this.modButtons.add(new ModButton(300, 100, 60, 20, ModuleRegistry.getInstance().getByName("FPS"), 20, 7));
        this.modButtons.add(new ModButton(390, 100, 60, 20, ModuleRegistry.getInstance().getByName("CPS"), 20, 7));
        this.modButtons.add(new ModButton(480, 100, 60, 20, ModuleRegistry.getInstance().getByName("Yaw"), 20, 7));
        this.modButtons.add(new ModButton(570, 100, 60, 20, ModuleRegistry.getInstance().getByName("Pitch"), 20, 7));


        this.modButtons.add(new ModButton(210, 130, 60, 20, ModuleRegistry.getInstance().getByName("Emo"),20, 7 ));
        this.allowUserInput = true;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        ScaledResolution sr = new ScaledResolution(mc);
        super.drawScreen(mouseX, mouseY, partialTicks);

        Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight()-50, new Color(38, 38, 38,230).getRGB());
        Gui.drawRect(210, 80, sr.getScaledWidth() - 210, 82, new Color(255, 255, 200,255).getRGB());
        mc.fontRendererObj.drawString("HUDS", (sr.getScaledWidth() / 2) - (mc.fontRendererObj.getStringWidth("HUDS") / 2), 70, new Color(255, 255, 255,255).getRGB());
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
