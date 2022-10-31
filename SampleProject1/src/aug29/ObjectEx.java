package aug29;

public class ObjectEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object login[][]=new Object[3][2];
		login[0][0]="Admin1";
		login[0][1]=123;
		login[1][0]="Admin2";
		login[1][1]=456;
		login[2][0]="Admin3";
		login[2][1]=789;
		for (int i = 0; i < login.length; i++) {
			for (int j = 0; j < login[i].length; j++) {
				System.out.print(login[i][j]+"\t");
				
			}
			System.out.println();
		}
		

	}

}
