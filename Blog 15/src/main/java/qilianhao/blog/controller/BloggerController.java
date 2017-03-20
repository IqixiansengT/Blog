package qilianhao.blog.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import qilianhao.blog.entity.Blogger;
import qilianhao.blog.service.BloggerService;
import qilianhao.blog.util.CryptographyUtil;


/**
 * ����Controller��
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@Resource
	private BloggerService bloggerService;
	/**
	 * ��ȫ��½
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(Blogger blogger,HttpServletRequest request,HttpServletResponse response){
		String remember=request.getParameter("remember");
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(blogger.getUserName(), CryptographyUtil.md5(blogger.getPassword(), "����ɮ"));
		try{
			subject.login(token); // ��¼��֤
			return "redirect:/admin/main.jsp";
		}catch(AuthenticationException e){
			e.printStackTrace();
			request.setAttribute("blogger", blogger);
			request.setAttribute("errorInfo", "�û��������������");
			return "login";
		}
	}
	
	/**
	 * ���ڲ���
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/aboutMe")
	public ModelAndView aboutMe()throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.addObject("pageTitle", "���ڲ���_SSM����ϵͳ");
		mav.addObject("mainPage", "foreground/blogger/info.jsp");
		mav.setViewName("mainTemp");
		return mav;
	}
	
}
