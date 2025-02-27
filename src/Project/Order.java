package Project;

public class Order {
private int orderID;
private double totalPrice;
private BakeryItem[] itemList;
private int itemCounter;


public Order(int id) {
	orderID=id;
	itemList=new BakeryItem[10];
	itemCounter=0;
	totalPrice=0.0;
}

public void addItem(BakeryItem item) {
	if(itemCounter>=itemList.length) {
		System.out.println("we can not add this item only 10 item allowed per order");
	}else {
		if(item instanceof GlazedDonat) {
			GlazedDonat g =(GlazedDonat)item;
			itemList[itemCounter++]=new GlazedDonat(item);
			calculateTotalPrice();
			//totalPrice+=item.getPrice;
			
		}else if(item instanceof Donat) {
			Donat d =(Donat)item;
		itemList[itemCounter++]=new Donat(item);
		calculateTotalPrice();

		//totalPrice+=item.getPrice;

		
		}else if(item instanceof Cake) {
			Cake c = (Cake) item;
			itemList[itemCounter++]=new Cake(item);
			calculateTotalPrice();
			//totalPrice+=item.getPrice;


			
		}
		
	}//end else
	System.out.println("Adding has done ! for "+item.getName() );
	
}//end method


public void removeItem(BakeryItem item) {
	for(int i=0 ; i<itemCounter ; i++) {
		if(itemList[i] !=null && itemAreEqual(itemList[i],item)) {
			removeItemAtIndex(i);
			calculateTotalPrice();
			//totalPrice-=itemList[i].getPrice;
			return;
		}
	}
		System.out.println("sorry, we can not remove this item");
	}


public void removeItemAtIndex (int index) {
	if(index>=0 && index<itemCounter) {
		System.out.println("Removing has done ! for "+itemList[index].getName() );


		for(int i =index; i<itemCounter -1 ; i++ ) 
			itemList[i] =itemList[i+1];
		
		itemList[itemCounter -1]=null;
		itemCounter--;
	}//end if
}//end method

private boolean itemAreEqual(BakeryItem item1, BakeryItem item2) {
	if(item1 ==null || item2==null) return false;
	if(item1.getClass() != item2.getClass())return false;
	
	switch (item1.getClass().getName()) {
	
	case"GlazedDonat":
		GlazedDonat g1 = (GlazedDonat) item1;
		GlazedDonat g2= (GlazedDonat) item2;
		return  g1.getGlazeFlavor().equalsIgnoreCase(g2.getGlazeFlavor()) &&
                g1.isSprinkled() == g2.isSprinkled() &&
                g1.getFillingType().equalsIgnoreCase(g2.getFillingType()) &&
                g1.getTopping().equalsIgnoreCase(g2.getTopping()) &&
                g1.getSize().equalsIgnoreCase(g2.getSize()) &&
                g1.getNumber() == g2.getNumber();
		
	 case "Donut":
         Donut d1 = (Donut) item1;
         Donut d2 = (Donut) item2;
         return d1.getFillingType().equalsIgnoreCase(d2.getFillingType()) &&
                d1.getTopping().equalsIgnoreCase(d2.getTopping()) &&
                d1.getSize().equalsIgnoreCase(d2.getSize()) &&
                d1.getNumber() == d2.getNumber();
         
	  case "Cake":
          Cake c1 = (Cake) item1;
          Cake c2 = (Cake) item2;
          return c1.getFlavor().equalsIgnoreCase(c2.getFlavor()) &&
                 c1.getLayers() == c2.getLayers() &&
                 c1.getWriting().equalsIgnoreCase(c2.getWriting());



	}
}


public void displayOrderDetails() {
    System.out.println("\nOrder Details - Order ID: " + orderID);
    
    if (itemCounter == 0) {
        System.out.println("The order is empty. No items available.");
    } else {
        for (int i = 0; i < itemCounter; i++) {
            System.out.println((i + 1) + ". " + itemList[i].toString());
        }
    }
    
    System.out.println("Total Price: " + totalPrice + " SAR");
}


public void calculateTotalPrice() {
	for(int i=0; i<itemCounter; i++) {
		totalPrice += itemList[i].getPrice();
	}
}

public int getOrderID() {
	return orderID;
}

public BakeryItem[] getItenList() {
	return itemList;
}














































}//end of class Order
