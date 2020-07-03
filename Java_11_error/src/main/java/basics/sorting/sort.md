Stream<Map.Entry<K,V>> sorted =
    map.entrySet().stream()
       .sorted(Map.Entry.comparingByValue());
This will let you consume the entries sorted in ascending order of value. If you want descending value, simply reverse the comparator:

Stream<Map.Entry<K,V>> sorted =
    map.entrySet().stream()
       .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
If the values are not comparable, you can pass an explicit comparator:

Stream<Map.Entry<K,V>> sorted =
    map.entrySet().stream()
       .sorted(Map.Entry.comparingByValue(comparator));
You can then proceed to use other stream operations to consume the data. For example, if you want the top 10 in a new map:

Map<K,V> topTen =
    map.entrySet().stream()
       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
       .limit(10)
       .collect(Collectors.toMap(
          Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
Or print to System.out:

map.entrySet().stream()
   .sorted(Map.Entry.comparingByValue())
   .forEach(System.out::println);