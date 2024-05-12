
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
 * 球员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qiuyuan")
public class QiuyuanController {
    private static final Logger logger = LoggerFactory.getLogger(QiuyuanController.class);

    private static final String TABLE_NAME = "qiuyuan";

    @Autowired
    private QiuyuanService qiuyuanService;


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
    private QiuyuanCollectionService qiuyuanCollectionService;//球员收藏
    @Autowired
    private QiuyuanLiuyanService qiuyuanLiuyanService;//球员留言
    @Autowired
    private SaishixinxiService saishixinxiService;//赛事信息
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
        PageUtils page = qiuyuanService.queryPage(params);

        //字典表数据转换
        List<QiuyuanView> list =(List<QiuyuanView>)page.getList();
        for(QiuyuanView c:list){
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
        QiuyuanEntity qiuyuan = qiuyuanService.selectById(id);
        if(qiuyuan !=null){
            //entity转view
            QiuyuanView view = new QiuyuanView();
            BeanUtils.copyProperties( qiuyuan , view );//把实体数据重构到view中
            //级联表 球队
            //级联表
            QiuduiEntity qiudui = qiuduiService.selectById(qiuyuan.getQiuduiId());
            if(qiudui != null){
            BeanUtils.copyProperties( qiudui , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setQiuduiId(qiudui.getId());
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
    public R save(@RequestBody QiuyuanEntity qiuyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qiuyuan:{}",this.getClass().getName(),qiuyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<QiuyuanEntity> queryWrapper = new EntityWrapper<QiuyuanEntity>()
            .eq("qiudui_id", qiuyuan.getQiuduiId())
            .eq("qiuyuan_name", qiuyuan.getQiuyuanName())
            .eq("guoji_types", qiuyuan.getGuojiTypes())
            .eq("qiuyuan_shengri", qiuyuan.getQiuyuanShengri())
            .eq("zan_number", qiuyuan.getZanNumber())
            .eq("cai_number", qiuyuan.getCaiNumber())
            .eq("qiuyuan_types", qiuyuan.getQiuyuanTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiuyuanEntity qiuyuanEntity = qiuyuanService.selectOne(queryWrapper);
        if(qiuyuanEntity==null){
            qiuyuan.setZanNumber(1);
            qiuyuan.setCaiNumber(1);
            qiuyuan.setInsertTime(new Date());
            qiuyuan.setCreateTime(new Date());
            qiuyuanService.insert(qiuyuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QiuyuanEntity qiuyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,qiuyuan:{}",this.getClass().getName(),qiuyuan.toString());
        QiuyuanEntity oldQiuyuanEntity = qiuyuanService.selectById(qiuyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(qiuyuan.getQiuyuanPhoto()) || "null".equals(qiuyuan.getQiuyuanPhoto())){
                qiuyuan.setQiuyuanPhoto(null);
        }
        if("".equals(qiuyuan.getQiuyuanContent()) || "null".equals(qiuyuan.getQiuyuanContent())){
                qiuyuan.setQiuyuanContent(null);
        }

            qiuyuanService.updateById(qiuyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<QiuyuanEntity> oldQiuyuanList =qiuyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        qiuyuanService.deleteBatchIds(Arrays.asList(ids));

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
            List<QiuyuanEntity> qiuyuanList = new ArrayList<>();//上传的东西
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
                            QiuyuanEntity qiuyuanEntity = new QiuyuanEntity();
//                            qiuyuanEntity.setQiuduiId(Integer.valueOf(data.get(0)));   //球队 要改的
//                            qiuyuanEntity.setQiuyuanName(data.get(0));                    //球员名称 要改的
//                            qiuyuanEntity.setShangpinShengao(data.get(0));                    //身高(米) 要改的
//                            qiuyuanEntity.setShangpinTizhong(data.get(0));                    //体重(kg) 要改的
//                            qiuyuanEntity.setGuojiTypes(Integer.valueOf(data.get(0)));   //国籍 要改的
//                            qiuyuanEntity.setQiuyuanUuidNumber(data.get(0));                    //球员编号 要改的
//                            qiuyuanEntity.setQiuyuanShengri(data.get(0));                    //生日 要改的
//                            qiuyuanEntity.setQiuyuanPhoto("");//详情和图片
//                            qiuyuanEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            qiuyuanEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            qiuyuanEntity.setQiuyuanTypes(Integer.valueOf(data.get(0)));   //球员位置 要改的
//                            qiuyuanEntity.setRuduiTime(sdf.parse(data.get(0)));          //入队时间 要改的
//                            qiuyuanEntity.setQiuyuanContent("");//详情和图片
//                            qiuyuanEntity.setInsertTime(date);//时间
//                            qiuyuanEntity.setCreateTime(date);//时间
                            qiuyuanList.add(qiuyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //球员编号
                                if(seachFields.containsKey("qiuyuanUuidNumber")){
                                    List<String> qiuyuanUuidNumber = seachFields.get("qiuyuanUuidNumber");
                                    qiuyuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qiuyuanUuidNumber = new ArrayList<>();
                                    qiuyuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("qiuyuanUuidNumber",qiuyuanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //球员编号
                        List<QiuyuanEntity> qiuyuanEntities_qiuyuanUuidNumber = qiuyuanService.selectList(new EntityWrapper<QiuyuanEntity>().in("qiuyuan_uuid_number", seachFields.get("qiuyuanUuidNumber")));
                        if(qiuyuanEntities_qiuyuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QiuyuanEntity s:qiuyuanEntities_qiuyuanUuidNumber){
                                repeatFields.add(s.getQiuyuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [球员编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        qiuyuanService.insertBatch(qiuyuanList);
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
        List<QiuyuanView> returnQiuyuanViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("qiuyuanYesnoTypes",2);
        PageUtils pageUtils = qiuyuanCollectionService.queryPage(params1);
        List<QiuyuanCollectionView> collectionViewsList =(List<QiuyuanCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(QiuyuanCollectionView collectionView:collectionViewsList){
            Integer qiuyuanTypes = collectionView.getQiuyuanTypes();
            if(typeMap.containsKey(qiuyuanTypes)){
                typeMap.put(qiuyuanTypes,typeMap.get(qiuyuanTypes)+1);
            }else{
                typeMap.put(qiuyuanTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("qiuyuanTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("qiuyuanYesnoTypes",2);
            PageUtils pageUtils1 = qiuyuanService.queryPage(params2);
            List<QiuyuanView> qiuyuanViewList =(List<QiuyuanView>)pageUtils1.getList();
            returnQiuyuanViewList.addAll(qiuyuanViewList);
            if(returnQiuyuanViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("qiuyuanYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = qiuyuanService.queryPage(params);
        if(returnQiuyuanViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnQiuyuanViewList.size();//要添加的数量
            List<QiuyuanView> qiuyuanViewList =(List<QiuyuanView>)page.getList();
            for(QiuyuanView qiuyuanView:qiuyuanViewList){
                Boolean addFlag = true;
                for(QiuyuanView returnQiuyuanView:returnQiuyuanViewList){
                    if(returnQiuyuanView.getId().intValue() ==qiuyuanView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnQiuyuanViewList.add(qiuyuanView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnQiuyuanViewList = returnQiuyuanViewList.subList(0, limit);
        }

        for(QiuyuanView c:returnQiuyuanViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnQiuyuanViewList);
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
        PageUtils page = qiuyuanService.queryPage(params);

        //字典表数据转换
        List<QiuyuanView> list =(List<QiuyuanView>)page.getList();
        for(QiuyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QiuyuanEntity qiuyuan = qiuyuanService.selectById(id);
            if(qiuyuan !=null){


                //entity转view
                QiuyuanView view = new QiuyuanView();
                BeanUtils.copyProperties( qiuyuan , view );//把实体数据重构到view中

                //级联表
                    QiuduiEntity qiudui = qiuduiService.selectById(qiuyuan.getQiuduiId());
                if(qiudui != null){
                    BeanUtils.copyProperties( qiudui , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setQiuduiId(qiudui.getId());
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
    public R add(@RequestBody QiuyuanEntity qiuyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,qiuyuan:{}",this.getClass().getName(),qiuyuan.toString());
        Wrapper<QiuyuanEntity> queryWrapper = new EntityWrapper<QiuyuanEntity>()
            .eq("qiudui_id", qiuyuan.getQiuduiId())
            .eq("qiuyuan_name", qiuyuan.getQiuyuanName())
            .eq("guoji_types", qiuyuan.getGuojiTypes())
            .eq("qiuyuan_uuid_number", qiuyuan.getQiuyuanUuidNumber())
            .eq("qiuyuan_shengri", qiuyuan.getQiuyuanShengri())
            .eq("zan_number", qiuyuan.getZanNumber())
            .eq("cai_number", qiuyuan.getCaiNumber())
            .eq("qiuyuan_types", qiuyuan.getQiuyuanTypes())
//            .notIn("qiuyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QiuyuanEntity qiuyuanEntity = qiuyuanService.selectOne(queryWrapper);
        if(qiuyuanEntity==null){
                qiuyuan.setZanNumber(1);
                qiuyuan.setCaiNumber(1);
            qiuyuan.setInsertTime(new Date());
            qiuyuan.setCreateTime(new Date());
        qiuyuanService.insert(qiuyuan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

