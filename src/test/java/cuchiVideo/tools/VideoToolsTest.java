package cuchiVideo.tools;

import org.bytedeco.javacv.FrameGrabber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoToolsTest {

    @DisplayName("Test MessageService.get()")
    @Test
    void testGet() {

        File myFile = new File("C:/Users/Javier/Downloads/estVideo.mp4");
        try {
            long[] l = VideoTools.GetVideoLengthAndRate(myFile);

            System.out.println("-->" + l[0]);
            System.out.println("-->" + l[1]);
            System.out.println("-->" + l[2]);
            System.out.println("-->" + l[3]);

            Duration duration = Duration.ofMillis(l[0]);
            System.out.println("Seconds--->"+ duration.toSecondsPart());

            assertEquals("Hello JUnit 5", "");
        }catch (FrameGrabber.Exception e){
            e.printStackTrace();

        }
    }

}
