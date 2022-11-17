package org.neptunestation.pg_query.java;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import javax.json.*;
import org.json.*;
import org.junit.*;
import org.skyscreamer.jsonassert.*;
import org.skyscreamer.jsonassert.comparator.*;

public class ConcurrencyTest {
    @Test
    public void testRunner () throws IOException, JSONException {
	for (JsonValue j : Json.createReader(getClass().getResourceAsStream("/parse_tests.json")).readObject().getJsonArray("tests"))
	    new Thread(new Runnable () {
		    private JsonValue bar;
		    public Runnable init (final JsonValue bar) {
			this.bar = bar;
			return this;}
		    public void run () {
			try {JSONAssert.assertEquals(bar.asJsonObject().getJsonObject("json").toString(), PgJava.pg_query_parse(bar.asJsonObject().getJsonString("sql").getString()).getParse_tree(), false);}
			catch (Exception e) {throw new RuntimeException(e);}}}.init(j)).start();}
    public void tearDown () {
	PgJava.pg_query_exit();}}
