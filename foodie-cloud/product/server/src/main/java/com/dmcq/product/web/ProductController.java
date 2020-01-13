package com.dmcq.product.web;

import com.dmcq.product.domain.dto.SimpleCartDto;
import com.dmcq.product.domain.entity.ProductCategory;
import com.dmcq.product.domain.entity.ProductInfo;
import com.dmcq.product.domain.vo.ProductCategoryVo;
import com.dmcq.product.domain.vo.ProductInfoVo;
import com.dmcq.product.service.ProductCategoryService;
import com.dmcq.product.service.ProductInfoService;
import com.qinpiyi.common.response.CommonResponse;
import com.qinpiyi.common.response.CommonResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title ProductController
 * @Description TODO
 * @Author qinhao
 * @Date 2019/6/18 16:24
 **/
@Api(value = "商品", tags = "商品")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductInfoService productInfoService;
    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    AmqpTemplate amqpTemplate;

    @ApiOperation(value = "查询已上架商品列表")
    @GetMapping("/list")
    public CommonResponse list(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        System.out.println(Arrays.asList(cookies));
        //查询所有在架商品
        List<ProductInfo> productList = productInfoService.findUpAll();
        //获取类目列表
        List<Integer> categoryTypeList = productList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        //从数据库查询类目
        List<ProductCategory> categoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        //构造数据
        List<ProductCategoryVo> categoryVos = new ArrayList<ProductCategoryVo>();
        for (ProductCategory c : categoryList) {
            ProductCategoryVo categoryVo = new ProductCategoryVo();
            categoryVo.setCategoryName(c.getCategoryName());
            categoryVo.setCategoryType(c.getCategoryType());
            List<ProductInfoVo> infoVos = new ArrayList<ProductInfoVo>();
            for (ProductInfo p : productList) {
                if (p.getCategoryType() == c.getCategoryType()) {
                    ProductInfoVo infoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(p, infoVo);
                    infoVos.add(infoVo);
                }
            }
            categoryVo.setProductInfoVoList(infoVos);
            categoryVos.add(categoryVo);
        }
        return CommonResponseUtil.success(categoryVos);
    }

    /**
     * 根据id列表查询商品信息列表
     */
    @PostMapping("/quaryListByIds")
    public List<ProductInfo> quaryListByIds(@RequestBody List<String> ids){
        return productInfoService.findByIds(ids);
    }

    /**
     * 批量扣库存
     */
    @PostMapping("/deductStock")
    public CommonResponse deductStock(@RequestBody List<SimpleCartDto> list){
        productInfoService.deductStock(list);
        return CommonResponseUtil.success("扣库存成功");
    }

    @GetMapping("/mqTest")
    public void mqTest(){
        amqpTemplate.convertAndSend("myQueue","test");
    }
}
