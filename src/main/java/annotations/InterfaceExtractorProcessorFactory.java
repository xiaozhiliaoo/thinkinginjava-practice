//: annotations/InterfaceExtractorProcessorFactory.java
// APT-based annotation processing.
package annotations;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * 用法：apt <apt 和 javac 选项> <源文件>
 其中，apt 选项包括：
 -classpath <路径>            指定查找用户类文件和注释处理器工厂的位置
 -cp <路径>                   指定查找用户类文件和注释处理器工厂的位置
 -d <路径>                    指定存放处理器和 javac 生成的类文件的位置
 -s <路径>                    指定存放处理器生成的源文件的位置
 -source <版本>               提供与指定版本的源兼容性
 -version                   版本信息
 -help                      输出标准选项的提要；使用 javac -help 可以得到更多选项
 -X                         输出非标准选项的提要
 -J<标志>                     直接将 <标志> 传递给运行时系统
 -A[关键字[=值]]                传递给注释处理器的选项
 -nocompile                 请勿将源文件编译为类文件
 -print                     输出指定类型的文本表示
 -factorypath <路径>          指定查找注释处理器工厂的位置
 -factory <类>               要使用的 AnnotationProcessorFactory 的名称；绕过默认的搜索进程
 有关 javac 选项的信息，请参见 javac -help。
 */

public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory {

    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env) {
        //返回注解处理器
        return new InterfaceExtractorProcessor(env);
    }

    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("annotations.ExtractInterface");
    }


    /**
     * 没有选项
     * */
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }

} ///:~*/
