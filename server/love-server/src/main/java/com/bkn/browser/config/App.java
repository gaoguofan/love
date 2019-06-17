package com.bkn.browser.config;

import javax.servlet.http.HttpServletResponse;

/**
 * 系统业务常量类
 *
 * @author 小高
 * @date Aug 4, 2015 9:19:50 AM
 */
public interface App {

	/** 系统基础常量 */
	class System {
		/** 所有接口成功时返回的CODE值 */
		public static final int API_RESULT_CODE_FOR_SUCCEES = 0;
		/** 所有接口成功时返回的MSG值 */
		public static final String API_RESULT_MSG_FOR_SUCCEES = "succees";
		/** 所有接口异常情况时返回的CODE值 */
		public static final int API_RESULT_CODE_FOR_FAIL = -1;
		/** 所有接口异常情况时返回的MSG值 */
		public static final String API_RESULT_MSG_FOR_FAIL = "fail";
		/** 分页查询默认的每页显示数量 */
		public static final int API_DEFAULT_PAGE_SIZE = 50;
		/** 服务器域名 */
		public static final String SERVER_HOST = "www.sumer.ink";
		/** 消息队列主机 */
		public static final String NOTYNOCE_SERVER_HOST = "120.24.165.15";
		/** 服务器地址 */
		public static final String SERVER_BASE_URL = "http://" + SERVER_HOST + "/uclubdoctor";
		/** 项目根目录 */
        public static final String SERVER_CONTEXT_LOADER = "uclubdoctor";
		/** 权限不足 */
		public static final int ERROR_CODE_FORBIDDEN = HttpServletResponse.SC_FORBIDDEN;
		/** 会话失效 */
		public static final int ERROR_CODE_SESSION_INVALID = 999;
		
	}

	/** 队列通道常量 */
	class Queue {
		
	}
	
	/** redis常量key */
	class Redis {
		/** 百度语音合成AccessToken的key */
		public static final String BAIDU_TEXT_TO_VOICE_ACCESS_TOKEN_KEY = "baidu_text_to_voice_access_token_key";
		/** 门店对应微信accessToken的hash key */
		public static final String STORE_WECHAT_ACCESS_TOKEN_KEY_HASH = "store_wechat_access_token_key_hash";
		/** 门店对应微信JS接口的临时票据 */
		public static final String STORE_WECHAT_JSAPI_TICKET_KEY_HASH = "store_wechat_jsapi_ticket_key_hash";
		/** 手机验证码前缀，后面跟手机号码 */
		public static final String PHONE_VERIFY_CODE_KEY_PRE = "phone_verify_code_key_";
		/** 手机验证码前缀, 更新手机号码, 后面跟手机号码 */
        public static final String PHONE_UPDATE_CODE_KEY_PRE = "phone_update_code_key_";
		/** 从redis中获取订单号 */
        public static final String GET_ORDER_CODE = "get_order_code";
        /** APP接口token 与 用户账户ID对应的hash key */
        public static final String APP_TOKEN_USER_KEY_HASH = "app_token_user_key_hash";
        /** APP接口用户账户ID 与 token对应的hash key */
        public static final String APP_USER_TOKEN_KEY_HASH = "app_user_token_key_hash";
        /** APP接口token 与 用户设备类型对应的hash key */
        public static final String APP_TOKEN_DEVICE_TYPE_KEY_HASH = "app_token_device_type_key_hash";
        /** APP接口token 与 用户设备标识对应的hash key */
        public static final String APP_TOKEN_DEVICE_TOKEN_KEY_HASH = "app_token_device_token_key_hash";
        /** 内测访问名单 */
        public static final String BETA_ACCESS_USER_SET = "beta_access_user_set";
        /** 微信标识对应渠道商标识 */
        public static final String BKN_WECHAT_OPENID_DISTRIBUTOR = "bkn_wechat_openid_distrbutor";
        /** 渠道商标识对应微信标识 */
        public static final String BKN_WECHAT_DISTRIBUTOR_OPENID = "bkn_wechat_distrbutor_openid";
        /** 订单基础传输对象的hash key，key为订单编号，value为订单信息，包含订单明细、服务明细 */
        public static final String ORDER_BASE_INFO_KEY_HASH = "order_base_info_key_hash";
	}

	/** session常量key */
	class Session {
		/** 头部一级菜单 */
		public static final String SYSTEM_HEAD_MENU = "session_key_system_head_menu";
		/** 侧边二级菜单 */
		public static final String SYSTEM_LEFT_SUB_MENU = "session_key_system_left_submenu";
		/** 当前用户的openid */
		public static final String WECHAT_OPEN_ID = "session_key_wechat_open_id";
		/** 当前用户的userid */
		public static final String USER_ID = "session_key_user_id";
		/** 当前用户的MEMBER_ID */
        public static final String MEMBER_ID = "session_key_member_id";
		/** node聊天推送IP地址 */
        public static final String CHAT_IP = "session_chat_ip";

	}

