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
		 try {
			 File tmpDir = Files.createTempDirectory("my-native-lib").toFile();
			 tmpDir.deleteOnExit();
			 File nativeLibTmpFile = new File(tmpDir, libName);
			 nativeLibTmpFile.deleteOnExit();
			 try (InputStream in = (new org.neptunestation.pg_java.PgJava()).getClass().getResourceAsStream("/" + libName)) {
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
