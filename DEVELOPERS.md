## Raspberry Pi ws2812 Library

The library uses ws2812 as the underlying driver. It's a C library from [626Pilot/RaspberryPi-NeoPixel-WS2812](https://github.com/626Pilot/RaspberryPi-NeoPixel-WS2812), although I've taken the modified version from [pimoroni/unicorn-hat](https://github.com/pimoroni/unicorn-hat)

Use [SWIG](http://www.swig.org/) to generate the JNI bindings;

    cd ws2812
    swig -java ws2812-RPi.i

Compile the `.o` files.

    gcc -fpic -c ws2812-RPi.c ws2812-RPi_wrap.c -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include/linux

Compile the shared object.

    gcc -shared ws2812-RPi.o ws2812-RPi_wrap.o -o libws2812-RPi.so


## Setting LD_LIBRARY_PATH in Maven

As hinted at [here](http://docs.codehaus.org/display/MAVENUSER/Projects+With+JNI), setting the following doesn't seem to work for the failsafe plugin.

    <environmentVariables>
        <LD_LIBRARY_PATH>ws2812</LD_LIBRARY_PATH>
    </environmentVariables>

Copying the `.so` file directly into `/usr/lib` doesn't seem to work.

Untested:

    <systemPropertyVariables>
        <LD_LIBRARY_PATH>${project.basedir}/ws2812/swig_example</LD_LIBRARY_PATH>
    </systemPropertyVariables>

Environment variables are OS settings available via `System.getenv()`. For example, set using `export FOO=xxx` for example.

System properties are set using `-D` on the command line and are available via `System.getProperties()`. For example, `java.library.path`. They can be set at runtime using `System.setProperty`.
