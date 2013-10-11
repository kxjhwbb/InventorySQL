/**
 * Copyright (c) 2013 Exo-Network
 * 
 * This software is provided 'as-is', without any express or implied
 * warranty. In no event will the authors be held liable for any damages
 * arising from the use of this software.
 * 
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 * 
 *    1. The origin of this software must not be misrepresented; you must not
 *    claim that you wrote the original software. If you use this software
 *    in a product, an acknowledgment in the product documentation would be
 *    appreciated but is not required.
 * 
 *    2. Altered source versions must be plainly marked as such, and must not be
 *    misrepresented as being the original software.
 * 
 *    3. This notice may not be removed or altered from any source
 *    distribution.
 * 
 * manf                   info@manf.tk
 */

package tk.manf.InventorySQL;

import java.util.ArrayList;
import java.util.List;
import se.ranzdo.bukkit.methodcommand.CommandHandler;
import tk.manf.InventorySQL.commands.InvSQLCommand;

public class CommandManager {
    private final List<AbstractCommandHandler> commands;
    private CommandHandler handler;
    private InventorySQLPlugin plugin;
    
    public CommandManager() {
        commands = new ArrayList<AbstractCommandHandler>(1);
        commands.add(new InvSQLCommand());
    }

    public void initialise(InventorySQLPlugin plugin) {
        this.plugin = plugin;
        handler = new CommandHandler(plugin);
        for (AbstractCommandHandler command : commands) {
            command.initialise(handler);
            command.setCommandManager(this);
        }
    }
    
    public void disable() {
        this.plugin = null;
    }

    public InventorySQLPlugin getPlugin() {
        return plugin;
    }
}