package com.study;

import javax.persistence.*;

/**
 * @ClassName Customer
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/23
 * @Version V1.0
 * 客户的实体类
 *      配置映射关系
 *      1.实体类和表的映射关系
 *      2.实体类中属性和表中字段的映射关系
 *      使用jpa注解
 * @Entity:声明实体类
 * @Table:配置实体类和表的映射关系 name属性就是配置数据库表的名称
 * @GeneratedValue 主键生成策略 GenerationType.IDENTITY自增
 * @Column配置属性和字段的映射关系
 **/
@Entity
@Table(name = "cst_customer")
public class Customer {
    @Id//声明是数据库主键的配置
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId; //客户主键
    @Column(name = "cust_name")
    private String custName;//客户名称
    @Column(name = "cust_source")
    private String custSource;//客户来源
    @Column(name = "cust_level")
    private String custLevel;//客户级别
    @Column(name = "cust_phone")
    private String custPhone;//客户联系方式
    @Column(name = "cust_industry")
    private String custIndustry;//客户所属行
    @Column(name = "cust_adders")
    private String custAdders;//客户地址

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custAdders='" + custAdders + '\'' +
                '}';
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustAdders() {
        return custAdders;
    }

    public void setCustAdders(String custAdders) {
        this.custAdders = custAdders;
    }
}
