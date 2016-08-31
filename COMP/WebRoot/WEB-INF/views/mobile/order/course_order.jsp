<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>球场预定</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/order/order.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/order/order.js?v=${version}"></script>
</head>
<body>
<div class="content">
	<!-- main - start -->
	<section>
		<div class="wrap order_info pb80">
			<!-- 产品 - start -->
			<form id="course_order_form" method="post">
				<div class="wsend clearfix">
					<div class="bg_w bd_ec_b p10 lh150">
						<p>打球人信息</p>
					</div>
					<div class="bg_w  p10 play_user_info">
						<p class="ptb8 clearfix play_user">
							<span class="l wp25 10pr">
								<i class="iconfont icon-touxiang t_fd741c pr4 f_11"></i>
								<input type="hidden" class="userInput" value="0"/>
								<input type="text" readonly="readonly" class="userInput f_08 defaultName " />
							</span>
							<span class="l wp40 pr10">
								<i class="iconfont icon-shouji t_fd741c pr4 f_11"></i>
								<input type="text" readonly="readonly" maxlength="11" class="userInput f_08 defaultPhone " />
							</span>
							<span class="r wp30 pr10">
								<input type="button" class="editBtn del_btn r p4 ml3" value="删除" />
								<input type="button" class="editBtn edit_btn r p4 ml3" value="编辑" />
							</span>
						</p>
					</div>
				</div>
				<input type="hidden" name="accountId" id="accountId" value="${timeVo.accountId }" />
				<input type="hidden" name="courseId" id="courseId" value="${courseVo.id }" />
				<input type="hidden" name="timeId" value="${timeVo.id }" />
				<input type="hidden" id="stockCount" value="${4 - timeVo.saleCount }" />
				<input type="hidden" name="userId" id="userId"  />
				<input type="hidden" name="userCount" id="userCount" value="1"  />
				<input type="hidden"  id="signPrice" value="${timeVo.price }" />
				<input type="hidden" name="price" id="truePrice" value="" />
				<input type="hidden" name="playUsers" id="playUsers" value="" />
				<div class="order_con t_333">
					<ul class="ptb10">
						<li class="bd_ec bg_w plr10 mt15">
							<p class="tit ptb10">
								<span class="t_666">球场信息</span>
							</p>
							<div class="con ptb10 bd_d2_t clearfix">
								<a href="javascript:;" class="img l">
									<img src="${ctx }${courseVo.imageUrl1}"/>
								</a>
								<div class="r_txt pl10 lh150 l">
									<a href="javascript:;" class=" name">${courseVo.courseName }</a>
									<p class="ptb6 clearfix"><span class="l">联系电话:${courseVo.tellPhone }</span></p>
									<p class="t_999 f_09">球场地址:${courseVo.address }</p>
									<input type="hidden" id="navigationId" value="${courseVo.navigationId }">
								</div>
							</div>
							<p class="bd_d2_t ptb10 clearfix">
								<span class="pl10 l">开球时间:<fmt:formatDate value="${timeVo.openDate }" pattern="yyyy-MM-dd"/> <fmt:formatDate value="${timeVo.openTime }" pattern="HH:mm:00"/></span>
								<em class="f_08 t_orange r">剩余${4 - timeVo.saleCount }个球位</em>
							</p>
						</li>
						<li class="bg_w bd_ec_tb mt15 p10 clearfix addresssection">
							<span class="l t_666">打球人员：</span>
							<span class="r"><span class="t_fd741c chooseAddress"><i class="iconfont icon-jikediancanicon09 f_12 mr3"></i></span></span>
						</li>
						<li class="bg_w bd_ec_tb mt15 p10">
							<p class="pb10 clearfix vip_tis" style="display: none;">
								<span class="l f_08 t_orange">您是尊贵的VIP用户,付款享受会员价</span>
							</p>
							<p class=" lh2rem clearfix price">
								<span class="l t_666 ">实付款</span>
								<span class="t_fd741c t_bold f_16 r ">￥<span class="displayPrice">${timeVo.price }</span></span>
							</p>
						 </li>
					  </ul>
					</div>
				</form>
			</div>
			<!-- 产品 - end -->
		</div>
		<div class="wrap addr_mana user_add page_pop" id="user-input">
			<form>
				<ul class="bg_w addr_ul p10 bd_ec_tb">
					<li class="ptb10 clearfix">
						<label class="ptb10 addr_l t_999 l">姓名：</label>
						<input class="bd_ec addr_r p10 l" type="text" value="" id="playName" placeholder="请输入打球人姓名" />
					</li>
					<li class="ptb10 clearfix">
						<label class="ptb10 addr_l t_999 l">手机号码：</label>
						<input class="bd_ec addr_r p10 l" type="tel" value="" id="playPhone"  maxlength="11" 
								onkeyup="this.value=this.value.replace(/\D/g,'')" placeholder="请输入11位手机号码" />
					</li>
					<li class="pt10 pb20 t_c">
						<input type="button" class="btn btn_red mlr10 saveInfo" value="添加">
						<input type="button" class="btn btn_gray mlr10 cancelInfo" value="取消">
					</li>
				</ul>
			</form>
	   </div>
		<div class="popDiv pp" id="msgDiv" style="display:none" >
		    <div>
		        <p id="msg" style="top:30px text-align:center" ></p>
		    </div>
	    </div> 
	    <div class="gray"></div>
	</section>
	<!-- main - end -->
	<!-- footer - start -->
	<footer>
		<div class="index_foot index_foot_fa bd_b9_t
		 clearfix">
			<a href="javascript:;" class="c_fa mlr10">
				<span class="iconfont icon-daohangshouye f_20"></span>
			</a>
			<a href="javascript:;" class="btn btn_red mlr10 r confirm_pay">确认付款</a>
			<a href="javascript:;" class="btn btn_aaa mlr10 r back_btn">取消返回</a>
		</div>	
	</footer>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/order/course_order.js?v=${version}"></script>
</html>