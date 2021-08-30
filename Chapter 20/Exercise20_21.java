/*
Author: 
Date: 

Description: 
*/


public class Exercise20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};
    
    selectionSort(list, new GeometricObjectComparator());
    
	for (GeometricObject g: list) {
			System.out.printf("\n%.2f ", g.getArea());
	}
	System.out.println();
}

    private static void selectionSort(GeometricObject[] list, GeometricObjectComparator geometricObjectComparator) {
	// TODO Auto-generated method stub
	
}

	Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    

  }	
