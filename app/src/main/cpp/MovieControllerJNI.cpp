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
            jobject /* this */,
            jint count) {
        return (long) new MovieController(count);
    }

    extern "C" JNIEXPORT jint JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieCount(
            JNIEnv *env,
            jobject /* this */,
            jlong session) {
        MovieController *movieController = (MovieController *) session;
        jint count = (jint) movieController->getMovies().size();
        return count;
    }

    extern "C" JNIEXPORT jstring JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieName(
            JNIEnv *env,
            jobject /* this */,
            jlong session,
            jint offset) {
        MovieController *movieController = (MovieController *) session;
        Movie *movie = (Movie *) movieController->getMovies()[offset];
        return env->NewStringUTF(movie->name.c_str());
    }

    extern "C" JNIEXPORT jint JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieLastUpdated(
            JNIEnv *env,
            jobject /* this */,
            jlong session,
            jint offset) {
        MovieController *movieController = (MovieController *) session;
        Movie *movie = (Movie *) movieController->getMovies()[offset];
        return movie->lastUpdated;
    }

    extern "C" JNIEXPORT jlong JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieDetailToken(
            JNIEnv *env,
            jobject /* this */,
            jlong session,
            jstring name) {
        MovieController *movieController = (MovieController *) session;
        jboolean isCopy;
        std::string sname = env->GetStringUTFChars(name, &isCopy);
        MovieDetail *movieDetail = movieController->getMovieDetail(sname);
        if (movieDetail == nullptr) {
            return 0;
        }
        return (long) movieDetail;
    }

    extern "C" JNIEXPORT jstring JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieDetailName(
            JNIEnv *env,
            jobject /* this */,
            jlong token) {
        MovieDetail *movieDetail = (MovieDetail *) token;
        return env->NewStringUTF(movieDetail->name.c_str());
    }

    extern "C" JNIEXPORT jstring JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieDetailDescription(
            JNIEnv *env,
            jobject /* this */,
            jlong token) {
        MovieDetail *movieDetail = (MovieDetail *) token;
        return env->NewStringUTF(movieDetail->description.c_str());
    }

    extern "C" JNIEXPORT jfloat JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieDetailScore(
            JNIEnv *env,
            jobject /* this */,
            jlong token) {
        MovieDetail *movieDetail = (MovieDetail *) token;
        return movieDetail->score;
    }

    extern "C" JNIEXPORT jint JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieDetailActorCount(
            JNIEnv *env,
            jobject /* this */,
            jlong token) {
        MovieDetail *movieDetail = (MovieDetail *) token;
        jint count = (jint) movieDetail->actors.size();
        return count;
    }

    extern "C" JNIEXPORT jstring JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieDetailActorName(
            JNIEnv *env,
            jobject /* this */,
            jlong token,
            jint offset) {
        MovieDetail *movieDetail = (MovieDetail *) token;
        return env->NewStringUTF(movieDetail->actors[offset].name.c_str());
    }

    extern "C" JNIEXPORT jstring JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieDetailActorImage(
            JNIEnv *env,
            jobject /* this */,
            jlong token,
            jint offset) {
        MovieDetail *movieDetail = (MovieDetail *) token;
        return env->NewStringUTF(movieDetail->actors[offset].imageUrl.c_str());
    }

    extern "C" JNIEXPORT jint JNICALL
    Java_com_highrise_movieman_moviesnative_MovieControllerNative_getMovieDetailActorAge(
            JNIEnv *env,
            jobject /* this */,
            jlong token,
            jint offset) {
        MovieDetail *movieDetail = (MovieDetail *) token;
        return movieDetail->actors[offset].age;
    }
}


