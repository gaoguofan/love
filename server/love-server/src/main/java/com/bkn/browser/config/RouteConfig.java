
package com.bkn.browser.config;

/**
 * 接口地址常量类，定义时使用根目录下的绝对地址
 *
 * @author 李志伟
 * @date Aug 4, 2015 9:20:30 AM
 */
public interface RouteConfig {
    
    /**
     * 登陆类
    * @author 李志伟
    * @date 2017年3月11日 下午3:31:15
     */
    class Login {
        /** 系统目录 */
        public static final String SYSTEM_INDEX = "/";
        /** 登录页面 */
        public static final String LOGIN_VIEW = "login/view";
        /** 获取验证码 */
        public static final String GET_YZM_PAGE_BKN = "app/bkngetYzmPage";
        /** 登录 */
        public static final String BKNUSER_LOGIN = "login/bknuser/login";
        /** 退出登录 */
        public static final String BKNUSER_OUT_LOGIN = "login/out/login";
        /** 更新微信菜单 */
        public static final String WECHAT_MENU_ACTION = "app/wechat/menu";
    }
    
    
    /**
     * 订单
    * @author 骆峰
    * @date 2017年3月16日 下午6:52:25
     */
    class Order {
        /**快速开单*/
        public static final String ORDER_VIEW_QUICK = "order/view/quick";
        /**快速开单保存*/
        public static final String ORDER_SAVE_QUICK = "order/save/quick";
        /**订单管理*/
        public static final String VIEW_ORDER = "view/order/manage";
        /**订单UCD测试*/
        public static final String VIEW_ORDER_UCD_TEST = "view/order/ucd/test";
        /**查询订单UCD测试订单*/
        public static final String VIEW_ORDER_UCD_QUERY = "view/order/ucd/query";
        /**上传的测评订单*/
        public static final String ACTION_ORDER_UPDATE = "action/customer/orderUpdate";
        /**查询已经上传的测评订单*/
        public static final String VIEW_ORDER_UCD_ALL_READY_QUERY = "view/order/ready/ucd/query";
        /**查询测评数据*/
        public static final String SELECT_LIST_ORDER = "select/order/orderid";
        /**撰写报告*/
        public static final String ACTION_UCD_BG = "action/ucd/baogao";
        /**组合订单查看*/
        public static final String ACTION_UCD_ZH = "view/order/zh/ucd/query";
        /**组合订单更变*/
        public static final String ACTION_UCD_ZH_STATUS = "view/order/zh/ucd/status";
        
        
        
        /**订单确认*/
        public static final String SAVE_LIST_ORDER = "order/save/List";
        
        /** 营业汇总 */
        public static final String ACTION_BUSINESS_SUMMARY = "action/order/businessSummary";
        /**订单条件查询*/
        public static final String SELECT_LIST_ONE = "order/select/ListOne";
        /**订单分页条件查询*/
        public static final String VIEW_ORDER_PAGE = "view/order/page";
        /**款项页面*/
        public static final String MONEY_VIEW = "money/viwe/deptMoney";
        /**款项付款*/
        public static final String SAVE_DEPT_VIEW = "save/dept/falw";
        /**查询明细付款*/
        public static final String SELECT_DEPT_VIEW = "select/dept/falw";
        /**查询明细收款*/
        public static final String SELECT_MONEY_VIEW = "select/money/falw";
        
        /**款项*/
        public static final String UPDATE_DEPT_LIST = "update/dept/list";
        
        /**款项收款*/
        public static final String SAVE_MONEY_VIEW = "save/money/falw";
        /**款项付款*/
        public static final String SELECT_DEPT_lIST = "select/dept/list";
        /**款项收款*/
        public static final String SELECT_MONEY_lIST = "select/money/list";
        /**付款作废*/
        public static final String UPDATE_MONEY_DEPT = "update/money/dept";
        /**收款作废*/
        public static final String DELETE_MONEY_DEPT = "delete/money/dept";
        /**分页查询*/
        public static final String VIEW_DEPT_MONEY_PAGE = "view/dept/money/page";
        
