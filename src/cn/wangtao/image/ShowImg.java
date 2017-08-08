package cn.wangtao.image;

import org.bytedeco.javacpp.opencv_core.Mat;

public class ShowImg {

	private Mat img = null;
	private String imgName = null;
	/**
	 * 
	 * Constructor
	 * @param img
	 */
	public ShowImg(Mat img, String imgName) {
		super();
		this.setImg(img);
		this.setImgName(imgName);
	}
	
	public void show(){
		ShowImgThread showImgThread = new ShowImgThread(img, imgName);
		Thread thread = new Thread(showImgThread);
		thread.start();
	}
	public Mat getImg() {
		return img;
	}

	public void setImg(Mat img) {
		this.img = img;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
}
