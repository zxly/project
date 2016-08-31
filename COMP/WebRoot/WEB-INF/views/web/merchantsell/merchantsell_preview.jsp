<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
 <div class="popup_inner">
     <div class="popup_con">
         <div class="popup_info">
             <div class="bg_f7 description_click">
                 <span class="close_btn cursor_p">×</span>
                 <div class="bg_f7">
                 <div id="slideBox" class="slideBox">
                 	<div class="swiper-container">
		                <div class="swiper-wrapper">
		                	<c:if test="${ !empty sellVo.imageUrl1 }">
		                		<a class="swiper-slide" href="javascript:;" ><img src="${ctx }${sellVo.imageUrl1}" style="width:100%;" /></a>
		        			</c:if>
		        			<c:if test="${ !empty sellVo.imageUrl2 }">
		                		<a class="swiper-slide" href="javascript:;" ><img src="${ctx }${sellVo.imageUrl2}" style="width:100%;" /></a>
		        			</c:if>
		        			<c:if test="${ !empty sellVo.imageUrl3 }">
		                		<a class="swiper-slide" href="javascript:;" ><img src="${ctx }${sellVo.imageUrl3}" style="width:100%;" /></a>
		        			</c:if>
		                </div>
		                <div class="swiper-pagination"></div>
		            </div>
                 </div>
                 <div class="bg_w">
                     <div class="t_white bg_red plr10 ptb15 clearfix">
                       <span class="l">
                         <b class="f20 inline_block mr15"></b>
                       </span>
                       <span class="pt5 fr">
                       		优惠时间：<fmt:formatDate value="${sellVo.beginTime}" pattern="yyy-MM-dd"/>至<fmt:formatDate value="${sellVo.endTime}" pattern="yyy-MM-dd"/>
                       </span>
                     </div>
                     <div class="p10">
                       <p class="lh150 f10">所属商家：${sellVo.merchantName }</p>
                     </div>
                     <div class="bd_d2_t">
	                       <div class="bd_d4_dash_t sel_btn ptb15 plr10 clearfix">
		                       	<p class="t_fd741c fl  lh_hb pl5">优惠标题:${sellVo.title }</p>
	                       </div>
                     </div>
                 </div>
                 </div>
                 <!--tab切换 - start-->
                 <div class="mtb15 js-tab detail_tab">
                     <div class="pro_nav bd_d2_b bg_w clearfix">
                         <a href="javascript:;" class="ptb15 js-nav active f14">优惠介绍</a>
                         <span class="bd_line js-line"></span>
                     </div>
                     <div class="pro_list">
                         <div class="js-pro active">
                           <div class="p10 pic_detail bg_w">
                             	${sellVo.content }
                           </div>
                         </div>
                     </div>
                 </div>
                 <!--tab切换 - end-->
             </div>
             </div>
         </div>
     </div>
 </div>
