package com.gl.club.common.tools;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;
import com.sun.media.jai.codec.BMPEncodeParam;
import com.sun.media.jai.codec.ImageEncodeParam;
import com.sun.media.jai.codec.JPEGEncodeParam;
import com.sun.media.jai.codec.PNGEncodeParam;
import com.sun.media.jai.codec.TIFFEncodeParam;
import com.sun.media.jai.codecimpl.JPEGCodec;
import com.sun.media.jai.codecimpl.JPEGImageEncoder;
import com.sun.media.jai.codecimpl.PNGCodec;
import com.sun.media.jai.codecimpl.PNGImageEncoder;

public class ImageHandleUtil {
	private static Logger log=Logger.getLogger(ImageHandleUtil.class);
	public final static String PNG = "png";
	public final static String JPG = "jpg";
	
	/**
	 * 获取图片格式
	 * @param file
	 *            图片文件
	 * @return 图片格式
	 */
	public static String getImageFormatName(File file) throws IOException {
		String formatName = null;

		ImageInputStream iis = ImageIO.createImageInputStream(file);
		Iterator<ImageReader> imageReader = ImageIO.getImageReaders(iis);
		if (imageReader.hasNext()) {
			ImageReader reader = imageReader.next();
			formatName = reader.getFormatName();
		}
		iis.close();
		return formatName;
	}
	
	/**
	 * 通过 图片的宽、高  。 校验图片是否合法
	 * @param file
	 * @return
	 */
	public static boolean isImage(File file){
        CompressImage compressImage = new CompressImage();
        try {
            BufferedImage image = ImageIO.read(file);
            if (image != null) {
                compressImage.setSrcWidth(image.getWidth());
                compressImage.setSrcHeight(image.getHeight());
            }
            return true;
        } catch (IOException e) {
        	file.delete();
        	return false;
        }
	}
	
	/**
	 * 剪切并压缩图片
	 * @param compressImg 需要参数:边距宽高、剪切宽高、 图片源路径、目标路径
	 * @throws IOException
	 */
	public static void shearAndCompressionImage(CompressImage compressImg) throws IOException{
		// 剪切图片
		boolean flag = cutImage(compressImg.getSrcPath(), compressImg.getDestPath() , false, 
				compressImg.getMarginWide() , compressImg.getMarginHigh(), // 具边距
				compressImg.getSheraWide(), compressImg.getShearHigh());// 剪切的宽高
		
		//剪切图片是否成功
		if(flag){
			File newFile = new File(compressImg.getDestPath());
			
			String flag_type = isSpecifiedFormat(newFile);
			
			//当图片格式不为 jpg 或者 png 时，删除并停止操作
			if(flag_type == null){
				newFile.delete();
				return ;
			}
			
			//压缩图片
			if(newFile.length() > 1024 * 300 ){
				//获取图片宽高   长度为2  0角标为宽   1角标为高
				int[] infos = ImageHandleUtil.getWideHigh(newFile);
				
				//压缩图片
				compressImg.setSrcPath( compressImg.getDestPath() );//源路径
				compressImg.setSrcWidth(infos[0]);
				compressImg.setSrcHeight(infos[1]);
				
				compressImg.setDestPath( compressImg.getDestPath() );//目标路径
				compressImg.setDestWidth(infos[0] / 4);
				compressImg.setDestHeight(infos[1] / 4);
				
				compressImg.setProportionByHeight(true);
				compressImg.setProportionByWidth(true);
				
				ImageHandleUtil.compressImage(compressImg , flag_type);
			}
		}
	}
	
