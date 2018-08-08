package com.hennro.hes.module.scm.mapper;

import java.util.List;

import com.hennro.hes.module.scm.entity.Attachment;
import com.hennro.hes.module.scm.entity.PreOrderDetails;
import com.hennro.hes.module.scm.entity.Preorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

/**  
 * 
 * @author LuoHM
 * @date 2018-6-11 
 */
@Mapper
public interface PreOrderMapper {
	List<Preorder> findList(Preorder preorder);
	Preorder getById(@Param("id")String id);
	List<PreOrderDetails> getOrderDetails(@Param("id")String id);
	int inserFile(Attachment att);

	List<Attachment> getAttchments(@Param("fid")String fid);

	int checkExist(@Param("attName") String attName);

    Attachment getAttchmentById(@Param("id") String id);

	int deleteById(@Param("id")String attId);
}
