package problem1.sequentialSolution;

import org.apache.commons.cli.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem1.structure.CLIOption;
import problem1.structure.Course;
import problem1.structure.StudentV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class SequentialTest {

    @Test
    public void writeCSV() {
        String[] args = new String[]{"--dir", "data"};
        CLIOption cliOption = new CLIOption();
        Options options = cliOption.createOptions();
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine commandLine = parser.parse(options, args);
            String dirName = commandLine.getOptionValue("dir");
            Sequential sequential = new Sequential(dirName);
            List<Course> courses = sequential.readCourseCSV();
            sequential.writeCSV();
        } catch (ParseException e) {
            cliOption.printHelp(options, e.getMessage());
        }
    }
}