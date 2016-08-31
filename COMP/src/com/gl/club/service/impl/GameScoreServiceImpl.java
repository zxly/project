package com.gl.club.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.club.common.base.entity.IdEntity.EnableFlag;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.dao.GameScoreDao;
import com.gl.club.entity.GameScore;
import com.gl.club.service.GameScoreService;
import com.gl.club.vo.GameScoreVo;

@Service
public class GameScoreServiceImpl implements GameScoreService{

	@Autowired
	private GameScoreDao gameScoreDao;
	
	@Override
	public Page<GameScoreVo> doFindScoreByGame(Page<GameScoreVo> page,
			GameScoreVo gameScoreVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select gs.*, cg.game_name,u.user_name,u.nick_name ,sum(gs.greenbar) totle_green,");
		sql.append("sum(gs.grade) totle_Grade,sum(gs.par) totle_Par,sum(gs.handspike) totle_hands");
		sql.append(" from TBL_GAME_SCORE gs left join TBL_COURSE_GAME cg on gs.game_id = cg.id ");
		sql.append(" left join TBL_WX_USER u on gs.user_id = u.id ");
		sql.append(" where gs.account_id =:accountId and gs.game_id=:gameId and gs.enable_flag = :enableFlag ");
		paramMap.put("accountId", gameScoreVo.getAccountId());
		paramMap.put("gameId", gameScoreVo.getGameId());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(gameScoreVo.getUserId())){
			sql.append(" and gs.user_id = :userId ");
			paramMap.put("userId", gameScoreVo.getUserId());
		}
		sql.append(" group by gs.game_id ,gs.user_id ");
		return gameScoreDao.findPageSQL(page, sql.toString(), paramMap, GameScoreVo.class);
	}
	
	@Override
	public GameScoreVo doFindUserTotle(GameScoreVo gameScoreVo){
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select gs.*, cg.game_name,u.user_name,u.nick_name ,sum(gs.greenbar) totle_green,");
		sql.append("sum(gs.grade) totle_Grade,sum(gs.par) totle_Par,sum(gs.handspike) totle_hands");
		sql.append(" from TBL_GAME_SCORE gs left join TBL_COURSE_GAME cg on gs.game_id = cg.id ");
		sql.append(" left join TBL_WX_USER u on gs.user_id = u.id ");
		sql.append(" where gs.account_id =:accountId and gs.game_id=:gameId and gs.enable_flag = :enableFlag and gs.user_id = :userId ");
		paramMap.put("accountId", gameScoreVo.getAccountId());
		paramMap.put("gameId", gameScoreVo.getGameId());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("userId", gameScoreVo.getUserId());
		sql.append(" group by gs.game_id ,gs.user_id ");
		return gameScoreDao.findUniqueSql(sql.toString(), paramMap, GameScoreVo.class);
	}

	@Override
	public Page<GameScoreVo> doFindScoreDetail(Page<GameScoreVo> page,GameScoreVo gameScoreVo){
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select gs.*, cg.game_name,u.user_name,u.nick_name ");
		sql.append(" from TBL_GAME_SCORE gs left join TBL_COURSE_GAME cg on gs.game_id = cg.id ");
		sql.append(" left join TBL_WX_USER u on gs.user_id = u.id ");
		sql.append(" where gs.account_id =:accountId and gs.game_id=:gameId and gs.user_id = :userId ");
		sql.append(" order by gs.hole_No asc ");
		paramMap.put("accountId", gameScoreVo.getAccountId());
		paramMap.put("gameId", gameScoreVo.getGameId());
		paramMap.put("userId", gameScoreVo.getUserId());
		return gameScoreDao.findPageSQL(page, sql.toString(), paramMap, GameScoreVo.class);
	}
	
	@Override
	public AjaxMessage doSaveUserScore(GameScoreVo gameScoreVos) {
		List<GameScore> list = this.getScoreList(gameScoreVos);
		list = gameScoreDao.save(list);
		if(!EmptyUtil.isNullOrEmpty(list)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "计分保存成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "计分保存失败！");
	}

	@Override
	public AjaxMessage doUpdateUserScore(GameScoreVo gameScoreVos) {
		List<GameScore> list = this.getScoreList(gameScoreVos);
		list = gameScoreDao.save(list);
		if(!EmptyUtil.isNullOrEmpty(list)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "计分修改成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "计分修改失败！");
	}

	@Override
	public AjaxMessage doDelteUserScore(List<String> ids, String accountId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<GameScore> getScoreList(GameScoreVo gameScoreVos){
		List<GameScore> gameScores = new ArrayList<GameScore>();
		String gradeInfos = gameScoreVos.getGradeInfos();
		String [] gradeInfoArr = gradeInfos.split(";");
		for(int i =0;i<gradeInfoArr.length;i++){
			String[] grades =gradeInfoArr[i].split(",");
			if(!EmptyUtil.isNullOrEmpty(grades[7]) && !EmptyUtil.isNullOrEmpty(grades[2]) 
					&& !EmptyUtil.isNullOrEmpty(grades[3]) && !EmptyUtil.isNullOrEmpty(grades[4])
					&& !EmptyUtil.isNullOrEmpty(grades[5]) && !EmptyUtil.isNullOrEmpty(grades[6])){
				GameScore score = new GameScore();
				if(!grades[0].equals("0")){
					score.setId(grades[0]);
				}
				score.setAccountId(gameScoreVos.getAccountId());
				score.setGameId(gameScoreVos.getGameId());
				score.setUserId(gameScoreVos.getUserId());
				score.setHoleNo(Integer.parseInt(grades[1]));
				score.setHoleName(grades[2]);
				score.setPar(Integer.parseInt(grades[3]));
				score.setHandspike(Integer.parseInt(grades[4]));
				score.setGreenbar(Integer.parseInt(grades[5]));
				score.setEagleBall(Integer.parseInt(grades[6]));
				score.setBirdie(Integer.parseInt(grades[7]));
				Integer grade = Integer.parseInt(grades[4])+Integer.parseInt(grades[5]);
				score.setGrade(grade);
				gameScores.add(score);
			}
		}
		return gameScores;
	}

}
