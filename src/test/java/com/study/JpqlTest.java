package com.study;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @ClassName JpaTest
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/23
 * @Version V1.0
 *
 * 测试Jpql查询
 **/
public class JpqlTest {
    /**
     * 查询全部
     *      jpql: from Customer
     *      sql:SELECT * FROM cst_customer
     * */
    @Test
    public void testFindAll(){
        //1.获取事务EntityMannger
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.完成查询全部
        String jpql = "from com.study.Customer";
        Query query = entityManager.createQuery(jpql);//创建Query查询对象,query对象才是执行的jpql的对象
        //发送查询并封装结果集
        List resultList = query.getResultList();
        for (Object obj:resultList) {
            System.out.println(obj);
        }
        //4.提交事务
        transaction.commit();
        //5.释放资源
        entityManager.close();

    }

    /**
     * 排序
     *  sql:SELECT * FROM cst_Customer ORDER BY cust_id DESC
     *  jpql:from Customer order by CustId desc
     *
     *
     *  进行jpql查询
     *         1.创建query查询对象
     *         2.对参数进行赋值
     *         3.查询并返回结果集
     * */
    @Test
    public void testOrder(){
        //1.获取事务EntityMannger
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.完成查询全部
        String jpql = "from com.study.Customer order by custId desc";
        Query query = entityManager.createQuery(jpql);//创建Query查询对象,query对象才是执行的jpql的对象
        //发送查询并封装结果集
        List resultList = query.getResultList();
        for (Object obj:resultList) {
            System.out.println(obj);
        }
        //4.提交事务
        transaction.commit();
        //5.释放资源
        entityManager.close();

    }

    /**
     * 使用jpql查询,统计客户的总数
     *      sql:select count(id) from cst_customer
     *      jpql:select count(custId) from Customer
     * */

    @Test
    public void testCount(){
        //1.获取事务EntityMannger
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.完成查询条数
        //根据jpql语句创建Query语句
        String jpql = "select count(custId) from Customer";

        Query query = entityManager.createQuery(jpql);//创建Query查询对象,query对象才是执行的jpql的对象
        //对参数赋值
        //发送查询,并封装结果
        /**
         * getResultList:直接将结果封装为list集合
         * singleResult:  得到唯一的结果集
         * */
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);
        //4.提交事务
        transaction.commit();
        //5.释放资源
        entityManager.close();

    }
    /**
     *  sql:select * from cst_customer limit ?,?
     *  jpql: from Customer
     * */
    @Test
    public void testLimit(){
        //1.获取事务EntityMannger
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.完成查询条数
        //根据jpql语句创建Query语句
        String jpql = "from Customer";

        Query query = entityManager.createQuery(jpql);//创建Query查询对象,query对象才是执行的jpql的对象

        //对参数赋值 分页参数
        //起始索引
        query.setFirstResult(0);
        query.setMaxResults(1);
        //
        List resultList = query.getResultList();

        for (Object obj:resultList) {
            System.out.println(obj);
        }
        //4.提交事务
        transaction.commit();
        //5.释放资源
        entityManager.close();

    }
    /**
     * 条件查询
     *
     * sql:select * form cst_customer where cust_name like '3'
     *jpql:from Customer where custName like ?
     * */
    @Test
    public void testGroud(){
        //1,根据配置文件创建工厂 获取事务管理器
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.条件查询
        String jpql = "from Customer where custName like ?";
        Query query = entityManager.createQuery(jpql);
        //对占位符赋值
        //第一个参数:占位符的索引位置(从1开始),第二个参数:取值
        query.setParameter(1,"3%");
        List resultList = query.getResultList();
        for (Object obj: resultList
             ) {
            System.out.println(obj);
        }
        //4.提交事务
        transaction.commit();
        //5.释放资源
        entityManager.close();
    }

}
