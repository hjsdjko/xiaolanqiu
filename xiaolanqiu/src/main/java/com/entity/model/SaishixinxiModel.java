package com.entity.model;

import com.entity.SaishixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛事信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaishixinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 赛事信息编号
     */
    private String saishixinxiUuidNumber;


    /**
     * 比赛时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date bisiaTime;


    /**
     * 赛事照片
     */
    private String saishixinxiPhoto;


    /**
     * 主队
     */
    private String saishixinxiZhudui;


    /**
     * 客队
     */
    private String saishixinxiKedui;


    /**
     * 比赛场地
     */
    private String saishixinxiChangdi;


    /**
     * 比赛备注
     */
    private String saishixinxiContent;


    /**
     * 阶段
     */
    private Integer saishixinxiTypes;


    /**
     * 胜利队伍
     */
    private Integer shengliTypes;


    /**
     * 上传时间
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
