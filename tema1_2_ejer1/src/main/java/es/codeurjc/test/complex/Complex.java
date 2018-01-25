package es.codeurjc.test.complex;

import static java.lang.Math.*;

public class Complex {

	private double realPart = 0;
	private double imaginaryPart = 0;

	public Complex(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	public Complex() {
	}

	public double getRealPart() {
		return this.realPart;
	}

	public double getImaginaryPart() {
		return this.imaginaryPart;
	}

	public double abs() {
		return sqrt(pow(this.realPart, 2.0) + pow(this.imaginaryPart, 2.0));
	}

	public double phase() {
		return atan2(this.imaginaryPart, this.realPart);
	}

	// return a new Complex object whose value is the conjugate of this
	public Complex conjugate() {
		return new Complex(this.realPart, -this.imaginaryPart);
	}

	// return a new Complex object whose value is the reciprocal of this
	public Complex reciprocal() {
		double scale = pow(this.realPart, 2.0) + pow(this.imaginaryPart, 2.0);
		return new Complex(this.realPart / scale, this.imaginaryPart / scale);
	}

	// return a new Complex object whose value is (this + complex)
	public Complex add(Complex complex) {

		double newRealPart = this.realPart + complex.realPart;
		double newImaginaryPart = this.imaginaryPart + complex.imaginaryPart;

		return new Complex(newRealPart, newImaginaryPart);
	}

	// return a new Complex object whose value is (this - complex)
	public Complex minus(Complex complex) {
		double newRealPart = this.realPart - complex.realPart;
		double newImaginaryPart = this.imaginaryPart - complex.imaginaryPart;

		return new Complex(newRealPart, newImaginaryPart);
	}

	// return a new Complex object whose value is (this * complex)
	public Complex times(Complex complex) {
		double newRealPart = (this.realPart * complex.realPart)
				- (this.imaginaryPart * complex.imaginaryPart);
		double newImaginaryPart = (this.realPart * complex.imaginaryPart)
				- (this.imaginaryPart * complex.realPart);

		return new Complex(newRealPart, newImaginaryPart);
	}

	// return a new Complex object whose value is (this * alpha)
	public Complex times(double alpha) {
		return new Complex(alpha * this.realPart, alpha * this.imaginaryPart);
	}

	// return a new Complex object whose value is (this / complex)
	public Complex divides(Complex complex) {
		return this.times(complex.reciprocal());
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imaginaryPart);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(realPart);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complex other = (Complex) obj;
		if (Double.doubleToLongBits(imaginaryPart) != Double
				.doubleToLongBits(other.imaginaryPart))
			return false;
		if (Double.doubleToLongBits(realPart) != Double
				.doubleToLongBits(other.realPart))
			return false;
		return true;
	}

	public String toString() {
		return this.realPart + " + " + this.imaginaryPart + "i ";
	}
}
