package cn.wangtao.image;

import static org.bytedeco.javacpp.opencv_highgui.imshow;
import static org.bytedeco.javacpp.opencv_highgui.waitKey;

import org.bytedeco.javacpp.opencv_core.Mat;

/**
 * 
 * @author wangtao34
 * @datetime 2017年7月6日 上午10:56:05
 */
public class ShowImgThread implements Runnable {

	private Mat img = null;
	private String imgName = null;
	/**
	 * 
	 * Constructor
	 * @param img
	 */
	public ShowImgThread(Mat img, String imgName) {
		super();
		this.setImg(img);
		this.setImgName(imgName);
	}
	
	@Override
	public void run() {
		imshow(imgName, img);
		waitKey();
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
