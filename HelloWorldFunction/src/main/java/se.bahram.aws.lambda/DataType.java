package se.bahram.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class DataType {

    private Double instanceVariable = Math.random();
    private static Double staticVariable = Math.random();

    public void coldsStartBasics() {
        Double localVariable = Math.random();

        System.out.println("localVariable = " + localVariable);
        System.out.println("instanceVariable = " + instanceVariable);
        System.out.println("staticVariable = " + staticVariable);
    }

    public DataType() {
        System.out.println("Inside Constructor");
    }

    static {
        System.out.println("Static Block executed");
    }

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

    public ClinicalData getClinicals(Patient patient) {
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setBp("80/120");
        clinicalData.setHeartRate("80");
        return clinicalData;
    }

    public void getOutput(InputStream input, OutputStream output, Context context) throws IOException {

        System.out.println(System.getenv("restapiurl"));


        System.out.println(context.getAwsRequestId());
        System.out.println(context.getFunctionName());
        System.out.println(context.getRemainingTimeInMillis());
        System.out.println(context.getMemoryLimitInMB());
        System.out.println(context.getLogGroupName());

        int data = 0;
        while ((data = input.read()) != -1) {
            output.write(Character.toLowerCase(data));
        }
    }

}