package basics.cache;

/*
 * import org.eclipse.mat.SnapshotException; import
 * org.eclipse.mat.parser.model.PrimitiveArrayImpl; import
 * org.eclipse.mat.snapshot.ISnapshot; import
 * org.eclipse.mat.parser.internal.SnapshotFactory; import
 * org.eclipse.mat.snapshot.model.IClass; import
 * org.eclipse.mat.snapshot.model.IObject; import
 * org.eclipse.mat.util.ConsoleProgressListener; import
 * org.eclipse.mat.util.IProgressListener; import java.io.File; import
 * java.io.IOException; import java.util.Collection; import java.util.HashMap;
 * public class Main { public static void main(String[] args) throws
 * SnapshotException, IOException { String arg = args[args.length - 1]; String
 * fileName = arg; IProgressListener listener = new
 * ConsoleProgressListener(System.out); SnapshotFactory sf = new
 * SnapshotFactory(); ISnapshot snapshot = sf.openSnapshot(new File(fileName),
 * new HashMap<String, String>(), listener);
 * System.out.println(snapshot.getSnapshotInfo()); System.out.println();
 * String[] classNames = {"java.lang.String"}; for (String name : classNames) {
 * Collection<IClass> classes = snapshot.getClassesByName(name, false); if
 * (classes == null || classes.isEmpty()) {
 * System.out.println(String.format("Cannot find class %s in heap dump", name));
 * continue; } assert classes.size() == 1; IClass clazz =
 * classes.iterator().next(); int[] objIds = clazz.getObjectIds(); long
 * minRetainedSize = snapshot.getMinRetainedSize(objIds, listener);
 * System.out.println(String.format("%s instances = %d, retained size >= %d",
 * clazz.getName(), objIds.length, minRetainedSize)); for (int i = 0; i <
 * objIds.length; i++) { IObject str = snapshot.getObject(objIds[i]); String
 * address = Long.toHexString(snapshot.mapIdToAddress(objIds[i]));
 * PrimitiveArrayImpl chars = (PrimitiveArrayImpl) str.resolveValue("value");
 * String value = new String((char[]) chars.getValueArray());
 * System.out.println(String.format("id=%d, address=%s, value=%s", objIds[i],
 * address, value)); } } } }
 */