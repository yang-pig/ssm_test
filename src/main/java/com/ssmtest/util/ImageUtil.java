package com.ssmtest.util;

import java.io.File;
import java.io.IOException;


import com.ssmtest.entity.ImageHolder;
import net.coobird.thumbnailator.Thumbnails;


public class ImageUtil {
	
	
	public static String generateThumbnail(ImageHolder thumbnail, String targetAddr) {
		String realFileName = PathUtil.getRandomFileName();
		String extension = getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage())
			.size(200, 200).outputQuality(0.25f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}
	
	
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}
	
	
	
	public static String generateNormalImgs(ImageHolder thumbnail, String targetAddr) {
		String realFileName = PathUtil.getRandomFileName();
		String extension = getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage()).size(600, 300).outputQuality(0.5f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}



	
	private static String getFileExtension(String FileName) {
		return FileName.substring(FileName.lastIndexOf("."));
		
		
	}


}
