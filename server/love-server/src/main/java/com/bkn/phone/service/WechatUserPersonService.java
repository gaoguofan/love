package com.bkn.phone.service;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bkn.browser.config.App;
import com.bkn.browser.config.PageConfig;
import com.bkn.browser.config.RouteConfig;
import com.bkn.browser.mybatis.LoveLiaobeiAnswerMapper;
import com.bkn.browser.mybatis.LoveLiaobeiQuestionMapper;
import com.bkn.browser.mybatis.LoveUserInfoMapper;
import com.bkn.browser.utils.HttpClientUtil;
import com.bkn.system.dto.BaseDto;
import com.bkn.system.entity.LoveLiaobeiQuestion;
import com.bkn.system.entity.LoveUserInfo;
import com.bkn.system.service.RedisService;
import com.bkn.system.service.SmsService;

import net.sf.json.JSONObject;


/**
 * 移动端用户个人版面
* @author 高国藩
* @date 2017年3月16日 下午8:38:53
 */
@Service
@Transactional
public class WechatUserPersonService {

    @Autowired
    private RedisService redisService;
    
    @Autowired
    private SmsService smsService;
    
    @Autowired LoveUserInfoMapper loveUserInfoMapper;
    @Autowired LoveLiaobeiQuestionMapper liaobeiQuestionMapper;
    @Autowired LoveLiaobeiAnswerMapper loveLiaobeiAnswerMapper;
    
    
    /**
     * 注册页面
    * @author 高国藩
    * @date 2019年1月21日 上午10:39:39
    * @param openId
    * @return
     */
    public ModelAndView viewUserLoginPage(String openId) {
        LoveUserInfo selectByWechatId = loveUserInfoMapper.selectByWechatId(openId);
        if (selectByWechatId != null) {
            return new ModelAndView("redirect:/" + RouteConfig.WechatUser.WECHAT_USER_PERSON);
        } else {
            return new ModelAndView(PageConfig.Wechat.LOGIN);
        }
    }

    
    

    /**
     * 获取验证码
    * @author 高国藩
    * @date 2017年3月23日 下午3:31:47
    * @param phone  phone
    * @return       BaseDto
     */
    public BaseDto getVerifyCodeAction(String phone) {
        String code = RandomStringUtils.randomNumeric(6);
        redisService.set(App.Redis.PHONE_VERIFY_CODE_KEY_PRE + phone, code);
        redisService.expire(App.Redis.PHONE_VERIFY_CODE_KEY_PRE + phone, 180);
        if(smsService.sendCheckMsgAlibaMessage(phone, code)) {
            return new BaseDto(App.System.API_RESULT_CODE_FOR_SUCCEES, "验证码发送成功");
        }
        return new BaseDto(App.System.API_RESULT_CODE_FOR_FAIL, "短信发送不成功");
    }

   
    /**
     * 提取中文汉字
    * @author 高国藩
    * @date 2017年4月20日 下午1:44:44
    * @param paramValue 预提取中文汉字
    * @return           提取结果
     */
    public static String getChinese(String paramValue) {
        String regex = "([\u4e00-\u9fa5]+)";
        String str = "";
        Matcher matcher = Pattern.compile(regex).matcher(paramValue);
        while (matcher.find()) {
            str+= matcher.group(0);
        }
        return str;
    }


    /**
     * 搜索聊呗信息
    * @author 高国藩
    * @date 2019年6月17日 下午5:27:13
    * @param key
    * @return
     */
    public ModelAndView userQueryKey(String key) {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/话术搜索");
        List<LoveLiaobeiQuestion> liaobeiQuestions =  liaobeiQuestionMapper.selectByKeyAndPageInfo(key);
        modelAndView.addObject("liaobeiQuestions", liaobeiQuestions);
        System.out.println(net.sf.json.JSONArray.fromObject(liaobeiQuestions));
        return modelAndView;
    }


    /**
     * 实现注册操作
    * @author 高国藩
    * @date 2019年6月17日 下午8:04:40
    * @param openId
    * @param accessToken
    * @param phone
    * @param code
    * @param request
    * @return
     */
    public BaseDto viewUserLoginAction(String openId, String accessToken,
            String phone, String code, HttpServletRequest request) {
        if(code.equals(redisService.get(App.Redis.PHONE_VERIFY_CODE_KEY_PRE + phone))) {
            String userInfoRes = HttpClientUtil.sendGetReq(String.format(App.Wechat.GET_USER_INFO_URL, new Object[] {accessToken, openId}), "utf-8");
            JSONObject userInfoJson = JSONObject.fromObject(userInfoRes);
            String sex = userInfoJson.getString("sex");
            String userName = userInfoJson.getString("nickname");
            userName = getChinese(userName);
            String imagePath = userInfoJson.getString("headimgurl");
            LoveUserInfo bknNewMemberInfo = new LoveUserInfo();
            bknNewMemberInfo.setPhone(phone);
            bknNewMemberInfo.setWechatOpenId(openId);
            bknNewMemberInfo.setUserName(userName);
            bknNewMemberInfo.setImagePath(imagePath);
            bknNewMemberInfo.setSex(sex.equals("1") ? "男" : "女");
            loveUserInfoMapper.insertSelective(bknNewMemberInfo);
            return new BaseDto(App.System.API_RESULT_CODE_FOR_SUCCEES, "注册成功");
        }
        return new BaseDto(App.System.API_RESULT_CODE_FOR_FAIL, "验证码错误");
    }

    
}
