package control.test;

public class LabelForWhile {

	/**
	 *HappyBoyLi
	 *2017-1-21 обнГ2:59:09
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		outer:
			while(true){
				System.out.println("Outer while loop");
				while(true){
					i++;
					System.out.println("i= "+i);
					if(i==8){
						System.out.println("break outer");
						break outer;
					}
				}
			}
	}

}
