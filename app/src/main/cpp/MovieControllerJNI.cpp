/**
 * Copyright @ 2019 Douglas Selph
 */

#include <jni.h>
#include <string>
#include "MovieController.hpp"

namespace movies {

    extern "C" JNIEXPORT jlong JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_create(
            JNIEnv *env,
            jobject /* this */) {
        return (long) new MovieController();
    }

    extern "C" JNIEXPORT jint JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieCount(
            JNIEnv* env,
            jobject /* this */,
            jlong session) {
        MovieController *movieController = (MovieController *) session;
        jint count = (jint) movieController->getMovies().size();
        return count;
    }

    extern "C" JNIEXPORT jstring JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieName(
            JNIEnv* env,
            jobject /* this */,
            jlong session,
            jint offset) {
        MovieController *movieController = (MovieController *) session;
        Movie *movie = (Movie*) movieController->getMovies()[offset];
        return env->NewStringUTF(movie->name.c_str());
    }

    extern "C" JNIEXPORT jstring JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_stringFromJNI(
            JNIEnv* env,
            jobject /* this */) {
        std::string hello = "Hello from C++";
        return env->NewStringUTF(hello.c_str());
    }


}


