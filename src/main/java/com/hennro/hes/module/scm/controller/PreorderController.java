package com.hennro.hes.module.scm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.hennro.hes.common.JsonHelper;
import com.hennro.hes.common.base.Response;
import com.hennro.hes.module.scm.entity.Attachment;
import com.hennro.hes.module.scm.entity.PreOrderDetails;
import com.hennro.hes.module.scm.entity.Preorder;
import com.hennro.hes.module.scm.service.PreOrderService;
import com.hennro.hes.module.sys.core.entity.HUser;
import com.hennro.hes.utils.LayUI;
import org.apache.poi.util.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import static java.io.File.separator;

/**  
 * 
 * @author LuoHM
 * @date 2018-6-11 
 */
@Controller
@RequestMapping(value = "/scm/preorder")
public class PreorderController{

	@Autowired
    PreOrderService preorderService;

	@Autowired
	JsonHelper jsonHelper;
	
	@RequestMapping(value = {"list",""})
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {

		return "scm/order/preorderList";
	}
	@RequestMapping(value = {"preorderGrid"})
	@ResponseBody
	public Object orderGrid(HttpServletRequest request, Integer page, Integer limit , Preorder order, HttpServletResponse response, Model model) {
		Subject subject = SecurityUtils.getSubject();
		HUser user = (HUser) subject.getPrincipal();
		order.setPageNum(page);
		order.setPageSize(limit);
		order.setSupplyName(user.getFLoginName());
		PageInfo pageInfo = preorderService.getByPage(order);
		//List<Order> orderList = orderService.getOrderList(order);
		// model.addAttribute("orderList", orderList);
		return  jsonHelper.string(LayUI.data(pageInfo));
	}
	
	@RequestMapping(value = {"details"})
	public String details( String id,HttpServletRequest request, HttpServletResponse response, Model model) {

		Preorder order = preorderService.getById(id);
		List<PreOrderDetails> detailsList = preorderService.getOrderDetails(id);
		List<Attachment> attachmentList = preorderService.getAttchments(id);
		model.addAttribute("preOrder", order);
		model.addAttribute("detailsList", detailsList);
		model.addAttribute("attList",attachmentList);
		return "scm/order/preorderDetails";
	}
	@RequestMapping(value = {"upload"})
	@ResponseBody
	public String upload( String id,HttpServletRequest request, HttpServletResponse response, Model model, MultipartFile file) {
		//上传文件
		System.out.println("=上传文件=");
		if(file.isEmpty()){
			return jsonHelper.string(Response.failure("文件不存在"));
		}

		String fileName = file.getOriginalFilename();
		if(preorderService.checkExist(fileName)){
			return jsonHelper.string(Response.failure("文件名已存在，请修改后上传。"));
		}

		Float size = Float.valueOf(file.getSize());
		System.out.println(fileName + "-->" + (size/1024/1024)+"Mb");

		String path = "D:\\uploadFile"+separator+fileName;

		File newFile = new File(path);
		if(!newFile.getParentFile().exists()){//判断文件父目录是否存在
            newFile.getParentFile().mkdir();
		}
		try {
			file.transferTo(newFile); //保存文件
            Attachment att = new Attachment();
            preorderService.insertFile(file,fileName,id,path,"",size);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return jsonHelper.string(Response.failure(e.getMessage()));
		} catch (IOException e) {

			e.printStackTrace();
			return jsonHelper.string(Response.failure(e.getMessage()));
		}

		return jsonHelper.string(Response.success("上传成功"));
	}

	@RequestMapping(value = {"downLoad"})
	public void downLoad(String attId,HttpServletRequest request, HttpServletResponse response, Model model){
		Attachment att = preorderService.getAttchmentById(attId);
		response.setCharacterEncoding(request.getCharacterEncoding());
		response.setContentType("application/octet-stream");
		FileInputStream fis = null;
		try {
			File file = new File(att.getPath());
			fis = new FileInputStream(file);
			response.setHeader("Content-Disposition", "attachment; filename="+file.getName());
			IOUtils.copy(fis,response.getOutputStream());
			response.flushBuffer();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	@RequestMapping(value = {"delete"})
	@ResponseBody
	public String delete(String attId,HttpServletRequest request, HttpServletResponse response, Model model){

			try{
				Attachment att = preorderService.getAttchmentById(attId);
				//删除文件
				File file = new File(att.getPath());
				if (file.exists()){
					file.delete();
					int count = preorderService.deleteById(attId);
					System.out.println("影响行数："+count);
				}

			}catch (Exception e){
				return jsonHelper.string(Response.success("删除出错"));
			}

		return jsonHelper.string(Response.success("已删除"));
	}
}
