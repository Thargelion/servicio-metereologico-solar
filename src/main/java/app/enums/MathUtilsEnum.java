package app.enums;

import org.apache.commons.math3.analysis.function.Abs;

public enum MathUtilsEnum {
    instance;
    private Abs abs = new Abs();

    private MathUtilsEnum() {
    }

    public Abs getAbs() {
        return abs;
    }
}
