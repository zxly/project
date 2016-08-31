<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<!-- table-start -->
<table class="table_01 table_promotion mt15" cellspacing="0">
  <tbody>
      <tr>
          <th class="wp5">&nbsp;</th>
          <th class="wp5">排序</th>
          <th class="wp15">球场图片</th>
          <th class="wp10">球场名称</th>
          <th class="wp10">预定状态</th>
          <th class="wp10">预定详情</th>
          <th class="wp10">开放时间</th>
          <th class="wp10">二维码</th>
          <th class="wp10">所属功能</th>
          <th class="wp15">操作</th>
      </tr>
      <c:if test="${!empty page.result }">
      		<c:forEach items="${page.result }" var="course">
      			<tr>
		          <td><input type="checkbox" class="fl ml20 _checkbox" value="${course.id }"/></td>
		          <td><p class="ptb5 plr10 bd_e">${course.sort }</p></td>
		          <td><img src="${ctx }${course.imageUrl1 }" class="promotion_img bd_e"/></td>
		          <td>${course.courseName }</td>
		          <td>
		          		<c:if test="${course.isReserve eq Constants_YES}">
		          			<span class="t_green">已开放</span>
		          		</c:if>
		          		<c:if test="${course.isReserve eq Constants_NO}">
		          			<span class="t_999">未开放</span>
		          		</c:if>
		          </td>
		          <td> <a href="javascript:;" class="t_blue f14 pb10 js_open_pop course_user_order" data-target="#order" dataId="${course.id}">${course.orderCount }</a></td>
		          <td><a href="javascript:;" class="t_blue f14  pb10 js_open_pop course_date_scan" data-target="#datelist"  dataId="${course.id}">查看</a></td>
		           <td>
		              <div class="code_see t_blue re_r">
		                  <span class="t_blue">查看</span>
		                  <div class="ab_r r0 p10 bd_b bg_white code_box">
		                      <img src="${ctx }${course.qrcode }" class="code show_block"/>
		                  </div>  
		              </div>
		          </td>
		          <td>${course.navigationName}</td>
		          <td>
		              <a href="javascript:;" onclick="tools.updateSingleData('${ctx}/club/golfCourse/updatePage', '${course.id }')" class="t_blue f14 updateCls">编辑</a>
		              <a href="javascript:;" class="t_blue f14 js_open_pop deleteCls " data-target="#delsign" dataId="${course.id }">删除</a>
		          </td>
		      </tr>
      		</c:forEach>
      </c:if>
      <c:if test="${empty page.result }">
      		<tr>
		          <td colspan="10" style="text-align: center;">暂无球场信息</td>
		     </tr>
      </c:if>
  </tbody>
</table>
<!-- table-end -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>

