package grammar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 数组
 * @Author: Tu-Yi
 * @Created: 2021/03/11 20:33
 */
public class ArrayTest {

    static Logger logger = LoggerFactory.getLogger(ArrayTest.class.getName());

    public static void main(String[] args) {
        getMax();
        addEle();
        delEle();
        testArrays();
        testArrayCopy();

        //从侧面验证：
        //int[] arr1; //如果对数组只声明，没有后续操作，那么相当于 白定义了。
        //int[] arr2 = null;
        //System.out.println(arr2.length);//Exception in thread "main" java.lang.NullPointerException
        //int[] arr3 = new int[0];
        //System.out.println(arr3.length);
        //int[] arr4 = new int[4];
        //System.out.println(arr4.length);

        //System.out.println(args.length);//0
        //从这个结果证明，参数是String[],实参是  new String[0]
        //默认情况下，虚拟机在调用main方法的时候就是传入了一个长度为0的数组

        System.out.println(args.length);
        for (String str : args) {
            System.out.println(str);
        }
    }


    public static void getMax() {
        int[] arr = {1, 2, 3, 4, 5};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        logger.info("max:{}", max);
    }

    public static void addEle() {

        int[] arr = {12, 34, 56, 7, 3, 10, 55, 66, 77, 88, 999, 89};

        //从键盘接收数据：
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入你要添加元素的指定下标：");
        int index = sc.nextInt();
        System.out.println("请录入你要添加的元素：");
        int ele = sc.nextInt();




        //3.增加元素
        //调用方法：
        insertEle(arr, index, ele);


        //4.输出增加元素后的数组：
        System.out.print("\n增加元素后的数组：");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {//i==arr.length-1 最后一个元素不用加,
                System.out.print(arr[i]);
            }
        }
    }



    /*
       提取一个添加元素的方法：
       在数组的指定位置上添加一个指定的元素。
       在哪个数组的哪个位置添加哪个元素！
       不确定因素：形参：哪个数组，哪个位置，哪个元素
       返回值：无

       */
    public static void insertEle(int[] arr, int index, int ele) {
        for (int i = arr.length - 1; i >= (index + 1); i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = ele;
    }

    public static void delEle() {
        //功能：给定一个数组,删除元素3：

        //1.给定一个数组：
        int[] arr = {12, 34, 56, 7, 3, 10, 34, 45, 56, 7, 666};

        //2.输出删除前的数组：
        System.out.println("删除元素前的数组：" + Arrays.toString(arr));


        //找到要删除的元素对应的索引即可：
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 3) {
                index = i;
                break;
            }
        }

        //3.删除

        if (index != -1) {
            for (int i = index; i <= arr.length - 2; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = 0;
        } else {//index==-1
            System.out.println("根本没有你要删除的元素！");
        }


        //4.输出删除后的数组：
        System.out.println("删除元素后的数组：" + Arrays.toString(arr));
    }

    public static void testArrays() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] brr = {1, 2, 3, 4, 5, 6};

        // Arrays.toString 返回内容的字符串形式
        System.out.println(Arrays.toString(arr)); //[1, 2, 3, 4, 5, 6]

        //二分查找
        int a[] = new int[]{18, 62, 68, 82, 65, 9};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        //使用binarySearch之前，必须先使用sort进行排序
        System.out.println("数字 62出现的位置:" + Arrays.binarySearch(a, 62));

        // Arrays.equals 比较两个数组的值是否一样  相同的顺序包含相同的元素
        //true
        System.out.println(Arrays.equals(arr, brr));
        //false  数组没有重写equals 用的是Object的equals
        System.out.println(arr.equals(brr));
        //false  内存地址比较
        System.out.println(arr == brr);

        // Arrays.copyOf 数组复制，和新数组长度没关系，
        //新数组长度取决于函数的长度参数，浪费内存，用System.arrayCopy实现，存
        int[] crr;
        //效率低
        crr = Arrays.copyOf(arr, 10);
        //[1, 2, 3, 4, 5, 6, 0, 0, 0, 0]
        System.out.println(Arrays.toString(crr));

        //copyOfRange  区间复制
        int a1[] = new int[]{18, 62, 68, 82, 65, 9};

        // copyOfRange(int[] original, int from, int to)
        // 第一个参数表示源数组
        // 第二个参数表示开始位置(取得到)
        // 第三个参数表示结束位置(取不到)
        int[] b = Arrays.copyOfRange(a1, 0, 3);

        //18, 62, 68
        for (int value : b) {
            System.out.print(value + " ");
        }


        //Arrays.fill 循环填充
        Arrays.fill(crr, 99);
        //[99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
        System.out.println(Arrays.toString(crr));

        //Arrays.sort 升序
        Arrays.sort(arr);
        //[1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(arr));
        //比较自定义类型，必须实现Comparable接口
        Person[] persons = new Person[3];
        persons[0] = new Person("小明", 19, "男");
        persons[1] = new Person("旺财", 16, "男");
        persons[2] = new Person("小强", 25, "男");

        Arrays.sort(persons);

        //旺财	16
        //小明	19
        //小强	25
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public static void testArrayCopy() {
        //给一个源数组：
        int[] srcArr = {11, 22, 33, 44, 55, 66, 77, 88};
        //给一个目标数组：
        int[] destArr = new int[10];

        //复制：
        System.arraycopy(srcArr, 1, destArr, 3, 3);
        //遍历查看目标数组：[0, 0, 0, 22, 33, 44, 0, 0, 0, 0]
        System.out.println(Arrays.toString(destArr));
    }
}
