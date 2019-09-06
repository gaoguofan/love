package com.bkn.browser.config;

/**
 * 视图地址常量类，定义时使用根目录/WEB-INF/views/下对绝对地址
 * @author 李志伟
 * @date Aug 4, 2015 9:21:29 AM
 */
public interface PageConfig {

    /**
     * 网页端访问路由
    * @author 李志伟
    * @date 2017年3月10日 下午3:39:02
     */
	class BrowserIndex {
		/** 登陆页面 */
		public static final String LOGIN_INDEX = "login";
		/** 登陆页面 */
        public static final String SYSTEM_PAY = "platform/system_pay";
        /** 登陆页面 */
        public static final String SERVICE_PAY = "platform/service_pay";
	}
	
	class Login {
        /** 登陆页面 */
        public static final String LOGIN_VIEW = "login/login";
    }
	
	/**
	 * 
	* @author 骆峰
	* @date 2017年3月27日 下午5:23:04
	 */
	class Setting {
	    /** 设置页面 */
        public static final String SETTING_BASESET = "setting/baseSet";
        /** 权限页面 */
        public static final String SETTING_MANAGESET = "setting/manageSet";
        /** 菜单页面 */
        public static final String SETTING_MUNE_ROLE = "setting/set_role_manage";
        /** 微信页面 */
        public static final String SETTING_WECHARSETTING = "setting/wecharSetting";
        /** 用户基本信息页面 */
        public static final String SETTING_USERSETTING = "setting/userSetting";
        /** 巴康诺短信流水 */
        public static final String VIEW_BKN_MSM = "setting/msm";
        /** 巴康诺提款 */
        public static final String VIEW_BKN_WITHDRAWCASH = "report/withdraw_cash";
        
        /** 售后 */
        public static final String SETTING_ORDERSALES = "setting/orderSales";
        
        /** 评价 */
        public static final String SETTING_EVALUATE = "setting/evaluate_manage";
     
	}
	
	
	/**
	 * 
	* @author 骆峰
	* @date 2017年3月27日 下午5:23:14
	 */
	class Order{
	    /** 快速开单 */
        public static final String ORDER_BASESET = "order/order";
        /** 订单管理 */
        public static final String ORDER_MANAGE = "order/orderManage";
        /** 订单管理 */
        public static final String ORDER_UCD = "order/orderUcd";
        /** 已经完成订单 */
        public static final String ORDER_UCD_READY = "order/orderReady";
        /** 营业汇总 */
        public static final String VIEW_BUSINESS_SUMMARY = "order/businessSummary";
        /** 巴康诺快报 */
        public static final String VIEW_BKN_NEWS = "report/news";
        /** 组合订单 */
        public static final String ORDER_UCD_ZH = "order/orderZh";
        
	}
	
	/**
	 * 款项管理
	* @author 骆峰
	* @date 2017年3月22日 下午2:10:34
	 */
	class Money{
	    /** 款项管理 */
        public static final String DEPTMONEY_VIEW = "money/deptMoney";
        /** 客户动态 */
        public static final String REPORT_MONEYWATER = "report/money_water";
        /** 支付流水 */
        public static final String VIEW_PAY_FLOW = "money/payFlow";
	}
	/**
	 * 移动端
	* @author 李志伟
	* @date 2017年3月16日 上午10:34:43
	 */
	class Wechat {
	    /** 设置页面 */
        public static final String LOGIN = "uclubdoctor/register";
        /** 个人资料 */
        public static final String PERSONAL = "uclubdoctor/personal";
        /** 序列号录入 */
        public static final String SERIES = "uclubdoctor/series";
        /** 我的历史测评 */
        public static final String HISTORY = "uclubdoctor/history";
        /** 我的图表 */
        public static final String CHARS = "uclubdoctor/chars";
        /** 个人信息展示 */
        public static final String MESSAGE = "uclubdoctor/message";
        /** 我的订单 */
        public static final String ORDER = "uclubdoctor/order";
        /** 我的订单详情 */
        public static final String ORDER_DETAIL = "uclubdoctor/orderDetail";
        /** 我的订单状态 */
        public static final String ORDER_STATUS = "uclubdoctor/orderStatus";
        /** 测评订单查看分析报告 */
        public static String MOBILE_USER_ORDER_ANALYSE = "uclubdoctor/analyse";
        /** 支付订单网页 */
        public static String MOBILE_USER_ORDER_PAY = "uclubdoctor/pay";
        
