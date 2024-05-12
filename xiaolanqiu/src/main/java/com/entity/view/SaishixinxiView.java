package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SaishixinxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 赛事信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("saishixinxi")
public class SaishixinxiView extends SaishixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 阶段的值
	*/
	@ColumnInfo(comment="阶段的字典表值",type="varchar(200)")
	private String saishixinxiValue;
	/**
	* 胜利队伍的值
	*/
	@ColumnInfo(comment="胜利队伍的字典表值",type="varchar(200)")
	private String shengliValue;




	public SaishixinxiView() {

	}

	public SaishixinxiView(SaishixinxiEntity saishixinxiEntity) {
		try {
			BeanUtils.copyProperties(this, saishixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 阶段的值
	*/
	public String getSaishixinxiValue() {
		return saishixinxiValue;
	}
	/**
	* 设置： 阶段的值
	*/
	public void setSaishixinxiValue(String saishixinxiValue) {
		this.saishixinxiValue = saishixinxiValue;
	}
	//当前表的
	/**
	* 获取： 胜利队伍的值
	*/
	public String getShengliValue() {
		return shengliValue;
	}
	/**
	* 设置： 胜利队伍的值
	*/
	public void setShengliValue(String shengliValue) {
		this.shengliValue = shengliValue;
	}




	@Override
	public String toString() {
		return "SaishixinxiView{" +
			", saishixinxiValue=" + saishixinxiValue +
			", shengliValue=" + shengliValue +
			"} " + super.toString();
	}
}
