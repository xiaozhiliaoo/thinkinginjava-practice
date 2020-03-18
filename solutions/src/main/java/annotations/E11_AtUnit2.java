package annotations;

import net.mindview.util.ProcessFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * @packgeName: annotations
 * @ClassName: E11_AtUnit2
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/14-21:13
 * @version: 1.0
 * @since: JDK 1.8
 */
public class E11_AtUnit2 implements ProcessFiles.Strategy{

    static Class<?> testClass;

    static List<String> failedTests = new ArrayList<>();

    static long testsRun = 0;

    static long failures = 0;

    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);

        new ProcessFiles(new E11_AtUnit2(),"class").start(args);

        //生成测试报告
        report();
    }

    private static void report() {
        if (failures == 0) {
            print("OK (" + testsRun + " tests)");
        } else {
            print("("+ testsRun + " tests)");
            print("\n>>> "+failures + "FAILURE" + (failures>1?"S":"") + " <<<");
            for (String failed : failedTests) {
                print("  " + failed);
            }
        }
    }

    @Override
    public void process(File file) {

    }
}
