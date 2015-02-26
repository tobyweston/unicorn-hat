# Compiling the C Libraries

## Raspberry Pi rpi-ws281x Library

A fix for the Pi 2 came from [richardghirst/rpi_ws281x](https://github.com/richardghirst/rpi_ws281x). This project uses it (and another C library, see below) to drive the LEDs. You need to compile the C on the Pi and generate the shared objects (`.so`).

If you need to, use [SWIG](http://www.swig.org/) to generate the JNI bindings;

    cd src/main/c/rpi-ws281x/
    swig -java -package bad.robot.unicorn.neopixel.ws2811 rpi_ws281x.i

Follow these steps to build it.

    cd src/main/c/rpi-ws281x/lib
    make lib

That will create `.o` and `.a` files in the `lib` folder. Then use the `Makefile` one level up to compile the Java wrapper and create the `.so` file (this actually calls into the `lib/Makefile` so that's why the previous step is optional).

    cd src/main/c/rpi-ws281x/
    make build

Look for the generated `.so` file and remove any `.o` files.


## Raspberry Pi ws2812 Library

The library uses ws2812 as the underlying driver. It's a C library from [626Pilot/RaspberryPi-NeoPixel-WS2812](https://github.com/626Pilot/RaspberryPi-NeoPixel-WS2812), although I've taken the modified version from [pimoroni/unicorn-hat](https://github.com/pimoroni/unicorn-hat)

Use [SWIG](http://www.swig.org/) to generate the JNI bindings (manually targeting the Pi 2 only);

    cd src/main/c/ws2812/lib
    swig -java -package bad.robot.unicorn.neopixel.ws2812 ws2812-RPi.i

Compile the `.o` files.

    gcc -fPIC -c ws2812-RPi.c ws2812-RPi_wrap.c -DPERI_BASE=0x3F000000 -DRPI2 -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include/linux

Compile the shared object.

    gcc -shared ws2812-RPi.o ws2812-RPi_wrap.o -o libws2812-RPi.so

or do it all via the `src/main/c/ws2812/lib/Makefile` (which will also build the Pi B+ version rather than the just the Pi 2 version).

    cd src/main/c/ws2812/lib
    make swig_prep
    make shared


# Setting LD_LIBRARY_PATH in Maven

Setting the `LD_LIBRARY_PATH` in the pom means you should be able to run the hardware tests directly with `mvn failsafe:integration-tests` and blinky lights will blink on the physical HAT. You need to run `sudo mvn` though.

    <environmentVariables>
        <LD_LIBRARY_PATH>${project.basedir}/src/main/c/ws2812</LD_LIBRARY_PATH>
    </environmentVariables>

As a reminder to myself; Environment variables are OS settings available via `System.getenv()`. For example, set using `export FOO=xxx` for example. System properties are set using `-D` on the command line and are available via `System.getProperties()`. For example, `java.library.path`. They can be set at runtime using `System.setProperty`.


Running from the shell, something like this should work.

    sudo java -cp target/test-classes:target/classes/ -Djava.library.path=/home/pi/dev/unicorn-hat-java/src/main/c/ws2812 bad.robot.unicorn.integration.BasicIntegrationTest

If you see an error like this,

    Exception in thread "main" java.lang.UnsatisfiedLinkError: no ws2812-RPi in java.library.path