package ru.homework;

import static org.junit.Assert.*;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import ru.homework.exception.OverflowDiscriminant;

public class QuadraticEquationTest {
	
	/**
	 * x^2+1 = 0
	 */
	@Test
	public void test3() {
		final double a = 1;
		final double b = 0;
		final double c = 1;
		assertEquals(0, QuadraticEquation.solve(a, b, c).length);
	}
	
	/**
	 * x^2-1 = 0
	 */
	@Test
	public void test5() {
		final double a = 1;
		final double b = 0;
		final double c = -1;
		
		final double[] equationRoots = QuadraticEquation.solve(a, b, c);
		
		assertEquals(2, equationRoots.length);
		assertTrue(ArrayUtils.contains(equationRoots, 1D));
		assertTrue(ArrayUtils.contains(equationRoots, -1D));
	}
	
	/**
	 * x^2+2x+1 = 0
	 */
	@Test
	public void test7() {
		final double a = 1;
		final double b = 2;
		final double c = 1.0000001;
		
		final double[] equationRoots = QuadraticEquation.solve(a, b, c);
		
		assertEquals(1, equationRoots.length);
		assertTrue(ArrayUtils.contains(equationRoots, -1D));
	}
	
	/**
	 * a = 0
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test9() {
		final double a = 0;
		final double b = 1;
		final double c = 1;
		
		QuadraticEquation.solve(a, b, c);
	}
	
	@Test(expected = OverflowDiscriminant.class)
	public void testOverflow() {
		final double a = Double.MAX_VALUE;
		final double b = Double.MAX_VALUE;
		final double c = Double.MAX_VALUE;
		
		QuadraticEquation.solve(a, b, c);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNanArguments() {
		final double a = 0;
		final double b = Double.NaN;
		final double c = Double.NaN;
		
		QuadraticEquation.solve(a, b, c);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeInfinity() {
		final double a = 1;
		final double b = Double.NEGATIVE_INFINITY;
		final double c = 3;
		
		QuadraticEquation.solve(a, b, c);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPositiveInfinity() {
		final double a = 1;
		final double b = 1;
		final double c = Double.POSITIVE_INFINITY;
		
		QuadraticEquation.solve(a, b, c);
	}
	
}
