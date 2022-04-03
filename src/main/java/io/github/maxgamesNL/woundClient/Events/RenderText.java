package io.github.maxgamesNL.woundClient.Events;

import io.github.maxgamesNL.woundClient.modules.Module;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderText {

    @SubscribeEvent
    public void render(net.minecraftforge.client.event.RenderGameOverlayEvent.Text e) {
        for(Module module : ModuleRegistry.getInstance().getAll()) {
            if(module.isEnabled()) {
                module.renderText(e);
            }
        }

    }
}
