/*
 * Copyright (C) 2012, 2013 Andreas Halle
 *
 * This file is part of pplex.
 *
 * pplex is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * pplex is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public license
 * along with pplex. If not, see <http://www.gnu.org/licenses/>.
 */
package controller.shellcommands;

import java.util.HashSet;
import java.util.Set;

import lightshell.Command;

public class Exit extends Command {
    @SuppressWarnings("serial")
    protected Set<String> getAliases() {
        return new HashSet<String>() {
            { 
                add("q");
                add("quit");
            }
        };
    }
    protected String getName() { return "exit"; }
    
    protected String getShortHelp() {
        return "quit the program (q and quit do the same)";
    }
    
    protected String getUsage() { return "exit"; }
    
    protected String execute(String arg) {
        if (arg != null) return "exit: Command does not take any arguments.";
        System.exit(0);
        return null;
    }
}
