package reflex;

import reflex.entity.Student;
import reflex.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;


public class ReflexUtils {


    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Student user = new Student(12,"刘昊楠",new BigDecimal("333.32"),true);
        Student user2 = new Student(12,"6666",new BigDecimal("6633.32"),false);
        String s = entityComparison(user, user2);
        System.out.println(s);

    }

    /**
     * 新老实体的比较
     * @param oldEntity
     * @param newEntity
     * @return
     */
    private static String entityComparison(Object oldEntity,Object newEntity) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class<?> oldEntityClass = oldEntity.getClass();
        Class<?> newEntityClass = newEntity.getClass();
        Field[] oldFields = oldEntityClass.getDeclaredFields();
        Field[] newFields = newEntityClass.getDeclaredFields();
        if(oldFields.length!=newFields.length){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < oldFields.length; i++) {
            Field oldField =  oldFields[i];
            Field newField = newFields[i];
            oldField.setAccessible(Boolean.TRUE);
            newField.setAccessible(Boolean.TRUE);
            String oldType = oldField.getGenericType().toString();
            String newType = newField.getGenericType().toString();
            if(!oldType.equals(newType)){
                return "";
            }
            String name = oldField.getName();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);

            String oldValue = oldEntityClass.getMethod("get" + name).invoke(oldEntity) + "";
            String newValue = newEntityClass.getMethod("get" + name).invoke(newEntity) + "";
            if(oldType.equals("class java.lang.Integer")){
                Integer oldInteger = Integer.valueOf(oldValue);
                Integer newInteger = Integer.valueOf(newValue);
                if(oldInteger!=newInteger){
                    stringBuilder.append("Integer"+oldValue+newValue);
                }

            }

            if(oldType.equals("class java.lang.String")){
                if(!oldValue.equals(newValue)){
                    stringBuilder.append("String"+oldValue+newValue);
                }
            }

            if(oldType.equals("class java.lang.Boolean")){
                Boolean oldBoolean = Boolean.valueOf(oldValue);
                Boolean newBoolean = Boolean.valueOf(newValue);
                if(oldBoolean!=newBoolean){
                    stringBuilder.append("Boolean"+oldValue+newValue);

                }


            }
            if(oldType.equals("class java.math.BigDecimal")){
                BigDecimal oldDecimal = new BigDecimal(oldValue);
                BigDecimal newDecimal = new BigDecimal(newValue);
                if(oldDecimal.compareTo(newDecimal)!=0){

                } stringBuilder.append("BigDecimal"+oldValue+newValue);

            }



        }


        return stringBuilder.toString();
    }
}
