package ch2;

import java.util.Objects;

public class item5_use_di {

    public static void main(String[] args) {

    }
}

class SpellChecker { // 맞춤법 검사기
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }
}

class Lexicon {} // 각 사전별 맞춤법
