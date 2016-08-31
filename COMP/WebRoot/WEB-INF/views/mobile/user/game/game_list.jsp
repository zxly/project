<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/mobile/MobileTaglibs.jsp" %>
<ul>
	<c:if test="${!empty page.result }">
		<c:forEach items="${page.result }" var="game">
			<li class="clearfix plr10 ptb15">
				<div class="t-css l pro_img">
					<a href="${ctx }/mobile/order/signOrder/orderInfo.html?orderId=${game.id }&accountId=${game.accountId }" class="t-cell-css">
						<img src="${ctx }${game.imageUrl1}" alt="" />
					</a>
				</div>
				<div class="l pl10 pro_info">
					<a href="${ctx }/mobile/game/gameInfo.html?gameId=${game.gameId }" class="show pro_name">${game.gameName }</a>
					<p class="l ">
						<span class="t_fd741c f_08 wp100">
							开赛时间：<fmt:formatDate value="${ game.beginTime}" pattern="yyyy-MM-dd"/>
						</span><br />
						<span class="t_fd741c f_08 pl4">￥${game.price }元</span>
					</p>
					<c:if test="${game.beginStatus eq 'JXZ' }">
						<c:if test="${game.payType eq 'ONLINEPAY'  }">
							<c:if test="${game.payStatus eq 'DFK' }">
								<a href="${ctx }/mobile/order/signOrder/orderInfo.html?orderId=${game.id }&accountId=${game.accountId }" class="btn btn_organe r mt6">立即付款</a>
							</c:if>
							<c:if test="${game.payStatus eq 'YFK' }">
								<c:if test="${game.checkStatus ne 'YSH' }">
									<a href="javascript:;" class="btn btn_bd_orange r mt6">${ game.checkStatus.text}</a>
								</c:if>
								<c:if test="${game.checkStatus eq 'YSH' }">
									<a href="javascript:;" class="btn btn_bd_orange r mt6">${ game.payStatus.text}</a>
								</c:if>
							</c:if>
						</c:if>
						<c:if test="${game.payType eq 'OFFLINEPAY'  }">
							<c:if test="${game.checkStatus eq 'YSH' }">
								<a href="javascript:;" class="btn btn_bd_black r mt6">${ game.checkStatus.text}</a>
							</c:if>
							<c:if test="${game.checkStatus ne 'YSH' }">
								<a href="javascript:;" class="btn btn_bd_black r mt6">${ game.payType.text}</a>
								<a href="javascript:;" class="btn btn_bd_black r mt6">${ game.checkStatus.text}</a>
							</c:if>
						</c:if>
					</c:if>
					<c:if test="${game.beginStatus eq 'YJS' }">
						<c:if test="${game.payType eq 'ONLINEPAY'  }">
							<c:if test="${game.payStatus eq 'DFK' }">
								<a href="javascript:;" class="btn btn_organe r mt6">${ game.payStatus.text}</a>
							</c:if>
							<c:if test="${game.payStatus eq 'YFK' }">
								<c:if test="${game.checkStatus ne 'YSH' }">
									<a href="javascript:;" class="btn btn_bd_orange r mt6">${ game.checkStatus.text}</a>
								</c:if>
								<c:if test="${game.checkStatus eq 'YSH' }">
									<a href="javascript:;" class="btn btn_bd_orange r mt6">${ game.payStatus.text}</a>
								</c:if>
							</c:if>
						</c:if>
						<c:if test="${game.payType eq 'OFFLINEPAY'  }">
							<c:if test="${game.checkStatus eq 'YSH' }">
								<a href="javascript:;" class="btn btn_bd_black r mt6">${ game.checkStatus.text}</a>
							</c:if>
							<c:if test="${game.checkStatus ne 'YSH' }">
								<a href="javascript:;" class="btn btn_bd_black r mt6">${ game.checkStatus.text}</a>
							</c:if>
						</c:if>
					</c:if>
					<c:if test="${game.beginStatus eq 'BSZ' }">
						<c:if test="${game.payType eq 'ONLINEPAY'  }">
							<c:if test="${game.payStatus eq 'DFK' }">
								<a href="javascript:;" class="btn btn_bd_black r mt6">未付款</a>
							</c:if>
							<c:if test="${game.payStatus eq 'YFK' }">
								<c:if test="${game.checkStatus ne 'YSH' }">
									<a href="javascript:;" class="btn btn_bd_orange r mt6">${ game.checkStatus.text}</a>
								</c:if>
								<c:if test="${game.checkStatus eq 'YSH' }">
									<a href="javascript:;" class="btn btn_bd_orange r mt6">${ game.beginStatus.text}</a>
								</c:if>
							</c:if>
						</c:if>
						<c:if test="${game.payType eq 'OFFLINEPAY'  }">
							<c:if test="${game.checkStatus eq 'YSH' }">
								<a href="javascript:;" class="btn btn_bd_orange r mt6">${ game.beginStatus.text}</a>
							</c:if>
							<c:if test="${game.checkStatus ne 'YSH' }">
								<a href="javascript:;" class="btn btn_bd_black r mt6">${ game.checkStatus.text}</a>
							</c:if>
						</c:if>
					</c:if>
					<c:if test="${game.beginStatus eq 'BSJS' }">
						<c:if test="${game.payType eq 'ONLINEPAY'  }">
							<c:if test="${game.payStatus eq 'DFK' }">
								<a href="javascript:;" class="btn btn_bd_black r mt6">未付款</a>
							</c:if>
							<c:if test="${game.payStatus eq 'YFK' }">
								<c:if test="${game.checkStatus eq 'YSH' }">
									<a href="javascript:;" class="btn btn_bd_orange r mt6 grade_scan" 
										onclick="user_game.searchScore('${game.gameId}', '${game.accountId}')">查看成绩</a>
								</c:if>
								<c:if test="${game.checkStatus ne 'YSH' }">
									<a href="javascript:;" class="btn btn_bd_black r mt6">${ game.checkStatus.text}</a>
								</c:if>
							</c:if>
						</c:if>
						<c:if test="${game.payType eq 'OFFLINEPAY'  }">
							<c:if test="${game.checkStatus eq 'YSH' }">
								<a href="javascript:;" class="btn btn_bd_orange r mt6 grade_scan"
									onclick="user_game.searchScore('${game.gameId}', '${game.accountId}')">查看成绩</a>
							</c:if>
							<c:if test="${game.checkStatus ne 'YSH' }">
								<a href="javascript:;" class="btn btn_bd_black r mt6">${ game.checkStatus.text}</a>
							</c:if>
						</c:if>
					</c:if>
				</div>
			</li>
		</c:forEach>
	</c:if>
	<c:if test="${empty page.result }">
		<li class="clearfix plr10 ptb15">
			<div class="l pl10 pro_info">
				<a href="javascirpt:;" class="show pro_name">亲！您还没有报名比赛哦！</a>
			</div>
		</li>
	</c:if>
</ul>
<script type="text/javascript">
	initPage(${page.pageNumber},${page.pageSize},${page.totalCount});
</script>