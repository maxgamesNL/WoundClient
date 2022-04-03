package io.github.maxgamesNL.woundClient.Events;

import io.github.maxgamesNL.woundClient.modules.Module;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import io.github.maxgamesNL.woundClient.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

public class Tick {

    KeyBinding[] keyBindings = ClientProxy.keyBindings;

    @SubscribeEvent
    public void tick(net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent event) {

        keyBindings = ClientProxy.keyBindings;

        for (Module module : ModuleRegistry.getInstance().getAll()) {
            if (module.isEnabled()) {
                module.tick();
            }
        }

        if(Minecraft.getMinecraft().thePlayer != null) {
            if(keyBindings[0].isPressed()) {
                ModuleRegistry.getInstance().getByName("ClickGUI").toggle();
            }
        }
    }
}