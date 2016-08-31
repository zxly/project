package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.GameScoreVo;

public interface GameScoreService {

	/***
	 * 
	 * <b>方法名：</b>：doFindScoreByGame<br>
	 * <b>功能说明：</b>：根据比赛ID查询查询参赛人员的计分<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-23 下午2:03:57
	 * @param page
	 * @param gameScoreVo
	 * @return
	 */
	public Page<GameScoreVo> doFindScoreByGame(Page<GameScoreVo> page,GameScoreVo gameScoreVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindUserTotle<br>
	 * <b>功能说明：</b>：统计用户总成绩<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-25 上午11:36:52
	 * @param gameScoreVo
	 * @return
	 */
	public GameScoreVo doFindUserTotle(GameScoreVo gameScoreVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindScoreDetail<br>
	 * <b>功能说明：</b>：查询详细信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-24 下午3:15:57
	 * @param page
	 * @param gameScoreVo
	 * @return
	 */
	public Page<GameScoreVo> doFindScoreDetail(Page<GameScoreVo> page,GameScoreVo gameScoreVo);
	
	/**
	 * 
	 * <b>方法名：</b>：doSaveUserScore<br>
	 * <b>功能说明：</b>：添加保存用户分数<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-23 下午2:08:55
	 * @param gameScoreVo
	 * @return
	 */
	public AjaxMessage doSaveUserScore(GameScoreVo gameScoreVos);
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateUserScore<br>
	 * <b>功能说明：</b>：修改用户分数<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-23 下午2:09:30
	 * @param gameScoreVo
	 * @return
	 */
	public AjaxMessage doUpdateUserScore(GameScoreVo gameScoreVos);
	
	/**
	 * 
	 * <b>方法名：</b>：doDelteUserScore<br>
	 * <b>功能说明：</b>：删除用户分数<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-23 下午2:09:49
	 * @param ids
	 * @param accountId
	 * @return
	 */
	public AjaxMessage doDelteUserScore(List<String> ids,String accountId);
	
}
