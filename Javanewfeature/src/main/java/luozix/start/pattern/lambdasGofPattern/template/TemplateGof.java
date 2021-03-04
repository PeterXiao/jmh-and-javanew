/**
 * Project Name:java11_in_action File Name:TemplateGof.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.template Date:2021年3月4日下午5:51:43 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: TemplateGof.java @Package luozix.start.pattern.lambdasGofPattern.template @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:51:43
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.template;
/**
 * ClassName:TemplateGof <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:51:43 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: TemplateGof @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:51:43
 * @version
 * @since JDK 1.8
 */
public class TemplateGof {

  public abstract static class AbstractResourceManipulatorTemplate {
    protected Resource resource;

    private void openResource() {
      resource = new Resource();
    }

    protected abstract void doSomethingWithResource();

    private void closeResource() {
      resource.dispose();
      resource = null;
    }

    public void execute() {
      openResource();
      try {
        doSomethingWithResource();
      } finally {
        closeResource();
      }
    }
  }

  public static class ResourceUser extends AbstractResourceManipulatorTemplate {
    @Override
    protected void doSomethingWithResource() {
      resource.useResource();
    }
  }

  public static class ResourceEmployer extends AbstractResourceManipulatorTemplate {
    @Override
    protected void doSomethingWithResource() {
      resource.employResource();
    }
  }

  public static void main(String[] args) {
    new ResourceUser().execute();
    new ResourceEmployer().execute();
  }
}
