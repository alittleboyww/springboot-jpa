package com.springboot.hibernatejpa.dao;

import com.springboot.hibernatejpa.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyDao extends JpaRepository<Company,Long> {
    /**
     * @Description:通过id查询店铺信息
     * @param id
     * @return
     */
    Company findById(Integer id);

    /**
     * @Description:查询所有公司信息
     * @param isCheck
     * @return
     */
    List<Company> findByIsCheck(Integer isCheck);

    /**
     * @Description:查询公公司信息，分页展示
     * @param isCheck
     * @param pageable
     * @return
     */
    Page<Company> findByIsCheck(Integer isCheck, Pageable pageable);

    /**
     * @Description:通过公司名称查询（使用的是jpa的jpql）
     * 其中语句中的表名，字段名都是按照实体类的名称写的
     * @param comName
     * @return
     */
    @Query("select c from Company c where c.comName = :comName")
    List<Company> getComName(@Param("comName") String comName);

    /**
     * @Description:通过名称查询店铺列表（使用自定义原生sql）
     * @param comName
     * @return
     */
    @Query(value = "select * from company where com_name like %:comName%",nativeQuery = true)
    List<Company> selectComName(@Param("comName") String comName);


}
