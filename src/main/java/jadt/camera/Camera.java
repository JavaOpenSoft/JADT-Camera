package jadt.camera;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Camera {
    private VideoStream videoStream = new VideoStream();
    private String platform = System.getProperty("os.name");
    private Webcam webcam = Webcam.getDefault();
    private String saveDirectory = null;

    public Camera() {

    }
    public void writeVideo(String saveDirectory,String outputFile, String extension){

    }
    public Object getVideoStream() {
        return videoStream;
    }

    public void open() {
        webcam.open();
    }

    public void close() {
        webcam.close();
    }

    public Webcam getComponent() {
        return webcam;
    }

    public void write(String filename, String fileFormat) throws IOException {
        if (platform.equals("Windoows XP") || platform.equals("Windows 7")
                || platform.equals("Windows 8") || platform.equals("Windows 8.1")
                || platform.equals("Windows 10") || platform.equals("Windows 11"))
            ImageIO.write(webcam.getImage(), fileFormat, new File(saveDirectory + "\\" + filename));
        else ImageIO.write(webcam.getImage(), fileFormat, new File(saveDirectory + "/" + filename));
    }

    public void write(String filename, String directory, String fileFormat) throws IOException {
        if (platform.equals("Windoows XP") || platform.equals("Windows 7")
                || platform.equals("Windows 8") || platform.equals("Windows 8.1")
                || platform.equals("Windows 10") || platform.equals("Windows 11"))
            ImageIO.write(webcam.getImage(), fileFormat, new File(filename + "\\" + directory));
        else ImageIO.write(webcam.getImage(), fileFormat, new File(filename + "/" + directory));
    }

    public void setSaveDirectory(String saveDirectory) {
        this.saveDirectory = saveDirectory;
    }

    public void setResolution(CameraResolution resolution) {
        webcam.setViewSize(resolution.getSize());
    }

    public void addCameraListener(CameraListener cameraListener) {
        webcam.addWebcamListener(cameraListener);
    }

    public ArrayList<Dimension> getSupportedResolutions() {
        ArrayList<Dimension> arrayList = new ArrayList<Dimension>();
        for (Dimension supportedSizes : webcam.getViewSizes()) {
            arrayList.add(supportedSizes);
        }
        for (int i = 0; i <= arrayList.size(); i++) {

        }
        return arrayList;
    }

    public void setColorMode(String colorMode) {

    }
    public Image getImage() {
        return webcam.getImage();
    }
    public void startVideoCapture() {
        videoStream.start();
    }
    public ArrayList<Image> stopCapture(){
        videoStream.interrupt();
        return videoStream.getVideoStreamArray();
    }
    public void setDelayBetweenFrames(int delayBetweenFrames) {
        videoStream.setFrameDelay(delayBetweenFrames);
    }


}
class VideoStream extends Thread{
        private ArrayList <Image>videoStream = new ArrayList<Image>();
        private Webcam webcam = Webcam.getDefault();
        private int frameDelay = 100;
        private boolean isStreaming = true;
        @Override
        public void run() {
            while (isStreaming) {
                videoStream.add(webcam.getImage());
                try {
                    Thread.sleep(frameDelay);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        public void startStream() {
            this.isStreaming = true;
        }
        public void stopStream(){
            this.isStreaming = false;
        }
        public ArrayList<Image> getVideoStreamArray(){
            return videoStream;
        }
        public void setFrameDelay(int frameDelay){
            this.frameDelay = frameDelay;
        }
}
