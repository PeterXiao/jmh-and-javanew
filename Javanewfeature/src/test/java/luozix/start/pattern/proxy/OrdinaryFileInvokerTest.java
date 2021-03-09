/**
 * @Title: OrdinaryFileInvokerTest.java @Package luozix.start.pattern.proxy @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiaoyu xiaoyulong07@outlook.com
 * @date 2021年2月12日 下午10:03:44
 * @version V1.0
 */
package luozix.start.pattern.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import luozix.start.pattern.lambdascommand.FileInvoker;
import luozix.start.pattern.lambdascommand.ordinary.CloseFileCommand;
import luozix.start.pattern.lambdascommand.ordinary.OpenFileCommand;
import luozix.start.pattern.lambdascommand.ordinary.WriteFileCommand;
import luozix.start.pattern.lambdascommand.system.FileSystemReceiver;
import luozix.start.pattern.lambdascommand.system.MacFileSystemReceiver;
import luozix.start.pattern.lambdascommand.system.WindowsFileSystemReceiver;

/**
 * @ClassName: OrdinaryFileInvokerTest @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyu xiaoyulong07@outlook.com
 * @date 2021年2月12日 下午10:03:44
 */

/** Created by mtumilowicz on 2017-11-20. */
public class OrdinaryFileInvokerTest {

  private final FileSystemReceiver windowsReceiver = new WindowsFileSystemReceiver();
  private final FileSystemReceiver macReceiver = new MacFileSystemReceiver();

  @Test
  public void windowsOpenFile() {
    assertEquals("WINDOWS, OPEN", new FileInvoker(windowsReceiver::open).excute());

    assertEquals("WINDOWS, OPEN", new FileInvoker(new OpenFileCommand(windowsReceiver)).excute());
  }

  @Test
  public void windowsWriteFile() {
    assertEquals("WINDOWS, WRITE", new FileInvoker(windowsReceiver::write).excute());

    assertEquals("WINDOWS, WRITE", new FileInvoker(new WriteFileCommand(windowsReceiver)).excute());
  }

  @Test
  public void windowsCloseFile() {
    assertEquals("WINDOWS, CLOSE", new FileInvoker(windowsReceiver::close).excute());

    assertEquals("WINDOWS, CLOSE", new FileInvoker(new CloseFileCommand(windowsReceiver)).excute());
  }

  @Test
  public void macOpenFile() {
    assertEquals("MAC, OPEN", new FileInvoker(macReceiver::open).excute());

    assertEquals("MAC, OPEN", new FileInvoker(new OpenFileCommand(macReceiver)).excute());
  }

  @Test
  public void macWriteFile() {
    assertEquals("MAC, WRITE", new FileInvoker(macReceiver::write).excute());

    assertEquals("MAC, WRITE", new FileInvoker(new WriteFileCommand(macReceiver)).excute());
  }

  @Test
  public void macCloseFile() {
    assertEquals("MAC, CLOSE", new FileInvoker(macReceiver::close).excute());

    assertEquals("MAC, CLOSE", new FileInvoker(new CloseFileCommand(macReceiver)).excute());
  }
}
