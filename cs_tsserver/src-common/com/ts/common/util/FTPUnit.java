package com.ts.common.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.enterprisedt.net.ftp.FileTransferClient;
import com.enterprisedt.net.ftp.FileTransferInputStream;
import com.enterprisedt.net.ftp.FileTransferOutputStream;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * FTP
 * 
 * @author Administrator
 * 
 */
public class FTPUnit {
	
	public static final SimpleDateFormat YMDHMS_SDFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * ��ʼ������
	 * @param url FTP�����IP��ַ  �磬192.168.1.254
	 * @param port FTP����˶˿�  �磬21
	 * @param username �û���
	 * @param password ����
	 * @return
	 * @throws Exception
	 */
	public static FileTransferClient getFileTransferClient(String url,Integer port,String username,String password) throws Exception {
		FileTransferClient ftp = new FileTransferClient();
		ftp.setRemoteHost(url);
		ftp.setRemotePort(port);
		ftp.setUserName(username);
		ftp.setPassword(password);
		ftp.getAdvancedSettings().setControlEncoding("UTF-8");
		ftp.getAdvancedFTPSettings().setConnectMode(FTPConnectMode.PASV);// ����ģʽ����������ɿͻ��˷���
		ftp.setContentType(FTPTransferType.BINARY); // BINARYģʽ�������Ϳ�ִ���ļ�,ѹ���ļ�,��ͼƬ�ļ�.
		ftp.connect();
		return ftp;
	}
	
	/**
	 * �ر�FTP
	 */
	public static void closeFileTransferClient(FileTransferClient ftp)throws Exception{
		if(ftp!=null && ftp.isConnected()){
			ftp.disconnect();
		}
	}

	/**
	 * �ϴ������ļ�
	 * @param localFilePath �����ļ�·��
	 * @param remoteFilePath Զ�̴��·��
	 * @param folderPath ����ļ���·�� /����/����/����ƴ��/��/��/��/
	 */
	public static void upload(String localFilePath, String remoteFilePath,String folderPath,FileTransferClient ftp) throws Exception {
		createDirectory(ftp, folderPath);
		ftp.uploadFile(localFilePath, remoteFilePath);
	}
	
	/**
	 * �ϴ������ļ�
	 * @param file �ļ�
	 * @param remoteFilePath Զ�̴��·��
	 * @param folderPath ����ļ���·�� /����/����/����ƴ��/��/��/��/
	 */
	public static void upload(File file, String remoteFilePath,String folderPath,FileTransferClient ftp) throws Exception {
		createDirectory(ftp, folderPath);
		FileInputStream fis = new FileInputStream(file);
		FileTransferOutputStream ftos = ftp.uploadStream(remoteFilePath);
		byte[] bytes = new byte[1024];   
		int c;   
		while ((c = fis.read(bytes)) != -1) {   
			ftos.write(bytes, 0, c);   
		}   
		ftos.flush();
		ftos.close();
		fis.close();
	}

