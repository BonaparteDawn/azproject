package entity;

public class Menu {
    /**
     * 菜单id号
     */
    private Integer id;

    /**
     * 菜单父id
     */
    private Integer parent_id;

    /**
     * 菜单描述
     */
    private String name;

    /**
     * 菜单url地址
     */
    private String url;

    /**
     * 菜单icon
     */
    private String icon;

    /**
     * 菜单打开状态（1、打开，0、关闭）
     */
    private Integer is_open;

    /**
     * 排序位置
     */
    private Integer sort;

    /**
     * 菜单项备注
     */
    private String remark;

    /**
     * 菜单id号
     * @return id 菜单id号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 菜单id号
     * @param id 菜单id号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 菜单父id
     * @return parent_id 菜单父id
     */
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * 菜单父id
     * @param parent_id 菜单父id
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * 菜单描述
     * @return name 菜单描述
     */
    public String getName() {
        return name;
    }

    /**
     * 菜单描述
     * @param name 菜单描述
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 菜单url地址
     * @return url 菜单url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 菜单url地址
     * @param url 菜单url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 菜单icon
     * @return icon 菜单icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 菜单icon
     * @param icon 菜单icon
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 菜单打开状态（1、打开，0、关闭）
     * @return is_open 菜单打开状态（1、打开，0、关闭）
     */
    public Integer getIs_open() {
        return is_open;
    }

    /**
     * 菜单打开状态（1、打开，0、关闭）
     * @param is_open 菜单打开状态（1、打开，0、关闭）
     */
    public void setIs_open(Integer is_open) {
        this.is_open = is_open;
    }

    /**
     * 排序位置
     * @return sort 排序位置
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序位置
     * @param sort 排序位置
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 菜单项备注
     * @return remark 菜单项备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 菜单项备注
     * @param remark 菜单项备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}