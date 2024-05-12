package com.dao;

import com.entity.SaishixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SaishixinxiView;

/**
 * 赛事信息 Dao 接口
 *
 * @author 
 */
public interface SaishixinxiDao extends BaseMapper<SaishixinxiEntity> {

   List<SaishixinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
