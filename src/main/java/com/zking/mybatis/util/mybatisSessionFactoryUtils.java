package com.zking.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class mybatisSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
    
    static{
        try {
            InputStream is = mybatisSessionFactoryUtils.class.getResourceAsStream("/mybatis.cfg.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static SqlSession openSession(){
        SqlSession sqlSession = threadLocal.get();
        if(null==sqlSession){
           sqlSession = sqlSessionFactory.openSession();
           threadLocal.set(sqlSession);
        }
        return sqlSession;

    }

    public static void closeSession(){
        SqlSession sqlSession = threadLocal.get();
        if(null!=sqlSession){
            sqlSession.close();
            threadLocal.set(null);
        }
    }

    public static void main(String[] args) {
        SqlSession sqlSession = mybatisSessionFactoryUtils.openSession();
        System.out.println("成功");
        mybatisSessionFactoryUtils.closeSession();
        System.out.println("关闭");

    }
}
