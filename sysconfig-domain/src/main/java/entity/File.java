package entity;

import java.util.Date;

public class File {
    /**
     * 文件映射id
     */
    private Integer id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件原名
     */
    private String fileOriginalName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件的相对路径
     */
    private String filePath;

    /**
     * 业务id
     */
    private String businessID;

    /**
     * 业务类型
     */
    private Short businessType;

    /**
     * 时间
     */
    private Date time;

    /**
     * 备注
     */
    private String remark;

    /**
     * 文件映射id
     * @return id 文件映射id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 文件映射id
     * @param id 文件映射id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 文件名
     * @return name 文件名
     */
    public String getName() {
        return name;
    }

    /**
     * 文件名
     * @param name 文件名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 文件原名
     * @return fileOriginalName 文件原名
     */
    public String getFileOriginalName() {
        return fileOriginalName;
    }

    /**
     * 文件原名
     * @param fileOriginalName 文件原名
     */
    public void setFileOriginalName(String fileOriginalName) {
        this.fileOriginalName = fileOriginalName == null ? null : fileOriginalName.trim();
    }

    /**
     * 文件类型
     * @return fileType 文件类型
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 文件类型
     * @param fileType 文件类型
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * 文件的相对路径
     * @return filePath 文件的相对路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 文件的相对路径
     * @param filePath 文件的相对路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * 业务id
     * @return businessID 业务id
     */
    public String getBusinessID() {
        return businessID;
    }

    /**
     * 业务id
     * @param businessID 业务id
     */
    public void setBusinessID(String businessID) {
        this.businessID = businessID == null ? null : businessID.trim();
    }

    /**
     * 业务类型
     * @return businessType 业务类型
     */
    public Short getBusinessType() {
        return businessType;
    }

    /**
     * 业务类型
     * @param businessType 业务类型
     */
    public void setBusinessType(Short businessType) {
        this.businessType = businessType;
    }

    /**
     * 时间
     * @return time 时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 时间
     * @param time 时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}