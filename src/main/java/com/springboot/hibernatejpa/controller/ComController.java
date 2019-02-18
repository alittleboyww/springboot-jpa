package com.springboot.hibernatejpa.controller;

import com.springboot.hibernatejpa.model.Company;
import com.springboot.hibernatejpa.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comApi")
public class ComController {
    @Autowired
    private ComService comService;

    @ResponseBody
    @RequestMapping("selectComById")
    public Company selectCompany(Integer id){
        return comService.findById(id);
    }

    @ResponseBody
    @RequestMapping("selectComList")
    public List<Company> selectComList(Integer isCheck){
        return comService.findByIsCheck(isCheck);
    }

    @ResponseBody
    @RequestMapping("selectComListPage")
    public Page<Company> selectComListPage(Integer isCheck,Integer page){
        int size = 3;
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        //这里不适用PageRequest构造函数 而是直接调用器静态方法
        Pageable pageable = PageRequest.of(page,size,sort);
        return comService.findByIsCheck(isCheck,pageable);
    }
    //使用sql
    @ResponseBody
    @RequestMapping("selectComListByName")
    public List<Company> selectComByName(String comName){
        return comService.selectShopName(comName);
    }

    //使用jpql
    @ResponseBody
    @RequestMapping("getComListByName")
    public List<Company> getComListByName(String comName){
        return comService.getShopName(comName);
    }
}
