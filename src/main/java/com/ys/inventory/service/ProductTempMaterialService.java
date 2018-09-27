package com.ys.inventory.service;
import com.ys.inventory.entity.ProductTempMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liusihua.
 * @date 2018/09/04.
 * 注:  需要回归接口添加 注解 ：@Transactional(rollbackFor = Exception.class)
 */


@Service
@EnableTransactionManagement
public class ProductTempMaterialService  {
    @Autowired(required = false)
    private ProductTempMaterial mapper;

}