        /** 大卖场 */
        public static final String MOBILE_HYPER_MARKET = "wechat/market";
        /** 产品详情 */
        public static final String MOBILE_HYPER_PRODUCKT = "wechat/prodeckt";
        /** 热销商品 */
        public static final String MOBILE_HYPER_HOT = "wechat/hot";
        /** 个人页面 */
        public static final String MOBILE_USER_PERSON = "wechat/person";
        /** 待收货订单 */
        public static final String MOBILE_USER_ORDER_RECEIVED = "wechat/receive";
        /** 推荐人查看 */
        public static final String MOBILE_REFEREE = "wechat/referee";
        /** 代理商分布 */
        public static final String MOBILE_AGENT = "wechat/agent";
        /** 二级推荐人查看 */
        public static final String MOBILE_REFEREE_S = "wechat/referees";
        /** 关注商品查看 */
        public static final String MOBILE_GOODS_STARS = "wechat/stars";
        /** 购物车 */
        public static String MOBILE_GOODS_CART = "wechat/cart";
        /** 地址项管理 */
        public static String MOBILE_USER_ADDRESS = "wechat/address";
        /** 已完成订单 */
        public static String MOBILE_USER_ORDER_HAS_RECEIVED = "wechat/order";
        /** 账号设置 */
        public static String MOBILE_USER_MANAGEMENT = "wechat/management";
        /** 已完成款项 */
        public static String MOBILE_COMPLETED_SUM = "wechat/completed";
        /** 渠道商首页 */
        public static String MOBILE_CHANNEL_HOME = "wechat/channel";
        /** 评价订单 */
        public static String MOBILE_GOODS_APPRAISE = "wechat/appraise";
        /** 渠道排行榜 */
        public static String MOBILE_CHARTS = "wechat/charts";
        /** 获利总览 */
        public static String MOBILE_PROFIT = "wechat/profit";
        /** 我的评价 */
        public static String MOBILE_MY_EVAL = "wechat/eval";
        /** 应收款 */
        public static String MOBILE_COLLECTION_TRUSTED = "wechat/trusted";
        /** 待付款 */
        public static String MOBILE_CUSTOMARY_DUES = "wechat/dues";
        /** 待确认订单 */
        public static String MOBILE_COLLECTION_SHURE = "wechat/shure";
        /** 申请售后 */
        public static String MOBILE_AFTER_SALES = "wechat/salse";
        /** 我的售后 */
        public static String MOBILE_SALSE_VIEW = "wechat/salseview";
        /** 手机号码修改 */
        public static String MOBILE_USER_PHONE = "wechat/phone";
        /** 账号密码修改 */
        public static String MOBILE_USER_PAS = "wechat/pas";
        /** 待发货订单 */
        public static String MOBILE_ORDER_SUSPENSE = "wechat/suspense";
        /** 地址簿管理 */
        public static String MOBILE_ADDRESS_CONFIG = "wechat/new_address";
        /** 巴康诺快报 */
        public static String QUITE = "wechat/quite";
        /** 提现记录 */
        public static String CASH = "wechat/cash";
        
	}
	
	/**
	 * 商品
	 * @author 李金荣
	 * @date 2017年3月17日 上午10:19:09
	 */
	class GoodsInfo {
	    /** 商品信息 */
	    public static final String VIEW_GOODS_INFO = "goods/goodsInfo";
	    /** 产品类别 */
	    public static final String VIEW_PRODUCT_CATEGORY = "goods/productCategory";
	    /** 商品销售信息 */
	    public static final String VIEW_GOODS_SALE_INFO = "goods/goodsSaleInfo";
	}
	
	/**
	 * 产品
	 * @author 李金荣
	 * @date 2017年3月17日 上午10:19:13
	 */
	class ProductInfo {
	    /** 产品信息 */
	    public static final String VIEW_PRODUCT_INFO = "product/productInfo";
	}
	
	/**
	 * 客户
	 * @author 李金荣
	 * @date 2017年3月17日 上午10:19:49
	 */
	class CustomerInfo {
	    /** 客户信息 */
	    public static final String VIEW_CUSTOMER_INFO = "customer/customerInfo";
	}
}
