package com.gl.club.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.club.common.base.entity.IdEntity.EnableFlag;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BeanUtil;
import com.gl.club.common.tools.Constants;
import com.gl.club.common.tools.Digests;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.dao.SysUserDao;
import com.gl.club.entity.SysUser;
import com.gl.club.service.SysUserService;
import com.gl.club.vo.SysUserVo;

/***
 * 
 * <b>类名：</b>SysUserServiceImpl.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>用户管理Servive</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-5 下午2:36:13
 */
@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public Page<SysUserVo> doFindUserByPage(SysUserVo userVo,Page<SysUserVo> page) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select u.id,u.account_id,a.account_name,u.login_name,u.mobile,u.email,u.real_name,u.header_pic,u.sex,u.nick_name ");
		sql.append("from TBL_SYS_USER u left  join TBL_WX_ACCOUNT a on u.account_id = a.account_id ");
		sql.append("where u.enable_flag = :enableFlag ");
		paramMap.put("enableFlag", Constants.YES);
		if(!EmptyUtil.isNullOrEmpty(userVo.getAccountId()) && !"0".equals(userVo.getAccountId())){
			sql.append(" and u.account_id = :accountId ");
			paramMap.put("accountId", userVo.getAccountId());
		}
		if(!EmptyUtil.isNullOrEmpty(userVo.getLoginName())){
			sql.append(" and u.login_name = :loginName ");
			paramMap.put("loginName", userVo.getLoginName());
		}
		if(!EmptyUtil.isNullOrEmpty(userVo.getNickName())){
			sql.append(" and u.nick_name like :nickName ");
			paramMap.put("nickName", "%"+userVo.getNickName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(userVo.getRealName())){
			sql.append(" and u.real_name like :realName ");
			paramMap.put("realName", "%"+userVo.getRealName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(userVo.getMobile())){
			sql.append(" and u.mobile = :mobile ");
			paramMap.put("mobile", userVo.getMobile());
		}
		return sysUserDao.findPageSQL(page, sql.toString(), paramMap, SysUserVo.class);
	}

	@Override
	public SysUserVo doFindUserById(String userId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select u.id,u.account_id,a.account_name,u.login_name,u.mobile,u.email,u.real_name,u.header_pic,u.sex,u.nick_name,u.plain_password ");
		sql.append("from TBL_SYS_USER u left  join TBL_WX_ACCOUNT a on u.account_id = a.account_id ");
		sql.append("where u.enable_flag = :enableFlag and u.id= :userId");
		paramMap.put("enableFlag", Constants.YES);
		paramMap.put("userId", userId);
		return sysUserDao.findUniqueSql(sql.toString(), paramMap, SysUserVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveUser(SysUserVo userVo) {
		SysUser user = new SysUser();
		BeanUtil.copyProperties(user, userVo);
		Digests.entryptPassword(user);
		user=sysUserDao.save(user);
		if(!EmptyUtil.isNullOrEmpty(user)){
			return AjaxMessage.getInstance(AjaxMessage.INFO,"添加用户成功！");
		}else{
			return AjaxMessage.getInstance(AjaxMessage.ERROR,"添加用户失败！");
		}
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateUser(SysUserVo userVo) {
		String hql="From SysUser where id=:id and enableFlag = :enableFlag ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", userVo.getId());
		paramMap.put("enableFlag", EnableFlag.YES);
		SysUser user = sysUserDao.findUnique(hql.toString(), paramMap);
		if(!EmptyUtil.isNullOrEmpty(user)){
			BeanUtil.copyProperties(user, userVo);
			Digests.entryptPassword(user);
			user=sysUserDao.save(user);
			if(!EmptyUtil.isNullOrEmpty(user)){
				return AjaxMessage.getInstance(AjaxMessage.INFO,"修改用户成功！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR,"修改用户失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDeleteUser(List<String> ids) {
		String hql="update SysUser set enableFlag = :enableFlag where id in (:list) ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("list",ids);
		boolean isSuccess = sysUserDao.batchUpdateOrDelete(hql.toString(), paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO,"删除用户成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR,"删除用户失败！");
	}

}
