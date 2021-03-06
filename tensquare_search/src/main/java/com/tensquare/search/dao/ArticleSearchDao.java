package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author ysl
 * @Date 2019/10/27 11:11
 * @Description:    文章数据访问层接口
 **/
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {


    /**
     * 检索
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String title,String content, Pageable pageable);
}