        /** 收支流水 */
        public static final String VIEW_PAY_FLOW = "order/view/payFlow";
        /** 查询 */
        public static final String VIEW_FIND_PAY_FLOW = "action/find/flow/{type}";
        /** 查询 */
        public static final String VIEW_DELETED_WITHDRAW = "bkn/deleted/withdraw";
        /** 客户总付金额 */
        public static final String ACTION_CUSTOMER_INCOME_AMOUNT = "action/customer/income/amount";
    }
    
    /**
     * 设置
    * @author 骆峰
    * @date 2017年3月14日 下午2:26:44
     */
    
    class Setting {
        
        /**设置页面*/
        public static final String SETTING_VIEW_BASESET = "setting/view/baseSet";
        /**用户基本信息页面*/
        public static final String SETTING_VIEW_USER = "setting/view/user";
        /**设置保存*/
        public static final String SETTING_SAVE_UPDATE = "setting/save/update";
        /**设置刷新*/
        public static final String SETTING_SELECT_SETTING = "setting/select/setting";
        /** 权限分配页面 */
        public static final String SYSTEM_VIEW_SHOWROLE = "system/view/showRole";
        /** 管理员设置 保存 */
        public static final String BKNADMINISTRATOR_SAVEUPDATE = "administrator/action/saveUpdate";
        /** 管理员初始化密码*/
        public static final String BKNUSER_UODATE_PASSWORD = "bnkuser/update/password";
        /** 管理员设置 */
        public static final String SYSTEM_VIEW_BKNADMINISTRATOR = "system/view/bknadministrator";
        /** 管理菜单 */
        public static final String SYSTEM_VIEW_BKNSELECTROLE = "system/view/bknselectRole";
        /** 管理菜单 */
        public static final String SYSTEM_VIEW_BKNSAVEROLE = "system/view/bknsaveRole";
        /** 删除角色 */
        public static final String SYSTEM_VIEW_BKNDELETEDROLE = "system/view/bkndeleteRole";
        /** 系统管理员查询 */
        public static final String ADMINISTRATOR_ACTION_BKNSELECTUSERR = "administrator/action/bknselectUser";
        /** 系统管理员删除 */
        public static final String ADMINISTRATOR_ACTION_BKNDELETEDUSER = "administrator/action/bkndeleteUser";
        /** 微信 */
        public static final String WECHAR_VIEW_BKN = "wechat/view/bkn";
        /** 将base64上传至七牛 */
        public static final String BASE64 = "qiniu/base64";
        /** 微信设置保存 */
        public static final String BKNMEMBERSHOP_ACTION = " bknmembershop/action";
        /**售后*/
        public static final String SETTING_ORDER_SALES = "setting/order/sales";
        /**售后查询*/
        public static final String SETTING_SELECT_ORDERSALES = "setting/select/orderSales";
        /**售后查询分页*/
        public static final String SELECT_ORDERSALES_PAGE = "setting/select/orderSales/page";
        /**售后保存*/
        public static final String SETTING_SALES_STATUS = "  save/sales/status";
        
        /** 短信服务流水 */
        public static final String VIEW_SMS_FLOW = "system/view/smsFlow";
        
        
        /** 管理评价*/
        public static final String USER_CHANG_EVALUATION = "user/change/evaluation";
        
        
        /** 管理员修改密码*/
        public static final String CHANGE_UPDATE_PASSWORD = "user/change/password";
        
