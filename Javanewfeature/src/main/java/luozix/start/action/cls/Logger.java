/**
 * 
 */
package luozix.start.action.cls;

/**
 * @author xiaoy
 *
 */
public class Logger {
	private String format;

	public String getFormat() {
		return this.format;
	}

	public void setFormat() {
		this.format = format;
	}

}

class Speaker {

}
class AudioPlayer {
	protected boolean openSpeaker(Speaker sp) {
		return false;
		// 实现细节
	}
}

class StreamingAudioPlayer extends AudioPlayer {
	protected boolean openSpeaker(Speaker sp) {
		return false;
		// 实现细节
	}
}