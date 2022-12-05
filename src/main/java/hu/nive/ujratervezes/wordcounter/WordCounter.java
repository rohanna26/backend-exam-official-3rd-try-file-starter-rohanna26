package hu.nive.ujratervezes.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordCounter {



    public int[] countWords(String fileName, int wordLength) {


        List<Integer> countWords = new ArrayList<>();

        String line;


        try (Scanner scanner = new Scanner(new File(fileName))) {

            while (scanner.hasNextLine()) {

                line = scanner.nextLine();
                String[] words = line.split(" ");
                String lastWord = words[words.length - 1];
                words[words.length - 1] = lastWord.substring(0, lastWord.length() - 1);

                countWords.add((int) Arrays.stream(words)
                        .filter(word -> word.length() == wordLength)
                        .count());
            }


        } catch (NumberFormatException | FileNotFoundException e) {
            return new int[0];
        }


        return countWords.stream().mapToInt(Integer::intValue).toArray();
    }
}
