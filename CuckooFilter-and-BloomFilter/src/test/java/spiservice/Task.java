/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:Task.java Package Name:spiservice
 * Date:2021年5月4日下午1:02:27 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Task.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年5月4日 下午1:02:27
 * @version V1.0
 */
package spiservice;
/**
 * ClassName:Task <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年5月4日 下午1:02:27 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Task @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年5月4日 下午1:02:27
 * @version
 * @since JDK 1.8
 */
import java.util.Date;

/**
 * @author: 栈长
 * @from: 公众号Java技术栈
 */
public class Task {

  private long id;
  private String name;
  private String content;
  private int type;
  private int status;
  private Date finishDate;

  private Task(TaskBuilder taskBuilder) {
    id = taskBuilder.id;
    name = taskBuilder.name;
    content = taskBuilder.content;
    type = taskBuilder.type;
    status = taskBuilder.status;
    finishDate = taskBuilder.finishDate;
  }

  /**
   * @author:
   * @from:
   */
  public static class TaskBuilder {

    private long id;
    private String name;
    private String content;
    private int type;
    private int status;
    private Date finishDate;

    public TaskBuilder(long id, String name) {
      this.id = id;
      this.name = name;
    }

    public TaskBuilder content(String content) {
      this.content = content;
      return this;
    }

    public TaskBuilder type(int type) {
      this.type = type;
      return this;
    }

    public TaskBuilder status(int status) {
      this.status = status;
      return this;
    }

    public TaskBuilder finishDate(Date finishDate) {
      this.finishDate = finishDate;
      return this;
    }

    public Task build() {
      return new Task(this);
    }
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getContent() {
    return content;
  }

  public int getType() {
    return type;
  }

  public int getStatus() {
    return status;
  }

  public Date getFinishDate() {
    return finishDate;
  }

  @Override
  public String toString() {
    return "Task{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", content='"
        + content
        + '\''
        + ", type="
        + type
        + ", status="
        + status
        + ", finishDate="
        + finishDate
        + '}';
  }
}
