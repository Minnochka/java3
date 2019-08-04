import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CIassForTest {

    public static void start(Class cl)
    {
        Method[] methods = cl.getDeclaredMethods();
        List<Method> methodList = new ArrayList<Method>();
        int priority;

        for (Method m: methods) {
            if(m.isAnnotationPresent(Test.class)) {
                priority = m.getAnnotation(Test.class).priority();
                if(priority < 1 || priority > 10) {
                    throw  new RuntimeException("Приоритет не находится в пределах от 1 до 10!");
                }
                else{
                    methodList.add(m);
                }
            }
        }

        methodList.sort(new Comparator<Method>() {
            @Override
            public int compare(Method m1, Method m2) {
                return m1.getAnnotation(Test.class).priority() - m2.getAnnotation(Test.class).priority();
            }
        });

        /*for(Method m : methodList){
            System.out.println(m.getAnnotation(Test.class).priority());
        }*/

        for(Method m: methods){
            if(m.isAnnotationPresent(BeforeSuite.class)){
                if(methodList.get(0).isAnnotationPresent(BeforeSuite.class)){
                    throw new RuntimeException("BeforeSuite уже есть!");
                }
                else{
                    methodList.add(0, m);
                }
            }
            else if(m.isAnnotationPresent(AfterSuite.class)){
                if(methodList.get(methodList.size() - 1).isAnnotationPresent(AfterSuite.class)){
                    throw new RuntimeException("AfterSuite уже есть!");
                }
                else{
                    methodList.add(methodList.size(), m);
                }
            }
        }
        for (Method m: methodList) {
            try {
                m.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
