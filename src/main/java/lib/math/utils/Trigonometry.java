package lib.math.utils;

import app.enums.MathUtilsEnum;
import lib.math.geometry.Punto;
import org.apache.commons.math3.analysis.function.Abs;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;

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

    public static double crossProduct(double[] triPoint1, double[] triPoint2, double[] triPoint3) {
        return crossProduct(
                new Vector2D(triPoint1),
                new Vector2D(triPoint2),
                new Vector2D(triPoint3)
        );
    }

    public static double crossProduct(Vector2D vector1, Vector2D vector2, Vector2D vector3) {
        return vector1.crossProduct(vector2, vector3);
    }

    public static double rank(RealMatrix realMatrix) {
        SingularValueDecomposition singularMatrix = new SingularValueDecomposition(realMatrix);
        return singularMatrix.getRank();
    }

    public static boolean arePointsAligned(Punto punto1, Punto punto2, Punto punto3) {
        double[] coordsX = {punto1.getCoordX(), punto2.getCoordX(), punto3.getCoordX()};
        double[] coordsY = {punto1.getCoordY(), punto2.getCoordY(), punto3.getCoordY()};
        if (checkEquality(coordsX) || checkEquality(coordsY)) {
            return true;
        }
        double firstDivision = (punto2.getCoordX() - punto1.getCoordX()) / (punto3.getCoordX() - punto2.getCoordX());
        double secondDivision = (punto2.getCoordY() - punto1.getCoordY()) / (punto3.getCoordY() - punto2.getCoordY());
        return secondDivision == firstDivision;
    }

    public static boolean checkEquality(double[] numbers) {
        double total = 0;
        for (double number : numbers) {
            total += number;
        }
        return MathUtilsEnum.instance.getAbs().value(numbers[0]) == (MathUtilsEnum.instance.getAbs().value(total) / numbers.length);
    }

    public static boolean arePointsAligned(RealMatrix realMatrix) {
        return Trigonometry.rank(realMatrix) == 1;
    }

    public static boolean arePointsAligned(double[][] matrix) {
        Array2DRowRealMatrix realMatrix = new Array2DRowRealMatrix(matrix);
        return arePointsAligned(realMatrix);
    }
}
