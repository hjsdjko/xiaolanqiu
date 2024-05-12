
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 赛事详情
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/saishixinxiXiangqing")
public class SaishixinxiXiangqingController {
    private static final Logger logger = LoggerFactory.getLogger(SaishixinxiXiangqingController.class);

    private static final String TABLE_NAME = "saishixinxiXiangqing";

    @Autowired
    private SaishixinxiXiangqingService saishixinxiXiangqingService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private QiuduiService qiuduiService;//球队
    @Autowired
    private QiuduiCollectionService qiuduiCollectionService;//球队收藏
    @Autowired
    private QiuduiLiuyanService qiuduiLiuyanService;//球队留言
    @Autowired
    private QiuyuanService qiuyuanService;//球员
    @Autowired
    private QiuyuanCollectionService qiuyuanCollectionService;//球员收藏
    @Autowired
    private QiuyuanLiuyanService qiuyuanLiuyanService;//球员留言
    @Autowired
    private SaishixinxiService saishixinxiService;//赛事信息
    @Autowired
    private SaishixinxiCollectionService saishixinxiCollectionService;//赛事信息收藏
    @Autowired
    private SaishixinxiXiangqingCollectionService saishixinxiXiangqingCollectionService;//赛事详情收藏
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = saishixinxiXiangqingService.queryPage(params);