        /** 评论修改*/
        public static final String EVALUATION_UPDATE_ONE = " evaluation/update/one";
        /** 评论查询*/
        public static final String EVALUATION_SELECT_ONE = " evaluation/select/one";
        
    }
    /**
     * 移动支付类
     * @author 李志伟
     * @date 2016年5月10日 下午6:00:20
     */
    class AppPay {
        /** 发起NATIVE扫码支付请求 */
        public static final String REQUEST_APP_PAY = "app/pay/qr";
        /** 发起网页扫码支付请求 */
        public static final String REQUEST_APP_PAY_JS_API = "app/pay/js/api";
        /** 生成微信支付二维码 */
        public static final String REQUEST_APP_PAY_CODE = "app/pay/code";
        /** 发起micro支付请求 */
        public static final String REQUEST_APP_MICRO = "app/pay/micro";
        /** NATIVE扫码支付请求回调 */
        public static final String REQUEST_APP_PAY_CALLBACK = "app/pay/qr/call/{outTradeNo}";
        /** 网页扫码支付请求回调 测评订单 */
        public static final String APP_PAY_JS_API_PATH = "app/pay/js/ucd/{id}";
        /** 网页扫码支付请求回调 组合订单 */
        public static final String APP_PAY_JS_API_ORDER_PATH = "app/pay/js/order/{id}";
        /** 商城调起微信支付 */
        public static final String GOODSINFO_PAY = "app/goodsinfo/wechat/init/pay";
        /** 支付成功回调接口 */
        public static final String GOODSINFO_PAY_CALLBACK = "app/goodsinfo/wechat/pay/callback/{transactionId}";
        /** 微信支付统一下单api */
        public static final String WECHAT_SERVER_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        /** 微信支付micropay api */
        public static final String WECHAT_MICROPAY_API = "https://api.mch.weixin.qq.com/pay/micropay";
        /** 发起NATIVE扫码支付请求 */
        public static final String REQUEST_APP_SYSTEM_PAY = "app/system/pay/qr";
        /** NATIVE扫码支付请求回调 */
        public static final String REQUEST_APP_SYSTEM_PAY_CALLBACK = "app/system/pay/qr/call/{outTradeNo}";
    }
    
    /** 七牛图片处理模块 */
    class Qiniu {
        /** 获取token */
        public static final String UPTOKEN = "qiniu/uptoken";
        /** 抓取网络资源上传到七牛 */
        public static final String FETCH = "qiniu/fetch";
        /** 文字转语音 */
        public static final String TEXT_TO_VOICE = "qiniu/textToVoice";
        /** 将base64上传至七牛 */
        public static final String BASE64 = "qiniu/base64";
    }

    /** 微信接口 */
    class Wechat {
        /** 微信验证及消息回复 */
        public static final String CHART = "coreServlet";
        /** 微信上传获得永久thumb_media_id */
        public static final String GETTHUMBID = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";
        /** 微信上传获得上传图片URL */
        public static final String GETPICURL = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
        /** 根据openId群发消息 */
        public static final String SEND_MESSAGEBYID = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
        /** 上传图文素材获得medaiId */
        public static final String GETMEDIAID = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
        /** 菜单创建-微信接口 */
        public static final String CREATE_NORMAL_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
        /** 个性化菜单创建-微信接口 */
        public static final String CREATE_CONDITIONAL_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
        /** 菜单删除-微信接口 */
        public static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
        /** 创建分组-微信接口 */
        public static final String CREATE_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
        /** 删除分组-微信接口 */
        public static final String DELETED_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
        /** 获取分组-微信接口 */
        public static final String GET_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN";
        /** 移动用户分组-微信接口 */
        public static final String MOVE_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
        /** 获取accessToken */
        public static final String GET_ACCESSTOKEN = "https://api.weixin.qq.com/cgi-bin/token?gra"
                + "nt_type=client_credential&appid=APPID&secret=APPSECRET";
        /** 获取图文消息列表 */
        public static final String GET_THUMB = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
        /** 微信更新图文消息 */
        public static final String UPDATE_WECHAT = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";
        /** 微信删除图文消息 */
        public static final String DELETE_WECHAT = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
        /** 微信发送模板消息 */
        public static final String SEND_COUPON = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        /** 微信图文消息预览 */
        public static final String ITEM_PRE_VIEW = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
        /** 二维码临时ticket */
        public static final String TICKET = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
        /** 发送消息(文本) */
        public static final String COUCOMER_PUSH_MSG = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
        /** 生成微信卡包 */
        public static final String WECHAT_MEMBER_LEVEL = "https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN";
        /** 查询会员卡包 */
        public static final String WECHAT_MEMBER_LEVEL_QUERY = "https://api.weixin.qq.com/card/user/getcardlist?access_token=ACCESS_TOKEN";
        /** 核销会员卡包 */
        public static final String WECHAT_MEMBER_LEVEL_DELETED = "https://api.weixin.qq.com/card/code/unavailable?access_token=ACCESS_TOKEN";
        /** 微信卡包背景图 */
        public static final String WECHAT_MEMBER_LEVEL_IMAGE = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
        /** 商户支付,redPachage */
        public static final String WECHAT_MONEY_PAY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
        /** 商户支付,款项卡款 */
        public static final String WECHAT_JBS_PAY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
        /** 商户支付,退款 */
        public static final String WECHAT_PAY_REBACK = "https://api.mch.weixin.qq.com/secapi/pay/refund";
        /** 商户支付,订单查询 */
        public static final String WECHAT_PAY_ORDERQUERY = "https://api.mch.weixin.qq.com/pay/orderquery";
        /** 微信七牛上传图片存储图片,用于图片库 */
        public static final String QINNIU_UPLOAD = "wechat/qiniu/upload";
        /** 微信授权回调接口 */
        public static final String CALL_BACK = "/wechat/callback/{openidKey}";
        /** 微信授权回调接口-授权平台返回 */
        public static final String CALL_BACK_OPEN_SDK = "/wechat/ws/sdk/{openidKey}";
        /** 发起微信支付 */
        public static final String CREATE_PAY = "/wechat/pay/create";
        /** 微信支付回调接口 */
        public static final String CALL_BACK_PAY = "/wechat/pay/callback";
        /** 提取微信素材资源 */
        public static final String FETCH_MEDIA = "wechat/fetch/media";
        /** 进入新增图文消息页面 */
        public static final String ARTIC_MANAGER = "/artic/manager";
        /** 跳转某个图文消息修改页面，并展示其信息 */
        public static final String SEND_UPDATE_ITEM = "wechat/send/update/item";
        /** 更新thumbId */
        public static final String CHANGE_THUMB_ID = "wechat/update/thumb/id";

    }
    
