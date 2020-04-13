package com.hibernate.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/4/10  18:29
 */
public class SelectStudy {
    public static void main(String[] args) {

        Configuration cn = new Configuration().configure();
        SessionFactory sf = cn.buildSessionFactory();
        Session se = sf.openSession();
        StudyTableEntity sty = (StudyTableEntity) se.get(StudyTableEntity.class, 2);
        System.out.println(sty.getName() + "和" + sty.getLesson());


        //修改
        sty.setLesson("python");
        sty.setName("spring");

        Transaction tx = se.beginTransaction();
        se.update(sty);
        tx.commit();

        // 删除
        tx = se.beginTransaction();
        se.delete(sty);

        //提交
        tx.commit();

        sty = (StudyTableEntity) se.get(StudyTableEntity.class, 2);
        System.out.println(sty.getName() + "和" + sty.getLesson());

        se.close();
    }
}
