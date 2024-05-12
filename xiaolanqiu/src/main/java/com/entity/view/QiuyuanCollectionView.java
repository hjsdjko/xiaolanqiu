package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.QiuyuanCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 球员收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("qiuyuan_collection")
public class QiuyuanCollectionView extends QiuyuanCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String qiuyuanCollectionValue;

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



	public QiuyuanCollectionView() {

	}

	public QiuyuanCollectionView(QiuyuanCollectionEntity qiuyuanCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, qiuyuanCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getQiuyuanCollectionValue() {
		return qiuyuanCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setQiuyuanCollectionValue(String qiuyuanCollectionValue) {
		this.qiuyuanCollectionValue = qiuyuanCollectionValue;
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
		return "QiuyuanCollectionView{" +
			", qiuyuanCollectionValue=" + qiuyuanCollectionValue +
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
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
