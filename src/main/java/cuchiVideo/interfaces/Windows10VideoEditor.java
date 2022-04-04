package cuchiVideo.interfaces;

import cuchiVideo.VideoOutputInterface;

import java.io.File;

public class Windows10VideoEditor implements VideoOutputInterface {

    @Override
    public void addImage(File Img, double Duration) throws Exception {

    }

    @Override
    public void addVideo(File Video, double Duration, double init, double end, int width, int height) {

    }

    @Override
    public void addMusic(File Song, double Duration) {

    }

    @Override
    public void write() throws Exception {

    }
}
