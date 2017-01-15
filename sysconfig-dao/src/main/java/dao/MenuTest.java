package dao;

import common.framework.db.DBDao;
import entity.Menu;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fuzhong.Yan on 16/11/4.
 */
@Service
public class MenuTest implements InitializingBean {
//    @Autowired
    private DBDao dbDao;

    public DBDao getDbDao() {
        return dbDao;
    }

    public void setDbDao(DBDao dbDao) {
        this.dbDao = dbDao;
    }

    public void getAll(){

        try {
            List<Menu> a = dbDao.selectObjects("allUsers",1,10);
            for (Menu t:a){
                System.out.println(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afterPropertiesSet() throws Exception {
//        dbDao.setNamespace("menuTest");
    }
}