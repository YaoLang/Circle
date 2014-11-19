package shape;
/*	 Բ		*/

public class Circle {
	private Point locat = null;
	private double radius;
	
	public Point getLocat() {
		return locat;
	}
	public void setLocat(Point locat) {
		this.locat = locat;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Circle(){
		locat = new Point(0,0);
		radius = 1.0;
	}
	public Circle(Point p,double radius){
		locat = p;
		this.radius = radius;
	}
	public Circle(int x, int y ,double radius){
		locat = new Point(x, y);
		this.radius = radius;
	}
	/**
	 * �������
	 */
	public double getArea(){
		return  Math.PI*radius*radius;
	}
	/**
	 * �ж�԰�ཻ
	 */
	public boolean isIntersected(Circle another){
		double juLi = another.getLocat().getJuLi(this.locat);
		if(juLi>Math.abs(radius-another.getRadius())&&juLi<another.getRadius()+radius){
			return true;
		}
		return false;
	}
	/**
	 * �жϰ���
	 */
	public boolean contains(Circle another){
		double juLi = another.getLocat().getJuLi(this.locat);
		if(juLi<Math.abs(radius-another.getRadius())){
			return true;
		}
		return false;
	}
	/**
	 * �ж�Բ��С��ϵ
	 */
	public int compareTo(Circle another){
		if(Math.abs(another.getRadius()-radius)<0.0001){
			return 0;
		}
		else{
			if(another.getRadius()-radius>0){
				return -1;
			}
			else{
				return 1;
			}
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String c = "[Circle("+this.locat.getX()+","+this.locat.getY()+")-"+this.radius+"]";
		return c;
	}
	
}
