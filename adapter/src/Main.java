//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "Cancion1.mp3");
        audioPlayer.play("mp4", "Video1.mp4");
        audioPlayer.play("vlc", "Pelicula1.vlc");
        audioPlayer.play("avi", "Archivo.avi");
    }
}
// Interfaz principal MediaPlayer
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Interfaz para formatos avanzados
interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}

// Implementación de VLC Player
class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Reproduciendo VLC file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // No hace nada
    }
}

// Implementación de MP4 Player
class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // No hace nada
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Reproduciendo MP4 file: " + fileName);
    }
}

// Adaptador que permite usar AdvancedMediaPlayer con MediaPlayer
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

// Clase principal AudioPlayer que usa MediaAdapter para otros formatos
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        // Reproduce MP3 por defecto
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Reproduciendo MP3 file: " + fileName);
        }
        // Usa MediaAdapter para otros formatos
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Formato no soportado: " + audioType);
        }
    }
}
