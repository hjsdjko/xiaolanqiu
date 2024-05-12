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
 * 赛事信息
 *
 * @author 
 * @email
 */
@TableName("saishixinxi")
public class SaishixinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SaishixinxiEntity() {

	}

	public SaishixinxiEntity(T t) {
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
     * 赛事信息编号
     */
    @ColumnInfo(comment="赛事信息编号",type="varchar(200)")
    @TableField(value = "saishixinxi_uuid_number")

    private String saishixinxiUuidNumber;


    /**
     * 比赛时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="比赛时间",type="timestamp")
    @TableField(value = "bisia_time")

    private Date bisiaTime;


    /**
     * 赛事照片
     */
    @ColumnInfo(comment="赛事照片",type="varchar(200)")
    @TableField(value = "saishixinxi_photo")

    private String saishixinxiPhoto;


    /**
     * 主队
     */
    @ColumnInfo(comment="主队",type="varchar(200)")
    @TableField(value = "saishixinxi_zhudui")

    private String saishixinxiZhudui;


    /**
     * 客队
     */
    @ColumnInfo(comment="客队",type="varchar(200)")
    @TableField(value = "saishixinxi_kedui")

    private String saishixinxiKedui;


    /**
     * 比赛场地
     */
    @ColumnInfo(comment="比赛场地",type="varchar(200)")
    @TableField(value = "saishixinxi_changdi")

    private String saishixinxiChangdi;


    /**
     * 比赛备注
     */
    @ColumnInfo(comment="比赛备注",type="longtext")
    @TableField(value = "saishixinxi_content")

    private String saishixinxiContent;


    /**
     * 阶段
     */
    @ColumnInfo(comment="阶段",type="int(11)")
    @TableField(value = "saishixinxi_types")

    private Integer saishixinxiTypes;


    /**
     * 胜利队伍
     */
    @ColumnInfo(comment="胜利队伍",type="int(11)")
    @TableField(value = "shengli_types")

    private Integer shengliTypes;


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
	 * 获取：赛事信息编号
	 */
    public String getSaishixinxiUuidNumber() {
        return saishixinxiUuidNumber;
    }
    /**
	 * 设置：赛事信息编号
	 */

    public void setSaishixinxiUuidNumber(String saishixinxiUuidNumber) {
        this.saishixinxiUuidNumber = saishixinxiUuidNumber;
    }
    /**
	 * 获取：比赛时间
	 */
    public Date getBisiaTime() {
        return bisiaTime;
    }
    /**
	 * 设置：比赛时间
	 */

    public void setBisiaTime(Date bisiaTime) {
        this.bisiaTime = bisiaTime;
    }
    /**
	 * 获取：赛事照片
	 */
    public String getSaishixinxiPhoto() {
        return saishixinxiPhoto;
    }
    /**
	 * 设置：赛事照片
	 */

    public void setSaishixinxiPhoto(String saishixinxiPhoto) {
        this.saishixinxiPhoto = saishixinxiPhoto;
    }
    /**
	 * 获取：主队
	 */
    public String getSaishixinxiZhudui() {
        return saishixinxiZhudui;
    }
    /**
	 * 设置：主队
	 */

    public void setSaishixinxiZhudui(String saishixinxiZhudui) {
        this.saishixinxiZhudui = saishixinxiZhudui;
    }
    /**
	 * 获取：客队
	 */
    public String getSaishixinxiKedui() {
        return saishixinxiKedui;
    }
    /**
	 * 设置：客队
	 */

    public void setSaishixinxiKedui(String saishixinxiKedui) {
        this.saishixinxiKedui = saishixinxiKedui;
    }
    /**
	 * 获取：比赛场地
	 */
    public String getSaishixinxiChangdi() {
        return saishixinxiChangdi;
    }
    /**
	 * 设置：比赛场地
	 */

    public void setSaishixinxiChangdi(String saishixinxiChangdi) {
        this.saishixinxiChangdi = saishixinxiChangdi;
    }
    /**
	 * 获取：比赛备注
	 */
    public String getSaishixinxiContent() {
        return saishixinxiContent;
    }
    /**
	 * 设置：比赛备注
	 */

    public void setSaishixinxiContent(String saishixinxiContent) {
        this.saishixinxiContent = saishixinxiContent;
    }
    /**
	 * 获取：阶段
	 */
    public Integer getSaishixinxiTypes() {
        return saishixinxiTypes;
    }
    /**
	 * 设置：阶段
	 */

    public void setSaishixinxiTypes(Integer saishixinxiTypes) {
        this.saishixinxiTypes = saishixinxiTypes;
    }
    /**
	 * 获取：胜利队伍
	 */
    public Integer getShengliTypes() {
        return shengliTypes;
    }
    /**
	 * 设置：胜利队伍
	 */

    public void setShengliTypes(Integer shengliTypes) {
        this.shengliTypes = shengliTypes;
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
        return "Saishixinxi{" +
            ", id=" + id +
            ", saishixinxiUuidNumber=" + saishixinxiUuidNumber +
            ", bisiaTime=" + DateUtil.convertString(bisiaTime,"yyyy-MM-dd") +
            ", saishixinxiPhoto=" + saishixinxiPhoto +
            ", saishixinxiZhudui=" + saishixinxiZhudui +
            ", saishixinxiKedui=" + saishixinxiKedui +
            ", saishixinxiChangdi=" + saishixinxiChangdi +
            ", saishixinxiContent=" + saishixinxiContent +
            ", saishixinxiTypes=" + saishixinxiTypes +
            ", shengliTypes=" + shengliTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
