package aug30;

public class ExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		int x=10,y=0,z;
		z=x/y;
		System.out.println(z);
		}
		catch (Throwable e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
