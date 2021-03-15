package grammar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 装拆箱
 * @Author: Tu-Yi
 * @Created: 2021/03/15 16:57
 */
public class Boxing {
    static Logger logger = LoggerFactory.getLogger(Boxing.class.getName());

    public static void main(String[] args) {

        Map<String,Boolean> map =  new HashMap<String, Boolean>();
        //jdk1.7  NPE
        //jdk8 null
        Boolean b = (map!=null ? map.get("Hollis") : false);
        logger.info("b:{}",b);
    }
}
