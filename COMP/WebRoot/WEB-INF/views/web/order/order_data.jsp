<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<!-- 搜索end --->
<ul class="table_tit bd_d bg_f5 mtb15 t_c clearfix">
    <li class="wp10">用户名称</li>
    <li class="wp25">商品名称</li>
    <li class="wp15">商品价格</li>
    <li class="wp12">下单时间</li>
    <li class="wp12">快递费</li>
    <li class="wp10">订单状态</li>
    <li class="wp15">操作</li>
</ul>
<!-- table-start -->
<div class="wrap">
	<c:if test="${!empty page.result }">
		<c:forEach items="${page.result }" var="order">
			<table class="table_01 mb15" cellspacing="0">
		        <tbody>
		            <tr>
		                <th colspan="5" class="t_l">
		                	<p class="t_666">
		                		<c:if test="${!empty order.payTime  }">
				                	<span class="plr20">
				                		付款时间：<fmt:formatDate value="${order.payTime }" pattern="yyyy-MM-dd"/>
				                		<em class="pl10 t_999"><fmt:formatDate value="${order.payTime }" pattern="HH:mm:ss"/></em>
				                	</span>
			                	</c:if>
			                	<c:if test="${empty order.payTime  }">
			                		<span class="plr20">
				                		下单时间：<fmt:formatDate value="${order.createTime }" pattern="yyyy-MM-dd"/>
				                		<em class="pl10 t_999"><fmt:formatDate value="${order.createTime }" pattern="HH:mm:ss"/></em>
				                	</span>
			                	</c:if>
			                	<span>订单编号：${order.orderNo } </span>
		                	</p>
		                </th>
		                <th colspan="4" class="t_r t_666">商品价格：<span class="t_red pr20 text_bold">￥${order.price * order.goodsNumber }</span></th>
		            </tr>
		            <tr>
		                <td class="wp10">
		                	<c:if test="${empty order.realName }">
		                		<c:if test="${!empty order.userName }">
		                			${order.userName }
		                		</c:if>
		                		<c:if test="${empty order.userName }">
		                			${order.nickName }
		                		</c:if>
		                	</c:if>
		                	<c:if test="${!empty order.realName }">
		                		${order.realName }
		                	</c:if>
		                </td>
		                <td class="wp25 re_r">
		                	<div class="product clearfix">
		                    	<div class="dis_table fl">
		                    		<a href="javascript:;" class="dis_cell">
		                    			<img src="${ctx }${order.imageUrl1}" width="50px"/>
		                    		</a>
		                    	</div>
		                        <div class="fl pro_con t_l">
		                        	<p class="pro_tit">${order.goodsName} </p>
		                            <p class="pt5 clearfix"><span class="t_666 fl">${order.price}*${order.goodsNumber }</span>
		                            <!-- <span class="fr t_4279aa f14 snapshot">交易快照</span></p> -->
		                        </div>
		                    </div>
		                </td>
		                <td class="wp10">${order.price}</td>
		                <td class="wp15"><fmt:formatDate value="${order.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		                <td class="wp10">${order.logisticsPrice } </td>
		                <td class="wp10"><span>${order.orderStatus.text } </span></td>
		                <td class="wp15 re_r">
		                	<a href="javascript:;" class="t_4279aa f14 show_block detail_look" onclick="tools.updateSingleData('${ctx}/club/order/orderInfo', '${order.id }')">查看详情</a>
		                	<c:if test="${order.orderStatus eq 'DFH'}">
		                		<span class="btn btn_blue deliver_btn">确认发货</span>
                                <div class="detail_alert deliver_alert">
                                	<div class="triangle_r"></div>
                                	<div class="clearfix f18 t_2e ptb10 plr20 bd_e_b"><span class="fl">发货</span><span class="fr btn_close"></span></div>
                                    <div class="address_show clearfix ptb20">
                                    	<div class="fl w100 t_r lh30">收货地址:</div>
                                        <div class="fl address_con lh30">
                                        <p>
                                        	<span class="pr20">${order.acceptName }（收）</span>${order.telphone }<span class="pl10 pr20">${order.zipcode }</span>
                                        </p>
                                        <p class="clearfix">
                                        	<span class="detail_addr">${order.province }${order.city }${order.area }${order.receivingAddress }</span>
                                        </p>
                                        </div>
                                    </div>
                                    <div class="bd_d_dash_t ptb20 mlr30 clearfix">
                                        <!-- <div class="fl mb15 mr50 form_ctrl">
                                            <label class="fl">物流公司：</label>
                                            <div class=" pull_down fl">
                                                  <div class=" pull_down_text">顺丰快递</div>
                                                  <ul class=" pull_down_select">
                                                       <li>所有状态</li>
                                                       <li>待审核</li>
                                                       <li>已结束</li>
                                                       <li>进行中</li>
                                                  </ul>
                                             </div>
                                        </div>
                                        <div class="fl form_ctrl">
                                        	<label>运送单号：</label>
                                            <input type="text" value="25367815649632 " class="h30"/>
                                        </div>-->
                                        <span class="fr btn btn_blue deliver_sure" dataId="${order.id }" status="DSH">确认发货</span>
                                    </div> 
                                </div>
		                	</c:if>
		                    <!-- <span class="t_4279aa f14 show_block cur_po logistics_look">查看物流</span>
		                    <div class="detail_alert logistics_alert">
		                    	<div class="triangle_r"></div>
		                    	<div class="clearfix">
		                        	<div class="fl logi_con"><span class="pr20">天天快递</span>运单号：886148692835</div><span class="fr btn_close"></span>
		                        </div>
		                    </div> -->
		                </td>
		            </tr>
		        </tbody>
		    </table>
		</c:forEach>
	</c:if>
	<c:if test="${empty page.result }">
		<table class="table_01 mb15" cellspacing="0">
            <tbody>
                <tr>
                    <th colspan="5" class="t_c">
                    	<p class="t_666"><span class="plr20">没有订单数据 </span></p>
                    </th>
                </tr>
            </tbody>
        </table>
	</c:if>
</div>
<!-- table-end -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>
