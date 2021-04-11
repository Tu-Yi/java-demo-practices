package grammar.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 字符串
 * @Author: Tu-Yi
 * @Created: 2021/03/16 14:24
 */
public class StringTest {

    static Logger logger = LoggerFactory.getLogger(StringTest.class.getName());

    public static void main(String[] args) {
        {
            //s1在栈中
            String s1 = "abc";
            String s2 = "abc";
            //s3在堆中
            String s3 = new String("abc");
            //true
            logger.info("s1==s2:{}",s1==s2);
            //false
            logger.info("s1==s3:{}",s1==s3);
            //true  //String重写了equals，比较内容
            logger.info("s1.equals(s3):{}",s1.equals(s3));
        }

        {
            //m和n是同一个对象
            //
            //m,u,v都是不同的对象
            //
            //m,u,v,n但都使用了同样的字符数组，并且用equal判断的话也会返回true
            String m = "hello,world";
            String n = "hello,world";
            String u = new String(m);
            String v = new String("hello,world");


            //true
            logger.info("m == n:{}",m == n);
            //false
            logger.info("m == u:{}",m == u);
            //false
            logger.info("m == v:{}",m == v);
            //false
            logger.info("u == v:{}",u == v);

        }

        {
            System.out.println("abac".replace("a", "\\a")); //\ab\ac
        }
        {
            Pattern pattern = Pattern.compile("正则表达式");
            Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
            //替换符合正则的数据
            System.out.println(matcher.replaceAll("Java"));
        }
        {
            //文字替换（首次出现字符）
            Pattern pattern = Pattern.compile("正则表达式");
            Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
//替换第一个符合正则的数据
            System.out.println(matcher.replaceFirst("Java"));
        }
    }


}
