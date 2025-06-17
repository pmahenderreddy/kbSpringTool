/*
ProviderSubInterface
 -- notifySubscriber

Provider
 + registerSubscriber(Subscriber)
 + getSubscribers
 + broadcastMsgToSubscriber(int)

Subscriber implementes ProviderSubInterface
 * int data
 = notifySubscriber

*/

import java.util.*;

public class ProviderSubscriberApp {
	public static void main(String[] args) {
		Provider p = new Provider();
		
		Subscriber s1 = new Subscriber(1);
		Subscriber s2 = new Subscriber(2);
		Subscriber s3 = new Subscriber(3);
		
		p.registerSubscriber( s1 );
		//p.registerSubscriber( s2 );
		p.registerSubscriber( s3 );
		
		//..
		p.broadcastMsgToSubscriber(10);
		//...
	}
}

interface ProviderSubInterface {
	void notifySubscriber(int data);
}

class Subscriber implements ProviderSubInterface {
	int data;
	int id;
	
	Subscriber(int id) { this.id = id; }
	
	public void notifySubscriber(int data) {
		this.data = data;
		System.out.println(this.id + " got new data: " + data);
	}
}

class Provider {
	List<Subscriber> users = new ArrayList<Subscriber>();
	
	public boolean registerSubscriber(Subscriber sub) {
		users.add(sub);
		return true;
	}
	
	public void broadcastMsgToSubscriber(int data) {
		for( int i = 0; i < this.getSubscribers().size(); i++ ) {
			Subscriber subscriber = this.getSubscribers().get( i );
			subscriber.notifySubscriber( data );
		}
	}
	
	public List<Subscriber> getSubscribers() {
		return users;
	}
}
