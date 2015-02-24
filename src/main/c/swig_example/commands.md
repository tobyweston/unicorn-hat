    swig -java -package bad.robot.unicorn.integration.jni -noproxy example.i
    gcc -fpic -c example.c example_wrap.c -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include -I/usr/lib/jvm/jdk-8-oracle-arm-vfp-hflt/include/linux
    gcc -shared example.o example_wrap.o -o libexample.so
