package org.neptunestation.pg_java;

/**
 * Hello world!
 *
 */
public class App {
		public static void main(String[] args) {
				System.out.println("Hello World!");
				PgJava.pg_query_parse("select * from account");
		}
}
