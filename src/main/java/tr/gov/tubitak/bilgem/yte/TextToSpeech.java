package tr.gov.tubitak.bilgem.yte;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

import javax.sound.sampled.AudioInputStream;


class TextToSpeech {

    private MaryInterface tts;

    TextToSpeech() {
        try {
            tts = new LocalMaryInterface();
        } catch (MaryConfigurationException e) {
            e.printStackTrace();
        }
    }

    void setLanguage(String language) {
        switch (language.toLowerCase()) {
            case "en":
                setLangCode("cmu-slt-hsmm");
                break;
            case "tr":
                setLangCode("dfki-ot-hsmm");
                break;
            default:
                break;
        }
    }

    private void setLangCode(String code) {
        tts.setVoice(code);
    }

    void speak(String text) {
        try {
            AudioInputStream audio = tts.generateAudio(text);
            AudioPlayer audioPlayer = new AudioPlayer();
            audioPlayer.setAudio(audio);
            audioPlayer.start();
            System.out.println("Reading...");
            audioPlayer.join();
            System.out.println("Reading finished!");
        } catch (SynthesisException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
