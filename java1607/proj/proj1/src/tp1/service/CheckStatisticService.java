package tp1.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import tp1.model.dao.impl.jdbc.check.CheckStatisticDAO;
import tp1.model.vo.check.CheckStatistic;

public class CheckStatisticService {
	
	private final CheckStatisticDAO mCSD = new CheckStatisticDAO();

	public List<Integer> getCheckinStatistics() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String end = df.format(now);
		String start = df.format(new Date(now.getTime() - 7 * 24 * 60 * 60 * 1000));
		
		List<CheckStatistic> statistics = mCSD.findAllCheckinStatistic(start, end);
		System.out.println(statistics);
		return buildStatistics(statistics);
	}
	
	public List<String> getLabels() {
		DateFormat df = new SimpleDateFormat("MM-dd");
		Date now = new Date();
		
		List<String> results = new ArrayList<String>();
		for (int i = 6; i >= 0; i--) {
			String date = df.format(new Date(now.getTime() - i * 24 * 60 * 60 * 1000));
			System.out.println(date);
			results.add("\"" + date + "\"");
		}
		return results;
	}

	
	public List<Integer> getCheckoutStatistics() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String end = df.format(now);
		String start = df.format(new Date(now.getTime() - 7 * 24 * 60 * 60 * 1000));
		
		List<CheckStatistic> statistics = mCSD.findAllCheckoutStatistic(start, end);
		System.out.println(statistics);
		return buildStatistics(statistics);
	}

	private List<Integer> buildStatistics(List<CheckStatistic> statistics) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		
		Map<String, Integer> map = buildMap(statistics);
		
		List<Integer> results = new ArrayList<Integer>();
		for (int i = 6; i >= 0; i--) {
			String date = df.format(new Date(now.getTime() - i * 24 * 60 * 60 * 1000));
			System.out.println(date);
			if (map.containsKey(date)) {
				results.add(map.get(date));
			} else {
				results.add(0);
			}
		}
		return results;
	}

	private Map<String, Integer> buildMap(List<CheckStatistic> statistics) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (CheckStatistic stat : statistics) {
			map.put(stat.getDate(), stat.getCount());
		}
		return map;
	}
	
	public static void main(String[] args) {
		CheckStatisticService service = new CheckStatisticService();
		System.out.println(service.getCheckinStatistics());
		System.out.println(service.getLabels());
	}
	
}
