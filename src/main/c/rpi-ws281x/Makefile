all: clean build

swig_prep:
	swig -java -package bad.robot.unicorn.neopixel.ws2811 rpi_ws281x.i

build:
	cd lib && make lib
	gcc -pthread -fno-strict-aliasing -DNDEBUG -g -fwrapv -O2 -Wall -Wstrict-prototypes -fPIC -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include/linux -Ilib/ -c rpi_ws281x_wrap.c -o rpi_ws281x_wrap.o
	gcc -pthread -shared -Wl,-O1 -Wl,-Bsymbolic-functions -Wl,-z,relro rpi_ws281x_wrap.o -Llib/ -lws2811 -o libws281x.so

clean:
	cd lib && make clean
	-rm rpi_ws281x_wrap.o
