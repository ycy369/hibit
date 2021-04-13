package example.controller;

import example.bean.Admin;
import example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制类
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/loginCtl")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    /**
     * 登录验证
     */
    @RequestMapping("/login")
    public Map<String, Object> login(Admin admin, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            admin = loginService.login(admin);
            session.setAttribute("admin", admin);//用户信息存储到session中,这样客户端每次不需要将用户信息向后端发送
            if (admin != null) {
                map.put("admin", admin);//将用户信息包装到map中向前端返回
                map.put("code", 0);//code名字可以自己定义,表示后端的处理状态
                map.put("JSESSIONID", session.getId());//把服务器端生成的sessionid响应个前端
            } else {
                map.put("code", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 2);
        }
        return map;//map封装后端要提供给前端的所有信息  自动将map转为json, springBoot中自带json转换包 jackson
    }

    /**
     * 安全退出
     */
    @RequestMapping("/logOut")
    public int logOut(HttpSession session) {

        try {
            session.invalidate();
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
}
