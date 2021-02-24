package com.study;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @ClassName JpaUtil
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/24
 * @Version V1.0
 *
 * 为了解决实体管理器工厂浪费资源 和耗时问题
 *       通过静态代码块的形式,当程序第一次访问次工具 类时,创建一个公共的实体管理工厂对象
 *
 *       第一次访问getEntityManager方法,经过静态代码块创建一个factory对象,在调用方法创建一个EntityManager对象
 *       第二次访问getEntityManager方法,直接通过一个已经创建好的factory对象,创建EntityManager对象
 **/
public class JpaUtils {
    private static EntityManagerFactory factory;
    static {
        //加载配置文件,创建entityManagerFactory
        factory = Persistence.createEntityManagerFactory("myJpa");

    }
    /**
     * 获取EntityMAnager对象
     * */
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