	/**
	 * �ϴ�����ļ�
	 * @localFilePathArr �����ļ�·��
	 * @remoteFilePathArr Զ�̷������ļ����·��
	 * @folderPath Զ�̷���������ļ����ļ���
	 * @ftp ftp�ͷ�������
	 */
	public static void upload(String[] localFilePathArr,String[] remoteFilePathArr, String folderPath,FileTransferClient ftp) throws Exception {
		try{
		createDirectory(ftp, folderPath);
		for (int i = 0; i < localFilePathArr.length; i++) {
			ftp.uploadFile(localFilePathArr[i], remoteFilePathArr[i]);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * ���ص����ļ�
	 * @param localFilePath �����ļ�·��
	 * @param remoteFilePath Զ�̴��·��
	 */
	public static void download(String localFilePath, String remoteFilePath,FileTransferClient ftp)throws Exception {
		ftp.downloadFile(localFilePath, remoteFilePath);
	}

	/**
	 * ����ȸ߶�ѹ��ͼƬ�ļ�
	 * @param oldFile Ҫ����ѹ�����ļ�ȫ·��
	 * @param newFile ���ļ�
	 * @param width ���
	 * @param height �߶�
	 * @param quality ���� 0.0 -- 1.0 ԽС��ѹ����ͼ��Ч��Խ��,ͼƬԽС
	 * @return ����ѹ������ļ���ȫ·��
	 */
	public static void zipWidthHeightImageFile(String oldFile,String newFile, int width, int height,
			float quality,FileTransferClient ftp) throws Exception{
		if (oldFile == null) {
			return ;
		}
		/** �Է������ϵ���ʱ�ļ����д��� */
		String tempPath = "ftp://"+ftp.getUserName()
				+":"+ftp.getPassword()
				+"@"+ftp.getRemoteHost()
				+":"+ftp.getRemotePort()
				+ oldFile;
		FileTransferInputStream ftis = FileTransferClient.downloadURLStream(tempPath);
		
		Image srcFile = ImageIO.read(ftis);

		/** ��,���趨 */
		BufferedImage tag = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
		
		/** ѹ��֮����λ�� */
		FileTransferOutputStream ftos = null;
		try{
			ftos = ftp.uploadStream(newFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(ftos);
		JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
		/** ѹ������ */
		jep.setQuality(quality, true);
		encoder.encode(tag, jep);
		
		ftis.close();
		ftos.flush();
		ftos.close();
	}
	
	/**
	 * ����ȸ߶�ѹ��ͼƬ�ļ�
	 * @param oldFile Ҫ����ѹ�����ļ�ȫ·��
	 * @param newFile ���ļ�
	 * @param width ���
	 * @param height �߶�
	 * @param quality ���� 0.0 -- 1.0 ԽС��ѹ����ͼ��Ч��Խ��,ͼƬԽС
	 * @return ����ѹ������ļ���ȫ·��
	 */
	public static void zipWidthHeightImageFile(File oldFile,String newFile, int width, int height,
			float quality,FileTransferClient ftp) throws Exception{
		if (oldFile == null) {
			return ;
		}
		
		Image srcFile = ImageIO.read(oldFile);

		/** ��,���趨 */
		BufferedImage tag = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
		
		/** ѹ��֮����λ�� */
		FileTransferOutputStream ftos = null;
		try{
			ftos = ftp.uploadStream(newFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(ftos);
		JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
		/** ѹ������ */
		jep.setQuality(quality, true);
		encoder.encode(tag, jep);
		
		ftos.flush();
		ftos.close();
	}
	
	/**
	 * ����ȸ߶�ѹ��ͼƬ�ļ�
	 * @param oldFile Ҫ����ѹ�����ļ�ȫ·��
	 * @param newFile ���ļ�
	 * @param width ���
	 * @param height �߶�
	 * @param quality ���� 0.0 -- 1.0 ԽС��ѹ����ͼ��Ч��Խ��,ͼƬԽС
	 * @return ����ѹ������ļ���ȫ·��
	 */
	public static void zipWidthHeightImageFile(String[] oldFiles,String[] newFiles, int width, int height,
			float quality,FileTransferClient ftp) throws Exception{
		
		String tempPath = "ftp://"+ftp.getUserName()
							+":"+ftp.getPassword()
							+"@"+ftp.getRemoteHost()
							+":"+ftp.getRemotePort()
							+ "/";
		
		FileTransferInputStream ftis = null;
		FileTransferOutputStream ftos = null;
		Image srcFile = null;
		BufferedImage tag = null;
		JPEGImageEncoder encoder = null;
		JPEGEncodeParam jep = null;
		for (int i=0;i<oldFiles.length;i++) {
			ftis = FileTransferClient.downloadURLStream(tempPath+oldFiles[i]);
			srcFile = ImageIO.read(ftis);

			/** ��,���趨 */
			tag = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
			
			/** ѹ��֮����λ�� */
			
			ftos = ftp.uploadStream(newFiles[i]);
			
			encoder = JPEGCodec.createJPEGEncoder(ftos);
			jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
			/** ѹ������ */
			jep.setQuality(quality, true);
			encoder.encode(tag, jep);
			
			ftis.close();
			ftos.flush();
			ftos.close();
		}
	}
	
	/**
	 * ɾ���ļ����ļ���
	 * @param remotePath Զ���ļ����ļ���·��
	 * @param type 0:�ļ�   �����ļ���
	 */
	public static void delete(String remotePath,int type,FileTransferClient ftp) throws Exception{
		if(remotePath!=null && "".equals(remotePath)){
			if(type==0){
				try{
					ftp.deleteFile(remotePath);
				}catch (Exception e) {
					System.out.println("ɾ���쳣:"+remotePath);
				}
			}else{
				try{
					ftp.deleteDirectory(remotePath);
				}catch (Exception e) {
					System.out.println("ɾ���쳣:"+remotePath);
				}
			}
		}
	}
	
	/**
	 * ɾ���ļ����ļ���
	 * @param remotePath Զ���ļ����ļ���·��
	 * @param type 0:�ļ�   �����ļ���
	 */
	public static void delete(String[] remotePaths,int type,FileTransferClient ftp) throws Exception{
		if(type==0){
			for (String path : remotePaths) {
				if(path!=null && !"".equals(path)){
					try{
						ftp.deleteFile(path);
					}catch (Exception e) {
						System.out.println("ɾ���쳣:"+path);
					}
				}
			}
		}else{
			for (String path : remotePaths) {
				if(path!=null && "".equals(path)){
					try{
						ftp.deleteFile(path);
					}catch (Exception e) {
						System.out.println("ɾ���쳣:"+path);
					}
				}
			}
		}
	}
	
	/**
	 * �����ļ���
	 * @param path ��ŵ��ļ���·�� /����/����/����ƴ��/��/��/��/
	 */
	public static void createDirectory(FileTransferClient ftpClient,
			String folderPath) throws Exception {
		if (ftpClient.directoryList(folderPath).length==0) {
			String[] fileNames = folderPath.split("/");
			String temp = "";
			for (int i = 1; i < fileNames.length; i++) {
				temp = temp+"/"+fileNames[i];
				if (ftpClient.directoryList(temp).length==0) {
					ftpClient.createDirectory(temp+"/");
				} else {
					continue;
				}
			}
		}
	}
	
	/**
	 * ��ȡͼƬ������
	 * @param localFilePath �ϴ�ͼƬ·�� ����"/"��β
	 * @return ����Map imgurl ԭͼ preimgurl ѹ��ͼ
	 */
	public static Map<String, String[]> getImagePath(String[] localFilePath,String folderPath){
		Map<String, String[]> urlMap = new HashMap<String, String[]>();
		String[] imgurl = null;
		String[] preimgurl = null;
		if(localFilePath!=null && localFilePath.length!=0){
			int size = localFilePath.length;
			imgurl = new String[size];
			preimgurl = new String[size];
			String temp;
			for (int i = 0; i < size; i++) {
				temp = System.currentTimeMillis()+"_"+ (int)(Math.random()*1000000);;
				imgurl[i] = folderPath + temp + getFileSuffix(localFilePath[i]);
				preimgurl[i] = folderPath + temp + "s" + getFileSuffix(localFilePath[i]);
			}
		}
		urlMap.put("imgurl", imgurl);
		urlMap.put("preimgurl", preimgurl);
		return urlMap;
	}
	
	/**
	 * ��ȡ�ļ���
	 * 
	 * @return
	 */
	public static String getFileSuffix(String filePath) {
		String suffix = "";
		if (filePath != null && !"".equals(filePath)) {
			suffix = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
		}
		return suffix;
	}
	
	/**
	 * ��ȡͼƬ������ʱ��
	 * @param args
	 */
	public static String[] getImageCreateTime(String[] imgPaths,FileTransferClient ftp)throws Exception{
		String[] createTimes = null;
		if(imgPaths!=null && imgPaths.length!=0){
			createTimes = new String[imgPaths.length];
			Metadata metadata = null;
			ExifSubIFDDirectory directory = null;
			byte[] buf = null;
			for (int i=0;i<imgPaths.length;i++) {
				buf = ftp.downloadByteArray(imgPaths[i]);
				metadata = JpegMetadataReader.readMetadata(new BufferedInputStream(new ByteArrayInputStream(buf)));
				directory = metadata.getDirectory(ExifSubIFDDirectory.class);
				try{
					createTimes[i] = directory.getDescription(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
				}catch (Exception e) {
					createTimes[i] = null;
				}
			}
		}
		return createTimes;
	}
	
	/**
	 * ��ȡͼƬ������ʱ��
	 * @param args
	 */
	public static String getImageCreateTime(File file)throws Exception{
		String createTime = "";
		if(file!=null){
			try{
				Metadata metadata = JpegMetadataReader.readMetadata(file);
				ExifSubIFDDirectory directory = metadata.getDirectory(ExifSubIFDDirectory.class);
				createTime = directory.getDescription(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
			}catch (Exception e) {
				createTime = "";
			}
		}
		return createTime;
	}
	
	public static void main(String[] args) {
		try {
			FileTransferClient ftpClient = FTPUnit.getFileTransferClient("192.168.1.254",21,"ftp","123456");
			FileInputStream fis = new FileInputStream(new File("D:\\ip.log"));
			FileTransferOutputStream ftos = ftpClient.uploadStream("/test/ip.log");
			byte[] bytes = new byte[1024];   
			int c;   
			while ((c = fis.read(bytes)) != -1) {   
				ftos.write(bytes, 0, c);   
			}   
			ftos.flush();
			ftos.close();
			fis.close();
			
			ftpClient.disconnect();
			//String[] str=getImageCreateTime(new String[]{"/DF4/3838/xunjian/2013/5/20/1369045589718_150510.jpg"},ftpClient);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
