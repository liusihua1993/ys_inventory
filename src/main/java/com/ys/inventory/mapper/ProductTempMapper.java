package com.ys.inventory.mapper;

import com.ys.inventory.entity.ProductTemp;
import com.ys.inventory.vo.ProductTempSearchVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductTempMapper {
    /**
     * 新增产品模板
     * @param record
     * @return
     */
    int insert(ProductTemp record);

    /**
     * 获取详情
     * @param productTempId
     * @return
     */
    ProductTemp get(String productTempId);

    List<ProductTemp> selectAll();

    /**
     * 修改产品模板
     * @param record
     * @return
     */
    int updateProductTemp(ProductTemp record);

    /**
     * 查看是否存在同名模板
     * @param mapperMap
     * @return
     */
    ProductTemp getProductTempByName(Map<String, String> mapperMap);

    /**
     * 删除产品模板
     * @param mapperParam
     */
    void delete(HashMap<String, String> mapperParam);

    /**
     * 产品模板列表
     * @param vo
     * @return
     */
    List<ProductTemp> find(ProductTempSearchVO vo);
}