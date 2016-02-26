package com.ts.common.util;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageZipUtil {

	/**
	 * �ȱ���ѹ��ͼƬ�ļ�<br> �ȱ���ԭ�ļ�����ѹ�����ϴ�
	 * @param oldFile  Ҫ����ѹ�����ļ�
	 * @param newFile  ���ļ�
	 * @param width  ��� //���ÿ��ʱ���߶ȴ���0���ȱ������ţ�
	 * @param height �߶� //���ø߶�ʱ����ȴ���0���ȱ������ţ�
	 * @param quality ���� 0.0 -- 1.0   ԽС��ѹ����ͼ��Ч��Խ��,ͼƬԽС
	 * @return ����ѹ������ļ���ȫ·��
	 */
	public static String zipImageFile(File oldFile,File newFile, int width, int height,
			float quality) {
		if (oldFile == null) {
			return null;
		}
		try {
			/** �Է������ϵ���ʱ�ļ����д��� */
			Image srcFile = ImageIO.read(oldFile);
			int w = srcFile.getWidth(null);
		//	System.out.println(w);
			int h = srcFile.getHeight(null);
		//	System.out.println(h);
			double bili;
			if(width>0){
				bili=width/(double)w;
				height = (int) (h*bili);
			}else{
				if(height>0){
					bili=height/(double)h;
					width = (int) (w*bili);
				}
			}
			/** ��,���趨 */
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
			//String filePrex = oldFile.getName().substring(0, oldFile.getName().indexOf('.'));
			/** ѹ������ļ��� */
			//newImage = filePrex + smallIcon+  oldFile.getName().substring(filePrex.length());

			/** ѹ��֮����ʱ���λ�� */
			FileOutputStream out = new FileOutputStream(newFile);

			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
			/** ѹ������ */
			jep.setQuality(quality, true);
			encoder.encode(tag, jep);
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFile.getAbsolutePath();
	}

	/**
	 * ����ȸ߶�ѹ��ͼƬ�ļ�<br> �ȱ���ԭ�ļ�����ѹ�����ϴ�
	 * @param oldFile  Ҫ����ѹ�����ļ�ȫ·��
	 * @param newFile  ���ļ�
	 * @param width  ���
	 * @param height �߶�
	 * @param quality ����  0.0 -- 1.0   ԽС��ѹ����ͼ��Ч��Խ��,ͼƬԽС
	 * @return ����ѹ������ļ���ȫ·��
	 */
	public static String zipWidthHeightImageFile(File oldFile,File newFile, int width, int height,
			float quality) {
		if (oldFile == null) {
			return null;
		}
		String newImage = null;
		try {
			/** �Է������ϵ���ʱ�ļ����д��� */
			Image srcFile = ImageIO.read(oldFile);
			int w = srcFile.getWidth(null);
		//	System.out.println(w);
			int h = srcFile.getHeight(null);
		//	System.out.println(h);

			/** ��,���趨 */
			BufferedImage tag = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
			//String filePrex = oldFile.substring(0, oldFile.indexOf('.'));
			/** ѹ������ļ��� */
			//newImage = filePrex + smallIcon+ oldFile.substring(filePrex.length());

			/** ѹ��֮����ʱ���λ�� */
			FileOutputStream out = new FileOutputStream(newFile);

			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
			/** ѹ������ */
			jep.setQuality(quality, true);
			encoder.encode(tag, jep);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newImage;
	}

	public static void main(String args[]) throws IOException {
		System.out.println(ImageZipUtil.zipWidthHeightImageFile(new File("E:/c.jpg"),new File("E:/cs.jpg"), 300, 300, 0.75f));
	}
}
