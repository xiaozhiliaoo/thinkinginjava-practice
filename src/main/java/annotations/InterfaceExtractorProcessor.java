//: annotations/InterfaceExtractorProcessor.java
// APT-based annotation processing.
// {Exec: apt -factory
// annotations.InterfaceExtractorProcessorFactory
// Multiplier.java -s ../annotations}
/**
 *
 * 在java目录下cmd
 * >apt -factory annotations.InterfaceExtractorProcessorFactory annotations\Multiplier.java -s ../java/annotation
 * **/

package annotations;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

// 下载地址 http://mvnrepository.com/artifact/com.sun/tools/1.7.0.13
// jdk7已经不支持apt命令了
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/index.html?overview-summary.html
// https://docs.oracle.com/javase/7/docs/technotes/guides/apt/GettingStarted.html#AnnotationProcessor
public class InterfaceExtractorProcessor implements AnnotationProcessor {

    private final AnnotationProcessorEnvironment env;

    private ArrayList<MethodDeclaration> interfaceMethods = new ArrayList<MethodDeclaration>();

    public InterfaceExtractorProcessor(AnnotationProcessorEnvironment env) {
        this.env = env;
    }

    public void process() {

        for (TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations()) {
            //提取类中的接口
            ExtractInterface annot = typeDecl.getAnnotation(ExtractInterface.class);
            if (annot == null) {
                break;
            }
            for (MethodDeclaration m : typeDecl.getMethods()) {
                if (m.getModifiers().contains(Modifier.PUBLIC) && !(m.getModifiers().contains(Modifier.STATIC))) {
                    interfaceMethods.add(m);
                }
            }

            if (interfaceMethods.size() > 0) {
                try {
                    PrintWriter writer = env.getFiler().createSourceFile(annot.value());
                    writer.println("package " + typeDecl.getPackage().getQualifiedName() + ";");
                    writer.println("public interface " + annot.value() + " {");
                    for (MethodDeclaration m : interfaceMethods) {
                        writer.print("  public ");
                        writer.print(m.getReturnType() + " ");
                        writer.print(m.getSimpleName() + " (");
                        int i = 0;
                        for (ParameterDeclaration parm : m.getParameters()) {
                            writer.print(parm.getType() + " " + parm.getSimpleName());
                            if (++i < m.getParameters().size()) {
                                writer.print(", ");
                            }
                        }
                        writer.println(");");
                    }
                    writer.println("}");
                    writer.close();
                } catch (IOException ioe) {
                    throw new RuntimeException(ioe);
                }
            }
        }
    }
} ///:~*/
