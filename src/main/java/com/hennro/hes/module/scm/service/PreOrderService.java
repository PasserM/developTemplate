package com.hennro.hes.module.scm.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hennro.hes.module.scm.entity.Attachment;
import com.hennro.hes.module.scm.entity.PreOrderDetails;
import com.hennro.hes.module.scm.entity.Preorder;
import com.hennro.hes.module.scm.mapper.PreOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


/**  
 * 
 * @author LuoHM
 * @date 2018-6-11 
 */
@Service
public class PreOrderService {
	@Resource
	PreOrderMapper mapper;

	public PageInfo<Preorder> getByPage(Preorder preorder) {
		if(null ==preorder.getPageNum() ){
			preorder.setPageNum(1);
		}
		if(null == preorder.getPageSize()){
			preorder.setPageSize(20);
		}
		PageHelper.startPage(preorder.getPageNum(),preorder.getPageSize());
		PageInfo<Preorder> page = new PageInfo<Preorder>(mapper.findList(preorder));
		return page;
	}
	public  Preorder getById(String id){
		return mapper.getById(id);
	}

	public List<PreOrderDetails> getOrderDetails(String id) {

		return mapper.getOrderDetails(id);
	}

	public int insertFile(MultipartFile file, String fileName, String id, String path, String remarks, Float size) {
		String postfix = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
		Attachment att = new Attachment();
		att.setAttName(fileName);
		att.setAttType(postfix);
		att.setPath(path);
		att.setFid(id);
		att.setRemark(remarks);
		att.setFileSize(size);
		return  mapper.inserFile(att);
	}

	public List<Attachment> getAttchments(String id) {
		return mapper.getAttchments(id);
	}

	public boolean checkExist(String attName){
		if(mapper.checkExist(attName)>0){
			return true;
		}
		return false;
	}

	public Attachment getAttchmentById(String id) {
		return mapper.getAttchmentById(id);
	}

	public int deleteById(String attId) {
		return mapper.deleteById(attId);
	}
}
