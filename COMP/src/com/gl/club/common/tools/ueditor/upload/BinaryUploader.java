package com.gl.club.common.tools.ueditor.upload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;
import org.json.JSONObject;

import com.gl.club.common.tools.SpringContextUtils;
import com.gl.club.common.tools.ueditor.PathFormat;
import com.gl.club.common.tools.ueditor.define.AppInfo;
import com.gl.club.common.tools.ueditor.define.BaseState;
import com.gl.club.common.tools.ueditor.define.FileType;
import com.gl.club.common.tools.ueditor.define.State;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.xml.internal.ws.api.message.Attachment;

public class BinaryUploader {

	/**
	 * 主流图片格式类型
	 */
	private static String[] imagesType = new String[]{"gif","jpg","jpeg","png","bmp"};
	
	public static final State saveNew(HttpServletRequest request,
			Map<String, Object> conf) {
		
		String fileKey = (String)request.getAttribute("fileKey");
		System.out.println("fileKey==="+fileKey);
		String fileType = "";
		
		//AttachmentService attachmentService = SpringContextUtils.getBean("attachmentServiceImp");
		
		DiskFileItemFactory diskFactory = new DiskFileItemFactory();  
		// threshold 极限、临界值，即硬盘缓存 1M  
		//diskFactory.setSizeThreshold(4 * 1024);  
		
		//获取上传文件列表
		ServletFileUpload upload = new ServletFileUpload(diskFactory);
		List<FileItem> fileList = null;
		try {
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			ex.printStackTrace();
		}
		//创建临时文件夹
		@SuppressWarnings("deprecation")
		String contentPath = request.getRealPath("/");
		String tempFilePath = contentPath+File.separator+"tempfile"+File.separator;
		System.out.println(contentPath+"-------------------------------------"+tempFilePath);
		File tempDir = new File(tempFilePath);
		if(!tempDir.exists()){
			tempDir.mkdir();
		}
		Iterator<FileItem> it = fileList.iterator();
		
		while (it.hasNext()) {
			FileItem item = it.next();
			if (item.isFormField()) {
				if("fileType".equals(item.getFieldName())){
					fileType= getSafeString(item.getString());
					
				}
			}
		}
		
		String originalName = "";
		Long size = 0l;
 
		JSONArray array = new JSONArray();
		it = fileList.iterator();
		while (it.hasNext()) {
			FileItem item = it.next();
			if (!item.isFormField()) {
				originalName = item.getName();//原文件名
				String random = UUID.randomUUID().toString();//uuid 生成 新文件名称
				String extName = getExtName(originalName);
				size = item.getSize();
				if (originalName == null || "".equals(originalName.trim()) || size == 0)
					continue;
				String domain = "files";
				if(isImages(extName.toLowerCase())){
					domain = "images";
				}
				File file = new File(tempFilePath + random + "." + extName);
				try {
//					item.write(file);
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
				
				//文件写入分布式缓存服务器
				//Attachment attachment = initAttachment(originalName,extName,size,domain,fileType,relateBillId,attachmentType,random);
				if("images".equals(domain)){
					try {
						ImageIO.read(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				JSONObject json = new JSONObject();
				json.put("nginxLink", tempFilePath + random + "." + extName);
				json.put("originalName", originalName);
				array.put(json);
				State state = new BaseState(true);
				state.putInfo( "size", size );
				state.putInfo( "title", originalName);
				state.putInfo( "url",new StringBuffer("/tempfile/").append(random).append(".").append(extName).toString());
				state.putInfo( "type", fileType);
				state.putInfo( "original", originalName);
				
				//file.delete();
				
				return state;
				
			}
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}
	
	//获取文件扩展名
	private static String getExtName(String fileName){
		if(fileName.lastIndexOf(".") == -1){ //没扩展名
			return "";
		}
		return fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
	}
	
	/***
	 * 
	 * <b>方法名：</b>：isImages<br>
	 * <b>功能说明：</b>：判断是否是图片<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-8 下午12:05:42
	 * @param extName
	 * @return
	 */
	private static boolean isImages(String extName) {
		for(int i=0;i<imagesType.length;i++){
			if(extName.equals(imagesType[i])){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 返回有效字符串
	 */
	public static String getSafeString(String str) {
		if (str == null)
			return "";
		else
			return str.trim();
	}
	
	
	public static final State save(HttpServletRequest request,
			Map<String, Object> conf) {
		FileItemStream fileStream = null;
		boolean isAjaxUpload = request.getHeader( "X_Requested_With" ) != null;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
		}

		ServletFileUpload upload = new ServletFileUpload(
				new DiskFileItemFactory());

        if ( isAjaxUpload ) {
            upload.setHeaderEncoding( "UTF-8" );
        }

		try {
			FileItemIterator iterator = upload.getItemIterator(request);

			while (iterator.hasNext()) {
				fileStream = iterator.next();

				if (!fileStream.isFormField())
					break;
				fileStream = null;
			}

			if (fileStream == null) {
				return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			}

			String savePath = (String) conf.get("savePath");
			String originFileName = fileStream.getName();
			String suffix = FileType.getSuffixByFilename(originFileName);

			originFileName = originFileName.substring(0,
					originFileName.length() - suffix.length());
			savePath = savePath + suffix;

			long maxSize = ((Long) conf.get("maxSize")).longValue();

			if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
				return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
			}

			savePath = PathFormat.parse(savePath, originFileName);

			String physicalPath = (String) conf.get("rootPath") + savePath;

			InputStream is = fileStream.openStream();
			State storageState = StorageManager.saveFileByInputStream(is,
					physicalPath, maxSize);
			is.close();
			
			if (storageState.isSuccess()) {
				storageState.putInfo("url", PathFormat.format(savePath));
				storageState.putInfo("type", suffix);
				storageState.putInfo("original", originFileName + suffix);
			}

			return storageState;
		} catch (FileUploadException e) {
			return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
		} catch (IOException e) {
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
	
}
