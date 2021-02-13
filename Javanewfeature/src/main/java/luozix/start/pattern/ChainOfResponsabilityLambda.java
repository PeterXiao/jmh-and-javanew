/**  
* @Title: ChainOfResponsabilityLambda.java
* @Package luozix.start.pattern
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午11:06:45
* @version V1.0  
*/
package luozix.start.pattern;
/**
* @ClassName: ChainOfResponsabilityLambda
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午11:06:45
*
*/

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class ChainOfResponsabilityLambda {
	static class File {
		static enum Type {
			AUDIO, TEXT, UNKNOWN
		}

		String content;
		Type type;

		public File(String content, Type type) {
			this.content = content;
			this.type = type;
		}
	}

	public static Optional<String> parseText(File f) {
		if (f.type == File.Type.TEXT) {
			return Optional.of("Text file: " + f.content);
		} else {
			return Optional.empty();
		}
	}

	public static Optional<String> parseAudio(File f) {
		if (f.type == File.Type.AUDIO) {
			return Optional.of("Audio file: " + f.content);
		} else {
			return Optional.empty();
		}
	}

	public static void main(String[] args) {
		final File file = new File("Nevermind - Nirvana", File.Type.AUDIO);
		System.out.println(Stream
				.<Function<File, Optional<String>>>of(ChainOfResponsabilityLambda::parseAudio,
						ChainOfResponsabilityLambda::parseText)
				.map(f -> f.apply(file)).findFirst().flatMap(Function.identity())
				.orElseThrow(() -> new RuntimeException("Unknown file format")));
	}

}
