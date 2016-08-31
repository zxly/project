package com.gl.club.service;

import java.util.Map;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.CourseOrderVo;

public interface CourseOrderService {

	/***
	 * 
	 * <b>方法名：</b>：doFindCourseOrderPage<br>
	 * <b>功能说明：</b>：分页查询球场订场订单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 下午5:08:11
	 * @param page
	 * @param courseOrderVo
	 * @return
	 */
	public Page<CourseOrderVo> doFindCourseOrderPage(Page<CourseOrderVo> page,CourseOrderVo courseOrderVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveCourseOrder<br>
	 * <b>功能说明：</b>：确认提交订单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-12 上午11:00:15
	 * @param courseOrderVo
	 * @return
	 */
	public Map<String, Object> doSaveCourseOrder(CourseOrderVo courseOrderVo);
	
	
	/***
	 * 
	 * <b>方法名：</b>：updateCourseOrder<br>
	 * <b>功能说明：</b>：修改订单状态<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-12 上午11:00:27
	 * @param orderId
	 * @param payStatus
	 * @return
	 */
	public AjaxMessage updateCourseOrder(String orderId ,String userId);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindCourseOrderVoById<br>
	 * <b>功能说明：</b>：查询订单详情<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-12 下午3:19:06
	 * @param orderId
	 * @return
	 */
	public CourseOrderVo doFindCourseOrderVoById(String orderId);
	
	/***
	 * 
	 * <b>方法名：</b>：doCloseOrder<br>
	 * <b>功能说明：</b>：关闭订单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-29 下午5:19:42
	 * @param orderId
	 * @param userId
	 * @param accountId
	 * @return
	 */
	public AjaxMessage doCloseOrder(String orderId ,String userId,String accountId);
	
}
