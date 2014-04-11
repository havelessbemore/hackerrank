//https://www.hackerrank.com/challenges/fraud-prevention
import java.io.*;
import java.util.*;

public class Solution {
    private static class Node {
        private String cc;
        private boolean isValid;
        private List<Integer> orderIds;
        public Node(String cc){
            this.cc = cc;
            isValid = true;
            orderIds = new ArrayList<Integer>();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Node> map = new HashMap<String, Node>(N);
        for(int n = 0; n < N; ++n){
            String[] record = br.readLine().split(",");
            //Order ID
            int orderId = Integer.parseInt(record[0]);
            //Deal ID
            int dealId = Integer.parseInt(record[1]);
            //Email
            String email = record[2].toLowerCase();
            email = email.substring(0,email.lastIndexOf('@'))
                .replaceAll("\\.","")
                .replaceFirst("\\+.*", "")
                + email
                .substring(email.lastIndexOf('@'));
            //Address
            String address = record[3]
                .replace("Street", "St.")
                .replace("Road", "Rd.")
                .toLowerCase();
            //City
            String city = record[4].toLowerCase();
            //State
            String state = record[5]
                .toLowerCase()
                .replace("illinois", "il")
                .replace("california", "ca")
                .replace("new york", "ny");
            //Zip Code
            String zipCode = record[6].replaceAll("-","");
            //Credit Card #
            String cc = record[7];
            //First Condition
            String condition = dealId + email;
            Node node = map.get(condition);
            if (node == null){
                map.put(condition, node = new Node(cc));
            } else if (!node.cc.equals(cc)){
                node.isValid = false;
            }
            node.orderIds.add(orderId);
            //Second Condition
            condition = dealId + address + city + state + zipCode;
            node = map.get(condition);
            if (node == null){
                map.put(condition, node = new Node(cc));
            } else if (!node.cc.equals(cc)){
                node.isValid = false;
            }
            node.orderIds.add(orderId);
        }
        Set<Integer> set = new HashSet<Integer>();
        for(Node n: map.values()){
            if (!n.isValid) {
                set.addAll(n.orderIds);
            }
        }
        map = null;
        Integer[] fraudulent = set.toArray(new Integer[N = set.size()]);
        set = null;
        Arrays.sort(fraudulent);
        StringBuffer sb = new StringBuffer();
        for(int n = 0; n < N; ++n){
            sb.append(n+1 == N ? fraudulent[n] : fraudulent[n] + ",");
        }
        fraudulent = null;
        System.out.print(sb);
    }
}