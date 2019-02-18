package com.springboot.hibernatejpa.service;

import com.springboot.hibernatejpa.dao.CompanyDao;
import com.springboot.hibernatejpa.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("ComService")
public class ComService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private CompanyDao companyDao;

    public Company findById(Integer id){
        return companyDao.findById(id);
    }

    public List<Company> findByIsCheck(Integer isCheck){
        return companyDao.findByIsCheck(isCheck);
    }

    public Page<Company> findByIsCheck(Integer isCheck, Pageable pageable){
        return companyDao.findByIsCheck(isCheck,pageable);
    }

    public List<Company> getShopName(String name){
        return companyDao.getComName(name);
    }

    public List<Company> selectShopName(String name){
        return companyDao.selectComName(name);
    }
}
