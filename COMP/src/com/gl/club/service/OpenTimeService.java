package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.OpenTimeVo;

public interface OpenTimeService {
	
	public Page<OpenTimeVo> doFindOpenTimeByPage(Page<OpenTimeVo> page,OpenTimeVo openTimeVo);

	public List<OpenTimeVo> doFindOpenTimeListByDateId(String accountId,String dateId,String isReserve);
	
	public AjaxMessage doReserveOpenTime(String accountId,String timeId,String flag);
	
	public OpenTimeVo doFindOpenTimeById(String accountId,String timeId);
	
}
