#include <jni.h>
/* Header for class org_zwave4j_JniTest */

#ifndef _Included_init
#define _Included_init

extern JavaVM * jvm;
extern jobject classLoader;

jclass findClass(JNIEnv * env, const char * name);

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM * vm, void * pvt);

#endif
