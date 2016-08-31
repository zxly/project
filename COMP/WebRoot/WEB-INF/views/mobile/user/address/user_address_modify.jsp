<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<title>
		<c:if test="${empty method or 'save' eq method }">新增</c:if><c:if test="${!empty method and 'update' eq method }">编辑</c:if>地址
	</title>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/user/userAddress/user_address.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/user/userAddress/user_address.js?v=${version}"></script>
</head>
<body>
<div class="content">
	<!-- main - start -->
	<section>
		<div class="wrap addr_mana pb80">
			<form action="${ctx }/mobile/wxuser/address/add.ajax" 
					editAction="${ctx }/mobile/wxuser/address/update.ajax" 
					method="post" id="myForm">
				<input type="hidden"  name="id" value="${addressVo.id }" />
				<input type="hidden"  name="userId" id="userId" />
				<input type="hidden"  name="accountId" id="accountId" value="${accountId}" />
               	<input type="hidden"  id="method" value="${method }" />
				<ul class="bg_w addr_ul p10 bd_ec_tb">
					<li class="ptb10 clearfix">
						<label class="ptb10 addr_l t_999 l">收货人：</label>
						<input class="bd_ec addr_r p10 l" type="text" name="receiveName" 
							value="${addressVo.receiveName}" placeholder="请输入收件人">
					</li>
					<li class="ptb10 clearfix">
						<label class="ptb10 addr_l t_999 l">手机号码：</label>
						<input class="bd_ec addr_r p10 l" type="text" name="reveivePhone" 
							value="${addressVo.reveivePhone }" placeholder="请输入手机号码">
					</li>
					<li class="ptb10 clearfix">
						<label class="ptb10 addr_l t_999 l">邮政编码：</label>
						<input class="bd_ec addr_r p10 l" type="text" name="zipCode" 
							value="${addressVo.zipCode}" placeholder="请输入邮政编码">
					</li>
					<li class="ptb10 clearfix">
						<label class="ptb10 addr_l t_999 l">所在地址：</label>
						<p class="addr_r addr_r_sel l clearfix">
							<span>
								<select class="bd_ec ptb10 plr4 province_select" name="provinceId" ></select>
							</span>
							<span>
								<select class="bd_ec ptb10 plr4 city_select" name="cityId">
									<option>城市</option>
								</select>
							</span>
							<span>
								<select class="bd_ec ptb10 plr4 area_select" name="areaId">
									<option>区域</option>
								</select>
							</span>
						</p>
					</li>
					<li class="ptb10 clearfix">
						<label class="ptb10 addr_l t_999 l">详细地址：</label>
						<input class="bd_ec addr_r p10 l" type="text" name="address" 
							value="${addressVo.address }" placeholder="请输入详细地址">
					</li>
					<li class="pt10 pb20 t_c">
						<input type="button" class="btn btn_red mlr10 confrim_modify" value="保存"/>
						<input type="button" class="btn btn_gray mlr10" value="取消"/>
					</li>
				</ul>
			</form>
		</div>
	</section>
	<!-- main - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/user/userAddress/user_address_modify.js?v=${version}"></script>
</html>
