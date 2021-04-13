package example.service;

import example.bean.Admin;
import example.mapper.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 登录处理服务处
 */
@Service
@Transactional
public class LoginService {

    @Autowired
    Login login;

    public Admin login(Admin admin) {
        return login.login(admin);
    }
}
