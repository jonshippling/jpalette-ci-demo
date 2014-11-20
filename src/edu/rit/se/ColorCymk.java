package edu.rit.se;

public class ColorCymk implements Color
{
	public final double c, y, m, k;

	/**
	 * <p>
	 * Each of the parameters c, y, m, and k is a fractional number between
	 * 0 and 1.
	 * </p>
	 */
	public ColorCymk(double c, double y, double m, double k)
	{
		this.c = c;
		this.y = y;
		this.m = m;
		this.k = k;
	}

	@Override
	public ColorCymk toCymk()
	{
		return new ColorCymk(c,y,m,k);
	}

	@Override
	public ColorHex toHex() throws ColorException
	{
		String red,green,blue;
		int R,G,B;
		R = (int) (255 * (1-c) * (1-k));
		G = (int) (255 * (1-m) * (1-k));
		B = (int) (255 * (1-y) * (1-k));
		
		String hex = new String();
		hex += Integer.toHexString(R);
		hex += Integer.toHexString(G);
		hex += Integer.toHexString(B);
		hex = hex.toUpperCase();

		return new ColorHex(hex);
	}

	/*
	 The R,G,B values are given in the range of 0..255.
The red (R) color is calculated from the cyan (C) and black (K) colors:
R = 255 × (1-C) × (1-K)
The green color (G) is calculated from the magenta (M) and black (K) colors:
G = 255 × (1-M) × (1-K)
The blue color (B) is calculated from the yellow (Y) and black (K) colors:
B = 255 × (1-Y) × (1-K)
	 */
	@Override
	public ColorRgb toRgb()
	{
		int R,G,B;
		R = (int) (255 * (1-c) * (1-k));
		G = (int) (255 * (1-m) * (1-k));
		B = (int) (255 * (1-y) * (1-k));
		return new ColorRgb(R,G,B);
	}

	@Override
	public String toString()
	{
		String result;
		result = String.format("(c:%.3f,y:%.3f,m:%.3f,k:%.3f)", c, y,
			m, k);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * Since floating-point numbers are involved, equality must be
	 * determined within some acceptable error.
	 */
	@Override
	public boolean equals(Object o)
	{
		final double epsilon = .01;

		if (o instanceof ColorCymk) {
			ColorCymk that = (ColorCymk) o;

			boolean result = true;
			result &= Math.abs(this.c - that.c) < epsilon;
			result &= Math.abs(this.y - that.y) < epsilon;
			result &= Math.abs(this.m - that.m) < epsilon;
			result &= Math.abs(this.k - that.k) < epsilon;

			return result;
		} else {
			return false;
		}
	}
}
