package sysConfig;

import common.framework.annotation.AZ_LogMethod;
import common.framework.exception.AZ_BusinessException;
import common.framework.service.AZ_ENV;
import common.framework.util.*;
import constant.AZ_Constant;
import entity.File;
import entity.FileExample;
import enums.AZ_LogTime;
import enums.AZ_LogType;
import fileapi.AZ_FileApi;
import mapper.FileMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vo.AZ_File;
import vo.AZ_FileBytes;
import vo.AZ_FileIn;
import vo.AZ_FileOut;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Fuzhong.Yan on 16/12/13.
 */
@Service
public class AZ_FileSystemService implements AZ_FileSystemApi,InitializingBean{
    @Autowired
    private AZ_FileApi azFileApi;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private AZ_ENV azEnv;
    /**
     * 数据流块大小
     */
    private int block_size = 0;
    /**
     * 写文件流
     * @param id
     * @param outputStream
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "根据文件ID找到文件,然后将数据写入输出流",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public AZ_FileOut writeFileOut(Integer id, OutputStream outputStream) throws AZ_BusinessException {
        if (ObjectUtils.isEmpty(id)){
            throw new AZ_BusinessException("COM_FILE_E_01","文件ID号为空");
        }
        if (ObjectUtils.isEmpty(outputStream)){
            throw new AZ_BusinessException("COM_FILE_E_02","输出数据流为空");
        }
        AZ_FileOut res = null;
        AZ_File file = getFileByID(id);
        if (ObjectUtils.isNotEmpty(file)){
            try {
                boolean u = false;
                long skip = 0;
                byte[] block_bytes = null;
                while ((block_bytes = azFileApi.readBytes(file.getFilePath(),skip,block_size))!=null){
                    if (block_bytes == null){
                        u = true;
                        break;
                    }
                    skip += block_bytes.length;
                    outputStream.write(block_bytes);
                    outputStream.flush();
                }
                if (u){
                    res = new AZ_FileOut();
                    BeanUtils.copyProperties(file,res);
                    res.setOutputStream(outputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * 获取文件
     *
     * @param businessID
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "获取文件信息",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public List<AZ_FileBytes> getFileBytes(String businessID, Short businessType) throws AZ_BusinessException, IOException {
        if (ObjectUtils.isEmpty(businessID)){
            throw new AZ_BusinessException("COM_FILE_E_03","文件业务ID为空");
        }
        if (ObjectUtils.isEmpty(businessType)){
            throw new AZ_BusinessException("COM_FILE_E_04","文件业务类型为空");
        }
        List<AZ_File> files = getFile(businessID, businessType);
        List<AZ_FileBytes> res = new ArrayList<AZ_FileBytes>();
        if (ListUtils.isNotEmpty(files)){
            for (AZ_File file:files){
                byte[] bytes = azFileApi.readBytesByFileName(file.getFilePath());
                if (ObjectUtils.isNotEmpty(bytes)){
                    AZ_FileBytes vo = new AZ_FileBytes();
                    BeanUtils.copyProperties(file,vo);
                    vo.setBytes(bytes);
                    res.add(vo);
                }
            }
        }
        return res;
    }

    /**
     * 获取文件
     *
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "获取所有文件信息",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public List<AZ_File> getFiles() throws AZ_BusinessException {
        FileExample e = new FileExample();
        FileExample.Criteria ct = e.createCriteria();
        List<File> files= fileMapper.selectByExample(e);
        List<AZ_File> res = new ArrayList<AZ_File>();
        if (ListUtils.isNotEmpty(files)){
            String filePathPrefix = getFilePathPrefix();
            for (File file:files){
                AZ_File vo = new AZ_File();
                BeanUtils.copyProperties(file,vo);
                if (StringUtils.isNotEmpty(filePathPrefix)){
                    vo.setFilePathPrefix(filePathPrefix);
                    if (StringUtils.isNotEmpty(file.getFilePath())){
                        vo.setFullFilePath(filePathPrefix+file.getFilePath());
                    }
                }
                res.add(vo);
            }
        }
        return  res;
    }

    /**
     * 获取文件
     *
     * @param businessID
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "获取文件信息",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public List<AZ_File> getFile(String businessID, Short businessType) throws AZ_BusinessException {
        if (ObjectUtils.isEmpty(businessID)){
            throw new AZ_BusinessException("COM_FILE_E_03","文件业务ID为空");
        }
        if (ObjectUtils.isEmpty(businessType)){
            throw new AZ_BusinessException("COM_FILE_E_04","文件业务类型为空");
        }
        FileExample e = new FileExample();
        FileExample.Criteria ct = e.createCriteria();
        ct.andBusinessIDEqualTo(businessID);
        ct.andBusinessTypeEqualTo(businessType);
        List<File> files= fileMapper.selectByExample(e);
        List<AZ_File> res = new ArrayList<AZ_File>();
        if (ListUtils.isNotEmpty(files)){
            String filePathPrefix = getFilePathPrefix();
            for (File file:files){
                AZ_File vo = new AZ_File();
                BeanUtils.copyProperties(file,vo);
                if (StringUtils.isNotEmpty(filePathPrefix)){
                    vo.setFilePathPrefix(filePathPrefix);
                    if (StringUtils.isNotEmpty(file.getFilePath())){
                        vo.setFullFilePath(filePathPrefix+file.getFilePath());
                    }
                }
                res.add(vo);
            }
        }
        return  res;
    }

    /**
     * 获取文件
     *
     * @param businessID
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "获取文件信息",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public List<AZ_File> getFileByBusinessID(String businessID) throws AZ_BusinessException {
        if (ObjectUtils.isEmpty(businessID)){
            throw new AZ_BusinessException("COM_FILE_E_03","文件业务ID为空");
        }
        FileExample e = new FileExample();
        FileExample.Criteria ct = e.createCriteria();
        ct.andBusinessIDEqualTo(businessID);
        List<File> files= fileMapper.selectByExample(e);
        List<AZ_File> res = new ArrayList<AZ_File>();
        if (ListUtils.isNotEmpty(files)){
            String filePathPrefix = getFilePathPrefix();
            for (File file:files){
                AZ_File vo = new AZ_File();
                BeanUtils.copyProperties(file,vo);
                if (StringUtils.isNotEmpty(filePathPrefix)){
                    vo.setFilePathPrefix(filePathPrefix);
                    if (StringUtils.isNotEmpty(file.getFilePath())){
                        vo.setFullFilePath(filePathPrefix+file.getFilePath());
                    }
                }
                res.add(vo);
            }
        }
        return  res;
    }

    /**
     * 获取文件
     *
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "获取文件信息",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public List<AZ_File> getFileByBusinessType(Short businessType) throws AZ_BusinessException {
        if (ObjectUtils.isEmpty(businessType)){
            throw new AZ_BusinessException("COM_FILE_E_04","文件业务类型为空");
        }
        FileExample e = new FileExample();
        FileExample.Criteria ct = e.createCriteria();
        ct.andBusinessTypeEqualTo(businessType);
        List<File> files= fileMapper.selectByExample(e);
        List<AZ_File> res = new ArrayList<AZ_File>();
        if (ListUtils.isNotEmpty(files)){
            String filePathPrefix = getFilePathPrefix();
            for (File file:files){
                AZ_File vo = new AZ_File();
                BeanUtils.copyProperties(file,vo);
                if (StringUtils.isNotEmpty(filePathPrefix)){
                    vo.setFilePathPrefix(filePathPrefix);
                    if (StringUtils.isNotEmpty(file.getFilePath())){
                        vo.setFullFilePath(filePathPrefix+file.getFilePath());
                    }
                }
                res.add(vo);
            }
        }
        return  res;
    }

    /**
     * 获取文件
     *
     * @param id
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "获取文件信息",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public AZ_File getFileByID(Integer id) throws AZ_BusinessException {
        AZ_File res = null;
        if (ObjectUtils.isEmpty(id)){
            throw new AZ_BusinessException("COM_FILE_E_01","文件ID号为空");
        }
        File file = fileMapper.selectByPrimaryKey(id);
        if (ObjectUtils.isNotEmpty(file)){
            res = new AZ_File();
            BeanUtils.copyProperties(file,res);
            String filePathPrefix = getFilePathPrefix();
            if (StringUtils.isNotEmpty(filePathPrefix)){
                res.setFilePathPrefix(filePathPrefix);
                if (StringUtils.isNotEmpty(res.getFilePath())){
                    res.setFullFilePath(filePathPrefix+res.getFilePath());
                }
            }
        }
        return res;
    }

    /**
     * 上传数据
     *
     * @param files
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "上传文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    @Transactional(rollbackFor = Exception.class)
    public List<AZ_File> uploadFileIn(List<AZ_FileIn> files) throws AZ_BusinessException, IOException {
        if (ListUtils.isEmpty(files)){
            throw new AZ_BusinessException("COM_FILE_E_05","输入流文件类型数组为空");
        }
        for (AZ_FileIn in:files){
            if (ObjectUtils.isEmpty(in.getBusinessID())){
                throw new AZ_BusinessException("COM_FILE_E_03","文件业务ID为空");
            }
            if (ObjectUtils.isEmpty(in.getBusinessType())){
                throw new AZ_BusinessException("COM_FILE_E_04","文件业务类型为空");
            }
            if (ObjectUtils.isEmpty(in.getInputStream())){
                throw new AZ_BusinessException("COM_FILE_E_06","文件输入流为空");
            }
        }
        List<AZ_File> res = new ArrayList<AZ_File>();
        for (AZ_FileIn in:files){
            in.setFilePath(this.productFilePath(in));
            azFileApi.deleteFile(in.getFilePath());
            while (true){
                InputStream inputStream = IOUtils.copy(in.getInputStream(),0,block_size,true);
                if (ObjectUtils.isEmpty(inputStream)){
                    break;
                }
                azFileApi.appendInputStream(in.getFilePath(),inputStream);
                inputStream.close();
            }
            in.setTime(new Date());
            AZ_File add_temp = this.add(in);
            if (ObjectUtils.isNotEmpty(add_temp)){
                res.add(add_temp);
            }
        }
        return res;
    }

    /**
     * 上传数据
     *
     * @param files
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "上传文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    @Transactional(rollbackFor = Exception.class)
    public List<AZ_File> uploadFileBytes(List<AZ_FileBytes> files) throws AZ_BusinessException {
        if (ListUtils.isEmpty(files)){
            throw new AZ_BusinessException("COM_FILE_E_07","字节文件类型数组为空");
        }
        for (AZ_FileBytes bytes:files){
            if (ObjectUtils.isEmpty(bytes.getBusinessID())){
                throw new AZ_BusinessException("COM_FILE_E_03","文件业务ID为空");
            }
            if (ObjectUtils.isEmpty(bytes.getBusinessType())){
                throw new AZ_BusinessException("COM_FILE_E_04","文件业务类型为空");
            }
            if (ObjectUtils.isEmpty(bytes.getBytes())){
                throw new AZ_BusinessException("COM_FILE_E_08","文件输入流为空");
            }
        }
        for(AZ_FileBytes vo:files){
            deleteFile(vo.getBusinessID(),vo.getBusinessType());
        }
        List<AZ_File> res = new ArrayList<AZ_File>();
        for(AZ_FileBytes vo:files){
            vo.setFilePath(this.productFilePath(vo));
            try {
                boolean u = false;
                byte[] temp_1 = null;
                ByteArrayInputStream inputStream = new ByteArrayInputStream(vo.getBytes());
                azFileApi.deleteFile(vo.getFilePath());
                while (( temp_1 = IOUtils.copy2Bytes(inputStream,0,block_size,true))!=null){
                    azFileApi.appendBytes(vo.getFilePath(),temp_1);
                }
                if (temp_1 == null){
                    u = true;
                }
                inputStream.close();
                if (u == true){
                    vo.setTime(new Date());
                    AZ_File temp =  this.add(vo);
                    if (ObjectUtils.isNotEmpty(temp)){
                        res.add(temp);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * 上传输入流文件数据
     *
     * @param file
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "上传文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public AZ_File uploadFile(AZ_FileIn file) throws AZ_BusinessException {
        if (ObjectUtils.isEmpty(file)){
            throw new AZ_BusinessException("COM_FILE_E_09","输入流文件类型为空");
        }
        if (ObjectUtils.isEmpty(file.getBusinessID())){
            throw new AZ_BusinessException("COM_FILE_E_03","文件业务ID为空");
        }
        if (ObjectUtils.isEmpty(file.getBusinessType())){
            throw new AZ_BusinessException("COM_FILE_E_04","文件业务类型为空");
        }
        List<AZ_File> file_temp = getFile(file.getBusinessID(), file.getBusinessType());
        if (ListUtils.isNotEmpty(file_temp)){
            this.deleteFile(file.getBusinessID(),file.getBusinessType());
        }
        file.setFilePath(this.productFilePath(file));
        AZ_File res = null;
        try {
            boolean u = false;
            while (true){
                InputStream temp = IOUtils.copy(file.getInputStream(),0,block_size,true);
                if (ObjectUtils.isEmpty(temp)){
                    u = true;
                    break;
                }
                azFileApi.appendInputStream(file.getFilePath(),temp);
                temp.close();
            }
            if (u){
                file.setTime(new Date());
                res = this.add(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 上传文件数据
     *
     * @param file
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "上传文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public AZ_File uploadFileBytes(AZ_FileBytes file) throws AZ_BusinessException {
        if (ObjectUtils.isEmpty(file)){
            throw new AZ_BusinessException("COM_FILE_E_10","输入字节文件类型为空");
        }
        if (ObjectUtils.isEmpty(file.getBusinessID())){
            throw new AZ_BusinessException("COM_FILE_E_03","文件业务ID为空");
        }
        if (ObjectUtils.isEmpty(file.getBusinessType())){
            throw new AZ_BusinessException("COM_FILE_E_04","文件业务类型为空");
        }
        List<AZ_File> file_temp = getFile(file.getBusinessID(), file.getBusinessType());
        if (ListUtils.isNotEmpty(file_temp)){
            this.deleteFile(file.getBusinessID(),file.getBusinessType());
        }
        file.setFilePath(this.productFilePath(file));
        AZ_File res = null;
        try {
             boolean u = false;
            azFileApi.deleteFile(file.getFilePath());
            ByteArrayInputStream inputStream = new ByteArrayInputStream(file.getBytes());
            while (true){
                InputStream temp = IOUtils.copy(inputStream,0,block_size,true);
                if (ObjectUtils.isEmpty(temp)){
                    u = true;
                    break;
                }
                azFileApi.appendInputStream(file.getFilePath(),temp);
                temp.close();
            }
            inputStream.close();
            if (u){
                file.setTime(new Date());
                res = this.add(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 删除文件
     *
     * @param businessID
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "删除文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean deleteFile(String businessID, Short businessType) throws AZ_BusinessException {
        if (ObjectUtils.isEmpty(businessID)){
            throw new AZ_BusinessException("COM_FILE_E_03","文件业务ID为空");
        }
        if (ObjectUtils.isEmpty(businessType)){
            throw new AZ_BusinessException("COM_FILE_E_04","文件业务类型为空");
        }
        FileExample e = new FileExample();
        FileExample.Criteria ct = e.createCriteria();
        ct.andBusinessIDEqualTo(businessID);
        ct.andBusinessTypeEqualTo(businessType);
        int del = fileMapper.deleteByExample(e);
        return del > 0?true:false;
    }

    /**
     * 删除数据库文件映射
     *
     * @param businessID
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "删除文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean deleteFileByBusinessID(String businessID) throws AZ_BusinessException {
        if (ObjectUtils.isEmpty(businessID)){
            throw new AZ_BusinessException("COM_FILE_E_03","文件业务ID为空");
        }
        FileExample e = new FileExample();
        FileExample.Criteria ct = e.createCriteria();
        ct.andBusinessIDEqualTo(businessID);
        int del = fileMapper.deleteByExample(e);
        return del > 0?true:false;
    }

    /**
     * 删除数据库文件映射
     *
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "删除文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean deleteFileByBusinessType(Short businessType) throws AZ_BusinessException {
        if (ObjectUtils.isEmpty(businessType)){
            throw new AZ_BusinessException("COM_FILE_E_04","文件业务类型为空");
        }
        FileExample e = new FileExample();
        FileExample.Criteria ct = e.createCriteria();
        ct.andBusinessTypeEqualTo(businessType);
        int del = fileMapper.deleteByExample(e);
        return del > 0?true:false;
    }

    /**
     * 删除数据库文件映射
     *
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "删除所有文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean deleteAllFile() throws AZ_BusinessException {
        FileExample e = new FileExample();
        FileExample.Criteria ct = e.createCriteria();
        int del = fileMapper.deleteByExample(e);
        return del > 0?true:false;
    }

    /**
     * 清空指定文件
     *
     * @param businessID
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    @Transactional(rollbackFor = Exception.class)
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "清空文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean clearFile(String businessID, Short businessType) throws AZ_BusinessException {
        List<AZ_File> files= getFile(businessID,businessType);
        boolean res = false;
        if (ListUtils.isNotEmpty(files)){
            for (AZ_File vo:files){
                if (ObjectUtils.isNotEmpty(vo.getFilePath())){
                    try {
                        azFileApi.deleteFile(vo.getFilePath());
                    } catch (IOException e) {
                        throw new AZ_BusinessException(e.getMessage(),"删除文件实体失败");
                    }
                }
            }
        }
        return deleteFile(businessID,businessType);
    }

    /**
     * 清空指定类型文件
     *
     * @param businessType
     * @return
     * @throws AZ_BusinessException
     */
    @Transactional(rollbackFor = Exception.class)
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "清空文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean clearFileByBusinessType(Short businessType) throws AZ_BusinessException {
        List<AZ_File> files= getFileByBusinessType(businessType);
        boolean res = false;
        if (ListUtils.isNotEmpty(files)){
            for (AZ_File vo:files){
                if (ObjectUtils.isNotEmpty(vo.getFilePath())){
                    try {
                        azFileApi.deleteFile(vo.getFilePath());
                    } catch (IOException e) {
                        throw new AZ_BusinessException(e.getMessage(),"删除文件实体失败");
                    }
                }
            }
        }
        return deleteFileByBusinessType(businessType);
    }

    /**
     * 清空指定类型文件
     *
     * @param businessID
     * @throws AZ_BusinessException
     * @businessID
     */
    @Transactional(rollbackFor = Exception.class)
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "清空文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean clearFileByBusinessID(String businessID) throws AZ_BusinessException {
        List<AZ_File> files= getFileByBusinessID(businessID);
        boolean res = false;
        if (ListUtils.isNotEmpty(files)){
            for (AZ_File vo:files){
                if (ObjectUtils.isNotEmpty(vo.getFilePath())){
                    try {
                        azFileApi.deleteFile(vo.getFilePath());
                    } catch (IOException e) {
                        throw new AZ_BusinessException(e.getMessage(),"删除文件实体失败");
                    }
                }
            }
        }
        return deleteFileByBusinessID(businessID);
    }

    /**
     * 清空所有文件
     *
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "清空所有文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean clearAllFile() throws AZ_BusinessException {
        List<AZ_File> files= getFiles();
        boolean res = false;
        if (ListUtils.isNotEmpty(files)){
            for (AZ_File vo:files){
                if (ObjectUtils.isNotEmpty(vo.getFilePath())){
                    try {
                        azFileApi.deleteFile(vo.getFilePath());
                    } catch (IOException e) {
                        throw new AZ_BusinessException(e.getMessage(),"删除文件实体失败");
                    }
                }
            }
        }
        return deleteAllFile();
    }

    /**
     * 添加文件映射
     *
     * @param file
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "添加文件信息",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public AZ_File add(File file) throws AZ_BusinessException {
        if (ObjectUtils.isEmpty(file)){
            throw new AZ_BusinessException("COM_FILE_E_11","文件不存在");
        }
        if (ObjectUtils.isEmpty(file.getBusinessID())){
            throw new AZ_BusinessException("COM_FILE_E_03","文件业务ID为空");
        }
        if (ObjectUtils.isEmpty(file.getBusinessType())){
            throw new AZ_BusinessException("COM_FILE_E_04","文件业务类型为空");
        }
        if (ObjectUtils.isEmpty(file.getFilePath())){
            throw new AZ_BusinessException("COM_FILE_E_12","文件相对路径为空");
        }
        int res = fileMapper.insert(file);
        AZ_File azFile = null;
        if (res > 0){
            azFile = new AZ_File();
            BeanUtils.copyProperties(file,azFile);
            String filePathPrefix = getFilePathPrefix();
            if (StringUtils.isNotEmpty(filePathPrefix)){
                azFile.setFilePathPrefix(filePathPrefix);
                if (StringUtils.isNotEmpty(azFile.getFilePath())){
                    azFile.setFullFilePath(filePathPrefix+azFile.getFilePath());
                }
            }
        }
        return azFile;
    }

    /**
     * 文件前缀
     *
     * @return
     * @throws AZ_BusinessException
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "获得文件前缀",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public String getFilePathPrefix() throws AZ_BusinessException {
        return azEnv.getProperty("FILE_PATH_PREFIX",String.class,AZ_Constant.FILE_PATH_PREFIX);
    }

    /**
     * 获取文件中指定块的数据流
     *
     * @param id
     * @param skip_size
     * @param block_size
     * @return
     */
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "读取指定位置的数据块",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public byte[] copy2Bytes(Integer id, long skip_size, int block_size) throws AZ_BusinessException, IOException {
        if (ObjectUtils.isEmpty(id)){
            throw new AZ_BusinessException("COM_FILE_E_01","文件ID号为空");
        }
        if (block_size < 0){
            block_size = azEnv.getProperty("FILE_BLOCK_SIZE",Integer.class,AZ_Constant.FILE_BLOCK_SIZE)*AZ_Constant.FILE_BLOCK_UNIT_M;
        }
        if (skip_size < 0){
            skip_size = 0;
        }
        File file = getFileByID(id);
        byte[] bytes = null;
        if (ObjectUtils.isNotEmpty(file) && ObjectUtils.isNotEmpty(file.getFilePath())){
            bytes = azFileApi.readBytes(file.getFilePath(),skip_size,block_size);
        }
        return bytes;
    }

    @AZ_LogMethod(appName = "FileSystemService",appDesc = "生成文件路径",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    private String productFilePath(File file){
        String res = null;
        String filePath = file.getBusinessType()+"/"+file.getBusinessID()+"/"+file.getName()+file.getFileOriginalName();
        try {
            res = ByteUtils.toRadix(filePath.getBytes(),azEnv.getProperty("FILE_PATH_RADIX_BASE",Integer.class,AZ_Constant.FILE_PATH_RADIX_BASE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    @AZ_LogMethod(appName = "FileSystemService",appDesc = "初始化属性",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public void afterPropertiesSet() throws Exception {
        block_size = azEnv.getProperty("FILE_BLOCK_SIZE",Integer.class,AZ_Constant.FILE_BLOCK_SIZE)*AZ_Constant.FILE_BLOCK_UNIT_M;
    }
}
