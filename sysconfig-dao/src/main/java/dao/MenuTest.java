package dao;

import common.framework.db.DBDao;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fuzhong.Yan on 16/11/4.
 */
@Service
public class MenuTest implements InitializingBean {
    @Autowired
    private DBDao dbDao;

    public void getAll(){

        try {
            List<Object> a = dbDao.selectObjects("allUsers");
            for (Object t:a){
                System.out.println(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afterPropertiesSet() throws Exception {
        dbDao.setNamespace("menuTest");
    }
}