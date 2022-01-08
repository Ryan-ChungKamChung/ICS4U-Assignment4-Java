/*
 * This class represents a triangle and its properties
 *
 * @author  Ryan Chung
 * @version 1.0
 * @since   2022-01-06
 */

/** Triangle class with triangle properties and sides. */
public class Triangle {
    /** Triangle's first side. */
    private final double side1;
    /** Triangle's second side. */
    private final double side2;
    /** Triangle's third side. */
    private final double side3;

    /**
    * Triangle constructor.
    *
    * @param sideLength1 triangle's first side
    * @param sideLength2 triangle's second side
    * @param sideLength3 triangle's third side
    * @throws ArithmeticException if it isn't a valid triangle
    */
    public Triangle(
        final double sideLength1,
        final double sideLength2,
        final double sideLength3
    ) {
        this.side1 = sideLength1;
        this.side2 = sideLength2;
        this.side3 = sideLength3;

        if (!isTriangleValid()) {
            throw new ArithmeticException();
        }
    }

    /**
    * Checks whether 3 given sides can form a triangle.
    *
    * @return if it is a valid triangle or not
    */
    protected boolean isTriangleValid() {
        final boolean isValid;

        if (side1 + side2 > side3 && side1 + side3 > side2
            && side2 + side3 > side1) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }

    /**
    * Calculates semiperimeter (Half of the perimeter of a triangle).
    *
    * @return semiperimeter
    */
    public double getSemiperimeter() {
        return (side1 + side2 + side3) / 2;
    }

    /**
    * Calculates area using Heron's formula.
    *
    * @return the area
    */
    public double getArea() {
        final double semiperimeter = getSemiperimeter();
        return Math.sqrt(
            semiperimeter * (semiperimeter - side1) * (semiperimeter - side2)
            * (semiperimeter - side3)
        );
    }

    /**
    * Calculates the perimeter.
    *
    * @return perimeter
    */
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    /**
    * Checks what type of triangle it is.
    *
    * @return triangle type
    */
    public String getName() {
        final String triangleType;

        if (side1 == side2 && side2 == side3) {
            triangleType = "Equilateral";
        } else if (side1 == side2 && side2 == side3 && side1 == side3) {
            triangleType = "Isoceles";
        } else {
            triangleType = "Scalene";
        }
        return triangleType;
    }

    /**
    * Calculates all 3 angles using the 3 given sides.
    *
    * @return the angles
    */
    public double[] getAngles() {
        final double squaredSide1 = Math.pow(side1, 2);
        final double squaredSide2 = Math.pow(side2, 2);
        final double squaredSide3 = Math.pow(side3, 2);

        final double[] angles = {
            Math.acos((squaredSide2 + squaredSide3 - squaredSide3)
                / (2 * side2 * side3)) * 180 / Math.PI,
            Math.acos((squaredSide1 + squaredSide3 - squaredSide2)
                / (2 * side1 * side2)) * 180 / Math.PI,
            Math.acos((squaredSide1 + squaredSide2 - squaredSide3)
                / (2 * side1 * side2)) * 180 / Math.PI,
        };
        return angles;
    }

    /**
    * Calculates all 3 heights based on the 3 given sides.
    *
    * @return the heights
    */
    public double[] getHeights() {
        final double[] heights = {
            2 * getArea() * side1,
            2 * getArea() * side2,
            2 * getArea() * side3,
        };
        return heights;
    }

    /**
    * Calculates the incircle radius.
    *
    * @return the incircle radius
    */
    public double getIncircleRadius() {
        return getArea() / getSemiperimeter();
    }

    /**
    * Calculates the circumcircle area.
    *
    * @return the circumcircle area
    */
    public double getCircumcircleArea() {
        final double multiplier = 4;
        return Math.PI * Math.pow(
            (side1 * side2 * side3) / (multiplier * getArea()), 2
        );
    }
}
