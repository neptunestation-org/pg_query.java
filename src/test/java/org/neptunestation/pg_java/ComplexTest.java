package org.neptunestation.pg_java;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import org.junit.*;

public class ComplexTest {
    @Test
    public void main () throws IOException {
	String fingerprint = "fc5a0500dddc25aa";
	InputStream input = getClass().getResourceAsStream("/test.properties");
	Properties prop = new Properties();
	prop.load(input);
	String query = prop.getProperty("query");
	PgQueryFingerprintResult result = PgJava.pg_query_fingerprint(query);
	assertEquals(fingerprint, result.getFingerprint_str());
    }
}
