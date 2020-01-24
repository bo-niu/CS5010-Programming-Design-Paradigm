package problem1;

import org.apache.commons.cli.*;

/**
 * ClIOption class handles user command line input.
 */
public class CLIOption {

    /**
     * Returns default options for this project.
     *
     * @return default options.
     */
    public Options createOptions() {
        Options options = new Options();

        final Option dir = Option.builder()
                .longOpt("dir")
                .required()
                .hasArg()
                .argName("directory_name")
                .desc("accept the directory containing the OULAD csv files")
                .build();

        final Option threshold = Option.builder()
                .longOpt("threshold")
                .hasArg()
                .argName("num_clicks")
                .desc("value to identify days when each course had the most activity.")
                .build();

        final Option numThreads = Option.builder()
                .longOpt("numThreads")
                .hasArg()
                .argName("number of working threads")
                .desc("value to identify producer threads while working.")
                .build();

        options.addOption(dir);
        options.addOption(threshold);
        options.addOption(numThreads);
        return options;
    }

    /**
     * Prints a string representing the basic usage.
     *
     * @param options the default options.
     */
    private void printUsage(Options options) {
        final HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(" ", options);
    }

    /**
     * Prints a string representing the error message.
     *
     * @param options the default options.
     * @param header  a string representing the error message.
     */
    public void printHelp(Options options, String header) {
        final HelpFormatter formatter = new HelpFormatter();
        String footer = "Example:" +
                "\n--dir directory_name" +
                "\n--dir directory_name --threshold num_clicks";
        formatter.printHelp("Demo ", header, options, footer, true);
    }
}