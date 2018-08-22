package com.yxw.ssm.service.impl;




import com.yxw.ssm.mapper.SysPermissionMapperCustom;
import com.yxw.ssm.mapper.SysUserMapper;
import com.yxw.ssm.entity.ActiveUser;
import com.yxw.ssm.entity.SysPermission;
import com.yxw.ssm.entity.SysUser;
import com.yxw.ssm.exception.CustomException;
import com.yxw.ssm.service.SysService;
import com.yxw.ssm.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysServiceImpl implements SysService {
	
	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;
	
	@Autowired
	private SysUserMapper sysUserMapper;


	@Override
	public List<SysPermission> findSysPermissionList(String userid)
			throws Exception {
		
		return sysPermissionMapperCustom.findMenuByUserid(userid);
	}


	@Override
	public ActiveUser authenticat(String usercode, String password)
			throws Exception {
		
		//账号和密码非空校验
		/**
		 认证过程：
		 根据用户身份（账号）查询数据库，如果查询不到用户不存在
		 对输入的密码 和数据库密码 进行比对，如果一致，认证通过
		 */
		//根据用户账号查询数据库
		System.out.println(sysUserMapper.toString());
		SysUser sysUser = sysUserMapper.selectById(usercode);

		if(sysUser == null){
			//抛出异常
			throw new CustomException("用户账号不存在");
		}

		//数据库密码 (md5密码 )
		String password_db = sysUser.getPassword();

		//对输入的密码 和数据库密码 进行比对，如果一致，认证通过
		//对页面输入的密码 进行md5加密
		String password_input_md5 = new MD5().getMD5ofStr(password);
		if(!password_input_md5.equalsIgnoreCase(password_db)){
			//抛出异常
			throw new CustomException("用户名或密码 错误");
		}
		//得到用户id
		String userid = sysUser.getId();
		//根据用户id查询菜单
		List<SysPermission> menus =sysPermissionMapperCustom.findMenuByUserid(userid);

		//根据用户id查询权限url
		List<SysPermission> permissions = sysPermissionMapperCustom.findPermissionByUserid(userid);

		//认证通过，返回用户身份信息
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(sysUser.getId());
		activeUser.setUsercode(usercode);
		activeUser.setUsername(sysUser.getUsername());//用户名称

		//放入权限范围的菜单和url
		activeUser.setMenus(menus);
		activeUser.setPermissions(permissions);

		return activeUser;
/*
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(usercode);
		List<SysUser> userList = sysUserMapper.selectByExample(sysUserExample);
		if(userList == null || userList.size()<=0){
			throw new CustomException("账号不存在！");
		}
		SysUser sysUser = userList.get(0);
		//密码 
		String password_fromdb = sysUser.getPassword();
		
		//输入 密码 和数据库密码 比较
		if(!password_fromdb.equalsIgnoreCase(new MD5().getMD5ofStr(password))){
			throw new CustomException("账号或密码 错误 ！");
		}
		//认证通过，返回用户身份
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(sysUser.getId());
		activeUser.setUsername(sysUser.getUsername());
		activeUser.setUsercode(sysUser.getUsercode());
		
		//菜单列表
		List<SysPermission> menus = sysPermissionMapperCustom.findMenuByUserid(sysUser.getId());
		activeUser.setMenus(menus);
		//权限列表
		List<SysPermission> permissions = sysPermissionMapperCustom.findPermissionByUserid(sysUser.getId());
		activeUser.setPermissions(permissions);*/

	}




}
