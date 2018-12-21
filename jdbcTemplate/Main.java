package com.oukele.jdbcTemplate;

import com.oukele.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JDBCTemplateConfig.class);
        UserDao dao = context.getBean(UserDao.class);

//        System.out.println("------------------------- List -------------------------");
//        System.out.println(dao.getToList());
//        System.out.println("------------------------- 键值对应 -------------------------");
//        System.out.println(dao.getToMap());
//        System.out.println("------------------------ 对象数据 ------------------------------");
//        User user = dao.getToUser();
//        System.out.println(user);
        System.out.println("-------------------------添加-------------------------");
        System.out.println(dao.create("JAVA1", "123"));

    }
}
