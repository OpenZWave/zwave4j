#include "../headers/init.h"

JavaVM * jvm;

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM * vm, void * pvt)
{
	jvm = vm;
	JNIEnv * env;
	if (jvm->GetEnv((void **) &env, JNI_VERSION_1_6))
	{
         return JNI_ERR; /* JNI version not supported */
    }
	return JNI_VERSION_1_6;
}
