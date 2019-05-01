package lib.math.utils;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;

public class Trigonometry {
    public static double rank(RealMatrix realMatrix) {
        SingularValueDecomposition singularMatrix = new SingularValueDecomposition(realMatrix);
        return singularMatrix.getRank();
    }

    public static boolean arePointsAligned(RealMatrix realMatrix) {
        return Trigonometry.rank(realMatrix) == 1;
    }
}
