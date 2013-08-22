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

import java.io.*;

/**
 * @author zagumennikov
 */
public class NativeLibraryLoader {

    public static final String NATIVE_LIBS_DIRECTORY_NAME = "native_libs";
    public static final String WINDOWS_DIRECTORY_NAME = "windows";
    public static final String LINUX_DIRECTORY_NAME = "linux";
    public static final String SOLARIS_DIRECTORY_NAME = "solaris";
    public static final String OS_X_DIRECTORY_NAME = "os_x";
    public static final String X86_DIRECTORY_NAME = "x86";
    public static final String AMD_64_DIRECTORY_NAME = "amd64";

    private static final String TEMP_FILE_PREFIX = "native-lib-";

    public static void loadLibrary(String libraryName, Class clazz) {
        String libraryPath = getLibraryPath(libraryName);

        File tempLibraryFile;
        try (InputStream libraryStream = clazz != null ? clazz.getResourceAsStream(libraryPath) : ClassLoader.getSystemResourceAsStream(libraryPath)) {
            if (libraryStream == null) {
                throw new RuntimeException(String.format("Library not found %s", libraryPath));
            }

            tempLibraryFile = File.createTempFile(TEMP_FILE_PREFIX, null);
            tempLibraryFile.deleteOnExit();

            try (OutputStream tempLibraryStream = new FileOutputStream(tempLibraryFile)) {
                int len;
                byte[] buffer = new byte[8192];
                while ((len = libraryStream.read(buffer)) > -1) {
                    tempLibraryStream.write(buffer, 0, len);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.load(tempLibraryFile.getAbsolutePath());

        //noinspection ResultOfMethodCallIgnored
        tempLibraryFile.delete();
    }

    private static String getLibraryPath(String libraryName) {
        StringBuilder libraryPathBuilder = new StringBuilder("/" + NATIVE_LIBS_DIRECTORY_NAME + "/");

        String osName = System.getProperty("os.name");
        if (isLinux(osName)) {
            libraryPathBuilder.append(LINUX_DIRECTORY_NAME);
        } else if (isWindows(osName)) {
            libraryPathBuilder.append(WINDOWS_DIRECTORY_NAME);
        } else if (isSunOS(osName)) {
            libraryPathBuilder.append(SOLARIS_DIRECTORY_NAME);
        } else if (isOSX(osName)) {
            libraryPathBuilder.append(OS_X_DIRECTORY_NAME);
        }

        libraryPathBuilder.append('/');

        String architecture = System.getProperty("os.arch");
        if (isX86(architecture)) {
            libraryPathBuilder.append(X86_DIRECTORY_NAME);
        } else if (isAmd64(architecture)) {
            libraryPathBuilder.append(AMD_64_DIRECTORY_NAME);
        }

        libraryPathBuilder.append('/').append(System.mapLibraryName(libraryName));
        return libraryPathBuilder.toString();
    }

    private static boolean isLinux(String osName) {
        return osName.equals("Linux");
    }

    private static boolean isWindows(String osName) {
        return osName.startsWith("Windows");
    }

    private static boolean isSunOS(String osName) {
        return osName.equals("SunOS");
    }

    private static boolean isOSX(String osName) {
        return osName.endsWith("OS X");
    }

    private static boolean isX86(String architecture) {
        return architecture.endsWith("86");
    }

    private static boolean isAmd64(String architecture) {
        return architecture.equals("amd64");
    }
}
