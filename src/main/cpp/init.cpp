#include <stdlib.h>
#include <string.h>
#include "../headers/init.h"

JavaVM * jvm;
jobject classLoader;

jclass findClass(JNIEnv * env, const char * name)
{
    char * convertedName = (char *) malloc((strlen(name) + 1) * sizeof(char));
    strcpy(convertedName, name);
    for (size_t i = 0; i < strlen(convertedName); i++)
    {
        if (convertedName[i] == '/')
        {
            convertedName[i] = '.';
        }
    }

    jclass clazz = (jclass) env->CallObjectMethod(
            classLoader,
            env->GetMethodID(
                    env->GetObjectClass(classLoader),
                    "loadClass",
                    "(Ljava/lang/String;)Ljava/lang/Class;"
            ),
            env->NewStringUTF(convertedName)
    );

    free(convertedName);

    return clazz;
}

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM * vm, void * pvt)
{
	jvm = vm;
	JNIEnv * env;
	if (jvm->GetEnv((void **) &env, JNI_VERSION_1_6))
	{
         return JNI_ERR; /* JNI version not supported */
    }

    jclass threadClass = env->FindClass("java/lang/Thread");
    classLoader = env->NewGlobalRef(env->CallObjectMethod(
            env->CallStaticObjectMethod(
                    threadClass,
                    env->GetStaticMethodID(threadClass, "currentThread", "()Ljava/lang/Thread;")
            ),
            env->GetMethodID(threadClass, "getContextClassLoader", "()Ljava/lang/ClassLoader;")
    ));

	return JNI_VERSION_1_6;
}
