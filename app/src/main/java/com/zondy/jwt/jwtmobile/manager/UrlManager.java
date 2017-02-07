package com.zondy.jwt.jwtmobile.manager;

import com.zondy.jwt.jwtmobile.global.Constant;

/**
 * Created by sheep on 2017/1/3.
 */

public class UrlManager {
    public static String HOST_IP = "61.183.129.187";// 默认的ip和端口，会在登陆界面的设置ip时改变。
    public static String HOST_PORT = "4040";
    public static String PUSH_HOST_IP = "61.183.129.187";
    public static String PUSH_HOST_PORT = "4041";

    public static String LOGIN = "/UserLogin!login";// 登入
    // public static String LOGOUT = "/CloseServlet.do";// 登出
    public static String LOGOUT = "/UserLogout!logout";// 登出
    public static String changePwd = "/UserLogin!updatePassword";// 修改密码
    public static String UPDATE = "/CheckUpdateInfo!checkUpdateInfo";// 更新信息查询
    public static String mapFile = "/mobileInfo/MapGIS.zip";// 地图文件
    public static String queryJingliList = "/QueryZbjl!queryJinglList";// 查询警力列表
    public static String queryConnectionList = "/ZhongheQuery!queryAllConnection";// 查询联系人通讯录
    public static String queryJingqList = "/QueryJQ!queryJingqList";// 查询警情列表
    public static String queryJingqByJingqid = "/QueryJQ!queryJingqByJingqid";// 重新加载警情详情
    public static String reachConfirm = "/ConfirmArrive!confirmArrive";// 到场确认
    public static String receiveJingqingConfirm = "/ConfirmArrive!confirmReceiveJingqing";// 接收警情确认
    public static String receiveJingqingReBack = "/ConfirmArrive!reBackJingqing";// 回退警情确认
    public static String handleJingqing = "/HandleJQCLXX!handleJqxx";// 处理警情
    public static String handleJingqingWithZJG = "/HandleJQCLXX!handleJqxx_ZJG";// 处理张家港警情
    public static String queryJingqingByCondition = "/QueryJQ!queryJingqListByCondition2";// 根据不同条件查询警情
    public static String queryXiectsxxDetailByID = "xxxxxxxxxxxxx";// 查询协查推送信息详情
    public static String queryXiectsxxList = "/QueryXCTSXX!queryJingqListXCTS";// 查询协查推送信息列表
    public static String xiectsQueryFeedbackList = "/QueryXCTSXX!queryFKXXListXCTSID";// 根据信息id查询协查推送反馈记录
    public static String xiectsFeedback = "/QueryXCTSXX!addFKXX";// 协查反馈信息
    public static String sendJingq = "/HandleJQXX!saveJQXX";// 发送警情
    public static String getIdentifyCardInfo = "/QueryPeople!queryRyxxBySfzhm";// 获取身份证信息
    public static String uploadMedia = "/UploadMedia!saveMedia";// 上传多媒体信息

    public static String queryWangba = "/ZhongheQuery!queryWangba";// 查询网吧信息
    public static String queryLvdian = "/ZhongheQuery!queryLvdian";// 查询旅店信息

