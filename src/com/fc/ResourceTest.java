package com.fc;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化测试类。
 * 从资源包中，加载对应国家的文字。
 */
public class ResourceTest {

    public static void main(String[] args) {
        System.out.println("key:value----");
        getAllMsg(ResourceBundle.getBundle("login_messages"));
        System.out.println();
        System.out.println("简单字符----");
        getSimpleMsg(ResourceBundle.getBundle("login_messages", Locale.CHINA));
        getSimpleMsg(ResourceBundle.getBundle("login_messages", Locale.JAPAN));
        getSimpleMsg(ResourceBundle.getBundle("login_messages", Locale.US));
        System.out.println();
        System.out.println("格式化字符----");
        getFormattedMsg(ResourceBundle.getBundle("login_messages", Locale.US));
        getFormattedMsg(ResourceBundle.getBundle("login_messages", Locale.JAPAN));
        getFormattedMsg(ResourceBundle.getBundle("login_messages", Locale.CHINA));
    }

    private static void getSimpleMsg(ResourceBundle login_messages) {
        String login_success = login_messages.getString("login_success");
        System.out.println(login_success);
        String login_error = login_messages.getString("login_error");
        System.out.println(login_error);
    }
    private static void getAllMsg(ResourceBundle login_messages) {
        Iterator<String> myMessage = login_messages.getKeys().asIterator();
        while (myMessage.hasNext()) {
            String next = myMessage.next();
            System.out.println(next+":"+ login_messages.getString(next));
        }
    }
    private static void getFormattedMsg(ResourceBundle login_messages) {
        String morning = "morning";
        // 输入参数
        Object[] args = {"hao.fu",new Date(),1002};
        // 将地区也传入
        Locale locale = login_messages.getLocale();

        MessageFormat morningMessage = new MessageFormat(login_messages.getString(morning), locale);
        System.out.println(morning +":"+ morningMessage.format(args));
        String afternoon = "afternoon";
        MessageFormat afterNoonMessage = new MessageFormat(login_messages.getString(morning), locale);
        System.out.println(afternoon +":"+ afterNoonMessage.format(args));
    }
}
