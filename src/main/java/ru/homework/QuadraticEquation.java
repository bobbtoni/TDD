package ru.homework;

import ru.homework.exception.OverflowDiscriminant;

public class QuadraticEquation {
	private static final double EPSILON = 0.001;
	
	public static double[] solve(double a, double b, double c) {
		if (Math.abs(a) <= EPSILON) {
			throw new IllegalArgumentException("Аргумент `a` не может быть равен 0");
		}
		if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
			throw new IllegalArgumentException("Аргументы не могут быть NaN");
		}
		if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
			throw new IllegalArgumentException("В значениях аргументов не может быть бесконечность");
		}
		final double discriminant = b*b - 4*a*c;
		if (Double.isNaN(discriminant)) {
			throw new OverflowDiscriminant("Невозможно вычислеть дискриминант, "
					+ "превышено максимально допустимое значение типа double");
		}
		final double[] equationRoots;
		if (discriminant < -EPSILON) {
			equationRoots = new double[0];
		} else if (Math.abs(discriminant) <= EPSILON) {
			equationRoots = new double[] {-b/2*a};
		} else {
			final double equationRoot1 = (-b + Math.sqrt(discriminant)) / 2 * a;
			final double equationRoot2 = (-b - Math.sqrt(discriminant)) / 2 * a;
			equationRoots = new double[] {equationRoot1, equationRoot2};
		}
		return equationRoots;
	}
}