    /**
     * 用户微信接口地址
    * @author 李志伟
    * @date 2017年3月16日 上午10:06:26
     */
    class WechatUser {
        /** 微信端用户登陆 */
        public final static String WECHAT_USER_LOGIN_VIEW = "app/user/login";
        /** 个人信息完善 */
        public final static String WECHAT_USER_PERSONAL = "app/user/personal";
        /** 序列码录入 */
        public final static String WECHAT_USER_SERIES = "app/user/series";
        /** 序列码查询 */
        public final static String WECHAT_USER_QUERY_SERIES = "app/user/query/series";
        /** 我的历史 */
        public final static String WECHAT_USER_HISTORY = "app/user/history";
        /** chars图表 */
        public final static String WECHAT_USER_CHARS = "app/user/chars";
        /** 个人页面 */
        public static final String WECHAT_USER_PERSON = "app/user/mobile/person";
        /** 我的订单 */
        public static final String WECHAT_USER_ORDER = "app/user/order";
        /** 我的订单详情 */
        public static final String WECHAT_USER_DETAIL = "app/user/orderDetail";
        /** 移动端查看检测报告*/
        public static final String VIEW_ORDER_UCD_ALL_READY_QUERY = "app/order/ready/ucd/query";
        /** 我的订单状态 */
        public static final String WECHAT_USER_STATUS = "app/user/orderStatus";
        /** 微信网页支付-测试订单 */
        public static final String WECHAT_APP_PAY_FOR_TEST = "app/wechat/pay/test";
        /** 微信网页支付-组合订单 */
        public static final String WECHAT_APP_PAY_FOR_ORDER = "app/wechat/pay/order";
        
        
        /** 退出登录 */
        public static final String WECHAT_USER_LOGIN_OUT = "app/user/login/out";
        /** 巴康诺大卖场 */
        public final static String WECHAT_USER_MOBILE_HYPERMARKET = "app/user/mobile/hypermarket";
        /** 查看产品详情 */
        public static final String WECHAT_USER_MOBILE_GOODS_DETAIL = "app/user/mobile/goods/detail";
        /** 购物车 */
        public static final String WECHAT_USER_MOBILE_ADD_CART = "app/user/mobile/add/cart";
        /** 关注产品 */
        public static final String WECHAT_USER_MOBILE_SHOP_STARS = "app/user/mobile/add/stars";
        /** 热销商品INDEX */
        public static final String WECHAT_USER_MOBILE_GOODS_HOT = "app/user/mobile/goods/hot";
        /** 清算购物车 */
        public static final String WECHAT_USER_MOBILE_GOODS_CART = "app/user/mobile/goods/cart";
        /** 删除购物车 */
        public static final String WECHAT_USER_MOBILE_DELETED_CART = "app/user/mobile/deleted/cart";
        /** 评价订单 */
        public static final String WECHAT_USER_MOBILE_GOODS_APPRAISE = "app/user/mobile/goods/appraise";
        /** 验证码获取 */
        public static final String WECHAT_USER_LOGIN_CODE = "app/user/mobile/verge";
        /** 地址栏管理 */
        public static final String WECHAT_USER_MOBILE_ADDRESS = "app/user/mobile/address";
        /** 待收货订单 */
        public static final String WECHAT_USER_LOGIN_ORDER_RECEIVED = "app/user/mobile/order/received";
        /** 已完成订单 */
        public static final String WECHAT_USER_LOGIN_ORDER_HAS_RECEIVED = "app/user/mobile/order/has/received";
        /** 待发货订单 */
        public static final String WECHAT_USER_LOGIN_ORDER_SUSPENSE = "app/user/mobile/order/suspense";
        /** 设置账号 */
        public static final String WECHAT_USER_MANAGEMENT = "app/user/mobile/manage";
        /** 账号切换 */
        public static final String WECHAT_USER_MANAGEMENT_SWITH = "app/user/mobile/manage/swith";
        /** 账号切换更新 */
        public static final String WECHAT_USER_ACCOUNT_UPDATE = "app/user/mobile/manage/update";
        /** 已完成款项 */
        public static final String WECHAT_USER_COMPLETED_SUM = "app/user/mobile/completed/sum";
        /** 渠道首页 */
        public static final String WECHAT_USER_CHANNEL_HOME = "app/user/mobile/channel/home";
        /** 渠道排行榜 */
        public static final String WECHAT_USER_CHARTS = "app/user/mobile/charts";
        /** 获利总览 */
        public static final String WECHAT_USER_PROFIT = "app/user/mobile/profit";
        /** 推荐人查看 */
        public static final String WECHAT_USER_REFEREE = "app/user/mobile/referee";
        /** 代理商分布 */
        public static final String WECHAT_AGENT = "app/user/mobile/agent";
        /** 我的评价 */
        public static final String WECHAT_USER_MY_EVAL_VIEW = "app/user/mobile/my/eval";
        /** 应收款 */
        public static final String WECHAT_USER_COLLECTION_TRUSTED = "app/user/mobile/collection/trusted";
        /** 待确认订单 */
        public static final String WECHAT_USER_COLLECTION_SHURE = "app/user/mobile/collection/shure";
        /** 应付款 */
        public static final String WECHAT_USER_CUSTOMARY_DUES = "app/user/mobile/customary/dues";
        /** 申请售后 */
        public static final String WECHAT_USER_MOBILE_AFTER_SALES = "app/user/mobile/after/salse";
        /** 查看我的售后 */
        public static final String WECHAT_USER_MOBILE_AFTER_SALES_VIEW = "app/user/mobile/after/salse/view";
        /** 修改手机号码 */
        public static final String WECHAT_USER_PHONE_ACTION = "app/user/mobile/phone/action";
        /** 修改登录密码 */
        public static final String WECHAT_USER_PAS_ACTION = "app/user/mobile/pas/action";
        /** 验证码获取 */
        public static final String WECHAT_USER_UPDATE_PHONE = "app/user/mobile/phone/verge";
        /** 手机号码修改 */
        public static final String WECHAT_USER_PHONE_UPDATE = "app/user/mobile/phone/update/action";
        /** 地址簿管理 */
        public static final String WECHAT_USER_MOBILE_ADDRESS_CONFIG = "app/user/mobile/phone/address/config";
        /** 巴康诺快报查看 */
        public static final String WECHAT_USER_MOBILE_BKN_QUITE_MSG = "app/user/mobile/phone/quite/msg";
        /** 用户提现操作 */
        public static final String WECHAT_USER_WITHDRAW_CASH = "app/user/mobile/withdraw/cash";
    }
    
