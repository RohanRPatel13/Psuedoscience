import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class ABCDGuesser2 {
    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        double posNum = 0.0;
        while (posNum <= 0.0) {
            out.println("Enter a positive number: ");
            posNum = in.nextDouble();
        }
        return posNum;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        double posNum = 1.0;
        while (posNum <= 1.0) {
            out.println("Enter a positive number not equal to 1: ");
            posNum = in.nextDouble();
        }
        return posNum;
    }

    private static void findU(double u, double w, double x, double y,
            double z) {
        double a = 0;
        int aCount;
        double b = 0;
        int bCount;
        double c = 0;
        int cCount;
        double d = 0;
        int dCount;
        double[] exponents = { -5, -4, -3, -2, -1, -1 / 2, -1 / 3, -1 / 4, 0,
                1 / 4, 1 / 3, 1 / 2, 1, 2, 3, 4, 5 };
        double firstIndex = ((Math.pow(w, exponents[0]))
                * (Math.pow(x, exponents[0])) * (Math.pow(y, exponents[0]))
                * (Math.pow(z, exponents[0]))) - u;
        for (dCount = 1; dCount < 17; dCount++) {
            for (cCount = 1; cCount < 17; cCount++) {
                for (bCount = 1; bCount < 17; bCount++) {
                    for (aCount = 1; aCount < 17; aCount++) {
                        double estimate = ((Math.pow(w, exponents[aCount]))
                                * (Math.pow(x, exponents[bCount]))
                                * (Math.pow(y, exponents[cCount]))
                                * (Math.pow(z, exponents[dCount]))) - u;
                        if (Math.abs(estimate) < Math.abs(firstIndex)) {
                            firstIndex = estimate;
                            a = exponents[aCount];
                            b = exponents[bCount];
                            c = exponents[cCount];
                            d = exponents[dCount];
                        }

                    }
                    aCount = 0;
                }
                bCount = 0;
            }
            cCount = 0;
        }
        double error = (firstIndex / u) * 100;
        System.out.println(u + firstIndex);
        System.out.println("Error: " + error);
        System.out.println("Exponent Values");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);

    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        double u = getPositiveDouble(in, out);
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);
        findU(u, w, x, y, z);

    }
}
