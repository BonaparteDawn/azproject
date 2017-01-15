package common.framework.db;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 *  MySQL数据库访问DAO
 * Created by Fuzhong.Yan on 16/11/4.
 */
@Service
public class MySqlDBDao  extends DBDao{
    @Autowired
    @Qualifier("sqlSessionTemplateBatch")
    private SqlSessionTemplate sqlSessionTemplateBatch;

    @Autowired
    @Qualifier("sqlSessionTemplateSimple")
    private  SqlSessionTemplate sqlSessionTemplateSimple;

    public MySqlDBDao(){
        super();
    }

    public <T> List<T> selectObjects(String statement) throws Exception {
        if (statement == null || statement.equals("")){
            return null;
        }
        return sqlSessionTemplateSimple.selectList(getNamespace()+"."+statement);
    }

    /**
     * 查询指定页的一组对象
     *
     * @param statement
     * @param pageNum
     * @param pageSize  @return
     * @throws Exception
     */
    public <T> Page<T> selectObjects(String statement, Integer pageNum, Integer pageSize) throws Exception {
        if (statement == null || "".equals(statement)){
            return null;
        }
        if (pageNum == null || pageNum <=0){
            pageNum = 1;
        }
        if (pageSize == null || pageSize <0){
            pageSize = 10;
        }
        PageHelper.startPage(pageNum,pageSize);
        return (Page<T>) sqlSessionTemplateSimple.selectList(getNamespace()+"."+statement);
    }

    public <T> List<T> selectObjects(String statement, Object object) throws Exception {
        if (statement == null || statement.equals("")){
            return null;
        }
        return sqlSessionTemplateSimple.selectList(getNamespace()+"."+statement,object);
    }

    /**
     * 查询指定页的一组对象
     *
     * @param statement
     * @param object
     * @param pageNum
     * @param pageSize  @return
     * @throws Exception
     */
    public <T> Page<T> selectObjects(String statement, Object object, Integer pageNum, Integer pageSize) throws Exception {
        if (statement == null || "".equals(statement)){
            return null;
        }
        if (pageNum == null || pageNum <=0){
            pageNum = 1;
        }
        if (pageSize == null || pageSize <0){
            pageSize = 10;
        }
        PageHelper.startPage(pageNum,pageSize);
        return (Page<T>) sqlSessionTemplateSimple.selectList(getNamespace()+"."+statement,object);
    }

    public <T> T selectObject(String statement) throws Exception {
        if (statement == null || statement.equals("")){
            return null;
        }
        return sqlSessionTemplateSimple.selectOne(getNamespace()+"."+statement);
    }

    public <T> T selectObject(String statement, Object object) throws Exception {
        if (statement == null || statement.equals("")){
            return null;
        }
        return sqlSessionTemplateSimple.selectOne(getNamespace()+"."+statement,object);
    }

    public boolean updateObjects(String statement) throws Exception {
        if (statement == null || statement.equals("")){
            return false;
        }
        boolean u_rs = false;
        int rs = sqlSessionTemplateBatch.update(getNamespace()+"."+statement);
        if (0 < rs){
            u_rs = true;
        }
        return u_rs;
    }

    public boolean updateObjects(String statement, Object object) throws Exception {
        if (statement == null || statement.equals("")){
            return false;
        }
        boolean u_rs = false;
        int rs = sqlSessionTemplateBatch.update(getNamespace()+"."+statement,object);
        if (0 < rs){
            u_rs = true;
        }
        return u_rs;
    }

    public boolean updateObject(String statement) throws Exception {
        if (statement == null || statement.equals("")){
            return false;
        }
        boolean u_r = false;
        int r = sqlSessionTemplateSimple.update(getNamespace()+"."+statement);
        if ( r > 0 ){
            u_r = true;
        }
        return u_r;
    }

    public boolean updateObject(String statement, Object object) throws Exception {
        if (statement == null || statement.equals("")){
            return false;
        }
        boolean u_r = false;
        int r = sqlSessionTemplateSimple.update(getNamespace()+"."+statement,object);
        if (r>0){
            u_r = true;
        }
        return u_r;
    }

    public boolean deleteObject(String statement) throws Exception {
        return  deleteObjects(statement);
    }

    public boolean deleteObject(String statement, Object object) throws Exception {
        return  deleteObjects(statement, object);
    }
    public boolean deleteObjects(String statement) throws Exception {
        if (statement == null || statement.equals("")){
            return false;
        }
        boolean u_r = false;
        int r = sqlSessionTemplateSimple.delete(getNamespace()+"."+statement);
        if (r>0){
            u_r = true;
        }
        return u_r;
    }

    public boolean deleteObjects(String statement, Object object) throws Exception {
        if (statement == null || statement.equals("")){
            return false;
        }
        boolean u_r = false;
        int r = sqlSessionTemplateSimple.delete(getNamespace()+"."+statement,object);
        if (r>0){
            u_r = true;
        }
        return u_r;
    }


    public boolean addObject(String statement) throws Exception {
        return  addObjects(statement);
    }

    public boolean addObject(String statement, Object object) throws Exception {
        return  addObjects(statement, object);
    }

    public boolean addObjects(String statement) throws Exception {
        if (statement == null || statement.equals("")){
            return false;
        }
        boolean u_r = false;
        int r = sqlSessionTemplateSimple.insert(getNamespace()+"."+statement);
        if (r>0){
            u_r = true;
        }
        return u_r;
    }

    public boolean addObjects(String statement, Object object) throws Exception {
        if (statement == null || statement.equals("")){
            return false;
        }
        boolean u_r = false;
        int r = sqlSessionTemplateSimple.insert(getNamespace()+"."+statement,object);
        if (r>0){
            u_r = true;
        }
        return u_r;
    }
}