    /**
     * 商品信息
     * @author 李金荣
     * @date 2017年3月14日 下午2:57:12
     */
    class GoodsInfo {
        /** 商品信息 */
        public static final String VIEW_GOODS_INFO = "goods/view/goodsInfo";
        /** 添加（更新）商品信息 */
        public static final String ACTION_GOODS_ADD_OR_UPDATE = "action/goods/addOrUpdate";
        /** 添加（更新）商品信息 */
        public static final String APP_GOODS_ADD_OR_UPDATE = "app/goods/addOrUpdate";
        
        /** 产品类别 */
        public static final String VIEW_PRODUCT_CATEGORY = "goods/view/productCategory";
        /** 添加（更新）产品类别 */
        public static final String ACTION_CATEGORY_ADD_OR_UPDATE = "action/category/addOrUpdate";
        
        /** 商品销售信息 */
        public static final String VIEW_GOODS_SALE_INFO = "goods/view/saleInfo";
    }
    
    /**
     * 产品信息
     * @author 李金荣
     * @date 2017年3月15日 下午5:46:33
     */
    class ProductInfo {
        /** 产品信息 */
        public static final String VIEW_PRODUCT_INFO = "product/view/productInfo";
        /** 新增（更新）产品 */
        public static final String ACTION_PRODUCT_ADD_OR_UPDATE = "action/product/addOrUpdate";
        /** 批量上架商品 */
        public static final String ACTION_PRODUCT_BATCH_ENABLE = "action/product/batchEnable";
        /** 根据产品标识查询 */
        public static final String ACTION_PRODUCT_QUERY_ID = "action/product/queryById";
        
    }
    
    
    /**
     * 报表
    * @author 骆峰
    * @date 2017年3月23日 下午3:37:17
     */
    class Report {
        /** 客户提成 */
        public static final String VIEW_CUSTOMER = "customer/view/list";
        /** 客户提成查询 */
        public static final String SELECT_CUSTOMER_LIST = "select/customer/list";
        
