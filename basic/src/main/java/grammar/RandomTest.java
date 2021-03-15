package grammar;

import cn.hutool.core.util.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @Description: 随机数的生成
 * @Author: Tu-Yi
 * @Created: 2021/03/11 12:12
 */
public class RandomTest {
    static Logger logger = LoggerFactory.getLogger(RandomTest.class.getName());

    public static void main(String[] args) {

        mathRandomTest();
        randomTest();
        huToolTest();
    }


    /**
     * @Description: java.lang.Math
     * 公式：int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/3/11 12:26
     *
     */
    public static void mathRandomTest(){
        int randomWithMathRandom = (int) ((Math.random() * 100) + 0);
        logger.info("randomWithMathRandom:{}",randomWithMathRandom);
    }

    /**
     * @Description: java.util.Random
     * 公式：int randomWintNextIntWithinARange = random.nextInt(max - min) + min;
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/3/11 12:26
     *
     */
    public static void randomTest(){
        int randomWithMathRandom = new Random().nextInt(100);
        logger.info("randomWithMathRandom:{}",randomWithMathRandom);
    }

    /**
     * @Description: Hutool
     *
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/3/11 12:26
     *
     */
    public static void  huToolTest(){
        logger.info("ints:{}",NumberUtil.generateRandomNumber(0, 100, 1));
    }
}
