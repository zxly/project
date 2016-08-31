<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<!-- table-start -->
<table class="table_01" cellspacing="0">
    <thead>
        <tr>
            <th class="wp25"> 赛事名称 </th>
            <th class="wp10"> 比赛场地 </th>
            <th> 比赛时间 </th>
            <th> 报名时间 </th>
            <th> 报名详情 </th>
            <th> 比赛成绩</th>
            <th> 比赛状态 </th>
            <th> 操作 </th>                                                                  
        </tr>
    </thead>
    <tbody>
    	<c:if test="${!empty page.result }">
    		<c:forEach items="${page.result }" var="game">
    			<tr>
		            <td class="re_r">
		                <div class="fl t-css bd_c goods_name ml20">
		                	<span class="t-cell-css">
		                		<img src="${ctx }${game.imageUrl1}"/>
		                	</span>
		                </div> 
		                <a href="javascript:;" class="goods_description overflow_h2  wp60 t_l t_justify fl f14 ">
		                  	${game.gameName }
		                    <div class="ab_r bg_white description_hover t-css p15">
		                        <span class="t-cell-css">
		                        	<img src="${game.qrcode }"/>
		                        </span>      
		                    </div>
		                </a>
		                <p class="pl10 t_red t_l fl text_bold pt5">会员价：￥${game.vipPrice}</p>    
		            </td>
		            <td>${game.courseName }</td>
		            <td> 
		            	<a href="javascript:;" class="f14 show_block t_green"><fmt:formatDate value="${game.beginTime }" pattern="yyyy-MM-dd"/></a>
		            	<a href="javascript:;" class="f14 show_block t_red"><fmt:formatDate value="${game.endTime }" pattern="yyyy-MM-dd"/></a>
		            </td>
		            <td> 
		            	<a href="javascript:;" class="f14 show_block t_green"><fmt:formatDate value="${game.signBeginTime }" pattern="yyyy-MM-dd"/></a>
		            	<a href="javascript:;" class="f14 show_block t_red"><fmt:formatDate value="${game.signEndTime }" pattern="yyyy-MM-dd"/></a>
		            </td>
		            <td>
		            	<a href="javascript:;" class="f14 js_open_pop stock" data-target="#stock" dataId="${game.id }">${game.signCount }人</a> 
		            </td>  
		            <td> 
		            	<a href="javascript:;" class="f14 js_open_pop t_blue score_scan" data-target="#game_score" dataId="${game.id }">查看</a>
		            </td>
		            <td>
		            	<c:if test="${game.beginStatus eq 'WKS' }">
		            		<div class="bg_orange t_white w70 h30 ml20">${game.beginStatus.text }</div>
		            	</c:if>
		            	<c:if test="${game.beginStatus eq 'JXZ' }">
		            		<div class="bg_green t_white w70 h30 ml20">${game.beginStatus.text }</div>
		            	</c:if>
		            	<c:if test="${game.beginStatus eq 'YJS' }">
		            		<div class="bg_blue t_white w70 h30 ml20">${game.beginStatus.text }</div>
		            	</c:if>
		            	<c:if test="${game.beginStatus eq 'BSZ' }">
		            		<div class="bg_blue t_white w70 h30 ml20">${game.beginStatus.text }</div>
		            	</c:if>
		            	<c:if test="${game.beginStatus eq 'BSJS' }">
		            		<div class="bg_gray t_white w70 h30 ml20">${game.beginStatus.text }</div>
		            	</c:if>
		            </td>
		            <td>
		            	<c:if test="${game.beginStatus eq 'WKS' }">
		            		<a href="javascript:;" class="f14  t_darkblue js_open_pop chanage_status" data-target="#change" status="JXZ" dataId="${game.id }">开始报名</a>
		            	</c:if>
		            	<c:if test="${game.beginStatus eq 'JXZ' }">
		            		<a href="javascript:;" class="f14  t_darkblue js_open_pop chanage_status" data-target="#change" status="YJS" dataId="${game.id }">结束报名</a>
		            	</c:if>
		            	<c:if test="${game.beginStatus eq 'YJS' }">
		            		<a href="javascript:;" class="f14  t_darkblue js_open_pop chanage_status" data-target="#change" status="BSZ" dataId="${game.id }">开始比赛</a>
		            	</c:if>
		            	<c:if test="${game.beginStatus eq 'BSZ' }">
		            		<a href="javascript:;" class="f14  t_darkblue js_open_pop chanage_status" data-target="#change" status="BSJS" dataId="${game.id }">结束比赛</a>
		            	</c:if>
		                <a href="javascript:;" class="f14  t_darkblue" onclick="tools.updateSingleData('${ctx}/club/game/updatePage', '${game.id }')">编辑</a>
		                <a href="javascript:;" class="f14  t_darkblue">删除</a>
		            </td>
		        </tr>
    		</c:forEach>
    	</c:if>
    	<c:if test="${empty page.result }">
    		<tr><td class="t_c" colspan="8">暂无赛事信息</td></tr>
    	</c:if>
    </tbody>
</table>
<!-- table-end -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>          
