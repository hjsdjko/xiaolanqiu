package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 赛事详情
 *
 * @author 
 * @email
 */
@TableName("saishixinxi_xiangqing")
public class SaishixinxiXiangqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SaishixinxiXiangqingEntity() {

	}

	public SaishixinxiXiangqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 赛事信息
     */
    @ColumnInfo(comment="赛事信息",type="int(11)")
    @TableField(value = "saishixinxi_id")

    private Integer saishixinxiId;


    /**
     * 球员
     */
    @ColumnInfo(comment="球员",type="int(11)")
    @TableField(value = "qiuyuan_id")

    private Integer qiuyuanId;


    /**
     * 赛事详情编号
     */
    @ColumnInfo(comment="赛事详情编号",type="varchar(200)")
    @TableField(value = "saishixinxi_xiangqing_uuid_number")

    private String saishixinxiXiangqingUuidNumber;


    /**
     * 标题
     */
    @ColumnInfo(comment="标题",type="varchar(200)")
    @TableField(value = "saishixinxi_xiangqing_name")

    private String saishixinxiXiangqingName;


    /**
     * 类型
     */
    @ColumnInfo(comment="类型",type="int(11)")
    @TableField(value = "saishixinxi_xiangqing_types")

    private Integer saishixinxiXiangqingTypes;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "saishixinxi_xiangqing_file")

    private String saishixinxiXiangqingFile;


    /**
     * 分值
     */
    @ColumnInfo(comment="分值",type="int(11)")
    @TableField(value = "saishixinxi_xiangqing_defen")

    private Integer saishixinxiXiangqingDefen;


    /**
     * 发生时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发生时间",type="timestamp")
    @TableField(value = "saishixinxi_xiangqing_time")

    private Date saishixinxiXiangqingTime;


    /**
     * 详情
     */
    @ColumnInfo(comment="详情",type="longtext")
    @TableField(value = "saishixinxi_xiangqing_content")

    private String saishixinxiXiangqingContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：赛事信息
	 */
    public Integer getSaishixinxiId() {
        return saishixinxiId;
    }
    /**
	 * 设置：赛事信息
	 */

    public void setSaishixinxiId(Integer saishixinxiId) {
        this.saishixinxiId = saishixinxiId;
    }
    /**
	 * 获取：球员
	 */
    public Integer getQiuyuanId() {
        return qiuyuanId;
    }
    /**
	 * 设置：球员
	 */

    public void setQiuyuanId(Integer qiuyuanId) {
        this.qiuyuanId = qiuyuanId;
    }
    /**
	 * 获取：赛事详情编号
	 */
    public String getSaishixinxiXiangqingUuidNumber() {
        return saishixinxiXiangqingUuidNumber;
    }
    /**
	 * 设置：赛事详情编号
	 */

    public void setSaishixinxiXiangqingUuidNumber(String saishixinxiXiangqingUuidNumber) {
        this.saishixinxiXiangqingUuidNumber = saishixinxiXiangqingUuidNumber;
    }
    /**
	 * 获取：标题
	 */
    public String getSaishixinxiXiangqingName() {
        return saishixinxiXiangqingName;
    }
    /**
	 * 设置：标题
	 */

    public void setSaishixinxiXiangqingName(String saishixinxiXiangqingName) {
        this.saishixinxiXiangqingName = saishixinxiXiangqingName;
    }
    /**
	 * 获取：类型
	 */
    public Integer getSaishixinxiXiangqingTypes() {
        return saishixinxiXiangqingTypes;
    }
    /**
	 * 设置：类型
	 */

    public void setSaishixinxiXiangqingTypes(Integer saishixinxiXiangqingTypes) {
        this.saishixinxiXiangqingTypes = saishixinxiXiangqingTypes;
    }
    /**
	 * 获取：附件
	 */
    public String getSaishixinxiXiangqingFile() {
        return saishixinxiXiangqingFile;
    }
    /**
	 * 设置：附件
	 */

    public void setSaishixinxiXiangqingFile(String saishixinxiXiangqingFile) {
        this.saishixinxiXiangqingFile = saishixinxiXiangqingFile;
    }
    /**
	 * 获取：分值
	 */
    public Integer getSaishixinxiXiangqingDefen() {
        return saishixinxiXiangqingDefen;
    }
    /**
	 * 设置：分值
	 */

    public void setSaishixinxiXiangqingDefen(Integer saishixinxiXiangqingDefen) {
        this.saishixinxiXiangqingDefen = saishixinxiXiangqingDefen;
    }
    /**
	 * 获取：发生时间
	 */
    public Date getSaishixinxiXiangqingTime() {
        return saishixinxiXiangqingTime;
    }
    /**
	 * 设置：发生时间
	 */

    public void setSaishixinxiXiangqingTime(Date saishixinxiXiangqingTime) {
        this.saishixinxiXiangqingTime = saishixinxiXiangqingTime;
    }
    /**
	 * 获取：详情
	 */
    public String getSaishixinxiXiangqingContent() {
        return saishixinxiXiangqingContent;
    }
    /**
	 * 设置：详情
	 */

    public void setSaishixinxiXiangqingContent(String saishixinxiXiangqingContent) {
        this.saishixinxiXiangqingContent = saishixinxiXiangqingContent;
    }
    /**
	 * 获取：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SaishixinxiXiangqing{" +
            ", id=" + id +
            ", saishixinxiId=" + saishixinxiId +
            ", qiuyuanId=" + qiuyuanId +
            ", saishixinxiXiangqingUuidNumber=" + saishixinxiXiangqingUuidNumber +
            ", saishixinxiXiangqingName=" + saishixinxiXiangqingName +
            ", saishixinxiXiangqingTypes=" + saishixinxiXiangqingTypes +
            ", saishixinxiXiangqingFile=" + saishixinxiXiangqingFile +
            ", saishixinxiXiangqingDefen=" + saishixinxiXiangqingDefen +
            ", saishixinxiXiangqingTime=" + DateUtil.convertString(saishixinxiXiangqingTime,"yyyy-MM-dd") +
            ", saishixinxiXiangqingContent=" + saishixinxiXiangqingContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
