package de.hfu.Buchstaben;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class) 
public class UtilTest {
	
	private boolean soll;
	private int param;
	
	public UtilTest(int soll, int param)
	{
		if(soll == 1)	this.soll = true;
		else			this.soll = false;
		this.param = param;
	}

	@Parameters
	public static Collection<Integer[]> daten(){
		return Arrays.asList(new Integer[][]{
			{1, 1},
			{1, 2},
			{1, 3},
			{1, 4},
			{1, 5},
			{1, 6},
			{0, 7},
			{0, 8},
			{0, 9},
			{0, 10},
			{0, 11},
			{0, 12},
		});
	}
	
	@Test
	public void test() {
		assertEquals(soll,Util.istErstesHalbjahr(param));
	}
	
	@Test(expected=IllegalArgumentException.class, timeout = 1000)
	public void testException(){
		Util.istErstesHalbjahr(0);
		Util.istErstesHalbjahr(13);
	}

}
