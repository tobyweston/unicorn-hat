all: clean build

swig_prep:
	swig -java -package bad.robot.unicorn.neopixel rpi_ws281x.i

install:
	sudo ./setup.py install

build:
	sudo ./setup.py build

clean:
	sudo rm -rf build
