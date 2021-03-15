package grammar.exercise;

import cn.hutool.core.util.NumberUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @Description: 双色球
 * @Author: Tu-Yi
 * @Created: 2021/03/13 12:40
 */
public class DoubleColorBall {

    static Logger logger = LoggerFactory.getLogger(DoubleColorBall.class.getName());

    public static void main(String[] args) {

        int[] balls = new int[7];
        boolean flag = false;
        int count = 0;
        while (true){
            logger.info("------欢迎进入双色球彩票系统------");
            logger.info("1.购买彩票");
            logger.info("2.查看开奖");
            logger.info("3.退出系统");
            logger.info("双色球彩票------请输入操作代码：");

            Scanner scanner = new Scanner(System.in);
            int i=0;

            do {
                logger.info("双色球彩票------输入操作代码(1-3)：");
                i = scanner.nextInt();
            }while(i<1 || i>3);

            if(i==1){
                logger.info("双色球彩票------购买彩票");
                count = buyBalls(balls);
                if(count==0){
                    logger.info("双色球彩票------购买失败");
                }
                flag=true;
            }else if(i==2){
                if(!flag) {
                    logger.info("双色球彩票------未购买彩票");
                }else{
                    logger.info("双色球彩票------查看开奖");
                    //int[] winBalls = genWinningNumbers();
                    int[] winBalls = {1,2,3,4,5,6,7};
                    logger.info("双色球彩票------中奖号码为：{}",winBalls);
                    int level = compareBalls(winBalls,balls);
                    switch (level){
                        case 1:
                            logger.info("恭喜你，中了1等奖，1注奖金500万，您一共获得：{} 万元",500*count);
                            break;
                        case 2:
                            logger.info("恭喜你，中了2等奖，1注奖金100万，您一共获得：{} 万元",100*count);
                            break;
                        case 3:
                            logger.info("恭喜你，中了3等奖，1注奖金3000元，您一共获得：{} 元",3000*count);
                            break;
                        case 4:
                            logger.info("恭喜你，中了4等奖，1注奖金200元，您一共获得：{} 元",200*count);
                            break;
                        case 5:
                            logger.info("恭喜你，中了5等奖，1注奖金10元，您一共获得：{} 元",10*count);
                            break;
                        case 6:
                            logger.info("恭喜你，中了6等奖，1注奖金5元，您一共获得：{} 元",5*count);
                            break;
                        default:
                            return;
                    }
                    flag=false;
                }
            }else{
                return;
            }
        }
    }

    public static int buyBalls(int[] balls){
        int count = 0;
        try {
            logger.info("双色球彩票------请输入购买的注数：");
            Scanner scanner = new Scanner(System.in);
            count = scanner.nextInt();
            for (int i = 0; i <7 ; i++) {
                if(i==6){
                    logger.info("双色球彩票------请输入篮球(1-16)：");
                }else{
                    logger.info("双色球彩票------请输入第{}个红球(1-33)：",i+1);
                }
                balls[i] = scanner.nextInt();
            }

            logger.info("您一共购买了{}注，共{}元钱,所选号码为：{}",count,count*2,balls);

        } catch (Exception e) {
            logger.error("异常：",e);
        }
        return count;
    }

    public static int[] genWinningNumbers(){
        int[] redBalls = NumberUtil.generateRandomNumber(1, 33, 6);
        int[] blueBalls = NumberUtil.generateRandomNumber(1, 16, 1);
        return ArrayUtils.addAll(redBalls, blueBalls);
    }

    public static int compareBalls(int[] winBalls,int[] balls){
        int level;
        int winRedCount = 0;
        int winBlueCount = 0;
        for (int i = 0; i < 7; i++) {
            if(i!=6){
                for(int j = 0;j<=5;j++){
                    if(balls[i]==winBalls[j]){
                        winRedCount++;
                    }
                }
            }else{
                if(balls[6]==winBalls[6]){
                    winBlueCount++;
                }
            }
        }
        if(winRedCount==6&&winBlueCount==1){
            level = 1;
        }else if(winRedCount==6){
            level = 2;
        }else if(winRedCount==5&&winBlueCount==1){
            level = 3;
        }else if(winRedCount==5||(winRedCount==4&&winBlueCount==1)){
            level = 4;
        }else if(winRedCount==4||(winRedCount==3&&winBlueCount==1)){
            level = 5;
        }else{
            level = 6;
        }
        return level;
    }
}
