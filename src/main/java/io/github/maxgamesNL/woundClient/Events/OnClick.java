package io.github.maxgamesNL.woundClient.Events;

import io.github.maxgamesNL.woundClient.modules.Module;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OnClick {

    @SubscribeEvent
    public void onClick(net.minecraftforge.client.event.MouseEvent event) {
        for (Module module : ModuleRegistry.getInstance().getAll()) {
            if (module.isEnabled()) {
                module.onClick(event);
            }
        }
    }
}
