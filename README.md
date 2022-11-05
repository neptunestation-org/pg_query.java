# pg_java
This Java extension uses the actual PostgreSQL server source to parse SQL queries and return the internal PostgreSQL parse tree.

## Pre-Requisites ##

* Java JDK
* gcc
* Make
* Maven
* Swig

## Caveat Emptor ##

This was *built* under the following conditions.

1. Java JDK:  OpenJDK 17
2. gcc:  9.4.0
3. make:  GNU Make 4.2.1
4. Maven:  3.8.6
5. Ubuntu:  20.04.1
6. Swig:  4.0.1

This was *tested* almost not at all.  Good luck!

## Installation ##

```shell
git clone https://github.com/davidaventimiglia/pg_java
cd pg_query
mvn package
cp target/downloads/libpg_query-13-2.1.2/libpg_query.so /usr/lib/jni
```

## Usage ##

Simple test with Beanshell.

1. Run `bsh` with the appropriate `CLASSPATH` and `LD_LIBRARY_PATH`.

```shell
LD_LIBRARY_PATH=/usr/lib/jni bsh -classpath target/pg_java-1.0-SNAPSHOT.jar
```

2. Load the library, import the package, and run the simplest of all possible tests.

```java
import org.neptunestation.pg_query.*;
System.loadLibrary("pg_query");
print(PgJava.pg_query_parse("select 1").getParse_tree());
```
