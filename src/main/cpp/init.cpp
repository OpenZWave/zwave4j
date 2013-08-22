/*
 * Copyright (c) 2013 Alexander Zagumennikov
 *
 * SOFTWARE NOTICE AND LICENSE
 *
 * This file is part of ZWave4J.
 *
 * ZWave4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ZWave4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ZWave4J.  If not, see <http://www.gnu.org/licenses/>.
 */

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