    public static String queryZhuanjia = "/ZhongheQuery!queryZhuanjia";// 查询专家信息
    public static String queryJingli = "/QueryJL!queryJingLList";// 查询警力信息
    public static String chujQueryAlongJingys = "/QueryZD!querySTJYList";// 查询处警随同警员
    public static String chujQueryShifcss = "/QueryZD!querySFCS";// 查询处警的事发场所
    public static String chujQueryWeather = "/QueryZD!queryTQLX";// 查询处警的天气情况
    public static String chujQueryChujsx = "/QueryZD!queryCJSX";// 查询处警属性
    public static String chujQueryChujBiaozdzByKeyword = "/HandleJQCLXX!queryBZDZ";// 查询处警的标准地址by关键字
    public static String chujQueryChujBiaozdzBylonlat = "xxxx";// 查询处警的标准地址by经纬度
    public static String queryZiyuan = "/ZhongheQuery!queryYingjiziyuan";// 查询应急资源
    public static String queryYiliaodanwei = "/ZhongheQuery!queryYiliaodanwei";// 查询医疗信息
    public static String queryXiaofangdanwei = "/ZhongheQuery!queryXiaofangdanwei";// 查询消防信息
    public static String queryArea = "/ZhongheQuery!queryArea";// 查询区域信息
    public static String fabuxinxi = "/HandleFabuxinxi!fabuxinxi";// 发布信息
    public static String uploadGPS = "/HandleGPS!updateGPSLocation";// 上传gps信息
    public static String uploadDlxx = "/Heartbeat_beat";// 更新登陆在线时间
    public static String queryZHCXList="/ZhongheQuery!queryZHCXXXList";//通过图层名直接获取查询结果
    public static String queryTCFZList="/ZhongheQuery!queryTCFZXX";//查询地址列表
    // public static String jingqinglb = "/QueryJQ!queryJQLB";// 获取警情类别
    // public static String jingqinglx = "/QueryJQ!queryJQLX";// 获取警情类型
    // public static String jingqingxl = "/QueryJQ!queryJQXL";// 获取警情细类

    // ========数据采集 start========
    public static String caijlx = "/Static2Json!getCJLX";// 获取采集类型列表
    public static String caijTucengByLx = "/Static2Json!getCjtcByLx";// 获取采集图层列表
    public static String caijTucengAddFieldList = "/QueryLayerStructJson!getLayerAttribute";// 获取图层结构属性
    public static String caijSelectDataList = "/Select2Json!getSelectDataByLX";// 获取下拉列表的选择字段
    public static String caijSelectDataOfXiaqu = "/Select2Json!getSSXQData";// 获取下拉列表的选择字段
    public static String caijiAddPoint = "/HandleData2Json!addPoint";// 添加采集点
    public static String caijiAddLineOrArea = "/HandleData2Json!addPolygn";// 添加采集线或面
    // public static String
    // caijiUpdate="/HandleData2Json!updateSingle";//修改单条采集记录
    public static String caijiPointUpdate = "/HandleData2Json!updatePoint";// 修改点
    public static String caijiPolygnUpdate = "/HandleData2Json!updatePolygn";// 修改线或面
    public static String caijiDeletePoint = "/HandleData2Json!deleteData";// 删除采集点
    public static String caijiAuditPoint = "/HandleData2Json!audit";// 审核采集记录
    public static String caijiQueryResult = "/QueryLayer2Json!queryData";// 采集查询结果
    public static String caijiRecordEditFieldList = "/QueryLayer2Json!queryForEdit";// 获取采集记录的字段

    // ========数据采集 end========

