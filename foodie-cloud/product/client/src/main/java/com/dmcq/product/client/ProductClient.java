package com.dmcq.product.client;

import com.dmcq.product.common.entity.DeductStockInput;
import com.dmcq.product.common.entity.ProductInfoOutPut;
import com.qinpiyi.common.response.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Title ProductClient
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/12 9:10
 **/
@FeignClient(name = "product")
public interface ProductClient {

    /**
     * 根据id列表查询商品信息列表
     */
    @PostMapping("/product/quaryListByIds")
    public List<ProductInfoOutPut> quaryListByIds(@RequestBody List<String> ids);
    /**
     * 批量扣库存
     */
    @PostMapping("/product/deductStock")
    public CommonResponse deductStock(@RequestBody List<DeductStockInput> list);
}
