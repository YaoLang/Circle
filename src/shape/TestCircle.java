package shape;

import java.util.Random;

public class TestCircle {
	
	private static Circle[] target = new Circle[10];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCircle.getRandomCircle();
		TestCircle.sort();
		TestCircle.computeArea();
	}
	
	/**
	 * 生成随机圆
	 */
	public static Circle[] getRandomCircle(){
		
		Random r = new Random();
		int k; // 正负号
		int x; // 0<x<100
		int y; // 0<y<100
		double radius ; // 半径
		for(int i = 0 ; i< 10 ; i ++){
			k = r.nextInt(2);
			x = r.nextInt(101);
			if(k == 0 ){
				x = -x ;
			}
			k = r.nextInt(2);
			y = r.nextInt(101);
			if(k == 0 ){
				y = -y ;
			}
			radius = (r.nextDouble()*100)%30;
			target[i] = new Circle(x,y,radius);
		}
		return target;
	}
	
	/**
	 * 排序
	 */
	public static void sort(){
		Circle c = null;
		int swap ;
		for(int i = 0;i<10-1;i++){
			swap = 0;
			for(int j = 0;j<10-i-1;j++){
				if(target[j].compareTo(target[j+1])>0){
					swap = 1;
					c = target[j];
					target[j]= target[j+1];
					target[j+1] = c;
				}
			}
			if(swap==0){
				break;
			}
		}
		for(Circle s : target){
			System.out.println(s.toString());
		}
	}
	/**
	 * 没有相交包含
	 */
	public static double computeArea(){
		double allArea = 0;
		int swap ;
		for(int i = 0;i<10;i++){
			swap = 0 ;
			for(int j = i+1;j<10;j++){
				if(target[i].isIntersected(target[j])==true||target[i].contains(target[j])==true){
					swap = 1;
					break;
				}
			}
			if(swap==0){
				allArea = allArea + target[i].getArea();
			}
		}
		System.out.println(allArea);
		return allArea;
	}
}
