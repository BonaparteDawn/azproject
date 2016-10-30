package vo;

import entity.Menu;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单VO
 * Created by Fuzhong.Yan on 16/10/30.
 */
public class MenuVo extends Menu implements Comparable<MenuVo>{
    /**
     * 当前节点的子节点
     */
    private  List<MenuVo> children;

    public List<MenuVo> getChildren() {
        if (CollectionUtils.isEmpty(children))
        {
            children = new ArrayList<MenuVo>();
        }
        return children;
    }
    public void setChildren(List<MenuVo> children) {
        this.children = children;
    }
    public int compareTo(MenuVo o) {
        return this.getSort()-o.getSort();
    }

    /**
     * 打印对象本身信息
     */
    public void printInfo(){
        printInfo(this);
    }

    /**
     * 打印指定Vo信息
     * @param vo
     */
    public  void printInfo(MenuVo vo){
        if (vo != null){
            System.out.println("id:"+vo.getId()+"   parent_id:"+vo.getParentId()+"  name:"+vo.getName());
            List<MenuVo> children_vo = vo.getChildren();
            for (MenuVo t_vo : children_vo){
                printInfo(t_vo);
            }
        }
    }
}
