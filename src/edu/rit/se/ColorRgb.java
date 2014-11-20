package edu.rit.se;

public class ColorRgb implements Color
{
	private final int r, g, b;

	public ColorRgb(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public ColorCymk toCymk()
	{
		double rP = (double) r/255;
		double gP = (double) g/255;
		double bP = (double) b/255;
		
		double k = 1-Util.varMax(rP,gP,bP);
		double c = (1-rP-k) / (1-k);
		double m = (1-gP-k) / (1-k);
		double y = (1-bP-k) / (1-k);

		return new ColorCymk(c,m,y,k);
	}

	@Override
	public ColorHex toHex() throws ColorException
	{

		String red,green,blue;
		red = Integer.toHexString(r);
		green = Integer.toHexString(g);
		blue = Integer.toHexString(b);
		
		return new ColorHex(red+green+blue);
	}

	@Override
	public ColorRgb toRgb()
	{
		return new ColorRgb(r, g, b);
	}

	@Override
	public String toString()
	{
		String result;
		result = String.format("(r:%d,g:%d,b:%d)", r, g, b);

		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof ColorRgb) {
			ColorRgb that = (ColorRgb) o;

			return (this.r == that.r) && (this.g == that.g)
				&& (this.b == that.b);
		} else {
			return false;
		}
	}
}
