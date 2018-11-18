package com.hd.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.hd.common.BaseConditionVO;
import com.hd.model.Userbean;
import com.hd.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	@Resource
	private IUserService userService;

	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		// shiro在认证过程中出现错误后将异常类路径通过request返回
		String exceptionClassName = (String) request
				.getAttribute("shiroLoginFailure");
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(
					exceptionClassName)) {
				// throw new CustomException("账号不存在");
				model.addAttribute("msg", "账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName)) {
				// throw new CustomException("用户名/密码错误");
				model.addAttribute("msg", "用户名/密码错误");
			} else if ("randomCodeError".equals(exceptionClassName)) {
				// throw new CustomException("验证码错误");
				model.addAttribute("msg", "验证码错误");
			} else {
				// throw new Exception();// 最终在异常处理器生成未知错误
				model.addAttribute("msg", "未知错误,请联系管理员");
			}
		}
		
		return "login";
	}
	
	@RequestMapping("/init")
	@RequiresPermissions("USER_CREATE")
	public String init(){
		
		return "add_user";
	}
	
	@RequestMapping("/query")
	@RequiresPermissions("USER_QUERY")
	public String queryAll(BaseConditionVO vo, Map map) {

		PageInfo<Userbean> list = userService.query(vo);
		System.out.println(list);
		map.put("pageModel", list);
		map.put("vo", vo);
		return "index";
	}

	@RequestMapping("/save")
	@RequiresPermissions("USER_CREATE")
	public String save(Userbean user) {
		userService.insertSelective(user);
		return "redirect:/user/query";
	}

	// restfull
	@RequestMapping("/delete/{id}")
	@RequiresPermissions("USER_DELETE")
	public String delete(@PathVariable("id") int id) {
		userService.deleteByPrimaryKey(id);
		return "redirect:/user/query";
	}

	@RequestMapping("/queryById/{id}")
	@RequiresPermissions("USER_UPDATE")
	public String queryById(@PathVariable("id") int id, Map map) {
		Userbean user = userService.selectByPrimaryKey(id);
		map.put("user", user);
		return "update_user";
	}

	@RequestMapping("/update")
	@RequiresPermissions("USER_UPDATE")
	public String update(Userbean user) {
		userService.updateByPrimaryKeySelective(user);

		return "redirect:/user/query";
	}

}