    // ========报备 start========
    public static String baobeiTuogang = "/GRBB!baobeiTuogang";// 报备脱岗提交
    public static String getGerenAllByMonth = "/GRBB!baobeiGetAllBaobeis";// 获取该用户下指定月份的所有报备信息
    public static String baobeiSignIn = "/GRBB!baobeiSignIn";// 上岗签到
    public static String baobeiIsNeedSignIn = "/GRBB!baobeiIsNeedSignIn";// 判断是否需要签到
    public static String baobeiReSignIn = "/GRBB!baobeiReSignIn";// 恢复上岗
    public static String baobeiSignOut = "/GRBB!baobeiSignOut";// 离岗签退
    public static String baobeiQueryByDate = "/GRBB!baobeiQueryByDate";// 根据给定日期(年月日)查询当日报备信息
    public static String baobeiQueryHadBaobeiDates = "/GRBB!queryBBDateList_boss";// 根据给定月份查询本月具有报备信息的日期集合,用来展示哪些日期有报备信息
    // ========报备 end========
    // ========统计分析 start========
    public static String jingqfxGetJingqTypes = "/Tongjfx!getAllJingqType";// 获取所有警情类型
    public static String jingqfxGetJingqDatas = "/Tongjfx!getJingqDatasByCondition";// 根据条件获取警情
    public static String jingqfxGetJingqDatasCount = "/Tongjfx!getJingqDatasCountByCondition";// 根据条件获取警情的类型,数量,日期之间的关系.
    public static String jingqfxGetJingqgy = "/Tongjfx!Jqgy";// 根据警情概要信息
    public static String jingqfxGetBaobgy = "/Tongjfx!Bbgy";// 获取报备概要信息
    public static String jingqfxGetUsergy = "/Tongjfx!Usergy";// 获取用户概要信息
    public static String jingqfxGetJingqTongjDatas = "/Tongjfx!Jqtjfx_db";// 警情各类对比统计分析的数据集
    public static String jingqfxGetBaobTongjDatas = "/Tongjfx!Bbtjfx";// 报备各类对比统计分析的数据集
    public static String jingqfxGetUserTongjDatas = "/Tongjfx!Usertjfx";// 用户各类对比统计分析的数据集
    public static String jingqfxGetLineChartNextLevelDatas = "/Tongjfx!Jqtjfx_xt";// 警情分析线图下探
    // ========统计分析 end========
    // ========盘查 start========
    public static String panchaQueryPerson = "/XLPC!pcbd";// 盘查比对,查询所有满足条件的人员信息
    public static String panchaQueryBiduiCommonInfos = "/XLPC!rybdxx";// 查询比对基本信息集合
    public static String panchaQueryBiduiDetailInfosWithWFFZ = "/XLPC!wffzjl";// 查询比对详细信息集合之违法犯罪
    public static String panchaQueryBiduiDetailInfosWithBKRY = "/XLPC!bkjl";// 查询比对详细信息集合之布控人员
    public static String panchaQueryBiduiDetailInfosWithJSBR = "/XLPC!jsbrjl";// 查询比对详细信息集合之精神病人
    public static String panchaQueryBiduiDetailInfosWithLDRK = "/XLPC!ldjl";// 查询比对详细信息集合之流动人口
    public static String panchaQueryBiduiDetailInfosWithPCJL = "/XLPC!pcjl";// 查询比对详细信息集合之盘查记录
    public static String panchaQueryBiduiDetailInfosWithQGCK = "/XLPC!ckjl";// 查询比对详细信息集合之全国常口
    public static String panchaQueryBiduiDetailInfosWithYCCK = "/XLPC!ycckjl";// 查询比对详细信息集合之全国常口
    public static String panchaQueryBiduiDetailInfosWithWFXYR = "/XLPC!wfxyrjl";// 查询比对详细信息集合之违法嫌疑人
    public static String panchaQueryBiduiDetailInfosWithXDRY = "/XLPC!xdjl";// 查询比对详细信息集合之吸毒人员
    public static String panchaQueryBiduiDetailInfosWithZTRY = "/XLPC!ztjl";// 查询比对详细信息集合之在逃人员
    public static String panchaSavePanchaInput = "/XLPC!pcxx_add";// 保存盘查输入的信息
    public static String panchaUpdatePanchaRecord = "/XLPC!pcxx_update";// 修改盘查信息
    public static String panchaQueryPersonWithHecjs = "/XLPC!querypcxx";// 根据输入信息查询人员信息,若返回多条,则跳转到人员列表界面,否则跳转到盘查信息补录界面
    public static String panchaQueryPancReocrds = "/XLPC!pcxxlist";// 根据人员信息查询盘查记录
    // ========盘查分析 end========
    // ========综合查询 start========
    public static String zonghcxQueryAddress = "/ZhongheQuery!queryDZJBXXList";// 查询地址信息
    public static String zonghcxQueryAllAddressLayers = "/ZhongheQuery!queryTCFZXX";// 查询所有分类图层
    public static String zhoubssQueryAllAddressLayers = "/ZhongheQuery!queryTCFL";// 周边搜索查询所有分类图层
    public static String zonghcxQueryCZRK = "/ZhongheQuery!queryckxxlist";// 查询常住人口
    public static String zonghcxQueryJSRY = "/ZhongheQuery!queryjsryxxlist";// 查询驾驶人员
    public static String zonghcxQueryLDRK = "/ZhongheQuery!queryldrkxxlist";// 查询流动人口
    public static String zonghcxQueryLGRK = "/ZhongheQuery!querylgrkxxlist";// 查询旅馆人口
    public static String zonghcxQueryZTRK = "/ZhongheQuery!queryztrkxxlist";// 查询在逃人口
    public static String zonghcxQuerySWRY = "/ZhongheQuery!queryswryxxlist";// 查询上网人员
    public static String zonghcxQueryJingqList = "/QueryJQ!queryJingqListByCondition";// 根据处警信息条件查询
    public static String zonghcxQueryLKXX = "/ZhongheQuery!querylkxxlist";// 查询旅客信息
    public static String zonghcxQueryLGXX = "/ZhongheQuery!querylgrkxxlist";// 查询旅馆信息
    public static String zonghcxQueryCZW = "/ZhongheQuery!queryczwlist";// 查询出租屋数据
    public static String zonghcxQueryCZWZL = "/ZhongheQuery!queryczwzlxxlist";// 查询出租房屋租赁信息
    public static String zonghcxQueryAJXYR = "/XLPC!wfxyrjl";// 查询案件嫌疑人信息
    public static String zonghcxQueryJSBR = "/XLPC!jsbrjl";// 查询精神病人信息

