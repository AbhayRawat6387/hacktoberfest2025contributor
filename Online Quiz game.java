import java.util.Scanner;

class Question {
    String question;
    String[] options;
    char answer;

    // Constructor
    public Question(String question, String[] options, char answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    // Display question and options
    public void displayQuestion() {
        System.out.println("\n" + question);
        char optionChar = 'A';
        for (String opt : options) {
            System.out.println(optionChar + ". " + opt);
            optionChar++;
        }
    }

    // Check if answer is correct
    public boolean checkAnswer(char userAnswer) {
        return Character.toUpperCase(userAnswer) == answer;
    }
}

public class OnlineQuizGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        // Creating quiz questions
        Question[] quiz = {
            new Question("1. Which company developed Java?",
                    new String[]{"Microsoft", "Sun Microsystems", "Apple", "IBM"}, 'B'),
            new Question("2. Which keyword is used to inherit a class in Java?",
                    new String[]{"super", "extends", "this", "implements"}, 'B'),
            new Question("3. Which method is the entry point of Java program?",
                    new String[]{"start()", "main()", "run()", "init()"}, 'B'),
            new Question("4. Which of these is not a Java feature?",
                    new String[]{"Object-Oriented", "Portable", "Use of Pointers", "Dynamic"}, 'C'),
            new Question("5. Which of these is used to handle exceptions?",
                    new String[]{"try-catch", "include", "import", "define"}, 'A')
        };

        System.out.println("==================================");
        System.out.println("      🧠 JAVA QUIZ SYSTEM 🧠      ");
        System.out.println("==================================");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("\nWelcome, " + name + "! Let's start the quiz.");

        // Loop through all questions
        for (Question q : quiz) {
            q.displayQuestion();
            System.out.print("Your answer (A/B/C/D): ");
            char ans = sc.next().charAt(0);

            if (q.checkAnswer(ans)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.answer);
            }
        }

        // Display final score
        System.out.println("\n==================================");
        System.out.println("Quiz Completed!");
        System.out.println("Player: " + name);
        System.out.println("Your Score: " + score + " / " + quiz.length);
        System.out.println("==================================");

        sc.close();
    }
}
