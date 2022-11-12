package org.neptunestation.pg_java;

import static org.junit.Assert.assertTrue;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
		/**
		 * Rigorous Test :-)
		 */
		@Test
		public void shouldAnswerWithTrue () {
				System.out.println(org.neptunestation.pg_java.PgJava.pg_query_parse("select 1"));
				assertTrue( true );
		}
}
