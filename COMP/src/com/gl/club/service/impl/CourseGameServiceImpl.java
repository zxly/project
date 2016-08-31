package com.gl.club.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.club.common.base.entity.IdEntity.EnableFlag;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BeanUtil;
import com.gl.club.common.tools.Constants;
import com.gl.club.common.tools.DateUtil;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.QRCodeUtils;
import com.gl.club.dao.CourseGameDao;
import com.gl.club.entity.CourseGame;
import com.gl.club.entity.CourseGame.BenginStatus;
import com.gl.club.service.CourseGameService;
import com.gl.club.vo.CourseGameVo;

@Service
public class CourseGameServiceImpl implements CourseGameService{

	@Autowired
	private CourseGameDao gameDao;
	
	@Override
	public Page<CourseGameVo> doFindGamePage(CourseGameVo gameVo,
			Page<CourseGameVo> page) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select cg.* ,mn.navigation_name,gc.course_name, ");
		sql.append(" (select count(*) from TBL_SIGN_ORDER so where cg.id = so.game_id ) as sign_count");
		sql.append(" from TBL_COURSE_GAME cg  left join TBL_MOBILE_NAVIGATION mn on cg.navigation_id = mn.id ");
		sql.append(" left join TBL_GOLF_COURSE gc on cg.course_id = gc.id ");
		sql.append(" where  cg.account_id = :accountId  and cg.enable_flag = :enableFlag ");
		paramMap.put("accountId", gameVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(gameVo.getNavigationId())){
			sql.append(" and cg.navigation_id = :navigationId ");
			paramMap.put("navigationId", gameVo.getNavigationId());
		}
		if(!EmptyUtil.isNullOrEmpty(gameVo.getCourseName())){
			sql.append(" and gc.course_name like :courseName ");
			paramMap.put("courseName", "%"+gameVo.getCourseName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(gameVo.getGameName())){
			sql.append(" and cg.game_name like :gameName ");
			paramMap.put("gameName", "%"+gameVo.getGameName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(gameVo.getBeginStatus())){
			sql.append(" and cg.begin_status = :beginStatus ");
			paramMap.put("beginStatus", gameVo.getBeginStatus().getValue());
		}
		if(!EmptyUtil.isNullOrEmpty(gameVo.getBeginTime())){
			sql.append(" and ").append(DateUtil.formatQueryTime("cg.begin_time")).append(">= :beginTime ");
			paramMap.put("beginTime", DateUtil.getStartTime(DateUtil.formatDate(gameVo.getBeginTime())));
		}
		if(!EmptyUtil.isNullOrEmpty(gameVo.getEndTime())){
			sql.append(" and ").append(DateUtil.formatQueryTime("cg.end_time")).append("<= :endTime ");
			paramMap.put("endTime", DateUtil.getEndTime(DateUtil.formatDate(gameVo.getEndTime())));
		}
		if(!EmptyUtil.isNullOrEmpty(gameVo.getSignBeginTime())){
			sql.append(" and ").append(DateUtil.formatQueryTime("cg.sign_begin_time")).append(">= :signBeginTime ");
			paramMap.put("signBeginTime", DateUtil.getStartTime(DateUtil.formatDate(gameVo.getSignBeginTime())));
		}
		if(!EmptyUtil.isNullOrEmpty(gameVo.getSignBeginTime())){
			sql.append(" and ").append(DateUtil.formatQueryTime("cg.sign_end_time")).append("<= :signEndTime ");
			paramMap.put("signEndTime", DateUtil.getEndTime(DateUtil.formatDate(gameVo.getSignBeginTime())));
		}
		return gameDao.findPageSQL(page, sql.toString(), paramMap, CourseGameVo.class);
	}

	@Override
	public CourseGameVo doFindGameById(String accountId, String id) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select cg.* ,mn.navigation_name,gc.course_name, ");
		sql.append(" (select count(*) from TBL_SIGN_ORDER so where cg.id = so.game_id ) as sign_count");
		sql.append(" from TBL_COURSE_GAME cg  left join TBL_MOBILE_NAVIGATION mn on cg.navigation_id = mn.id ");
		sql.append(" left join TBL_GOLF_COURSE gc on cg.course_id = gc.id ");
		sql.append(" where cg.id = :gameId and cg.account_id = :accountId  and cg.enable_flag = :enableFlag ");
		paramMap.put("gameId", id);
		paramMap.put("accountId", accountId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		return gameDao.findUniqueSql(sql.toString(), paramMap, CourseGameVo.class);
	}

	@Override
	public CourseGameVo doFindGameByGameId(String gameId){
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select cg.* ,mn.navigation_name,gc.course_name, ");
		sql.append(" (select count(*) from TBL_SIGN_ORDER so where cg.id = so.game_id ) as sign_count,");
		sql.append(" case when cg.begin_time > now() then 0 ");//比赛未开始
		sql.append(" when cg.begin_time <= now() and cg.end_time >= now() then 1 ");//比赛中
		sql.append(" when cg.end_time < now() then 2 ");//比赛结束
		sql.append(" when cg.sign_begin_time > now() then 3 ");//未开始报名
		sql.append(" when cg.sign_begin_time <= now() and cg.sign_end_time >= now() then 4 ");//报名中
		sql.append(" when cg.sign_end_time < now() then 5 end as game_status");//报名结束
		sql.append(" from TBL_COURSE_GAME cg  left join TBL_MOBILE_NAVIGATION mn on cg.navigation_id = mn.id ");
		sql.append(" left join TBL_GOLF_COURSE gc on cg.course_id = gc.id ");
		sql.append(" where cg.id = :gameId  and cg.enable_flag = :enableFlag ");
		paramMap.put("gameId", gameId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		return gameDao.findUniqueSql(sql.toString(), paramMap, CourseGameVo.class);
	}
	
	@Override
	@Transactional
	public AjaxMessage doSaveGame(CourseGameVo gameVo,HttpServletRequest request) throws Exception {
		CourseGame game = new CourseGame();
		BeanUtil.copyProperties(game, gameVo);
		game = gameDao.save(game);
		if(!EmptyUtil.isNullOrEmpty(game)){
				String qrcode = QRCodeUtils.uploadQrcode(request, Constants.IP+"/mobile/game/gameInfo.html?gameId="+game.getId());
				game.setQrcode(qrcode);
				game = gameDao.save(game);
				if(!EmptyUtil.isNullOrEmpty(game)){
					return AjaxMessage.getInstance(AjaxMessage.INFO, "比赛信息添加成功！");
				}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "比赛信息添加失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateGame(CourseGameVo gameVo) {
		String hql  = "From CourseGame where id = :gameId and accountId = :accountId and enableFlag = :enableFlag ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("gameId", gameVo.getId());
		paramMap.put("accountId", gameVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES);
		CourseGame game = gameDao.findUnique(hql, paramMap);
		BeanUtil.copyProperties(game, gameVo);
		game = gameDao.save(game);
		if(!EmptyUtil.isNullOrEmpty(game)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "比赛信息修改成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "比赛信息修改失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDelteGame(String accountId, List<String> gameIds) {
		String hql = "update CourseGame set enableFlag = :enableFlag where accountId = :accountId and id in (:list) ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("accountId", accountId);
		paramMap.put("list",gameIds);
		boolean isSuccess = gameDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "比赛信息删除成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "比赛信息删除失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doChangeGameStatus(String gameId, String accountId,
			BenginStatus status) {
		String hql  = "update CourseGame set beginStatus = :beginStatus where id = :gameId and accountId = :accountId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginStatus", status);
		paramMap.put("gameId", gameId);
		paramMap.put("accountId", accountId);
		boolean isSuccess = gameDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "比赛信息已修改为"+status.getText()+"！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "修改失败！");
	}

	@Override
	public List<CourseGameVo> doFindFinshCourseGame(String accountId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select cg.* from  TBL_COURSE_GAME cg where cg.account_Id = :accountId ");
		sql.append(" and cg.begin_Status = :status and cg.enable_Flag = :enableFlag ");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountId", accountId);
		paramMap.put("status", BenginStatus.BSJS.getValue());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		return gameDao.findListResultSql(sql.toString(), paramMap, CourseGameVo.class);
	}

}