    // ========综合查询 end========
    // ========数据库字典 start========

    public static String jingqingksxz = "/QueryJQ!queryJQCLJG";// 获取警情快速选择处理结果
    public static String queryZZJGZD = "/QueryZD!queryZZJGZD";// 查询所有组织机构字典
    public static String queryCLLXZD = "/QueryZD!queryCLLXZD";// 查询所有车辆类型字典
    public static String queryCLZTZD = "/QueryZD!queryCLZTZD";// 查询所有车辆状态字典
    public static String queryJingqTypeZD = "/QueryZD!getAllJingqType";// 查询所有警情类型字典
    public static String queryChujTypeZD = "/QueryZD!queryCJLX";// 查询所有处警类型字典
    public static String queryJqgyLx = "/QueryZD!queryJqgyLx"; // 获取警情概要类型字典
    public static String queryBbgyLx = "/QueryZD!queryBbgyLx"; // 获取报备概要类型字典
    public static String queryUsergyLx = "/QueryZD!queryUsergyLx"; // 获取用户概要类型字典
    public static String queryJqtjfs = "/QueryZD!queryJqtjfs"; // 获取警情统计方式类型字典
    public static String queryBbtjfs = "/QueryZD!queryBbtjfs"; // 获取报备统计方式类型字典
    public static String queryUsertjfs = "/QueryZD!queryUsertjfs"; // 获取用户统计方式类型字典
    public static String queryJqszlx = "/QueryZD!queryJqszlx"; // 获取警情统计数值类型字典
    public static String queryBbszlx = "/QueryZD!queryBbszlx"; // 获取报备统计数值类型字典
    public static String queryUserszlx = "/QueryZD!queryUserszlx"; // 获取用户统计数值类型字典
    public static String queryPancyy = "/QueryZD!queryPCYY"; // 获取盘查原因字典
    public static String queryChujdw = "/QueryZD!queryZHCXCJDWFL"; // 获取处警单位字典
    // ========数据库字典 end========
    // ========消息推送 start========
    public static String receiveMsg = "/ConfirmArrive!confirmReceiveMsg";// 推送消息接受确认
    // ========消息推送 end========

    public static String getSERVER() {
            return "http://" + HOST_IP + ":" + HOST_PORT + "/mobileJWT/json";
    }
}
