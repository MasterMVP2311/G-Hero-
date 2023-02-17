import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Music 
{

    private double duration;

    public void playMusic(String musicLocation)
    {
        try
        {
            File musicPath = new File(musicLocation);

            if (musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                AudioFormat af = audioInput.getFormat();
                double d = audioInput.getFrameLength() / af.getFrameRate();
                duration = d;
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                

                //JOptionPane.showMessageDialog(null, "Press OK to stop playing");
            }
            else
            {
                System.out.println("Can't find file");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    public double getLength()
    {
        return duration;
    }
}
