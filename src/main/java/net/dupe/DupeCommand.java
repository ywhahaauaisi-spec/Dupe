package net.dupe;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import com.mojang.brigadier.CommandDispatcher;

public class DupeCommand {
    
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            registerDupeCommand(dispatcher);
        });
    }
    
    private static void registerDupeCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
            net.minecraft.server.command.CommandManager.literal("dupe")
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    if (player == null) {
                        context.getSource().sendError(Text.literal("Only players can use this command!"));
                        return 0;
                    }
                    
                    ItemStack heldItem = player.getMainHandStack();
                    
                    if (heldItem.isEmpty()) {
                        player.sendMessage(Text.literal("§cYou're not holding anything!"), false);
                        return 0;
                    }
                    
                    // Deep clone the item
                    ItemStack duplicate = heldItem.copy();
                    
                    // Add to inventory or drop if full
                    if (!player.getInventory().insertStack(duplicate)) {
                        player.dropItem(duplicate, false);
                    }
                    
                    player.sendMessage(
                        Text.literal("§a✓ Duplicated: " + heldItem.getName().getString()),
                        false
                    );
                    
                    return 1;
                })
        );
    }
}
