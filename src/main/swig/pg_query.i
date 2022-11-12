%module PgJava
%{
#include "pg_query.h"
%}
%include "pg_query.h"

%pragma(java) jniclassimports=%{
	 import java.io.*;
	 import java.net.*;
	 import java.nio.file.*;
	 import org.neptunestation.pg_java.*;
	 %}

%pragma(java) jniclasscode=%{
	 static {
		 String libName = "libpg_query.so";
		 String pathName = String.format("/NATIVE/%s/%s/%s", System.getProperty("os.arch"), System.getProperty("os.name"), libName);
		 try {
			 File tmpDir = Files.createTempDirectory("my-native-lib").toFile();
			 tmpDir.deleteOnExit();
			 File nativeLibTmpFile = new File(tmpDir, libName);
			 nativeLibTmpFile.deleteOnExit();
			 try (InputStream in = (new org.neptunestation.pg_java.PgJava()).getClass().getResourceAsStream(pathName)) {
				 Files.copy(in, nativeLibTmpFile.toPath());
			 }
			 System.load(nativeLibTmpFile.getAbsolutePath());
		 }
		 catch (Exception e) {
			 e.printStackTrace();
			 System.exit(1);
		 }
	 }
	 %}
