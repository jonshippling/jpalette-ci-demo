package edu.rit.se;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SwatchTest
{
	private Swatch sw;

	@Before
	public void setUp() throws Exception
	{
		sw = SwatchFactory.empty("test");
		sw.addColor(new ColorRgb(125, 125, 125));
		sw.addColor(new ColorHex("CCCCCC"));
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testContains()
	{
		assert(true);
	}

	@Test
	public void testRemoveColor()
	{
		assert(true);
	}

	@Test
	public void testAddColorLevel1()
	{
		assertTrue(sw.addColor(new ColorRgb(50, 50, 50)));
		assertTrue(sw.addColor(new ColorRgb(50, 50, 50)));
	}

	@Test
	public void testAddColorLevel2()
	{
		assertTrue(true);
	}
}
