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
 * 球员
 *
 * @author 
 * @email
 */
@TableName("qiuyuan")
public class QiuyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QiuyuanEntity() {

	}

	public QiuyuanEntity(T t) {
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
     * 球队
     */
    @ColumnInfo(comment="球队",type="int(11)")
    @TableField(value = "qiudui_id")

    private Integer qiuduiId;


    /**
     * 球员名称
     */
    @ColumnInfo(comment="球员名称",type="varchar(200)")
    @TableField(value = "qiuyuan_name")

    private String qiuyuanName;


    /**
     * 身高(米)
     */
    @ColumnInfo(comment="身高(米)",type="decimal(10,2)")
    @TableField(value = "shangpin_shengao")

    private Double shangpinShengao;


    /**
     * 体重(kg)
     */
    @ColumnInfo(comment="体重(kg)",type="decimal(10,2)")
    @TableField(value = "shangpin_tizhong")

    private Double shangpinTizhong;


    /**
     * 国籍
     */
    @ColumnInfo(comment="国籍",type="int(11)")
    @TableField(value = "guoji_types")

    private Integer guojiTypes;


    /**
     * 球员编号
     */
    @ColumnInfo(comment="球员编号",type="varchar(200)")
    @TableField(value = "qiuyuan_uuid_number")

    private String qiuyuanUuidNumber;


    /**
     * 生日
     */
    @ColumnInfo(comment="生日",type="varchar(200)")
    @TableField(value = "qiuyuan_shengri")

    private String qiuyuanShengri;


    /**
     * 球员照片
     */
    @ColumnInfo(comment="球员照片",type="varchar(200)")
    @TableField(value = "qiuyuan_photo")

    private String qiuyuanPhoto;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 球员位置
     */
    @ColumnInfo(comment="球员位置",type="int(11)")
    @TableField(value = "qiuyuan_types")

    private Integer qiuyuanTypes;


    /**
     * 入队时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="入队时间",type="timestamp")
    @TableField(value = "rudui_time")

    private Date ruduiTime;


    /**
     * 球员介绍
     */
    @ColumnInfo(comment="球员介绍",type="longtext")
    @TableField(value = "qiuyuan_content")

    private String qiuyuanContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
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
	 * 获取：球队
	 */
    public Integer getQiuduiId() {
        return qiuduiId;
    }
    /**
	 * 设置：球队
	 */

    public void setQiuduiId(Integer qiuduiId) {
        this.qiuduiId = qiuduiId;
    }
    /**
	 * 获取：球员名称
	 */
    public String getQiuyuanName() {
        return qiuyuanName;
    }
    /**
	 * 设置：球员名称
	 */

    public void setQiuyuanName(String qiuyuanName) {
        this.qiuyuanName = qiuyuanName;
    }
    /**
	 * 获取：身高(米)
	 */
    public Double getShangpinShengao() {
        return shangpinShengao;
    }
    /**
	 * 设置：身高(米)
	 */

    public void setShangpinShengao(Double shangpinShengao) {
        this.shangpinShengao = shangpinShengao;
    }
    /**
	 * 获取：体重(kg)
	 */
    public Double getShangpinTizhong() {
        return shangpinTizhong;
    }
    /**
	 * 设置：体重(kg)
	 */

    public void setShangpinTizhong(Double shangpinTizhong) {
        this.shangpinTizhong = shangpinTizhong;
    }
    /**
	 * 获取：国籍
	 */
    public Integer getGuojiTypes() {
        return guojiTypes;
    }
    /**
	 * 设置：国籍
	 */

    public void setGuojiTypes(Integer guojiTypes) {
        this.guojiTypes = guojiTypes;
    }
    /**
	 * 获取：球员编号
	 */
    public String getQiuyuanUuidNumber() {
        return qiuyuanUuidNumber;
    }
    /**
	 * 设置：球员编号
	 */

    public void setQiuyuanUuidNumber(String qiuyuanUuidNumber) {
        this.qiuyuanUuidNumber = qiuyuanUuidNumber;
    }
    /**
	 * 获取：生日
	 */
    public String getQiuyuanShengri() {
        return qiuyuanShengri;
    }
    /**
	 * 设置：生日
	 */

    public void setQiuyuanShengri(String qiuyuanShengri) {
        this.qiuyuanShengri = qiuyuanShengri;
    }
    /**
	 * 获取：球员照片
	 */
    public String getQiuyuanPhoto() {
        return qiuyuanPhoto;
    }
    /**
	 * 设置：球员照片
	 */

    public void setQiuyuanPhoto(String qiuyuanPhoto) {
        this.qiuyuanPhoto = qiuyuanPhoto;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：球员位置
	 */
    public Integer getQiuyuanTypes() {
        return qiuyuanTypes;
    }
    /**
	 * 设置：球员位置
	 */

    public void setQiuyuanTypes(Integer qiuyuanTypes) {
        this.qiuyuanTypes = qiuyuanTypes;
    }
    /**
	 * 获取：入队时间
	 */
    public Date getRuduiTime() {
        return ruduiTime;
    }
    /**
	 * 设置：入队时间
	 */

    public void setRuduiTime(Date ruduiTime) {
        this.ruduiTime = ruduiTime;
    }
    /**
	 * 获取：球员介绍
	 */
    public String getQiuyuanContent() {
        return qiuyuanContent;
    }
    /**
	 * 设置：球员介绍
	 */

    public void setQiuyuanContent(String qiuyuanContent) {
        this.qiuyuanContent = qiuyuanContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
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
        return "Qiuyuan{" +
            ", id=" + id +
            ", qiuduiId=" + qiuduiId +
            ", qiuyuanName=" + qiuyuanName +
            ", shangpinShengao=" + shangpinShengao +
            ", shangpinTizhong=" + shangpinTizhong +
            ", guojiTypes=" + guojiTypes +
            ", qiuyuanUuidNumber=" + qiuyuanUuidNumber +
            ", qiuyuanShengri=" + qiuyuanShengri +
            ", qiuyuanPhoto=" + qiuyuanPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", qiuyuanTypes=" + qiuyuanTypes +
            ", ruduiTime=" + DateUtil.convertString(ruduiTime,"yyyy-MM-dd") +
            ", qiuyuanContent=" + qiuyuanContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
