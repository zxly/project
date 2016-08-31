package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.OpenDateVo;

public interface OpenDateService {

	/***
	 * 
	 * <b>方法名：</b>：doFindOpenDatePage<br>
	 * <b>功能说明：</b>：分页查询球场开放预定的日期<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 上午10:38:32
	 * @param page
	 * @param dateVo
	 * @return
	 */
	public Page<OpenDateVo> doFindOpenDatePage(Page<OpenDateVo> page,OpenDateVo dateVo);
	
	public OpenDateVo doFindOpenDateById(String accountId,String dateId);
	
	public List<OpenDateVo> doFindOpenDateList(String accountId,String courseId ,String isReserve);
	
	public AjaxMessage doSaveOpenDate(OpenDateVo dateVo);
	
	public AjaxMessage doUpdateOpendDate(OpenDateVo dateVo);
	
	public AjaxMessage doDelteOpenDate(String accoutnId,List<String> dataIds);
	
	public AjaxMessage doReserveOpenDate(String accountId,String dateId,String flag);
	
}
