package grammar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Description: 圆面积周长
 * @Author: Tu-Yi
 * @Created: 2021/03/11 11:00
 */
public class Circle {

    static Logger logger = LoggerFactory.getLogger(Circle.class.getName());

    private static final double RADIUS =3;


    public static void main(String[] args) {
        logger.info("round:{}",getRound());

        logger.info("area:{}",getArea());
    }


    public static double getRound() {
        BigDecimal bgPerimeter = BigDecimal.valueOf(2 * Math.PI * RADIUS).setScale(2, RoundingMode.UP);
        return bgPerimeter.doubleValue();
    }

    public static double getArea() {
        BigDecimal bgArea = BigDecimal.valueOf(Math.PI * Math.pow(RADIUS, 2)).setScale(2, RoundingMode.UP);
        return bgArea.doubleValue();
    }
}
