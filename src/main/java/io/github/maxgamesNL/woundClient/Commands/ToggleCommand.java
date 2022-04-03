package io.github.maxgamesNL.woundClient.Commands;

import io.github.maxgamesNL.woundClient.WoundClient;
import io.github.maxgamesNL.woundClient.modules.ModuleRegistry;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class ToggleCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "toggle";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {
            sender.addChatMessage(new ChatComponentText("Usage: /toggle <module>"));
        }else {
            String mod = args[0];
            if (ModuleRegistry.getInstance().getByName(mod) != null) {
                sender.addChatMessage(new ChatComponentText("Toggled " + mod+" to " + !ModuleRegistry.getInstance().getByName(mod).isEnabled()));
                ModuleRegistry.getInstance().getByName(mod).toggle();
            }else {
                sender.addChatMessage(new ChatComponentText("Module not found!"));
            }

        }

    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }


}