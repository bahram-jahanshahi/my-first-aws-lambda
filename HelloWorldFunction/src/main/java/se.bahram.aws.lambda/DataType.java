package se.bahram.aws.lambda;

import java.util.*;

public class DataType {

    public boolean getNumber(float number) {
        return number > 100;
    }

    public List<Integer> getScores(List<String> names) {

        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Bahram", 80);
        studentScores.put("Vidar", 90);
        studentScores.put("Marco", 95);
        studentScores.put("Juan Pablo", 100);

        List<Integer> matchingScores = new LinkedList<>();
        names.forEach(name -> {
            matchingScores.add( studentScores.get(name) );
        });

        return matchingScores;
    }

    public void saveEmployeeData(Map<String, Integer> empData) {
        System.out.println(empData);
    }

    public Map<String, List<Integer>> getStudentScores() {

        Map<String, List<Integer>> studentScores = new HashMap<String, List<Integer>>();

        studentScores.put("Bahram", Arrays.asList(80, 90, 100));
        studentScores.put("Vidar", Arrays.asList(90, 85, 85));
        studentScores.put("Marco", Arrays.asList(70, 90, 95));

        return studentScores;
    }

}