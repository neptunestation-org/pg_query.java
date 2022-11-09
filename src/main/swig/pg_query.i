%module test
%{
#include "pg_query.h"
%}
%include "../../../target/downloads/libpg_query-13-2.1.2/pg_query.h"

%pragma(java) jniclassimports=%{
	 import java.io.*;
	 import java.net.*;
	 import java.nio.file.*;
	 %}

%pragma(java) jniclasscode=%{
	 static {
		 String libName = "libpg_query.so";
		 URL url = Class.class.getResource("/" + libName);
		 try {
			 File tmpDir = Files.createTempDirectory("my-native-lib").toFile();
			 tmpDir.deleteOnExit();
			 File nativeLibTmpFile = new File(tmpDir, libName);
			 nativeLibTmpFile.deleteOnExit();
			 try (InputStream in = url.openStream()) {
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
