package org.zwave4j;

import java.util.StringTokenizer;

/**
 * @author zagumennikov
 */
public class NativeLibraryLoader {

    public static final String WINDOWS_DIRECTORY_NAME = "windows";
    public static final String LINUX_DIRECTORY_NAME = "linux";
    public static final String SOLARIS_DIRECTORY_NAME = "solaris";
    public static final String MAC_OS_X_DIRECTORY_NAME = "mac_os_x";
    public static final String X86_DIRECTORY_NAME = "x86";
    public static final String AMD_64_DIRECTORY_NAME = "amd64";

    public static void loadLibrary(String libraryName) {
        String osName = System.getProperty("os.name");
        String architecture = System.getProperty("os.arch");
        String fileSeparator = System.getProperty("file.separator");

        StringBuilder libraryPath = new StringBuilder();

        if(osName.equals("Linux")){
            libraryPath.append(LINUX_DIRECTORY_NAME);
        } else if(osName.startsWith("Win")){
            libraryPath.append(WINDOWS_DIRECTORY_NAME);
        } else if(osName.equals("SunOS")){
            libraryPath.append(SOLARIS_DIRECTORY_NAME);
        } else if(osName.equals("Mac OS X")){
            libraryPath.append(MAC_OS_X_DIRECTORY_NAME);
        }

        libraryPath.append(fileSeparator);

        if(architecture.equals("i386") || architecture.equals("i686")){
            libraryPath.append(X86_DIRECTORY_NAME);
        } else if(architecture.equals("amd64")){
            libraryPath.append(AMD_64_DIRECTORY_NAME);
        }

        libraryPath.append(fileSeparator).append(System.mapLibraryName(libraryName));

        String[] nativeLibraryPaths = System.getProperty("java.library.path").split(";");
        for (String nativeLibraryPath : nativeLibraryPaths) {
            if (!nativeLibraryPath.endsWith(fileSeparator)) {
                nativeLibraryPath = nativeLibraryPath + fileSeparator;
            }
            try {
                System.load(nativeLibraryPath + libraryPath.toString());
                break;
            } catch (UnsatisfiedLinkError ignored) {
            }
        }

    }
}
