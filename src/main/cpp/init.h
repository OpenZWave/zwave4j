#include <jni.h>
#include <Defs.h>

#ifndef _Included_init
#define _Included_init

extern JavaVM * jvm;
extern jobject classLoader;


uint8 inline getUint8(jshort value) { return (uint8) value; }

uint16 inline getUint16(jint value) { return (uint16) value; }

uint32 inline getUint32(jlong value) { return (uint32) value; }

uint32 inline getUint32(jsize value) { return (uint32) value; }

int8 inline getInt8(jbyte value) { return (int8) value; }

int16 inline getInt16(jshort value) { return (int16) value; }

int32 inline getInt32(jint value) { return (int32) value; }

int64 inline getInt64(jlong value) { return (int64) value; }

float32 inline getFloat32(jfloat value) { return (float32) value; }

float64 inline getFloat64(jdouble value) { return (float64) value; }

bool inline getBool(jboolean value) { return (value == JNI_FALSE) ? false : true; }


jshort inline getJshort(uint8 value) { return (jshort) value; }

jint inline getJint(uint16 value) { return (jint) value; }

jlong inline getJlong(uint32 value) { return (jlong) value; }

jsize inline getJsize(uint32 value) { return (jsize) value; }

jbyte inline getJbyte(int8 value) { return (jbyte) value; }

jshort inline getJshort(int16 value) { return (jshort) value; }

jint inline getJint(int32 value) { return (jint) value; }

jlong inline getJlong(int64 value) { return (jlong) value; }

jfloat inline getJfloat(float32 value) { return (jfloat) value; }

jdouble inline getJdouble(float64 value) { return (jdouble) value; }

jboolean inline getJboolean(bool value) { return value ? JNI_TRUE : JNI_FALSE; }


jclass findClass(JNIEnv * env, const char * name);


JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM * vm, void * pvt);

#endif
