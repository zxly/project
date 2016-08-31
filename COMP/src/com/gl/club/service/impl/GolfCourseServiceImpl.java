package com.gl.club.service.impl;

import java.io.IOException;
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
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.QRCodeUtils;
import com.gl.club.dao.GolfCourseDao;
import com.gl.club.entity.GolfCourse;
import com.gl.club.service.GolfCourseService;
import com.gl.club.vo.GolfCourseVo;

/***
 * 
 * <b>类名：</b>GolfCourseServiceImpl.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>球场信息管理Action/p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-1 上午10:26:10
 */
@Service
public class GolfCourseServiceImpl implements GolfCourseService{
	
	@Autowired
	private GolfCourseDao golfCourseDao;

	@Override
	public Page<GolfCourseVo> doFindGolfCoursePage(Page<GolfCourseVo> page,
			GolfCourseVo golfCourseVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select g.*,mn.navigation_name ,(select count(*) from TBL_COURSE_ORDER co where co.course_id = g.id ) order_count ");
		sql.append(" from TBL_GOLF_COURSE g left  join TBL_MOBILE_NAVIGATION mn on g.navigation_id = mn.id ");
		sql.append(" where g.enable_flag = :enableFlag and g.account_id = :accountId ");
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("accountId", golfCourseVo.getAccountId());
		if(!EmptyUtil.isNullOrEmpty(golfCourseVo.getNavigationId())){
			sql.append(" and g.navigation_id = :navigationId ");
			paramMap.put("navigationId", golfCourseVo.getNavigationId());
		}
		if(!EmptyUtil.isNullOrEmpty(golfCourseVo.getCourseName())){
			sql.append(" and g.course_name like :courseName ");
			paramMap.put("courseName","%"+ golfCourseVo.getCourseName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(golfCourseVo.getIsReserve())){
			sql.append(" and g.is_reserve = :isReserve ");
			paramMap.put("isReserve", golfCourseVo.getIsReserve());
		}
		sql.append("order by g.sort asc ");
		return golfCourseDao.findPageSQL(page, sql.toString(), paramMap, GolfCourseVo.class);
	}

	@Override
	public List<GolfCourseVo> doFindGolfCourseList(String accountId,String navigationId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select g.*,mn.navigation_name ");
		sql.append(" from TBL_GOLF_COURSE g left  join TBL_MOBILE_NAVIGATION mn on g.navigation_id = mn.id ");
		sql.append(" where g.enable_flag = :enableFlag and g.account_id = :accountId ");
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("accountId", accountId);
		if(!EmptyUtil.isNullOrEmpty(navigationId)){
			sql.append(" and g.navigation_id = :navigationId ");
			paramMap.put("navigationId", navigationId);
		}
		sql.append("order by g.sort asc ");
		return golfCourseDao.findListResultSql(sql.toString(), paramMap, GolfCourseVo.class);
	}

	@Override
	public GolfCourseVo doFindGolfCourseById(String accountId, String courseId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select g.*,mn.navigation_name ");
		sql.append(" from TBL_GOLF_COURSE g left  join TBL_MOBILE_NAVIGATION mn on g.navigation_id = mn.id ");
		sql.append(" where g.id = :courseId and g.enable_flag = :enableFlag and g.account_id = :accountId ");
		paramMap.put("courseId", courseId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("accountId", accountId);
		return golfCourseDao.findUniqueSql(sql.toString(), paramMap, GolfCourseVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveGolfCourse(GolfCourseVo golfCourseVo,HttpServletRequest request) {
		GolfCourse golfCourse = new GolfCourse();
		BeanUtil.copyProperties(golfCourse, golfCourseVo);
		golfCourse = golfCourseDao.save(golfCourse);
		if(!EmptyUtil.isNullOrEmpty(golfCourse)){
			try {
				String qrcode = QRCodeUtils.uploadQrcode(request, Constants.IP+"/mobile/golfCourse/courseInfo.html?courseId="+golfCourse.getId()+"&accountId="+golfCourse.getAccountId());
				golfCourse.setQrcode(qrcode);
				golfCourse = golfCourseDao.save(golfCourse);
				if(!EmptyUtil.isNullOrEmpty(golfCourse)){
					return AjaxMessage.getInstance(AjaxMessage.INFO, "球场信息保存成功！");
				}
			} catch (IOException e) {
				e.printStackTrace();
				return AjaxMessage.getInstance(AjaxMessage.ERROR, "球场信息保存失败！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "球场信息保存失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateGolfCourse(GolfCourseVo golfCourseVo) {
		String hql ="From GolfCourse where id = :id and accountId = :accountId and enableFlag = :enableFlag ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", golfCourseVo.getId());
		paramMap.put("accountId", golfCourseVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES);
		GolfCourse golfCourse = golfCourseDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(golfCourse)){
			BeanUtil.copyProperties(golfCourse, golfCourseVo);
			golfCourse = golfCourseDao.save(golfCourse);
			if(!EmptyUtil.isNullOrEmpty(golfCourse)){
				return AjaxMessage.getInstance(AjaxMessage.INFO, "球场信息修改成功！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "球场信息修改失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDeleteGolfCourse(String accountId, List<String> ids) {
		String hql = "update GolfCourse set enableFlag = :enableFlag where accountId =:accountId and id in (:list) ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("accountId", accountId);
		paramMap.put("list", ids);
		boolean isSuccess = golfCourseDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "球场信息删除成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "球场信息删除失败！");
	}

	
	
}
