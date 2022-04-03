package io.github.maxgamesNL.woundClient.modules.Trolling;

import io.github.maxgamesNL.woundClient.modules.Category;
import io.github.maxgamesNL.woundClient.modules.Module;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import static net.minecraft.client.gui.Gui.drawModalRectWithCustomSizedTexture;

public class Emo extends Module {

    Minecraft mc = Minecraft.getMinecraft();
    private final ResourceLocation emo = new ResourceLocation("woundClient", "Remedy.PNG");
    public Emo() {
        super("Emo", ModuleRegistry.getInstance().getCategoryByName("Trolling"), "Shows that you are emo");
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
        mc.renderEngine.bindTexture(emo);
        drawModalRectWithCustomSizedTexture(0, 0, 0, 0, 100, 100, 100, 100);
    }

    @Override
    public void renderText(RenderGameOverlayEvent.Text e) {

    }

    @Override
    public void onClick(MouseEvent e) {

    }
}
