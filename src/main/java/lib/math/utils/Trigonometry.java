package lib.math.utils;

import app.utils.MathUtilsEnum;
import org.apache.commons.math3.analysis.function.Abs;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;
import org.apache.commons.math3.util.MathArrays;

public class Trigonometry {

    /* IsPointInTri() -
     * Used by IsPointInQuad(). Function takes the point and the triangle's
     * vertices. It finds the area of the passed triangle (v1 v2 v3), and then the
     * areas of the three triangles (pt v2 v3), (pt v1 v3), and (pt v1 v2). If the
     * sum of these three is greater than the first, then the point is outside of
     * the triangle.
     */

    public static boolean isPointInTri(double[] floatingPoint, double[] triPoint1, double[] triPoint2, double[] triPoint3) {
        double trianguloBase, triangulo1, triangulo2, triangulo3;
        Vector2D puntoFlotante = new Vector2D(floatingPoint);
        Vector2D punto1 = new Vector2D(triPoint1);
        Vector2D punto2 = new Vector2D(triPoint2);
        Vector2D punto3 = new Vector2D(triPoint3);
        Abs abs = MathUtilsEnum.instance.getAbs();
        trianguloBase = abs.value(crossProduct(punto1, punto2, punto3));
        triangulo1 = abs.value(crossProduct(puntoFlotante, punto1, punto2));
        triangulo2 = abs.value(crossProduct(puntoFlotante, punto1, punto3));
        triangulo3 = abs.value(crossProduct(puntoFlotante, punto2, punto3));
        return (triangulo1 + triangulo2 + triangulo3) <= trianguloBase;
    }

    public static double crossProduct(Vector2D vector1, Vector2D vector2, Vector2D vector3)  {
        return vector1.crossProduct(vector2, vector3);
    }

    public static double rank(RealMatrix realMatrix) {
        SingularValueDecomposition singularMatrix = new SingularValueDecomposition(realMatrix);
        return singularMatrix.getRank();
    }

    public static boolean arePointsAligned(RealMatrix realMatrix) {
        return Trigonometry.rank(realMatrix) == 1;
    }
}
