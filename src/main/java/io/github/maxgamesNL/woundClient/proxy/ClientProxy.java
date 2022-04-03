package io.github.maxgamesNL.woundClient.proxy;

import io.github.maxgamesNL.woundClient.Commands.ToggleCommand;
import io.github.maxgamesNL.woundClient.Events.OnClick;
import io.github.maxgamesNL.woundClient.Events.RenderText;
import io.github.maxgamesNL.woundClient.Events.RenderTick;
import io.github.maxgamesNL.woundClient.Events.Tick;
import io.github.maxgamesNL.woundClient.modules.HUD.Coords;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {

    public static KeyBinding[] keyBindings;

    @Override
    public void registerRenders() {
        //MinecraftForge.EVENT_BUS.register(new CoordsHUD());
    }

    @Override
    public void registerEvents() {

        MinecraftForge.EVENT_BUS.register(new Tick());
        MinecraftForge.EVENT_BUS.register(new RenderTick());
        MinecraftForge.EVENT_BUS.register(new RenderText());
        MinecraftForge.EVENT_BUS.register(new OnClick());
    }

    @Override
    public void registerCommands() {
        ClientCommandHandler.instance.registerCommand(new ToggleCommand());

    }

    public void registerKeyBindings() {
        keyBindings = new KeyBinding[1];
        keyBindings[0] = new KeyBinding("Open ClickGUI", Keyboard.KEY_RSHIFT, "Wound Client");


        for(KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }
    }

}
