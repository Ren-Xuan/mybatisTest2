package com.renxuan.mybatis.entity;

/**
 * 
 * @author ���
 *
 */
public class User {
	private int id;
	private String name;
	private int age;
	private SEX sex;
	public User(int id, String name, int age, SEX sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	} 
	
	public SEX getSEX() {
		return sex;
	}
	public void setSEX(SEX sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	public User() {
		// ��֪��Ϊʲôû�����Ҫ����
//		ʵ������Ҫô���в��޲ι��췽������д��Ҫ���Ͷ�Ҫд������ֻд�вι��췽��
//		mybatisΪʲô�־û���ʱ�����ṩһ������������Ĭ�Ϲ��캯����
//
//		ԭ����Ϊmybatis��ܻ�������Ĭ�Ϲ��췽��������ʵ������
//
//		��Class���newInstance���� �����������ͨ������Ĭ�Ϲ��췽��������ʵ������� ��
//
//		����������һ�㣬�����û���ṩ�κι��췽������������Զ��ṩĬ�Ϲ��췽�����޲ι�������������������ṩ�������в����Ĺ��췽���Ļ���������Ͳ���Ϊ���ṩĬ�Ϲ��췽������ʱ�����ֶ����޲ι�����д�ڴ��������new Xxxx()�ǻᱨ��ģ�����Ĭ�ϵĹ��췽�����Ǳ���ģ�ֻ���ж�����췽��ʱ���Ǳ���ģ�������롱ָ���ǡ������ֶ�д��������
//
//		����ѯ��ʱ�򷵻ص�ʵ������һ������ʵ������mybatis��̬ͨ���������ɵ�
//
//		�����Class.forName("className").newInstance();��Ҫ��Ӧ�����ṩһ���޲ι��캯��

//private Object createByConstructorSignature(ResultSetWrapper rsw, Class<?> resultType, List<Class<?>> constructorArgTypes, List<Object> constructorArgs,
//                                              String columnPrefix) throws SQLException {
//    final Constructor<?>[] constructors = resultType.getDeclaredConstructors();
//    final Constructor<?> annotatedConstructor = findAnnotatedConstructor(constructors);
//    if (annotatedConstructor != null) {
//      return createUsingConstructor(rsw, resultType, constructorArgTypes, constructorArgs, columnPrefix, annotatedConstructor);
//    } else {
//      for (Constructor<?> constructor : constructors) {
//        if (allowedConstructor(constructor, rsw.getClassNames())) {
//          return createUsingConstructor(rsw, resultType, constructorArgTypes, constructorArgs, columnPrefix, constructor);
//        }
//      }
//    }
//    throw new ExecutorException("No constructor found in " + resultType.getName() + " matching " + rsw.getClassNames());
//  }

	}
}
