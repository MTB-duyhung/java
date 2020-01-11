package assignment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TourMethod {

    private ArrayList<Tour> m = new ArrayList<>();

    public void sort() {
    	Collections.sort(m, new Comparator<Tour>() {

			@Override
			public int compare(Tour o1, Tour o2) {
				int c;
        		c=o1.getTitle().compareTo(o2.getTitle());
        		if (c==0) {
        			c=o1.getPrice()>o2.getPrice()?-1:1;
        		}
        		return c;
			}
    		
    	});
    }
    
    public void add(Tour a) {
        m.add(a);
    }

    public ArrayList<Tour> domesticList() {
        ArrayList<Tour> list = new ArrayList<>();
        for (Tour v : m) {
            if (v instanceof Domestic) {
                list.add(v);
            }
        }
        return list;
    }

    public double avgInternationalCharge() {
        double sum = 0, count = 0;
        for (Tour v : m) {
            if (v instanceof Domestic) {
                sum += v.tourCharge();
                count++;
            }
        }
        return (double) sum / count;
    }

    public Tour searchCode(String code) {
        for (Tour v : m) {
            if (code.equals(v.getCode())) {
                return v;
            }
        }
        return null;
    }

    public ArrayList<Tour> searchTitle(String title) {
        ArrayList<Tour> list = new ArrayList<>();
        for (Tour v : m) {
            if (title.compareTo(v.getTitle()) == 0) {
                list.add(v);
            }
        }
        return list;
    }

    public ArrayList<Tour> searchStartDate(Date start) {
        ArrayList<Tour> list = new ArrayList<>();
        for (Tour v : m) {
            if (start.compareTo(v.getStart()) <= 0) {
                list.add(v);
            }
        }
        return list;
    }

    public ArrayList<Tour> searchTransport(boolean transport) {
        ArrayList<Tour> list = new ArrayList<>();
        for (Tour v : m) {
            if (transport == (v.isTransport())) {
                list.add(v);
            }
        }
        return list;
    }

    public Tour firstMinTour() {
        double min = m.get(1).tourCharge();
        for (Tour v : m) {
            if (v.tourCharge() < min) {
                return v;
            }
        }
        return m.get(1);
    }

    public void removeCode(String code) {

        for (Tour v : m) {
            if (code.equals(v.getCode())) {
                m.remove(v);
                break;
            }
        }
    }

    public void removeStartDate(Date start) {
        for (Tour v : m) {
            if (v.getStart().compareTo(start) > 0) {
                m.remove(v);
            }
        }
    }

    public void updateTour(String id) {
        String uCode = null;
        String uTitle;
        double uPrice = 0;
        boolean uTransport = false;
        Date uStart = null;
        Date uEnd = null;
        Scanner in = new Scanner(System.in);
        for (Tour v : m) {
            if (id.equals(v.getCode())) {
                    System.out.print("Title: ");
                    uTitle = in.next();
                    v.setTitle(uTitle);
                    System.out.print("Price: ");
                    uPrice = in.nextDouble();
                    v.setPrice(uPrice);
                    System.out.print("Transport:aircraft(a)/car(c) ");
                    uTransport = "a".equalsIgnoreCase(in.next());
                    v.setTransport(uTransport);
                    DateFormat df = new SimpleDateFormat("yyyy/m/d");
                    System.out.println("Start Date: ");
                    try {
                        uStart = df.parse(in.next());
                    } catch (ParseException ex) {
                        Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    v.setStart(uStart);
                    System.out.println("End Date: ");
                    try {
                        uEnd = df.parse(in.next());
                    } catch (ParseException ex) {
                        Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    v.setEnd(uEnd);
            }
        }
    }

    public String toString() {
    	String buf = "";
    	for (Tour t : m) {
    		buf += t.toString() + "\n";
    	}
    	return buf;
    }
}
