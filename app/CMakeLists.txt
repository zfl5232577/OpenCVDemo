# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

#配置工程路径
set(path_project D:/Mark_ndk/OpenCVDemo)

include_directories(${path_project}/app/src/main/cpp/include)

add_library( # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-lib.cpp )


 #添加两个预编译的so库
 add_library( opencv_java3
              SHARED
              IMPORTED
             )

 #设置两个预编译的库的路径
 set_target_properties(
                        opencv_java3
                        PROPERTIES IMPORTED_LOCATION
                        ${path_project}/app/libs/${ANDROID_ABI}/libopencv_java3.so
                     )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library(
              log-lib
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries(
                       native-lib
                       ${log-lib}
                       opencv_java3)