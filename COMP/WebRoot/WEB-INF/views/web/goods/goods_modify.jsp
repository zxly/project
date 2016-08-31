<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>
		<c:if test="${empty method or 'save' eq method }">发布</c:if><c:if test="${!empty method and 'update' eq method }">编辑</c:if>商品
	</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/goods/goods_modify.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/goods/goods_modify.js"></script>
	<c:set var="fileKey" value="${fileKey }"/>
	<script language="javascript" type="text/javascript">
		var fileKey = '${fileKey}';
	</script>
</head>

<body>
     <!--header-->
     <%@ include file="/WEB-INF/incComPage/web/head.jsp" %>
     
     <!--content-->
     <div class="content">
          <!--top menu-->
          <%@ include file="/WEB-INF/incComPage/web/top.jsp" %>
          
          <div class="main main-bg clearfix">
               <!--menu-left-->
               <%@ include file="/WEB-INF/incComPage/web/left.jsp" %>
               <!--menu-end-->
               
               <!--info-right-->
               <div class="info-right fr w980 pr20 pb60">
               <form action="${ctx }/club/goods/add" editAction="${ctx }/club/goods/update" method="post" id="myForm">
               		<input type="hidden"  name="id" value="${goodsVo.id }" />
               		<input type="hidden"  id="method" value="${method }" />
                    <div class="bd_c mt15 p30">
                          <div class="mb20">
                              <label class="w80 show_inline_block t_r">商品名称：</label>
                              <input type="text" class="form_control w450" name="goodsName" value="${goodsVo.goodsName }"/>
                          </div>
                          <div class="mb20">
                              <label class="w80 show_inline_block t_r">所属导航：</label>
                              <input type="hidden" name="navigationId" id="navigationId" value="${goodsVo.navigationId }"/>
                               <div class="pull_down navigation_pull_down v_m">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">
		                              		<c:if test="${empty goodsVo.navigationId }">
		                              			请选择功能导航
		                              		</c:if>
		                              		<c:if test="${!empty goodsVo.navigationId }">
		                              			${goodsVo.navigationName }
		                              		</c:if>
		                              </div>  
		                          </div>  
		                          <div class="pull_down_select t_999">
		                              <ul class="pull_down_navigation"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
                          </div>
                          <div class="mb20 clearfix">
                              <label class="w80 show_inline_block t_r fl">商品类型：</label>
                              <input type="text" class="form_control w150 fl" id="categoryName" value="${goodsVo.categoryName }" disabled="disabled"/>
                              <input type="hidden"  name="categoryId" id="categoryId" value="${goodsVo.categoryId }"/>
                              <em class="f12 t_red fl mt15 ml15">*请在下方选择商品类型</em>
                          </div>
                          <div class="mb20 clearfix">
                              <label class="w80 show_inline_block t_r fl">类型选择：</label>
                              <div class="bd_c w180 fl mr10 ht200" >
                              		<div class="wp100 h32 bg_fa t_c bd_c_b">一级分类</div>
                              		<div class="wp100 categorydiv categorydiv1 ht160 owoverflow_auto" ></div>
                              </div>
                              <div class="bd_c w180 fl mr10 ht200" >
                              		<div class="wp100 h32 bg_fa t_c bd_c_b">二级分类</div>
                              		<div class="wp100 categorydiv categorydiv2 ht160 owoverflow_auto" ></div>
                              </div>
                              <div class="bd_c w180 fl mr10 ht200" >
                              		<div class="wp100 h32 bg_fa t_c bd_c_b">三级分类</div>
                              		<div class="wp100 categorydiv categorydiv3 ht160 owoverflow_auto" ></div>
                              </div>
                          </div>
                          <div class="mb20">
                              <label  class="w80 show_inline_block t_r">是否上架：</label>
                              <label class="pr10">
                                  <input type="radio" name="isUp" value="${Constants_YES }" <c:if test="${empty goodsVo.isUp or goodsVo.isUp eq Constants_YES }">checked="checked"</c:if> />是  
                              </label>
                              <label>
                                  <input type="radio" name="isUp" value="${Constants_NO }" <c:if test="${!empty goodsVo.isUp and goodsVo.isUp eq Constants_NO }">checked="checked"</c:if>/>否  
                              </label>
                              <span>（只有上架的商品才会在前台显示出来，客户是无法看到下架商品）</span>          
                          </div>
                          <div class="mb20 clearfix">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">商品规格：</label>
                              <div class="fl">
                                  <table class="table_p" cellspacing="0">
                                      <thead>
                                          <tr>
                                              <th>规格</th>                                                        
                                              <th>数量</th>
                                              <th>原价</th>
                                              <th>会员价</th>
                                              <th>操作</th>
                                          </tr> 
                                      </thead>
                                      <tbody>
                                      	<c:if test="${empty specVo }">
                                      		<tr class="speclist">
                                      		  <td style="display: none;"><input class="t_c w80 form_control specId"  type="text" value="0"/></td>
                                              <td><input class="t_c w80 form_control specName"  type="text" value=""/></td>
                                              <td><input class="t_c w80 form_control goodsNum" type="text" value=""/></td>
                                              <td><input class="t_c w80 form_control price" type="text" value=""/></td>
                                              <td><input class="t_c w80 form_control vipPrice" type="text" value=""/></td>
                                              <td><a class="t_darkblue f14 del" href="javascript:;"></a></td>
                                          </tr>
                                      	</c:if>
                                      	<c:if test="${!empty specVo }">
                                      		<c:forEach items="${ specVo}" var="spec">
	                                      		<tr class="speclist">
	                                      			  <td style="display: none;"><input class="t_c w80 form_control specId"  type="text" value="${spec.id }"/></td>
	                                      			  <td><input class="t_c w80 form_control specName" disabled="disabled"  type="text" value="${spec.specName }"/></td>
		                                              <td><input class="t_c w80 form_control goodsNum" disabled="disabled" type="text" value="${spec.specNumber }"/></td>
		                                              <td><input class="t_c w80 form_control price"  type="text" value="${spec.price }"/></td>
		                                              <td><input class="t_c w80 form_control vipPrice"  type="text" value="${spec.vipPrice }"/></td>
		                                              <td><a class="t_darkblue f14 del" href="javascript:;"></a></td>
		                                          </tr>
                                      		</c:forEach>
                                      	</c:if>
                                      </tbody>
                                  </table>
                                  <div class="bd_c add_box">
                                  	  <input type="hidden" name="goodsSpec" id="goodsSpec" value=""/>
                                      <a href="javascript:;" class="add f14">
                                        + 新增内容
                                      </a>
                                  </div>  
                              </div>
                          </div>
                          <div class="clearfix mb20">
                                <label class="w80 show_inline_block t_r fl pr4 pt5">商品图片：</label>
                                <div class="img_box fl bd_c">
                                    
                                    <div class="img clearfix mtb15">
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty goodsVo.imageUrl1 }">
	                                             <p class="t-cell-css">
		                                              	<img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" 
		                                              		name="upload_img_1" id="upload_img_1" fid="1" alt="img"/>
		                                            	<input type="hidden" name="imageUrl1" id="image_url_1" value=""/>
		                                          </p>
	                                          </c:if>
	                                          <c:if test="${!empty goodsVo.imageUrl1 }">
	                                             <p class="t-cell-css">
		                                              	<img class="upload_img" src="${ctx }${goodsVo.imageUrl1}" name="upload_img_1" id="upload_img_1" fid="1" alt="img"/>
		                                            	<input type="hidden" name="imageUrl1" id="image_url_1" value="${goodsVo.imageUrl1}"/>
		                                          </p>
	                                          </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty goodsVo.imageUrl2 }">
	                                           <p class="t-cell-css">
		                                              	<img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" 
		                                              		name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
		                                            	<input type="hidden" name="imageUrl2" id="image_url_2" value=""/>
		                                        </p>
	                                        </c:if>
	                                        <c:if test="${!empty goodsVo.imageUrl2 }">
	                                        	<p class="t-cell-css">
		                                              	<img class="upload_img" src="${ctx }${goodsVo.imageUrl2 } 
		                                              		name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
		                                            	<input type="hidden" name="imageUrl2" id="image_url_2" value="${goodsVo.imageUrl2 }"/>
		                                        </p>
	                                        </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty goodsVo.imageUrl3 }">
                                        		<p class="t-cell-css">
		                                           <img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_3" 
		                                           	id="upload_img_3" fid="3" alt="img"/>
		                                           <input type="hidden" name="imageUrl3" id="image_url_3" value=""/>
		                                        </p>
                                        	</c:if>
                                        	<c:if test="${!empty goodsVo.imageUrl3 }">
                                        		<p class="t-cell-css">
		                                           <img class="upload_img" src="${ctx }${goodsVo.imageUrl3}" name="upload_img_3" 
		                                           	id="upload_img_3" fid="3" alt="img"/>
		                                           <input type="hidden" name="imageUrl3" id="image_url_3" value="${goodsVo.imageUrl3 }"/>
		                                        </p>
                                        	</c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty goodsVo.imageUrl4 }">
                                        		<p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" 
	                                              		name="upload_img_4" id="upload_img_4" fid="4" alt="img"/>
	                                            	<input type="hidden" name="imageUrl4" id="image_url_4" value=""/>
	                                            </p>
                                        	</c:if>
                                            <c:if test="${!empty goodsVo.imageUrl4 }">
                                        		<p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }${goodsVo.imageUrl4}" 
	                                              		name="upload_img_4" id="upload_img_4" fid="4" alt="img"/>
	                                            	<input type="hidden" name="imageUrl4" id="image_url_4" value="${goodsVo.imageUrl4}"/>
	                                            </p>
                                        	</c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty goodsVo.imageUrl5 }">
                                        		 <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" 
	                                              		name="upload_img_5" id="upload_img_5" fid="5" alt="img"/>
	                                            	<input type="hidden" name="imageUrl5" id="image_url_5" value=""/>
	                                         	</p>
                                        	</c:if>
                                            <c:if test="${!empty goodsVo.imageUrl5 }">
                                        		 <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }${goodsVo.imageUrl5}" 
	                                              		name="upload_img_5" id="upload_img_5" fid="5" alt="img"/>
	                                            	<input type="hidden" name="imageUrl5" id="image_url_5" value="${goodsVo.imageUrl5}"/>
	                                         	</p>
                                        	</c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                    </div>
                                    <p class="t_999 lh24">1、图片单张大小支持3M以下,超过系统自动压缩</p>
                                    <p class="t_999 lh24">2、建议图片长宽比例1.5</p>
                                    <p class="t_999 lh24">3、自动压缩和宽度调整可能会使图片失真，支持的图片格式：jpg、 jpeg、png</p>
                                </div>
                          </div>
                          <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">商品介绍：</label>
                              <div class="fl">
                                  <textarea id="introduce" class="introduce" name="introduce">${goodsVo.introduce }</textarea>
                              </div>
                          </div>
                          <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4">物流运费：</label>
                              <input type="text" placeholder="填写运费" name="logisticsPrice" class="form_control v_m" value="${goodsVo.logisticsPrice }"/>  
                          </div>
                          <div class="mb20">
                              <label  class="w80 show_inline_block t_r">优惠券：</label>
                              <label class="pr10">
                                  <input type="radio" name="isCoupons" value="${Constants_YES }" <c:if test="${empty goodsVo.isCoupons or goodsVo.isCoupons eq Constants_YES }">checked="checked"</c:if> />可以使用优惠券
                              </label>
                              <label>
                                  <input type="radio" name="isCoupons" value="${Constants_NO }"<c:if test="${!empty goodsVo.isCoupons and goodsVo.isCoupons eq Constants_NO }">checked="checked"</c:if>/>不能使用优惠券  
                              </label>                   
                          </div>
                    </div>
                    <div class="publish_bottom bd_c p20">
                      <input type="button" class="btn btn_blue confrim_modify" value="确认提交"/>
                    </div>
                </form>                  
               </div>	
               <!--info-end-->
          </div>
     </div>
     <%@ include file="/ueditor/ueditor.jsp" %>
     <input type="hidden" id="ratio" value="1.5"/>
     <%@ include file="/upload/comUpload.jsp" %>
</body>
<script type="text/javascript" src="${ctx }/static/web/js/goods/goodsUE.js"></script>
<script type="text/javascript" src="${ctx }/static/web/js/goods/goods_modify_manage.js"></script>
</html>

