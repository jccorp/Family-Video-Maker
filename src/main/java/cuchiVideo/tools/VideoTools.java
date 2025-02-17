package cuchiVideo.tools;

import java.io.File;
import java.util.Map;

import net.sourceforge.filebot.mediainfo.MediaInfo;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;


public class VideoTools {

    public static long[] GetVideoLengthAndRate(File file) throws FrameGrabber.Exception {

        OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(file);


        long [] retorno = new long [4];
        frameGrabber.start();
        System.out.println("Rate-->"+frameGrabber.getFrameRate());
        retorno[0] = frameGrabber.getLengthInTime();
        retorno[1] = frameGrabber.getVideoBitrate();
        retorno[2] = frameGrabber.getImageWidth();
        retorno[3] = frameGrabber.getImageHeight();


        System.out.println("time in seconds:"+ (frameGrabber.getLengthInFrames() / frameGrabber.getFrameRate()));
        //m.forEach((k,l) -> System.out.println("Llave:"+k+" Valor:"+l));

        //System.out.println("Metadata:"+frameGrabber.get);

        frameGrabber.stop();



        return retorno;
    }

	/**
	 * @param file
	 *
	 * Devuelve un array de long con
	 * 0-duracion
	 * 1-bitrate
	 * 2-widht
	 * 3-height
	 * 
	 */
    public static long[] GetVideoLenghtAndRate(File file) {
    	//devuelve en el primero la duracion y en el segundo el bitrate
        // first we create a Xuggler container object


    	System.out.println("FIle:"+ file.getAbsolutePath());
        long [] retorno = new long [4];
   
        //hay que tener el mediainfo instalado de:
        //http://mediaarea.net/en/MediaInfo/Download/Windows
        //y poner la dll en el path. pilla el primer instalador
        // (still within the Project Properties dialog) Click on the "Run/Debug Settings",
        //select your Java class, then click on the "Edit..." button. Select the "Arguments" tab,
        //then add -Djava.library.path="C:\chilkatJava;${env_var:PATH}" where "C:\chilkatJava" is
        //the directory path containing the "chilkat.dll" file.

        //debug CUCHi
    
        try {

	        //parece que lo resolvi metiendo en la carpeta  C:\Users\yocuc\git\Family-Video-Maker\CuchiVideoSlideshow\target\classes\win32-x86
	        //el media info de arquitecrau de 32 bits descargado de la web
   	        //System.load("C:\\Program Files\\MediaInfo\\MediaInfo.dll");
   	        //System.out.println("Librería Cargada");
        } catch (Exception e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }
   
        MediaInfo info    = new MediaInfo();
        info.open(file);

        int i=0; //stream number
        // query for the total duration

        String Duracion=info.get(MediaInfo.StreamKind.General, 0, "Duration", MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);;
        //Got in milliseconds
   
        try{
            retorno[0] = (int)Double.parseDouble(Duracion);
            //Integer.parseInt(Duracion);
        } catch (Exception e){
            retorno[0]=0;
        }
  
        // query for the bit rate
        String Bitrate=info.get(MediaInfo.StreamKind.Video, 0, "BitRate", MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);;
        retorno[1] = Integer.parseInt(Bitrate+0);

        // query for the widht in pixels
        String Width=info.get(MediaInfo.StreamKind.Video, i, "Width",
                MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);

        retorno[2] = Integer.parseInt(Width);

        //query for the widht in pixels
        String Height=info.get(MediaInfo.StreamKind.Video, i, "Height",
                MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);

        retorno[3] = Integer.parseInt(Height);

        //System.out.println("Duration (ms): " + retorno[0]);

        //System.out.println("Bit Rate (bits per second): " + retorno[1]);
        info.close();

        return retorno;
    }

}