package duplicate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateCall {

	public static void main(String[] args) {

		String line = "";

		List<String> list = new ArrayList<>();

		// An array of file names that correspond to the required dates. If
		// needed, you can add a number of dates. The only condition: it must
		// coincide with the file name in the string below
		String[] fileNames = { "27_03_2017" };

		for (int i = 0; i < fileNames.length; i++) {

			String file = "C:/trial/" + fileNames[i] + ".csv";

			System.out.println(fileNames[i] + ".csv");

			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				while ((line = br.readLine()) != null) {
					list.add(line);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}

			List<String> shortList = list.stream().map(a -> {

				String[] stringArray = a.split(",");

				return stringArray[2].substring(2, stringArray[2].length() - 2);

			}).collect(Collectors.toList());

			Set<HelperCall> set = new HashSet<>();

			for (String value : shortList) {
				set.add(new HelperCall(value, Collections.frequency(shortList, value)));
			}

			long count = set.stream().filter(a -> a.getQuantity() > 1).count();

			List<HelperCall> finalList = set.stream().filter(a -> a.getQuantity() > 1)
					.sorted(Comparator.comparing(HelperCall::getQuantity)).collect(Collectors.toList());

			for (HelperCall value : finalList)
				System.out.println(value);

			System.out.println("Duplicate calls: " + count);

		}

	}

}
