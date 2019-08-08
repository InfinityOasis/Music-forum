package com.github.web.servlet;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.domain.User;
import com.github.domain.follow;
import com.github.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 进行follow操作
 * @author lzy
 */

@WebServlet("/follow")
public class Follow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("usermsg");
        if(user != null){
            follow follow = new follow();
            follow.setFollowed((String) session.getAttribute("auserid"));
            follow.setUserid(user.getUserid());
            String s = JSON.toJSONString(follow);
            System.out.println("follow表信息: " + s);
            UserServiceImpl userService = new UserServiceImpl();
            if( ! userService.isFollow(follow) ){
                //未关注，添加关注
                userService.follow(follow);
            }else{
                //已关注，取消关注
                userService.cancelFollow(follow);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
