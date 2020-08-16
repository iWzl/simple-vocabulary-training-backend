package cc.itsc.project.vocabulary.training.backend.utils;

/**
 * 对象校验工具
 *
 * @author Leonardo iWzl
 * @version 1.0
 */
public class ObjectUtil {

    public static boolean isNotEmpty(String strObj) {
        return strObj != null && !"".equals(strObj);
    }

    public static boolean isNotEmpty(Long longObj) {
        return longObj != null && 0 != longObj;
    }

    public static boolean isNotEmpty(Integer intObj) {
            return intObj != null && 0 != intObj;
    }
}
