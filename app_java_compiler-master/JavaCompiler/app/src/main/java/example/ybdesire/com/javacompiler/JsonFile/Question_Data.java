package example.ybdesire.com.javacompiler.JsonFile;

public class Question_Data {

    private String mQuestion[] = {
            "If i want to print out\n [I Love OU FYP], what i should do?",
            "What is the output of\nSystem.out.print(\"iiiiiiiiiiii\\n\");\nSystem.out.print(\"iiiiiiiiiiii\");\n",
            "What is the output of\nint x = 3;\nint y = 5;\nSystem.out.print(\"x\"+\"y\");"
    };


    private String mChoices[][] = {
            {"System(I Love OU FYP).out.print;", "System.print.out(\"I Love OU FYP\");", "System.out.print(\"I Love OU FYP\");"},
            {"iiiiiiiiiiiiiiiiiiiiiiii", "iiiiiiiiiiii\niiiiiiiiiiii", "i"},
            {"8", "x+y", "xy"}
    };

    private String mCorrectAnsers[] = {
            "System.out.print(\"I Love OU FYP\");",
            "iiiiiiiiiiii\niiiiiiiiiiii",
            "xy"
    };

    public String getmQuestion(int a) {
        return mQuestion[a];
    }

    public String[] getmChoices(int a) {
        return mChoices[a];
    }

    public String getmCorrectAnsers(int a) {
        return mCorrectAnsers[a];
    }

    public String[] getTotalmQuestion() {
        return mQuestion;
    }
}
