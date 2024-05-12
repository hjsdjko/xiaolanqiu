package com.entity.vo;

import com.entity.SaishixinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 赛事信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("saishixinxi")
public class SaishixinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 赛事信息编号
     */

    @TableField(value = "saishixinxi_uuid_number")
    private String saishixinxiUuidNumber;


    /**
     * 比赛时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "bisia_time")
    private Date bisiaTime;


    /**
     * 赛事照片
     */

    @TableField(value = "saishixinxi_photo")
    private String saishixinxiPhoto;


    /**
     * 主队
     */

    @TableField(value = "saishixinxi_zhudui")
    private String saishixinxiZhudui;


    /**
     * 客队
     */

    @TableField(value = "saishixinxi_kedui")
    private String saishixinxiKedui;


    /**
     * 比赛场地
     */

    @TableField(value = "saishixinxi_changdi")
    private String saishixinxiChangdi;


    /**
     * 比赛备注
     */

    @TableField(value = "saishixinxi_content")
    private String saishixinxiContent;


    /**
     * 阶段
     */

    @TableField(value = "saishixinxi_types")
    private Integer saishixinxiTypes;


    /**
     * 胜利队伍
     */

    @TableField(value = "shengli_types")
    private Integer shengliTypes;


    /**
     * 上传时间
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
	 * 设置：赛事信息编号
	 */
    public String getSaishixinxiUuidNumber() {
        return saishixinxiUuidNumber;
    }


    /**
	 * 获取：赛事信息编号
	 */

    public void setSaishixinxiUuidNumber(String saishixinxiUuidNumber) {
        this.saishixinxiUuidNumber = saishixinxiUuidNumber;
    }
    /**
	 * 设置：比赛时间
	 */
    public Date getBisiaTime() {
        return bisiaTime;
    }


    /**
	 * 获取：比赛时间
	 */

    public void setBisiaTime(Date bisiaTime) {
        this.bisiaTime = bisiaTime;
    }
    /**
	 * 设置：赛事照片
	 */
    public String getSaishixinxiPhoto() {
        return saishixinxiPhoto;
    }


    /**
	 * 获取：赛事照片
	 */

    public void setSaishixinxiPhoto(String saishixinxiPhoto) {
        this.saishixinxiPhoto = saishixinxiPhoto;
    }
    /**
	 * 设置：主队
	 */
    public String getSaishixinxiZhudui() {
        return saishixinxiZhudui;
    }


    /**
	 * 获取：主队
	 */

    public void setSaishixinxiZhudui(String saishixinxiZhudui) {
        this.saishixinxiZhudui = saishixinxiZhudui;
    }
    /**
	 * 设置：客队
	 */
    public String getSaishixinxiKedui() {
        return saishixinxiKedui;
    }


    /**
	 * 获取：客队
	 */

    public void setSaishixinxiKedui(String saishixinxiKedui) {
        this.saishixinxiKedui = saishixinxiKedui;
    }
    /**
	 * 设置：比赛场地
	 */
    public String getSaishixinxiChangdi() {
        return saishixinxiChangdi;
    }


    /**
	 * 获取：比赛场地
	 */

    public void setSaishixinxiChangdi(String saishixinxiChangdi) {
        this.saishixinxiChangdi = saishixinxiChangdi;
    }
    /**
	 * 设置：比赛备注
	 */
    public String getSaishixinxiContent() {
        return saishixinxiContent;
    }


    /**
	 * 获取：比赛备注
	 */

    public void setSaishixinxiContent(String saishixinxiContent) {
        this.saishixinxiContent = saishixinxiContent;
    }
    /**
	 * 设置：阶段
	 */
    public Integer getSaishixinxiTypes() {
        return saishixinxiTypes;
    }


    /**
	 * 获取：阶段
	 */

    public void setSaishixinxiTypes(Integer saishixinxiTypes) {
        this.saishixinxiTypes = saishixinxiTypes;
    }
    /**
	 * 设置：胜利队伍
	 */
    public Integer getShengliTypes() {
        return shengliTypes;
    }


    /**
	 * 获取：胜利队伍
	 */

    public void setShengliTypes(Integer shengliTypes) {
        this.shengliTypes = shengliTypes;
    }
    /**
	 * 设置：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上传时间
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
