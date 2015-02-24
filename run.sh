#!/bin/bash
sudo java -cp target/test-classes:target/classes/ -Djava.library.path=/home/pi/dev/unicorn-hat-java/src/main/c/ws2812 bad.robot.unicorn.integration.$1
