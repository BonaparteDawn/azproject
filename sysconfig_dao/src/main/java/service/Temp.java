package service;

import bean.User;
import bean.UserExample;
import dao.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fuzhong.Yan on 16/10/29.
 */
@Service
public class Temp {
    @Autowired
    private  UserMapper userMapper;
    public  void printAll(){
        UserExample e = new UserExample();
        final List<User> users = userMapper.selectByExample(e);
        for (User temp : users){
            System.out.println(temp.getUserId());
        }
    }
}
