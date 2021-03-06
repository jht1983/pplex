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

import output.Output;

import controller.Data;
import lightshell.Command;
import model.LP;

public class ShowDual extends Command {
    protected String getName() { return "dual"; }
    protected String getShortHelp() { return "show the dual dictionary"; }
    protected String getUsage() { return "show dual"; }
    
    protected String getLongHelp() {
        return "print out a dual dictionary of the current linear program."
             + " For the primal, see the 'show primal' command.";
    }
    
    protected String execute(String arg) {
        if (arg != null) return "show dual: Command does not take any"
                              + "arguments.";
        LP lp = Data.getCurrentProgram();
        if (lp == null) return "show: No current linear program loaded.";
        return Output.dual(lp, Data.format);
    }
    
    @SuppressWarnings("serial")
    protected Set<String> getAliases() {
        return new HashSet<String>() {
            { 
                add("d");
            }
        };
    }
}