	/**
	 * 判断图片是否为 jpg 或者 png 格式
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public static String isSpecifiedFormat(File file) throws IOException{
		 String imgType = getImageFormatName( file );
		
		//判断图片类型
		boolean img_flag = false;
		img_flag = "jpg".equalsIgnoreCase(imgType) || "jpeg".equalsIgnoreCase(imgType); 
		
		//当类型为 jpg 时,不判断png格式
		if(img_flag)
			return ImageHandleUtil.JPG;
			
		if("png".equalsIgnoreCase(imgType))
			return ImageHandleUtil.PNG;
		
		return null;
	}
	
	/**
	 * 获取图片的宽和高
	 * @param file
	 * @return int[] 长度为2  0角标为宽   1角标为高
	 */
	public static int[] getWideHigh(File file){
		try {
			int[] imgInfo = new int[2]; 
			
			BufferedImage image = ImageIO.read(file);
			
			imgInfo[0] = image.getWidth();
			imgInfo[1] = image.getHeight();
			
			return imgInfo;
		} catch (IOException e) {
			return null;
		}
	}
	
	/**
	 * 将图片存储到硬盘中
	 * @param uploadFile 
	 * @param newFile 存储路径
	 */
	public static void writePic(MultipartFile uploadFile , File newFile) {
    	InputStream ips = null;
    	FileOutputStream fis = null;
    	try {
    		// 读入原文件
    		ips = uploadFile.getInputStream();
    		fis = new FileOutputStream(newFile);
    		
    		byte[] bytes = new byte[2048];
    		for(int index = 0 ; (index = ips.read(bytes)) != -1 ; ){
    			fis.write(bytes, 0, index);//写入
    			fis.flush();//刷新
    		}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ips != null) { ips.close();}
				if(fis != null) { fis.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @description : 剪切图片
	 * @param srcPath �?图片源路径(硬盘地址)
	 * @param cutFilePath : 剪切后图片地�?��硬盘地址�?
	 * @param keepSrc : 剪切后是否保存原�?
	 * @param fromLeft : 剪切图片的�?择框左上角距左像素�?
	 * @param fromTop �?剪切图片的�?择框左上角距顶部像素�?
	 * @param width �?图片剪切后宽�?
	 * @param height : 图片剪切后高�?
	 * @return
	 * @throws IOException
	 */
	public static boolean cutImage(CompressImage compressImage ,  boolean keepSrc )throws IOException {   
		String srcPath = compressImage.getSrcPath();
		String destPath = compressImage.getDestPath();
		int marginWide = compressImage.getMarginWide();
		int marginHigh = compressImage.getMarginHigh();
		int sheraWide = compressImage.getSheraWide();
		int shearHigh = compressImage.getShearHigh();
		
		return cutImage(srcPath , destPath , keepSrc , marginWide, marginHigh , sheraWide , shearHigh);
	}
	
	/**
	 * @description : 剪切图片
	 * @param srcPath �?图片源路径(硬盘地址)
	 * @param cutFilePath : 剪切后图片地�?��硬盘地址�?
	 * @param keepSrc : 剪切后是否保存原�?
	 * @param fromLeft : 剪切图片的�?择框左上角距左像素�?
	 * @param fromTop �?剪切图片的�?择框左上角距顶部像素�?
	 * @param width �?图片剪切后宽�?
	 * @param height : 图片剪切后高�?
	 * @return
	 * @throws IOException
	 */
	public static boolean cutImage(String srcPath, String cutFilePath,boolean keepSrc,int fromLeft, int fromTop,int width, int height)throws IOException {   
	    // 保存裁剪后的图片    
		boolean flag=false;
		String fileSufix="";
		boolean isexist=false;
		int orgWith=0;
		int orgHeight=0;
		try {
			File srcFile = new File(srcPath);    
			BufferedImage image = ImageIO.read(srcFile);
			orgWith=image.getWidth();
			orgHeight=image.getHeight();
			// 保存缩放后的图片   
			fileSufix = srcFile.getName().substring(srcFile.getName().lastIndexOf(".") + 1);       
			File destFile = new File(cutFilePath);
			isexist=destFile.exists();
			if(!keepSrc){
				//如果传入的是否剪切参数为不保存原图片，则此处删除原图
				if (srcFile.isFile() && srcFile.exists()) {  
					System.out.println(srcFile.delete());  
				}  
			}
			System.out.println("原图的宽:"+orgWith+"原图高:"+orgHeight+"--x:"+fromLeft+"--y:"+fromTop+"--裁剪后width:"+width+"--裁剪后height:"+height+"--destFile:"+isexist);
			flag = ImageIO.write(image.getSubimage( fromLeft, fromTop, width, height), fileSufix, destFile);
		} catch (Exception e) {
			log.error("原图的宽:"+orgWith+"原图高:"+orgHeight+"--x:"+fromLeft+"--y:"+fromTop+"--裁剪后width:"+width+"--裁剪后height:"+height+"--destFile:"+isexist);
			e.printStackTrace();
		}    
	    return flag;
	}
	
	/**
	 * @description : 压缩图片，只能压缩 jpg格式图片
	 * @param args
	 */
	public static boolean compressImage(CompressImage compressImg) throws IOException{
		String srcPath = compressImg.getSrcPath();
		String imageFormat = getImageFormat(srcPath);
		String destPath = compressImg.getDestPath();
		int srcWidth = compressImg.getSrcWidth();
		int srcHeight = compressImg.getSrcHeight();
		int destWidth = compressImg.getDestWidth();
		int destHeight = compressImg.getDestHeight();
		boolean proportionByWidth = compressImg.isProportionByWidth();
		boolean proportionByHeight = compressImg.isProportionByHeight();
		ImageEncodeParam encodeParam = compressImg.getEncodeParam();
		try {			
			File srcFile = new File(srcPath);
			if (!srcFile.exists()) {
				return false;
			}
			BufferedImage img = ImageIO.read(srcFile);
			if (img == null) {
				//图片为空的时�?
				return false;
			}else{
				//判断对象为空的时�?
				if (img.getWidth(null) == -1) {
					return false;
				}else if(!checkImageFormat(imageFormat)){
					return false;
				}else {
					/********************************************此处为图片满足压缩条件，进行压缩操作***************************************/
					encodeParam = initImageEncodeParam(imageFormat);
					if (proportionByWidth) {
						//按宽度等比压�?
						double rate = (float)destWidth / srcWidth;
						destHeight = (int) (srcHeight * rate);
					} else if(proportionByHeight){
						//按高度等比压�?
						double rate = (float)destHeight / srcHeight;
						destWidth = (int) (srcWidth * rate);
					}else{
						//非等比压缩，即以用户输入的数值进行压缩，或�?未输入数值则�?00*100压缩
						if(destHeight == 0){
							destHeight = 100;
						}
						if(destWidth == 0){
							destWidth = 100;
						}
					}
					BufferedImage tag = new BufferedImage((int) destWidth,(int) destHeight, BufferedImage.TYPE_INT_RGB);
					/*
					 * Image.SCALE_SMOOTH 的缩略算�?生成缩略图片的平滑度�?优先级比速度�?生成的图片质量比较好
					 * 但�?度慢
					 */
					tag.getGraphics().drawImage(img.getScaledInstance(destWidth, destHeight,Image.SCALE_SMOOTH), 0, 0, null);
					FileOutputStream out = new FileOutputStream(destPath);
					JPEGImageEncoder encoder = (JPEGImageEncoder) JPEGCodec.createImageEncoder(getImageType(imageFormat), out, encodeParam);
					
					encoder.encode(tag);
					out.close();
					return true;
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("图片压缩出现错误!!!");
			return false;
		}
	}
	
	/**
	 * @description : 压缩图片
	 * @param args
	 */
	public static boolean compressImage(CompressImage compressImg , String type) throws IOException{
		String srcPath = compressImg.getSrcPath();
		String imageFormat = getImageFormat(srcPath);
		String destPath = compressImg.getDestPath();
		int srcWidth = compressImg.getSrcWidth();
		int srcHeight = compressImg.getSrcHeight();
		int destWidth = compressImg.getDestWidth();
		int destHeight = compressImg.getDestHeight();
		boolean proportionByWidth = compressImg.isProportionByWidth();
		boolean proportionByHeight = compressImg.isProportionByHeight();
		ImageEncodeParam encodeParam = compressImg.getEncodeParam();
		try {			
			File srcFile = new File(srcPath);
			if (!srcFile.exists()) {
				return false;
			}
			BufferedImage img = ImageIO.read(srcFile);
			if (img == null) {
				//图片为空的时�?
				return false;
			}else{
				//判断对象为空的时�?
				if (img.getWidth(null) == -1) {
					return false;
				}else if(!checkImageFormat(imageFormat)){
					return false;
				}else {
					/********************************************此处为图片满足压缩条件，进行压缩操作***************************************/
					encodeParam = initImageEncodeParam(imageFormat);
					if (proportionByWidth) {
						//按宽度等比压�?
						double rate = (float)destWidth / srcWidth;
						destHeight = (int) (srcHeight * rate);
					} else if(proportionByHeight){
						//按高度等比压�?
						double rate = (float)destHeight / srcHeight;
						destWidth = (int) (srcWidth * rate);
					}else{
						//非等比压缩，即以用户输入的数值进行压缩，或�?未输入数值则�?00*100压缩
						if(destHeight == 0){
							destHeight = 100;
						}
						if(destWidth == 0){
							destWidth = 100;
						}
					}
					BufferedImage tag = new BufferedImage((int) destWidth,(int) destHeight, BufferedImage.TYPE_INT_RGB);
					/*
					 * Image.SCALE_SMOOTH 的缩略算�?生成缩略图片的平滑度�?优先级比速度�?生成的图片质量比较好
					 * 但�?度慢
					 */
					tag.getGraphics().drawImage(img.getScaledInstance(destWidth, destHeight,Image.SCALE_SMOOTH), 0, 0, null);
					FileOutputStream out = new FileOutputStream(destPath);
					if(type.equals(ImageHandleUtil.JPG)){
						JPEGImageEncoder encoder = (JPEGImageEncoder) JPEGCodec.createImageEncoder(getImageType(imageFormat), out, encodeParam);
						encoder.encode(tag);
						out.close();
						return true;
					}else if(type.equals(ImageHandleUtil.PNG)){
						PNGImageEncoder encoder = (PNGImageEncoder)PNGCodec.createImageEncoder(getImageType(imageFormat), out, encodeParam);
						encoder.encode(tag);
						out.close();
						return true;
					}
					
					return false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("图片压缩出现错误!!!");
			return false;
		}
	}
	
	/**
	 * 在指定目录下创建时间目录并返回
	 * 格式：yyyy/MM/dd/yyyyMMddhhmmssSSSS999_时间戳.格式
	 * @param sourceFileName 文件名
	 * @param path 存储路径
	 * @return
	 */
    public static String getFilePath(String sourceFileName , String path) {
 
    	 String baseFolder = path + "/" + "images";
         Date nowDate = new Date();
         // yyyy/MM/dd
         DateTime dateTime = new DateTime();
         String fileFolder = baseFolder + File.separator + new DateTime(nowDate).toString("yyyy")
                 + File.separator + new DateTime(nowDate).toString("MM") + File.separator
                 + new DateTime(nowDate).toString("dd");// 需要引入 joda-time 
         File file = new File(fileFolder);
         if (!file.isDirectory()) {
             // 如果目录不存在，则创建目录
             file.mkdirs();
         }
         // 生成新的文件名
         String fileName = new DateTime(nowDate).toString("yyyyMMddhhmmssSSSS")
                 + RandomUtils.nextInt(9999) + "." + StringUtils.substringAfterLast(sourceFileName, ".");
         return fileFolder + File.separator + fileName.replace(".",  "_" + System.currentTimeMillis() + ".")  ;
    }
	
    /**
	 * 该方法用于获取当前时间
	 * @return
	 */
	public static Timestamp getCurrentTime(){
		return new Timestamp(new Date().getTime());
	}
    
	/**************************************************************私有方法部分***************************************************************/
	/**
	 * @description : 获取传入图片的格�?
	 * @author : PJH
	 * @param srcPath : 图片路径
	 * @date : 2015-01-19
	 * @return
	 */
	private static String getImageFormat(String srcPath){
		String result = "";
		if(srcPath == null || srcPath.equals("")){
			return result;
		}
		int imageTypeFlag = srcPath.lastIndexOf('.');
		if (imageTypeFlag == -1 || imageTypeFlag == srcPath.length() - 1){
			return result;
		}else{
			result = srcPath.substring(imageTypeFlag + 1).toLowerCase();
		}
		return result;
	}
	
	/**
	 * @description : 判断传入格式是否符合要求[jpg,jpeg,tiff,tif,bmp,png]
	 * @author : PJH
	 * @param srcPath : 图片路径
	 * @date : 2015-01-19
	 * @return
	 */
	private static boolean checkImageFormat(String imageFormat){
		if(imageFormat.equals("jpg") || imageFormat.equals("jpeg") ||
				imageFormat.equals("tiff") || imageFormat.equals("tif") 
				|| imageFormat.equals("bmp") || imageFormat.equals("png")){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @description : 通过图片格式初始化压缩图片的对应�?
	 * @author : PJH
	 * @param srcPath : 图片路径
	 * @date : 2015-01-21
	 * @return
	 */
	private static ImageEncodeParam initImageEncodeParam(String imageFormat){
		ImageEncodeParam result = null;
		if (imageFormat.equals("jpeg") || imageFormat.equals("jpg")) {
			result = new JPEGEncodeParam();
			((JPEGEncodeParam) result).setQuality(1F);
		} else if (imageFormat.equals("tiff") || imageFormat.equals("tif")) {
			result = new TIFFEncodeParam();
			((TIFFEncodeParam) result).setCompression(TIFFEncodeParam.COMPRESSION_NONE);
		} else if (imageFormat.equals("bmp")) {
			result = new BMPEncodeParam();
		} else if (imageFormat.equals("png")) {
			result = new PNGEncodeParam.Palette();
			((PNGEncodeParam.Palette) result).setBitDepth(2);
		} 
		return result;
	}
	
	/**
	 * @description : 通过图片格式得到图片对应的类�?
	 * @author : PJH
	 * @param srcPath : 图片路径
	 * @date : 2015-01-21
	 * @return
	 */
	private static String getImageType(String imageFormat){
		String result = "";
		if (imageFormat.equals("jpeg") || imageFormat.equals("jpg")) {
			result = "JPEG";
		} else if (imageFormat.equals("tiff") || imageFormat.equals("tif")) {
			result = "TIFF";
		} else if (imageFormat.equals("bmp")) {
			result ="BMP";
		} else if (imageFormat.equals("png")) {
			result = "PNG";
		} 
		return result;
	}
	
	public static void main(String[] args) {
		/*try {
		    //剪切
			System.out.println(ImageHandleUtil.cutImage("E:\\小Q截图-20150506095250.png", "E:\\1.jpg", true, 0, 0, 100, 100));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		/*try {
		    //压缩
			CompressImage compressImage = new CompressImage();
			compressImage.setSrcPath("E:\\compressImageTest\\test_cut.jpg");
			compressImage.setSrcWidth(100);
			compressImage.setSrcHeight(100);
			
			compressImage.setDestPath("E:\\compressImageTest\\test_compress.jpg");
			compressImage.setDestHeight(50);
			compressImage.setProportionByHeight(true);
			System.out.println(ImageHandleUtil.compressImage(compressImage));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*    try {
			 //剪切并压缩
			CompressImage compress = new CompressImage();
			
			compress.setSrcPath("E://小Q截图-20150506095250.png");
			compress.setMarginWide(0);
			compress.setMarginHigh(0);
			
			compress.setDestPath("E://2.png");
			compress.setSheraWide(1024);
			compress.setShearHigh(800);
			
			shearAndCompressionImage(compress);
		} catch (Exception e) {
		}*/
		 
	}
}
