package poc;

import com.pty4j.unix.PtyHelpers;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.function.CLibrary;

@SuppressWarnings("DuplicatedCode") public class SimpleNativePoc implements CContext.Directives {

  @CLibrary("c") public interface C_lib extends Library {
    int execv(String command, StringArray argv);

    int execve(String command, StringArray argv, StringArray env);

    int ioctl(int fd, NativeLong cmd, PtyHelpers.winsize data);

    int kill(int pid, int signal);

    int waitpid(int pid, int[] stat, int options);

    int sigprocmask(int how, IntByReference set, IntByReference oldset);

    String strerror(int errno);

    int grantpt(int fdm);

    int unlockpt(int fdm);

    int close(int fd);

    String ptsname(int fd);

    int open(String pts_name, int o_rdwr);

    int open(String pts_name, int o_rdwr, int mode);

    int killpg(int pid, int sig);

    int fork();

    int setsid();

    int getpid();

    int setpgid(int pid, int pgid);

    void dup2(int fd, int fileno);

    int getppid();

    void unsetenv(String s);

    void chdir(String dirpath);
  }

  private static C_lib m_Clib = (C_lib) Native.loadLibrary("c", C_lib.class);


  public static void main(String[] args) throws Exception {
    System.out.println("start");
    C_lib cLib = Native.loadLibrary("c", C_lib.class);
    int getpid = cLib.getpid();
    System.out.println("pid = " + getpid);
    System.out.println("end");
  }

}
