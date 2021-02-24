package com.study;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @ClassName JpaTest
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/23
 * @Version V1.0
 **/
public class JpaTest {
    /**
     * 测试 jpa 的保存
     *          新增
     *          Jpa的操作步骤
     *              1.加载配置文件创建工厂(实体管理类工厂)对象
     *              2.通过实体管理类工厂获取实体类管理器
     *              3.获取事务对象开启事务
     *              4.完成CRUD
     *              5.提交(回滚事务)
     *              6.释放资源
     * */
    @Test
    public void testSave(){
//        //1.加载配置文件创建工厂(实体管理类工厂)对象  持久化单元名称
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
//
//        //2.通过实体管理类工厂获取实体类管理器
//        EntityManager em = factory.createEntityManager();
        //通过工具类
        EntityManager em = JpaUtils.getEntityManager();

        //3.获取事务对象开启事务
        EntityTransaction tx = em.getTransaction();//获取事务对象
        tx.begin();
        //4.完成CRUD保存一个客户到数据库中
         Customer customer = new Customer();
         customer.setCustName("hello world");
         customer.setCustAdders("111");
        //保存操作
        em.persist(customer);
        //5.提交(回滚事务)
        tx.commit();
        //6.释放资源
        em.close();
//        factory.close();
    }


    /**
     * 根据Id
     * 查询客户
     *
     * find (立即加载)
     *  1查询的对象就是当前客户对象本身
     *  2在调用find方法的时候,就会发送sql语句查询数据库
     * */
    @Test
    public void testFind(){
        //通过工具类获取EntityManager
        EntityManager em = JpaUtils.getEntityManager();
        //开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //CRUD 查询
        /**
         * find根据Id查询数据
         *         class:查询数据的结果需要包装的实体类类型的字节码
         *         id:查询主键的取值
         * */
        Customer customer = em.find(Customer.class, 1l);
        System.out.println(customer);
        //提交事务
        tx.commit();
        //释放资源
        em.close();
    }

    /**
     * (延迟加载)
     *Reference根据Id查询数据
     *      1.获取的对象是一个动态代理对象
     *      2.调用getReference方法不会立即发送sql语句查询数据库\
     *          *当调用查询结果对象的时候才会发送查询的sql语句:什么时候发送sql语句查询数据库
     * */
    @Test
    public void testReference(){
        //通过工具类获取EntityManager
        EntityManager em = JpaUtils.getEntityManager();
        //开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //CRUD 查询
        /**
         * getReference根据Id查询数据
         *         class:查询数据的结果需要包装的实体类类型的字节码
         *         id:查询主键的取值
         * */
        Customer customer = em.getReference(Customer.class, 1l);
        System.out.println(customer);
        //提交事务
        tx.commit();
        //释放资源
        em.close();
    }

    /**
     * 删除客户
     * */
    @Test
    public void testRemove(){
        //通过工具类获取EntityManager
        EntityManager em = JpaUtils.getEntityManager();
        //开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //CRUD 查询
        /**
         * 1查询id客户
         * 2调用remove删除客户
         * */
        //1查询id客户
        Customer reference = em.getReference(Customer.class, 1l);
        //2根据id删除
        em.remove(reference);

        //提交事务
        tx.commit();
        //释放资源
        em.close();
    }

    @Test
    public void JpaUpdate(){
        //实用工具类建造工厂调用实体管理器
        EntityManager entityManager = JpaUtils.getEntityManager();
        //开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        /**
         * 1.先查询客户
         * 2.更新客户
         * */
        //修改操作 merge
        //1.先查询客户
        Customer customer = entityManager.find(Customer.class, 2l);
        //2.更新客户
        customer.setCustPhone("15839331529");
        entityManager.merge(customer);
        //保存事务
        transaction.commit();
        //释放资源
        entityManager.close();
    }
}
