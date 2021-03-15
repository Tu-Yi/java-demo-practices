package grammar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: char那些事
 * @Author: Tu-Yi
 * @Created: 2021/03/10 22:08
 */
public class CharTest {
    static Logger logger = LoggerFactory.getLogger(CharTest.class.getName());

    public static void main(String[] args) {
        testChar1();
        testChar2();
    }

    public static void testChar1(){
        //定义字符类型的变量：
        char ch1 = 'a';
        logger.info("ch1:{}",ch1);
        char ch2 = 'A';
        logger.info("ch2:{}",ch2);
        char ch3 = '4';
        logger.info("ch3:{}",ch3);
        char ch4 = '中';
        logger.info("ch4:{}",ch4);
        char ch5 = '?';
        logger.info("ch5:{}",ch5);
        //java中无论：字母，数字，符号，中文都是字符类型的常量，都占用2个字节。
        char ch6 = ' ';
        logger.info("ch6:{}",ch6);
        //字符类型：单引号引起来的单个字符
        logger.info("--------------------------------");
        /*
        转义字符：
        \将后面的普通字符转换为特殊含义
        */
        // \n  换行
        logger.info("aaa\nbbb");

        //  \t  制表符
        logger.info("aaaaaaa\tbbb");

        //aabbb  \b  向前退一格
        logger.info("\"aaa\\bbbb");

        //bbb   \r 将光标到本行开头 ：回车
        logger.info("aaa\rbbb");

        // \" 将双引号原样输出  \' 将单引号原样输出 \\ 将\原样输出
        logger.info("\"java\"");
    }

    public static void testChar2(){
        char ch1 = 'A';
        //A
        logger.info("ch1:{}",ch1);
        //155
        logger.info("ch1+90:{}",ch1+90);
        //90
        logger.info("155-ch1:{}",155-ch1);
        //char类型我们看到的样子就是它本身的字面常量,但是底层在进行计算的时候，实际上是按照一个码进行计算的。
        //这个码就是ASCII
        //之前说char类型是按照Unicode码表进行存储的 (Unicode兼容了ASCII码，Unicode的前128位置ASCII)

        char ch2 = '中';
        // 中
        logger.info("ch2:{}",ch2);

        // 20103
        logger.info("ch2+90:{}",ch2+90);

        // 90
        logger.info("20103-ch2:{}",20103-ch2);

        //转换：
        int num1 = (int)ch2;
        //20013
        logger.info("num1:{}",num1);

        char ch = (char)20013;
        logger.info("ch:{}",ch);

        char ch5 = 20013;
        //中
        logger.info("ch5:{}",ch5);

        //面试题：
        char ch6 = '2'+2;
        //'4'--->4
        logger.info("ch6:{}",ch6);
    }
}
