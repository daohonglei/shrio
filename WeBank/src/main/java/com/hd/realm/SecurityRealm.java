package com.hd.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class SecurityRealm extends AuthorizingRealm {

	// 身份认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// 获取用户名
		String username = (String) token.getPrincipal();

		// 根据用户名username到数据库查询，判断是否有这个用户
		// 模拟数据：假设aaa才是正确的用户名
		if (!"aaa".equals(username)) {
			// 用户名不存在
			return null;
		}

		// 2、判断密码 ，正确的密码是从数据库中取得，模拟数据 假设密码为123
		String pwd = "123";

		AuthenticationInfo info = new SimpleAuthenticationInfo(username, pwd,
				"myrealm");

		return info;
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		String username=(String) principal.getPrimaryPrincipal();
		//根据 用户名到数据库中查询这个用户所拥有的所有的菜单权限
		//模拟数据
//		List<String> list=new ArrayList<String>();
//		list.add("USER_CREATE");
//		list.add("USER_DELETE");
//		list.add("USER_QUERY");
		
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addRole("role1");
		//info.addStringPermission("USER_CREATE");
		info.addStringPermission("USER_QUERY");
		//info.addStringPermission("USER_UPDATE");
		
		
		return info;
	}

}
