package io.github.maxgamesNL.woundClient.Events;

import io.github.maxgamesNL.woundClient.modules.Module;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderTick {

    Minecraft mc = Minecraft.getMinecraft();


    @SubscribeEvent
    public void onHudRender(RenderGameOverlayEvent.Post e) {
        if(e.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS) {
            for (Module module : ModuleRegistry.getInstance().getAll()) {
                if (module.isEnabled()) {
                    module.renderHud(e);
                }
            }
        }

    }

}
