package Collections;

import java.util.*;

class Content implements Comparable<Content> {
  private String content;

  public Content(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    Content c = (Content) o;
    return this.getContent().toLowerCase().equals(c.getContent().toLowerCase());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.getContent().toLowerCase());
  }

  @Override
  public int compareTo(Content o) {
    if (this.content.length() > o.getContent().length()) return -1;
    else if (this.content.length() < o.getContent().length()) return 1;
    return 0;
  }
}


public class Main {
  public static void main(String[] args) {
    // List
    // ArrayList
    List<String> strList = new ArrayList<>();
    strList.add("test1");
    strList.add("test2");
    strList.add("test3");
    strList.add(1, "test1-1");
    for (String elem : strList) {
      System.out.println(elem);
    }

    strList.remove(0);
    strList.remove(strList.indexOf("test3"));
    Iterator<String> iter1 = strList.iterator();
    while(iter1.hasNext()) {
      System.out.println(iter1.next());
    }

    System.out.println(strList.contains("test3"));
    System.out.println(strList.contains("test1-1"));

    System.out.println("-----------------------------------------------------");
    List<Content> contentList = new ArrayList<>();
    contentList.add(new Content("AA"));
    contentList.add(new Content("AAAA"));
    contentList.add(new Content("A"));
    contentList.add(new Content("AAA"));
    for (Content c : contentList) {
      System.out.println(c.getContent());
    }
    System.out.println();

    Collections.sort(contentList);
    for (Content c : contentList) {
      System.out.println(c.getContent());
    }

    System.out.println("-----------------------------------------------------");

    // LinkedList
    List<String> strLinkedList = new LinkedList<>();
    strLinkedList.add("hi1");
    strLinkedList.add("hi2");
    strLinkedList.add("hi3");
    strLinkedList.add("hi4");
    Iterator iter2 = strLinkedList.iterator();
    while(iter2.hasNext()) {
      System.out.println(iter2.next());
    }
    System.out.println(strLinkedList.contains("hi5"));
    System.out.println(strLinkedList.contains("hi1"));

    strLinkedList.add(1, "hi1-1");
    strLinkedList.remove(2);
    for (String elem : strLinkedList) {
      System.out.println(elem);
    }

    System.out.println("-----------------------------------------------------");

    // Vector
    List<String> strVector = new Vector<>();
    strVector.add("hello1");
    strVector.add("hello2");
    strVector.add("hello3");
    strVector.add("hello4");
    strVector.add("hello5");

    Iterator iter3 = strVector.iterator();
    while(iter3.hasNext()) {
      System.out.println(iter3.next());
    }

    strVector.remove(4);
    System.out.println(strVector.contains("hello5"));
    for (String elem : strVector) {
      System.out.println(elem);
    }

    System.out.println("-----------------------------------------------------");

    // Stack
    Stack<String> strStack = new Stack<>();
    strStack.push("hi1");
    strStack.push("hi2");
    strStack.push("hi3");
    strStack.push("hi4");
    strStack.push("hi5");

    System.out.println(strStack.peek());
    System.out.println(strStack.pop());
    System.out.println(strStack.pop());
    System.out.println(strStack.contains("hi3"));
    System.out.println(strStack.contains("hi4"));

    System.out.println("-----------------------------------------------------");

    // Queue
    Queue<String> strQueue = new LinkedList<>();
    strQueue.offer("t1");
    strQueue.offer("t2");
    strQueue.add("t3");
    strQueue.add("t4");
    strQueue.add("t5");

    System.out.println(strQueue.peek());
    System.out.println(strQueue.poll());
    System.out.println("-----------------------------------------------------");

    // PriorityQueue
    PriorityQueue<Integer> strPriorityQueue = new PriorityQueue<>();
    strPriorityQueue.add(1);
    strPriorityQueue.add(5);
    strPriorityQueue.add(3);
    strPriorityQueue.add(4);
    strPriorityQueue.add(2);

    int strPriorityQueueSize = strPriorityQueue.size();
    for (int i = 0; i < strPriorityQueueSize; i++) {
      System.out.println(strPriorityQueue.poll());
    }

    PriorityQueue<Content> contentPriorityQueue = new PriorityQueue<Content>();
    contentPriorityQueue.offer(new Content("a"));
    contentPriorityQueue.offer(new Content("aaaa"));
    contentPriorityQueue.offer(new Content("aaa"));
    contentPriorityQueue.offer(new Content("aa"));
    contentPriorityQueue.offer(new Content("aaaaa"));

    int contentPriorityQueueSize = contentPriorityQueue.size();
    for (int i = 0; i < contentPriorityQueueSize; i++) {
      System.out.println(contentPriorityQueue.poll().getContent());
    }

    System.out.println("-----------------------------------------------------");

    // Set
    // HashSet
    Set<String> strSet = new HashSet<>();
    strSet.add("Str1");
    strSet.add("Str1");
    strSet.add("Str2");
    strSet.add("Str3");

    for (String elem : strSet) {
      System.out.println(elem);
    }
    System.out.println(strSet.contains("Str1"));
    System.out.println(strSet.contains("Str4"));
    System.out.println("-----------------------------------------------------");

    Set<Content> contentHashSet = new HashSet<>();
    contentHashSet.add(new Content("itsa"));
    contentHashSet.add(new Content("itsA"));

    for (Content content : contentHashSet) {
      System.out.println(content.getContent());
    }

    System.out.println("-----------------------------------------------------");

    // LinkedHashSet
    Set<String> strLinkedHashSet = new LinkedHashSet<>();
    strLinkedHashSet.add("Str1");
    strLinkedHashSet.add("Str1");
    strLinkedHashSet.add("Str3");
    strLinkedHashSet.add("Str2");
    for (String elem : strLinkedHashSet) {
      System.out.println(elem);
    }
    System.out.println("-----------------------------------------------------");

    // Map
    // HashMap
    Map<String, String> strHashMap = new HashMap<>();
    strHashMap.put("a", "it's a");
    strHashMap.put("b", "it's b");
    strHashMap.put("c", "it's c");
    strHashMap.put("d", "it's d");
    strHashMap.put("e", "it's e");

    Set<String> strHashMapKeys = strHashMap.keySet();
    for (String keys : strHashMapKeys) {
      System.out.println(keys);
    }
    for (String keys : strHashMapKeys) {
      System.out.println(strHashMap.get(keys));
    }
    Collection<String> strHashMapValues = strHashMap.values();
    Iterator iter5 = strHashMapValues.iterator();
    System.out.println();
    while(iter5.hasNext()) {
      System.out.println(iter5.next());
    }
    System.out.println();
    for (String value : strHashMapValues) {
      System.out.println(value);
    }

    System.out.println("-----------------------------------------------------");

    Map<Content, String> contentKeyHashMap = new HashMap<>();
    contentKeyHashMap.put(new Content("A"), "a");
    contentKeyHashMap.put(new Content("a"), "a");

    Set<Content> contentKeyHashMapKeys = contentKeyHashMap.keySet();
    for (Content key : contentKeyHashMapKeys) {
      System.out.println(contentKeyHashMap.get(key));
    }
    System.out.println(contentKeyHashMap.containsKey(new Content("A")));


    // HashTable

    // TreeMap
    System.out.println("-----------------------------------------------------");
    SortedMap<Integer, Content> contentTreeMap = new TreeMap<Integer, Content>(Collections.reverseOrder());
    contentTreeMap.put(2, new Content("AA"));
    contentTreeMap.put(4, new Content("AAAA"));
    contentTreeMap.put(1, new Content("A"));
    contentTreeMap.put(5, new Content("AAAAA"));
    contentTreeMap.put(3, new Content("AAA"));

    Set<Integer> contentTreeMapKeys = contentTreeMap.keySet();
    for (Integer key : contentTreeMapKeys) {
      System.out.println(contentTreeMap.get(key).getContent());
    }


    int[] A = {1, 2, 3, 4, 5};
    List<Integer> linkedList = new LinkedList<Integer>();
    Integer[] result = linkedList.toArray(new Integer[linkedList.size()]);


  }
}