        /** 巴康诺快报 */
        public static final String VIEW_BKN_NEWS = "bkn/view/news";
        /** 巴康诺快报（更新）添加 */
        public static final String ACTION_NEWS_ADD_OR_UPDATE = "action/news/addOrUpdate";
        
        /** 巴康诺短信流水 */
        public static final String VIEW_BKN_MSM = "bkn/view/msm";
        
        /** 巴康诺客户提现查看 */
        public static final String BKN_SELECT_WITHDRAW = "bkn/select/withdraw";
        /** 巴康诺客户加盟抵扣 */
        public static final String BKN_SELECT_WITHDRAWFLOW = "bkn/select/withdrawFlow";
        
        /** 提现 */
        public static final String VIEW_BKN_WIDHDRAW = "bkn/view/widhdraw";
        /** 提现查询 */
        public static final String VIEW_BKN_WIDHDRAWTIME = "bkn/select/withdrawTime";
        /** 提现查询明细 */
        public static final String VIEW_BKN_WIDHDRAWDATIAL = "bkn/select/withdrawDatial";
        /** 提现查询明细作废 */
        public static final String VIEW_DELETED_WIDHDRAWDATIAL = "bkn/deleted/withdrawDatial";
    }
    /**
     * 客户信息
     * @author 李金荣
     * @date 2017年3月17日 上午10:21:12
     */
    class CustomerInfo {
        /** 客户信息 */
        public static final String VIEW_CUSTOMER_INFO = "customer/view/customerInfo";
        /** 添加（更新）客户 */
        public static final String ACTION_CUSTOMER_ADD_OR_UPDATE = "action/customer/addOrUpdate";
        /** 客户动态 */
        public static final String VIEW_CUSTOMER_DYNAMIC = "customer/view/customerDynamic";
        /** 客户信息球具信息 */
        public static final String VIEW_CUSTOMER_GOODS = "customer/query/goods";
        /** 在线下单操作 */
        public static final String ACTION_CUSTOMER_ORDER = "action/customer/order";
    }

}
