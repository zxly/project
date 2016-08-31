package com.gl.club.common.tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

public class Uploadify extends HttpServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private Logger log=Logger.getLogger(getClass());
	
	/**
	 * 主流图片格式类型
	 */
	private String[] imagesType = new String[]{"jpg","jpeg","png","bmp"};
	
	/**
	 * 返回有效字符串
	 */
	public String getSafeString(String str) {
		if (str == null)
			return "";
		else
			return str.trim();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!EmptyUtil.isNullOrEmpty(request.getParameter("cWidth"))){//pc端剪切图片并上传
			cutImage(request, response);
		}else{
			if(!EmptyUtil.isNullOrEmpty(request.getParameter("file"))){//手机端上传图片并裁剪
				wapUpload(request, response);
			}else{//pc端只上传图片
				upload(request, response);
			}
		}
	}
	
	
	
	/**
	 * 裁剪上传图片
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void cutImage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String mWidth = request.getParameter("mWidth");//左上角相对于图片的X坐标
		String mHeight = request.getParameter("mHeight");
		String cWidth = request.getParameter("cWidth");
		String cHeight = request.getParameter("cHeight");	
		String localImgWidth=request.getParameter("localImgWidth");
		DiskFileItemFactory diskFactory = new DiskFileItemFactory();  
		//获取上传文件列表
		Map<String, Object> json = new HashMap<String,Object>();
		try {
			ServletFileUpload upload = new ServletFileUpload(diskFactory);
			List<FileItem> fileList = null;
			try {
				fileList = upload.parseRequest(request);
			} catch (FileUploadException ex) {
				ex.printStackTrace();
				return;
			}
			//创建临时文件夹
			String contentPath = this.getServletContext().getRealPath("/");
			String tempFilePath = contentPath+File.separator+"tempfile"+File.separator;
			File tempDir = new File(tempFilePath);
			if(!tempDir.exists()){
				tempDir.mkdir();
			}
			Iterator<FileItem> it = fileList.iterator();
			String originalName = "";
			Integer size = 0;				
			it = fileList.iterator();
			while (it.hasNext()) {
				FileItem item = it.next();
				if (!item.isFormField()) {
					originalName = item.getName();//原文件名
					String random = UUID.randomUUID().toString();//uuid 生成 新文件名称
					String extName = this.getExtName(originalName);
					size = Integer.parseInt(Long.valueOf(item.getSize()).toString());
					if (originalName == null || "".equals(originalName.trim()) || size == 0)
						continue;
					String domain = "files";
					if(this.isImages(extName.toLowerCase())){
						domain = "images";
					}
					String fileKey=random + "." + extName;
					File file = new File(tempFilePath +fileKey );
					try {
						if("images".equals(domain)){
							try{
								JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(item.getInputStream());  
								BufferedImage image = decoder.decodeAsBufferedImage();  
								ImageIO.write(image, "JPEG", file);						
							}catch (Exception e) {
								item.write(file);
							}
						}else{
							item.write(file);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				
					BufferedImage image = ImageIO.read(file);
					if(image.getWidth()>0) {				//原图大小					
						int bakWidth = image.getWidth();				
						Double rate = bakWidth/Double.parseDouble(localImgWidth);//原图和页面图的比例关系
						int marginLeft = (int)(rate * (Integer.parseInt(mWidth)));
						int marginTop = (int)(rate * (Integer.parseInt(mHeight)));
						
						int picWidth = (int)(rate * (Integer.parseInt(cWidth)));
						int picHeight = (int)(rate * (Integer.parseInt(cHeight)));
						String ran = UUID.randomUUID().toString();//uuid 生成 新文件名称
						CompressImage compress = new CompressImage();
						compress.setSrcPath(tempFilePath+fileKey);//压缩图片源路径（硬盘地址）
						compress.setMarginWide(marginLeft);//图片剪切的边距-宽
						compress.setMarginHigh(marginTop);//图片剪切的边距-高
						String tempPath = contentPath+File.separator+"tempfile"+File.separator+"images"+File.separator;
						File tempImages = new File(tempPath);
						if(!tempImages.exists()){
							tempImages.mkdir();
						}
						String imagePath=tempPath+ran + "." + extName;
						compress.setDestPath(imagePath);//压缩后图片存储路径（硬盘地址)
						compress.setSheraWide(picWidth);//图片剪切的宽
						compress.setShearHigh(picHeight);// 图片剪切的高
						//对图片进行压缩剪切					
						ImageHandleUtil.shearAndCompressionImage(compress);
						File f = new File(imagePath);
						if("images".equals(domain)){
							BufferedImage bufferedImage  = ImageIO.read(f);
							bufferedImage.flush();
						}
						json.put("success",true);
						json.put("nginxLink", imagePath.replace(contentPath, ""));	
						image.flush();
						//f.delete();
				     }		
				}
			}
		} catch (Exception e) {
			log.error("---cutImage图片localImgWidth："+localImgWidth+"--cHeight:"+cHeight+"--cWidth:"+cWidth+"--mHeight:"+mHeight+"--mWidth:"+mWidth);
			e.printStackTrace();
			json.put("success",false);
		}
		this.writeJsonData(json, response);
	}
	
	/**
	 * 上传图片
	 */
	public void upload(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		Map<String,Object> json = new HashMap<String, Object>();
		String preview=request.getParameter("preview");
		DiskFileItemFactory diskFactory = new DiskFileItemFactory();  
		// threshold 极限、临界值，即硬盘缓存 1M  
		//diskFactory.setSizeThreshold(4 * 1024);  
		
		//获取上传文件列表
		try {
			ServletFileUpload upload = new ServletFileUpload(diskFactory);
			List<FileItem> fileList = null;
			try {
				fileList = upload.parseRequest(request);
			} catch (FileUploadException ex) {
				ex.printStackTrace();
				return;
			}
			//创建临时文件夹
			String contentPath = this.getServletContext().getRealPath("/");
			String tempFilePath = contentPath+File.separator+"tempfile"+File.separator;
			File tempDir = new File(tempFilePath);
			if(!tempDir.exists()){
				tempDir.mkdir();
			}
			Iterator<FileItem> it = fileList.iterator();
			String originalName = "";
			Integer size = 0;
			String realPath="";
			while (it.hasNext()) {
				FileItem item = it.next();
				if (!item.isFormField()) {
					originalName = item.getName();//原文件名
					String random = UUID.randomUUID().toString();//uuid 生成 新文件名称
					String extName = this.getExtName(originalName);
					size=Integer.parseInt(Long.valueOf(item.getSize()).toString());
					if (originalName == null || "".equals(originalName.trim()) || size == 0)
						continue;
					String domain = "files";
					if(this.isImages(extName.toLowerCase())){
						domain = "images";
					}
					realPath=tempFilePath + random + "." + extName;
					File file = new File(realPath);
					try {
						if("images".equals(domain)){
							try{
								JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(item.getInputStream());  
								BufferedImage image = decoder.decodeAsBufferedImage();  
								ImageIO.write(image, "JPEG", file);
							
							}catch (Exception e) {
								item.write(file);
							}
						}else{
							item.write(file);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}				
						json.put("success",true);
						json.put("nginxLink", realPath);
						json.put("preview", preview);
				}
			}
		} catch (Exception e) {
			log.error("upload图片上传");
			e.printStackTrace();
			json.put("success",false);
		}
		this.writeJsonData(json, response);
	}
	
	/**
	 * 手机端上传图片
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void wapUpload(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		        Map<String,Object> json = new HashMap<String, Object>();
		        //获取原文件名
		        String imgName = request.getParameter("file");
				String contentPath = this.getServletContext().getRealPath("/");
				String tempFilePath = contentPath+File.separator+"tempfile"+File.separator+imgName;
				File file =null;
				//生成file对象
		        try {
					file = new File(tempFilePath);	
					if(file.exists()){
						BufferedImage image = ImageIO.read(file);
						String extName=imgName.substring(imgName.lastIndexOf(".")+1);
						if(image.getWidth()>0) {	
							int marginLeft = Integer.parseInt(request.getParameter("x"));//x轴
							int marginTop  = Integer.parseInt(request.getParameter("y"));	//y轴					
							int picWidth   = Integer.parseInt(request.getParameter("width"));//裁剪的宽
							int picHeight  = Integer.parseInt(request.getParameter("height"));//裁剪的高
							String ran = UUID.randomUUID().toString();//uuid 生成 新文件名称
							CompressImage compress = new CompressImage();
							compress.setSrcPath(tempFilePath);//压缩图片源路径（硬盘地址）
							compress.setMarginWide(marginLeft);//图片剪切的边距-宽
							compress.setMarginHigh(marginTop);//图片剪切的边距-高
							String tempPath = contentPath+File.separator+"tempfile"+File.separator+"images"+File.separator;
							File tempImages = new File(tempPath);
							if(!tempImages.exists()){
								tempImages.mkdir();
							}
							String imagePath=tempPath+ran + "." + extName;
							compress.setDestPath(imagePath);//压缩后图片存储路径（硬盘地址)
							compress.setSheraWide(picWidth);//图片剪切的宽
							compress.setShearHigh(picHeight);// 图片剪切的高
							//对图片进行压缩剪切					
							ImageHandleUtil.shearAndCompressionImage(compress);
							File f = new File(imagePath);
							json.put("success",true);
							json.put("nginxLink", imagePath);	
							image.flush();
							f.delete();
					     }	
						
					}else{
						json.put("success",false);
					}
				} catch (Exception e) {
					log.error("-----------------------------------------wapUpload图片是否存在："+file.exists());
					e.printStackTrace();
					json.put("success",false);
				}	
		        this.writeJsonData(json, response);
	}
	public void writeJsonData(Object data, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			if (data instanceof Map) {
				response.getWriter().print(JSONObject.fromObject(data));
			} else if (data instanceof List) {
				JSONArray array = JSONArray.fromObject(((List<?>) data).toArray());
				response.getWriter().print(array);
			} else {
				response.getWriter().print(JSONObject.fromObject(data));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * isImages(这里用一句话描述这个方法的作用)
	 * @Title: isImages
	 * @Description: 根据文件后缀名判断文件是否为图片类型
	 * @param extName
	 * @return  传人参数
	 * @throws
	 */
	private boolean isImages(String extName) {
		for(int i=0;i<imagesType.length;i++){
			if(extName.equals(imagesType[i])){
				return true;
			}
		}
		return false;
	}

	public void init() throws ServletException {
		// Put your code here
	}
	
	//获取文件扩展名
	private String getExtName(String fileName){
		if(fileName.lastIndexOf(".") == -1){ //没扩展名
			return "";
		}
		return fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
	}

}
