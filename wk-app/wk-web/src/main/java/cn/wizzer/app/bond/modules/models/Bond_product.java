package cn.wizzer.app.bond.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 产品表
 */
@Table("bond_product")
public class Bond_product extends BaseModel implements Serializable {
    @Column
    @Name
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("产品代码")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String productCode;

    @Column
    @Comment("产品名称")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String productName;

    @Column
    @Comment("上层产品代码")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String preProductCode;

    @Column
    @Comment("下层产品代码")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String sufProductCode;

    @Column
    @Comment("备注")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPreProductCode() {
        return preProductCode;
    }

    public void setPreProductCode(String preProductCode) {
        this.preProductCode = preProductCode;
    }

    public String getSufProductCode() {
        return sufProductCode;
    }

    public void setSufProductCode(String sufProductCode) {
        this.sufProductCode = sufProductCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bond_product that = (Bond_product) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (preProductCode != null ? !preProductCode.equals(that.preProductCode) : that.preProductCode != null)
            return false;
        if (sufProductCode != null ? !sufProductCode.equals(that.sufProductCode) : that.sufProductCode != null)
            return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (preProductCode != null ? preProductCode.hashCode() : 0);
        result = 31 * result + (sufProductCode != null ? sufProductCode.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bond_product{" +
                "id='" + id + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", preProductCode='" + preProductCode + '\'' +
                ", sufProductCode='" + sufProductCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
