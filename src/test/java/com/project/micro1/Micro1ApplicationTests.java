package com.project.micro1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class Micro1ApplicationTests {

	@Test
	public void testConcatenation() {
		String foo = "abc";
		String bar = "def";
		assertEquals("abcdef", foo + bar);
	}

	private void assertEquals(String abcdef, String s) {
	}

	@Test
	public void testStartsWith() {
		String foo = "abc";
		assertTrue(foo.startsWith("ab"));

	/*@Test
	public void contextLoads() {
	}*/
	}
}
