/*
 * Copyright (c) 2013 Alexander Zagumennikov
 *
 * SOFTWARE NOTICE AND LICENSE
 *
 * This file is part of ZWave4J.
 *
 * ZWave4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ZWave4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ZWave4J.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.zwave4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zagumennikov
 */
public class Options {

    private static Options instance;

    public static synchronized Options create(String configPath, String userPath, String commandLine) {
        if (instance == null) {
            createNativeOptions(configPath, userPath, commandLine);
            instance = new Options();
        }
        return instance;
    }

    public static Options get() {
        return instance;
    }

    public static boolean destroy() {
        return destroyNativeOptions();
    }

    private static native void createNativeOptions(String configPath, String userPath, String commandLine);

    private static native boolean destroyNativeOptions();


    public native boolean lock();

    public native boolean addOptionBool(String name, boolean defaultValue);

    public native boolean addOptionInt(String name, int defaultValue);

    public native boolean addOptionString(String name, String defaultValue, boolean append);

    public native boolean getOptionAsBool(String name, AtomicReference<Boolean> value);

    public native boolean getOptionAsInt(String name, AtomicReference<Integer> value);

    public native boolean getOptionAsString(String name, AtomicReference<String> value);

    public native OptionType getOptionType(String name);

    public native boolean areLocked();
}
