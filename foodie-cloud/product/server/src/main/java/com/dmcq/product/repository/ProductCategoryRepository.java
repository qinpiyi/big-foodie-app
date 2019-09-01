package com.dmcq.product.repository;

import com.dmcq.product.domain.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title ProductCategoryRepository
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 14:11
 **/
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
