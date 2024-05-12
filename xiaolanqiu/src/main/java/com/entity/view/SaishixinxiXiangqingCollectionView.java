package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SaishixinxiXiangqingCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 赛事详情收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("saishixinxi_xiangqing_collection")
public class SaishixinxiXiangqingCollectionView extends SaishixinxiXiangqingCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String saishixinxiXiangqingCollectionValue;

	//级联表 赛事详情
												/**
		* 赛事详情编号
		*/

		@ColumnInfo(comment="赛事详情编号",type="varchar(200)")
		private String saishixinxiXiangqingUuidNumber;
		/**
		* 标题
		*/

		@ColumnInfo(comment="标题",type="varchar(200)")
		private String saishixinxiXiangqingName;
		/**
		* 类型
		*/
		@ColumnInfo(comment="类型",type="int(11)")
		private Integer saishixinxiXiangqingTypes;
			/**
			* 类型的值
			*/
			@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
			private String saishixinxiXiangqingValue;
		/**
		* 附件
		*/

		@ColumnInfo(comment="附件",type="varchar(200)")
		private String saishixinxiXiangqingFile;
		/**
		* 分值
		*/

		@ColumnInfo(comment="分值",type="int(11)")
		private Integer saishixinxiXiangqingDefen;
		/**
		* 发生时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="发生时间",type="timestamp")
		private Date saishixinxiXiangqingTime;
		/**
		* 详情
		*/

		@ColumnInfo(comment="详情",type="longtext")
		private String saishixinxiXiangqingContent;
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



	public SaishixinxiXiangqingCollectionView() {

	}

	public SaishixinxiXiangqingCollectionView(SaishixinxiXiangqingCollectionEntity saishixinxiXiangqingCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, saishixinxiXiangqingCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getSaishixinxiXiangqingCollectionValue() {
		return saishixinxiXiangqingCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setSaishixinxiXiangqingCollectionValue(String saishixinxiXiangqingCollectionValue) {
		this.saishixinxiXiangqingCollectionValue = saishixinxiXiangqingCollectionValue;
	}


	//级联表的get和set 赛事详情

		/**
		* 获取： 赛事详情编号
		*/
		public String getSaishixinxiXiangqingUuidNumber() {
			return saishixinxiXiangqingUuidNumber;
		}
		/**
		* 设置： 赛事详情编号
		*/
		public void setSaishixinxiXiangqingUuidNumber(String saishixinxiXiangqingUuidNumber) {
			this.saishixinxiXiangqingUuidNumber = saishixinxiXiangqingUuidNumber;
		}

		/**
		* 获取： 标题
		*/
		public String getSaishixinxiXiangqingName() {
			return saishixinxiXiangqingName;
		}
		/**
		* 设置： 标题
		*/
		public void setSaishixinxiXiangqingName(String saishixinxiXiangqingName) {
			this.saishixinxiXiangqingName = saishixinxiXiangqingName;
		}
		/**
		* 获取： 类型
		*/
		public Integer getSaishixinxiXiangqingTypes() {
			return saishixinxiXiangqingTypes;
		}
		/**
		* 设置： 类型
		*/
		public void setSaishixinxiXiangqingTypes(Integer saishixinxiXiangqingTypes) {
			this.saishixinxiXiangqingTypes = saishixinxiXiangqingTypes;
		}


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

		/**
		* 获取： 附件
		*/
		public String getSaishixinxiXiangqingFile() {
			return saishixinxiXiangqingFile;
		}
		/**
		* 设置： 附件
		*/
		public void setSaishixinxiXiangqingFile(String saishixinxiXiangqingFile) {
			this.saishixinxiXiangqingFile = saishixinxiXiangqingFile;
		}

		/**
		* 获取： 分值
		*/
		public Integer getSaishixinxiXiangqingDefen() {
			return saishixinxiXiangqingDefen;
		}
		/**
		* 设置： 分值
		*/
		public void setSaishixinxiXiangqingDefen(Integer saishixinxiXiangqingDefen) {
			this.saishixinxiXiangqingDefen = saishixinxiXiangqingDefen;
		}

		/**
		* 获取： 发生时间
		*/
		public Date getSaishixinxiXiangqingTime() {
			return saishixinxiXiangqingTime;
		}
		/**
		* 设置： 发生时间
		*/
		public void setSaishixinxiXiangqingTime(Date saishixinxiXiangqingTime) {
			this.saishixinxiXiangqingTime = saishixinxiXiangqingTime;
		}

		/**
		* 获取： 详情
		*/
		public String getSaishixinxiXiangqingContent() {
			return saishixinxiXiangqingContent;
		}
		/**
		* 设置： 详情
		*/
		public void setSaishixinxiXiangqingContent(String saishixinxiXiangqingContent) {
			this.saishixinxiXiangqingContent = saishixinxiXiangqingContent;
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
		return "SaishixinxiXiangqingCollectionView{" +
			", saishixinxiXiangqingCollectionValue=" + saishixinxiXiangqingCollectionValue +
			", saishixinxiXiangqingUuidNumber=" + saishixinxiXiangqingUuidNumber +
			", saishixinxiXiangqingName=" + saishixinxiXiangqingName +
			", saishixinxiXiangqingFile=" + saishixinxiXiangqingFile +
			", saishixinxiXiangqingDefen=" + saishixinxiXiangqingDefen +
			", saishixinxiXiangqingTime=" + DateUtil.convertString(saishixinxiXiangqingTime,"yyyy-MM-dd") +
			", saishixinxiXiangqingContent=" + saishixinxiXiangqingContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
