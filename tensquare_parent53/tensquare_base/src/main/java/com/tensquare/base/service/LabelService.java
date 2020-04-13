package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aheadx on 2020/4/11.
 */
@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;
    /*** 查询全部标签 * @return */
    public List<Label> findAll(){
        return labelDao.findAll();
    }
    /*** 根据ID查询标签 * @return */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }
    /*** 增加标签 * @param label */
    public void add(Label label){
        label.setId( idWorker.nextId()+"" );//设置ID
        labelDao.save(label);
        }
    /*** 修改标签 * @param label */
    public void update(Label label){
        labelDao.save(label);
    }
    /*** 删除标签 * @param id */
    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    public List<Label> findSearch(Label label) {
       return labelDao.findAll(new Specification<Label>() {
           /**
            * @param root   跟对象，也就是要把条件封装到哪个对象中。where 类名=label getid
            * @param criteriaQuery  封装的是查询关键字，比如group by order by等
            * @param criteriaBuilder 用来封装条件对象的,如果直接返回null，表示不需要任何条件
            * @return
            */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        });
    }
}
