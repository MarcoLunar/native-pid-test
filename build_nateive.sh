#!/bin/bash

mvn clean install

/opt/app/graalvm/graalvm-ce-java8-linux-amd64-20.1.0/graalvm-ce-java8-20.1.0/bin/native-image --no-server -cp "/opt/poligon/native-pid-test/target/classes:/home/mel/.m2/repository/org/graalvm/nativeimage/svm/20.1.0/svm-20.1.0.jar:/home/mel/.m2/repository/org/graalvm/sdk/graal-sdk/20.1.0/graal-sdk-20.1.0.jar:/home/mel/.m2/repository/org/graalvm/nativeimage/objectfile/20.1.0/objectfile-20.1.0.jar:/home/mel/.m2/repository/org/graalvm/nativeimage/pointsto/20.1.0/pointsto-20.1.0.jar:/home/mel/.m2/repository/org/graalvm/truffle/truffle-nfi/20.1.0/truffle-nfi-20.1.0.jar:/home/mel/.m2/repository/org/graalvm/truffle/truffle-api/20.1.0/truffle-api-20.1.0.jar:/home/mel/.m2/repository/org/graalvm/compiler/compiler/20.1.0/compiler-20.1.0.jar:/home/mel/.m2/repository/org/jetbrains/pty4j/pty4j/0.9.6/pty4j-0.9.6.jar:/home/mel/.m2/repository/org/jetbrains/annotations/16.0.2/annotations-16.0.2.jar:/home/mel/.m2/repository/com/google/guava/guava/25.1-jre/guava-25.1-jre.jar:/home/mel/.m2/repository/com/google/code/findbugs/jsr305/3.0.2/jsr305-3.0.2.jar:/home/mel/.m2/repository/org/checkerframework/checker-qual/2.0.0/checker-qual-2.0.0.jar:/home/mel/.m2/repository/com/google/errorprone/error_prone_annotations/2.1.3/error_prone_annotations-2.1.3.jar:/home/mel/.m2/repository/com/google/j2objc/j2objc-annotations/1.1/j2objc-annotations-1.1.jar:/home/mel/.m2/repository/org/codehaus/mojo/animal-sniffer-annotations/1.14/animal-sniffer-annotations-1.14.jar:/home/mel/.m2/repository/log4j/log4j/1.2.14/log4j-1.2.14.jar:/home/mel/.m2/repository/net/java/dev/jna/jna/4.5.0/jna-4.5.0.jar:/home/mel/.m2/repository/org/jetbrains/pty4j/purejavacomm/0.0.11.1/purejavacomm-0.0.11.1.jar:/home/mel/.m2/repository/net/java/dev/jna/jna-platform/4.5.0/jna-platform-4.5.0.jar" --no-fallback -H:Class=poc.SimpleNativePoc  -H:Name=simpletest --verbose -H:ClassInitialization=:build_time --initialize-at-run-time=com.sun.jna.platform.win32.Version,com.sun.jna.platform.win32.Kernel32,com.pty4j.windows.WinPty -Dos.name=Linux --allow-incomplete-classpath -H:+ReportExceptionStackTraces -H:+TraceClassInitialization -H:ReflectionConfigurationFiles=/opt/poligon/native-pid-test/reflect-config.json -H:ResourceConfigurationFiles=/opt/poligon/native-pid-test/resource-config.json -H:+JNIVerboseLookupErrors && ./simpletest