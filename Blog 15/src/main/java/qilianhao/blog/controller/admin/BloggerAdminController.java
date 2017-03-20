package qilianhao.blog.controller.admin;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import qilianhao.blog.util.DateUtil;

import qilianhao.blog.entity.Blogger;
import qilianhao.blog.entity.Link;
import qilianhao.blog.entity.PageBean;
import qilianhao.blog.service.BloggerService;
import qilianhao.blog.util.CryptographyUtil;
import qilianhao.blog.util.ResponseUtil;
import qilianhao.blog.util.StringUtil;


/**
 * ����Ա����Controller��
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

	@Resource
	private BloggerService bloggerService;
	/**
	 * ��ѯ������Ϣ
	 * @param page
	 * @param rows
	 * @param s_blog
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/find")
	public String find(HttpServletResponse response)throws Exception{
		Blogger bloggerList=bloggerService.find();
		System.out.println("������Ϣ�޸Ĳ���+++++++++++++++++"+bloggerList.getNickName());
		JSONObject result=JSONObject.fromObject(bloggerList);
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * �޸Ĳ�����Ϣ
	 * @param file1
	 * @param blogger
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(@RequestParam("imageFile") MultipartFile imageFile,Blogger blogger,HttpServletRequest request,HttpServletResponse response)throws Exception{
		if(!imageFile.isEmpty()){
			String filePath=request.getServletContext().getRealPath("/");
			System.out.println("++++++++++++ͼƬ·������+++++++"+filePath);

			String imageName=DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
			System.out.println("++++++++++++ͼƬ·������+++++++"+imageName);
			imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
			System.out.println("++++++++++++ͼƬ·������+++++++"+new File(filePath+"static/userImages/"+imageName).getPath());

			blogger.setImageName(imageName);
		}
		int resultTotal=bloggerService.update(blogger);
		StringBuffer result=new StringBuffer();
		if(resultTotal>0){
			result.append("<script language='javascript'>alert('�޸ĳɹ���');</script>");
		}else{
			result.append("<script language='javascript'>alert('�޸�ʧ�ܣ�');</script>");
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * �޸Ĳ�������
	 * @param newPassword
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyPassword")
	public String modifyPassword(String newPassword,HttpServletResponse response)throws Exception{
		Blogger blogger=new Blogger();
		blogger.setPassword(CryptographyUtil.md5(newPassword, "����ɮ"));
		int resultTotal=bloggerService.update(blogger);
		JSONObject result=new JSONObject();
		System.out.println("�����޸Ĳ���"+resultTotal);
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	/*
	 * ��ȫ�˳�
	 * 
	 * */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		Subject subject=SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/login.jsp";
	}
	
}
