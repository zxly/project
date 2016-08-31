<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
 <table class="table_01" cellspacing="0">
    <thead>
        <tr>
        	<th> 用户头像 </th>
            <th> 登录名称</th>
            <th> 用户昵称</th>
            <th> 真实姓名 </th>
            <th> 手机号码 </th>
            <th> 用户邮箱</th>
            <th> 所属平台</th>
            <th class="wp20"> 操作 </th>
        </tr>
    </thead>
    <tbody>
    	<c:if test="${!empty page.result }">
    		<c:forEach items="${page.result}" var="user">
    			 <tr>
    			 	<td>
		                <div class="ml15 t-css  crowdfunding_project">
		                	<span class="t-cell-css">
		                		<c:if test="${empty user.headerPic }">
		                			<img src="${ctx }/static/web/image/globle/defalult_head.jpg" />
		                		</c:if>
		                		<c:if test="${!empty user.headerPic }">
		                			<img src="${ctx }${user.headerPic}"/>
		                		</c:if>
		                	</span>
		                </div> 
		            </td>
		            <td> ${user.loginName } </td>
		            <td> ${user.nickName }  </td>
		            <td> ${user.realName }  </td>
		            <td class="t_orange"> ${user.mobile } </td>
		            <td class="t_blue text_bold"> ${user.email } </td>
		            <td>${user.accountName }</td>
		            <td class="t_blue">
		                <div class="pull_down td_pull_down bg_blue fl">
		                    <div>
		                        <div class="fl pull_down_text fl t_999 t_white">操作</div>  
		                    </div>  
		                    <div class="pull_down_select t_white bg_blue">
		                        <ul>
		                            <li class="previewCls js_open_pop" data-target="#preview" dataId="${user.id }">预览</li>
		                            <li class="updateCls" actUrl="${ctx }/club/user/initUpdatePage/${user.id}">修改</li>
		                            <li class="deleteCls js_open_pop" data-target="#open" dataId="${user.id }">删除</li>
		                        </ul>
		                    </div>
		                    <span class="t_999 t_white f12"></span>
		                </div>
		            </td>
		        </tr>
    		</c:forEach>
    	</c:if>
    	<c:if test="${empty page.result }">
    		<tr><td colspan="8">暂无用户信息</td></tr>
    	</c:if>
       
    </tbody>
</table>
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>

