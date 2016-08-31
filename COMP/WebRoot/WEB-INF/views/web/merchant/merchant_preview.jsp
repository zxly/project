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
		                	<c:if test="${ !empty merVo.imageUrl1 }">
		                		<a class="swiper-slide" href="javascript:;" ><img src="${ctx }${merVo.imageUrl1}" style="width:100%;" /></a>
		        			</c:if>
		        			<c:if test="${ !empty merVo.imageUrl2 }">
		                		<a class="swiper-slide" href="javascript:;" ><img src="${ctx }${merVo.imageUrl2}" style="width:100%;" /></a>
		        			</c:if>
		        			<c:if test="${ !empty merVo.imageUrl3 }">
		                		<a class="swiper-slide" href="javascript:;" ><img src="${ctx }${merVo.imageUrl3}" style="width:100%;" /></a>
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
                       		<fmt:formatDate value="${merVo.openTime }" pattern="HH:mm:00"/>-<fmt:formatDate value="${merVo.closeTime }" pattern="HH:mm:00"/>
                       </span>
                     </div>
                     <div class="p10">
                       <p class="lh150">${merVo.merchantName }</p>
                     </div>
                     <div class="bd_d2_t">
	                       <div class="bd_d4_dash_t sel_btn ptb15 plr10 clearfix">
		                       	 <p class="t_fd741c fl f10 lh_hb pl5">联系电话:${merVo.tellPhone }</p>
		                       	 <c:if test="${merVo.isRecommended eq Constants_YES }">
		                         	<p class="t_fd741c fr f10 lh_hb pl5">${merVo.navigationName }推荐</p>
		                         </c:if>
	                       </div>
                     </div>
                   
                 </div>
                 <div class="mtb15 plr10 ptb15 bg_w t_333">所属区域：${merVo.address }</div>
                 </div>
                 <!--tab切换 - start-->
                 <div class="mtb15 js-tab detail_tab">
                     <div class="pro_nav bd_d2_b bg_w clearfix">
                         <a href="javascript:;" class="ptb15 js-nav active f14">商家简介</a>
                         <a href="javascript:;" class="ptb15 js-nav f14">商家优惠</a>
                         <span class="bd_line js-line"></span>
                     </div>
                     <div class="pro_list">
                         <div class="js-pro active">
                           <div class="p10 pic_detail bg_w">
                             	${merVo.introduce }
                           </div>
                         </div>
                         <div class="js-pro ">
                         	<c:if test="${empty sellVos }">
                           		<div class="plr10 ptb20 t_c">该商家暂无优惠信息！</div>
                            </c:if>
                           <c:if test="${!empty sellVos }">
                           		<ul class="detail_ul plr10 bg_w">
                           			<c:forEach items="${ sellVos}" var="sell">
                           				 <li class="ptb10 t-css border-box">
			                               <div class="wp20 t-cell-css t_l">
			                                 	<img src="${ctx}${sell.imageUrl1}" style="width: 50px">
			                               </div>
			                               <div class="t-cell-css pl10 border-box t_l">
			                                 	<a href="javascript:;" class="t_norwrap inline_block mb10">${sell.title}</a>
			                               </div>
			                             </li>
                           			</c:forEach>
		                          </ul>
                           </c:if>
                         </div>
                     </div>
                 </div>
                 <!--tab切换 - end-->
             </div>
             </div>
         </div>
     </div>
 </div>
