package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SaishixinxiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 赛事信息收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("saishixinxi_collection")
public class SaishixinxiCollectionView extends SaishixinxiCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String saishixinxiCollectionValue;

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
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public SaishixinxiCollectionView() {

	}

	public SaishixinxiCollectionView(SaishixinxiCollectionEntity saishixinxiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, saishixinxiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getSaishixinxiCollectionValue() {
		return saishixinxiCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setSaishixinxiCollectionValue(String saishixinxiCollectionValue) {
		this.saishixinxiCollectionValue = saishixinxiCollectionValue;
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
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "SaishixinxiCollectionView{" +
			", saishixinxiCollectionValue=" + saishixinxiCollectionValue +
			", saishixinxiUuidNumber=" + saishixinxiUuidNumber +
			", bisiaTime=" + DateUtil.convertString(bisiaTime,"yyyy-MM-dd") +
			", saishixinxiPhoto=" + saishixinxiPhoto +
			", saishixinxiZhudui=" + saishixinxiZhudui +
			", saishixinxiKedui=" + saishixinxiKedui +
			", saishixinxiChangdi=" + saishixinxiChangdi +
			", saishixinxiContent=" + saishixinxiContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
