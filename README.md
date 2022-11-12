# pg_query.java
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
git clone https://github.com/neptunestation-org/pg_query.java.git
cd pg_query.java
mvn install
```
