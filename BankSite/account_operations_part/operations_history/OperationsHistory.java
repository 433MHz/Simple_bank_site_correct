package operations_history;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class OperationsHistory {
	private LinkedList<LinkedList> outer = new LinkedList<LinkedList>();
	private LinkedList<String> inner = new LinkedList<String>();
	private int id = 0;
	private boolean alreadyExecuted = false;

	public void putIn(String from, String to, float money, String way) {
		id++;
		if (!alreadyExecuted) {
			inner.add("ID");
			inner.add("FROM");
			inner.add("TO");
			inner.add("MONEY");
			inner.add("DATE");
			inner.add("TIME");
			inner.add("GET/SEND");
			outer.add(inner);
			inner = new LinkedList<String>();
			alreadyExecuted = true;
		}
		inner = new LinkedList<String>();
		inner.add(String.valueOf(id));
		inner.add(from);
		inner.add(to);
		inner.add(String.valueOf(money));
		LocalDate lc = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		inner.add(String.valueOf(lc.format(dtf)));
		LocalTime lt = LocalTime.now();
		dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		inner.add(String.valueOf(lt.format(dtf)));
		inner.add(way);
		outer.add(inner);
	}

	public void putIn(float money) {
		id++;
		if (!alreadyExecuted) {
			inner.add("ID");
			inner.add("FROM");
			inner.add("TO");
			inner.add("MONEY");
			inner.add("DATE");
			inner.add("TIME");
			inner.add("GET/SEND");
			outer.add(inner);
			inner = new LinkedList<String>();
			alreadyExecuted = true;
		}
		inner = new LinkedList<String>();
		inner.add(String.valueOf(id));
		inner.add("ADDED");
		inner.add("ADDED");
		inner.add(String.valueOf(money));
		LocalDate lc = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		inner.add(String.valueOf(lc.format(dtf)));
		LocalTime lt = LocalTime.now();
		dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		inner.add(String.valueOf(lt.format(dtf)));
		inner.add("ADDED");
		outer.add(inner);
	}

	public LinkedList<LinkedList> get() {
		return outer;
	}
}
