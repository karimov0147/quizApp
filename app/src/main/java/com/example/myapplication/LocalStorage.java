package com.example.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocalStorage {

    static List<QuestionsData> getQuestions (){


        ArrayList questions = new ArrayList<QuestionsData>();
        ArrayList questionsR = new ArrayList<QuestionsData>();


        questions.add(new QuestionsData(
                "Capital of germany",
                "Berlin",
                  new String[]{"Berlin" , "Paris" , "London" , "Amsterdam"},
                 ""
        ));

        questions.add(new QuestionsData(
                "Capital of UK",
                "London",
                new String[]{"Berlin" , "London" , "Dublin"},
                ""
        ));

        questions.add(new QuestionsData(
                "Capital of France",
                "Paris",
                new String[]{"Paris" , "Warsaw" , "Moscow" , "New york"},
                ""
        ));

        questions.add(new QuestionsData(
                "Is Washington the capital of the United States?",
                "Yes",
                new String[]{"Yes" , "No"},
                ""
        ));

        questions.add(new QuestionsData(
                "Is St. Petersburg the capital of Russia?",
                "No",
                new String[]{"Yes" , "No" },
                ""
        ));

        questions.add(new QuestionsData(
                "Capital of Belgium",
                "Brussels",
                new String[]{"Berlin" , "Brussels" , "Vena"},
                ""
        ));

        questions.add(new QuestionsData(
                "capital of Bulgaria",
                "Sofia",
                new String[]{"Brussels" , "Helsinki" , "Sofia" , "Riga"},
                ""
        ));

        questions.add(new QuestionsData(
                "capital of Finland",
                "Helsinki",
                new String[]{"Helsinki" , "Rome" , "Budapest"},
                ""
        ));

        questions.add(new QuestionsData(
                "capital of Hungary",
                "Budapest",
                new String[]{"Berlin" , "Budapest" , "Moscow"},
                ""
        ));

        questions.add(new QuestionsData(
                "capital of Latvia",
                "Riga",
                new String[]{"Riga" , "Dublin" , "Oslo"},
                ""
        ));

        questions.add(new QuestionsData(
                "Is Warsaw the capital of Poland?",
                "Yes",
                new String[]{"Yes" , "No" },
                ""
        ));

        questions.add(new QuestionsData(
                "Is Stockholm the capital of Switzerland?",
                "No",
                new String[]{"Yes" , "No" },
                ""
        ));

        questions.add(new QuestionsData(
                "Is Stockholm the capital of Sweden?",
                "Yes",
                new String[]{"Yes" , "No" },
                ""
        ));

        questions.add(new QuestionsData(
                "Is Bern the capital of Finland?",
                "No",
                new String[]{"Yes" , "No" },
                ""
        ));


        questions.add(new QuestionsData(
                "Is Kiev the capital of Belarus?",
                "No",
                new String[]{"Yes" , "No" },
                ""
        ));

        questions.add(new QuestionsData(
                "Is Kiev the capital of Belarus?",
                "No",
                new String[]{"Yes" , "No" },
                ""
        ));

        questions.add(new QuestionsData(
                "Russia is the largest country in the world?",
                "Yes",
                new String[]{"Yes" , "No" },
                ""
        ));

        questions.add(new QuestionsData(
                "The smallest country in the world?",
                "Vatican",
                new String[]{"Vatican" , "Monaco" },
                ""
        ));


        Collections.shuffle(questions);

        for (int i = 0; i < 7; i++) {
            questionsR.add(questions.get(i));
        }



        return questionsR;
    }
}
