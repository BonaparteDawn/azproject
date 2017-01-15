package entity;

import java.util.Date;

public class Role {
    /**
     * 角色id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色容量（0、表示无限制）
     */
    private Integer size;

    /**
     * 开始时间
     */
    private Date start_time;

    /**
     * 结束时间
     */
    private Date end_time;

    /**
     * 锁定角色（1、是，0、否）
     */
    private Integer is_lock;

    /**
     * 角色排序号
     */
    private Integer sort;

    /**
     * 角色备注
     */
    private String remark;

    /**
     * 角色id
     * @return id 角色id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 角色id
     * @param id 角色id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 角色名
     * @return name 角色名
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名
     * @param name 角色名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 角色容量（0、表示无限制）
     * @return size 角色容量（0、表示无限制）
     */
    public Integer getSize() {
        return size;
    }

    /**
     * 角色容量（0、表示无限制）
     * @param size 角色容量（0、表示无限制）
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * 开始时间
     * @return start_time 开始时间
     */
    public Date getStart_time() {
        return start_time;
    }

    /**
     * 开始时间
     * @param start_time 开始时间
     */
    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    /**
     * 结束时间
     * @return end_time 结束时间
     */
    public Date getEnd_time() {
        return end_time;
    }

    /**
     * 结束时间
     * @param end_time 结束时间
     */
    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    /**
     * 锁定角色（1、是，0、否）
     * @return is_lock 锁定角色（1、是，0、否）
     */
    public Integer getIs_lock() {
        return is_lock;
    }

    /**
     * 锁定角色（1、是，0、否）
     * @param is_lock 锁定角色（1、是，0、否）
     */
    public void setIs_lock(Integer is_lock) {
        this.is_lock = is_lock;
    }

    /**
     * 角色排序号
     * @return sort 角色排序号
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 角色排序号
     * @param sort 角色排序号
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 角色备注
     * @return remark 角色备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 角色备注
     * @param remark 角色备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}