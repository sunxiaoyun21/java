package com.sxy.service.impl;

import com.google.common.collect.Lists;
import com.sxy.exception.ServiceException;
import com.sxy.mapper.DiskMapper;
import com.sxy.pojo.Disk;
import com.sxy.service.DiskService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/2/21.
 */
@Service
public class DiskServiceImpl implements DiskService {
    @Autowired
    private DiskMapper diskMapper;

    @Value("${upload.path}")
    private String savaPath;

    @Override
    public List<Disk> findDiskByFid(Integer fid) {
        return diskMapper.findDiskByFid(fid);
    }

    /**
     * 创建新的文件价
     * @param disk
     */
    @Override
    public void saveFolder(Disk disk) {
        disk.setCreatUser("jack");
        disk.setCreatTime(DateTime.now().toString("YYYY-MM-dd hh:mm"));
        disk.setType(Disk.DIRECTORY_TYPE);
        diskMapper.saveFolder(disk);

    }

    /**
     * 保存文件
     * @param fid
     * @param file
     */
    @Override
    @Transactional
    public void saveFile(Integer fid, MultipartFile file) {

        //存文件到磁盘
        String sourceName=file.getOriginalFilename();
        String newName= UUID.randomUUID().toString();
        Long size=file.getSize();
        if(sourceName.lastIndexOf(".")!=-1){
            newName+=sourceName.substring(sourceName.lastIndexOf("."));
        }
        try {
            File saveFile=new File(new File(savaPath),newName);
            OutputStream outputStream=new FileOutputStream(saveFile);
            InputStream inputStream=file.getInputStream();
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }catch (IOException ex){
            throw new ServiceException();
        }
        //保存数据库
        Disk disk=new Disk();
        disk.setFid(fid);
        disk.setSourceName(sourceName);
        disk.setName(newName);
        disk.setCreatUser("jack");
        disk.setCreatTime(DateTime.now().toString("yyyy-mm-dd hh:mm"));
        disk.setSize(FileUtils.byteCountToDisplaySize(size));
        disk.setType(Disk.File_TYPE);

        diskMapper.saveFolder(disk);
    }

    @Override
    public InputStream downloadFile(Integer id) throws FileNotFoundException {
        Disk disk=diskMapper.findDiskById(id);
        if(disk==null || Disk.DIRECTORY_TYPE==disk.getType()){
            return  null;
        }else {
           File file=new File(savaPath+"/"+disk.getName());
           return new FileInputStream(file);
        }

    }

    @Override
    public Disk findDiskById(Integer id) {
        return diskMapper.findDiskById(id);
    }

    /**
     * 删除文件
     * @param id
     */
    @Override
    public void delDiskById(Integer id) {
        Disk disk=diskMapper.findDiskById(id);
        if(disk!=null){
            if(Disk.File_TYPE.equals(disk.getType())){
                //删除文件
                File file=new File(savaPath,disk.getName());
                file.delete();
                //删除数据库文件
                diskMapper.delDiskById(id);
            }else{
                List<Disk> diskList=diskMapper.findAll();//所有记录
                List<Integer> delListId= Lists.newArrayList();//即将被删除的ID
                findDelId(diskList,delListId,id);
                delListId.add(id);
               /* for(Integer delId:delListId){
                    Disk d=diskMapper.findDiskById(delId);
                    if(d.getType().equals(Disk.File_TYPE)){
                        diskMapper.delDiskById(delId);
                    }
                }*/
                //批量删除
                diskMapper.batchDel(delListId);
            }
        }

    }

    private void findDelId(List<Disk> diskList, List<Integer> delListId, Integer id) {
        for (Disk disk:diskList){
            if(disk.getFid().equals(id)){
                delListId.add(disk.getId());
                if(disk.getType().equals(Disk.DIRECTORY_TYPE)){
                    findDelId(diskList,delListId,disk.getId());
                }else {
                    File file=new File(savaPath,disk.getName());
                    file.delete();
                }
            }
        }
    }
}
