<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
 <div class="popup_inner">
            <div class="popup_con">
                <div class="popup_info">
                    <div class="bg_f7 description_click">
                        <span class="close_btn cursor_p">×</span>
                        <div class="bg_f7">
                        <div id="slideBox" class="slideBox">
                            <div class="swiper-container">
				                <div class="swiper-wrapper">
				                	<c:if test="${ !empty goodsVo.imageUrl1 }">
				                		<a class="swiper-slide" href="javascript:;" ><img src="${ctx }${goodsVo.imageUrl1}" style="width:100%;" /></a>
				        			</c:if>
				        			<c:if test="${ !empty goodsVo.imageUrl2 }">
				                		<a class="swiper-slide" href="javascript:;" ><img src="${ctx }${goodsVo.imageUrl2}" style="width:100%;" /></a>
				        			</c:if>
				        			<c:if test="${ !empty goodsVo.imageUrl3 }">
				                		<a class="swiper-slide" href="javascript:;" ><img src="${ctx }${goodsVo.imageUrl3}" style="width:100%;" /></a>
				        			</c:if>
				        			<c:if test="${ !empty goodsVo.imageUrl4 }">
				                		<a class="swiper-slide" href="javascript:;" ><img src="${ctx }${goodsVo.imageUrl3}" style="width:100%;" /></a>
				        			</c:if>
				        			<c:if test="${ !empty goodsVo.imageUrl5 }">
				                		<a class="swiper-slide" href="javascript:;" ><img src="${ctx }${goodsVo.imageUrl5}" style="width:100%;" /></a>
				        			</c:if>
				                </div>
				                <div class="swiper-pagination"></div>
				            </div>
                        </div>
                        <div class="bg_w">
                            <div class="t_white bg_red plr10 ptb15 clearfix">
                              <span class="l">
                                <b class="f20 inline_block mr15">￥${goodsVo.vipPrice }</b>
                                <del>￥${goodsVo.price }</del>
                              </span>
                             <c:if test="${goodsVo.logisticsPrice eq '0'}">
                              	<span class="pt5 fr">免运费</span>
                             </c:if>
                             <c:if test="${goodsVo.logisticsPrice ne '0'}">
                              	<span class="pt5 fr">运费：￥${goodsVo.logisticsPrice }</span>
                             </c:if>
                            </div>
                            <div class="p10">
                              <p class="lh150">${goodsVo.goodsName }</p>
                              <p class="t_999 clearfix mt10">
                                <span class="fl">已售${goodsVo.totleCount - goodsVo.goodsSotck }件</span>
                              </p>
                            </div>
                            <!-- <div class="bd_d2_t">
                              <div class="bd_d4_dash_t sel_btn ptb15 plr10 clearfix">
                                <p class="tt_hb fl t_r t_fff lh150"><span class="plr4 f10 t_white">天天红包</span></p>
                                <p class="t_fd741c fl f10 lh_hb pl5">订单确认收货后，即可每天领取红包！</p>
                              </div>
                            </div> -->
                        </div>
                        <!--规格与数量 - start-->
                        <div class="mtb15 js-sz">
                            <div class="js-sz-btn bg_w plr10 ptb15">
                            	商品规格
                              <span class="iconfont icon-jjshxialajiantou fr bd_c_l pl10 t_999"></span>
                            </div>
                            <div class="js-sz-con bg_w p10 clearfix active">
                              <div class="bd_9a_dash_b tags pt15 clearfix">
                              	<c:if test="${!empty specs }">
                              		<c:forEach items="${specs }" var="spec" >
                              			<label class="fl mr10"><input type="radio" name="color" value="${spec.specName }"><span>${spec.specName }</span></label>
                              		</c:forEach>
                              	</c:if>
                              </div>
                              
                            </div>
                        </div>
                        <!--规格与数量 - end-->
                        <!--tab切换 - start-->
                        <div class="mtb15 js-tab detail_tab">
                            <div class="pro_nav bd_d2_b bg_w clearfix">
                                <a href="javascript:;" class="ptb15 js-nav active f14">图文详情</a>
                                <span class="bd_line js-line"></span>
                            </div>
                            <div class="pro_list">
                                <div class="js-pro active">
                                  <div class="p10 pic_detail bg_w">
                                    ${goodsVo.introduce }
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
