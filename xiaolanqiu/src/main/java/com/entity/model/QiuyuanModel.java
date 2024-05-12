package com.entity.model;

import com.entity.QiuyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 球员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QiuyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 球队
     */
    private Integer qiuduiId;


    /**
     * 球员名称
     */
    private String qiuyuanName;


    /**
     * 身高(米)
     */
    private Double shangpinShengao;


    /**
     * 体重(kg)
     */
    private Double shangpinTizhong;


    /**
     * 国籍
     */
    private Integer guojiTypes;


    /**
     * 球员编号
     */
    private String qiuyuanUuidNumber;


    /**
     * 生日
     */
    private String qiuyuanShengri;


    /**
     * 球员照片
     */
    private String qiuyuanPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 球员位置
     */
    private Integer qiuyuanTypes;


    /**
     * 入队时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date ruduiTime;


    /**
     * 球员介绍
     */
    private String qiuyuanContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
