/**
 *
 */
package one;

import com.google.common.base.Optional;

/**
 * @author LiY
 * @time 下午10:55:26
 *
 *       1.ifPresent
 * 
 *       Optional<User> user = Optional.ofNullable(getUserById(id));
 *       user.ifPresent(u -> System.out.println("Username is: " +
 *       u.getUsername())); 2.orElse
 * 
 *       如果 Optional 中有值则将其返回，否则返回 orElse 方法传入的参数。
 * 
 *       User user = Optional .ofNullable(getUserById(id)) .orElse(new User(0,
 *       "Unknown"));
 * 
 *       System.out.println("Username is: " + user.getUsername()); 3.orElseGet
 * 
 *       orElseGet 与 orElse 方法的区别在于，orElseGet 方法传入的参数为一个 Supplier 接口的实现 —— 当
 *       Optional 中有值的时候，返回值；当 Optional 中没有值的时候，返回从该 Supplier 获得的值。
 * 
 *       User user = Optional .ofNullable(getUserById(id)) .orElseGet(() -> new
 *       User(0, "Unknown"));
 * 
 *       System.out.println("Username is: " + user.getUsername()); 4.orElseThrow
 * 
 *       orElseThrow 与 orElse 方法的区别在于，orElseThrow 方法当 Optional
 *       中有值的时候，返回值；没有值的时候会抛出异常，抛出的异常由传入的 exceptionSupplier 提供。
 * 
 *       User user = Optional .ofNullable(getUserById(id)) .orElseThrow(() ->
 *       new EntityNotFoundException("id 为 " + id + " 的用户没有找到"));
 */
public class sayHello {

	public void sayHello(String name) {
		name = Optional.fromNullable(name).or("火星人");
		System.out.println("文艺青年说：Hello, " + name);
	}
}
