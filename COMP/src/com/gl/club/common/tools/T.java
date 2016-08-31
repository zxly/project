
package com.gl.club.common.tools;

import java.util.UUID;

import com.gl.club.entity.SysUser;



public class T {
	
	public static void main(String[] args) {
		SysUser sysUser = new SysUser();
		sysUser.setLoginName("sysAdmin");
		sysUser.setPlainPassword("123!@#");
		sysUser.setIsFreeze(Constants.YES);
		sysUser.setNickName("admin");
		sysUser.setRealName("admin");
		Digests.entryptPassword(sysUser);
		System.out.println(sysUser.toString());
		System.out.println(UUID.randomUUID().toString().replace("-", ""));
	}

}
