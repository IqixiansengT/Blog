package qilianhao.blog.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import qilianhao.blog.entity.Blog;
import qilianhao.blog.entity.BlogType;
import qilianhao.blog.entity.Blogger;
import qilianhao.blog.entity.Link;
import qilianhao.blog.service.BlogService;
import qilianhao.blog.service.BlogTypeService;
import qilianhao.blog.service.BloggerService;
import qilianhao.blog.service.LinkService;
import qilianhao.blog.util.ResponseUtil;

import net.sf.json.JSONObject;

/**
 * ����ԱϵͳController��
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {

	@Resource
	private BloggerService bloggerService;
	
	@Resource
	private BlogTypeService blogTypeService;
	
	@Resource
	private BlogService blogService;
	
	@Resource
	private LinkService linkService;
	
	/**
	 * ˢ��ϵͳ����
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/refreshSystem")
	public String refreshSystem(HttpServletResponse response,HttpServletRequest request)throws Exception{
		ServletContext application=RequestContextUtils.getWebApplicationContext(request).getServletContext();
		Blogger blogger=bloggerService.find(); // ��ѯ������Ϣ
		blogger.setPassword(null);
		application.setAttribute("blogger", blogger);
		
		List<BlogType> blogTypeCountList=blogTypeService.countList(); // ��ѯ��������Լ����͵�����
		application.setAttribute("blogTypeCountList", blogTypeCountList);
		
		List<Blog> blogCountList=blogService.countList(); // �������ڷ����ѯ����
		application.setAttribute("blogCountList", blogCountList);
		
		List<Link> linkList=linkService.list(null); // ��ȡ������������
		application.setAttribute("linkList", linkList);
		
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
