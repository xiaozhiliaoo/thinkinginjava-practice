//: containers/Tester.java
// Applies Test objects to lists of different containers.
package containers;

import java.util.*;

public class Tester<C> {
    //字段宽度  格式化  排列整齐
    public static int fieldWidth = 8;
    // 默认测试参数
    public static TestParam[] defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);
    // Override this to modify pre-test initialization:

    //初始化大小 并且返回
    protected C initialize(int size) {
        return container;
    }

    protected C container;
    //输出标题
    private String headline = "";
    //测试列表，对象，不只一个容器，存储各种测试类
    private List<Test<C>> tests;

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;
    //设置格式
    private static String sizeField = "%" + sizeWidth + "s";

    //测试参数等于默认的
    private TestParam[] paramList = defaultParams;

    //容器              具体测试对象
    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null) {
            headline = container.getClass().getSimpleName();
        }
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    public void setHeadline(String newHeadline) {
        headline = newHeadline;
    }

    // Generic methods for convenience :
    public static <C> void run(C cntnr, List<Test<C>> tests) {

        new Tester<C>(cntnr, tests).timedTest();

    }

    public static <C> void run(C cntnr, List<Test<C>> tests, TestParam[] paramList) {
        //timedTest()真正测试方法
        new Tester<C>(cntnr, tests, paramList).timedTest();
    }

    private void displayHeader() {
        // Calculate width and pad with '-':
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder head = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        System.out.println(head);
        // Print column headers:
        System.out.format(sizeField, "size");
        for (Test test : tests) {
            System.out.format(stringField(), test.name);//方法名字
        }
        System.out.println();
    }

    // Run the tests for this container: 真正开始测试
    public void timedTest() {
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for (Test<C> test : tests) {
                C kontainer = initialize(param.size);
                long start = System.nanoTime();
                // Call the overriden method:
                int reps = test.test(kontainer, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps; // Nanoseconds  为了准确，用纳米时间  平均测试时间
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }
} ///:~
