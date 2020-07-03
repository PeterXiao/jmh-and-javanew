/**
 *
 */
package basics.cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Office
 *
 */
public class Mains {

    /**
     * @param args
     */
//    public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//    }
    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder text = new StringBuilder();
    static String sycDir = "D:\\坚果云\\CodeNotes"; // 笔记本同步路径
    static String hubDir = "D:\\github\\assets"; // github 库本地路径

    public static void main(String[] args) throws IOException, InterruptedException {
	System.out.println("正在处理中……");
	while (true) {
	    mainClear();
	    sleep(30000); // 间隔时间
	}
    }

    private static void sleep(int i) {
	// TODO Auto-generated method stub

    }

    public static void mainClear() throws IOException {
	ArrayList<String> picList = new ArrayList<>();
	File file = new File(sycDir);
	func(file);
	func(new File(hubDir));
	String ContentArea = text.toString();
	String regex = "\\(assets/.*?\\.\\w+\\)";
	Pattern pt = Pattern.compile(regex);
	Matcher mt = pt.matcher(ContentArea);
	while (mt.find()) {
	    String replace = mt.group().replace("(assets/", "").replace(")", "");
	    picList.add(replace);
	}
	for (String s : list) {
	    String fileName = s.substring(s.lastIndexOf("\\") + 1, s.length());// 获取文件名
	    int count = 0;
	    for (String pic : picList) {
		if (pic.equals(fileName)) {
		    count++;
		}
	    }
	    if (count <= 0) {
		System.out.println(s + "已放入" + sycDir + "回收站");
		String hs = file + "\\回收站\\";
		if (!new File(hs).exists())
		    new File(hs).mkdir();
		if (!new File(s).renameTo(new File(hs + fileName))) {
		    new File(hs + fileName).delete();
		    new File(s).renameTo(new File(hs + fileName));
		}
	    }
	}
	text = new StringBuilder();
	list.clear();
    }

    private static void func(File file) throws IOException {
	File[] fs = file.listFiles();
	String fName;
	for (File f : fs) {
	    if (f.isDirectory() && !f.toString().contains("回收站") && !f.toString().contains(".git")) // 排除回收站目录
		func(f);
	    if (f.isFile()) { // 若是文件，直接打印详细路径
		String s = f.toString();
		if (s.endsWith(".md")) {// 获取 md 文件内容
		    text.append(readToString(s));
		} else {
		    list.add(s);
		    if (s.contains(sycDir) && !s.contains(hubDir)) {
			fName = hubDir + "\\" + s.substring(s.lastIndexOf("\\") + 1, s.length());
			if (!new File(fName).exists()) {
			    System.out.println(s + "已同步");
			    Files.copy(new File(s).toPath(), new File(fName).toPath());
			}
		    }
		}
	    }
	}
    }

    public static String readToString(String fileName) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader(fileName));
	String line;
	StringBuilder txt = new StringBuilder();
	while ((line = br.readLine()) != null) {
	    txt.append(line);
	}
	br.close();
	return txt.toString();
    }

}
