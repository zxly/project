package com.gl.club.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.entity.CourseGame.BenginStatus;
import com.gl.club.vo.CourseGameVo;

public interface CourseGameService {

	/**
	 * 
	 * <b>方法名：</b>：doFindGamePage<br>
	 * <b>功能说明：</b>：分页查询比赛信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 上午10:34:55
	 * @param gameVo
	 * @param page
	 * @return
	 */
	public Page<CourseGameVo> doFindGamePage(CourseGameVo gameVo,Page<CourseGameVo> page);
	
	/**
	 * 
	 * <b>方法名：</b>：doFindGameById<br>
	 * <b>功能说明：</b>：查询单个比赛信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 上午10:35:13
	 * @param accountId
	 * @param id
	 * @return
	 */
	public CourseGameVo doFindGameById(String accountId,String id);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindGameByGameId<br>
	 * <b>功能说明：</b>：根据Id查询比赛详情<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-9 上午11:40:31
	 * @param gameId
	 * @return
	 */
	public CourseGameVo doFindGameByGameId(String gameId);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveGame<br>
	 * <b>功能说明：</b>：保存比赛信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 上午10:35:25
	 * @param gameVo
	 * @return
	 */
	public AjaxMessage doSaveGame(CourseGameVo gameVo,HttpServletRequest request) throws Exception;
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateGame<br>
	 * <b>功能说明：</b>：修改比赛信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 上午10:35:38
	 * @param gameVo
	 * @return
	 */
	public AjaxMessage doUpdateGame(CourseGameVo gameVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doDelteGame<br>
	 * <b>功能说明：</b>：删除比赛信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 上午10:35:52
	 * @param accountId
	 * @param gameIds
	 * @return
	 */
	public AjaxMessage doDelteGame(String accountId,List<String> gameIds);
	
	/***
	 * 
	 * <b>方法名：</b>：doChangeGameStatus<br>
	 * <b>功能说明：</b>：修改比赛状态<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 上午10:36:08
	 * @param gameId
	 * @param accountId
	 * @param status
	 * @return
	 */
	public AjaxMessage doChangeGameStatus(String gameId,String accountId,BenginStatus status);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindFinshCourseGame<br>
	 * <b>功能说明：</b>：查询比赛完成列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-23 下午5:15:37
	 * @param accountId
	 * @return
	 */
	public List<CourseGameVo> doFindFinshCourseGame(String accountId);
	
}
