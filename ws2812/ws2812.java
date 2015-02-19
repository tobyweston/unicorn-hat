/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package bad.robot.unicorn.neopixel;

public class ws2812 {
  public static void init(int numPixels) {
    ws2812JNI.init(numPixels);
  }

  public static void clear() {
    ws2812JNI.clear();
  }

  public static void show() {
    ws2812JNI.show();
  }

  public static Color_t Wheel(short WheelPos) {
    return new Color_t(ws2812JNI.Wheel(WheelPos), true);
  }

  public static void colorWipe(Color_t c, short wait) {
    ws2812JNI.colorWipe(Color_t.getCPtr(c), c, wait);
  }

  public static void rainbow(short wait) {
    ws2812JNI.rainbow(wait);
  }

  public static void rainbowCycle(short wait) {
    ws2812JNI.rainbowCycle(wait);
  }

  public static void theaterChase(Color_t c, short wait) {
    ws2812JNI.theaterChase(Color_t.getCPtr(c), c, wait);
  }

  public static void theaterChaseRainbow(short wait) {
    ws2812JNI.theaterChaseRainbow(wait);
  }

  public static short setBrightness(double b) {
    return ws2812JNI.setBrightness(b);
  }

  public static double getBrightness() {
    return ws2812JNI.getBrightness();
  }

  public static Color_t RGB2Color(short r, short g, short b) {
    return new Color_t(ws2812JNI.RGB2Color(r, g, b), true);
  }

  public static Color_t Color(short r, short g, short b) {
    return new Color_t(ws2812JNI.Color(r, g, b), true);
  }

  public static short setPixelColor(long pixel, short r, short g, short b) {
    return ws2812JNI.setPixelColor(pixel, r, g, b);
  }

  public static short setPixelColorT(long pixel, Color_t c) {
    return ws2812JNI.setPixelColorT(pixel, Color_t.getCPtr(c), c);
  }

  public static Color_t getPixelColor(long pixel) {
    return new Color_t(ws2812JNI.getPixelColor(pixel), true);
  }

  public static long numPixels() {
    return ws2812JNI.numPixels();
  }

  public static Color_t getPixels() {
    long cPtr = ws2812JNI.getPixels();
    return (cPtr == 0) ? null : new Color_t(cPtr, false);
  }

  public static void setPWMBit(long bitPos, short bit) {
    ws2812JNI.setPWMBit(bitPos, bit);
  }

  public static short getPWMBit(long bitPos) {
    return ws2812JNI.getPWMBit(bitPos);
  }

  public static void dumpLEDBuffer() {
    ws2812JNI.dumpLEDBuffer();
  }

  public static void dumpPWMBuffer() {
    ws2812JNI.dumpPWMBuffer();
  }

  public static void dumpPWMStatus() {
    ws2812JNI.dumpPWMStatus();
  }

  public static void dumpPWMControl(long word) {
    ws2812JNI.dumpPWMControl(word);
  }

  public static void dumpPWMDMAC() {
    ws2812JNI.dumpPWMDMAC();
  }

  public static void dumpPWM() {
    ws2812JNI.dumpPWM();
  }

  public static void dumpDMARegs() {
    ws2812JNI.dumpDMARegs();
  }

  public static void dumpControlBlock(SWIGTYPE_p_dma_cb_t c) {
    ws2812JNI.dumpControlBlock(SWIGTYPE_p_dma_cb_t.getCPtr(c));
  }

  public static void dumpTransferInformation(long TI) {
    ws2812JNI.dumpTransferInformation(TI);
  }

  public static void dumpDMA() {
    ws2812JNI.dumpDMA();
  }

  public static void terminate(int dummy) {
    ws2812JNI.terminate(dummy);
  }

}
