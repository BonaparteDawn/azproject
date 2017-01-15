package sysConfig;

import common.framework.exception.AZ_BusinessException;
import entity.File;
import vo.AZ_File;
import vo.AZ_FileBytes;
import vo.AZ_FileIn;
import vo.AZ_FileOut;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Fuzhong.Yan on 16/12/12.
 */
public interface AZ_FileSystemApi {
    /**
     * 写文件流
     * @param id
     * @param outputStream
     * @return
     * @throws AZ_BusinessException
     */
    public AZ_FileOut writeFileOut(Integer id, OutputStream outputStream) throws AZ_BusinessException;

    /**
     * 获取文件
     * @param businessID
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    public List<AZ_FileBytes> getFileBytes(String businessID, Short businessType) throws AZ_BusinessException, IOException;


    /**
     * 获取文件
     * @return
     * @throws AZ_BusinessException
     */
    public List<AZ_File> getFiles() throws AZ_BusinessException;


    /**
     * 获取文件
     * @param businessID
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    public List<AZ_File> getFile(String businessID, Short businessType) throws AZ_BusinessException;

    /**
     * 获取文件
     * @param businessID
     * @return
     * @throws AZ_BusinessException
     */
    public List<AZ_File> getFileByBusinessID(String businessID) throws AZ_BusinessException;

    /**
     * 获取文件
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    public List<AZ_File> getFileByBusinessType(Short businessType) throws AZ_BusinessException;

    /**
     * 获取文件
     * @param id
     * @return
     * @throws AZ_BusinessException
     */
    public AZ_File getFileByID(Integer id) throws AZ_BusinessException;
    /**
     * 上传数据
     * @param files
     * @return
     * @throws AZ_BusinessException
     */
    public List<AZ_File> uploadFileIn(List<AZ_FileIn> files) throws AZ_BusinessException, IOException;

    /**
     * 上传数据
     * @param files
     * @return
     * @throws AZ_BusinessException
     */
    public List<AZ_File> uploadFileBytes(List<AZ_FileBytes> files) throws AZ_BusinessException;

    /**
     * 上传输入流文件数据
     * @param file
     * @return
     * @throws AZ_BusinessException
     */
    public AZ_File uploadFile(AZ_FileIn file) throws AZ_BusinessException;

    /**
     * 上传文件数据
     * @param file
     * @return
     * @throws AZ_BusinessException
     */
    public AZ_File uploadFileBytes(AZ_FileBytes file) throws AZ_BusinessException;

    /**
     * 删除数据库文件映射
     * @param businessID
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    public boolean deleteFile(String businessID, Short businessType) throws AZ_BusinessException;

    /**
     * 删除数据库文件映射
     * @param businessID
     * @return
     * @throws AZ_BusinessException
     */
    public boolean deleteFileByBusinessID(String businessID) throws AZ_BusinessException;

    /**
     * 删除数据库文件映射
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    public boolean deleteFileByBusinessType(Short businessType) throws AZ_BusinessException;

    /**
     * 删除数据库文件映射
     * @return
     * @throws AZ_BusinessException
     */
    public boolean deleteAllFile() throws AZ_BusinessException;


    /**
     * 清空指定文件
     * @param businessID
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    public boolean clearFile(String businessID, Short businessType) throws AZ_BusinessException;

    /**
     * 清空指定类型文件
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    public boolean clearFileByBusinessType(Short businessType) throws AZ_BusinessException;

    /**
     * 清空指定类型文件
     * @param businessID
     * @businessID
     * @throws AZ_BusinessException
     */
    public boolean clearFileByBusinessID(String businessID) throws AZ_BusinessException;
    /**
     * 清空所有文件
     * @return
     * @throws AZ_BusinessException
     */
    public boolean clearAllFile() throws AZ_BusinessException;

    /**
     * 添加文件映射
     * @param file
     * @return
     * @throws AZ_BusinessException
     */
    public AZ_File add(File file) throws AZ_BusinessException;

    /**
     * 文件前缀
     * @return
     * @throws AZ_BusinessException
     */
    public String getFilePathPrefix() throws AZ_BusinessException;

    /**
     * 获取文件中指定位置的数据
     * @param id
     * @param skip_size
     * @param block_size
     * @return
     */
    public byte[] copy2Bytes(Integer id,long skip_size,int block_size) throws AZ_BusinessException, IOException;
}
