package poc;

import com.oracle.svm.core.annotate.AutomaticFeature;
import com.oracle.svm.core.jni.JNIRuntimeAccess;
import jtermios.linux.JTermiosImpl;
import org.graalvm.nativeimage.hosted.Feature;

@AutomaticFeature public class JNIRegistrationFeature implements Feature {
  public void beforeAnalysis(BeforeAnalysisAccess access) {
    System.out.println("REGISTRATION STARTED");

    try {
      JNIRuntimeAccess.register(SimpleNativePoc.class);
      JNIRuntimeAccess.register(SimpleNativePoc.C_lib.class);
      JNIRuntimeAccess.register(org.graalvm.compiler.phases.common.CanonicalizerPhase.class);

      JNIRuntimeAccess.register(String.class);
      JNIRuntimeAccess.register(String.class.getDeclaredField("value"));
      JNIRuntimeAccess.register(String.class.getDeclaredField("hash"));
      JNIRuntimeAccess.register(String.class.getDeclaredConstructor(char[].class));
      JNIRuntimeAccess.register(String.class.getDeclaredMethod("charAt", int.class));
      JNIRuntimeAccess.register(String.class.getDeclaredMethod("format", String.class, Object[].class));

      JNIRuntimeAccess.register(Object.class);
      JNIRuntimeAccess.register(String[].class);
      JNIRuntimeAccess.register(Integer.class);
      JNIRuntimeAccess.register(int.class);

      JNIRuntimeAccess.register(JTermiosImpl.Linux_C_lib_DirectMapping.class);
      JNIRuntimeAccess.register(JTermiosImpl.Linux_C_lib_DirectMapping.class.getDeclaredMethod("open", String.class, int.class));
      JNIRuntimeAccess.register(jtermios.linux.JTermiosImpl.Linux_C_lib_DirectMapping.class.getDeclaredMethod("open", String.class, int.class));

      System.out.println("REGISTRATION FINISHED");
    } catch (NoSuchMethodException | NoSuchFieldException e) {
      System.err.println("REGISTRATION ERROR: " + e);
    }
  }
}
