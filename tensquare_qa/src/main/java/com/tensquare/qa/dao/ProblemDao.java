package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author ysl
 * @Date 2019/10/23 23:37
 * @Description: 数据访问接口
 **/
public interface ProblemDao extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {


    /**
     *  根据标签ID查询最新问题列表
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in( select problemid from Pl where labelid=?1 ) order by replytime desc")
    public Page<Problem> findNewListByLabelId(String labelId, Pageable pageable);


    /**
     * 根据标签ID查询热门问题列表
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in(select problemid from Pl where labelid=?1) order by reply desc")
    public Page<Problem> findHotListByLaelId(String labelId,Pageable pageable);
}
