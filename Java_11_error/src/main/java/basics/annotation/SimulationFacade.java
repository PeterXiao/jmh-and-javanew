/**
 *
 */
package basics.annotation;

/**
 * @author Office
 *
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class SimulationFacade {
    interface RunMethod {
	void run();

	double getRate();
    }

    interface ReportMethod {
	void report();
    }

    private static List<Object> classes = null;
    private static List<RunMethod> runMethods = null;
    private static List<ReportMethod> reportMethods = null;
    private final static int MAX_OPERATION_TIMES = 100;

    static {
	classes = new ArrayList<>();
	ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/spring-config.xml");
	Map<String, Object> beanNames = applicationContext.getBeansWithAnnotation(Simulation.class);

	for (Object o : beanNames.values()) {
	    classes.add(o);
	}

	System.out.println(beanNames);
	runMethods = new ArrayList<RunMethod>();
	reportMethods = new ArrayList<ReportMethod>();

	for (final Object o : classes) {
	    Method[] methods = o.getClass().getDeclaredMethods();

	    for (final Method method : methods) {
		if (method.isAnnotationPresent(Run.class)) {
		    runMethods.add(new RunMethod() {
			@Override
			public void run() {
			    try {
				method.invoke(o);
			    } catch (InvocationTargetException e) {
				e.printStackTrace();
			    } catch (IllegalAccessException e) {
				e.printStackTrace();
			    }
			}

			@Override
			public double getRate() {
			    return method.getAnnotation(Run.class).rate();
			}
		    });
		} else if (method.isAnnotationPresent(Report.class)) {
		    reportMethods.add(new ReportMethod() {
			@Override
			public void report() {
			    try {
				method.invoke(o);
			    } catch (IllegalAccessException e) {
				e.printStackTrace();
			    } catch (InvocationTargetException e) {
				e.printStackTrace();
			    }
			}
		    });
		}
	    }
	}
    }

    public void run() {
	double rate = Math.random();
	for (RunMethod method : runMethods) {
	    if (rate <= method.getRate()) {
		method.run();
		break;
	    } else {
		rate -= method.getRate();
	    }
	}
    }

    public void report() {
	for (ReportMethod method : reportMethods) {
	    method.report();
	}
    }

    public static class MulTiThreadSimulation {
	private final static int THREAD_NUM = 10;
	SimulationFacade simulationFacade = new SimulationFacade();
	static AtomicInteger operationTimes = new AtomicInteger(0);

	public void run() {
	    List<Thread> threadList = new ArrayList<Thread>();
	    for (int i = 0; i < THREAD_NUM; i++) {
		Thread thread = new Thread(new Runnable() {
		    @Override
		    public void run() {
			while (operationTimes.getAndIncrement() < SimulationFacade.MAX_OPERATION_TIMES) {
			    try {
				// 仿真测试
				simulationFacade.run();
				Thread.sleep(10);
			    } catch (InterruptedException e) {
				e.printStackTrace();
			    }
			}
		    }
		});
		thread.start();
		threadList.add(thread);
	    }

	    for (Thread thread : threadList) {
		try {
		    thread.join();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}

	public void report() {
	    simulationFacade.report();
	}
    }

    public static void main(String[] args)
	    throws InvocationTargetException, IllegalAccessException, InstantiationException {
	MulTiThreadSimulation mulTiThreadSimulation = new MulTiThreadSimulation();
	mulTiThreadSimulation.run();
	mulTiThreadSimulation.report();
    }
}

