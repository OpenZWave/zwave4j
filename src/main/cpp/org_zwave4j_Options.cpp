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

#include <Options.h>
#include "../headers/init.h"
#include "../headers/org_zwave4j_Options.h"

jobject getOptions(JNIEnv * env)
{
	jclass clazz = findClass(env, "org/zwave4j/Options");
	return env->GetStaticObjectField(clazz, env->GetStaticFieldID(clazz, "instance", "Lorg/zwave4j/Options;"));
}

/*
 * Class:     org_zwave4j_Options
 * Method:    createNativeOptions
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_zwave4j_Options_createNativeOptions
  (JNIEnv * env, jclass clazz, jstring configPath, jstring userPath, jstring commandLine)
{
    const char * configPathChars = env->GetStringUTFChars(configPath, NULL);
    const char * userPathChars = env->GetStringUTFChars(userPath, NULL);
    const char * commandLineChars = env->GetStringUTFChars(commandLine, NULL);

	OpenZWave::Options::Create(
		std::string(configPathChars),
		std::string(userPathChars),
		std::string(commandLineChars)
	);

	env->ReleaseStringUTFChars(configPath, configPathChars);
	env->ReleaseStringUTFChars(userPath, userPathChars);
	env->ReleaseStringUTFChars(commandLine, commandLineChars);
}

/*
 * Class:     org_zwave4j_Options
 * Method:    destroyNativeOptions
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_org_zwave4j_Options_destroyNativeOptions
  (JNIEnv * env, jclass clazz)
{
	return OpenZWave::Options::Destroy();
}

/*
 * Class:     org_zwave4j_Options
 * Method:    lock
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_org_zwave4j_Options_lock
  (JNIEnv * env, jobject object)
{
	 return OpenZWave::Options::Get()->Lock();
}

/*
 * Class:     org_zwave4j_Options
 * Method:    addOptionBool
 * Signature: (Ljava/lang/String;Z)Z
 */
JNIEXPORT jboolean JNICALL Java_org_zwave4j_Options_addOptionBool
  (JNIEnv * env, jobject object, jstring name, jboolean defaultValue)
{
    const char * nameChars = env->GetStringUTFChars(name, NULL);
	return OpenZWave::Options::Get()->AddOptionBool(std::string(nameChars), getBool(defaultValue));
    env->ReleaseStringUTFChars(name, nameChars);
}

/*
 * Class:     org_zwave4j_Options
 * Method:    addOptionInt
 * Signature: (Ljava/lang/String;I)Z
 */
JNIEXPORT jboolean JNICALL Java_org_zwave4j_Options_addOptionInt
  (JNIEnv * env, jobject object, jstring name, jint defaultValue)
{
    const char * nameChars = env->GetStringUTFChars(name, NULL);
	return OpenZWave::Options::Get()->AddOptionInt(std::string(nameChars), defaultValue);
	env->ReleaseStringUTFChars(name, nameChars);
}

/*
 * Class:     org_zwave4j_Options
 * Method:    addOptionString
 * Signature: (Ljava/lang/String;Ljava/lang/String;Z)Z
 */
JNIEXPORT jboolean JNICALL Java_org_zwave4j_Options_addOptionString
  (JNIEnv * env, jobject object, jstring name, jstring defaultValue, jboolean append)
{
    const char * nameChars = env->GetStringUTFChars(name, NULL);
    const char * defaultValueChars = env->GetStringUTFChars(defaultValue, NULL);

	return OpenZWave::Options::Get()->AddOptionString(
		std::string(nameChars),
		std::string(defaultValueChars),
		getBool(append)
	);

	env->ReleaseStringUTFChars(name, nameChars);
	env->ReleaseStringUTFChars(defaultValue, defaultValueChars);
}

/*
 * Class:     org_zwave4j_Options
 * Method:    areLocked
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_org_zwave4j_Options_areLocked
  (JNIEnv * env, jobject object)
{
	return OpenZWave::Options::Get()->AreLocked();
}
