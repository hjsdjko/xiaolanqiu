package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.SaishixinxiXiangqingDao;
import com.entity.SaishixinxiXiangqingEntity;
import com.service.SaishixinxiXiangqingService;
import com.entity.view.SaishixinxiXiangqingView;

/**
 * 赛事详情 服务实现类
 */
@Service("saishixinxiXiangqingService")
@Transactional
public class SaishixinxiXiangqingServiceImpl extends ServiceImpl<SaishixinxiXiangqingDao, SaishixinxiXiangqingEntity> implements SaishixinxiXiangqingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<SaishixinxiXiangqingView> page =new Query<SaishixinxiXiangqingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
