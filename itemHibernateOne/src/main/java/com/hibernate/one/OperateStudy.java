package com.hibernate.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/4/10  17:47
 */
public class OperateStudy {

    public static void main(String[] args) {
        // 导入配置文件...
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory(); // 创建一个绘画工厂


        Session session = sf.openSession();
        Transaction tx = null;

        try {


            tx = session.beginTransaction();
            StudyTableEntity se = new StudyTableEntity();
            se.setName("hibernate");
            se.setLesson("030409");

            session.save(se);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }


    }
}
