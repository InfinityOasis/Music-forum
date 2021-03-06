package com.github.web.adminservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.service.MusicService;
import com.github.service.impl.MusicServiceImpl;
import com.github.util.MailUtil;
import com.github.util.MailUtil_musicupload;
import com.github.util.MailUtil_musicupload_fail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/pass")
public class pass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");
        String verifier = req.getParameter("verifier");
        String ispass = req.getParameter("ispass");
        String email = req.getParameter("userid");
        MusicService musicService = new MusicServiceImpl();
        if ("true".equals(ispass)) {

            Boolean pass = musicService.pass(url, verifier);
            // 返回操作结果,true代表操作成功,false代表操作失败
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("do", pass);
            if (pass){
                try {
                    MailUtil_musicupload.sendActiveMail(email);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getWriter(), map1);
        }else {
            Boolean notpass = musicService.notpass(url, verifier);
            if (notpass){
                try {
                    MailUtil_musicupload_fail.sendActiveMail(email);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("do", true);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getWriter(), map1);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
