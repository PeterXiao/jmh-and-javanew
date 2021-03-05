	//1. for : iterate over array
	for (int i = 0; i < args.length; i++) {
		
	}
	
	//2. for iterate over array with temp varaible 
	for (int i = 0; i < args.length; i++) {
		String string = args[i];
		
	}
	
	
	//3. for  over collection 
	for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
		type type = (type) iterator.next();
		
	}
	
	//4. foreach : iterate over an array or iterable 
	for (String string : args) {
		
	}
	
		
	//5. arrayadd : add an element to an array
	String[] args2 = new String[args.length + 1];
	System.arraycopy(args, 0, args2, 0, args.length);
	args2[args.length] = f;
	
	
	//6. arraymerge : marge two array into one
	String[] args3 = new String[args.length + args2.length];
	System.arraycopy(args, 0, args3, 0, args.length);
	System.arraycopy(args2, 0, args3, args.length, args2.length);
	
	
	//7. cast : typecast template
	type new_name = (type) name;
	
	
	//8. catch : add a catch block
	catch (Exception e) {
		// TODO: handle exception
	}
	
	
	//9. do : do-while loop
	do {
		
	} while (condition);
	
	
	//10. else : else block
	else {
		
	}
	
	
	//11. elseif : else if block
	else if (condition) {
		
	}
	
	   
	//12 : if : if condition
	if (condition) {
		
	}
	
	//13. ifelse : if else stataement 
	if (condition) {
		
	} else {
	
	}
	
		
	//14. insteadof : dymanic type test and cast
	if (args3 instanceof type) {
		type new_name = (type) args3;
		
	}
	
	
	//15.lazy : lazy creation
		
	if (args3 == null) {
		args3 = new type(arguments);
		
	}
	
	return args3;
	
	
	
	//16. new : create new object
	type name = new type(arguments);
		
	//17. runnable : 
	new Runnable() {
		public void run() {
	
		}
		
	
	}
	
	
	
	//18. Switch : swich case
	switch (key) {
	case value:
		
		break;
	
	default:
		break;
	}
	
	
	//19 : synchronized : synchronized block
	synchronized (args3) {
		
	}
	
	
	//20. syserr : system error : System.err.println()
	System.err.println();
	
	
	
	//21. sysout : print a statement out System.out.prinlt.ln
	System.out.println();
	
	
	
	//22. systrace : Print the current method to standard output
		    System.out.println("Example.main()");
		    
		    
		    //23. try : try block
		    try {
		
	} catch (Exception e) {
		// TODO: handle exception
	    
		   
	//24. toarray : convert collection to array.
		    
		    (type[]) collection.toArray(new type[collection.size()])
	    
		    
	//25.while : iterate with enumeration
		    while (en.hasMoreElements()) {
		type type = (type) en.nextElement();
		
	}
		   	    
		    
	//26.while : iterate with iterator
		    while (it.hasNext()) {
		type type = (type) it.next();
		
	}    
		    
	//27. While loop with condition
		    while (condition) {
		
	}

 Const属性
 
	private static final ${type} ${name} = new ${type}(${cursor});


SLF4J

	${:import(org.slf4j.Logger,org.slf4j.LoggerFactory)}
		/**
	 * Logging mechanism.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(${enclosing_type}.class);
	
Log4J 2

	${:import(org.apache.logging.log4j.LogManager,org.apache.logging.log4j.Logger)} 
	private static final Logger LOG = LogManager.getLogger(${enclosing_type}.class); 
	
JUL

	${:import(java.util.logging.Logger)}
	private static final Logger LOG = Logger.getLogger(${enclosing_type}.class.getName());	
	
read file

	${:import(java.nio.file.Files,
          java.nio.file.Paths,
          java.nio.charset.Charset,
          java.io.IOException,
          java.io.BufferedReader)}
	try (BufferedReader in = Files.newBufferedReader(Paths.get(${fileName:var(String)}),
	                                                 Charset.forName("UTF-8"))) {
	    String line = null;
	    while ((line = in.readLine()) != null) {
	        ${cursor}
	    }
	} catch (IOException e) {
	    // ${todo}: handle exception
	}	


读取文件

	${:import(java.io.BufferedReader,  
	          java.io.FileNotFoundException,  
	          java.io.FileReader,  
	          java.io.IOException)}  
	BufferedReader in = null;  
	try {  
	   in = new BufferedReader(new FileReader(${fileName}));  
	   String line;  
	   while ((line = in.readLine()) != null) {  
	      ${cursor}  
	   }  
	}  
	catch (FileNotFoundException e) {  
	   // Handle exception
	}  
	catch (IOException e) {  
	   // Handle exception
	} finally {  
	   if(in != null) in.close();  
	}

TestNG测试方法


	${:import(org.testng.annotations.Test, org.testng.annotations.Parameters, org.testng.Assert)}
	@Test(groups = "${name}")
	public final void ${name}() {
		${cursor}
	}


Message Format

	 ${:import(java.text.MessageFormat)} 
 	  MessageFormat.format(${word_selection}, ${cursor})	

Lock the selection	

		${lock}.acquire();
		try {
		    ${line_selection}
		    ${cursor}
		} finally {
		    ${lock}.release();
		}

Sigleton 

	static enum Singleton {
	    INSTANCE;
	
	    private static final ${enclosing_type} singleton = new ${enclosing_type}();
	
	    public ${enclosing_type} getSingleton() {
	        return singleton;
	    }
	}
	${cursor}
	
	${type} ${newName} = ${type}.Singleton.INSTANCE.getSingleton();
	
	
Sigleton 模式
	
		
	/**
	 * The shared instance.
	 */
	private static ${enclosing_type} instance = new ${enclosing_type}();
	 
	/**
	 * Private constructor.
	 */
	private ${enclosing_type}() {
	    super();
	}
	 
	/**
	 * Returns this shared instance.
	 *
	 * @returns The shared instance
	 */
	public static ${enclosing_type} getInstance() {
	    return instance;
	}
	
	
	
	
	
	
	
	
	
	
	
Template:

	${:import(java.util.Map.Entry)}
	for (Entry<${keyType:argType(map, 0)}, ${valueType:argType(map, 1)}> ${entry} : ${map:var(java.util.Map)}.entrySet())
	{
	    ${keyType} ${key} = ${entry}.getKey();
	    ${valueType} ${value} = ${entry}.getValue();
	    ${cursor}
	}	

	for (Entry<String, String> entry : properties.entrySet())
	{
	    String key = entry.getKey();
	    String value = entry.getValue();
	    |
	}	

	package ${enclosing_package};
	
	import org.junit.*;
	import static org.junit.Assert.*;
	import static org.hamcrest.Matchers.*;
	import static org.mockito.Matchers.*;
	import static org.mockito.Mockito.*;
	import org.mockito.Mockito;
	import org.slf4j.Logger;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.runners.MockitoJUnitRunner;
	import org.junit.runner.RunWith;
	
	// TODO autogenerated test stub
	@RunWith(MockitoJUnitRunner.class)
	public class ${primary_type_name} {
	
	    @InjectMocks
	    protected ${testedType} ${testedInstance};
	    ${cursor}
	
	    @Mock
	    protected Logger logger;
	
	    @Before
	    public void setup() throws Exception {
	    }
	
	    @Test
	    public void shouldXXX() throws Exception {
	        // given
	
	        // when
	        // TODO autogenerated method stub
	
	        // then
	        fail("Not implemented.");
	    }
	}
	// Here goes mockito+junit cheetsheet		
	
	
	if( ${word_selection} != null ){
	    ${cursor}
	}
	
	if( ${word_selection} == null ){
	    ${cursor}
	}
	
	for (${iterable_type} ${iterable_element} : ${iterable}) {
	    ${cursor}
	}
	
	System.out.println("${enclosing_type}.${enclosing_method}()");
	
	private static final ${type} ${name} = new ${type} ${cursor};

Bean Property

	private ${Type} ${property};
	
	public ${Type} get${Property}() {
	    return ${property};
	}
	
	public void set${Property}(${Type} ${property}) {
	    ${propertyChangeSupport}.firePropertyChange("${property}", this.${property},     this.${property} = ${property});
	}

PropertyChangeSupport

	private PropertyChangeSupport ${propertyChangeSupport} = new PropertyChangeSupport(this);${:import(java.beans.PropertyChangeSupport,java.beans.PropertyChangeListener)}
	public void addPropertyChangeListener(PropertyChangeListener listener) {
	  ${propertyChangeSupport}.addPropertyChangeListener(listener);
	}
	
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
	  ${propertyChangeSupport}.addPropertyChangeListener(propertyName, listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
	  ${propertyChangeSupport}.removePropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
	  ${propertyChangeSupport}.removePropertyChangeListener(propertyName, listener);
	}		

	${:import(org.apache.commons.lang.builder.EqualsBuilder,org.apache.commons.lang.builder.HashCodeBuilder)}
	@Override
	public boolean equals(Object obj) {
	    return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public int hashCode() {
	    return HashCodeBuilder.reflectionHashCode(this);
	}


	