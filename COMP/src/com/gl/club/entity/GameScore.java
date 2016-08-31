package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;

/***
 * 
 * <b>类名：</b>GameScore.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>比赛计分</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-29 下午4:50:29
 */
@Entity
@Table(name="TBL_GAME_SCORE")
public class GameScore extends IdEntity{

	/** serialVersionUID */
	
	private static final long serialVersionUID = -8337232814637048528L;

	private String accountId;
	
	private String gameId;
	
	private String userId;
	
	private Integer holeNo;
	
	private String holeName;
	
	private Integer par;//标准杆
	
	private Integer handspike;//推杆
	
	private Integer greenbar;//上果岭杆
	
	private Integer eagleBall;//老鹰球
	
	private Integer birdie;//小鸟球
	
	private Integer grade;//总成绩

	private Date createTime;
	
	private String createUserId;
	
	private Date updateTime;
	
	private String updateUserId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getHoleNo() {
		return holeNo;
	}

	public void setHoleNo(Integer holeNo) {
		this.holeNo = holeNo;
	}

	public String getHoleName() {
		return holeName;
	}

	public void setHoleName(String holeName) {
		this.holeName = holeName;
	}

	public Integer getPar() {
		return par;
	}

	public void setPar(Integer par) {
		this.par = par;
	}

	public Integer getHandspike() {
		return handspike;
	}

	public void setHandspike(Integer handspike) {
		this.handspike = handspike;
	}

	public Integer getGreenbar() {
		return greenbar;
	}

	public void setGreenbar(Integer greenbar) {
		this.greenbar = greenbar;
	}

	public Integer getEagleBall() {
		return eagleBall;
	}

	public void setEagleBall(Integer eagleBall) {
		this.eagleBall = eagleBall;
	}

	public Integer getBirdie() {
		return birdie;
	}

	public void setBirdie(Integer birdie) {
		this.birdie = birdie;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Override
	public String toString() {
		return "GameScore [accountId=" + accountId + ", gameId=" + gameId
				+ ", userId=" + userId + ", holeNo=" + holeNo + ", holeName="
				+ holeName + ", par=" + par + ", handspike=" + handspike
				+ ", greenbar=" + greenbar + ", eagleBall=" + eagleBall
				+ ", birdie=" + birdie + ", grade=" + grade + ", createTime="
				+ createTime + ", createUserId=" + createUserId
				+ ", updateTime=" + updateTime + ", updateUserId="
				+ updateUserId + ", enableFlag=" + enableFlag + ", id=" + id
				+ "]";
	}

	public GameScore(String accountId, String gameId, String userId,
			Integer holeNo, String holeName, Integer par, Integer handspike,
			Integer greenbar, Integer eagleBall, Integer birdie, Integer grade,
			Date createTime, String createUserId, Date updateTime,
			String updateUserId) {
		super();
		this.accountId = accountId;
		this.gameId = gameId;
		this.userId = userId;
		this.holeNo = holeNo;
		this.holeName = holeName;
		this.par = par;
		this.handspike = handspike;
		this.greenbar = greenbar;
		this.eagleBall = eagleBall;
		this.birdie = birdie;
		this.grade = grade;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
	}

	public GameScore() {
		super();
	}
	
	
	
	
}
