package com.ldh.test;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomerRealm extends AuthorizingRealm{
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String name=(String) token.getPrincipal();
		if(!"aaa".equals(name)){
			return null;
		}
		String pwd="123";
		AuthenticationInfo info=new SimpleAuthenticationInfo(name, pwd, "myrealm");
		return info;
	}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		String name=(String) principal.getPrimaryPrincipal();
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addRole("role1");
		info.addRole("role2");
		info.addStringPermission("user:add");
		info.addStringPermission("user:update");
		return info;
	}	
}
