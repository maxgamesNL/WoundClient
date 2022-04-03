package io.github.maxgamesNL.woundClient.modules.HUD;

import io.github.maxgamesNL.woundClient.modules.Category;
import io.github.maxgamesNL.woundClient.modules.Module;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

import static net.minecraft.client.gui.Gui.drawModalRectWithCustomSizedTexture;
import static net.minecraft.client.gui.Gui.drawRect;
import static org.lwjgl.opengl.GL11.*;

public class FPS extends Module {

    Minecraft mc = Minecraft.getMinecraft();


    public FPS() {
        super("FPS", ModuleRegistry.getInstance().getCategoryByName("HUD"), "Shows the FPS");
    }

    public int FPSCounterx = 10;
    public int FPSCountery = 20;

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
        Gui.drawRect(FPSCounterx, FPSCountery, FPSCounterx + 50, FPSCountery + 19, 0x80000000);
        mc.fontRendererObj.drawStringWithShadow("FPS: " + mc.debug.split(" ")[0], FPSCounterx + 4, FPSCountery + 6, 0xFFFFFFFF);

    }

    @Override
    public void renderText(RenderGameOverlayEvent.Text e) {

    }

    @Override
    public void onClick(MouseEvent e) {

    }
}
