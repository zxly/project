package com.gl.club.common.base.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gl.club.common.base.service.NginxDisposeService;
import com.gl.club.common.base.vo.NginxPaths;
import com.gl.club.common.tools.EmptyUtil;

@Service
public class NginxDisposeServiceImpl implements NginxDisposeService {

	
	@Value("${nginx_mogile_path}")
	private String nginxPath;
	
	
	//将fck里面的img src进行替换
	public String replaceImageToNginxPath(String image){
		if(EmptyUtil.isNullOrEmpty(image)){
			return "";
		}
		//可以配置多个nginx 路径
		String[] paths = nginxPath.split(",");
		NginxPaths nginxPaths = new NginxPaths(paths);
		image = image.replaceAll("&lt;", "<");
		image = image.replaceAll("&gt;", ">");
		image = image.replaceAll("<script>", "<pre>&lt;script&gt;");
		image = image.replaceAll("</script>", "&lt;/script&gt;</pre>");
		return image.replaceAll("(<img*?.*?src=[\"|\'])(.*?)", "$1"+nginxPaths+"$2");
	}
	
	@Override
	public String replaceImageToNginxPathMobile(String image){
		if(EmptyUtil.isNullOrEmpty(image)){
			return "";
		}
		//可以配置多个nginx 路径
		String[] paths = nginxPath.split(",");
		NginxPaths nginxPaths = new NginxPaths(paths);
		
		image = image.replaceAll("&lt;", "<");
		image = image.replaceAll("&gt;", ">");
		image = image.replaceAll("<script>", "<pre>&lt;script&gt;");
		image = image.replaceAll("</script>", "&lt;/script&gt;</pre>");
		image = image.replaceAll("(<img*?.*?src=[\"|\'].*?)(\\..*?)", "$1"+"_mobile"+"$2");
		return image.replaceAll("(<img*?.*?src=[\"|\'])(.*?)", "$1"+nginxPaths+"$2");
	}


	@Override
	public String cleanImageTag(String content) {
		return content.replaceAll("<\\s*img\\s+[^>]*?src\\s*=\\s*(\\'|\\\")(.*?)\\1[^>]*?\\/?\\s*>", "");
	}


	@Override
	public NginxPaths getNginxPaths() {
		String[] paths = nginxPath.split(",");
		return new NginxPaths(paths);
	}
	
	
}
