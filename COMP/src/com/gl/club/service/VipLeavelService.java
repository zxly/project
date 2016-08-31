package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.VipLeavelVo;

public interface VipLeavelService {

	public Page<VipLeavelVo> doFindVipLeavelPage(Page<VipLeavelVo> page,VipLeavelVo leavelVo);
	
	public List<VipLeavelVo> doFindVipLeavelList(String accountId,String navigationId);
	
	public VipLeavelVo doFindVipLeavelById(String accountId,String leavelId);
	
	public AjaxMessage doSaveVipLeavel(VipLeavelVo leavelVo);
	
	public AjaxMessage doUpateVipLeavel(VipLeavelVo leavelVo);
	
	public AjaxMessage doDelteVipLeavel(String accountId,List<String> leavelIds);
}
