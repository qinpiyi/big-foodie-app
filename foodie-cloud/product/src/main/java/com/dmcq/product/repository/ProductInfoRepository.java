package com.dmcq.product.repository;

import com.dmcq.product.domain.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Title ProductInfoRepository
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 11:07
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
