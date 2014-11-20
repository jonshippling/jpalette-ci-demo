package edu.rit.se;

/**
 * <p>
 * This class determines what type of color a string represents, and then parses
 * that string into a new instance of that color.
 * </p>
 *  test commit
 * @author Steven Kroh (skk8768)
 */
public class ColorFactory
{
	public static Color fromString(String strcol)
	{
		try {
			if (strcol.startsWith("(r:")) {
				String tmp;
				tmp = strcol.substring(1, strcol.length() - 1);
				tmp = tmp.replaceAll(" ", "");
				tmp = tmp.replaceAll(":", ",");
				String[] tok = tmp.split(",");

				final int r = Integer.valueOf(tok[1]);
				final int g = Integer.valueOf(tok[3]);
				final int b = Integer.valueOf(tok[5]);

				return new ColorRgb(r, g, b);
			} else if (strcol.startsWith("(c:")) {
				String tmp;
				tmp = strcol.substring(1, strcol.length() - 1);
				tmp = tmp.replaceAll(" ", "");
				tmp = tmp.replaceAll(":", ",");
				String[] tok = tmp.split(",");

				final double c = Double.valueOf(tok[1]);
				final double y = Double.valueOf(tok[3]);
				final double m = Double.valueOf(tok[5]);
				final double k = Double.valueOf(tok[7]);

				return new ColorCymk(c, y, m, k);
			} else if (strcol.startsWith("0x")) {
				String tmp = strcol;
				tmp = tmp.replaceAll(" ", "");
				String hex = tmp.substring(2).toUpperCase();

				return new ColorHex(hex);
			}
		} catch (Exception e) {
			/* If nothing works, return null */
		}

		return null;
	}
}
