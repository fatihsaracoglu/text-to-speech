package tr.gov.tubitak.bilgem.yte;


public class TextToSpeechApplication {

    public static void main(String[] args) {
        TextToSpeech textToSpeech = new TextToSpeech();
        StringBuilder text = ReadTextFile.read("tubitak-bilgem-yte.txt");
        textToSpeech.setLanguage("en");
        String translatedText = TranslatorService.translate("tr", "en", text.toString());
        textToSpeech.speak(translatedText);
    }
}