	/** 微信常量 */
	class Wechat {
	    
	    /** 获取access_token的url */
        public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?"
                + "grant_type=client_credential&appid=%s&secret=%s";
        
        /** 获取jsapi ticket的url */
        public static final String GET_JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";
        
		/** 临时 ACCESS_TOKEN ,后续将存入库中,定时更新 */
		public static final String ACCESS_TOKEN = "GJwb5yQ2VDkoIxvJ2LskPEPXZYq8Fanbm_hzvd5oURfYevEkwt6-ljth3rvS"
				    + "nPFEqUqTlUys5DIj3KeMwZLasyDhk5YFVYDBqwm_3PehPY4";

		/** 获取用户授权access_token的url */
		public static final String AUTH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?"
				    + "appid=%s&secret=%s&code=%s&grant_type=authorization_code";

		/** 获取关注用户的信息 */
		public static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";

		/** 微信基础授权，获取openid */
		public static final String AUTH_REDIRECT_BASE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?"
				    + "appid={app_id}&redirect_uri=http%3A%2F%2F" + App.System.SERVER_HOST
				    + "%2F" + App.System.SERVER_CONTEXT_LOADER + "%2Fwechat%2Fcallback%2F{openid_key}"
				    + "%3Fscope%3Dsnsapi_base%26redirect%3D{redirect_uri}&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";

		/** 微信高级授权，获取用户信息 */
		public static final String AUTH_REDIRECT_INFO_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?"
				    + "appid={app_id}&redirect_uri=http%3A%2F%2F" + App.System.SERVER_HOST
				    + "%2F" + App.System.SERVER_CONTEXT_LOADER + "%2Fwechat%2Fcallback%3Fscope%3Dsnsapi_userinfo%26"
				    + "redirect%3D{redirect_uri}&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		
		/** 微信通用基础授权，获取openid */
        public static final String AUTH_REDIRECT_COMMON_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                    + "appid={app_id}&redirect_uri=http%3A%2F%2F" + App.System.SERVER_HOST
                    + "%2F" + App.System.SERVER_CONTEXT_LOADER + "%2Fwechat%2Fws%2Fsdk%2F{openid_key}"
                    + "%3Fscope%3Dsnsapi_base%26redirect%3D{redirect_uri}&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";

		/** 获取微信素材资源 */
		public static final String FETCH_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";

		/** 巴康诺开放授权平台 原始ID */
        public static final String WECHAT_WSG_ID_BKN = "gh_868860c07201";
		/** 巴康诺开放授权平台 appId */
		public static final String WECHAT_APP_ID_BKN = "wx89a8d24957cf169c";
	    /** 巴康诺开放授权平台 secret */
        public static final String WECHAT_APP_SECRET_BKN = "9a8d655ef8d3ef43fa1b51a11fdfc837";
        
		/** 我道微信应用ID */
		public static final String PAY_APP_KEY_JOBWISDOM = "wx89a8d24957cf169c";
		/** 我道微信应用ID */
        public static final String PAY_APP_SCRETE_JOBWISDOM = "9a8d655ef8d3ef43fa1b51a11fdfc837";
        
		/** 我道微信支付商户号 */
		public static final String MCH_ID_JOBWISDOM = "1520155021";
		/** 我道微信支付API密钥 */
		public static final String MCH_PAY_KEY_JOBWISDOM = "123456789qwasdfghjklertyuiopzxcv";
		/** 我道微信支付API证书秘银 */
        public static final String KEY_STORE_JOBWISDOM = "PKCS12";
		/** 币种 */
		public static final String FEE_TYPE = "CNY";
		/** 签名方式 */
		public static final String SIGN_TYPE = "MD5";

	}

	/** 短信服务常量类 */
	class Sms {
		/** 我道短信应用id */
		public static final String APP_ID = "202099220000246359";
		/** 我道短信应用密钥 */
		public static final String APP_SECRET = "67ba2ad4a93c9b26d5e732e90e4a1591";
		/** 获取API 口令的接口地址(正式) */
		public static final String ACCESS_TOKEN_URL = "https://oauth.api.189.cn/emp/oauth2/v3/access_token";
		/** 发送短信的API接口地址  (正式)*/
		public static final String SEND_SMS_URL = "http://api.189.cn/v2/emp/templateSms/sendSms";
	}

}
