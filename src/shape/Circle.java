package shape;
/*	 圆		*/

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
	 * 计算面积
	 */
	public double getArea(){
		return  Math.PI*radius*radius;
	}
	/**
	 * 判断园相交
	 */
	public boolean isIntersected(Circle another){
		double juLi = another.getLocat().getJuLi(this.locat);
		if(juLi>Math.abs(radius-another.getRadius())&&juLi<another.getRadius()+radius){
			return true;
		}
		return false;
	}
	/**
	 * 判断包含
	 */
	public boolean contains(Circle another){
		double juLi = another.getLocat().getJuLi(this.locat);
		if(juLi<Math.abs(radius-another.getRadius())){
			return true;
		}
		return false;
	}
	/**
	 * 判断圆大小关系
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
