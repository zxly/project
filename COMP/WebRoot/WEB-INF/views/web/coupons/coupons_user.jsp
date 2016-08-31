<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<div class="popup_inner">
            <div class="popup_tit">
                <span class="f16">发送优惠券</span><span class="close_btn">&times;</span>
            </div>
            <input type="text" placeholder="用户昵称" name="nickName" class="form_control w220 mt15 ml15" />
	        <input class="btn btn_blue mt15 ml15 "  type="button" value="搜索" onclick="coupons.doSearch()"/>
            <div class="popup_con">
                <div class="popup_info p15 clearfix">
                    <div class="fl wp40">
                        <div class="rank_box bd_d">
                            <div class="rank_left">
                                <div class="bd_d_b ptb10 t_c re_r bg_f5 text_bold clearfix">
                                    <p class="wp30 fl">会员头像</p> 
                                    <p class="wp30 fl">会员昵称</p>
                                    <p class="wp20 fl">会员姓名</p>
                                    <p class="wp20 fl">已领取量</p>
                                </div>
                                <c:if test="${!empty page.result }">
                                	<c:forEach items="${page.result }" var="user">
                                		<div class="rank_con bd_d_b ptb10 t_c re_r clearfix" dataId="${user.id }">
		                                    <p class="wp30 fl rank_store">
		                                    	<span class="pl5"><img src="${user.headImgUrl }" width="50px"/></span></p> 
		                                    <p class="wp30 fl rank_coupon">${user.nickName }</p>
		                                    <p class="wp20 fl">
		                                    	<c:if test="${empty user.userName  }">
		                                    		匿名
		                                    	</c:if>
		                                    	<c:if test="${!empty user.userName  }">
		                                    		${ user.userName}
		                                    	</c:if>
		                                    </p>
		                                    <p class="wp20 fl">${user.receviedNum }张</p>
		                                </div>
                                	</c:forEach>
                                </c:if>
                                <c:if test="${empty page.result }">
                                		<div class="rank_con bd_d_b ptb10 t_c re_r clearfix">
		                                    <p class="wp100fl rank_coupon">暂无会员信息</p>
		                                </div>
                                </c:if>
                            </div>
                            <!-- paging分页 -->
                            <tags:page page="${page}" searchFn="coupons.doSearch" ></tags:page>
                            <!-- paging分页-end -->  
                        </div>
                    </div>
                    <div class="fl wp15 rank_box rank_center">
                        <div class="btn_right"></div>
                        <div class="btn_left"></div>
                    </div>
                    <div class="fr wp45">
                        <div class="rank_box rank_right bd_d"></div>
                    </div>  
                </div>
            </div>
            <div class="popup_ft">
                <input type="button" value="确认发送" class="btn btn_blue js_confirm_pop confirm_send" />
                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
            </div>     
        </div>