package vo;

import entity.Menu;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单VO
 * Created by Fuzhong.Yan on 16/10/30.
 */
public class AZ_MenuVo extends Menu implements Comparable<AZ_MenuVo>{
    /**
     * 当前节点的子节点
     */
    private  List<AZ_MenuVo> children;

    public List<AZ_MenuVo> getChildren() {
        if (CollectionUtils.isEmpty(children))
        {
            children = new ArrayList<AZ_MenuVo>();
        }
        return children;
    }
    public void setChildren(List<AZ_MenuVo> children) {
        this.children = children;
    }
    public int compareTo(AZ_MenuVo o) {
        if (this.getSort() == null && o.getSort() == null){
            return 0;
        }
        if (this.getSort() == null && o.getSort()!=null){
            return -1;
        }
        if (this.getSort() !=null && o.getSort() == null){
            return 1;
        }
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
    public  void printInfo(AZ_MenuVo vo){
        if (vo != null){
            System.out.println("id:"+vo.getId()+"   parent_id:"+vo.getParentId()+"  name:"+vo.getName());
            List<AZ_MenuVo> children_vo = vo.getChildren();
            for (AZ_MenuVo t_vo : children_vo){
                printInfo(t_vo);
            }
        }
    }
}
