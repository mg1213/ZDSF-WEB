package com.ztesoft.service;

import com.ztesoft.config.Constants;
import com.ztesoft.dto.SimpleResult;
import com.ztesoft.mapper.UserMapper;
import com.ztesoft.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 技术二科 王永梅 on 2017/3/16.
 */
@Transactional
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public SimpleResult userLogin(String userName, String pwd, HttpServletRequest request) {
        SimpleResult result = new SimpleResult();
        result.setSuccess(true);
        result.setErrorCode("");
        result.setErrorMessage("");
        result.setState("0");
        User user = new User();
        user.setUserName(userName);
        user = userMapper.selectOne(user);
        if (user == null) {
            result.setErrorCode("P_LOGIN_NOSTAFF");
            result.setErrorMessage("用户不存在");
            result.setState("1");
            return result;
        } else if (!user.getPassword().equals(pwd)) {
            result.setErrorCode("P_LOGIN_PASSWORD_ERROR");
            result.setErrorMessage("密码错误");
            result.setState("1");
            return result;
        } else if (user.getStatus().equals("InActive")) {

            result.setErrorCode("P_USER_STATE_INACTIVE");
            result.setErrorMessage("用户未激活");
            result.setState("1");
            return result;
        } else {
            request.getSession().setAttribute(Constants.SESSION_NAME, user);
            return result;
        }

    }

    public String getUserRole(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute(Constants.SESSION_NAME);
        if (user != null) {
            return user.getUserRole();
        }
        return null;
    }


    public String getSessionUserName(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_NAME);
        if (user != null) {
            return user.getUserName();
        }
        return null;
    }
}
