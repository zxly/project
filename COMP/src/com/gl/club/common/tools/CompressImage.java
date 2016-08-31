package com.gl.club.common.tools;

import com.sun.media.jai.codec.ImageEncodeParam;


/**
 * 
 * @author : PJH
 *
 */
public class CompressImage {
	/**
	 * 原图宽度
	 */
	private String iamgeFormat;
	
	/**
	 * 原图宽度
	 */
	private int srcWidth = 100;
	
	/**
	 * 原图高度
	 */
	private int srcHeight = 100;
	
	/**
	 * 压缩后图片宽�?
	 */
	private int destWidth = 100;
	
	/**
	 * 压缩后图片高�?
	 */
	private int destHeight = 100;
	
	/**
	 * 图片剪切的高
	 */
	private int shearHigh = 480;
	
	/**
	 * 图片剪切的宽
	 */
	private int sheraWide = 480;
	
	/**
	 *  图片剪切的边距-高
	 */
	private int marginHigh = 480;
	
	/**
	 *  图片剪切的边距-宽
	 */
	private int marginWide = 480;
	
	/**
	 * 按宽度等比压�?
	 */
	private boolean proportionByWidth = false;
	
	/**
	 * 按高度等比压�?
	 */
	private boolean proportionByHeight = false;
	
	/**
	 * 压缩图片源路径（硬盘地址�?
	 */
	private String srcPath = null;

	/**
	 * 压缩后图片存储路径（硬盘地址�?
	 */
	private String destPath = null;
	
	/**
	 * 用于做图片压缩的参数（不同格式有不同格式对应的子类）
	 */
	private ImageEncodeParam encodeParam = null;

	public String getIamgeFormat() {
		return iamgeFormat;
	}

	public void setIamgeFormat(String iamgeFormat) {
		this.iamgeFormat = iamgeFormat;
	}

	public int getSrcWidth() {
		return srcWidth;
	}

	public void setSrcWidth(int srcWidth) {
		this.srcWidth = srcWidth;
	}

	public int getSrcHeight() {
		return srcHeight;
	}

	public void setSrcHeight(int srcHeight) {
		this.srcHeight = srcHeight;
	}

	public int getDestWidth() {
		return destWidth;
	}

	public void setDestWidth(int destWidth) {
		this.destWidth = destWidth;
	}

	public int getDestHeight() {
		return destHeight;
	}

	public void setDestHeight(int destHeight) {
		this.destHeight = destHeight;
	}

	public int getShearHigh() {
		return shearHigh;
	}

	public void setShearHigh(int shearHigh) {
		this.shearHigh = shearHigh;
	}

	public int getSheraWide() {
		return sheraWide;
	}

	public void setSheraWide(int sheraWide) {
		this.sheraWide = sheraWide;
	}

	public int getMarginHigh() {
		return marginHigh;
	}

	public void setMarginHigh(int marginHigh) {
		this.marginHigh = marginHigh;
	}

	public int getMarginWide() {
		return marginWide;
	}

	public void setMarginWide(int marginWide) {
		this.marginWide = marginWide;
	}

	public boolean isProportionByWidth() {
		return proportionByWidth;
	}

	public void setProportionByWidth(boolean proportionByWidth) {
		this.proportionByWidth = proportionByWidth;
	}

	public boolean isProportionByHeight() {
		return proportionByHeight;
	}

	public void setProportionByHeight(boolean proportionByHeight) {
		this.proportionByHeight = proportionByHeight;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public ImageEncodeParam getEncodeParam() {
		return encodeParam;
	}

	public void setEncodeParam(ImageEncodeParam encodeParam) {
		this.encodeParam = encodeParam;
	}
}
