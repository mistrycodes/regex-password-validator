
import java.util.regex.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.swing.*;


public class Regex {
    public static String password;
    public static int count;

    private static void PlayMusic(String filepath) {

        InputStream music;
        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error, your file might be mp3 format." +
                    " Might I suggest converting your file to .wav, thank you. ");
        }

    }


    public static void main(String[] args) {

        Scanner myString = new Scanner(System.in);
        System.out.println("Be between 8 and 40 characters long\n" +
                "Contain at least one digit.\n" +
                "Contain at least one lower case character.\n" +
                "Contain at least one upper case character.\n" +
                "Contain at least one special character from [ @ # $ % ! . ]." +
                "Enter your desired password please");


        do {

            password = myString.nextLine();
            System.out.println("password is :" + password);

            String text = password;
            Pattern p = Pattern.compile("[A-Za-z0-9*£~]{10}");
            Matcher m = p.matcher(text);

            if (password == text)  {
                System.out.println("thats great, you password is to our standard");
                PlayMusic("Music\\\\ramsay2.wav");
                count++;
                System.out.println("your count has increased by n/" + count );
            } else{
                System.out.println(" your password is weak, try again please");
                PlayMusic("Music\\\\ramsay.wav");

            }


        }
        while (password.matches(password));

        if (myString != null) {
            myString.close();
        }




    }
}
