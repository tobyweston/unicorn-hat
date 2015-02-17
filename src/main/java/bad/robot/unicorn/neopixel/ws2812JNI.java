/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package bad.robot.unicorn.neopixel;

class ws2812JNI {
  static native void Color_t_r_set(long jarg1, Color_t jarg1_, short jarg2);
  static native short Color_t_r_get(long jarg1, Color_t jarg1_);
  static native void Color_t_g_set(long jarg1, Color_t jarg1_, short jarg2);
  static native short Color_t_g_get(long jarg1, Color_t jarg1_);
  static native void Color_t_b_set(long jarg1, Color_t jarg1_, short jarg2);
  static native short Color_t_b_get(long jarg1, Color_t jarg1_);
  static native long new_Color_t();
  static native void delete_Color_t(long jarg1);
  static native void init(int jarg1);
  static native void clear();
  static native void show();
  static native long Wheel(short jarg1);
  static native void colorWipe(long jarg1, Color_t jarg1_, short jarg2);
  static native void rainbow(short jarg1);
  static native void rainbowCycle(short jarg1);
  static native void theaterChase(long jarg1, Color_t jarg1_, short jarg2);
  static native void theaterChaseRainbow(short jarg1);
  static native short setBrightness(double jarg1);
  static native double getBrightness();
  static native long RGB2Color(short jarg1, short jarg2, short jarg3);
  static native long Color(short jarg1, short jarg2, short jarg3);
  static native short setPixelColor(long jarg1, short jarg2, short jarg3, short jarg4);
  static native short setPixelColorT(long jarg1, long jarg2, Color_t jarg2_);
  static native long getPixelColor(long jarg1);
  static native long numPixels();
  static native long getPixels();
  static native void setPWMBit(long jarg1, short jarg2);
  static native short getPWMBit(long jarg1);
  static native void dumpLEDBuffer();
  static native void dumpPWMBuffer();
  static native void dumpPWMStatus();
  static native void dumpPWMControl(long jarg1);
  static native void dumpPWMDMAC();
  static native void dumpPWM();
  static native void dumpDMARegs();
  static native void dumpControlBlock(long jarg1);
  static native void dumpTransferInformation(long jarg1);
  static native void dumpDMA();
  static native void terminate(int jarg1);
}