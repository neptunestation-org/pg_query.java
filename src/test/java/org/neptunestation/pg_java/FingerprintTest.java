package org.neptunestation.pg_query.java;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import org.junit.*;

public class FingerprintTest {
    @Test
    public void batch1 () throws IOException {
	InputStream input = getClass().getResourceAsStream("/fingerprint_tests.properties");
	Properties prop = new Properties();
	prop.load(input);
	for (String fingerprint : prop.stringPropertyNames()) {
	    PgQueryFingerprintResult result = PgJava.pg_query_fingerprint(prop.getProperty(fingerprint));
	    assertEquals(fingerprint, result.getFingerprint_str());
	    PgJava.pg_query_free_fingerprint_result(result);
	    result = PgJava.pg_query_fingerprint("SELECT !");
	    assertEquals("syntax error at end of input", result.getError().getMessage());
	}
    }

    @Test
    public void batch2 () throws IOException {
	InputStream input = getClass().getResourceAsStream("/fingerprint_tests_batch2.properties");
	Properties prop = new Properties();
	prop.load(input);
	for (String fingerprint : prop.stringPropertyNames()) {
	    PgQueryFingerprintResult result = PgJava.pg_query_fingerprint(prop.getProperty(fingerprint));
	    assertEquals(fingerprint, result.getFingerprint_str());
	    PgJava.pg_query_free_fingerprint_result(result);
	    result = PgJava.pg_query_fingerprint("SELECT !");
	    assertEquals("syntax error at end of input", result.getError().getMessage());
	}
    }

    public void tearDown () {
	PgJava.pg_query_exit();
    }
}
