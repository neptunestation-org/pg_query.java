package org.neptunestation.pg_query.java;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import javax.json.*;
import org.json.*;
import org.junit.*;
import org.skyscreamer.jsonassert.*;
import org.skyscreamer.jsonassert.comparator.*;

public class DeparseTest {
    @Test
    public void testRunner() throws IOException, JSONException {
	for (JsonValue j : Json.createReader(getClass().getResourceAsStream("/deparse_tests.json")).readObject().getJsonArray("tests"))
	    assertEquals(j.asJsonObject().getJsonString("sql").getString(), PgJava.pg_query_deparse_protobuf(PgJava.pg_query_parse_protobuf(j.asJsonObject().getJsonString("sql").getString()).getParse_tree()).getQuery());
    }
}
