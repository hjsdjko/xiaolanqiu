
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
 * 赛事信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/saishixinxi")
public class SaishixinxiController {
    private static final Logger logger = LoggerFactory.getLogger(SaishixinxiController.class);

    private static final String TABLE_NAME = "saishixinxi";

    @Autowired
    private SaishixinxiService saishixinxiService;


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
    private SaishixinxiCollectionService saishixinxiCollectionService;//赛事信息收藏
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
        PageUtils page = saishixinxiService.queryPage(params);

        //字典表数据转换
        List<SaishixinxiView> list =(List<SaishixinxiView>)page.getList();
        for(SaishixinxiView c:list){
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
        SaishixinxiEntity saishixinxi = saishixinxiService.selectById(id);
        if(saishixinxi !=null){
            //entity转view
            SaishixinxiView view = new SaishixinxiView();
            BeanUtils.copyProperties( saishixinxi , view );//把实体数据重构到view中
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
    public R save(@RequestBody SaishixinxiEntity saishixinxi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,saishixinxi:{}",this.getClass().getName(),saishixinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SaishixinxiEntity> queryWrapper = new EntityWrapper<SaishixinxiEntity>()
            .eq("saishixinxi_zhudui", saishixinxi.getSaishixinxiZhudui())
            .eq("saishixinxi_kedui", saishixinxi.getSaishixinxiKedui())
            .eq("saishixinxi_changdi", saishixinxi.getSaishixinxiChangdi())
            .eq("saishixinxi_types", saishixinxi.getSaishixinxiTypes())
            .eq("shengli_types", saishixinxi.getShengliTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishixinxiEntity saishixinxiEntity = saishixinxiService.selectOne(queryWrapper);
        if(saishixinxiEntity==null){
            saishixinxi.setInsertTime(new Date());
            saishixinxi.setCreateTime(new Date());
            saishixinxiService.insert(saishixinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SaishixinxiEntity saishixinxi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,saishixinxi:{}",this.getClass().getName(),saishixinxi.toString());
        SaishixinxiEntity oldSaishixinxiEntity = saishixinxiService.selectById(saishixinxi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(saishixinxi.getSaishixinxiPhoto()) || "null".equals(saishixinxi.getSaishixinxiPhoto())){
                saishixinxi.setSaishixinxiPhoto(null);
        }
        if("".equals(saishixinxi.getSaishixinxiContent()) || "null".equals(saishixinxi.getSaishixinxiContent())){
                saishixinxi.setSaishixinxiContent(null);
        }

            saishixinxiService.updateById(saishixinxi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SaishixinxiEntity> oldSaishixinxiList =saishixinxiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        saishixinxiService.deleteBatchIds(Arrays.asList(ids));

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
            List<SaishixinxiEntity> saishixinxiList = new ArrayList<>();//上传的东西
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
                            SaishixinxiEntity saishixinxiEntity = new SaishixinxiEntity();
//                            saishixinxiEntity.setSaishixinxiUuidNumber(data.get(0));                    //赛事信息编号 要改的
//                            saishixinxiEntity.setBisiaTime(sdf.parse(data.get(0)));          //比赛时间 要改的
//                            saishixinxiEntity.setSaishixinxiPhoto("");//详情和图片
//                            saishixinxiEntity.setSaishixinxiZhudui(data.get(0));                    //主队 要改的
//                            saishixinxiEntity.setSaishixinxiKedui(data.get(0));                    //客队 要改的
//                            saishixinxiEntity.setSaishixinxiChangdi(data.get(0));                    //比赛场地 要改的
//                            saishixinxiEntity.setSaishixinxiContent("");//详情和图片
//                            saishixinxiEntity.setSaishixinxiTypes(Integer.valueOf(data.get(0)));   //阶段 要改的
//                            saishixinxiEntity.setShengliTypes(Integer.valueOf(data.get(0)));   //胜利队伍 要改的
//                            saishixinxiEntity.setInsertTime(date);//时间
//                            saishixinxiEntity.setCreateTime(date);//时间
                            saishixinxiList.add(saishixinxiEntity);


                            //把要查询是否重复的字段放入map中
                                //赛事信息编号
                                if(seachFields.containsKey("saishixinxiUuidNumber")){
                                    List<String> saishixinxiUuidNumber = seachFields.get("saishixinxiUuidNumber");
                                    saishixinxiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> saishixinxiUuidNumber = new ArrayList<>();
                                    saishixinxiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("saishixinxiUuidNumber",saishixinxiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //赛事信息编号
                        List<SaishixinxiEntity> saishixinxiEntities_saishixinxiUuidNumber = saishixinxiService.selectList(new EntityWrapper<SaishixinxiEntity>().in("saishixinxi_uuid_number", seachFields.get("saishixinxiUuidNumber")));
                        if(saishixinxiEntities_saishixinxiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SaishixinxiEntity s:saishixinxiEntities_saishixinxiUuidNumber){
                                repeatFields.add(s.getSaishixinxiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [赛事信息编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        saishixinxiService.insertBatch(saishixinxiList);
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
        List<SaishixinxiView> returnSaishixinxiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("saishixinxiYesnoTypes",2);
        PageUtils pageUtils = saishixinxiCollectionService.queryPage(params1);
        List<SaishixinxiCollectionView> collectionViewsList =(List<SaishixinxiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(SaishixinxiCollectionView collectionView:collectionViewsList){
            Integer saishixinxiTypes = collectionView.getSaishixinxiTypes();
            if(typeMap.containsKey(saishixinxiTypes)){
                typeMap.put(saishixinxiTypes,typeMap.get(saishixinxiTypes)+1);
            }else{
                typeMap.put(saishixinxiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("saishixinxiTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("saishixinxiYesnoTypes",2);
            PageUtils pageUtils1 = saishixinxiService.queryPage(params2);
            List<SaishixinxiView> saishixinxiViewList =(List<SaishixinxiView>)pageUtils1.getList();
            returnSaishixinxiViewList.addAll(saishixinxiViewList);
            if(returnSaishixinxiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("saishixinxiYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = saishixinxiService.queryPage(params);
        if(returnSaishixinxiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnSaishixinxiViewList.size();//要添加的数量
            List<SaishixinxiView> saishixinxiViewList =(List<SaishixinxiView>)page.getList();
            for(SaishixinxiView saishixinxiView:saishixinxiViewList){
                Boolean addFlag = true;
                for(SaishixinxiView returnSaishixinxiView:returnSaishixinxiViewList){
                    if(returnSaishixinxiView.getId().intValue() ==saishixinxiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnSaishixinxiViewList.add(saishixinxiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnSaishixinxiViewList = returnSaishixinxiViewList.subList(0, limit);
        }

        for(SaishixinxiView c:returnSaishixinxiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnSaishixinxiViewList);
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
        PageUtils page = saishixinxiService.queryPage(params);

        //字典表数据转换
        List<SaishixinxiView> list =(List<SaishixinxiView>)page.getList();
        for(SaishixinxiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SaishixinxiEntity saishixinxi = saishixinxiService.selectById(id);
            if(saishixinxi !=null){


                //entity转view
                SaishixinxiView view = new SaishixinxiView();
                BeanUtils.copyProperties( saishixinxi , view );//把实体数据重构到view中

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
    public R add(@RequestBody SaishixinxiEntity saishixinxi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,saishixinxi:{}",this.getClass().getName(),saishixinxi.toString());
        Wrapper<SaishixinxiEntity> queryWrapper = new EntityWrapper<SaishixinxiEntity>()
            .eq("saishixinxi_uuid_number", saishixinxi.getSaishixinxiUuidNumber())
            .eq("saishixinxi_zhudui", saishixinxi.getSaishixinxiZhudui())
            .eq("saishixinxi_kedui", saishixinxi.getSaishixinxiKedui())
            .eq("saishixinxi_changdi", saishixinxi.getSaishixinxiChangdi())
            .eq("saishixinxi_types", saishixinxi.getSaishixinxiTypes())
            .eq("shengli_types", saishixinxi.getShengliTypes())
//            .notIn("saishixinxi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishixinxiEntity saishixinxiEntity = saishixinxiService.selectOne(queryWrapper);
        if(saishixinxiEntity==null){
            saishixinxi.setInsertTime(new Date());
            saishixinxi.setCreateTime(new Date());
        saishixinxiService.insert(saishixinxi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

