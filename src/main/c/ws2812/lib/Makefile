CPU := $(shell cat /proc/cpuinfo | grep BCM | awk '{print $$3}' | tr -d ' ')

$(warning Detected CPU=$(CPU))

ifeq ($(CPU),BCM2709)
	PERI_BASE := 0x3F000000
	RPI2 := -DRPI2
else
	PERI_BASE := 0x20000000
endif

swig_prep:
	swig -java -package bad.robot.unicorn.neopixel ../ws2812-RPi.i

all:
	gcc -fPIC -c ws2812-RPi.c ../ws2812-RPi_wrap.c -DPERI_BASE=$(PERI_BASE) $(RPI2) -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include/linux

	ar rc libws2812-RPi.a ws2812-RPi.o
	ranlib libws2812-RPi.a

shared:
	gcc -fPIC -c ws2812-RPi.c ../ws2812-RPi_wrap.c -DPERI_BASE=$(PERI_BASE) $(RPI2) -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include/linux
	gcc -shared ws2812-RPi.o ws2812-RPi_wrap.o -o ../libws2812-RPi.so

clean:
	-rm *.o
	-rm *.a
