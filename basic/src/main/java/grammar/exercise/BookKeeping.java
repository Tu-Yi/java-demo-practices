package grammar.exercise;

import cn.hutool.core.util.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Description: 小鲨鱼记账系统
 * @Author: Tu-Yi
 * @Created: 2021/03/13 11:03
 */
public class BookKeeping {

    static Logger logger = LoggerFactory.getLogger(BookKeeping.class.getName());
    public static void main(String[] args) {
        StringBuilder details = new StringBuilder();
        BigDecimal balance = BigDecimal.valueOf(0);
        while (true) {
            logger.info("------欢迎使用小鲨鱼记账系统------");
            logger.info("1.收支明细");
            logger.info("2.登记收入");
            logger.info("3.登记支出");
            logger.info("4.退出系统");
            logger.info("小鲨鱼记账------请输入操作代码：");

            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();

            int whileNum = 0;
            while (i!=1&&i!=2&&i!=3&&i!=4){
                whileNum++;
                logger.info("小鲨鱼记账------输入代码无效，请重新输入：");
                i = scanner.nextInt();
                if(whileNum>=4){
                    logger.info("错误操作超过4次，系统退出");
                    return;
                }
            }

            switch (i){
                case 1 :
                    logger.info("小鲨鱼记账------收入明细：");
                    logger.info(getDetails(details));
                    break;
                case 2 :
                    logger.info("小鲨鱼记账------登记收入：");
                    double income = scanner.nextDouble();
                    balance = NumberUtil.add(balance, income);
                    logger.info("小鲨鱼记账------收入说明：");
                    String incomeDesc = scanner.next();
                    details.append("收入：");
                    details.append(balance.doubleValue());
                    details.append(",收入说明：");
                    details.append(incomeDesc);
                    details.append("\n");
                    break;
                case 3 :
                    logger.info("小鲨鱼记账------登记支出：");
                    double expand = scanner.nextDouble();
                    balance = NumberUtil.sub(balance, expand);
                    logger.info("小鲨鱼记账------支出说明：");
                    String expandDesc = scanner.next();
                    details.append("支出：");
                    details.append(balance.doubleValue());
                    details.append(",支出说明：");
                    details.append(expandDesc);
                    details.append("\n");
                    break;
                case 4 :
                    logger.info("您确定要退出小鲨鱼记账系统？Y/N");
                    String next = scanner.next();
                    if("Y".equals(next)){
                        return;
                    }
                    break;
                default:
                    logger.info("请输入有效的操作代码");
            }
        }

    }

    public static String getDetails(StringBuilder details){
        String s = details.toString();
        return "".equals(s) ? "尚未录入收入明细" : s.substring(0,s.length()-1);
    }
}
