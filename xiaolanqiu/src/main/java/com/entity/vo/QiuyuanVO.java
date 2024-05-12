package com.entity.vo;

import com.entity.QiuyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 球员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiuyuan")
public class QiuyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 球队
     */

    @TableField(value = "qiudui_id")
    private Integer qiuduiId;


    /**
     * 球员名称
     */

    @TableField(value = "qiuyuan_name")
    private String qiuyuanName;


    /**
     * 身高(米)
     */

    @TableField(value = "shangpin_shengao")
    private Double shangpinShengao;


    /**
     * 体重(kg)
     */

    @TableField(value = "shangpin_tizhong")
    private Double shangpinTizhong;


    /**
     * 国籍
     */

    @TableField(value = "guoji_types")
    private Integer guojiTypes;


    /**
     * 球员编号
     */

    @TableField(value = "qiuyuan_uuid_number")
    private String qiuyuanUuidNumber;


    /**
     * 生日
     */

    @TableField(value = "qiuyuan_shengri")
    private String qiuyuanShengri;


    /**
     * 球员照片
     */

    @TableField(value = "qiuyuan_photo")
    private String qiuyuanPhoto;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 球员位置
     */

    @TableField(value = "qiuyuan_types")
    private Integer qiuyuanTypes;


    /**
     * 入队时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "rudui_time")
    private Date ruduiTime;


    /**
     * 球员介绍
     */

    @TableField(value = "qiuyuan_content")
    private String qiuyuanContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：球队
	 */
    public Integer getQiuduiId() {
        return qiuduiId;
    }


    /**
	 * 获取：球队
	 */

    public void setQiuduiId(Integer qiuduiId) {
        this.qiuduiId = qiuduiId;
    }
    /**
	 * 设置：球员名称
	 */
    public String getQiuyuanName() {
        return qiuyuanName;
    }


    /**
	 * 获取：球员名称
	 */

    public void setQiuyuanName(String qiuyuanName) {
        this.qiuyuanName = qiuyuanName;
    }
    /**
	 * 设置：身高(米)
	 */
    public Double getShangpinShengao() {
        return shangpinShengao;
    }


    /**
	 * 获取：身高(米)
	 */

    public void setShangpinShengao(Double shangpinShengao) {
        this.shangpinShengao = shangpinShengao;
    }
    /**
	 * 设置：体重(kg)
	 */
    public Double getShangpinTizhong() {
        return shangpinTizhong;
    }


    /**
	 * 获取：体重(kg)
	 */

    public void setShangpinTizhong(Double shangpinTizhong) {
        this.shangpinTizhong = shangpinTizhong;
    }
    /**
	 * 设置：国籍
	 */
    public Integer getGuojiTypes() {
        return guojiTypes;
    }


    /**
	 * 获取：国籍
	 */

    public void setGuojiTypes(Integer guojiTypes) {
        this.guojiTypes = guojiTypes;
    }
    /**
	 * 设置：球员编号
	 */
    public String getQiuyuanUuidNumber() {
        return qiuyuanUuidNumber;
    }


    /**
	 * 获取：球员编号
	 */

    public void setQiuyuanUuidNumber(String qiuyuanUuidNumber) {
        this.qiuyuanUuidNumber = qiuyuanUuidNumber;
    }
    /**
	 * 设置：生日
	 */
    public String getQiuyuanShengri() {
        return qiuyuanShengri;
    }


    /**
	 * 获取：生日
	 */

    public void setQiuyuanShengri(String qiuyuanShengri) {
        this.qiuyuanShengri = qiuyuanShengri;
    }
    /**
	 * 设置：球员照片
	 */
    public String getQiuyuanPhoto() {
        return qiuyuanPhoto;
    }


    /**
	 * 获取：球员照片
	 */

    public void setQiuyuanPhoto(String qiuyuanPhoto) {
        this.qiuyuanPhoto = qiuyuanPhoto;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：球员位置
	 */
    public Integer getQiuyuanTypes() {
        return qiuyuanTypes;
    }


    /**
	 * 获取：球员位置
	 */

    public void setQiuyuanTypes(Integer qiuyuanTypes) {
        this.qiuyuanTypes = qiuyuanTypes;
    }
    /**
	 * 设置：入队时间
	 */
    public Date getRuduiTime() {
        return ruduiTime;
    }


    /**
	 * 获取：入队时间
	 */

    public void setRuduiTime(Date ruduiTime) {
        this.ruduiTime = ruduiTime;
    }
    /**
	 * 设置：球员介绍
	 */
    public String getQiuyuanContent() {
        return qiuyuanContent;
    }


    /**
	 * 获取：球员介绍
	 */

    public void setQiuyuanContent(String qiuyuanContent) {
        this.qiuyuanContent = qiuyuanContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
