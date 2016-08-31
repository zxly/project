<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
<title>就近生活</title>
<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
<link rel="stylesheet" href="${ctx }/static/mobile/css/index/index.css?v=${version}" type="text/css" />
<script type="text/javascript" src="${ctx }/static/mobile/js/index/index.js?v=${version}"></script>
</head>
<body>
<div class="content">
	<!-- header - start -->
	<header class="bg_w">
	    <form action="">
		  	<div class="index_head">
		  	  	<a class="city" href="javascript:;">上海站</a>
			    <div class="search bg_w bd_a0"><em class="iconfont icon-iconsousuo01 t_666"></em><input class="f_09" type="search" value="" placeholder="搜商户或搜地点"/><a href="javascript:" class="clear">&times;</a></div>
			    <button type="submit" class="search_btn f_10">搜索</button>
			</div>
	    </form>
	</header>
	<!-- header - end -->

	<!-- main - start -->
	<section>
		<div class="wrap pb80 pt50">
			<!-- banner - start -->
			<div class="top_banner js-slider">
				<ul class="clearfix">
					<li><a href="javascript:;"><img src="myImg/index_banner.jpg" alt=""/></a></li>
					<li><a href="javascript:;"><img src="myImg/index_banner.jpg" alt=""/></a></li>
					<li><a href="javascript:;"><img src="myImg/index_banner.jpg" alt=""/></a></li>
					<li><a href="javascript:;"><img src="myImg/index_banner.jpg" alt=""/></a></li>
				</ul>
				<ol class="final_dot" id="final_dot"><li class="active"></li></ol>
			</div>
			<!-- banner - end -->
			<!-- 快捷导航 - start -->
			<div class="index_nav bg_w plr10 pb15">
				<div class="nav_page clearfix">
					<a href="javascript:;" class="item cake">
						<div class="iconfont icon-jjshyinpintiandian t_ffa54b"></div>蛋糕甜点
					</a>
					<a href="javascript:;" class="item ktv">
						<div class="iconfont icon-jjshktvdianying t_9bcd46"></div>KTV&bull;电影
					</a>
					<a href="javascript:;" class="item hotel">
						<div class="iconfont icon-jjshjiudianbinguan t_60caff"></div>酒店宾馆
					</a>
					<a href="javascript:;" class="item looks">
						<div class="iconfont icon-jjshmeirongmeifa t_fa82a5"></div>美容美发
					</a>
					<a href="javascript:;" class="item food">
						<div class="iconfont icon-jjshcanyinmeishi t_41c8cd"></div>餐饮美食
					</a>
					<a href="javascript:;" class="item fun">
						<div class="iconfont icon-jjshxiuxianyule t_ffa54b"></div>休闲娱乐
					</a>
					<a href="javascript:;" class="item life">
						<div class="iconfont icon-jjshshenghuofuwu t_d69df7"></div>生活服务
					</a>
					<a href="all.html" class="item all">
						<div class="iconfont icon-jjshquanbufenlei t_60ffbe"></div>全部分类
					</a>
				</div>
			</div>
			<!-- 快捷导航 - end -->

			<!-- 活动模块 - start -->
			<div class="cnt bg_w clearfix mt10">
				<a href="javascript:;" class="item near">
					<div class="inner p10 bd_d2_r t-css border-box">
						<div class="wp60 t-cell-css t_l">
							<p class="t_fe3c3c">附近折扣</p>
							<p class="t_666 pt4 f_08">各种门店折扣卡</p>
						</div>
						<div class="wp40 t-cell-css"><img src="myImg/cnt_01.jpg" alt=""/></div>
					</div>
				</a>
				<a href="javascript:;" class="item near">
					<div class="inner p10 bd_d2_r t-css border-box">
						<div class="wp60 t-cell-css t_l">
							<p class="t_4180cd">微活动</p>
							<p class="t_666 pt4 f_08">摇一摇  拆礼盒</p>
						</div>
						<div class="wp40 t-cell-css"><img src="myImg/cnt_02.jpg" alt=""/></div>
					</div>
				</a>
				<a href="javascript:;" class="item near">
					<div class="inner p10 bd_d2_t bd_d2_r t-css border-box">
						<div class="wp60 t-cell-css t_l">
							<p class="t_41c8cd">天天红包</p>
							<p class="t_666 pt4 f_08">天天抢红包啦！</p>
						</div>
						<div class="wp40 t-cell-css"><img src="myImg/cnt_03.jpg" alt=""/></div>
					</div>
				</a>
				<a href="javascript:;" class="item near">
					<div class="inner p10 bd_d2_t t-css border-box">
						<div class="wp60 t-cell-css t_l">
							<p class="t_4180cd">众筹</p>
							<p class="t_666 pt4 f_08">小众筹 大世界</p>
						</div>
						<div class="wp40 t-cell-css"><img src="myImg/cnt_04.jpg" alt=""/></div>
					</div>
				</a>
			</div>
			<!-- 活动模块 - end -->

			<!-- 产品 - start -->
			<div class="pro js-tab">
				<div class="pro_nav bg_w clearfix mt15">
					<a href="javascript:;" class="ptb15 js-nav active">为你推荐</a>
					<a href="javascript:;" class="ptb15 js-nav">折扣商家</a>
					<a href="javascript:;" class="ptb15 js-nav">热门优惠</a>
					<span class="bd_line js-line"></span>
				</div>
				<div class="pro_list mt15">
					<div class="pro_rec js-refresh js-pro active">
						<div class="item bg_w plr10 ptb15">
							<p class="t_275680">牛人自助烤肉1<span class="ml10 t_fd741c"><em class="iconfont icon-jjshpingfenwujiaoxing01"></em>5分</span></p>
							<a href="javascript:;" class="ptb10 clearfix">
								<div class="img pr10 l">
									<img src="productImg/pro.jpg" alt=""/>
								</div>
								<div class="info l">
									<p class="name t_norwrap">仅售255元，价值295元5人自助餐！节假日通用！时尚火锅不...</p>
									<p class="price pt4"><span class="t_fd741c" class="f_07">￥<font class="f_11">255</font></span><del class="ml15">￥295元</del></p>
									<p class="people f_08"><span class="iconfont icon-jjshgoumaiguo t_275680"></span>144人<span class="ml10 iconfont icon-jjshchakanguo  t_275680"></span>280人</p>
								</div>
							</a>
							<a href="javascript:;" class="ptb10 clearfix">
								<div class="img pr10 l">
									<img src="productImg/pro.jpg" alt=""/>
								</div>
								<div class="info l">
									<p class="name t_norwrap">仅售255元，价值295元5人自助餐！节假日通用！时尚火锅不...</p>
									<p class="price pt4"><span class="t_fd741c" class="f_07">￥<font class="f_11">255</font></span><del class="ml15">￥295元</del></p>
									<p class="people f_08"><span class="iconfont icon-jjshgoumaiguo t_275680"></span>144人<span class="ml10 iconfont icon-jjshchakanguo  t_275680"></span>280人</p>
								</div>
							</a>
							<a href="javascript:;" class="t_c pt10">查看更多</a>
						</div>

						<div class="item bg_w plr10 ptb15 mt15">
							<p class="t_275680">牛人自助烤肉<span class="ml10 t_fd741c"><em class="iconfont icon-jjshpingfenwujiaoxing01"></em>5分</span></p>
							<a href="javascript:;" class="ptb10 clearfix">
								<div class="img pr10 l">
									<img src="productImg/pro.jpg" alt=""/>
								</div>
								<div class="info l">
									<p class="name t_norwrap">仅售255元，价值295元5人自助餐！节假日通用！时尚火锅不...</p>
									<p class="price pt4"><span class="t_fd741c f_07">￥<font class="f_11">255</font></span><del class="ml15">￥295元</del></p>
									<p class="people f_08"><span class="iconfont icon-jjshgoumaiguo t_275680"></span>144人<span class="ml10 iconfont icon-jjshchakanguo  t_275680"></span>280人</p>
								</div>
							</a>
						</div>
					</div>
                    <!--折扣商家-start-->
					<div class="pro_disc js-refresh js-pro">
						<div class="item bg_w plr10 ptb15 clearfix">
						  <div class="img pr10 l"><a href="#"><img src="productImg/pro_3.jpg" alt=""></a></div>
                          <div class="info l lh150">
                           <a href="#" class="name t_norwrap show">美国金仁促堡健身会所（金美国金仁促堡健身会所...</a>
                           <a href="#"><p class="disc_card f_09"><span class="f_11 t_fd741c">1</span>张打折卡</p></a>
                           <div class="dis_loc clearfix">
                            <span class="l f_09">全城28家通用</span>
                            <a class="r t_fd741c"><span class="iconfont icon-dibiao"></span>距离5.8米</a>
                           </div>
                          </div>
                        </div>
                        <div class="item bg_w plr10 ptb15 clearfix">
						  <div class="img pr10 l"><a href="#"><img src="productImg/pro_3.jpg" alt=""></a></div>
                          <div class="info l lh150">
                           <a href="#" class="name t_norwrap show">美国金仁促堡健身会所（金美国金仁促堡健身会所...</a>
                           <p class="disc_card"><span class="f_11 t_fd741c">5</span>张打折卡</p>
                           <div class="dis_loc clearfix">
                            <span class="l">全城12家通用</span>
                            <a class="r t_fd741c"><span class="iconfont icon-dibiao"></span>距离8.8米</a>
                           </div>
                          </div>
                        </div>
					</div>
                    <!--折扣商家-end-->
					<div class="pro_new js-refresh js-pro">
						<div class="item bg_w plr10 ptb15">
							<p class="t_275680">牛人自助烤肉3<span class="ml10 t_fd741c"><em class="iconfont icon-jjshpingfenwujiaoxing01"></em>5分</span></p>
							<a href="javascript:;" class="ptb10 clearfix">
								<div class="img pr10 l">
									<img src="productImg/pro.jpg" alt=""/>
								</div>
								<div class="info l">
									<p class="name t_norwrap">仅售255元，价值295元5人自助餐！节假日通用！时尚火锅不...</p>
									<p class="price pt4"><span class="t_fd741c" class="f_07">￥<font class="f_11">255</font></span><del class="ml15">￥295元</del></p>
									<p class="people f_08"><span class="iconfont icon-jjshgoumaiguo t_275680"></span>144人<span class="ml10 iconfont icon-jjshchakanguo  t_275680"></span>280人</p>
								</div>
							</a>
							<a href="javascript:;" class="ptb10 clearfix">
								<div class="img pr10 l">
									<img src="productImg/pro.jpg" alt=""/>
								</div>
								<div class="info l">
									<p class="name t_norwrap">仅售255元，价值295元5人自助餐！节假日通用！时尚火锅不...</p>
									<p class="price pt4"><span class="t_fd741c" class="f_07">￥<font class="f_11">255</font></span><del class="ml15">￥295元</del></p>
									<p class="people f_08"><span class="iconfont icon-jjshgoumaiguo t_275680"></span>144人<span class="ml10 iconfont icon-jjshchakanguo  t_275680"></span>280人</p>
								</div>
							</a>
							<a href="javascript:;" class="t_c pt10">查看更多</a>
						</div>

						<div class="item bg_w plr10 ptb15 mt15">
							<p class="t_275680">牛人自助烤肉<span class="ml10 t_fd741c"><em class="iconfont icon-jjshpingfenwujiaoxing01"></em>5分</span></p>
							<a href="javascript:;" class="ptb10 clearfix">
								<div class="img pr10 l">
									<img src="productImg/pro.jpg" alt=""/>
								</div>
								<div class="info l">
									<p class="name t_norwrap">仅售255元，价值295元5人自助餐！节假日通用！时尚火锅不...</p>
									<p class="price pt4"><span class="t_fd741c" class="f_07">￥<font class="f_11">255</font></span><del class="ml15">￥295元</del></p>
									<p class="people f_08"><span class="iconfont icon-jjshgoumaiguo t_275680"></span>144人<span class="ml10 iconfont icon-jjshchakanguo  t_275680"></span>280人</p>
								</div>
							</a>
						</div>
					</div>
					<a href="javascript:;" class="loadmore t_c mt15 js-refresh-more">下拉加载更多</a>
				</div>
			</div>
			<!-- 产品 - end -->
		</div>
	</section>
	<!-- main - end -->

	<!-- footer - start -->
	<footer>
		<div class="index_foot bd_b9_t ptb4 clearfix">
			<a href="javascript:;" class="active">
				<div class="iconfont icon-jjshshouye"></div>首页
			</a>
			<a href="javascript:;">
				<div class="iconfont icon-jjshshangjia"></div>商家
			</a>
			<a href="javascript:;">
				<div class="iconfont icon-jjshkaidian"></div>开店
			</a>
			<a href="javascript:;">
				<div class="iconfont icon-jjshwode"></div>我的
			</a>
		</div>	
	</footer>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="myJs/near_life_index.js"></script>
</html>