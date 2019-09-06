package com.bkn.browser.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bkn.system.dto.ArticleDto;
import com.bkn.system.dto.NewsMessageDto;
import com.bkn.system.dto.TextMessageDto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 消息工具类
* @author 李志伟
* @date 2015年8月6日 上午9:38:53 
*
 */
public class MessageUtil {
    /**
     * 文本回复
     */
    public static SortedMap<String, String> autoMessageMap = new TreeMap<>(new Comparator<String>() { 
            @Override
            public int compare(String t1, String t2) {
            return t1.compareTo(t2);
        }
    });
    static {
        autoMessageMap.put("1", "门店会员手册" + System.getProperty("line.separator", "\n") 
                + "①  会员注册：点击右下角“会员中心”绑定↘" + System.getProperty("line.separator", "\n") 
                + "②  会员信息查询：登录右下角会员中心查看↘" + System.getProperty("line.separator", "\n") 
                + "     会员中心信息栏：订单、预约、疗程、积分、代金券、储值卡、个人设置" + System.getProperty("line.separator", "\n")
                + "③  会员解绑：会员中心—个人设置—解除关联");
        
        autoMessageMap.put("2", "股东融资分红：<a href=\"http://a.eqxiu.com/s/otIezGcV\">点我查看</a>");
        
        autoMessageMap.put("3", "门店员工手册：" + System.getProperty("line.separator", "\n") 
                + "①  员工登录：点击右下角“员工登录”↘，初次" + System.getProperty("line.separator", "\n")
                + "     登录默认密码123456，登陆后在“个人设置”中进行密码更改" + System.getProperty("line.separator", "\n")
                + "②  员工模块：接待大厅、服务、排行、我的" + System.getProperty("line.separator", "\n")
                + "③  个人信息更改：我的—个人设置");
        
        autoMessageMap.put("4", "敬请期待...");
        
        autoMessageMap.put("5", "聚合支付简介：<a href=\"http://a.eqxiu.com/s/otIezGcV\">点我查看</a>");
        
        autoMessageMap.put("6", "中邦我道简介：<a href=\"http://a.eqxiu.com/s/otIezGcV\">点我查看</a>");
    }
    
    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";
    
    /**
     * 获取用户文本信息
     */
    public static final String CONTENT = "Content";

    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";
    
    /**
     * 请求消息类型：声音
     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
    
    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";
    /**
     * 图文消息发送状态
     */
    public static final String EVENT_ITEMS_STATUS = "MASSSENDJOBFINISH";
    
    /**
     * 二维码票据扫描事件(已关注进入)
     */
    public static final String EVENT_SCAN = "SCAN";
    
    /**
     * 事件请求者
     */
    public static final String FROM_USER_NAME = "FromUserName";
    
    /**
     * 公众号原始ID
     */
    public static final String TO_USER_NAME = "ToUserName";
    
    /**
     * 消息类型
     */
    public static final String MSG_TYPE = "MsgType";
    
    /**
     * 消息事件类型
     */
    public static final String EVENT = "Event";
    
    /**
     * 票据二维码扫描进入的值
     */
    public static final String EVENT_KEY = "EventKey";
    
    
    /**
     * 票据二维码扫描进入的ticket值
     */
    public static final String TICKET = "Ticket";
    
    /**
     * 首次关注，优惠提醒
     */
    public static final String FIRST_SUB_TEXT = "";
    
    /**
     * 重新关注，提醒话语
     */
    public static final String AGAIN_SUB_TEXT = "Hi, 期盼好久, 欢迎再回来";
    
    /**
     * 股东下线，提醒话语
     */
    public static final String PARNTEN_SUB_TEXT = "恭喜您成为【%s】的人脉";
    
    /**
     * 已是会员，收到别人的分享，提醒话语
     */
    public static final String MEMBER_SHARE_TEXT = "开发调试中";
    
    /**
     * 还不是会员，收到别人的分享，提醒话语
     */
    public static final String NO_MEMBER_SHARE_TEXT = "开发调试中";

    
    /**
     * 用户对话，提醒话语
     */
    public static final String NOTICTY_TEXT = "开发调试中";

    /**
     * 解析微信发来的请求（XML）
     * @param request request
     * @return Map<String, String>
     * @throws Exception 异常
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
    }

    /**
     * 文本消息对象转换成xml
     * alias 起别名,如果没有,根节点将面为com.pacage.textMessage的形式
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToXml(TextMessageDto textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 图文消息对象转换成xml
     * 
     * @param newsMessage 图文消息对象
     * @return xml
     */
    public static String newsMessageToXml(NewsMessageDto newsMessage) {
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new ArticleDto().getClass());
        return xstream.toXML(newsMessage);
    }

    /**
     * 扩展xstream，使其支持CDATA块
     * 此处做了CreateTime和ArticleCount字段做特殊处理
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                /** 对所有xml节点的转换都增加CDATA标记*/
                boolean cdata = true;
                String createTime = "";
                String articleCount = "ArticleCount";

                public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz) {
                    if (name != null && name.equals("CreateTime")) {
                        createTime = "CreateTime";
                    }
                    else {
                        createTime = name;
                    }
                    if (name != null && name.equals("ArticleCount")) {
                        articleCount = "ArticleCount";
                    }
                    else {
                        articleCount = name;
                    }
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata && !createTime.equals("CreateTime") && !articleCount.equals("ArticleCount")) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    }
                    else {
                        writer.write(text);
                    }
                }
            };
        }
    });
    
    /**
     * 获得当前月--开始日期
    * @author 王大爷
    * @date 2015年8月19日 下午7:28:53
    * @return String
     */
    public static String getMinMonthDate() {   
        Calendar calendar = Calendar.getInstance();   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); 
        return dateFormat.format(calendar.getTime());
    }


    /**
     * 获得当前月--结束日期
    * @author 李志伟
    * @date 2015年8月19日 下午7:33:09
    * @return String
     */
    public static String getMaxMonthDate(){   
        Calendar calendar = Calendar.getInstance();   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }
    
    /**
     * javaBean转Map
    * @author 李志伟
    * @date 2015年12月11日 下午2:21:51
    * @param obj  与转换对象
    * @return     map
     */
    public static Map<String, Object> transBean2Map(Object obj) {
        if (obj == null){
            return null;
        }        
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.put(key, value);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
