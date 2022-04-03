package io.github.maxgamesNL.woundClient;

import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import io.github.maxgamesNL.woundClient.proxy.ClientProxy;
import io.github.maxgamesNL.woundClient.proxy.CommonProxy;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;



@Mod(modid = WoundClient.MODID, version = WoundClient.VERSION)
public class WoundClient {
    public static final String MODID = "woundclient";
    public static final String VERSION = "0.1.0";
    public static final String NAME = "Wound Client";
    public static final String SERVER_PROXY_CLASS = "io.github.maxgamesNL.woundClient.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "io.github.maxgamesNL.woundClient.proxy.ClientProxy";




    @SidedProxy(clientSide = WoundClient.CLIENT_PROXY_CLASS, serverSide = WoundClient.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    public static ClientProxy clientProxy;


    @Mod.Instance(WoundClient.MODID)
    public static WoundClient instance;
    public static ModuleRegistry moduleRegistry = ModuleRegistry.getInstance();



    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);






        proxy.registerRenders();
        proxy.registerEvents();
        proxy.registerCommands();
        proxy.registerKeyBindings();




        Display.setTitle("Wound Client");
    }



}

