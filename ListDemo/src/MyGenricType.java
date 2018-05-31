
public class MyGenricType<T extends Comparable<T>> {
	private T obj1,obj2;

	public MyGenricType(T obj1, T obj2) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	@Override
	public String toString() {
		return "MyGenricType [obj1=" + obj1 + ", obj2=" + obj2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((obj1 == null) ? 0 : obj1.hashCode());
		result = prime * result + ((obj2 == null) ? 0 : obj2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyGenricType other = (MyGenricType) obj;
		if (obj1 == null) {
			if (other.obj1 != null)
				return false;
		} else if (!obj1.equals(other.obj1))
			return false;
		if (obj2 == null) {
			if (other.obj2 != null)
				return false;
		} else if (!obj2.equals(other.obj2))
			return false;
		return true;
	}

	public T getObj1() {
		return obj1;
	}

	public void setObj1(T obj1) {
		this.obj1 = obj1;
	}

	public T getObj2() {
		return obj2;
	}

	public void setObj2(T obj2) {
		this.obj2 = obj2;
	}
	
}