        //字典表数据转换
        List<SaishixinxiXiangqingView> list =(List<SaishixinxiXiangqingView>)page.getList();
        for(SaishixinxiXiangqingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SaishixinxiXiangqingEntity saishixinxiXiangqing = saishixinxiXiangqingService.selectById(id);
        if(saishixinxiXiangqing !=null){
            //entity转view
            SaishixinxiXiangqingView view = new SaishixinxiXiangqingView();
            BeanUtils.copyProperties( saishixinxiXiangqing , view );//把实体数据重构到view中
            //级联表 赛事信息
            //级联表
            SaishixinxiEntity saishixinxi = saishixinxiService.selectById(saishixinxiXiangqing.getSaishixinxiId());
            if(saishixinxi != null){
            BeanUtils.copyProperties( saishixinxi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setSaishixinxiId(saishixinxi.getId());
            }
            //级联表 球员
            //级联表
            QiuyuanEntity qiuyuan = qiuyuanService.selectById(saishixinxiXiangqing.getQiuyuanId());
            if(qiuyuan != null){
            BeanUtils.copyProperties( qiuyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setQiuyuanId(qiuyuan.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody SaishixinxiXiangqingEntity saishixinxiXiangqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,saishixinxiXiangqing:{}",this.getClass().getName(),saishixinxiXiangqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SaishixinxiXiangqingEntity> queryWrapper = new EntityWrapper<SaishixinxiXiangqingEntity>()
            .eq("saishixinxi_id", saishixinxiXiangqing.getSaishixinxiId())
            .eq("qiuyuan_id", saishixinxiXiangqing.getQiuyuanId())
            .eq("saishixinxi_xiangqing_name", saishixinxiXiangqing.getSaishixinxiXiangqingName())
            .eq("saishixinxi_xiangqing_types", saishixinxiXiangqing.getSaishixinxiXiangqingTypes())
            .eq("saishixinxi_xiangqing_defen", saishixinxiXiangqing.getSaishixinxiXiangqingDefen())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishixinxiXiangqingEntity saishixinxiXiangqingEntity = saishixinxiXiangqingService.selectOne(queryWrapper);
        if(saishixinxiXiangqingEntity==null){
            saishixinxiXiangqing.setInsertTime(new Date());
            saishixinxiXiangqing.setCreateTime(new Date());
            saishixinxiXiangqingService.insert(saishixinxiXiangqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SaishixinxiXiangqingEntity saishixinxiXiangqing, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,saishixinxiXiangqing:{}",this.getClass().getName(),saishixinxiXiangqing.toString());
        SaishixinxiXiangqingEntity oldSaishixinxiXiangqingEntity = saishixinxiXiangqingService.selectById(saishixinxiXiangqing.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(saishixinxiXiangqing.getSaishixinxiXiangqingFile()) || "null".equals(saishixinxiXiangqing.getSaishixinxiXiangqingFile())){
                saishixinxiXiangqing.setSaishixinxiXiangqingFile(null);
        }
        if("".equals(saishixinxiXiangqing.getSaishixinxiXiangqingContent()) || "null".equals(saishixinxiXiangqing.getSaishixinxiXiangqingContent())){
                saishixinxiXiangqing.setSaishixinxiXiangqingContent(null);
        }

            saishixinxiXiangqingService.updateById(saishixinxiXiangqing);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SaishixinxiXiangqingEntity> oldSaishixinxiXiangqingList =saishixinxiXiangqingService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        saishixinxiXiangqingService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<SaishixinxiXiangqingEntity> saishixinxiXiangqingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            SaishixinxiXiangqingEntity saishixinxiXiangqingEntity = new SaishixinxiXiangqingEntity();
//                            saishixinxiXiangqingEntity.setSaishixinxiId(Integer.valueOf(data.get(0)));   //赛事信息 要改的
//                            saishixinxiXiangqingEntity.setQiuyuanId(Integer.valueOf(data.get(0)));   //球员 要改的
//                            saishixinxiXiangqingEntity.setSaishixinxiXiangqingUuidNumber(data.get(0));                    //赛事详情编号 要改的
//                            saishixinxiXiangqingEntity.setSaishixinxiXiangqingName(data.get(0));                    //标题 要改的
//                            saishixinxiXiangqingEntity.setSaishixinxiXiangqingTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            saishixinxiXiangqingEntity.setSaishixinxiXiangqingFile(data.get(0));                    //附件 要改的
//                            saishixinxiXiangqingEntity.setSaishixinxiXiangqingDefen(Integer.valueOf(data.get(0)));   //分值 要改的
//                            saishixinxiXiangqingEntity.setSaishixinxiXiangqingTime(sdf.parse(data.get(0)));          //发生时间 要改的
//                            saishixinxiXiangqingEntity.setSaishixinxiXiangqingContent("");//详情和图片
//                            saishixinxiXiangqingEntity.setInsertTime(date);//时间
//                            saishixinxiXiangqingEntity.setCreateTime(date);//时间
                            saishixinxiXiangqingList.add(saishixinxiXiangqingEntity);


                            //把要查询是否重复的字段放入map中
                                //赛事详情编号
                                if(seachFields.containsKey("saishixinxiXiangqingUuidNumber")){
                                    List<String> saishixinxiXiangqingUuidNumber = seachFields.get("saishixinxiXiangqingUuidNumber");
                                    saishixinxiXiangqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> saishixinxiXiangqingUuidNumber = new ArrayList<>();
                                    saishixinxiXiangqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("saishixinxiXiangqingUuidNumber",saishixinxiXiangqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //赛事详情编号
                        List<SaishixinxiXiangqingEntity> saishixinxiXiangqingEntities_saishixinxiXiangqingUuidNumber = saishixinxiXiangqingService.selectList(new EntityWrapper<SaishixinxiXiangqingEntity>().in("saishixinxi_xiangqing_uuid_number", seachFields.get("saishixinxiXiangqingUuidNumber")));
                        if(saishixinxiXiangqingEntities_saishixinxiXiangqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SaishixinxiXiangqingEntity s:saishixinxiXiangqingEntities_saishixinxiXiangqingUuidNumber){
                                repeatFields.add(s.getSaishixinxiXiangqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [赛事详情编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        saishixinxiXiangqingService.insertBatch(saishixinxiXiangqingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<SaishixinxiXiangqingView> returnSaishixinxiXiangqingViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("saishixinxiXiangqingYesnoTypes",2);
        PageUtils pageUtils = saishixinxiXiangqingCollectionService.queryPage(params1);
        List<SaishixinxiXiangqingCollectionView> collectionViewsList =(List<SaishixinxiXiangqingCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(SaishixinxiXiangqingCollectionView collectionView:collectionViewsList){
            Integer saishixinxiXiangqingTypes = collectionView.getSaishixinxiXiangqingTypes();
            if(typeMap.containsKey(saishixinxiXiangqingTypes)){
                typeMap.put(saishixinxiXiangqingTypes,typeMap.get(saishixinxiXiangqingTypes)+1);
            }else{
                typeMap.put(saishixinxiXiangqingTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("saishixinxiXiangqingTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("saishixinxiXiangqingYesnoTypes",2);
            PageUtils pageUtils1 = saishixinxiXiangqingService.queryPage(params2);
            List<SaishixinxiXiangqingView> saishixinxiXiangqingViewList =(List<SaishixinxiXiangqingView>)pageUtils1.getList();
            returnSaishixinxiXiangqingViewList.addAll(saishixinxiXiangqingViewList);
            if(returnSaishixinxiXiangqingViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("saishixinxiXiangqingYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = saishixinxiXiangqingService.queryPage(params);
        if(returnSaishixinxiXiangqingViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnSaishixinxiXiangqingViewList.size();//要添加的数量
            List<SaishixinxiXiangqingView> saishixinxiXiangqingViewList =(List<SaishixinxiXiangqingView>)page.getList();
            for(SaishixinxiXiangqingView saishixinxiXiangqingView:saishixinxiXiangqingViewList){
                Boolean addFlag = true;
                for(SaishixinxiXiangqingView returnSaishixinxiXiangqingView:returnSaishixinxiXiangqingViewList){
                    if(returnSaishixinxiXiangqingView.getId().intValue() ==saishixinxiXiangqingView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnSaishixinxiXiangqingViewList.add(saishixinxiXiangqingView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnSaishixinxiXiangqingViewList = returnSaishixinxiXiangqingViewList.subList(0, limit);
        }

        for(SaishixinxiXiangqingView c:returnSaishixinxiXiangqingViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnSaishixinxiXiangqingViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = saishixinxiXiangqingService.queryPage(params);

        //字典表数据转换
        List<SaishixinxiXiangqingView> list =(List<SaishixinxiXiangqingView>)page.getList();
        for(SaishixinxiXiangqingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SaishixinxiXiangqingEntity saishixinxiXiangqing = saishixinxiXiangqingService.selectById(id);
            if(saishixinxiXiangqing !=null){


                //entity转view
                SaishixinxiXiangqingView view = new SaishixinxiXiangqingView();
                BeanUtils.copyProperties( saishixinxiXiangqing , view );//把实体数据重构到view中

                //级联表
                    SaishixinxiEntity saishixinxi = saishixinxiService.selectById(saishixinxiXiangqing.getSaishixinxiId());
                if(saishixinxi != null){
                    BeanUtils.copyProperties( saishixinxi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSaishixinxiId(saishixinxi.getId());
                }
                //级联表
                    QiuyuanEntity qiuyuan = qiuyuanService.selectById(saishixinxiXiangqing.getQiuyuanId());
                if(qiuyuan != null){
                    BeanUtils.copyProperties( qiuyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setQiuyuanId(qiuyuan.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody SaishixinxiXiangqingEntity saishixinxiXiangqing, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,saishixinxiXiangqing:{}",this.getClass().getName(),saishixinxiXiangqing.toString());
        Wrapper<SaishixinxiXiangqingEntity> queryWrapper = new EntityWrapper<SaishixinxiXiangqingEntity>()
            .eq("saishixinxi_id", saishixinxiXiangqing.getSaishixinxiId())
            .eq("qiuyuan_id", saishixinxiXiangqing.getQiuyuanId())
            .eq("saishixinxi_xiangqing_uuid_number", saishixinxiXiangqing.getSaishixinxiXiangqingUuidNumber())
            .eq("saishixinxi_xiangqing_name", saishixinxiXiangqing.getSaishixinxiXiangqingName())
            .eq("saishixinxi_xiangqing_types", saishixinxiXiangqing.getSaishixinxiXiangqingTypes())
            .eq("saishixinxi_xiangqing_defen", saishixinxiXiangqing.getSaishixinxiXiangqingDefen())
//            .notIn("saishixinxi_xiangqing_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishixinxiXiangqingEntity saishixinxiXiangqingEntity = saishixinxiXiangqingService.selectOne(queryWrapper);
        if(saishixinxiXiangqingEntity==null){
            saishixinxiXiangqing.setInsertTime(new Date());
            saishixinxiXiangqing.setCreateTime(new Date());
        saishixinxiXiangqingService.insert(saishixinxiXiangqing);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

