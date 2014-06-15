## ZWave4J
ZWave4J - java wrapper for [OpenZWave](https://code.google.com/p/open-zwave) library.

The goal is to provide to java the same API as OpenZWave has.
Besides the wrapper ZWave4J has a simple executable `Main` class which demonstrates how to work with ZWave4J.

Supported platforms:

* Windows: x86, amd64
* Linux: x86, amd64, arm
* OS X: x86, amd64

## Usage

You can download the latest ZWave4J release from [GitHub](https://github.com/zgmnkv/zwave4j/releases) or from [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22zwave4j%22).
Library contains native binaries for windows and linux os, x86 and amd64 architecture.

To execute sample `Main` class, run:
```java -cp zwave4j-X.jar org.zwave4j.Main "C:/open-zwave/config" "//./COM1"```

## Build

### Requirements

1. [JDK 1.7+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. GCC ([MinGW for Windows](http://sourceforge.net/projects/mingwbuilds/))
3. [OpenZWave sources](https://code.google.com/p/open-zwave)

### Preparations

1. Copy `example.gradle.properties` into `gradle.properties`.
2. Edit properties in `gradle.properties`:
  * `openZWaveDir` - path to OpenZWave library source directory, needed compile.
  * `openZWaveConfigDir` - path to OpenZWave devices configurations directory, needed for OpenZWave library in runtime.
  * `zWaveControllerPort` - path to serial device, which Z-Wave controller is connected to, e.g. `//./COM1` for Windows or `/dev/ttyUSB0` for Linux.

### Build

Run `gradlew build` in console. It will compile native JNI binaries and java classes, assemble `jar` archive and put it into `build/libs` directory.
Native binaries for platforms supported by your host will be built.
To include native binaries for other platforms into compiled `jar`, put `native_libs` directory from other ZWave4J `jar`s in the project root directory.

### After build

If you have built your version of library from sources, you can use several options:

* Run `gradlew install` to install library into local maven repository for using ZWave4J as a library in your other projects.
* Run `gradlew run` in console. It will execute sample `Main` class.
* Run `gradlew installApp` to install application with start scripts into `build/install/zwave4j`, then you can start it manually from `build/install/zwave4j/bin`:
  ```zwave4j.bat "C:/open-zwave/config" "//./COM1"```
* Execute ZWave4J `Main` class manually from `build/libs` directory:
  ```java -cp zwave4j-X.jar org.zwave4j.Main "C:/open-zwave/config" "//./COM1"```

## Development

You can generate [IntelliJ IDEA](http://www.jetbrains.com/idea/) project files running `gradlew idea` task.
You can use [C/C++ plugin](http://plugins.jetbrains.com/plugin/?id=1373) to work with native sources.
