package com.github.w4o.boot.sao;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 新java的语法骚操作
 *
 * @author frank
 * @date 2020/4/21
 * java10 局部变量类型推断： 以 var 形式定义局部变量
 * java12 Switch 表达式： 以-> 形式的switch 表达式 {@link Sao#switchExpression}
 */
public class Sao {

    /**
     * java12 switch表达式骚操作
     * 箭头语法
     *
     * <pre>
     * String a = "";
     * switch(i) {
     *  case 1:
     *      a = "1";
     *      break;
     *  case 2:
     *      a = "2";
     *      break;
     *  default:
     *      a = "?";
     *      break;
     * }
     * </pre>
     */
    public static String switchExpression(int i) {

        var a = switch (i) {
            case 1 -> "1";
            case 2 -> "2";
            default -> "?";
        };

        a = "结果：" + a;

        return a;
    }

    /**
     * java14 模式匹配
     *
     * <pre>
     *     if (obj instanceof String) {
     *         String a = (String)Object;
     *     }
     * </pre>
     */
    public static String newInstanceOf(Object obj) {
        return "";
        /*
        if (obj instanceof String s) {
            return "字符串长度：" + s.length();
        } else {
            return "不是字符串类型";
        }
         */
    }

    /**
     * java9 集合的of方法
     */
    public static void collectionOf() {

        Map<String, String> map = Map.of("k1", "v1", "k2", "v2");
        System.out.println(map);

        List<Integer> list = List.of(1, 2, 3, 4);
        System.out.println(list);

        Set<Integer> set = Set.of(1, 2, 3);
        System.out.println(set);

    }

}
