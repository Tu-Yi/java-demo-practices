package grammar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 运算符的坑
 * @Author: Tu-Yi
 * @Created: 2021/01/05 12:57
 */
public class Operator {

    static Logger logger = LoggerFactory.getLogger(Operator.class.getName());

    public static void main(String[] args) {
        careDiv();
        selfOperator();
        logicOperator();
    }


    /**
     * @Description: 多种数据类型参与运算的时候，整数类型，浮点类型，字符类型都可以参与运算，
     * 唯独布尔类型不可以参与运
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 12:59
     *
     */
    public static void calBoolean(){
        //cannot be applied to 'double', 'boolean
        //double d2 = 12+1294L+8.5F+3.81+'a'+true;
    }

    /**
     * @Description: 小心除法
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 12:59
     *
     */
    public static void careDiv(){
        int a1 = 6370;
        a1 = a1 / 1000;
        //a1:6
        logger.info("a1:{}",a1);
    }

    /**
     * @Description: 自增和自减的坑
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 13:00
     *
     */
    public static void selfOperator(){
        int c=30;
        int d=40;
        //30 输出旧的值再自增
        logger.info("c++:{}",c++);
        //32 输出自增后的值，上一行已经自增到31
        logger.info("++c:{}",++c);
        //40 同理
        logger.info("d--:{}",d--);
        //38 同理
        logger.info("--d:{}",--d);
    }

    /**
     * @Description: 逻辑运算符 短路
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 13:04
     *
     */
    public static void logicOperator(){
        //1>2的结果为false，那么整个表达式的结果即为false，将不再计算2>(3/0)
        //false
        boolean c = 1>2 && 2>(3/0);
        logger.info("c:{}",c);
        //1>2的结果为false，那么整个表达式的结果即为false，还要计算2>(3/0)，0不能做除数，//会输出异常信息
        //Exception in thread "main" java.lang.ArithmeticException: / by zero
        boolean d = 1>2 & 2>(3/0);
        logger.info("d:{}",d);
    }
}
