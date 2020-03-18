package annotations;

import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.ArrayList;
import java.util.Set;

/**
 * @packgeName: annotations
 * @ClassName: InterfaceExtractorProcessorNew
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/10-19:50
 * @version: 1.0
 * @since: JDK 1.8
 */
public class InterfaceExtractorProcessorNew implements Processor {

    private ProcessingEnvironment env;

    private ArrayList<ExecutableElement> interfaceMethods = new ArrayList<>();


    public Set<String> getSupportedOptions() {
        return null;
    }

    public Set<String> getSupportedAnnotationTypes() {
        return null;
    }

    public SourceVersion getSupportedSourceVersion() {
        return null;
    }

    public void init(ProcessingEnvironment processingEnv) {

    }

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }

    public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member, String userText) {
        return null;
    }
}
