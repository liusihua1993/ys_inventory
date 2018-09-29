package com.ys.inventory.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 实体类对应的数据表为：  product_temp
 * @author mlink
 * @date 2018-09-04 10:47:47
 */
@ApiModel(value ="产品模板表")
public class ProductTemp {
    @ApiModelProperty(value = "主键")
    private String productTempId;

    @ApiModelProperty(value = "产品模板名称")
    private String productTempName;

    @ApiModelProperty(value = "产品模板描述")
    private String productTempDescribe;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "创建人")
    private String updateUser;

    @ApiModelProperty(value = "修改时间")
    private Long updateTime;

    @ApiModelProperty(value = "是否删除(1删除 默认0)")
    private String deleteFlag;

    @ApiModelProperty(value = "模板对应的原料消耗信息")
    private List<ProductTempMaterial> productTempMaterialList;

    public String getProductTempId() {
        return productTempId;
    }

    public void setProductTempId(String productTempId) {
        this.productTempId = productTempId;
    }

    public String getProductTempName() {
        return productTempName;
    }

    public void setProductTempName(String productTempName) {
        this.productTempName = productTempName;
    }

    public String getProductTempDescribe() {
        return productTempDescribe;
    }

    public void setProductTempDescribe(String productTempDescribe) {
        this.productTempDescribe = productTempDescribe;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getupdateUser() {
        return updateUser;
    }

    public void setupdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public List<ProductTempMaterial> getProductTempMaterialList() {
        return productTempMaterialList;
    }

    public void setProductTempMaterialList(List<ProductTempMaterial> productTempMaterialList) {
        this.productTempMaterialList = productTempMaterialList;
    }
}
