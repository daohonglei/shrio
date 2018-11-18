package com.ldh.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class Test01 {
	
	@Test
	public void test(){
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shrio.ini");
		SecurityManager manager=factory.getInstance();
		SecurityUtils.setSecurityManager(manager);
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("lisi", "123");
		subject.login(token);
		boolean flag=subject.isAuthenticated();
		System.out.println(flag);
		System.out.println(subject.hasRole("role1"));
		System.out.println(subject.isPermitted("user:add"));
	}
	
	@Test
	public void test2(){
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shrio-realm.ini");
		SecurityManager manager=factory.getInstance();
		SecurityUtils.setSecurityManager(manager);
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("aaa", "123");
		subject.login(token);
		boolean flag=subject.isAuthenticated();
		System.out.println(flag);
		
		System.out.println(subject.hasRole("role1"));
		System.out.println(subject.isPermitted("user:update"));
	}
	
	@Test
	public void test3(){
		String pwd="123";
		Md5Hash md5=new Md5Hash(pwd);
		System.out.println(md5.toString());
		
		//加盐
		md5=new Md5Hash(pwd,"ldh");
		System.out.println(md5.toString());
		
		//加盐   两次散列
		md5=new Md5Hash(pwd,"ldh",2);
		System.out.println(md5.toString());
		
	}

}
