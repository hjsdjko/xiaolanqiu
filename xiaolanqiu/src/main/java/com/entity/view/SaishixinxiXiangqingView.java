package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SaishixinxiXiangqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 赛事详情
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("saishixinxi_xiangqing")
public class SaishixinxiXiangqingView extends SaishixinxiXiangqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String saishixinxiXiangqingValue;

	//级联表 球员
							/**
		* 球员名称
		*/

		@ColumnInfo(comment="球员名称",type="varchar(200)")
		private String qiuyuanName;
		/**
		* 身高(米)
		*/
		@ColumnInfo(comment="身高(米)",type="decimal(10,2)")
		private Double shangpinShengao;
		/**
		* 体重(kg)
		*/
		@ColumnInfo(comment="体重(kg)",type="decimal(10,2)")
		private Double shangpinTizhong;
		/**
		* 国籍
		*/
		@ColumnInfo(comment="国籍",type="int(11)")
		private Integer guojiTypes;
			/**
			* 国籍的值
			*/
			@ColumnInfo(comment="国籍的字典表值",type="varchar(200)")
			private String guojiValue;
		/**
		* 球员编号
		*/

		@ColumnInfo(comment="球员编号",type="varchar(200)")
		private String qiuyuanUuidNumber;
		/**
		* 生日
		*/

		@ColumnInfo(comment="生日",type="varchar(200)")
		private String qiuyuanShengri;
		/**
		* 球员照片
		*/

		@ColumnInfo(comment="球员照片",type="varchar(200)")
		private String qiuyuanPhoto;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 球员位置
		*/
		@ColumnInfo(comment="球员位置",type="int(11)")
		private Integer qiuyuanTypes;
			/**
			* 球员位置的值
			*/
			@ColumnInfo(comment="球员位置的字典表值",type="varchar(200)")
			private String qiuyuanValue;
		/**
		* 入队时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="入队时间",type="timestamp")
		private Date ruduiTime;
		/**
		* 球员介绍
		*/

		@ColumnInfo(comment="球员介绍",type="longtext")
		private String qiuyuanContent;
	//级联表 赛事信息
		/**
		* 赛事信息编号
		*/

		@ColumnInfo(comment="赛事信息编号",type="varchar(200)")
		private String saishixinxiUuidNumber;
		/**
		* 比赛时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="比赛时间",type="timestamp")
		private Date bisiaTime;
		/**
		* 赛事照片
		*/

		@ColumnInfo(comment="赛事照片",type="varchar(200)")
		private String saishixinxiPhoto;
		/**
		* 主队
		*/

		@ColumnInfo(comment="主队",type="varchar(200)")
		private String saishixinxiZhudui;
		/**
		* 客队
		*/

		@ColumnInfo(comment="客队",type="varchar(200)")
		private String saishixinxiKedui;
		/**
		* 比赛场地
		*/

		@ColumnInfo(comment="比赛场地",type="varchar(200)")
		private String saishixinxiChangdi;
		/**
		* 比赛备注
		*/

		@ColumnInfo(comment="比赛备注",type="longtext")
		private String saishixinxiContent;
		/**
		* 阶段
		*/
		@ColumnInfo(comment="阶段",type="int(11)")
		private Integer saishixinxiTypes;
			/**
			* 阶段的值
			*/
			@ColumnInfo(comment="阶段的字典表值",type="varchar(200)")
			private String saishixinxiValue;
		/**
		* 胜利队伍
		*/
		@ColumnInfo(comment="胜利队伍",type="int(11)")
		private Integer shengliTypes;
			/**
			* 胜利队伍的值
			*/
			@ColumnInfo(comment="胜利队伍的字典表值",type="varchar(200)")
			private String shengliValue;



	public SaishixinxiXiangqingView() {

	}

	public SaishixinxiXiangqingView(SaishixinxiXiangqingEntity saishixinxiXiangqingEntity) {
		try {
			BeanUtils.copyProperties(this, saishixinxiXiangqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getSaishixinxiXiangqingValue() {
		return saishixinxiXiangqingValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setSaishixinxiXiangqingValue(String saishixinxiXiangqingValue) {
		this.saishixinxiXiangqingValue = saishixinxiXiangqingValue;
	}


	//级联表的get和set 球员

		/**
		* 获取： 球员名称
		*/
		public String getQiuyuanName() {
			return qiuyuanName;
		}
		/**
		* 设置： 球员名称
		*/
		public void setQiuyuanName(String qiuyuanName) {
			this.qiuyuanName = qiuyuanName;
		}

		/**
		* 获取： 身高(米)
		*/
		public Double getShangpinShengao() {
			return shangpinShengao;
		}
		/**
		* 设置： 身高(米)
		*/
		public void setShangpinShengao(Double shangpinShengao) {
			this.shangpinShengao = shangpinShengao;
		}

		/**
		* 获取： 体重(kg)
		*/
		public Double getShangpinTizhong() {
			return shangpinTizhong;
		}
		/**
		* 设置： 体重(kg)
		*/
		public void setShangpinTizhong(Double shangpinTizhong) {
			this.shangpinTizhong = shangpinTizhong;
		}
		/**
		* 获取： 国籍
		*/
		public Integer getGuojiTypes() {
			return guojiTypes;
		}
		/**
		* 设置： 国籍
		*/
		public void setGuojiTypes(Integer guojiTypes) {
			this.guojiTypes = guojiTypes;
		}


			/**
			* 获取： 国籍的值
			*/
			public String getGuojiValue() {
				return guojiValue;
			}
			/**
			* 设置： 国籍的值
			*/
			public void setGuojiValue(String guojiValue) {
				this.guojiValue = guojiValue;
			}

		/**
		* 获取： 球员编号
		*/
		public String getQiuyuanUuidNumber() {
			return qiuyuanUuidNumber;
		}
		/**
		* 设置： 球员编号
		*/
		public void setQiuyuanUuidNumber(String qiuyuanUuidNumber) {
			this.qiuyuanUuidNumber = qiuyuanUuidNumber;
		}

		/**
		* 获取： 生日
		*/
		public String getQiuyuanShengri() {
			return qiuyuanShengri;
		}
		/**
		* 设置： 生日
		*/
		public void setQiuyuanShengri(String qiuyuanShengri) {
			this.qiuyuanShengri = qiuyuanShengri;
		}

		/**
		* 获取： 球员照片
		*/
		public String getQiuyuanPhoto() {
			return qiuyuanPhoto;
		}
		/**
		* 设置： 球员照片
		*/
		public void setQiuyuanPhoto(String qiuyuanPhoto) {
			this.qiuyuanPhoto = qiuyuanPhoto;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 球员位置
		*/
		public Integer getQiuyuanTypes() {
			return qiuyuanTypes;
		}
		/**
		* 设置： 球员位置
		*/
		public void setQiuyuanTypes(Integer qiuyuanTypes) {
			this.qiuyuanTypes = qiuyuanTypes;
		}


			/**
			* 获取： 球员位置的值
			*/
			public String getQiuyuanValue() {
				return qiuyuanValue;
			}
			/**
			* 设置： 球员位置的值
			*/
			public void setQiuyuanValue(String qiuyuanValue) {
				this.qiuyuanValue = qiuyuanValue;
			}

		/**
		* 获取： 入队时间
		*/
		public Date getRuduiTime() {
			return ruduiTime;
		}
		/**
		* 设置： 入队时间
		*/
		public void setRuduiTime(Date ruduiTime) {
			this.ruduiTime = ruduiTime;
		}

		/**
		* 获取： 球员介绍
		*/
		public String getQiuyuanContent() {
			return qiuyuanContent;
		}
		/**
		* 设置： 球员介绍
		*/
		public void setQiuyuanContent(String qiuyuanContent) {
			this.qiuyuanContent = qiuyuanContent;
		}
	//级联表的get和set 赛事信息

		/**
		* 获取： 赛事信息编号
		*/
		public String getSaishixinxiUuidNumber() {
			return saishixinxiUuidNumber;
		}
		/**
		* 设置： 赛事信息编号
		*/
		public void setSaishixinxiUuidNumber(String saishixinxiUuidNumber) {
			this.saishixinxiUuidNumber = saishixinxiUuidNumber;
		}

		/**
		* 获取： 比赛时间
		*/
		public Date getBisiaTime() {
			return bisiaTime;
		}
		/**
		* 设置： 比赛时间
		*/
		public void setBisiaTime(Date bisiaTime) {
			this.bisiaTime = bisiaTime;
		}

		/**
		* 获取： 赛事照片
		*/
		public String getSaishixinxiPhoto() {
			return saishixinxiPhoto;
		}
		/**
		* 设置： 赛事照片
		*/
		public void setSaishixinxiPhoto(String saishixinxiPhoto) {
			this.saishixinxiPhoto = saishixinxiPhoto;
		}

		/**
		* 获取： 主队
		*/
		public String getSaishixinxiZhudui() {
			return saishixinxiZhudui;
		}
		/**
		* 设置： 主队
		*/
		public void setSaishixinxiZhudui(String saishixinxiZhudui) {
			this.saishixinxiZhudui = saishixinxiZhudui;
		}

		/**
		* 获取： 客队
		*/
		public String getSaishixinxiKedui() {
			return saishixinxiKedui;
		}
		/**
		* 设置： 客队
		*/
		public void setSaishixinxiKedui(String saishixinxiKedui) {
			this.saishixinxiKedui = saishixinxiKedui;
		}

		/**
		* 获取： 比赛场地
		*/
		public String getSaishixinxiChangdi() {
			return saishixinxiChangdi;
		}
		/**
		* 设置： 比赛场地
		*/
		public void setSaishixinxiChangdi(String saishixinxiChangdi) {
			this.saishixinxiChangdi = saishixinxiChangdi;
		}

		/**
		* 获取： 比赛备注
		*/
		public String getSaishixinxiContent() {
			return saishixinxiContent;
		}
		/**
		* 设置： 比赛备注
		*/
		public void setSaishixinxiContent(String saishixinxiContent) {
			this.saishixinxiContent = saishixinxiContent;
		}
		/**
		* 获取： 阶段
		*/
		public Integer getSaishixinxiTypes() {
			return saishixinxiTypes;
		}
		/**
		* 设置： 阶段
		*/
		public void setSaishixinxiTypes(Integer saishixinxiTypes) {
			this.saishixinxiTypes = saishixinxiTypes;
		}


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
		/**
		* 获取： 胜利队伍
		*/
		public Integer getShengliTypes() {
			return shengliTypes;
		}
		/**
		* 设置： 胜利队伍
		*/
		public void setShengliTypes(Integer shengliTypes) {
			this.shengliTypes = shengliTypes;
		}


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
		return "SaishixinxiXiangqingView{" +
			", saishixinxiXiangqingValue=" + saishixinxiXiangqingValue +
			", saishixinxiUuidNumber=" + saishixinxiUuidNumber +
			", bisiaTime=" + DateUtil.convertString(bisiaTime,"yyyy-MM-dd") +
			", saishixinxiPhoto=" + saishixinxiPhoto +
			", saishixinxiZhudui=" + saishixinxiZhudui +
			", saishixinxiKedui=" + saishixinxiKedui +
			", saishixinxiChangdi=" + saishixinxiChangdi +
			", saishixinxiContent=" + saishixinxiContent +
			", qiuyuanName=" + qiuyuanName +
			", shangpinShengao=" + shangpinShengao +
			", shangpinTizhong=" + shangpinTizhong +
			", qiuyuanUuidNumber=" + qiuyuanUuidNumber +
			", qiuyuanShengri=" + qiuyuanShengri +
			", qiuyuanPhoto=" + qiuyuanPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", ruduiTime=" + DateUtil.convertString(ruduiTime,"yyyy-MM-dd") +
			", qiuyuanContent=" + qiuyuanContent +
			"} " + super.toString();
	}
}
