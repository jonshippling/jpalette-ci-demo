package edu.rit.se;

public class ColorHex implements Color
{
	private final String hex;

	public ColorHex(String hex) throws ColorException
	{
		// We only support 6 character strings (two each for R,G,B)
		if (hex.length() != 6) { throw new ColorException(hex); }

		/* Implement this */

		/*
		 * Hint: String.substring(), Integer.parseInt()
		 * 
		 * Integer.parseInt() throws a NumberFormatException, which you
		 * can catch and then re-throw as a ColorException.
		 */

		this.hex = hex;
	}

	@Override
	public ColorCymk toCymk()
	{
		String sr = hex.substring(0, 2);
		String sg = hex.substring(2, 4);
		String sb = hex.substring(4, 6);

		int ir, ig, ib;

		ir = Integer.parseInt(sr, 16);
		ig = Integer.parseInt(sg, 16);
		ib = Integer.parseInt(sb, 16);
		
		double rP = (double) ir/255;
		double gP = (double) ig/255;
		double bP = (double) ib/255;
		
		double k = 1-Util.varMax(rP,gP,bP);
		double c = (1-rP-k) / (1-k);
		double m = (1-gP-k) / (1-k);
		double y = (1-bP-k) / (1-k);

		return new ColorCymk(c,m,y,k);
	}

	@Override
	public ColorHex toHex() throws ColorException
	{
		return new ColorHex(hex);
	}

	@Override
	public ColorRgb toRgb() 
	{
		String sr = hex.substring(0, 2);
		String sg = hex.substring(2, 4);
		String sb = hex.substring(4, 6);

		int ir, ig, ib;

		ir = Integer.parseInt(sr, 16);
		ig = Integer.parseInt(sg, 16);
		ib = Integer.parseInt(sb, 16);

		return new ColorRgb(ir, ig, ib);
	}

	@Override
	public String toString()
	{
		return "0x" + hex.toUpperCase();
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof ColorHex) {
			ColorHex that = (ColorHex) o;

			return this.hex.equals(that.hex);
		} else {
			return false;
		}
	}
}
