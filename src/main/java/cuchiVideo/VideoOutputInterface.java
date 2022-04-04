package cuchiVideo;

import java.io.File;

public interface VideoOutputInterface {

	void addImage(File Img, double Duration)throws Exception;
	
	void addVideo(File Video, double Duration, double init,double end, int width, int height);
	
	void addMusic(File Song, double Duration);
	
	void write() throws Exception;

}
