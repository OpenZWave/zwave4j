## ZWave4J
ZWave4J - java wrapper for [OpenZWave](https://github.com/OpenZWave/open-zwave) library.

The goal is to provide to java the same API as OpenZWave has.
Besides the wrapper ZWave4J has a simple executable `Main` class which demonstrates how to work with ZWave4J.

Supported platforms:

* Windows: x86, amd64
* Linux: x86, amd64, arm
* OS X: x86, amd64

## Usage

You can download the latest ZWave4J release from [GitHub](https://github.com/zgmnkv/zwave4j/releases)
or from [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22zwave4j%22),
or unstable snapshot from [sonatype](https://oss.sonatype.org/content/repositories/snapshots/com/github/zgmnkv/zwave4j/).

To execute sample `Main` class, run:

```java -cp zwave4j-X.jar org.zwave4j.Main "open-zwave/config" "/dev/ttyUSB0"```

* First argument is path to OpenZWave configuration directory.
* Second argument is path to serial device, which Z-Wave controller is connected to, e.g. `/dev/ttyUSB0` for Linux or `//./COM1` for Windows.

## Build

### Requirements

1. [JDK 1.7+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. GCC ([MinGW for Windows](https://sourceforge.net/projects/mingwbuilds/))
3. [OpenZWave sources](https://github.com/OpenZWave/open-zwave)

### Build configuration

1. Copy `example.gradle.properties` into `gradle.properties`.
2. Edit properties in `gradle.properties`:
  * `openZWaveDir` - path to OpenZWave library source directory, needed compile.
  * `openZWaveConfigDir` - path to OpenZWave configuration directory, needed for OpenZWave library in runtime.
  * `zWaveControllerPort` - path to serial device, which Z-Wave controller is connected to.

### Build

Run `./gradlew build` (`gradlew build` for Windows) in console.
It will compile native JNI binaries and java classes, assemble `jar` archive and put it into `build/libs` directory.
Native binaries for platforms supported by your host will be built.
To include native binaries for other platforms into compiled `jar`, put `native_libs` directory from other ZWave4J `jar`s in the project root directory.

### After build

If you have built a library from sources, you can use several options:

* Run `./gradlew install` to install library into local maven repository for using ZWave4J as a library in your other projects.
* Run `./gradlew run` in console. It will execute sample `Main` class.
* Run `./gradlew installApp` to install application with start scripts into `build/install/zwave4j`, then you can start it manually from `build/install/zwave4j/bin`:
  ```zwave4j.bat "open-zwave/config" "/dev/ttyUSB0"```
* Execute ZWave4J `Main` class manually from `build/libs` directory:
  ```java -cp zwave4j-X.jar org.zwave4j.Main "open-zwave/config" "/dev/ttyUSB0"```

## Development

You can generate [IntelliJ IDEA](https://www.jetbrains.com/idea/) project files running `./gradlew idea` task.
You can use [C/C++ plugin](https://plugins.jetbrains.com/plugin/?id=1373) to work with native sources.
